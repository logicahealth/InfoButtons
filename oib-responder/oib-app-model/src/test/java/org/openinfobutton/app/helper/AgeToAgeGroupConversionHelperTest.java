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
import junit.framework.TestCase;
import org.openinfobutton.app.model.AgeGroupMeshCode;
import org.openinfobutton.app.model.AgeUnitUcumCode;
import org.openinfobutton.app.model.Code;

/**
 *
 * @author rick
 */
public class AgeToAgeGroupConversionHelperTest extends TestCase {

    public AgeToAgeGroupConversionHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of isValidAgeAndUnits method, of class
     * AgeToAgeGroupConversionHelper.
     */
    public void testIsValidAgeAndMinuteUnits() {
        System.out.println("testIsValidAgeAndMinuteUnits");
        int age = 45;
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvalidNegMinutes() {
        System.out.println("testIsValidAgeAndInvalidNegMinutes");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvaldLargeMinutes() {
        System.out.println("testIsValidAgeAndInvaldLargeMinutes");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidZeroMinutes() {
        System.out.println("testIsValidAgeAndValidZeroMinutes");
        int age = 0;
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidMinutes() {
        System.out.println("testIsValidAgeAndValidMinutes");
        int age = 45000;
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    // HOURS
    public void testIsValidAgeAndHourUnits() {
        System.out.println("testIsValidAgeAndHourUnits");
        int age = 48;
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvalidNegHours() {
        System.out.println("testIsValidAgeAndInvalidNegHours");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvaldLargeHours() {
        System.out.println("testIsValidAgeAndInvaldLargeHours");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidZeroHours() {
        System.out.println("testIsValidAgeAndValidZeroHours");
        int age = 0;
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidHours() {
        System.out.println("testIsValidAgeAndValidHours");
        int age = 30 * 24;
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    // DAYS
    public void testIsValidAgeAndDayUnits() {
        System.out.println("testIsValidAgeAndDayUnits");
        int age = 5;
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvalidNegDays() {
        System.out.println("testIsValidAgeAndInvalidNegDays");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvaldLargeDays() {
        System.out.println("testIsValidAgeAndInvaldLargeDays");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidZeroDays() {
        System.out.println("testIsValidAgeAndValidZeroDays");
        int age = 0;
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidDays() {
        System.out.println("testIsValidAgeAndValidDays");
        int age = AgeToAgeGroupConversionHelper.MAX_DAYS_CONVERSION;
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    // MONTHS
    public void testIsValidAgeAndMonthsUnits() {
        System.out.println("testIsValidAgeAndMonthsUnits");
        int age = 5;
        String ageUnitsUcumCode = AgeUnitUcumCode.MONTH;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvalidNegMonths() {
        System.out.println("testIsValidAgeAndInvalidNegMonths");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.MONTH;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvaldLargeMonths() {
        System.out.println("testIsValidAgeAndInvaldLargeMonths");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.MONTH;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidZeroMonths() {
        System.out.println("testIsValidAgeAndValidZeroMonths");
        int age = 0;
        String ageUnitsUcumCode = AgeUnitUcumCode.MONTH;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidMonths() {
        System.out.println("testIsValidAgeAndValidMonths");
        int age = AgeToAgeGroupConversionHelper.MAX_MONTHS_CONVERSION;
        String ageUnitsUcumCode = AgeUnitUcumCode.MONTH;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    // WEEKS
    public void testIsValidAgeAndWeeksUnits() {
        System.out.println("testIsValidAgeAndWeeksUnits");
        int age = 5;
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvalidNegWeeks() {
        System.out.println("testIsValidAgeAndInvalidNegWeeks");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvaldLargeWeeks() {
        System.out.println("testIsValidAgeAndInvaldLargeWeeks");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidZeroWeeks() {
        System.out.println("testIsValidAgeAndValidZeroWeeks");
        int age = 0;
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidWeeks() {
        System.out.println("testIsValidAgeAndValidWeeks");
        int age = AgeToAgeGroupConversionHelper.MAX_WEEKS_CONVERSION;
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    // YEARS
    public void testIsValidAgeAndYearsUnits() {
        System.out.println("testIsValidAgeAndYearsUnits");
        int age = 5;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvalidNegYears() {
        System.out.println("testIsValidAgeAndInvalidNegYears");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndInvaldLargeYears() {
        System.out.println("testIsValidAgeAndInvaldLargeYears");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        boolean expResult = false;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidZeroYears() {
        System.out.println("testIsValidAgeAndValidZeroYears");
        int age = 0;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testIsValidAgeAndValidYears() {
        System.out.println("testIsValidAgeAndValidYears");
        int age = 110;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        boolean expResult = true;
        boolean result = AgeToAgeGroupConversionHelper.isValidAgeAndUnits(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of ageToAgeGroup method, of class AgeToAgeGroupConversionHelper.
     */
    public void testNegAgeToAgeGroup() {
        System.out.println("testNegAgeToAgeGroup");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    public void testAge0ToAgeGroup() {
        System.out.println("testAge0ToAgeGroup");
        int age = 0;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAge1ToAgeGroup() {
        System.out.println("testAge1ToAgeGroup");
        int age = 1;
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAge2To5AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 2; age <= 5; age++) {
            System.out.println("testAge2To5AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.PRESCHOOL_2_TO_5_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge6To12AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 6; age <= 12; age++) {
            System.out.println("testAge6To12AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.CHILD_6_TO_12_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge13To18AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 13; age <= 18; age++) {
            System.out.println("testAge13To18AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ADOLESCENT_13_TO_18_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge19To24AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 19; age <= 24; age++) {
            System.out.println("testAge19To24AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.YOUNG_ADULT_19_TO_24_YEARS));
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ADULT_19_TO_44_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge25To44AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 25; age <= 44; age++) {
            System.out.println("testAge25To44AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ADULT_19_TO_44_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge45To55AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 45; age <= 55; age++) {
            System.out.println("testAge45To55AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.MIDDLE_AGED_45_TO_64_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge56To64AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 56; age <= 64; age++) {
            System.out.println("testAge56To64AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.MIDDLE_AGED_45_TO_64_YEARS));
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.AGED_56_TO_79_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge65To79AgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 65; age <= 79; age++) {
            System.out.println("testAge65To79AgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.AGED_56_TO_79_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge79ToOldAgeGroup() {
        String ageUnitsUcumCode = AgeUnitUcumCode.YEAR;
        for (int age = 80; age <= AgeToAgeGroupConversionHelper.MAX_HUMAN_AGE_IN_YEARS; age++) {
            System.out.println("testAge79ToOldAgeGroup: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.OLD_80_YEARS_AND_ABOVE));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    // MONTHS
    public void testNegAgeMonths() {
        String ageUnitsUcumCode = AgeUnitUcumCode.MONTH;
        int age = -1;
        System.out.println("testNegAgeMonths: age=" + age);

        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (Exception e) {
            assert (true);
            return;
        }
        fail("Expecting runtime exception");
    }

    public void testAge0Months() {
        String ageUnitsUcumCode = AgeUnitUcumCode.MONTH;
        int age = 0;
        System.out.println("testAge0to4Weeks: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);

    }

    // WEEKS
    public void testNegAgeToAgeGroupWeek() {
        System.out.println("testNegAgeToAgeGroup");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    public void testAge0to4Weeks() {
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        for (int age = 0; age <= 4; age++) {
            System.out.println("testAge0to4Weeks: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge5WeeksTo2Years() {
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        for (int age = 5; age <= AgeToAgeGroupConversionHelper.MAX_WEEKS_IN_23_MONTHS; age++) {
            System.out.println("testAge5WeeksTo2Years: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge2YearsInWeeksTo5Years() {
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        for (int age = (52 * 2); age <= (52 * 5); age += 26) { // 2 years to 5 years in weeks
            System.out.println("testAge2YearsInWeeksTo5Years: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.PRESCHOOL_2_TO_5_YEARS));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge5YearsInWeeks() {
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        int age = AgeToAgeGroupConversionHelper.MAX_WEEKS_CONVERSION;
        System.out.println("testAge5YearsInWeeks: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.PRESCHOOL_2_TO_5_YEARS));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAge6YearsInWeeks() {
        String ageUnitsUcumCode = AgeUnitUcumCode.WEEK;
        int age = 12 * 52; // 6 years in weeks
        System.out.println("testAge6YearsInWeeks: age=" + age);
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    // DAYS
    public void testNegAgeDaysToAgeGroup() {
        System.out.println("testNegAgeToAgeGroup");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    public void testLargeAgeDaysToAgeGroup() {
        System.out.println("testNegAgeToAgeGroup");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    public void testAge0To34Days() {
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        for (int age = 0; age <= 34; age++) { // 2 years to 5 years in weeks
            System.out.println("testAge0To34Days: age=" + age);
            List<Code> expResult = new ArrayList<Code>();
            expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
            assertEquals(expResult, result);
        }
    }

    public void testAge35Days() {
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        int age = 35;
        System.out.println("testAge35Days: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.ONE_TO_23_MONTHS));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAge2YearsInDays() {
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        int age = 365 * 2;
        System.out.println("testAge2YearsInDays: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.PRESCHOOL_2_TO_5_YEARS));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAge5YearsInDays() {
        String ageUnitsUcumCode = AgeUnitUcumCode.DAY;
        int age = 365 * 5;
        System.out.println("testAge5YearsInDays: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.PRESCHOOL_2_TO_5_YEARS));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    // HOURS
    public void testNegAgeHoursToAgeGroup() {
        System.out.println("testNegAgeHoursToAgeGroup");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    public void testAge0Hour() {
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        int age = 0;
        System.out.println("testAge0Minutes: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAge48Hours() {
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        int age = 48;
        System.out.println("testAge48Hours: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAgeMaxHours() {
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        int age = AgeToAgeGroupConversionHelper.MAX_HOURS_CONVERSION;
        System.out.println("testAgeMaxHours: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testLargeAgeHoursToAgeGroup() {
        System.out.println("testLargeAgeHoursToAgeGroup");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.HOUR;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    // MINUTES
    public void testNegAgeMinutesToAgeGroup() {
        System.out.println("testNegAgeMinutesToAgeGroup");
        int age = -1;
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }

    public void testAge0Minutes() {
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        int age = 0;
        System.out.println("testAge0Minutes: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAge60Minutes() {
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        int age = 60;
        System.out.println("testAge60Minutes: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testAgeMaxMinutes() {
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        int age = AgeToAgeGroupConversionHelper.MAX_MINUTES_CONVERSION;
        System.out.println("testAgeMaxMinutes: age=" + age);
        List<Code> expResult = new ArrayList<Code>();
        expResult.add(new Code(AgeGroupMeshCode.MESH_CODE_SYSTEM_OID, AgeGroupMeshCode.BIRTH_TO_1_MONTH));
        List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        assertEquals(expResult, result);
    }

    public void testLargeAgeMinutesToAgeGroup() {
        System.out.println("testLargeAgeMinutesToAgeGroup");
        int age = Integer.MAX_VALUE;
        String ageUnitsUcumCode = AgeUnitUcumCode.MINUTE;
        try {
            List<Code> result = AgeToAgeGroupConversionHelper.ageToAgeGroup(age, ageUnitsUcumCode);
        } catch (IllegalArgumentException e) {
            assert (true);
            return;
        }
        fail("Shoud have thrown an exception.");
    }
}
