package org.openinfobutton.app.model;

/**
 *
 * @author rick
 */
public class AgeGroupMeshCode {

    public final static String MESH_CODE_SYSTEM_OID = "2.16.840.1.113883.6.177";
    
    public final static String BIRTH_TO_1_MONTH = "D007231";
    public final static String ONE_TO_23_MONTHS = "D007223";
    public final static String PRESCHOOL_2_TO_5_YEARS = "D002675";
    public final static String CHILD_6_TO_12_YEARS = "D002648";
    public final static String ADOLESCENT_13_TO_18_YEARS = "D000293";
    public final static String YOUNG_ADULT_19_TO_24_YEARS = "D055815";
    public final static String ADULT_19_TO_44_YEARS = "D000328";
    public final static String AGED_56_TO_79_YEARS = "D000368";
    public final static String MIDDLE_AGED_45_TO_64_YEARS = "D008875";
    public final static String OLD_80_YEARS_AND_ABOVE = "D000369";

    public static boolean isValidCode(String code) {

        if (BIRTH_TO_1_MONTH.equals(code)
                || ONE_TO_23_MONTHS.equals(code)
                || PRESCHOOL_2_TO_5_YEARS.equals(code)
                || ADOLESCENT_13_TO_18_YEARS.equals(code)
                || YOUNG_ADULT_19_TO_24_YEARS.equals(code)
                || ADULT_19_TO_44_YEARS.equals(code)
                || AGED_56_TO_79_YEARS.equals(code)
                || MIDDLE_AGED_45_TO_64_YEARS.equals(code)
                || OLD_80_YEARS_AND_ABOVE.equals(code)) {

            return true;
        }

        return false;
    }
}
