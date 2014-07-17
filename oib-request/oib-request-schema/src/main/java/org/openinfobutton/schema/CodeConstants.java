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
 * @version Jul 15, 2014
 */
package org.openinfobutton.schema;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1999          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2011-01-25 1#$:  Date of last commit
 */

/**
 * The Class CodeConstants.
 */
public final class CodeConstants
{
    
    /**
     * Instantiates a new code constants.
     */
    private CodeConstants(){}

    /* Constant Codes */

    /** The Constant PROVIDER. */
    public static final Code PROVIDER = CodeUtility.getCode( "PROV", "2.16.840.1.113883.5.110", "Provider", "" );

    /** The Constant PATIENT. */
    public static final Code PATIENT = CodeUtility.getCode( "PAT", "2.16.840.1.113883.5.110", "Patient", "" );

    /** The Constant GENDER. */
    public static final Code GENDER = CodeUtility.getCode( "", "2.16.840.1.113883.5.1", "", "AdministrativeGender" );

    /** The Constant AGEGROUP. */
    public static final Code AGEGROUP = CodeUtility.getCode( "", "2.16.840.1.113883.6.177", "", "MeSH" );

    /** The Constant TASKCONTEXT. */
    public static final Code TASKCONTEXT = CodeUtility.getCode( "", "2.16.840.1.113883.5.4", "", "ActCode" );

    /** The Constant LANGUAGE. */
    public static final Code LANGUAGE = CodeUtility.getCode( "", "2.16.840.1.113883.6.121", "",
                                                             "ISO Tags For Human Languages" );

    /** The Constant ENCOUNTER. */
    public static final Code ENCOUNTER = CodeUtility.getCode( "", "2.16.840.1.113883.5.4", "", "" );

    /* URL Implementation Parameter names */

    /** The Constant EFFECTIVE_TIME. */
    public static final String EFFECTIVE_TIME = "knowledgeRequestNotification.effectiveTime.v";

    /** The Constant HOLDER_NAME. */
    public static final String HOLDER_NAME = "holder.assignedEntity.n";

    /** The Constant HOLDER_CERTIFICATETEXT. */
    public static final String HOLDER_CERTIFICATETEXT = "holder.assignedEntity.certificateText";

    /** The Constant HOLDER_AUTHORIZEDPERSON. */
    public static final String HOLDER_AUTHORIZEDPERSON = "assignedAuthorizedPerson.id.root";

    /** The Constant HOLDER_ORGANIZATION. */
    public static final String HOLDER_ORGANIZATION = "representedOrganization.id.root";

    /** The Constant HOLDER_ORGANIZATIONNAME. */
    public static final String HOLDER_ORGANIZATIONNAME = "assignedEntity.representedOrganization.n";

    /** The Constant GENDER_CODE. */
    public static final String GENDER_CODE = "patientPerson.administrativeGenderCode.c";

    /** The Constant GENDER_DISPLAYNAME. */
    public static final String GENDER_DISPLAYNAME = "patientPerson.administrativeGenderCode.dn";

    /** The Constant GENDER_CODESYSTEM. */
    public static final String GENDER_CODESYSTEM = "patientPerson.administrativeGenderCode.cs";

    /** The Constant PATIENT_AGE. */
    public static final String PATIENT_AGE = "age.v.v";

    /** The Constant PATIENT_AGEUNIT. */
    public static final String PATIENT_AGEUNIT = "age.v.u";

    /** The Constant AGEGROUP_CODE. */
    public static final String AGEGROUP_CODE = "ageGroup.v.c";

    /** The Constant AGEGROUP_CODESYSTEM. */
    public static final String AGEGROUP_CODESYSTEM = "ageGroup.v.cs";

    /** The Constant AGEGROUP_DISPLAYNAME. */
    public static final String AGEGROUP_DISPLAYNAME = "ageGroup.v.dn";

    /** The Constant TASKCONTEXT_CODE. */
    public static final String TASKCONTEXT_CODE = "taskContext.c.c";

    /** The Constant TASKCONTEXT_CODESYSTEM. */
    public static final String TASKCONTEXT_CODESYSTEM = "taskContext.c.cs";

    /** The Constant TASKCONTEXT_DISPLAYNAME. */
    public static final String TASKCONTEXT_DISPLAYNAME = "taskContext.c.dn";

    /** The Constant SUBTOPIC_CODE. */
    public static final String SUBTOPIC_CODE = "subTopic.v.c";

    /** The Constant SUBTOPIC_CODESYSTEM. */
    public static final String SUBTOPIC_CODESYSTEM = "subTopic.v.cs";

    /** The Constant SUBTOPIC_DISPLAYNAME. */
    public static final String SUBTOPIC_DISPLAYNAME = "subTopic.v.dn";

