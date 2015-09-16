package org.openinfobutton.app.model;

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

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * The Class AgeGroupMeshCode.
 *
 * @author rick
 */
public final class AgeGroupMeshCode {

    /**
     * The Constant MESH_CODE_SYSTEM_OID.
     */
    public final static String MESH_CODE_SYSTEM_OID = "2.16.840.1.113883.6.177";

    /**
     * The Constant BIRTH_TO_1_MONTH.
     */
    public final static String BIRTH_TO_1_MONTH = "D007231";

    /**
     * The Constant ONE_TO_23_MONTHS.
     */
    public final static String ONE_TO_23_MONTHS = "D007223";

    /**
     * The Constant PRESCHOOL_2_TO_5_YEARS.
     */
    public final static String PRESCHOOL_2_TO_5_YEARS = "D002675";

    /**
     * The Constant CHILD_6_TO_12_YEARS.
     */
    public final static String CHILD_6_TO_12_YEARS = "D002648";

    /**
     * The Constant ADOLESCENT_13_TO_18_YEARS.
     */
    public final static String ADOLESCENT_13_TO_18_YEARS = "D000293";

    /**
     * The Constant YOUNG_ADULT_19_TO_24_YEARS.
     */
    public final static String YOUNG_ADULT_19_TO_24_YEARS = "D055815";

    /**
     * The Constant ADULT_19_TO_44_YEARS.
     */
    public final static String ADULT_19_TO_44_YEARS = "D000328";

    /**
     * The Constant MIDDLE_AGED_45_TO_64_YEARS.
     */
    public final static String MIDDLE_AGED_45_TO_64_YEARS = "D008875";

    /**
     * The Constant AGED_56_TO_79_YEARS.
     */
    public final static String AGED_56_TO_79_YEARS = "D000368";

    /**
     * The Constant OLD_80_YEARS_AND_ABOVE.
     */
    public final static String OLD_80_YEARS_AND_ABOVE = "D000369";

    /**
     * The Constant MAX_HUMAN_AGE_IN_YEARS.
     */
    public final static int MAX_HUMAN_AGE_IN_YEARS = 110;

    /**
     * The Constant AGE_RANGES.
     */
    @SuppressWarnings("boxing")
    public static final NavigableMap<Integer, String> AGE_RANGES = new TreeMap<Integer, String>() {
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
    private AgeGroupMeshCode() {
    }

    /**
     * Checks if is valid code.
     *
     * @param code the code
     * @return true, if is valid code
     */
    public static boolean isValidCode(String code) {

        if (BIRTH_TO_1_MONTH.equals(code) || ONE_TO_23_MONTHS.equals(code) || PRESCHOOL_2_TO_5_YEARS.equals(code)
                || CHILD_6_TO_12_YEARS.equals(code) || ADOLESCENT_13_TO_18_YEARS.equals(code)
                || YOUNG_ADULT_19_TO_24_YEARS.equals(code)
                || ADULT_19_TO_44_YEARS.equals(code) || AGED_56_TO_79_YEARS.equals(code)
                || MIDDLE_AGED_45_TO_64_YEARS.equals(code) || OLD_80_YEARS_AND_ABOVE.equals(code)) {

            return true;
        }

        return false;
    }
}
