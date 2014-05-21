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

import org.openinfobutton.schema.Encounter;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.openinfobutton.schemas.kb.Id;



public class EncounterMatcher extends ContextMatcher {

	public Encounter encounter;
	public CodedContextElement encounterType;
    public List<Id> serviceDeliveryLocation;
    KnowledgeRequest request;
    List<String> supportedCodeSystems;
	
	public EncounterMatcher(CodedContextElement encounterType, List<Id> serviceDeliveryLocation, 
			KnowledgeRequest request,List<String> supportedCodeSystems) {
		
		this.encounter = request.getEncounter();
		this.encounterType = encounterType;
		this.serviceDeliveryLocation = serviceDeliveryLocation;
		this.request= request;
		this.supportedCodeSystems = supportedCodeSystems;
	}
	

	@Override
	public Boolean MatchContext() {
		if (!CodeMatch(encounter.getCode(), encounterType, supportedCodeSystems,false, request)) {
			return false;
		}
		return true;
	}

}
