/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openinfobutton.app.model;

import java.math.BigDecimal;
import junit.framework.TestCase;

/**
 *
 * @author rick
 */
public class ValueSetCodeTest extends TestCase {
    
    public ValueSetCodeTest(String testName) {
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
     * Test of getValueSetCodeId method, of class ValueSetCode.
     */
    public void testSetGetValueSetCodeId() {
        System.out.println("getValueSetCodeId");
        ValueSetCode instance = new ValueSetCode();
        instance.setValueSetCodeId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getValueSetCodeId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValueSetId method, of class ValueSetCode.
     */
    public void testSetGetValueSetId() {
        System.out.println("getValueSetId");
        ValueSetCode instance = new ValueSetCode();
        instance.setValueSetId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getValueSetId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class ValueSetCode.
     */
    public void testSetGetCode() {
        System.out.println("getCode");
        ValueSetCode instance = new ValueSetCode();
        instance.setCode("code.code");
        String expResult = "code.code";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodeSystemOid method, of class ValueSetCode.
     */
    public void testSetGetCodeSystemOid() {
        System.out.println("getCodeSystemOid");
        ValueSetCode instance = new ValueSetCode();
        instance.setCodeSystemOid("oid.oid");
        String expResult = "oid.oid";
        String result = instance.getCodeSystemOid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodeDisplayName method, of class ValueSetCode.
     */
    public void testSetGetCodeDisplayName() {
        System.out.println("getCodeDisplayName");
        ValueSetCode instance = new ValueSetCode();
        instance.setCodeDisplayName("myDisplay");
        String expResult = "myDisplay";
        String result = instance.getCodeDisplayName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOrder method, of class ValueSetCode.
     */
    public void testSetGetListOrder() {
        System.out.println("getListOrder");
        ValueSetCode instance = new ValueSetCode();
        instance.setListOrder(Integer.MIN_VALUE);
        Integer expResult = Integer.MIN_VALUE;
        Integer result = instance.getListOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParentValueSetCodeId method, of class ValueSetCode.
     */
    public void testGetParentValueSetCodeId() {
        System.out.println("getParentValueSetCodeId");
        ValueSetCode instance = new ValueSetCode();
        instance.setParentValueSetCodeId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getParentValueSetCodeId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodeUri method, of class ValueSetCode.
     */
    public void testGetCodeUri() {
        System.out.println("getCodeUri");
        ValueSetCode instance = new ValueSetCode();
        instance.setCodeUri("uri-situation");
        String expResult = "uri-situation";
        String result = instance.getCodeUri();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ValueSetCode.
     */
    public void testHashCode1() {
        System.out.println("hashCode");
        ValueSetCode instance = new ValueSetCode();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    public void testHashCode2() {
        System.out.println("hashCode");
        ValueSetCode instance = new ValueSetCode();
        instance.setValueSetCodeId(BigDecimal.ONE);
        int expResult = (BigDecimal.ONE).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ValueSetCode.
     */
    public void testEquals1() {
        System.out.println("equals");
        Object object = null;
        ValueSetCode instance = new ValueSetCode();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    public void testEquals2() {
        System.out.println("equals");
        Object object = (Object)(new ValueSetCode());
        ValueSetCode instance = new ValueSetCode();
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    public void testEquals3() {
        System.out.println("equals");
        ValueSetCode instance = new ValueSetCode();
        instance.setValueSetCodeId(BigDecimal.ONE);
        ValueSetCode object = new ValueSetCode();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    public void testEquals4() {
        System.out.println("equals");
        ValueSetCode instance = new ValueSetCode();
        instance.setValueSetCodeId(BigDecimal.ONE);
        ValueSetCode object = new ValueSetCode();
        object.setValueSetCodeId(BigDecimal.ONE);
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    public void testEquals5() {
        System.out.println("equals");
        ValueSetCode instance = new ValueSetCode();
        instance.setValueSetCodeId(BigDecimal.ONE);
        ValueSetCode object = new ValueSetCode();
        object.setValueSetCodeId(BigDecimal.TEN);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ValueSetCode.
     */
    public void testToString() {
        System.out.println("toString");
        ValueSetCode instance = new ValueSetCode();
        instance.setValueSetCodeId(BigDecimal.ONE);
        String expResult = "org.openinfobutton.responder.model.ValueSetCode[ valueSetCodeId=" + BigDecimal.ONE + "\t" + null + " ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
