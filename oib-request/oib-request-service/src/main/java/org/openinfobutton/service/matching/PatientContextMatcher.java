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
