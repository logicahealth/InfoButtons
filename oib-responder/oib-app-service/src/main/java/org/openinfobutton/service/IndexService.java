/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Jul 15, 2014
 */
package org.openinfobutton.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.app.model.ValueSetCode;

// TODO: Auto-generated Javadoc
/**
 * The Interface IndexService.
 *
 * @author rick
 */
public interface IndexService
{

    /** The Constant GENERATED_BY_ONTOLOGY_RELATIONSHIP. */
    public static final String GENERATED_BY_ONTOLOGY_RELATIONSHIP = "GENERATED_BY_ONTOLOGY_RELATIONSHIP";

    /** The Constant RXNORM_CODE_SYSTEM_OID. */
    public static final String RXNORM_CODE_SYSTEM_OID = "2.16.840.1.113883.6.88";

    /** The Constant SNOMED_CODE_SYSTEM_OID. */
    public static final String SNOMED_CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";

    /** The Constant ICD9_CODE_SYSTEM_OID. */
    public static final String ICD9_CODE_SYSTEM_OID = "2.16.840.1.113883.6.103";

    // B-logic for indexing
    /**
     * Gets the expansion codes.
     *
     * @param codeSystem the code system
     * @param code the code
     * @return the expansion codes
     */
    Set<Code> getExpansionCodes( String codeSystem, String code );

    /**
     * Gets the supported code expansion code systems.
     *
     * @return the supported code expansion code systems
     */
    public List<ValueSetCode> getSupportedCodeExpansionCodeSystems();

    /**
     * Refresh asset index.
     *
     * @param assetId the asset id
     * @return the int
     */
    public int refreshAssetIndex( BigDecimal assetId );

    /**
     * Refresh asset index.
     *
     * @param assetId the asset id
     * @param codeSystem the code system
     * @return the int
     */
    public int refreshAssetIndex( BigDecimal assetId, String codeSystem );

    /**
     * Refresh all asset indexes.
     *
     * @return the int
     */
    public int refreshAllAssetIndexes();

    /**
     * Refresh all asset indexes.
     *
     * @param codeSystem the code system
     * @return the int
     */
    public int refreshAllAssetIndexes( String codeSystem );

}
