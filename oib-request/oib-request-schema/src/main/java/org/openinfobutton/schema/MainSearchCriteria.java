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

import org.hl7.v3.CategoryType;
import org.hl7.v3.REDSMT010001UVMainSearchCriteria;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/**
 * The Class MainSearchCriteria.
 */
public class MainSearchCriteria
{

    /** The code. */
    private Code code;

    /** The severity observation. */
    private SeverityObservation severityObservation;

    /**
     * Instantiates a new main search criteria.
     *
     * @param code the code
     * @param codeSystem the code system
     * @param displayName the display name
     * @param codeSystemName the code system name
     * @param severityObservation the severity observation
     */
    public MainSearchCriteria( String code, String codeSystem, String displayName, String codeSystemName,
                               Code severityObservation )
    {
        this.code = CodeUtility.getCode( code, codeSystem, displayName, codeSystemName );
        this.severityObservation = new SeverityObservation( severityObservation );
    }

    /**
     * Instantiates a new main search criteria.
     *
     * @param code the code
     * @param severityObservation the severity observation
     */
    public MainSearchCriteria( Code code, SeverityObservation severityObservation )
    {
        this.code = code;
        this.severityObservation = severityObservation;
    }

    /**
     * Instantiates a new main search criteria.
     *
     * @param mainSearchCriteria the main search criteria
     */
    public MainSearchCriteria( REDSMT010001UVMainSearchCriteria mainSearchCriteria )
    {

        this.code = CodeUtility.getCode( mainSearchCriteria.getValue() );
        if ( mainSearchCriteria.getSeverityObservation() != null )
        {
            this.severityObservation = new SeverityObservation( mainSearchCriteria.getSeverityObservation().getValue() );
        }
        else
        {
            this.severityObservation = new SeverityObservation();
        }
    }
    
    /**
     * Instantiates a new main search criteria.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public MainSearchCriteria(Map<String, String[]> requestParameters, final Map<String, List<CategoryType>> categoryHashMap) {
        
        List<CategoryType> category = new ArrayList<CategoryType>();
        final Code mainsearchCode = CodeUtility.getCode( CodeUtility.getCode());
        if ( requestParameters.containsKey( CodeConstants.MAINSEARCH_CODE ) )
        {
            mainsearchCode.setCode( requestParameters.get( CodeConstants.MAINSEARCH_CODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.MAINSEARCH_CODE )[0] );
            c.setScheme( CodeConstants.MAINSEARCH_CODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.MAINSEARCH_CODESYSTEM ) )
        {
            mainsearchCode.setCodeSystem( requestParameters.get( CodeConstants.MAINSEARCH_CODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.MAINSEARCH_CODESYSTEM )[0] );
            c.setScheme( CodeConstants.MAINSEARCH_CODESYSTEM );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.MAINSEARCH_DISPLAYNAME ) )
        {
            mainsearchCode.setDisplayName( requestParameters.get( CodeConstants.MAINSEARCH_DISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.MAINSEARCH_DISPLAYNAME )[0] );
            c.setScheme( CodeConstants.MAINSEARCH_DISPLAYNAME );
            category.add( c );
        }
        this.setCode( mainsearchCode );
        // Set severity observation
        final Code severityobservation = CodeUtility.getCode();
        if ( requestParameters.containsKey( CodeConstants.SEVERITYOBSERVATION_CODE ) )
        {
            severityobservation.setCode( requestParameters.get( CodeConstants.SEVERITYOBSERVATION_CODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.SEVERITYOBSERVATION_CODE )[0] );
            c.setScheme( CodeConstants.SEVERITYOBSERVATION_CODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.SEVERITYOBSERVATION_CODESYSTEM ) )
        {
            severityobservation.setCodeSystemName( requestParameters.get( CodeConstants.SEVERITYOBSERVATION_CODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.SEVERITYOBSERVATION_CODESYSTEM )[0] );
            c.setScheme( CodeConstants.SEVERITYOBSERVATION_CODESYSTEM );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.SEVERITYOBSERVATION_DISPLAYNAME ) )
        {
            severityobservation.setDisplayName( requestParameters.get( CodeConstants.SEVERITYOBSERVATION_DISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.SEVERITYOBSERVATION_DISPLAYNAME )[0] );
            c.setScheme( CodeConstants.SEVERITYOBSERVATION_DISPLAYNAME );
            category.add( c );
        }
        this.setSeverityObservation(new SeverityObservation( severityobservation ));
        categoryHashMap.put( CodeConstants.CONCEPT_OF_INTEREST_KEY, category );
    }

    /**
     * Instantiates a new main search criteria.
     */
    public MainSearchCriteria()
    {

        this( CodeUtility.getCode(), new SeverityObservation() );
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
     * Gets the severity observation.
     *
     * @return the severity observation
     */
    public SeverityObservation getSeverityObservation()
    {

        return this.severityObservation;
    }

    /**
     * Sets the severity observation.
     *
     * @param severityObservation the new severity observation
     */
    public void setSeverityObservation( SeverityObservation severityObservation )
    {

        this.severityObservation = severityObservation;
    }

    /**
     * Gets the JAXB element.
     *
     * @param mainSearchCriteria the main search criteria
     * @return the JAXB element
     */
    public static REDSMT010001UVMainSearchCriteria getJAXBElement( MainSearchCriteria mainSearchCriteria )
    {
        final REDSMT010001UVMainSearchCriteria jaxBElement = new REDSMT010001UVMainSearchCriteria();
        jaxBElement.setValue( CodeUtility.getJAXBElement( mainSearchCriteria.getCode() ) );
        jaxBElement.setSeverityObservation( SeverityObservation.getJAXBElement( mainSearchCriteria.getSeverityObservation() ) );
        return jaxBElement;
    }
}
