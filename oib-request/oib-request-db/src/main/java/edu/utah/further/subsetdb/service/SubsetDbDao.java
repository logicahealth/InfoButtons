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
package edu.utah.further.subsetdb.service;

import edu.utah.further.core.api.context.Api;
import edu.utah.further.subsetdb.domain.Concept;
import edu.utah.further.subsetdb.domain.Subset;

@Api
public interface SubsetDbDao {
	
	public Boolean isConceptInSubset (Long conceptid, Long subsetid); 
	
	public Concept getConceptByCodeAndCodeSystem(String code, String codesystem);
	
	public Subset getSubsetByName (String subsetName);
	
}
