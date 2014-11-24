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
import org.hl7.v3.REDSMT010001UVHealthCareProvider;
import org.hl7.v3.REDSMT010001UVLanguageCommunication;
import org.hl7.v3.REDSMT010001UVPatient;
import org.hl7.v3.REDSMT010001UVPerformer;
import org.hl7.v3.REDSMT010001UVPerson;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1097          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2010-10-01 1#$:  Date of last commit
 */

/**
 * The Class Performer.
 */
public class Performer
{

    /** The language. */
    private Code language;

    /** The health care provider. */
    private Code healthCareProvider;

    /** The provider or patient. */
    private Code providerOrPatient;

    /**
     * Instantiates a new performer.
     *
     * @param language the language
     * @param healthCareProvider the health care provider
     * @param providerOrPatient the provider or patient
     */
    public Performer( Code language, Code healthCareProvider, Code providerOrPatient )
    {

        this.language = language;
        this.healthCareProvider = healthCareProvider;
        this.providerOrPatient = providerOrPatient;
    }
    
    /**
     * Instantiates a new performer.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public Performer(Map<String, String[]> requestParameters, final Map<String, List<CategoryType>> categoryHashMap) {
        
        List<CategoryType> category = new ArrayList<CategoryType>();
        final Code performerLanguage = CodeUtility.getCode( CodeConstants.LANGUAGE );
        final Code performerHealthCareProvider = CodeUtility.getCode();
        Code performerProviderOrPatient = CodeUtility.getCode();
        if ( requestParameters.containsKey( CodeConstants.PERFORMER ) )
        {
            final String performerCode = requestParameters.get( CodeConstants.PERFORMER )[0];
            if ( performerCode.equals( "PROV" ) )
            {
                performerProviderOrPatient = CodeUtility.getCode( CodeConstants.PROVIDER );
            }
            else if ( performerCode.equals( "PAT" ) )
            {
                performerProviderOrPatient = CodeUtility.getCode( CodeConstants.PATIENT );
            }
            final CategoryType c = new CategoryType();
            c.setTerm( performerCode );
            c.setScheme( CodeConstants.PERFORMER );
            category.add( c );
            categoryHashMap.put( CodeConstants.PERFORMER_KNOWLEDGE_USERTYPE_KEY, category );
            category = new ArrayList<CategoryType>();
        }
        this.setProviderOrPatient( performerProviderOrPatient );
        if ( requestParameters.containsKey( CodeConstants.PERFORMER_CODE ) )
        {
            performerHealthCareProvider.setCode( requestParameters.get( CodeConstants.PERFORMER_CODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.PERFORMER_CODE )[0] );
            c.setScheme( CodeConstants.PERFORMER_CODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.PERFORMER_CODESYSTEM ) )
        {
            performerHealthCareProvider.setCodeSystem( requestParameters.get( CodeConstants.PERFORMER_CODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.PERFORMER_CODESYSTEM )[0] );
            c.setScheme( CodeConstants.PERFORMER_CODESYSTEM );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.PERFORMER_DISPLAYNAME ) )
        {
            performerHealthCareProvider.setDisplayName( requestParameters.get( CodeConstants.PERFORMER_DISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.PERFORMER_DISPLAYNAME )[0] );
            c.setScheme( CodeConstants.PERFORMER_DISPLAYNAME );
            category.add( c );
        }
        categoryHashMap.put( CodeConstants.PERFORMER_DISCIPLINE_KEY, category );
        category = new ArrayList<CategoryType>();

        this.setHealthCareProvider( performerHealthCareProvider );
        if ( requestParameters.containsKey( CodeConstants.PERFORMER_LANGUAGECODE ) )
        {
            performerLanguage.setCode( requestParameters.get( CodeConstants.PERFORMER_LANGUAGECODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.PERFORMER_LANGUAGECODE )[0] );
            c.setScheme( CodeConstants.PERFORMER_LANGUAGECODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.PERFORMER_LANGUAGECODESYSTEM ) )
        {
            performerLanguage.setCodeSystem( requestParameters.get( CodeConstants.PERFORMER_LANGUAGECODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.PERFORMER_LANGUAGECODESYSTEM )[0] );
            c.setScheme( CodeConstants.PERFORMER_LANGUAGECODESYSTEM );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.PERFORMER_LANGUAGEDISPLAYNAME ) )
        {
            performerLanguage.setDisplayName( requestParameters.get( CodeConstants.PERFORMER_LANGUAGEDISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.PERFORMER_LANGUAGEDISPLAYNAME )[0] );
            c.setScheme( CodeConstants.PERFORMER_LANGUAGEDISPLAYNAME );
            category.add( c );
        }
        this.setLanguage( performerLanguage );
        categoryHashMap.put( CodeConstants.PERFORMER_LANGUAGE_KEY, category );
    }

    /**
     * Instantiates a new performer.
     */
    public Performer()
    {

        this( CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode() );
    }

