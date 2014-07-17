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
package edu.utah.openinfobutton.externalresource.api;

import java.util.List;

import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.Id;

// TODO: Auto-generated Javadoc
/**
 * This is an interface that operates on the local DB instance to do value set matching.
 * 
 * @author Aditya Kalluri
 * @version 1.0
 */

public interface TerminologyHandler
{
    /**
     * Checks whether a code is a member of a value set.
     * 
     * @param code The code to be checked
     * @param subsetIdList A List of <Id> which contains the subsets
     * @return true or false
     */
    Boolean isSubsetMember( Code code, List<Id> subsetIdList );

    /**
     * This function checks if the transformation of a code to another code system is possible. The valid mappings are
     * read from a csv file. If the mapping is valid then the actual transformCode method from ExternalResourceHandler
     * is called
     * 
     * @param code The code to be transformed
     * @param codeSystem The target CodeSystem
     * @return Code(Transformed Code)
     */
    Code transformCode( Code code, String codeSystem );

}
