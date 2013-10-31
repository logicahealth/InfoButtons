package edu.utah.openinfobutton.externalresource.api;

import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;

/**
 * This is an interface that operates on the local DB instance
 * to do value set matching
 *  
 * @author Aditya Kalluri
 *
 *@version 1.0
 */

public interface TerminologyHandler {
	/**
	 * Checks whether a code is a member of a value set. 
	 * @param code The code to be checked
	 * @param subsetIdList A List of <Id> which contains the subsets
	 * @return true or false
	 */
	Boolean isSubsetMember(Code code,List<Id> subsetIdList);

	/**
	 * This function checks if the transformation of a code to another code system is possible.
	 * The valid mappings are read from a csv file.
	 * If the mapping is valid then the actual transformCode method from ExternalResourceHandler is called
	 * @param code The code to be transformed
	 * @param codeSystem The target CodeSystem
	 * @return Code(Transformed Code)
	 */
	Code transformCode(Code code,String codeSystem);
	
	
}
