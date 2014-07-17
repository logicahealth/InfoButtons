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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.CategoryType;
import org.hl7.v3.PQValueUnit;
import org.hl7.v3.REDSMT010001UVAge;
import org.hl7.v3.REDSMT010001UVAgeGroup;
import org.hl7.v3.REDSMT010001UVPatientContext;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1872          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2011-01-10 1#$:  Date of last commit
 */

/**
 * The Class PatientContext.
 */
public class PatientContext
{

    /** The patient. */
    private Patient patient;

    /**
     * Instantiates a new patient context.
     *
     * @param patient the patient
     */
    public PatientContext( Patient patient )
    {

        this.patient = patient;
    }

    /**
     * Instantiates a new patient context.
     */
    public PatientContext()
    {

        this( new Patient() );
    }
    
    /**
     * Instantiates a new patient context.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public PatientContext(Map<String, String[]> requestParameters, final Map<String, List<CategoryType>> categoryHashMap) {
        
        this( new Patient ());
        List<CategoryType> category = new ArrayList<CategoryType>();
        final Code gender = CodeUtility.getCode( CodeConstants.GENDER );
        if ( requestParameters.containsKey( CodeConstants.GENDER_CODE ) )
        {
            gender.setCode( requestParameters.get( CodeConstants.GENDER_CODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.GENDER_CODE )[0] );
            c.setScheme( CodeConstants.GENDER_CODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.GENDER_DISPLAYNAME ) )
        {
            gender.setDisplayName( requestParameters.get( CodeConstants.GENDER_DISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.GENDER_DISPLAYNAME )[0] );
            c.setScheme( CodeConstants.GENDER_DISPLAYNAME );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.GENDER_CODESYSTEM ) )
        {
            gender.setCodeSystem( requestParameters.get( CodeConstants.GENDER_CODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.GENDER_CODESYSTEM )[0] );
            c.setScheme( CodeConstants.GENDER_CODESYSTEM );
            category.add( c );
        }

        patient.setGender( gender );
        categoryHashMap.put( CodeConstants.PATIENT_GENDER_KEY, category );
        Code ageGroup = CodeUtility.getCode( CodeConstants.AGEGROUP );
        if ( requestParameters.containsKey( CodeConstants.PATIENT_AGE ) )
        {
            patient.setAge( Float.valueOf( requestParameters.get( CodeConstants.PATIENT_AGE )[0] ) );
            ageGroup = CodeUtility.getCode( "", "2.16.840.1.113883.6.177", "", "MeSH" );
            ageGroup.setCode( getAgeGroupFromAge(requestParameters.get( CodeConstants.PATIENT_AGE )[0] ));
        }

        if ( requestParameters.containsKey( CodeConstants.AGEGROUP_CODE ) )
        {
            ageGroup.setCode( requestParameters.get( CodeConstants.AGEGROUP_CODE )[0] );
        }
        if ( requestParameters.containsKey( CodeConstants.AGEGROUP_DISPLAYNAME ) )
        {
            ageGroup.setDisplayName( requestParameters.get( CodeConstants.AGEGROUP_DISPLAYNAME )[0] );
        }
        patient.setAgeGroup( ageGroup );
        this.setPatient( patient );
    }

    /**
     * Instantiates a new patient context.
     *
     * @param patientContext the patient context
     */
    public PatientContext( REDSMT010001UVPatientContext patientContext )
    {

        final Code gender = CodeUtility.getCode( patientContext.getAdministrativeGenderCode() );
        Code ageGroup = CodeUtility.getCode( "", "2.16.840.1.113883.6.177", "", "MeSH" );
        Float age = new Float( 0 );
        if ( ( patientContext.getAgeOrAgeGroup().get( 0 ).getClass().getName() ).equals( REDSMT010001UVAge.class.getName() ) )
        {
            final String temp =
                ( (REDSMT010001UVAge) patientContext.getAgeOrAgeGroup().get( 0 ) ).getValue().getValue();
            age = Float.parseFloat( temp );
            ageGroup.setCode( CodeConstants.AGE_RANGES.
                              get(CodeConstants.AGE_RANGES.floorKey(age.intValue())));
        }
        else if ( ( patientContext.getAgeOrAgeGroup().get( 0 ).getClass().getName() ).
                        equals( REDSMT010001UVAgeGroup.class.getName() ) )
        {
            ageGroup =
                CodeUtility.getCode( ( (REDSMT010001UVAgeGroup) patientContext.getAgeOrAgeGroup().get( 0 ) ).getValue() );
        }
        this.patient = new Patient( gender, ageGroup, age );
    }

    /**
     * Gets the patient.
     *
     * @return the patient
     */
    public Patient getPatient()
    {

        return this.patient;
    }

    /**
     * Sets the patient.
     *
     * @param patient the new patient
     */
    public void setPatient( Patient patient )
    {
        this.patient = patient;
    }

    /**
     * Gets the JAXB element.
     *
     * @param patientContext the patient context
     * @return the JAXB element
     */
    public static JAXBElement<REDSMT010001UVPatientContext> getJAXBElement( PatientContext patientContext )
    {
        final REDSMT010001UVPatientContext element = new REDSMT010001UVPatientContext();
        final Patient patient = patientContext.getPatient();
        element.setAdministrativeGenderCode( CodeUtility.getJAXBElement( patient.getGender() ) );
        if ( patient.getAge() > 0 )
        {
            final REDSMT010001UVAge age = new REDSMT010001UVAge();
            final PQValueUnit unit = new PQValueUnit();
            unit.setValue( Float.toString( patient.getAge() ) );
            age.setValue( unit );
            element.getAgeOrAgeGroup().add( age );
        }
        else
        {
            final REDSMT010001UVAgeGroup ageGroup = new REDSMT010001UVAgeGroup();
            ageGroup.setValue( CodeUtility.getJAXBElement( patient.getAgeGroup() ) );
            element.getAgeOrAgeGroup().add( ageGroup );
        }
        final JAXBElement<REDSMT010001UVPatientContext> jaxBElement =
            new JAXBElement<REDSMT010001UVPatientContext>( new QName( "urn:hl7-org:v3", "patientContext" ),
                                                           REDSMT010001UVPatientContext.class, element );
        return jaxBElement;
    }
    
    private String getAgeGroupFromAge (String ageString) {
        
        final Float age = Float.parseFloat( ageString );
        return CodeConstants.AGE_RANGES.get(CodeConstants.AGE_RANGES.floorKey(age.intValue()));
    }
}
