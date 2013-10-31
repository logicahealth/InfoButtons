package org.openinfobutton.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.app.model.ValueSetCode;

/**
 *
 * @author rick
 */
public interface IndexService {
    
    public static final String GENERATED_BY_ONTOLOGY_RELATIONSHIP = "GENERATED_BY_ONTOLOGY_RELATIONSHIP";
    public static final String RXNORM_CODE_SYSTEM_OID = "2.16.840.1.113883.6.88";
    public static final String SNOMED_CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";
    public static final String ICD9_CODE_SYSTEM_OID = "2.16.840.1.113883.6.103";    
        
    // B-logic for indexing
    Set<Code> getExpansionCodes( String codeSystem, String code );
    
    public List<ValueSetCode> getSupportedCodeExpansionCodeSystems();
    
    public int refreshAssetIndex( BigDecimal assetId );
    
    public int refreshAssetIndex( BigDecimal assetId, String codeSystem );

    public int refreshAllAssetIndexes();
    
    public int refreshAllAssetIndexes( String codeSystem );
    
}
