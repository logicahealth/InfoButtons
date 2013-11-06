package org.openinfobutton.service.dao.impl;

import gov.nih.nlm.rxnav.rest.model.AllRelatedGroup;
import gov.nih.nlm.rxnav.rest.model.ConceptGroup;
import gov.nih.nlm.rxnav.rest.model.ConceptProperties;
import gov.nih.nlm.rxnav.rest.model.Name;
import gov.nih.nlm.rxnav.rest.model.Rxcui;
import gov.nih.nlm.rxnav.rest.model.Rxnormdata;
import gov.nih.nlm.rxnav.rest.model.Tty;
import java.util.HashMap; 
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.service.dao.CodeExpanderDao;
import static org.openinfobutton.service.dao.CodeExpanderDao.RXNORM_CODE_SYSTEM_OID;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rick
 */
@Repository
public class CodeExpanderDaoImpl implements CodeExpanderDao {
        
    private Properties utsProperties;

    private Set<String> rxNormExpansionTermTypes;

    public CodeExpanderDaoImpl() {
    }
    
    public CodeExpanderDaoImpl( Properties utsProperties ) {
        this.utsProperties = utsProperties;
    }

    public void setUtsProperties(Properties utsProperties) {
        this.utsProperties = utsProperties;
    }

    public void setRxNormExpansionTermTypes(Set<String> rxNormExpansionTermTypes) {
        this.rxNormExpansionTermTypes = rxNormExpansionTermTypes;
    }

    private void setDefaultRxNormTermTypes() {
        rxNormExpansionTermTypes = new HashSet();
        rxNormExpansionTermTypes.add("CDFG");
        rxNormExpansionTermTypes.add("CDC");
        rxNormExpansionTermTypes.add("IN");
        rxNormExpansionTermTypes.add("PIN");
        rxNormExpansionTermTypes.add("BN");
        rxNormExpansionTermTypes.add("BDC");
        rxNormExpansionTermTypes.add("BDP");
        rxNormExpansionTermTypes.add("BDFG");
    }
        
    @Override
    public Set<Code> getExpansionCodes(String codeSystem, String code) {
        
        Code code_ = new Code();
        code_.setCode(code);
        code_.setCodeSystemOid(codeSystem);

        if ( RXNORM_CODE_SYSTEM_OID.equals( codeSystem ) ) {
            return getExpansionRxNormCodes(code);
        }
        else if ( SNOMED_CODE_SYSTEM_OID.equals( codeSystem ) ) {
            return getExpansionSnomedCodes(code);
        }
        else if ( ICD9_CODE_SYSTEM_OID.equals( codeSystem ) ) {
            return getExpansionIcd9Codes(code);
        }
        else {
            throw new UnsupportedOperationException("Code system " + codeSystem + " not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    @Override
    public Set<Code> getExpansionRxNormCodes( String code ) {
        
        if ( rxNormExpansionTermTypes == null ) {
            setDefaultRxNormTermTypes();
        }

        Set<Code> rxNormExpansionCuis = new HashSet<Code>();
        
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("rxcui", code);
                
        RestTemplate restTemplate = new RestTemplate();
        Rxnormdata rxNormResponse = restTemplate.getForObject("http://rxnav.nlm.nih.gov/REST/rxcui/{rxcui}/allrelated", Rxnormdata.class, vars );
        AllRelatedGroup allRelatedGroup = rxNormResponse.getAllRelatedGroup();
                
        for ( ConceptGroup conceptGroup:allRelatedGroup.getConceptGroup() ) {
            
            Tty termType = conceptGroup.getTty();
            
            if ( rxNormExpansionTermTypes.contains( termType.getContent() ) ) {
                
                for ( ConceptProperties conceptProperties:conceptGroup.getConceptProperties() ) {
                    Rxcui rxcui = conceptProperties.getRxcui();
                    Name name = conceptProperties.getName();
                    if ( rxcui != null ) {
                        String rxcuiCode = rxcui.getContent();
                        if ( rxcuiCode != null ) {
                            Code code_ = new Code();
                            code_.setCode( rxcui.getContent() );
                            code_.setDisplayName( name.getContent() );
                            code_.setCodeSystemOid( RXNORM_CODE_SYSTEM_OID );
                            code_.setDisplayName("RxNorm");
                            rxNormExpansionCuis.add( code_ );
                        }
                    }
                }
            }
        }
        
        return rxNormExpansionCuis;
    }

    public Set<Code> getExpansionIcd9Codes(String code) {

        CodeExpanderUtsHelper codeExpanderUtsHelper = new CodeExpanderUtsHelper( utsProperties );
        Set<Code> codes = codeExpanderUtsHelper.getExpansionCodes( CodeExpanderDao.ICD9_CODE_SYSTEM_OID, code);
        
        return codes;
    }

    public Set<Code> getExpansionSnomedCodes(String code) {

        CodeExpanderUtsHelper codeExpanderUtsHelper = new CodeExpanderUtsHelper( utsProperties );
        Set<Code> codes = codeExpanderUtsHelper.getExpansionCodes( CodeExpanderDao.SNOMED_CODE_SYSTEM_OID, code);
        
        return codes;        
    
    }
    
}
