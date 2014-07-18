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
