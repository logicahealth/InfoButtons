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
 * @version Jun 13, 2014
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
