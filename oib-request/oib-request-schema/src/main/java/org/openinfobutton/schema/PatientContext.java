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
package org.openinfobutton.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.PQValueUnit;
import org.hl7.v3.REDSMT010001UVAge;
import org.hl7.v3.REDSMT010001UVAgeGroup;
import org.hl7.v3.REDSMT010001UVPatientContext;
import org.openinfobutton.schemas.kb.Code;


/*
$Rev:: 1872          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2011-01-10 1#$:  Date of last commit
*/

public class PatientContext {

	private Patient patient;
	
	public PatientContext(Patient patient) {
		
		this.patient = patient;
	}
	
	public PatientContext() {
		
		this(new Patient());
	}
	
	public PatientContext(REDSMT010001UVPatientContext patientContext) {
		
		Code gender = CodeUtility.getCode(patientContext.getAdministrativeGenderCode());
		Code ageGroup = CodeUtility.getCode("", "2.16.840.1.113883.6.177", "", "MeSH");
		Float age = new Float(0);
		if ((patientContext.getAgeOrAgeGroup().get(0).getClass().getName()).
				equals(REDSMT010001UVAge.class.getName())) {
					String temp = ((REDSMT010001UVAge)patientContext.
							getAgeOrAgeGroup().get(0)).getValue().getValue();
					age = Float.parseFloat(temp);
					if (age > 0 && age < 1.0/12.0) {
						ageGroup.setCode("D007231");
					} else if (age >= 1.0/12.0 && age < 2) {
						ageGroup.setCode("D007223");
					} else if (age >= 2 && age < 6) {
						ageGroup.setCode("D002675");
					} else if (age >= 6 && age < 13) {
						ageGroup.setCode("D002648");
					} else if (age >= 13 && age < 19) {
						ageGroup.setCode("D000293");
					} else if (age >= 19 && age < 25) {
						ageGroup.setCode("D055815");
					} else if (age >= 25 && age < 45) {
						ageGroup.setCode("D000328");
					} else if (age >= 45 && age < 56) {
						ageGroup.setCode("D008875");
					} else if (age >= 56 && age < 80) {
						ageGroup.setCode("D000368");
					} else if (age >= 80) {
						ageGroup.setCode("D000369");
					}
				}
		else if ((patientContext.getAgeOrAgeGroup().get(0).getClass().getName()).
				equals(REDSMT010001UVAgeGroup.class.getName())) {
			ageGroup = CodeUtility.getCode(((REDSMT010001UVAgeGroup)patientContext.
					getAgeOrAgeGroup().get(0)).getValue());
		}
		this.patient = new Patient(gender, ageGroup, age);
	}
	
	public Patient getPatient() {
		
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public static JAXBElement<REDSMT010001UVPatientContext> getJAXBElement(PatientContext patientContext) {
		REDSMT010001UVPatientContext element = new REDSMT010001UVPatientContext();
		Patient patient = patientContext.getPatient();
		element.setAdministrativeGenderCode(CodeUtility.getJAXBElement(patient.getGender()));
		if (patient.getAge() > 0) {
			REDSMT010001UVAge age = new REDSMT010001UVAge();
			PQValueUnit unit = new PQValueUnit();
			unit.setValue(Float.toString(patient.getAge()));
			age.setValue(unit);
			element.getAgeOrAgeGroup().add(age);
		} else {
			REDSMT010001UVAgeGroup ageGroup = new REDSMT010001UVAgeGroup();
			ageGroup.setValue(CodeUtility.getJAXBElement(patient.getAgeGroup()));
			element.getAgeOrAgeGroup().add(ageGroup);
		}
		JAXBElement<REDSMT010001UVPatientContext> jaxBElement = new JAXBElement<REDSMT010001UVPatientContext>(new QName("urn:hl7-org:v3", "patientContext"), 
				REDSMT010001UVPatientContext.class, element);
		return jaxBElement;
	}
}
