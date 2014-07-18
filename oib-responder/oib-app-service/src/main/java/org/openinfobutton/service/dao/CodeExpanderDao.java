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
package org.openinfobutton.service.dao;

import java.util.Set;
import org.openinfobutton.app.model.Code;

// TODO: Auto-generated Javadoc
/**
 * The Interface CodeExpanderDao.
 *
 * @author rick
 */
public interface CodeExpanderDao
{

    /** The Constant RXNORM_CODE_SYSTEM_OID. */
    public static final String RXNORM_CODE_SYSTEM_OID = "2.16.840.1.113883.6.88";

    /** The Constant SNOMED_CODE_SYSTEM_OID. */
    public static final String SNOMED_CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";

    /** The Constant ICD9_CODE_SYSTEM_OID. */
    public static final String ICD9_CODE_SYSTEM_OID = "2.16.840.1.113883.6.103";

    /**
     * Gets the expansion codes.
     *
     * @param codeSystem the code system
     * @param code the code
     * @return the expansion codes
     */
    public Set<Code> getExpansionCodes( String codeSystem, String code );

    /**
     * Gets the expansion rx norm codes.
     *
     * @param code the code
     * @return the expansion rx norm codes
     */
    public Set<Code> getExpansionRxNormCodes( String code );

    /**
     * Gets the expansion icd9 codes.
     *
     * @param code the code
     * @return the expansion icd9 codes
     */
    public Set<Code> getExpansionIcd9Codes( String code );

    /**
     * Gets the expansion snomed codes.
     *
     * @param code the code
     * @return the expansion snomed codes
     */
    public Set<Code> getExpansionSnomedCodes( String code );

}
