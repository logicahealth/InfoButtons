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
 * @version Jul 31, 2014
 */
package org.infobutton.schema.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.v3.CategoryType;
import org.hl7.v3.REDSMT010001UVKnowledgeRequestNotification;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openinfobutton.schema.Code;
import org.openinfobutton.schema.CodeConstants;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schema.Encounter;
import org.openinfobutton.schema.Holder;
import org.openinfobutton.schema.IDLite;
import org.openinfobutton.schema.InformationRecipient;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.MainSearchCriteria;
import org.openinfobutton.schema.Patient;
import org.openinfobutton.schema.PatientContext;
import org.openinfobutton.schema.Performer;
import org.openinfobutton.schema.SeverityObservation;
import org.openinfobutton.schema.TaskContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The Class OIBSchemaConstructorTest.
 */
public class OIBSchemaConstructorTest
{
    
    /** The represented organization id. */
    private final String REPRESENTED_ORGANIZATION_ID = "1.3.6.1.4.1.5884";
    
    /** The represented organization name. */
    private final String REPRESENTED_ORGANIZATION_NAME = "University of Utah";
    
    /** The gender code. */
    private final String GENDER_CODE = "F";
    
    /** The age in years. */
    private final float AGE_IN_YEARS = 47;
    
    /** The age type code. */
    private final String AGE_TYPE_CODE = "a";
    
    /** The task context code. */
    private final String TASK_CONTEXT_CODE = "PROBLISTREV";
    
    /** The main search code. */
    private final String MAIN_SEARCH_CODE = "595.9";
    
    /** The main search codesystem. */
    private final String MAIN_SEARCH_CODESYSTEM = "2.16.840.1.113883.6.103";
    
    /** The main search display name. */
    private final String MAIN_SEARCH_DISPLAY_NAME = "Cystitis";
    
    /** The information recipient. */
    private final String INFORMATION_RECIPIENT = "PROV";
    
    
    /**
     * Test build holder.
     *
     * @return the holder
     */
    private final Holder testBuildHolder()
    {
        Holder holder = new Holder();
        holder.setAssignedAuthorizedPerson(testBuildIDLite());
        holder.setName(REPRESENTED_ORGANIZATION_NAME);
        holder.setRepresentedOrganization( testBuildIDLite() );
        return holder;
    }
    
    /**
     * Test build id lite.
     *
     * @return the ID lite
     */
    private final IDLite testBuildIDLite() 
    {
        IDLite idLite = new IDLite();
        idLite.setAssigningAuthorityName(REPRESENTED_ORGANIZATION_NAME);
        idLite.setRoot(REPRESENTED_ORGANIZATION_ID);
        return idLite;
    }
    
    /**
     * Test build patient context.
     *
     * @return the patient context
     */
    private final PatientContext testBuildPatientContext()
    {
        PatientContext patientContext = new PatientContext();
        patientContext.setPatient(testBuildPatient());
        return patientContext;
    }

    /**
     * Test build patient.
     *
     * @return the patient
     */
    private Patient testBuildPatient()
    {
        Patient patient = new Patient();
        patient.setAge(AGE_IN_YEARS);
        patient.setGender( CodeUtility.getCode( GENDER_CODE, "2.16.840.1.113883.5.1", "", 
                                                               "AdministrativeGender" ));                
        return patient;
    }
    
    /**
     * Test build performer.
     *
     * @return the performer
     */
    private Performer testBuildPerformer()
    {
        Performer performer = new Performer();
        performer.setHealthCareProvider(  CodeUtility.getCode( "PROV", "2.16.840.1.113883.5.110", "Provider", ""));
        performer.setLanguage( CodeUtility.getCode("", "2.16.840.1.113883.6.121", "",
                                                   "ISO Tags For Human Languages"));
        
        return performer;
    }
    
    /**
     * Test build information recipient.
     *
     * @return the information recipient
     */
    private InformationRecipient testBuildInformationRecipient()
    {
        InformationRecipient informationRecipient = new InformationRecipient();
        informationRecipient.setHealthCareProvider(  CodeUtility.getCode( "PROV", "2.16.840.1.113883.5.110", "Provider", ""));
        informationRecipient.setLanguage( CodeUtility.getCode("", "2.16.840.1.113883.6.121", "",
                                                   "ISO Tags For Human Languages"));
        
        return informationRecipient;
    }
    
    /**
     * Test build task context.
     *
     * @return the task context
     */
    private TaskContext testBuildTaskContext()
    {
        TaskContext task = new TaskContext();
        task.setCode( CodeUtility.getCode( "", "2.16.840.1.113883.5.4", "", "ActCode" ));
        
        return task;
    }
    
