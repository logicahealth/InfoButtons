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
