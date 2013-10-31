package org.openinfobutton.app.helper;

import java.util.ArrayList;
import java.util.List;
import org.openinfobutton.app.model.AgeGroupMeshCode;
import org.openinfobutton.app.model.AgeUnitUcumCode;
import org.openinfobutton.app.model.Code;

/**
 *
 * @author rick
 */
public class AgeToAgeGroupConversionHelper {

    public final static int MAX_HUMAN_AGE_IN_YEARS = 110;

    public static boolean isValidAgeAndUnits(int age, String ageUnitsUcumCode) {

        if (age < 0) {
            return false;
        }
        if (!AgeUnitUcumCode.isValidCode(ageUnitsUcumCode)) {
            return false;
        }
        if (AgeUnitUcumCode.YEAR.equals(ageUnitsUcumCode) && age > MAX_HUMAN_AGE_IN_YEARS) {
            return false;
        }
        if (AgeUnitUcumCode.MONTH.equals(ageUnitsUcumCode) && age > (MAX_HUMAN_AGE_IN_YEARS * 12)) {
            return false;
        }
        if (AgeUnitUcumCode.WEEK.equals(ageUnitsUcumCode) && age > (MAX_HUMAN_AGE_IN_YEARS * 52)) {
            return false;
        }
        if (AgeUnitUcumCode.DAY.equals(ageUnitsUcumCode) && age > (MAX_HUMAN_AGE_IN_YEARS * 52 * 7)) {
            return false;
        }
        if (AgeUnitUcumCode.HOUR.equals(ageUnitsUcumCode) && age > (MAX_HUMAN_AGE_IN_YEARS * 24 * 365)) {
            return false;
        }
        if (AgeUnitUcumCode.HOUR.equals(ageUnitsUcumCode) && age > (MAX_HUMAN_AGE_IN_YEARS * 24 * 365 * 60)) {
            return false;
        }

        return true;
    }

    public static List<Code> ageToAgeGroup(int age, String ageUnitsUcumCode) {

        if (AgeUnitUcumCode.YEAR.equals(ageUnitsUcumCode)) {

            return ageInYearsToAgeGroupCode(age);

        } else if (AgeUnitUcumCode.MONTH.equals(ageUnitsUcumCode)) {

            return ageInMonthsToAgeGroupCode(age);

        } else if (AgeUnitUcumCode.WEEK.equals(ageUnitsUcumCode)) {

            return ageInWeeksToAgeGroupCode(age);

        } else if (AgeUnitUcumCode.DAY.equals(ageUnitsUcumCode)) {

            return ageInDaysToAgeGroupCode(age);

        } else if (AgeUnitUcumCode.HOUR.equals(ageUnitsUcumCode)) {

            return ageInHoursToGroupCode(age);

        } else if (AgeUnitUcumCode.MINUTE.equals(ageUnitsUcumCode)) {

            int ageInHours = age / 60;
            return ageInHoursToGroupCode(ageInHours);

        }

        return null;
    }

    public static List<Code> ageInYearsToAgeGroupCode(int ageInYears) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInYears >= 0 && ageInYears < 2) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        } else if (ageInYears >= 2 && ageInYears <= 5) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.PRESCHOOL_2_TO_5_YEARS));
        } else if (ageInYears >= 6 && ageInYears <= 12) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.CHILD_6_TO_12_YEARS));
        } else if (ageInYears >= 13 && ageInYears <= 18) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ADOLESCENT_13_TO_18_YEARS));
        } else if (ageInYears >= 19 && ageInYears <= 24) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.YOUNG_ADULT_19_TO_24_YEARS));
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ADULT_19_TO_44_YEARS));
        } else if (ageInYears >= 25 && ageInYears <= 44) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ADULT_19_TO_44_YEARS));
        } else if (ageInYears >= 45 && ageInYears <= 55) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.MIDDLE_AGED_45_TO_64_YEARS));
        } else if (ageInYears >= 56 && ageInYears <= 64) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.MIDDLE_AGED_45_TO_64_YEARS));
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.AGED_56_TO_79_YEARS));
        } else if (ageInYears >= 65 && ageInYears <= 79) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.AGED_56_TO_79_YEARS));
        } else if (ageInYears >= 80) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.OLD_80_YEARS_AND_ABOVE));
        }

        return codes;
    }

    public static List<Code> ageInMonthsToAgeGroupCode(int ageInMonths) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInMonths < 1) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInMonths >= 1 && ageInMonths <= 23) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        } else if (ageInMonths > 23) {
            int ageInYears = ageInMonths / 12;
            return ageInYearsToAgeGroupCode(ageInYears);
        }

        return codes;
    }

    public static List<Code> ageInWeeksToAgeGroupCode(int ageInWeeks) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInWeeks >= 0 && ageInWeeks <= 4) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInWeeks > 4 && ageInWeeks <= (52 * 2 - 4)) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        } else if (ageInWeeks > (52 * 2 - 4)) {
            int ageInYears = ageInWeeks / 52;
            return ageInYearsToAgeGroupCode(ageInYears);
        }

        return codes;

    }

    public static List<Code> ageInDaysToAgeGroupCode(int ageInDays) {

        List<Code> codes = new ArrayList<Code>();
        
        if (ageInDays >= 0 && ageInDays <= 30) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInDays >= 31) {
            int ageInMonths = ageInDays / 31;
            return ageInMonthsToAgeGroupCode(ageInMonths);
        }

        return codes;
    }

    public static List<Code> ageInHoursToGroupCode(int ageInHours) {

        List<Code> codes = new ArrayList<Code>();
        
        if (ageInHours >= 0 && ageInHours <= (24 * 30)) { // <= 30 days
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInHours > (24 * 30)) {
            int ageInDays = ageInHours / 24;
            return ageInDaysToAgeGroupCode(ageInDays);
        }

        return codes;

    }
}
