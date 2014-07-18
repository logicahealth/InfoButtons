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
public class AppPropertyTest extends TestCase {
    
    public AppPropertyTest(String testName) {
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
     * Test of getAppPropertyId method, of class AppProperty.
     */
    public void testSetGetAppPropertyId() {
        System.out.println("getAppPropertyId");
        AppProperty instance = new AppProperty();
        instance.setAppPropertyId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getAppPropertyId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyGroup method, of class AppProperty.
     */
    public void testSetGetPropertyGroup() {
        System.out.println("getPropertyGroup");
        AppProperty instance = new AppProperty();
        instance.setPropertyGroup("myGroup");
        String expResult = "myGroup";
        String result = instance.getPropertyGroup();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyName method, of class AppProperty.
     */
    public void testSetGetPropertyName() {
        System.out.println("getPropertyName");
        AppProperty instance = new AppProperty();
        instance.setPropertyName("myProperty");
        String expResult = "myProperty";
        String result = instance.getPropertyName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyValue method, of class AppProperty.
     */
    public void testSetGetPropertyValue() {
        System.out.println("getPropertyValue");
        AppProperty instance = new AppProperty();
        instance.setPropertyValue("myPopertyValue12345");
        String expResult = "myPopertyValue12345";
        String result = instance.getPropertyValue();
        assertEquals(expResult, result);
    }
    
}
