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

/**
 * The Class AgeUnitUcumCode.
 *
 * @author rick
 */
public final class AgeUnitUcumCode {

    /**
     * The Constant MINUTE.
     */
    public final static String MINUTE = "min";

    /**
     * The Constant HOUR.
     */
    public final static String HOUR = "h";

    /**
     * The Constant DAY.
     */
    public final static String DAY = "d";

    /**
     * The Constant WEEK.
     */
    public final static String WEEK = "wk";

    /**
     * The Constant MONTH.
     */
    public final static String MONTH = "mo";

    /**
     * The Constant YEAR.
     */
    public final static String YEAR = "a";

    /**
     * Instantiates a new age unit ucum code.
     */
    private AgeUnitUcumCode() {
    }

    /**
     * Checks if is valid code.
     *
     * @param code the code
     * @return true, if is valid code
     */
    public static boolean isValidCode(String code) {

        if (MINUTE.equals(code) || HOUR.equals(code) || DAY.equals(code) || WEEK.equals(code)
                || MONTH.equals(code) || YEAR.equals(code)) {
            return true;
        }

        return false;
    }
}
