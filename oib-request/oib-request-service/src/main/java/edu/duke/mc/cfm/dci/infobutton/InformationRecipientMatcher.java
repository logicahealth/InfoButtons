package edu.duke.mc.cfm.dci.infobutton;

import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;


public class InformationRecipientMatcher extends ContextMatcher {

	public InformationRecipient informationRecipient;
	public CodedContextElement informationRecipientLanguage;
	public CodedContextElement informationRecipientDiscipline;
	public CodedContextElement informationRecipientKnowledgeUserType;
	List<String> supportedCodeSystems;
	KnowledgeRequest request;
	
	public InformationRecipientMatcher (CodedContextElement informationRecipientLanguage, CodedContextElement informationRecipientDiscipline,
			CodedContextElement informationRecipientKnowledgeUserType, KnowledgeRequest request,List<String> supportedCodeSystems) {
		
		this.informationRecipientLanguage = informationRecipientLanguage;
		this.informationRecipientDiscipline = informationRecipientDiscipline;
		this.informationRecipientKnowledgeUserType = informationRecipientKnowledgeUserType;
		this.informationRecipient = request.getInformationRecipient();
		this.request= request;
		this.supportedCodeSystems=supportedCodeSystems;
	}
	
	@Override
	public Boolean MatchContext() {
		if (!CodeMatch(informationRecipient.getProviderOrPatient(), informationRecipientKnowledgeUserType, supportedCodeSystems,false, request)) {
			return false;
		}
		if (!CodeMatch(informationRecipient.getLanguage(), informationRecipientLanguage, supportedCodeSystems,false, request)) {
			return false;
		}
		if (!CodeMatch(informationRecipient.getHealthCareProvider(), informationRecipientDiscipline, supportedCodeSystems,false, request)) {
			return false;
		}
		return true; 
	}

}
