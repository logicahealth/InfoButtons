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

import org.openinfobutton.schema.InformationRecipient;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.CodedContextElement;



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
