/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah<br>
 * Contact: {@code <andrew.iskander@utah.edu>}<br>
 * Biomedical Informatics<br>
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version May 5, 2014
 */
package edu.utah.openinfobutton.externalresource.api;

import java.util.ArrayList;
import java.util.List;

import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.Id;



/**
 * This interface describes the methods required for Terminology Inference Operations
 * UTS/Apelon/MetaMap specific implementations can be given.
 * 
 * @author Aditya Kalluri
 *
 *@version 1.0
 */
public interface ExternalResourceHandler {
	/**
	 * Translates a code in one code system to an equivalent code in another code system. 
	 * @param code Code to be transformed
	 * @param targetCS Target Code System
	 * @return Code(Transformed Code) Returns a valid code if successful or null on failure
	 */
	public Code transformCode(Code code,String targetCS);

	/*
	 *boolean matchCodeSet(List<Id> subsetIdList, Code code); 
	 */
	
	/**
	 *  Retrieves a set of candidate codes from a set of code systems that approximately match a given term.
	 *  The search can be restricted to a subTree in a terminology (e.g., clinical findings in SNOMED-CT).
	 *  For now, the UTS implementation searches only in SNOMEDCT,ICD10CM and ICD9CM code systems
	 * @param FreeText The Free Text term to be searched
	 * @return List of Codes in the 3 code systems(if found) or an empty List on failure
	 */
	ArrayList<Code> transformFreeText(String FreeText);

	/**
	 * Checks if a code (code1) is a descendant of another code (code2). 
	 * @param code1 descendant
	 * @param code2 parent
	 * @return Boolean
	 */
	boolean isDescendant(Code code1,Code code2);

}
