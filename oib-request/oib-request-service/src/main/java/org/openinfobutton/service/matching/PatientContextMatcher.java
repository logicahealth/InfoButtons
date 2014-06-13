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
import org.openinfobutton.schema.Patient;
import org.openinfobutton.schema.PatientContext;
import org.openinfobutton.schemas.kb.CodedContextElement;


public class PatientContextMatcher extends ContextMatcher {

	public PatientContext patientContext;
	public CodedContextElement patientGender;
	public CodedContextElement patientAge;
	KnowledgeRequest request;
	List<String> supportedCodeSystems;
	
	public PatientContextMatcher(CodedContextElement patientGender, 
			CodedContextElement patientAge,	KnowledgeRequest request,List<String> supportedCodeSystems) {
		
		this.patientContext = request.getPatientContext();
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.request = request;
		this.supportedCodeSystems = supportedCodeSystems;
	}


	@Override
	public Boolean MatchContext() {
		Patient patient = patientContext.getPatient();
		if (!CodeMatch(patient.getGender(), patientGender, supportedCodeSystems,false, request)) {
			return false;
		}
		if (!CodeMatch(patient.getAgeGroup(), patientAge, supportedCodeSystems,false, request)) {
			return false;
		}
		return true;
	}
}
