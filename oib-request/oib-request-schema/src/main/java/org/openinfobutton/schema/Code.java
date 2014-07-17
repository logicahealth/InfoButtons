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

import org.hl7.v3.CDLite;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1251          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2010-10-26 1#$:  Date of last commit
 */

/**
 * The Class Code.
 */
public class Code
{

    /** The code. */
    private String code;

    /** The code system. */
    private String codeSystem;

    /** The display name. */
    private String displayName;

    /** The code system name. */
    private String codeSystemName;

    /**
     * Instantiates a new code.
     *
     * @param code the code
     * @param codeSystem the code system
     * @param displayName the display name
     * @param codeSystemName the code system name
     */
    public Code( String code, String codeSystem, String displayName, String codeSystemName )
    {
        this.code = code;
        this.codeSystem = codeSystem;
        this.displayName = displayName;
        this.codeSystemName = codeSystemName;
    }

    /**
     * Instantiates a new code.
     *
     * @param code the code
     */
    public Code( CDLite code )
    {

        this( code.getCode(), code.getCodeSystem(), code.getDisplayName(), code.getCodeSystemName() );
    }

    /**
     * Instantiates a new code.
     *
     * @param code the code
     */
    public Code( Code code )
    {

        this( code.getSearchCode(), code.getCodeSystem(), code.getDisplayName(), code.getCodeSystemName() );
    }

    /**
     * Instantiates a new code.
     */
    public Code()
    {
        this( new String(), new String(), new String(), new String() );
    }

    /**
     * Gets the search code.
     *
     * @return the search code
     */
    public String getSearchCode()
    {
        return this.code;
    }

    /**
     * Gets the code system.
     *
     * @return the code system
     */
    public String getCodeSystem()
    {
        return this.codeSystem;
    }

    /**
     * Gets the display name.
     *
     * @return the display name
     */
    public String getDisplayName()
    {
        return this.displayName;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name
     */
    public String getCodeSystemName()
    {
        return this.codeSystemName;
    }

    /**
     * Sets the search code.
     *
     * @param searchCode the new search code
     */
    public void setSearchCode( String searchCode )
    {
        this.code = searchCode;
    }

    /**
     * Sets the code system.
     *
     * @param codeSystem the new code system
     */
    public void setCodeSystem( String codeSystem )
    {
        this.codeSystem = codeSystem;
    }

    /**
     * Sets the displayname.
     *
     * @param displayName the new displayname
     */
    public void setDisplayname( String displayName )
    {
        this.displayName = displayName;
    }

    /**
     * Sets the code system name.
     *
     * @param codeSystemName the new code system name
     */
    public void setCodeSystemName( String codeSystemName )
    {
        this.codeSystemName = codeSystemName;
    }

    /**
     * Gets the JAXB element.
     *
     * @param code the code
     * @return the JAXB element
     */
    public static CDLite getJAXBElement( Code code )
    {
        final CDLite jaxBElement = new CDLite();
        jaxBElement.setCode( code.getSearchCode() );
        jaxBElement.setCodeSystem( code.getCodeSystem() );
        jaxBElement.setDisplayName( code.getDisplayName() );
        jaxBElement.setCodeSystemName( code.getCodeSystemName() );
        return jaxBElement;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode( String code )
    {
        this.code = code;
    }

    /**
     * Sets the display name.
     *
     * @param displayName the new display name
     */
    public void setDisplayName( String displayName )
    {
        this.displayName = displayName;
    }

}
