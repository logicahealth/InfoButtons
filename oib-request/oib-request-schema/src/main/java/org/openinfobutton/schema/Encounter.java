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
import org.hl7.v3.REDSMT010001UVEncounter;
import org.hl7.v3.REDSMT010001UVServiceDeliveryLocation;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1097          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2010-10-01 1#$:  Date of last commit
 */

/**
 * The Class Encounter.
 */
public class Encounter
{

    /** The code. */
    private Code code;

    /** The service delivery location. */
    private IDLite serviceDeliveryLocation;

    /**
     * Instantiates a new encounter.
     *
     * @param code the code
     * @param serviceDeliveryLocation the service delivery location
     */
    public Encounter( Code code, IDLite serviceDeliveryLocation )
    {

        this.code = code;
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

    /**
     * Instantiates a new encounter.
     */
    public Encounter()
    {

        this( CodeUtility.getCode(), new IDLite() );
    }
    
    /**
     * Instantiates a new encounter.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public Encounter(Map<String, String[]> requestParameters, final Map<String, List<CategoryType>> categoryHashMap) {

        List<CategoryType> category = new ArrayList<CategoryType>();
        this.code = CodeUtility.getCode( CodeConstants.ENCOUNTER );
        this.serviceDeliveryLocation = new IDLite();
        if ( requestParameters.containsKey( CodeConstants.ENCOUNTER_CODE ) )
        {
            this.code.setCode( requestParameters.get( CodeConstants.ENCOUNTER_CODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.ENCOUNTER_CODE )[0] );
            c.setScheme( CodeConstants.ENCOUNTER_CODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.ENCOUNTER_CODESYSTEM ) )
        {
            this.code.setCodeSystemName( requestParameters.get( CodeConstants.ENCOUNTER_CODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.ENCOUNTER_CODESYSTEM )[0] );
            c.setScheme( CodeConstants.ENCOUNTER_CODESYSTEM );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.ENCOUNTER_DISPLAYNAME ) )
        {
            this.code.setDisplayName( requestParameters.get( CodeConstants.ENCOUNTER_DISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.ENCOUNTER_DISPLAYNAME )[0] );
            c.setScheme( CodeConstants.ENCOUNTER_DISPLAYNAME );
            category.add( c );
        }
        this.setCode( this.code );
        if ( requestParameters.containsKey( CodeConstants.ENCOUNTER_SERVICEDELIVERYLOCATION ) )
        {
            this.serviceDeliveryLocation.setRoot( requestParameters.get( CodeConstants.ENCOUNTER_SERVICEDELIVERYLOCATION )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.ENCOUNTER_SERVICEDELIVERYLOCATION )[0] );
            c.setScheme( CodeConstants.ENCOUNTER_SERVICEDELIVERYLOCATION );
            category.add( c );
        }
        this.setServiceDeliveryLocation( this.serviceDeliveryLocation );
        categoryHashMap.put( CodeConstants.ENCOUNTER_KEY, category );
    }

    /**
     * Instantiates a new encounter.
     *
     * @param encounter the encounter
     */
    public Encounter( REDSMT010001UVEncounter encounter )
    {

        final JAXBElement<REDSMT010001UVServiceDeliveryLocation> element = encounter.getServiceDeliveryLocation();
        final REDSMT010001UVServiceDeliveryLocation serviceDeliveryLocation = element.getValue();
        this.code = CodeUtility.getCode( encounter.getCode() );
        this.serviceDeliveryLocation = new IDLite( serviceDeliveryLocation.getId() );
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public Code getCode()
    {

        return this.code;
    }

    /**
     * Gets the service delivery location.
     *
     * @return the service delivery location
     */
    public IDLite getServiceDeliveryLocation()
    {

        return this.serviceDeliveryLocation;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode( Code code )
    {

        this.code = code;
    }

    /**
     * Sets the service delivery location.
     *
     * @param serviceDeliveryLocation the new service delivery location
     */
    public void setServiceDeliveryLocation( IDLite serviceDeliveryLocation )
    {

        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

    /**
     * Gets the JAXB element.
     *
     * @param encounter the encounter
     * @return the JAXB element
     */
    public static JAXBElement<REDSMT010001UVEncounter> getJAXBElement( Encounter encounter )
    {

        final REDSMT010001UVEncounter element = new REDSMT010001UVEncounter();
        element.setCode( CodeUtility.getJAXBElement( encounter.getCode() ) );
        final REDSMT010001UVServiceDeliveryLocation serviceDeliveryLocation =
            new REDSMT010001UVServiceDeliveryLocation();
        serviceDeliveryLocation.setId( IDLite.getJAXBElement( encounter.getServiceDeliveryLocation() ) );
        final JAXBElement<REDSMT010001UVServiceDeliveryLocation> sdl =
            new JAXBElement<REDSMT010001UVServiceDeliveryLocation>( new QName( "urn:hl7-org:v3",
                                                                               "serviceDeliveryLocation" ),
                                                                    REDSMT010001UVServiceDeliveryLocation.class,
                                                                    serviceDeliveryLocation );
        element.setServiceDeliveryLocation( sdl );
        final JAXBElement<REDSMT010001UVEncounter> jaxBElement =
            new JAXBElement<REDSMT010001UVEncounter>( new QName( "urn:hl7-org:v3", "encounter" ),
                                                      REDSMT010001UVEncounter.class, element );
        return jaxBElement;
    }
}
