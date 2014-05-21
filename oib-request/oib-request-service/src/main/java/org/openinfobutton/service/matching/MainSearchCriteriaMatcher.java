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

import java.util.List;

import org.apache.log4j.Logger;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.MainSearchCriteria;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.springframework.beans.factory.annotation.Autowired;

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
