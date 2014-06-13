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
package org.openinfobutton.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.REDSMT010001UVHealthCareProvider;
import org.hl7.v3.REDSMT010001UVLanguageCommunication;
import org.hl7.v3.REDSMT010001UVPatient;
import org.hl7.v3.REDSMT010001UVPerformer;
import org.hl7.v3.REDSMT010001UVPerson;
import org.openinfobutton.schemas.kb.Code;


/*
$Rev:: 1097          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2010-10-01 1#$:  Date of last commit
*/

public class Performer {

	private Code language;
	
	private Code healthCareProvider;
	
	private Code providerOrPatient;

	public Performer(Code language, Code healthCareProvider, Code providerOrPatient) {
		
		this.language = language;
		this.healthCareProvider = healthCareProvider;
		this.providerOrPatient = providerOrPatient;
	}
	
	public Performer() {
		
		this(CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode());
	}
	
	public Performer(REDSMT010001UVPerformer performer) {
		this (CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode());
		if (performer.getHealthCareProvider() != null) {
			this.providerOrPatient = CodeUtility.getCode("PROV", "2.16.840.1.113883.5.110", "Provider", "");
			this.healthCareProvider = CodeUtility.getCode(performer.getHealthCareProvider()
					.getValue().getCode());
			this.language = CodeUtility.getCode(performer.getHealthCareProvider().getValue()
					.getHealthCarePerson().getValue().getLanguageCommunication().get(0)
					.getLanguageCode());
		} else if (performer.getPatient() != null){
			this.providerOrPatient = CodeUtility.getCode("PAT", "2.16.840.1.113883.5.110", "Patient", "");
			this.healthCareProvider = CodeUtility.getCode();;
			this.language = CodeUtility.getCode(performer.getPatient().getValue().getPatientPerson().getValue()
					.getLanguageCommunication().get(0).getLanguageCode());
		}
	}
	
	public Code getLanguage() {
		
		return this.language;
	}
	
	public Code getHealthCareProvider() {
		
		return this.healthCareProvider;
	}
	
	public void setLanguage(Code language) {
		
		this.language = language;
	}
	
	public void setHealthCareProvider(Code healthCareProvider) {
		
		this.healthCareProvider = healthCareProvider;
	}
	
	public Code getProviderOrPatient() {
		return providerOrPatient;
	}

	public void setProviderOrPatient(Code providerOrPatient) {
		this.providerOrPatient = providerOrPatient;
	}
	
	public static JAXBElement<REDSMT010001UVPerformer> getJAXBElement(Performer performer) {
		
		REDSMT010001UVPerformer element = new REDSMT010001UVPerformer();
		REDSMT010001UVHealthCareProvider healthCareProvider = new REDSMT010001UVHealthCareProvider();
		REDSMT010001UVPatient patient = new REDSMT010001UVPatient();
		REDSMT010001UVPerson person = new REDSMT010001UVPerson();
		REDSMT010001UVLanguageCommunication language = new REDSMT010001UVLanguageCommunication();
		if (performer.getProviderOrPatient().getCode().equals("PROV")) {
			language.setLanguageCode(CodeUtility.getJAXBElement(performer.getLanguage()));
			person.getLanguageCommunication().add(language);
			healthCareProvider.setCode(CodeUtility.getJAXBElement(performer.getHealthCareProvider()));
			healthCareProvider.setHealthCarePerson(new JAXBElement<REDSMT010001UVPerson>(new QName("urn:hl7-org:v3", "healthCarePerson"), 
					REDSMT010001UVPerson.class, person));
			element.setHealthCareProvider(new JAXBElement<REDSMT010001UVHealthCareProvider>(new QName("urn:hl7-org:v3", "healthCareProvider"), 
					REDSMT010001UVHealthCareProvider.class, healthCareProvider));
		} else if (performer.getProviderOrPatient().getCode().equals("PAT")) {
			language.setLanguageCode(CodeUtility.getJAXBElement(performer.getLanguage()));
			person.getLanguageCommunication().add(language);
			patient.setPatientPerson(new JAXBElement<REDSMT010001UVPerson>(new QName("urn:hl7-org:v3", "patientPerson"), 
					REDSMT010001UVPerson.class, person));
			element.setPatient(new JAXBElement<REDSMT010001UVPatient>(new QName("urn:hl7-org:v3", "patient"), 
					REDSMT010001UVPatient.class, patient));
		}
		JAXBElement<REDSMT010001UVPerformer> jaxBElement = new JAXBElement<REDSMT010001UVPerformer>(new QName("urn:hl7-org:v3", "performer"), 
				REDSMT010001UVPerformer.class, element);
		return jaxBElement;		
	}
}
