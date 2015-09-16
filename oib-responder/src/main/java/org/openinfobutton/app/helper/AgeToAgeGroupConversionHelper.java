package org.openinfobutton.app.helper;

/*
 * #%L
 * Project:  oib-app-model
 * Director: Guilherme Del Fiol, MD, PhD
 *           University of Utah
 *           Biomedical Informatics
 *           421 Wakara Way, Suite 140
 *           Salt Lake City, UT 84108-3514
 * Phone:    801-581-4080
 * %%
 * Copyright (C) 2010 - 2014 University of Utah
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.List;
import org.openinfobutton.app.model.AgeGroupMeshCode;
import org.openinfobutton.app.model.AgeUnitUcumCode;
import org.openinfobutton.app.model.Code;

/**
 * The Class AgeToAgeGroupConversionHelper.
 *
 * @author rick
 */
public final class AgeToAgeGroupConversionHelper {

    /**
     * The Constant MAX_HUMAN_AGE_IN_YEARS.
     */
    public final static int MAX_HUMAN_AGE_IN_YEARS = 110;

    /**
     * The Constant MAX_MONTHS_CONVERSION.
     */
    public final static int MAX_MONTHS_CONVERSION = 60; // 5 years

    /**
     * The Constant MAX_WEEKS_CONVERSION.
     */
    public final static int MAX_WEEKS_CONVERSION = 5 * 52; // 5 years

    /**
     * The Constant MAX_DAYS_CONVERSION.
     */
    public final static int MAX_DAYS_CONVERSION = 5 * 365; // 5 years

    /**
     * The Constant MAX_HOURS_CONVERSION.
     */
    public final static int MAX_HOURS_CONVERSION = 30 * 24; // 30 days

    /**
     * The Constant MAX_MINUTES_CONVERSION.
     */
    public final static int MAX_MINUTES_CONVERSION = 60 * 24 * 30; // 30 days

    /**
     * The Constant MAX_WEEKS_IN_23_MONTHS.
     */
    public final static int MAX_WEEKS_IN_23_MONTHS = (52 * 2 - 1); // any # of weeks less than 2 years

    /**
     * Instantiates a new age to age group conversion helper.
     */
    private AgeToAgeGroupConversionHelper() {
    }

