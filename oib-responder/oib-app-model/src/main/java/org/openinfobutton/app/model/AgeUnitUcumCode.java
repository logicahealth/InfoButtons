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
package org.openinfobutton.app.model;

// TODO: Auto-generated Javadoc
/**
 * The Class AgeUnitUcumCode.
 *
 * @author rick
 */
public final class AgeUnitUcumCode
{

    /** The Constant MINUTE. */
    public final static String MINUTE = "min";

    /** The Constant HOUR. */
    public final static String HOUR = "h";

    /** The Constant DAY. */
    public final static String DAY = "d";

    /** The Constant WEEK. */
    public final static String WEEK = "wk";

    /** The Constant MONTH. */
    public final static String MONTH = "mo";

    /** The Constant YEAR. */
    public final static String YEAR = "a";

    /**
     * Instantiates a new age unit ucum code.
     */
    private AgeUnitUcumCode(){}
    
    /**
     * Checks if is valid code.
     *
     * @param code the code
     * @return true, if is valid code
     */
    public static boolean isValidCode( String code )
    {

        if ( MINUTE.equals( code ) || HOUR.equals( code ) || DAY.equals( code ) || WEEK.equals( code )
            || MONTH.equals( code ) || YEAR.equals( code ) )
        {
            return true;
        }

        return false;
    }
}