    /** The Constant MAINSEARCH_CODE. */
    public static final String MAINSEARCH_CODE = "mainSearchCriteria.v.c";

    /** The Constant MAINSEARCH_CODESYSTEM. */
    public static final String MAINSEARCH_CODESYSTEM = "mainSearchCriteria.v.cs";

    /** The Constant MAINSEARCH_DISPLAYNAME. */
    public static final String MAINSEARCH_DISPLAYNAME = "mainSearchCriteria.v.dn";

    /** The Constant MAINSEARCH_ORIGINALTEXT. */
    public static final String MAINSEARCH_ORIGINALTEXT = "mainSearchCriteria.v.ot";

    /** The Constant SEVERITYOBSERVATION_CODE. */
    public static final String SEVERITYOBSERVATION_CODE = "severityObservation.interpretationCode.c";

    /** The Constant SEVERITYOBSERVATION_CODESYSTEM. */
    public static final String SEVERITYOBSERVATION_CODESYSTEM = "severityObservation.interpretationCode.cs";

    /** The Constant SEVERITYOBSERVATION_DISPLAYNAME. */
    public static final String SEVERITYOBSERVATION_DISPLAYNAME = "severityObservation.interpretationCode.dn";

    /** The Constant INFORMATIONRECIPIENT. */
    public static final String INFORMATIONRECIPIENT = "informationRecipient";

    /** The Constant PERFORMER. */
    public static final String PERFORMER = "performer";

    /** The Constant PERFORMER_CODE. */
    public static final String PERFORMER_CODE = "performer.healthCareProvider.c.c";

    /** The Constant PERFORMER_CODESYSTEM. */
    public static final String PERFORMER_CODESYSTEM = "performer.healthCareProvider.c.cs";

    /** The Constant PERFORMER_DISPLAYNAME. */
    public static final String PERFORMER_DISPLAYNAME = "performer.healthCareProvider.c.dn";

    /** The Constant PERFORMER_LANGUAGECODE. */
    public static final String PERFORMER_LANGUAGECODE = "performer.languageCode.c";

    /** The Constant PERFORMER_LANGUAGECODESYSTEM. */
    public static final String PERFORMER_LANGUAGECODESYSTEM = "performer.languageCode.cs";

    /** The Constant PERFORMER_LANGUAGEDISPLAYNAME. */
    public static final String PERFORMER_LANGUAGEDISPLAYNAME = "performer.languageCode.dn";

    /** The Constant INFORMATIONRECIPIENT_CODE. */
    public static final String INFORMATIONRECIPIENT_CODE = "informationRecipient.healthCareProvider.c.c";

    /** The Constant INFORMATIONRECIPIENT_CODESYSTEM. */
    public static final String INFORMATIONRECIPIENT_CODESYSTEM = "informationRecipient.healthCareProvider.c.cs";

    /** The Constant INFORMATIONRECIPIENT_DISPLAYNAME. */
    public static final String INFORMATIONRECIPIENT_DISPLAYNAME = "informationRecipient.healthCareProvider.c.dn";

    /** The Constant INFORMATIONRECIPIENT_LANGUAGECODE. */
    public static final String INFORMATIONRECIPIENT_LANGUAGECODE = "informationRecipient.languageCode.c";

    /** The Constant INFORMATIONRECIPIENT_LANGUAGECODESYSTEM. */
    public static final String INFORMATIONRECIPIENT_LANGUAGECODESYSTEM = "informationRecipient.languageCode.cs";

    /** The Constant INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME. */
    public static final String INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME = "informationRecipient.languageCode.dn";

    /** The Constant ENCOUNTER_CODE. */
    public static final String ENCOUNTER_CODE = "encounter.c.c";

    /** The Constant ENCOUNTER_CODESYSTEM. */
    public static final String ENCOUNTER_CODESYSTEM = "encounter.c.cs";

    /** The Constant ENCOUNTER_DISPLAYNAME. */
    public static final String ENCOUNTER_DISPLAYNAME = "encounter.c.dn";

    /** The Constant ENCOUNTER_SERVICEDELIVERYLOCATION. */
    public static final String ENCOUNTER_SERVICEDELIVERYLOCATION = "serviceDeliveryLocation.id.root";

    /** The Constant EXECUTION_MODE. */
    public static final String EXECUTION_MODE = "executionMode";

    /** The Constant KNOWLEDGE_RESPONSE_TYPE. */
    public static final String KNOWLEDGE_RESPONSE_TYPE = "knowledgeResponseType";

    // Following are for storing the request parameters in the hashMap of knowledge request
    /** The Constant PATIENT_GENDER_KEY. */
    public static final String PATIENT_GENDER_KEY = "PATIENT_GENDER_KEY";

