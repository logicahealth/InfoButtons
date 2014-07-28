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
public class AgeGroupMeshCodeTest extends TestCase {

    public AgeGroupMeshCodeTest(String testName) {
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
     * Test of isValidCode method, of class AgeGroupMeshCode.
     */
    public void testIsValidCode1() {
        System.out.println("isValidCode");
        String code = "D007231";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode2() {
        System.out.println("isValidCode");
        String code = "D007223";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode3() {
        System.out.println("isValidCode");
        String code = "D002675";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode4() {
        System.out.println("isValidCode");
        String code = "D002648";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode5() {
        System.out.println("isValidCode");
        String code = "D000293";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode6() {
        System.out.println("isValidCode");
        String code = "D055815";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode7() {
        System.out.println("isValidCode");
        String code = "D000328";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode8() {
        System.out.println("isValidCode");
        String code = "D008875";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode9() {
        System.out.println("isValidCode");
        String code = "D000368";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsValidCode10() {
        System.out.println("isValidCode");
        String code = "D000369";
        boolean expResult = true;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsInvalidCode1() {
        System.out.println("isInvalidCode");
        String code = "D00723";
        boolean expResult = false;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsInvalidCode2() {
        System.out.println("isInvalidCode");
        String code = "";
        boolean expResult = false;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

    public void testIsInvalidCode3() {
        System.out.println("isInvalidCode");
        String code = null;
        boolean expResult = false;
        boolean result = AgeGroupMeshCode.isValidCode(code);
        assertEquals(expResult, result);
    }

}
