package edu.duke.mc.cfm.dci.infobutton;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;
import edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler;


public class MainSearchCriteriaMatcher extends ContextMatcher{

	public MainSearchCriteria mainSearch;
	Logger log = Logger.getLogger(MainSearchCriteriaMatcher.class.getName());
	public CodedContextElement context;
	@Autowired
	ExternalResourceHandler handler;
	KnowledgeRequest request;
	List<String> supportedCodeSystems;
	public MainSearchCriteriaMatcher (CodedContextElement context,KnowledgeRequest request, List<String> supportedCodeSystems) {
		
		this.mainSearch = request.getMainSearchCriteria();
		this.context = context;
		this.request = request;
		this.supportedCodeSystems = supportedCodeSystems;
	}

	@Override
	public Boolean MatchContext() {
		Boolean match = false;
		Code code = mainSearch.getCode();
		log.debug("Matching MainSearchCriteria...");
		if(code.getCode().equals("")&&request.getSearchCodes().size()==0)
		{
			log.info("Starting Free Text Transformation for code: "+code.getDisplayName());
			request.setSearchCodes(handler.transformFreeText(code.getDisplayName()));
			log.debug("Free Text Transformation Complete: "+request.getSearchCodes());
			if(request.getSearchCodes().size()>0)
				code=request.searchCodes.get(0);//this is to ensure the free text is also matched with a valid code
		}
		match = CodeMatch(code, context, supportedCodeSystems,true, request);
		log.debug("Match MainSearchCriteria RESULT = "+ match);
		return match;
	}
}
