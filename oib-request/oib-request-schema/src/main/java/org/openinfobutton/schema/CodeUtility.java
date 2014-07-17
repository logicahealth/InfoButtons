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
import org.hl7.v3.CategoryType;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/**
 * The Class CodeUtility.
 */
public final class CodeUtility
{

    /**
     * Instantiates a new code utility.
     */
    private CodeUtility(){}
    
    /**
     * Gets the code.
     *
     * @return the code
     */
    public static Code getCode()
    {
        final Code c = new Code();
        c.setCode( "" );
        c.setCodeSystem( "" );
        c.setCodeSystemName( "" );
        c.setDisplayName( "" );
        return c;
    }

    /**
     * Gets the code.
     *
     * @param cd the cd
     * @return the code
     */
    public static Code getCode( CDLite cd )
    {
        final Code c = new Code();
        c.setCode( cd.getCode() );
        c.setCodeSystem( cd.getCodeSystem() );
        c.setCodeSystemName( cd.getCodeSystemName() );
        c.setDisplayName( cd.getDisplayName() );
        return c;
    }

    /**
     * Gets the code.
     *
     * @param code the code
     * @param codeSystem the code system
     * @param displayName the display name
     * @param codeSystemName the code system name
     * @return the code
     */
    public static Code getCode( String code, String codeSystem, String displayName, String codeSystemName )
    {
        final Code c = new Code();
        c.setCode( code );
        c.setCodeSystem( codeSystem );
        c.setCodeSystemName( codeSystemName );
        c.setDisplayName( displayName );
        return c;
    }

    /**
     * Gets the code.
     *
     * @param cd the cd
     * @return the code
     */
    public static Code getCode( Code cd )
    {
        final Code c = new Code();
        c.setCode( cd.getCode() );
        c.setCodeSystem( cd.getCodeSystem() );
        c.setCodeSystemName( cd.getCodeSystemName() );
        c.setDisplayName( cd.getDisplayName() );
        return c;
    }

    /**
     * Gets the JAXB element.
     *
     * @param code the code
     * @return the JAXB element
     */
    public static CDLite getJAXBElement( Code code )
    {
        final CDLite jaxBElementCDLite = new CDLite();
        jaxBElementCDLite.setCode( code.getCode() );
        jaxBElementCDLite.setCodeSystem( code.getCodeSystem() );
        jaxBElementCDLite.setDisplayName( code.getDisplayName() );
        jaxBElementCDLite.setCodeSystemName( code.getCodeSystemName() );
        return jaxBElementCDLite;
    }

    /**
     * Convert into category type.
     *
     * @param term the term
     * @param scheme the scheme
     * @return the category type
     */
    public static CategoryType convertIntoCategoryType( String term, String scheme )
    {
        final CategoryType c = new CategoryType();
        c.setTerm( term );
        c.setScheme( scheme );
        return c;
    }
}
