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

import java.util.HashSet;
import java.util.Set;
import junit.framework.TestCase;

/**
 *
 * @author rick
 */
public class CodeTest extends TestCase {

    public CodeTest(String testName) {
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

    public void testCodeConstructor() {
        System.out.println("testSetGetCode");
        Code code = new Code("csOid", "code1234");
        String expResult = "code1234";
        assertTrue(expResult.equals(code.getCode()) && "csOid".equals(code.getCodeSystemOid()));
    }

    public void testSetGetCode() {
        System.out.println("testSetGetCode");
        Code code = new Code();
        code.setCode("code1");
        String expResult = "code1";
        assertTrue(expResult.equals(code.getCode()));
    }

    public void testSetGetDisplayName() {
        System.out.println("testSetGetDisplayName");
        Code code = new Code();
        code.setDisplayName("dispName");
        String expResult = "dispName";
        assertTrue(expResult.equals(code.getDisplayName()));
    }

    public void testSetCodeSystemOid() {
        System.out.println("testSetCodeSystemOid");
        Code code = new Code();
        code.setCodeSystemOid("oid.oid");
        String expResult = "oid.oid";
        assertTrue(expResult.equals(code.getCodeSystemOid()));
    }

    public void testSetGetCodeSystemDisplay() {
        System.out.println("testSetGetCodeSystemDisplay");
        Code code = new Code();
        code.setCodeSystemDisplayName("csDisplay");
        String expResult = "csDisplay";
        assertTrue(expResult.equals(code.getCodeSystemDisplayName()));
    }

    /**
     * Test of hashCode method, of class Code.
     */
    public void testHashCodeWithCodeAndCodeSystem() {
        System.out.println("hashCode");
        Code code1 = new Code();
        code1.setCode("123");
        code1.setCodeSystemOid("456");
        Code code2 = new Code();
        code2.setCode("123");
        code2.setCodeSystemOid("456");
        assertEquals(code1.hashCode(), code2.hashCode());
    }

    public void testHashCodeWithNotEqualCodeAndCdeSystem() {
        System.out.println("hashCode");
        Code code1 = new Code();
        code1.setCode("123");
        code1.setCodeSystemOid("456");
        Code code2 = new Code();
        code2.setCode("123");
        code2.setCodeSystemOid("457");
        assertTrue(code1.hashCode() != code2.hashCode());
    }

    public void testHashCodeWithCodesAndNoCodeSystems() {
        System.out.println("hashCode");
        Code code1 = new Code();
        code1.setCode("123");
        Code code2 = new Code();
        code2.setCode("123");
        assertEquals(code1.hashCode(), code2.hashCode());
    }

    public void testHashCodeWithCodesAndOneCodeSystems() {
        System.out.println("hashCode");
        Code code1 = new Code();
        code1.setCode("123");
        Code code2 = new Code();
        code2.setCode("123");
        code2.setCodeSystemOid("456");
        assertTrue(code1.hashCode() != code2.hashCode());
    }

    public void testCodeEqualsWithEqualCodes() {
        System.out.println("equals");
        Code code1 = new Code();
        code1.setCode("123");
        Code code2 = new Code();
        code2.setCode("123");
        assertTrue(code1.equals(code2));
    }

    public void testCodeEqualsWithNotEqualCodes() {
        System.out.println("not equals");
        Code code1 = new Code();
        code1.setCode("123");
        Code code2 = new Code();
        code2.setCode("122");
        assertTrue(!code1.equals(code2));
    }

    public void testCodeEqualsWithEqualCodesAndSystems() {
        System.out.println("equals");
        Code code1 = new Code();
        code1.setCode("123");
        code1.setCodeSystemOid("456");
        Code code2 = new Code();
        code2.setCode("123");
        code2.setCodeSystemOid("456");
        assertTrue(code1.equals(code2));
    }

    public void testCodeEqualsWithNotEqualCodesAndSystems() {
        System.out.println("not equals");
        Code code1 = new Code();
        code1.setCode("123");
        code1.setCodeSystemOid("456");
        Code code2 = new Code();
        code2.setCode("122");
        code2.setCodeSystemOid("456");
        assertTrue(!code1.equals(code2));
    }

    public void testCodeEqualsWithNoCodes() {
        System.out.println("not equals");
        Code code1 = new Code();
        Code code2 = new Code();
        assertTrue(!code1.equals(code2));
    }

    public void testCodeHashSetWithTwoEqualCodesInThree() {
        System.out.println("HashSet");
        Set<Code> codes = new HashSet<Code>();
        Code code1 = new Code();
        code1.setCode("123");
        code1.setCodeSystemOid("456");
        Code code2 = new Code();
        code2.setCode("122");
        code2.setCodeSystemOid("456");
        Code code3 = new Code();
        code3.setCode("123");
        code3.setCodeSystemOid("456");
        codes.add(code1);
        codes.add(code2);
        codes.add(code3);
        assertTrue(codes.size() == 2);
    }

    public void testCodeHashSetWithTwoCodes() {
        System.out.println("HashSet");
        Set<Code> codes = new HashSet<Code>();
        Code code1 = new Code();
        code1.setCode("123");
        code1.setCodeSystemOid("456");
        Code code2 = new Code();
        code2.setCode("122");
        code2.setCodeSystemOid("456");
        codes.add(code1);
        codes.add(code2);
        assertTrue(codes.size() == 2);
    }

    public void testHashCodeNoVals() {
        System.out.println("No vals set");
        Code code1 = new Code();
        assertTrue(code1.hashCode() == 0);
    }

}
