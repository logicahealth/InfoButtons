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

import junit.framework.TestCase;

/**
 *
 * @author rick
 */
public class AgeUnitUcumCodeTest extends TestCase {

    public AgeUnitUcumCodeTest(String testName) {
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
     * Test of isValidCode method, of class AgeUnitUcumCode.
     */
    public void testIsValidCode1() {
        System.out.println("isValidCode");
        String code = "min";
        boolean expResult = true;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode2() {
        System.out.println("isValidCode");
        String code = "h";
        boolean expResult = true;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode3() {
        System.out.println("isValidCode");
        String code = "d";
        boolean expResult = true;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode4() {
        System.out.println("isValidCode");
        String code = "wk";
        boolean expResult = true;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode5() {
        System.out.println("isValidCode");
        String code = "mo";
        boolean expResult = true;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode6() {
        System.out.println("isValidCode");
        String code = "a";
        boolean expResult = true;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsInvalidCode1() {
        System.out.println("isInvalidCode");
        String code = "aa";
        boolean expResult = false;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsInvalidCode2() {
        System.out.println("isInvalidCode");
        String code = "-a";
        boolean expResult = false;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsInvalidCode3() {
        System.out.println("isInvalidCode");
        String code = "";
        boolean expResult = false;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsInvalidCode4() {
        System.out.println("isInvalidCode");
        String code = null;
        boolean expResult = false;
        boolean result = AgeUnitUcumCode.isValidCode(code);
        assertEquals(expResult, result);
    }

}