    /**
     * Instantiates a new performer.
     *
     * @param performer the performer
     */
    public Performer( REDSMT010001UVPerformer performer )
    {
        this( CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode() );
        if ( performer.getHealthCareProvider() != null )
        {
            this.providerOrPatient = CodeUtility.getCode( "PROV", "2.16.840.1.113883.5.110", "Provider", "" );
            this.healthCareProvider = CodeUtility.getCode( performer.getHealthCareProvider().getValue().getCode() );
            this.language =
                CodeUtility.getCode( performer.getHealthCareProvider().getValue().
                                     getHealthCarePerson().getValue().getLanguageCommunication().get( 0 ).getLanguageCode() );
        }
        else if ( performer.getPatient() != null )
        {
            this.providerOrPatient = CodeUtility.getCode( "PAT", "2.16.840.1.113883.5.110", "Patient", "" );
            this.healthCareProvider = CodeUtility.getCode();
            ;
            this.language =
                CodeUtility.getCode( performer.getPatient().getValue().
                                     getPatientPerson().getValue().getLanguageCommunication().get( 0 ).getLanguageCode() );
        }
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public Code getLanguage()
    {

        return this.language;
    }

    /**
     * Gets the health care provider.
     *
     * @return the health care provider
     */
    public Code getHealthCareProvider()
    {

        return this.healthCareProvider;
    }

    /**
     * Sets the language.
     *
     * @param language the new language
     */
    public void setLanguage( Code language )
    {

        this.language = language;
    }

    /**
     * Sets the health care provider.
     *
     * @param healthCareProvider the new health care provider
     */
    public void setHealthCareProvider( Code healthCareProvider )
    {

        this.healthCareProvider = healthCareProvider;
    }

    /**
     * Gets the provider or patient.
     *
     * @return the provider or patient
     */
    public Code getProviderOrPatient()
    {
        return providerOrPatient;
    }

    /**
     * Sets the provider or patient.
     *
     * @param providerOrPatient the new provider or patient
     */
    public void setProviderOrPatient( Code providerOrPatient )
    {
        this.providerOrPatient = providerOrPatient;
    }

    /**
     * Gets the JAXB element.
     *
     * @param performer the performer
     * @return the JAXB element
     */
    public static JAXBElement<REDSMT010001UVPerformer> getJAXBElement( Performer performer )
    {

        final REDSMT010001UVPerformer element = new REDSMT010001UVPerformer();
        final REDSMT010001UVHealthCareProvider healthCareProvider = new REDSMT010001UVHealthCareProvider();
        final REDSMT010001UVPatient patient = new REDSMT010001UVPatient();
        final REDSMT010001UVPerson person = new REDSMT010001UVPerson();
        final REDSMT010001UVLanguageCommunication language = new REDSMT010001UVLanguageCommunication();
        if ( performer.getProviderOrPatient().getCode().equals( "PROV" ) )
        {
            language.setLanguageCode( CodeUtility.getJAXBElement( performer.getLanguage() ) );
            person.getLanguageCommunication().add( language );
            healthCareProvider.setCode( CodeUtility.getJAXBElement( performer.getHealthCareProvider() ) );
            healthCareProvider.setHealthCarePerson( new JAXBElement<REDSMT010001UVPerson>(
                                               new QName( "urn:hl7-org:v3", "healthCarePerson" ),
                                               REDSMT010001UVPerson.class,
                                               person ) );
            element.setHealthCareProvider( new JAXBElement<REDSMT010001UVHealthCareProvider>(
                                                new QName( "urn:hl7-org:v3","healthCareProvider" ),
                                                REDSMT010001UVHealthCareProvider.class,
                                                healthCareProvider ) );
        }
        else if ( performer.getProviderOrPatient().getCode().equals( "PAT" ) )
        {
            language.setLanguageCode( CodeUtility.getJAXBElement( performer.getLanguage() ) );
            person.getLanguageCommunication().add( language );
            patient.setPatientPerson( new JAXBElement<REDSMT010001UVPerson>( new QName( "urn:hl7-org:v3",
                                                                                        "patientPerson" ),
                                                                             REDSMT010001UVPerson.class, person ) );
            element.setPatient( new JAXBElement<REDSMT010001UVPatient>( new QName( "urn:hl7-org:v3", "patient" ),
                                                                        REDSMT010001UVPatient.class, patient ) );
        }
        final JAXBElement<REDSMT010001UVPerformer> jaxBElement =
            new JAXBElement<REDSMT010001UVPerformer>( new QName( "urn:hl7-org:v3", "performer" ),
                                                      REDSMT010001UVPerformer.class, element );
        return jaxBElement;
    }
}
