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

import org.openinfobutton.schemas.kb.Code;

/*
$Rev:: 1999          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2011-01-25 1#$:  Date of last commit
*/


public final class CodeConstants {
	
	/*Constant Codes*/
	
	public static final Code PROVIDER = CodeUtility.getCode("PROV", "2.16.840.1.113883.5.110", "Provider", "");
	
	public static final Code PATIENT = CodeUtility.getCode("PAT", "2.16.840.1.113883.5.110", "Patient", "");
	
	public static final Code GENDER = CodeUtility.getCode("", "2.16.840.1.113883.5.1", "", "AdministrativeGender");
	
	public static final Code AGEGROUP = CodeUtility.getCode("", "2.16.840.1.113883.6.177", "", "MeSH");
	
	public static final Code TASKCONTEXT = CodeUtility.getCode("", "2.16.840.1.113883.5.4", "", "ActCode");
	
	public static final Code LANGUAGE = CodeUtility.getCode("", "2.16.840.1.113883.6.121", "", "ISO Tags For Human Languages");
	
	public static final Code ENCOUNTER = CodeUtility.getCode("", "2.16.840.1.113883.5.4", "", "");
	
	/*URL Implementation Parameter names*/
	
	public static final String EFFECTIVE_TIME = "knowledgeRequestNotification.effectiveTime.v";
	
	public static final String HOLDER_NAME = "holder.assignedEntity.n";
	
	public static final String HOLDER_CERTIFICATETEXT = "holder.assignedEntity.certificateText";
	
	public static final String HOLDER_AUTHORIZEDPERSON = "assignedAuthorizedPerson.id.root";
	
	public static final String HOLDER_ORGANIZATION = "representedOrganization.id.root";
	
	public static final String HOLDER_ORGANIZATIONNAME = "assignedEntity.representedOrganization.n";
	
	public static final String GENDER_CODE = "patientPerson.administrativeGenderCode.c";
	
	public static final String GENDER_DISPLAYNAME = "patientPerson.administrativeGenderCode.dn";

	public static final String GENDER_CODESYSTEM = "patientPerson.administrativeGenderCode.cs";
	
	public static final String PATIENT_AGE = "age.v.v";
	
	public static final String PATIENT_AGEUNIT = "age.v.u";
	
	public static final String AGEGROUP_CODE = "ageGroup.v.c";
	
	public static final String AGEGROUP_CODESYSTEM = "ageGroup.v.cs";
	
	public static final String AGEGROUP_DISPLAYNAME = "ageGroup.v.dn";
	
	public static final String TASKCONTEXT_CODE = "taskContext.c.c";
	
	public static final String TASKCONTEXT_CODESYSTEM = "taskContext.c.cs";	
	
	public static final String TASKCONTEXT_DISPLAYNAME = "taskContext.c.dn";
	
	public static final String SUBTOPIC_CODE = "subTopic.v.c";
	
	public static final String SUBTOPIC_CODESYSTEM = "subTopic.v.cs";
	
	public static final String SUBTOPIC_DISPLAYNAME = "subTopic.v.dn";

	public static final String MAINSEARCH_CODE = "mainSearchCriteria.v.c";
	
	public static final String MAINSEARCH_CODESYSTEM = "mainSearchCriteria.v.cs";
	
	public static final String MAINSEARCH_DISPLAYNAME = "mainSearchCriteria.v.dn";
	
	public static final String MAINSEARCH_ORIGINALTEXT = "mainSearchCriteria.v.ot";
	
	public static final String SEVERITYOBSERVATION_CODE = "severityObservation.interpretationCode.c";
	
	public static final String SEVERITYOBSERVATION_CODESYSTEM = "severityObservation.interpretationCode.cs";
	
	public static final String SEVERITYOBSERVATION_DISPLAYNAME = "severityObservation.interpretationCode.dn";
	
	public static final String INFORMATIONRECIPIENT = "informationRecipient";
	
	public static final String PERFORMER = "performer";
	
	public static final String PERFORMER_CODE = "performer.healthCareProvider.c.c";
	
	public static final String PERFORMER_CODESYSTEM = "performer.healthCareProvider.c.cs";
	
	public static final String PERFORMER_DISPLAYNAME = "performer.healthCareProvider.c.dn";

	public static final String PERFORMER_LANGUAGECODE = "performer.languageCode.c";
	
	public static final String PERFORMER_LANGUAGECODESYSTEM = "performer.languageCode.cs";

	public static final String PERFORMER_LANGUAGEDISPLAYNAME = "performer.languageCode.dn";
	
	public static final String INFORMATIONRECIPIENT_CODE = "informationRecipient.healthCareProvider.c.c";
	
	public static final String INFORMATIONRECIPIENT_CODESYSTEM = "informationRecipient.healthCareProvider.c.cs";
	
	public static final String INFORMATIONRECIPIENT_DISPLAYNAME = "informationRecipient.healthCareProvider.c.dn";
	
	public static final String INFORMATIONRECIPIENT_LANGUAGECODE = "informationRecipient.languageCode.c";
	
	public static final String INFORMATIONRECIPIENT_LANGUAGECODESYSTEM = "informationRecipient.languageCode.cs";
	
	public static final String INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME = "informationRecipient.languageCode.dn";
	
	public static final String ENCOUNTER_CODE = "encounter.c.c";
	
	public static final String ENCOUNTER_CODESYSTEM = "encounter.c.cs";
	
	public static final String ENCOUNTER_DISPLAYNAME = "encounter.c.dn";
	
	public static final String ENCOUNTER_SERVICEDELIVERYLOCATION = "serviceDeliveryLocation.id.root";
	
	public static final String EXECUTION_MODE = "executionMode";
	
	public static final String KNOWLEDGE_RESPONSE_TYPE = "knowledgeResponseType";
	
	//Following are for storing the request parameters in the hashMap of knowledge request
	public static final String PATIENT_GENDER_KEY = "PATIENT_GENDER_KEY";
	public static final String PATIENT_AGEGROUP_KEY = "PATIENT_AGEGROUP_KEY";
	public static final String TASK_KEY  = "TASK_KEY";
	public static final String ENCOUNTER_KEY = "ENCOUNTER_KEY";
	public static final String PERFORMER_LANGUAGE_KEY = "PERFORMER_LANGUAGE_KEY"; 
	public static final String PERFORMER_DISCIPLINE_KEY = "PERFORMER_DISCIPLINE_KEY";
	public static final String PERFORMER_KNOWLEDGE_USERTYPE_KEY = "PERFORMER_KNOWLEDGE_USERTYPE_KEY"; 
	public static final String INFORMATION_RECIPIENT_LANGUAGE_KEY = "INFORMATION_RECIPIENT_LANGUAGE_KEY";
	public static final String INFORMATION_RECIPIENT_DISCIPLINE_KEY = "INFORMATION_RECIPIENT_DISCIPLINE_KEY";
	public static final String INFORMATION_RECIPIENT_USERTYPE_KEY = "INFORMATION_RECIPIENT_USERTYPE_KEY";
	public static final String CONCEPT_OF_INTEREST_KEY = "CONCEPT_OF_INTEREST_KEY";
}