    /** The Constant PATIENT_AGEGROUP_KEY. */
    public static final String PATIENT_AGEGROUP_KEY = "PATIENT_AGEGROUP_KEY";

    /** The Constant TASK_KEY. */
    public static final String TASK_KEY = "TASK_KEY";

    /** The Constant ENCOUNTER_KEY. */
    public static final String ENCOUNTER_KEY = "ENCOUNTER_KEY";

    /** The Constant PERFORMER_LANGUAGE_KEY. */
    public static final String PERFORMER_LANGUAGE_KEY = "PERFORMER_LANGUAGE_KEY";

    /** The Constant PERFORMER_DISCIPLINE_KEY. */
    public static final String PERFORMER_DISCIPLINE_KEY = "PERFORMER_DISCIPLINE_KEY";

    /** The Constant PERFORMER_KNOWLEDGE_USERTYPE_KEY. */
    public static final String PERFORMER_KNOWLEDGE_USERTYPE_KEY = "PERFORMER_KNOWLEDGE_USERTYPE_KEY";

    /** The Constant INFORMATION_RECIPIENT_LANGUAGE_KEY. */
    public static final String INFORMATION_RECIPIENT_LANGUAGE_KEY = "INFORMATION_RECIPIENT_LANGUAGE_KEY";

    /** The Constant INFORMATION_RECIPIENT_DISCIPLINE_KEY. */
    public static final String INFORMATION_RECIPIENT_DISCIPLINE_KEY = "INFORMATION_RECIPIENT_DISCIPLINE_KEY";

    /** The Constant INFORMATION_RECIPIENT_USERTYPE_KEY. */
    public static final String INFORMATION_RECIPIENT_USERTYPE_KEY = "INFORMATION_RECIPIENT_USERTYPE_KEY";

    /** The Constant CONCEPT_OF_INTEREST_KEY. */
    public static final String CONCEPT_OF_INTEREST_KEY = "CONCEPT_OF_INTEREST_KEY";
    
    /** The Constant MESH_CODE_SYSTEM_OID. */
    public final static String MESH_CODE_SYSTEM_OID = "2.16.840.1.113883.6.177";

    /** The Constant BIRTH_TO_1_MONTH. */
    public final static String BIRTH_TO_1_MONTH = "D007231";

    /** The Constant ONE_TO_23_MONTHS. */
    public final static String ONE_TO_23_MONTHS = "D007223";

    /** The Constant PRESCHOOL_2_TO_5_YEARS. */
    public final static String PRESCHOOL_2_TO_5_YEARS = "D002675";

    /** The Constant CHILD_6_TO_12_YEARS. */
    public final static String CHILD_6_TO_12_YEARS = "D002648";

    /** The Constant ADOLESCENT_13_TO_18_YEARS. */
    public final static String ADOLESCENT_13_TO_18_YEARS = "D000293";

    /** The Constant YOUNG_ADULT_19_TO_24_YEARS. */
    public final static String YOUNG_ADULT_19_TO_24_YEARS = "D055815";

    /** The Constant ADULT_19_TO_44_YEARS. */
    public final static String ADULT_19_TO_44_YEARS = "D000328";

    /** The Constant MIDDLE_AGED_45_TO_64_YEARS. */
    public final static String MIDDLE_AGED_45_TO_64_YEARS = "D008875";

    /** The Constant AGED_56_TO_79_YEARS. */
    public final static String AGED_56_TO_79_YEARS = "D000368";

    /** The Constant OLD_80_YEARS_AND_ABOVE. */
    public final static String OLD_80_YEARS_AND_ABOVE = "D000369";
    
    /** The Constant MAX_HUMAN_AGE_IN_YEARS. */
    public final static int MAX_HUMAN_AGE_IN_YEARS = 110;
    
    /** The Constant AGE_RANGES. */
    @SuppressWarnings( "boxing" )
    public static final NavigableMap<Integer,String> AGE_RANGES = new TreeMap<Integer, String>() 
    {
        {
            put(0, BIRTH_TO_1_MONTH);
            put(1, ONE_TO_23_MONTHS);
            put(2, PRESCHOOL_2_TO_5_YEARS);
            put(6, CHILD_6_TO_12_YEARS);
            put(13, ADOLESCENT_13_TO_18_YEARS);
            put(19, YOUNG_ADULT_19_TO_24_YEARS);
            put(25, ADULT_19_TO_44_YEARS);
            put(45, MIDDLE_AGED_45_TO_64_YEARS);
            put(56, AGED_56_TO_79_YEARS);
            put(80, OLD_80_YEARS_AND_ABOVE);
        }
    };
}
