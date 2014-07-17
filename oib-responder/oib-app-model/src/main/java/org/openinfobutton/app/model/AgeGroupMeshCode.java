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

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

// TODO: Auto-generated Javadoc
/**
 * The Class AgeGroupMeshCode.
 *
 * @author rick
 */
public final class AgeGroupMeshCode
{

    /** The Constant MESH_CODE_SYSTEM_OID. */
    public final static String MESH_CODE_SYSTEM_OID = "2.16.840.1.113883.6.177";

    /** The Constant BIRTH_TO_1_MONTH. */
    public final static String BIRTH_TO_1_MONTH = "D007231";

    /** The Constant ONE_TO_23_MONTHS. */
    public final static String ONE_TO_23_MONTHS = "D007223";

    /** The Constant PRESCHOOL_2_TO_5_YEARS. */
    public final static String PRESCHOOL_2_TO_5_YEARS = "D002675";

    /** The Constant CHILD_6_TO_12_YEARS. */
    public final static String CHILD_6_TO_12_YEARS = "D002648";

    /** The Constant ADOLESCENT_13_TO_18_YEARS. */
    public final static String ADOLESCENT_13_TO_18_YEARS = "D000293";

    /** The Constant YOUNG_ADULT_19_TO_24_YEARS. */
    public final static String YOUNG_ADULT_19_TO_24_YEARS = "D055815";

    /** The Constant ADULT_19_TO_44_YEARS. */
    public final static String ADULT_19_TO_44_YEARS = "D000328";

    /** The Constant MIDDLE_AGED_45_TO_64_YEARS. */
    public final static String MIDDLE_AGED_45_TO_64_YEARS = "D008875";

    /** The Constant AGED_56_TO_79_YEARS. */
    public final static String AGED_56_TO_79_YEARS = "D000368";

    /** The Constant OLD_80_YEARS_AND_ABOVE. */
    public final static String OLD_80_YEARS_AND_ABOVE = "D000369";
    
    /** The Constant MAX_HUMAN_AGE_IN_YEARS. */
    public final static int MAX_HUMAN_AGE_IN_YEARS = 110;
    
    /** The Constant AGE_RANGES. */
    @SuppressWarnings( "boxing" )
    public static final NavigableMap<Integer,String> AGE_RANGES = new TreeMap<Integer, String>() 
    {
        {
            put(0, BIRTH_TO_1_MONTH);
            put(1, ONE_TO_23_MONTHS);
            put(2, PRESCHOOL_2_TO_5_YEARS);
            put(6, CHILD_6_TO_12_YEARS);
            put(13, ADOLESCENT_13_TO_18_YEARS);
            put(19, YOUNG_ADULT_19_TO_24_YEARS);
            put(25, ADULT_19_TO_44_YEARS);
            put(45, MIDDLE_AGED_45_TO_64_YEARS);
            put(56, AGED_56_TO_79_YEARS);
            put(80, OLD_80_YEARS_AND_ABOVE);
        }
    };
    
    
    /**
     * Instantiates a new age group mesh code.
     */
    private AgeGroupMeshCode() {}

    /**
     * Checks if is valid code.
     *
     * @param code the code
     * @return true, if is valid code
     */
    public static boolean isValidCode( String code )
    {

        if ( BIRTH_TO_1_MONTH.equals( code ) || ONE_TO_23_MONTHS.equals( code ) || PRESCHOOL_2_TO_5_YEARS.equals( code )
            || ADOLESCENT_13_TO_18_YEARS.equals( code ) || YOUNG_ADULT_19_TO_24_YEARS.equals( code )
            || ADULT_19_TO_44_YEARS.equals( code ) || AGED_56_TO_79_YEARS.equals( code )
            || MIDDLE_AGED_45_TO_64_YEARS.equals( code ) || OLD_80_YEARS_AND_ABOVE.equals( code ) )
        {

            return true;
        }

        return false;
    }
}
