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
package org.openinfobutton.service.matching;

import java.util.List;

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.TaskContext;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;



public class TaskContextMatcher extends ContextMatcher{

	public TaskContext taskContext;
	public CodedContextElement context;
	KnowledgeRequest request;
	List<String> supportedCodeSystems;
	
	public TaskContextMatcher(CodedContextElement context,
			KnowledgeRequest request, List<String> supportedCodeSystems) {
		this.context = context;
		this.taskContext = request.getTaskContext();
		this.supportedCodeSystems = supportedCodeSystems;
	}

	@Override
	public Boolean MatchContext() {
		Boolean match = false;
		Code code = taskContext.getCode();
		match = CodeMatch(code,context,supportedCodeSystems,false,request);
		return match;
	}
}
