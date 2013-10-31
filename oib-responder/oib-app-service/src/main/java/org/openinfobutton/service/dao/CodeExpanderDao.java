package org.openinfobutton.service.dao;

import java.util.Set;
import org.openinfobutton.app.model.Code;

/**
 *
 * @author rick
 */
public interface CodeExpanderDao {
    
    public static final String RXNORM_CODE_SYSTEM_OID = "2.16.840.1.113883.6.88";
    public static final String SNOMED_CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";
    public static final String ICD9_CODE_SYSTEM_OID = "2.16.840.1.113883.6.103";    

    public Set<Code> getExpansionCodes(String codeSystem, String code);
    
    public Set<Code> getExpansionRxNormCodes( String code );
    
    public Set<Code> getExpansionIcd9Codes( String code );

    public Set<Code> getExpansionSnomedCodes( String code );

}
