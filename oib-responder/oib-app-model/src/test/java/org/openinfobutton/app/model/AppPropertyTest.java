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
