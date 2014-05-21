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

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.Performer;
import org.openinfobutton.schemas.kb.CodedContextElement;



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