    /**
     * Checks if is valid age and units.
     *
     * @param age the age
     * @param ageUnitsUcumCode the age units ucum code
     * @return true, if is valid age and units
     */
    public static boolean isValidAgeAndUnits(int age, String ageUnitsUcumCode) {

        if (age < 0) {
            return false;
        }

        try {
            final List<Code> convertedAgeCodes = ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (final IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    /**
     * Age to age group.
     *
     * @param age the age
     * @param ageUnitsUcumCode the age units ucum code
     * @return the list
     */
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

            return ageInMinutesToGroupCode(age);

        }

        return null;
    }

    /**
     * Age in years to age group code.
     *
     * @param ageInYears the age in years
     * @return the list
     */
    public static List<Code> ageInYearsToAgeGroupCode(int ageInYears) {

        final List<Code> codes = new ArrayList<Code>();
        if (ageInYears >= 19 && ageInYears <= 24) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.YOUNG_ADULT_19_TO_24_YEARS));
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ADULT_19_TO_44_YEARS));
        } else if (ageInYears >= 56 && ageInYears <= 64) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.MIDDLE_AGED_45_TO_64_YEARS));
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.AGED_56_TO_79_YEARS));
        } else if (ageInYears >= 0 && ageInYears <= MAX_HUMAN_AGE_IN_YEARS) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID,
                    AgeGroupMeshCode.AGE_RANGES.
                    get(AgeGroupMeshCode.AGE_RANGES.floorKey(ageInYears))
            ));
        } else {
            throw new IllegalArgumentException("age " + ageInYears
                    + " years is out of range for conversion.  The maximium value supported is " + MAX_HUMAN_AGE_IN_YEARS
                    + ".");
        }

        return codes;
    }

    /**
     * Age in weeks to age group code.
     *
     * @param ageInWeeks the age in weeks
     * @return the list
     */
    public static List<Code> ageInWeeksToAgeGroupCode(int ageInWeeks) {

        final List<Code> codes = new ArrayList<Code>();

        if (ageInWeeks >= 0 && ageInWeeks <= 4) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInWeeks > 4 && ageInWeeks <= MAX_WEEKS_IN_23_MONTHS) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        } else if (ageInWeeks > MAX_WEEKS_IN_23_MONTHS && ageInWeeks <= MAX_WEEKS_CONVERSION) {
            final int ageInYears = ageInWeeks / 52;
            return ageInYearsToAgeGroupCode(ageInYears);
        } else {
            throw new IllegalArgumentException("age " + ageInWeeks
                    + " weeks is out of range for conversion.  The maximium value supported is " + MAX_WEEKS_CONVERSION
                    + ".");
        }

        return codes;
    }

    /**
     * Age in months to age group code.
     *
     * @param ageInMonths the age in months
     * @return the list
     */
    public static List<Code> ageInMonthsToAgeGroupCode(int ageInMonths) {

        final List<Code> codes = new ArrayList<Code>();

        if (ageInMonths >= 0 && ageInMonths < 1) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInMonths >= 1 && ageInMonths <= 23) {
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        } else if (ageInMonths > 23 && ageInMonths <= MAX_MONTHS_CONVERSION) {
            final int ageInYears = ageInMonths / 12;
            return ageInYearsToAgeGroupCode(ageInYears);
        } else {
            throw new IllegalArgumentException("age " + ageInMonths
                    + " months is out of range for conversion.  The maximium value supported is " + MAX_MONTHS_CONVERSION
                    + ".");
        }

        return codes;
    }

    /**
     * Age in days to age group code.
     *
     * @param ageInDays the age in days
     * @return the list
     */
    public static List<Code> ageInDaysToAgeGroupCode(int ageInDays) {

        final List<Code> codes = new ArrayList<Code>();

        if (ageInDays >= 0 && ageInDays < 35) { // 1 days less than 5 weeks converts to a month
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInDays >= 35 && ageInDays <= MAX_DAYS_CONVERSION) { // otherwise use weeks conversion
            final int ageInWeeks = ageInDays / 7;
            return ageInWeeksToAgeGroupCode(ageInWeeks);
        } else {
            throw new IllegalArgumentException("age " + ageInDays
                    + " days is out of range for conversion.  The maximium value supported is " + MAX_DAYS_CONVERSION + ".");
        }

        return codes;
    }

    /**
     * Age in hours to group code.
     *
     * @param ageInHours the age in hours
     * @return the list
     */
    public static List<Code> ageInHoursToGroupCode(int ageInHours) {

        final List<Code> codes = new ArrayList<Code>();

        if (ageInHours >= 0 && ageInHours < (24 * 35)) { // < 35 days -> anything less than 5 weeks
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInHours >= (24 * 35) && ageInHours < MAX_HOURS_CONVERSION) { // otherwise use days conversion
            final int ageInDays = ageInHours / 24;
            return ageInDaysToAgeGroupCode(ageInDays);
        } else {
            throw new IllegalArgumentException("age " + ageInHours
                    + " hours is out of range for conversion.  The maximium value supported is " + MAX_HOURS_CONVERSION
                    + ".");
        }

        return codes;
    }

    /**
     * Age in minutes to group code.
     *
     * @param ageInMinutes the age in minutes
     * @return the list
     */
    public static List<Code> ageInMinutesToGroupCode(int ageInMinutes) {

        final List<Code> codes = new ArrayList<Code>();

        if (ageInMinutes >= 0 && ageInMinutes < (60 * 24 * 35)) { // < 35 days -> anything less than 5 weeks
            codes.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        } else if (ageInMinutes >= (60 * 24 * 35) && ageInMinutes < MAX_MINUTES_CONVERSION) { // otherwise use days conversion
            final int ageInHours = ageInMinutes / 60;
            return ageInHoursToGroupCode(ageInHours);
        } else {
            throw new IllegalArgumentException("age " + ageInMinutes
                    + " hours is out of range for conversion.  The maximium value supported is " + MAX_HOURS_CONVERSION
                    + ".");
        }

        return codes;
    }

}
