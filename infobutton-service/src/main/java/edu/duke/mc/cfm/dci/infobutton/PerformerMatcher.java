package edu.duke.mc.cfm.dci.infobutton;

import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;

/*
$Rev:: 1252          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2010-10-26 1#$:  Date of last commit
*/

public class PerformerMatcher extends ContextMatcher {

	public Performer performer;
	public CodedContextElement performerLanguage;
	public CodedContextElement performerDiscipline;
	public CodedContextElement performerKnowledgeUserType;
	List<String> supportedCodeSystems;
	KnowledgeRequest request;
	
	public PerformerMatcher (CodedContextElement performerLanguage, CodedContextElement performerDiscipline,
			CodedContextElement performerKnowledgeUserType,KnowledgeRequest request, List<String> supportedCodeSystems) {
		
		this.performerLanguage = performerLanguage;
		this.performerDiscipline = performerDiscipline;
		this.performerKnowledgeUserType = performerKnowledgeUserType;
		this.performer = request.getPerformer();
		this.supportedCodeSystems = supportedCodeSystems;
		this.request = request;
	}
	
	
	@Override
	public Boolean MatchContext() {
		if (!CodeMatch(performer.getProviderOrPatient(), performerKnowledgeUserType, supportedCodeSystems,false, request)) {
			return false;
		}
		if (!CodeMatch(performer.getLanguage(), performerLanguage, supportedCodeSystems,false, request)) {
			return false;
		}
		if (!CodeMatch(performer.getHealthCareProvider(), performerDiscipline, supportedCodeSystems,false, request)) {
			return false;
		}
		return true; 
	}
}
