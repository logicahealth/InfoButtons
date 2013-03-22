package edu.duke.mc.cfm.dci.infobutton;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CDset;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;
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
