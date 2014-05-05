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
package org.openinfobutton.service.matching;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.CDset;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.service.transform.TransformCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler;
import edu.utah.openinfobutton.externalresource.api.TerminologyHandler;

@Configurable(preConstruction = true)
public abstract class ContextMatcher {
	
	public abstract Boolean MatchContext();
	
	Logger log = Logger.getLogger(ContextMatcher.class.getName());
	@Autowired
	@Qualifier("externalSet")
	private TerminologyHandler ESHandler;
	@Autowired
	ExternalResourceHandler handler;
	@Autowired
	TransformCode tc;
	protected Boolean CodeMatch(Code c, CodedContextElement context,
			List<String> supportedCodeSystems,boolean runTerminologyInference, KnowledgeRequest request) {
		
		Code code = c;
		Boolean match = false;
		if (context != null && context.isMatch()) 
		{
			if(runTerminologyInference)
				code = tc.transformInput(context,code,supportedCodeSystems,request);
			List<Code> codes;
			if (context.getMatchingDomain().getEnumeration() != null) 
			{
				codes = getCodeListFromContext(context);
				for (Code contextCode : codes) 
				{
					if (code.getCodeSystem().equals(contextCode.getCodeSystem())) 
					{
						if (code.getCode().equals(contextCode.getCode())) 
						{
							match = true;
							break;
						}
					}
				}
				if(context.getMatchingDomain().getEnumeration().isIncludeDescendants()&&!match)
				{
					for (Code contextCode : codes) 
					{
						if(handler.isDescendant(code,contextCode))
						{
							match=true;
							log.debug(code.getCode()+" is a Descendant of "+contextCode.getCode());
							break;
						}
					}
				}
			} 
			else 
			{
				List<Id> subsetIdList=context.getMatchingDomain().getExternalValueSet();
				match = ESHandler.isSubsetMember(code,subsetIdList);
			}
		} else {
			match = true;
		}
		return match;
	}
	
	private List<Code> getCodeListFromContext(CodedContextElement context) {
		
		List<Code> codes = new ArrayList<Code>();
		CDset codeset = context.getMatchingDomain().getEnumeration();
		codes = codeset.getCode();
		return codes;
	}
}
