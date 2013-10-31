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
