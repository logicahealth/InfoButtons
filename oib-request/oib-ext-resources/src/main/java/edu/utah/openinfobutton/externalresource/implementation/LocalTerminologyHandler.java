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
package edu.utah.openinfobutton.externalresource.implementation;

import java.util.List;

import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.schemas.kb.TerminologyInference.CodeInference.InferenceDefinition.LocalMappings.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.utah.further.subsetdb.domain.Concept;
import edu.utah.further.subsetdb.domain.Subset;
import edu.utah.further.subsetdb.service.SubsetDbDao;
import edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler;
import edu.utah.openinfobutton.externalresource.api.TerminologyHandler;

@Component
public class LocalTerminologyHandler implements TerminologyHandler {

	@Autowired
	private SubsetDbDao dao;
	@Autowired
	ExternalResourceHandler handler;
	@Autowired
	TerminologyMappings terminologyMappings;
	List<Mapping> validMappings;
	public Boolean isSubsetMember(Code code,List<Id> subsetIdList) {
		
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
//		This is no longer necessary as all of the values sets are present in the UofU local OIB.
//		If required, your own implementation can be given.
//		if(!match)
//		{
//			match = handler.matchCodeSet(subsetIdList, code);
//		}		
		return match;
	}

	public Code transformCode(Code code, String codeSystem) {
		// TODO Auto-generated method stub
		validMappings=terminologyMappings.getValidMappings();
		for(int i=0;i<validMappings.size();i++)
		{
			Mapping m=validMappings.get(i);
			if((m.getSourceValue().equals(code.getCodeSystem()))&&(m.getTargetValue().equals(codeSystem)))
			{
				Code transformedCode = handler.transformCode(code,m.getTargetName());
				if(transformedCode!=null)
				{
					transformedCode.setCodeSystem(m.getTargetValue());
					return transformedCode;
				}
			}
		}
		return null;
	}

	public boolean isDescendant(Code code1, Code code2) {
		return handler.isDescendant(code1,code2);
	}
}
