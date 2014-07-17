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
import org.hl7.v3.REDSMT010001UVInformationRecipient;
import org.hl7.v3.REDSMT010001UVLanguageCommunication;
import org.hl7.v3.REDSMT010001UVPatient;
import org.hl7.v3.REDSMT010001UVPerson;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/**
 * The Class InformationRecipient.
 */
public class InformationRecipient
{

    /** The language. */
    private Code language;

    /** The health care provider. */
    private Code healthCareProvider;

    /** The provider or patient. */
    private Code providerOrPatient;

    /**
     * Instantiates a new information recipient.
     *
     * @param language the language
     * @param healthCareProvider the health care provider
     * @param providerOrPatient the provider or patient
     */
    public InformationRecipient( Code language, Code healthCareProvider, Code providerOrPatient )
    {

        this.language = language;
        this.healthCareProvider = healthCareProvider;
        this.providerOrPatient = providerOrPatient;
    }

    /**
     * Instantiates a new information recipient.
     */
    public InformationRecipient()
    {

        this( CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode() );
    }
    
    /**
     * Instantiates a new information recipient.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public InformationRecipient(Map<String, String[]> requestParameters, 
                                final Map<String, List<CategoryType>> categoryHashMap) {

        List<CategoryType> category = new ArrayList<CategoryType>();
        final Code language = CodeUtility.getCode( CodeConstants.LANGUAGE );
        final Code healthCareProvider = CodeUtility.getCode();
        Code providerOrPatient = CodeUtility.getCode();
        if ( requestParameters.containsKey( CodeConstants.INFORMATIONRECIPIENT ) )
        {
            final String informationRecipientCode = requestParameters.get( CodeConstants.INFORMATIONRECIPIENT )[0];
            if ( informationRecipientCode.equals( "PROV" ) )
            {
                providerOrPatient = CodeUtility.getCode( CodeConstants.PROVIDER );
            }
            else if ( informationRecipientCode.equals( "PAT" ) )
            {
                providerOrPatient = CodeUtility.getCode( CodeConstants.PATIENT );
            }
            final CategoryType c = new CategoryType();
            c.setTerm( informationRecipientCode );
            c.setScheme( CodeConstants.INFORMATIONRECIPIENT );
            category.add( c );
            categoryHashMap.put( CodeConstants.INFORMATION_RECIPIENT_USERTYPE_KEY, category );
            category = new ArrayList<CategoryType>();
        }
        this.setProviderOrPatient( providerOrPatient );
        if ( requestParameters.containsKey( CodeConstants.INFORMATIONRECIPIENT_CODE ) )
        {
            healthCareProvider.setCode( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_CODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_CODE )[0] );
            c.setScheme( CodeConstants.INFORMATIONRECIPIENT_CODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.INFORMATIONRECIPIENT_CODESYSTEM ) )
        {
            healthCareProvider.setCodeSystem( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_CODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_CODESYSTEM )[0] );
            c.setScheme( CodeConstants.INFORMATIONRECIPIENT_CODESYSTEM );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.INFORMATIONRECIPIENT_DISPLAYNAME ) )
        {
            healthCareProvider.setDisplayName( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_DISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_DISPLAYNAME )[0] );
            c.setScheme( CodeConstants.INFORMATIONRECIPIENT_DISPLAYNAME );
            category.add( c );
        }
        this.setHealthCareProvider( healthCareProvider );
        categoryHashMap.put( CodeConstants.INFORMATION_RECIPIENT_DISCIPLINE_KEY, category );
        category = new ArrayList<CategoryType>();

        if ( requestParameters.containsKey( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODE ) )
        {
            language.setCode( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODE )[0] );
            c.setScheme( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODESYSTEM ) )
        {
            language.setCodeSystem( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODESYSTEM )[0] );
            c.setScheme( CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODESYSTEM );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME ) )
        {
            language.setDisplayName( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME )[0] );
            c.setScheme( CodeConstants.INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME );
            category.add( c );
        }
        this.setLanguage( language );
        categoryHashMap.put( CodeConstants.INFORMATION_RECIPIENT_LANGUAGE_KEY, category );
    }

    /**
     * Instantiates a new information recipient.
     *
     * @param informationRecipient the information recipient
     */
    public InformationRecipient( REDSMT010001UVInformationRecipient informationRecipient )
    {
        this( CodeUtility.getCode(), CodeUtility.getCode(), CodeUtility.getCode() );
        if ( informationRecipient.getHealthCareProvider() != null )
        {
            this.providerOrPatient = CodeUtility.getCode( "PROV", "2.16.840.1.113883.5.110", "Provider", "" );
            this.healthCareProvider =
                CodeUtility.getCode( informationRecipient.getHealthCareProvider().getValue().getCode() );
            this.language =
                CodeUtility.getCode( informationRecipient.getHealthCareProvider().getValue().
                                     getHealthCarePerson().getValue().getLanguageCommunication().get( 0 ).getLanguageCode() );
        }
        else if ( informationRecipient.getPatient() != null )
        {
            this.providerOrPatient = CodeUtility.getCode( "PAT", "2.16.840.1.113883.5.110", "Patient", "" );
            this.healthCareProvider = null;
            this.language =
                CodeUtility.getCode( informationRecipient.getPatient().getValue().
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
     * @param informationRecipient the information recipient
     * @return the JAXB element
     */
    public static JAXBElement<REDSMT010001UVInformationRecipient> getJAXBElement( InformationRecipient informationRecipient )
    {

        final REDSMT010001UVInformationRecipient element = new REDSMT010001UVInformationRecipient();
        final REDSMT010001UVHealthCareProvider healthCareProvider = new REDSMT010001UVHealthCareProvider();
        final REDSMT010001UVPatient patient = new REDSMT010001UVPatient();
        final REDSMT010001UVPerson person = new REDSMT010001UVPerson();
        final REDSMT010001UVLanguageCommunication language = new REDSMT010001UVLanguageCommunication();
        if ( informationRecipient.getProviderOrPatient().getCode().equals( "PROV" ) )
        {
            language.setLanguageCode( CodeUtility.getJAXBElement( informationRecipient.getLanguage() ) );
            person.getLanguageCommunication().add( language );
            healthCareProvider.setCode( CodeUtility.getJAXBElement( informationRecipient.getHealthCareProvider() ) );
            healthCareProvider.setHealthCarePerson( new JAXBElement<REDSMT010001UVPerson>(
                                                       new QName( "urn:hl7-org:v3","healthCarePerson" ),
                                                       REDSMT010001UVPerson.class,
                                                       person ) );
            element.setHealthCareProvider( new JAXBElement<REDSMT010001UVHealthCareProvider>(
                                                      new QName("urn:hl7-org:v3","healthCareProvider" ),
                                                      REDSMT010001UVHealthCareProvider.class,
                                                      healthCareProvider ) );
        }
        else if ( informationRecipient.getProviderOrPatient().getCode().equals( "PAT" ) )
        {
            language.setLanguageCode( CodeUtility.getJAXBElement( informationRecipient.getLanguage() ) );
            person.getLanguageCommunication().add( language );
            patient.setPatientPerson( new JAXBElement<REDSMT010001UVPerson>( new QName( "urn:hl7-org:v3",
                                                                                        "patientPerson" ),
                                                                             REDSMT010001UVPerson.class, person ) );
            element.setPatient( new JAXBElement<REDSMT010001UVPatient>( new QName( "urn:hl7-org:v3", "patient" ),
                                                                        REDSMT010001UVPatient.class, patient ) );
        }
        final JAXBElement<REDSMT010001UVInformationRecipient> jaxBElement =
            new JAXBElement<REDSMT010001UVInformationRecipient>( new QName( "urn:hl7-org:v3", "informationRecipient" ),
                                                                 REDSMT010001UVInformationRecipient.class, element );
        return jaxBElement;
    }
}