    /**
     * Test build main search criteria.
     *
     * @return the main search criteria
     */
    private MainSearchCriteria testBuildMainSearchCriteria()
    {
        MainSearchCriteria mainSearch = new MainSearchCriteria();
        mainSearch.setCode( CodeUtility.getCode("595.9","2.16.840.1.113883.6.103", "Cystitis", ""));
        mainSearch.setSeverityObservation( new SeverityObservation() );
        return mainSearch;
    }
    
    /**
     * Test build encounter.
     *
     * @return the encounter
     */
    private Encounter testBuildEncounter() {
        
        Encounter encounter = new Encounter();
        encounter.setCode( CodeUtility.getCode( "", "2.16.840.1.113883.5.4", "", "" ) );
        encounter.setServiceDeliveryLocation( new IDLite() );
        return encounter;
    }
    
    /**
     * Cystitis icd9 request parameter map.
     *
     * @return the map
     */
    private static Map<String, String[]> cystitisICD9Request()
    {

        final Map<String, String[]> requestParameters = new HashMap<String, String[]>();
        requestParameters.put( "representedOrganization.id.root", new String[] { "1.3.6.1.4.1.5884" } );
        requestParameters.put( "patientPerson.administrativeGenderCode.c", new String[] { "F" } );
        requestParameters.put( "age.v.v", new String[] { "47" } );
        requestParameters.put( "age.v.u", new String[] { "a" } );
        requestParameters.put( "taskContext.c.c", new String[] { "PROBLISTREV" } );
        requestParameters.put( "mainSearchCriteria.v.c", new String[] { "595.9" } );
        requestParameters.put( "mainSearchCriteria.v.cs", new String[] { "2.16.840.1.113883.6.103" } );
        requestParameters.put( "mainSearchCriteria.v.dn", new String[] { "Cystitis" } );
        requestParameters.put( "performer", new String[] { "PROV" } );
        requestParameters.put( "informationRecipient", new String[] { "PROV" } );
        requestParameters.put( "knowledgeResponseType", new String[] { "text/xml" } );
        return requestParameters;

    }
    
    /**
     * Test build kr object.
     *
     * @return the knowledge request
     */
    private KnowledgeRequest testBuildKRObject() 
    {
        
        KnowledgeRequest request = new KnowledgeRequest();
        final Map<String, List<CategoryType>> categoryHashMap = new HashMap<String, List<CategoryType>>();
        
        request.setCategoryHashMap( categoryHashMap );
        request.setEffectiveTime( new Date() );
        request.setEncounter(testBuildEncounter());
        request.setExecutionMode( new String() );
        request.setHolder( testBuildHolder() );
        request.setInformationRecipient( testBuildInformationRecipient() );
        request.setMainSearchCriteria( testBuildMainSearchCriteria() );
        request.setPatientContext( testBuildPatientContext() );
        request.setPerformer( testBuildPerformer() );
        request.setTaskContext( testBuildTaskContext() );
        return request;
    }
    
    /**
     * Test convert kr object.
     *
     * @param request the request
     * @return the REDSM t010001 uv knowledge request notification
     */
    private REDSMT010001UVKnowledgeRequestNotification testConvertKRObject(KnowledgeRequest request)
    {
        
        return KnowledgeRequest.getJAXBElement( request );
        
    }
    
    /**
     * Test kr object construction.
     */
    @Test
    public void testKRObjectConstruction()
    {
        
        KnowledgeRequest request = testBuildKRObject();
        REDSMT010001UVKnowledgeRequestNotification soapRequest = testConvertKRObject(request);
        request = new KnowledgeRequest (soapRequest);
        assertEquals(request.getMainSearchCriteria().getCode().getCode(), soapRequest.getMainSearchCriteria().getValue().getCode());
    }
    
    @Test
    public void testKRBuildFromReqestParameters()
    {
        final Map<String, List<CategoryType>> categoryHashMap = new HashMap<String, List<CategoryType>>();
        KnowledgeRequest request = new KnowledgeRequest(cystitisICD9Request(), categoryHashMap);
        assertNotNull(request);
    }
    
    @Test
    public void testBuildEmptyKR()
    {
        
        KnowledgeRequest request = new KnowledgeRequest(new PatientContext(), new Holder(), new Performer(), 
                                                        new InformationRecipient(), new TaskContext(), new MainSearchCriteria(),
                                                        new Encounter(), new Date(), new String());
        assertNotNull(request);
        REDSMT010001UVKnowledgeRequestNotification soapRequest = KnowledgeRequest.getJAXBElement( request );
        assertNotNull(soapRequest);
        request = new KnowledgeRequest(soapRequest);
        assertNotNull(request);
        request = new KnowledgeRequest (new REDSMT010001UVKnowledgeRequestNotification());
        assertNotNull(request);
    }

}
