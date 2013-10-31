package edu.utah.openinfobutton.externalresource.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.duke.mc.cfm.dci.infobutton.Code;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;
import edu.utah.further.subsetdb.domain.Concept;
import edu.utah.further.subsetdb.domain.Subset;
import edu.utah.further.subsetdb.service.SubsetDbDao;
import edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler;
import edu.utah.openinfobutton.externalresource.api.ExternalSetHandler;

@Configurable(dependencyCheck = true)
public class MatchExternalSet implements ExternalSetHandler {

	@Autowired
	@Qualifier("subsetDbDao")
	private SubsetDbDao dao;
	
	public Boolean matchExternalSet(Code code,List<Id> subsetIdList) {
		
		Boolean match = false;
		Concept concept = dao.getConceptByCodeAndCodeSystem(code.getCode(), code.getCodeSystem());
		for(Id subsetId : subsetIdList)
		{
			Subset subset = dao.getSubsetByName(subsetId.getId());
			if (concept != null && subset != null) {
				match = dao.isConceptInSubset(concept.getId(), subset.getId());
			}
			if(match)
				break;
		}
		if(!match)
		{
			ExternalResourceHandler handler = new ApelonDTSHandler();
			match = handler.matchCodeSet(subsetIdList, code);
		}		
		return match;
	}
}
