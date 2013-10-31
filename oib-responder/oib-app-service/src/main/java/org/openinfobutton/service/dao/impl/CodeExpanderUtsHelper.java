package org.openinfobutton.service.dao.impl;

import gov.nih.nlm.uts.webservice.content.AtomClusterRelationDTO;
import gov.nih.nlm.uts.webservice.content.Psf;
import gov.nih.nlm.uts.webservice.content.SourceAtomClusterDTO;
import gov.nih.nlm.uts.webservice.content.UtsFault_Exception;
import gov.nih.nlm.uts.webservice.content.UtsWsContentController;
import gov.nih.nlm.uts.webservice.content.UtsWsContentControllerImplService;
import gov.nih.nlm.uts.webservice.security.UtsWsSecurityController;
import gov.nih.nlm.uts.webservice.security.UtsWsSecurityControllerImplService;
import java.util.ArrayList;
import java.util.List;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.service.dao.CodeExpanderDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rick
 */
public class CodeExpanderUtsHelper {

    @Autowired
    private Properties utsProperties;
    
    private Set<Code> expansionCodes;

    public CodeExpanderUtsHelper() {
    }
    
    public CodeExpanderUtsHelper( Properties properties ) {
        utsProperties = properties;        
    }

    public Set<Code> getExpansionCodes(String codeSystem, String code) {

        expansionCodes = new HashSet<Code>();

        if ( CodeExpanderDao.SNOMED_CODE_SYSTEM_OID.equals(codeSystem)) {
            getSnomedChildren(1, code);
        } else if ( CodeExpanderDao.ICD9_CODE_SYSTEM_OID.equals(codeSystem)) {
            getIcd9Children(1, code);
        } else {
            throw new UnsupportedOperationException("Code system " + codeSystem + " is not supported by the current UTS implementation."); //To change body of generated methods, choose Tools | Templates.
        }

        return expansionCodes;
    }

    private void getIcd9Children(int level, String code) {

        UtsWsContentController utsContentService = (new UtsWsContentControllerImplService()).getUtsWsContentControllerImplPort();

        List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
        Psf myPsf = new Psf();
        myPsf.getIncludedRelationLabels().add("PAR");

        try {
            myAtomClusterRelations =
                    utsContentService.getSourceDescriptorSourceDescriptorRelations(getSecurityTicket(), utsProperties.getProperty("umlsRelease"), code, "ICD9CM", myPsf);
        } catch (UtsFault_Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < myAtomClusterRelations.size(); i++) {

            AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get(i);
            String cuiCode = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
            String cuiPreferredName = myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();
            
            Code code_ = new Code();
            code_.setCode( cuiCode );
            code_.setDisplayName( cuiPreferredName );
            code_.setCodeSystemOid( CodeExpanderDao.ICD9_CODE_SYSTEM_OID );
            code_.setCodeSystemDisplayName("ICD-9 CM");
            
            expansionCodes.add(code_);
            getIcd9Children(level + 1, cuiCode );

        }

    }

    private void getSnomedChildren(int level, String code) {

        UtsWsContentController utsContentService = (new UtsWsContentControllerImplService()).getUtsWsContentControllerImplPort();
        SourceAtomClusterDTO conceptAtomCluster = null;
        List<AtomClusterRelationDTO> myRelations = null;
        Psf myPsf = new Psf();
        myPsf.getIncludedRelationLabels().add("PAR");

        try {

            conceptAtomCluster = utsContentService.getCode(getSecurityTicket(), utsProperties.getProperty("umlsRelease"), code, "SNOMEDCT");

            myRelations =
                    utsContentService.getSourceConceptSourceConceptRelations(getSecurityTicket(), utsProperties.getProperty("umlsRelease"), code, "SNOMEDCT", myPsf);

        } catch (UtsFault_Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < myRelations.size(); i++) {

            AtomClusterRelationDTO myRelation = myRelations.get(i);
            String cuiCode = myRelation.getRelatedAtomCluster().getUi();
            String cuiPreferredName = myRelation.getRelatedAtomCluster().getDefaultPreferredName();
            
            Code code_ = new Code();
            code_.setCode( cuiCode );
            code_.setDisplayName( cuiPreferredName );
            code_.setCodeSystemOid( CodeExpanderDao.SNOMED_CODE_SYSTEM_OID );
            code_.setCodeSystemDisplayName("SNOMED CT");
            
            expansionCodes.add(code_);
            getSnomedChildren(level + 1, cuiCode );
        }

    }

    private String getSecurityTicket() {

        String singleUseTicket = null;
        UtsWsSecurityController securityService = (new UtsWsSecurityControllerImplService()).getUtsWsSecurityControllerImplPort();

        try {
            String ticketGrantingTicket = securityService.getProxyGrantTicket(utsProperties.getProperty("username"), utsProperties.getProperty("password"));
            singleUseTicket = securityService.getProxyTicket(ticketGrantingTicket, utsProperties.getProperty("serviceName"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return singleUseTicket;
    }
}