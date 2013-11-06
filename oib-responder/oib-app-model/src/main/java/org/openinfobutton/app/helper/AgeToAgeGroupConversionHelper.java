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
    public final static int MAX_MONTHS_CONVERSION = 60; // 5 years
    public final static int MAX_WEEKS_CONVERSION = 5 * 52; // 5 years
    public final static int MAX_DAYS_CONVERSION = 5 * 365; // 5 years
    public final static int MAX_HOURS_CONVERSION = 30 * 24; // 30 days
    public final static int MAX_MINUTES_CONVERSION = 60 * 24 * 30; // 30 days
    public final static int MAX_WEEKS_IN_23_MONTHS = (52 * 2 - 1); // any # of weeks less than 2 years

    public static boolean isValidAgeAndUnits(int age, String ageUnitsUcumCode) {
        
        if (age < 0) {
            return false;
        }

        try {
            List<Code> convertedAgeCodes = ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
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

            return ageInMinutesToGroupCode( age );

        }

        return null;
    }

    public static List<Code> ageInYearsToAgeGroupCode(int ageInYears) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInYears == 0) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInYears == 1) {
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
        } else if (ageInYears >= 80 && ageInYears <= MAX_HUMAN_AGE_IN_YEARS) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.OLD_80_YEARS_AND_ABOVE));
        } else {
            throw new IllegalArgumentException("age " + ageInYears
                    + " years is out of range for conversion.  The maximium value supported is " + MAX_HUMAN_AGE_IN_YEARS + ".");
        }

        return codes;
    }

    public static List<Code> ageInWeeksToAgeGroupCode(int ageInWeeks) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInWeeks >= 0 && ageInWeeks <= 4) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInWeeks > 4 && ageInWeeks <= MAX_WEEKS_IN_23_MONTHS) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        } else if (ageInWeeks > MAX_WEEKS_IN_23_MONTHS && ageInWeeks <= MAX_WEEKS_CONVERSION) {
            int ageInYears = ageInWeeks / 52;
            return ageInYearsToAgeGroupCode(ageInYears);
        } else {
            throw new IllegalArgumentException("age " + ageInWeeks
                    + " weeks is out of range for conversion.  The maximium value supported is " + MAX_WEEKS_CONVERSION + ".");
        }

        return codes;
    }

    public static List<Code> ageInMonthsToAgeGroupCode(int ageInMonths) {
        
        List<Code> codes = new ArrayList<Code>();

        if (ageInMonths >= 0 && ageInMonths < 1) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInMonths >= 1 && ageInMonths <= 23) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        } else if (ageInMonths > 23 && ageInMonths <= MAX_MONTHS_CONVERSION) {
            int ageInYears = ageInMonths / 12;
            return ageInYearsToAgeGroupCode(ageInYears);
        } else {
            throw new IllegalArgumentException("age " + ageInMonths
                    + " months is out of range for conversion.  The maximium value supported is " + MAX_MONTHS_CONVERSION + ".");
        }

        return codes;
    }

    public static List<Code> ageInDaysToAgeGroupCode(int ageInDays) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInDays >= 0 && ageInDays < 35) { // 1 days less than 5 weeks converts to a month
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInDays >= 35 && ageInDays <= MAX_DAYS_CONVERSION) { // otherwise use weeks conversion
            int ageInWeeks = ageInDays / 7;
            return ageInWeeksToAgeGroupCode(ageInWeeks);
        } else {
            throw new IllegalArgumentException("age " + ageInDays
                    + " days is out of range for conversion.  The maximium value supported is " + MAX_DAYS_CONVERSION + ".");
        }

        return codes;
    }

    public static List<Code> ageInHoursToGroupCode(int ageInHours) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInHours >= 0 && ageInHours < (24 * 35)) { // < 35 days -> anything less than 5 weeks
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInHours >= (24 * 35) && ageInHours < MAX_HOURS_CONVERSION) { // otherwise use days conversion
            int ageInDays = ageInHours / 24;
            return ageInDaysToAgeGroupCode(ageInDays);
        } else {
            throw new IllegalArgumentException("age " + ageInHours
                    + " hours is out of range for conversion.  The maximium value supported is " + MAX_HOURS_CONVERSION + ".");
        }

        return codes;
    }

    public static List<Code> ageInMinutesToGroupCode(int ageInMinutes) {

        List<Code> codes = new ArrayList<Code>();

        if (ageInMinutes >= 0 && ageInMinutes < (60 * 24 * 35)) { // < 35 days -> anything less than 5 weeks
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInMinutes >= (60 * 24 * 35) && ageInMinutes < MAX_MINUTES_CONVERSION) { // otherwise use days conversion
            int ageInHours = ageInMinutes / 60;
            return ageInHoursToGroupCode(ageInHours);
        } else {
            throw new IllegalArgumentException("age " + ageInMinutes
                    + " hours is out of range for conversion.  The maximium value supported is " + MAX_HOURS_CONVERSION + ".");
        }

        return codes;
    }

}
