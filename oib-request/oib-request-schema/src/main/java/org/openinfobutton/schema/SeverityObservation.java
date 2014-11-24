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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.REDSMT010001UVSeverityObservation;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/**
 * The Class SeverityObservation.
 */
public class SeverityObservation
{

    /** The code. */
    private Code code;

    /**
     * Instantiates a new severity observation.
     *
     * @param code the code
     * @param codeSystem the code system
     * @param displayName the display name
     * @param codeSystemName the code system name
     */
    public SeverityObservation( String code, String codeSystem, String displayName, String codeSystemName )
    {
        this.code = CodeUtility.getCode( code, codeSystem, displayName, codeSystemName );
    }

    /**
     * Instantiates a new severity observation.
     *
     * @param code the code
     */
    public SeverityObservation( Code code )
    {
        this.code = code;
    }

    /**
     * Instantiates a new severity observation.
     *
     * @param severityObservation the severity observation
     */
    public SeverityObservation( REDSMT010001UVSeverityObservation severityObservation )
    {

        this.code = CodeUtility.getCode( severityObservation.getInterpretationCode() );
    }

    /**
     * Instantiates a new severity observation.
     */
    public SeverityObservation()
    {

        this( CodeUtility.getCode() );
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
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode( Code code )
    {

        this.code = code;
    }

    /**
     * Gets the JAXB element.
     *
     * @param severityObservation the severity observation
     * @return the JAXB element
     */
    public static JAXBElement<REDSMT010001UVSeverityObservation> getJAXBElement( SeverityObservation severityObservation )
    {
        final REDSMT010001UVSeverityObservation element = new REDSMT010001UVSeverityObservation();
        element.setInterpretationCode( CodeUtility.getJAXBElement( severityObservation.getCode() ) );
        final JAXBElement<REDSMT010001UVSeverityObservation> jaxBElement =
            new JAXBElement<REDSMT010001UVSeverityObservation>( new QName( "urn:hl7-org:v3", "severityObservation" ),
                                                                REDSMT010001UVSeverityObservation.class, element );
        return jaxBElement;
    }
}
