package edu.duke.mc.cfm.dci.infobutton;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.REDSMT010001UVHealthCareProvider;
import org.hl7.v3.REDSMT010001UVInformationRecipient;
import org.hl7.v3.REDSMT010001UVLanguageCommunication;
import org.hl7.v3.REDSMT010001UVPatient;
import org.hl7.v3.REDSMT010001UVPerson;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;

public class InformationRecipient {

	private Code language;
	
	private Code healthCareProvider;
	
	private Code providerOrPatient;
	
	public InformationRecipient(Code language, Code healthCareProvider, Code providerOrPatient) {
		
		this.language = language;
		this.healthCareProvider = healthCareProvider;
		this.providerOrPatient = providerOrPatient;
	}
	
	public InformationRecipient() {
		
		this(CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode());
	}
	
	public InformationRecipient(REDSMT010001UVInformationRecipient informationRecipient) {
		this (CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode());
		if (informationRecipient.getHealthCareProvider() != null) {
			this.providerOrPatient = CodeUtility.getCode("PROV", "2.16.840.1.113883.5.110", "Provider", "");
			this.healthCareProvider = CodeUtility.getCode(informationRecipient.getHealthCareProvider()
					.getValue().getCode());
			this.language = CodeUtility.getCode(informationRecipient.getHealthCareProvider().getValue()
					.getHealthCarePerson().getValue().getLanguageCommunication().get(0)
					.getLanguageCode());
		} else if (informationRecipient.getPatient() != null){
			this.providerOrPatient = CodeUtility.getCode("PAT", "2.16.840.1.113883.5.110", "Patient", "");
			this.healthCareProvider = null;
			this.language = CodeUtility.getCode(informationRecipient.getPatient().getValue().getPatientPerson().getValue()
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
	
	public static JAXBElement<REDSMT010001UVInformationRecipient> getJAXBElement(InformationRecipient informationRecipient) {
		
		REDSMT010001UVInformationRecipient element = new REDSMT010001UVInformationRecipient();
		REDSMT010001UVHealthCareProvider healthCareProvider = new REDSMT010001UVHealthCareProvider();
		REDSMT010001UVPatient patient = new REDSMT010001UVPatient();
		REDSMT010001UVPerson person = new REDSMT010001UVPerson();
		REDSMT010001UVLanguageCommunication language = new REDSMT010001UVLanguageCommunication();
		if (informationRecipient.getProviderOrPatient().getCode().equals("PROV")) {
			language.setLanguageCode(CodeUtility.getJAXBElement(informationRecipient.getLanguage()));
			person.getLanguageCommunication().add(language);
			healthCareProvider.setCode(CodeUtility.getJAXBElement(informationRecipient.getHealthCareProvider()));
			healthCareProvider.setHealthCarePerson(new JAXBElement<REDSMT010001UVPerson>(new QName("urn:hl7-org:v3", "healthCarePerson"), 
					REDSMT010001UVPerson.class, person));
			element.setHealthCareProvider(new JAXBElement<REDSMT010001UVHealthCareProvider>(new QName("urn:hl7-org:v3" ,"healthCareProvider"), 
					REDSMT010001UVHealthCareProvider.class, healthCareProvider));
		} else if (informationRecipient.getProviderOrPatient().getCode().equals("PAT")) {
			language.setLanguageCode(CodeUtility.getJAXBElement(informationRecipient.getLanguage()));
			person.getLanguageCommunication().add(language);
			patient.setPatientPerson(new JAXBElement<REDSMT010001UVPerson>(new QName("urn:hl7-org:v3", "patientPerson"), 
					REDSMT010001UVPerson.class, person));
			element.setPatient(new JAXBElement<REDSMT010001UVPatient>(new QName("urn:hl7-org:v3", "patient"), 
					REDSMT010001UVPatient.class, patient));
		}
		JAXBElement<REDSMT010001UVInformationRecipient> jaxBElement = new JAXBElement<REDSMT010001UVInformationRecipient>(new QName("urn:hl7-org:v3", "informationRecipient"), 
				REDSMT010001UVInformationRecipient.class, element);
		return jaxBElement;		
	}
}