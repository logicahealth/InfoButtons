/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openinfobutton.app.model;

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
