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
import java.math.BigInteger;
import junit.framework.TestCase;

/**
 *
 * @author rick
 */
public class AssetPropertyTest extends TestCase {
    
    /**
     * Test of getAssetPropertyId method, of class AssetProperty.
     */
    public void testAssetProperty() {
        System.out.println("Test AssetProperty(id)");
        AssetProperty instance = new AssetProperty(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getAssetPropertyId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssetPropertyId method, of class AssetProperty.
     */
    public void testSetGetAssetPropertyId() {
        System.out.println("getAssetPropertyId");
        AssetProperty instance = new AssetProperty();
        instance.setAssetPropertyId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getAssetPropertyId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyGroupNumber method, of class AssetProperty.
     */
    public void testSetGetPropertyGroupNumber() {
        System.out.println("getPropertyGroupNumber");
        AssetProperty instance = new AssetProperty();
        instance.setPropertyGroupNumber(BigInteger.ONE);
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = instance.getPropertyGroupNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyName method, of class AssetProperty.
     */
    public void testSetGetPropertyName() {
        System.out.println("getPropertyName");
        AssetProperty instance = new AssetProperty();
        instance.setPropertyName("myPropertyName");
        String expResult = "myPropertyName";
        String result = instance.getPropertyName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyType method, of class AssetProperty.
     */
    public void testSetGetPropertyType() {
        System.out.println("getPropertyType");
        AssetProperty instance = new AssetProperty();
        instance.setPropertyType("myPropType");
        String expResult = "myPropType";
        String result = instance.getPropertyType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class AssetProperty.
     */
    public void testSetGetCode() {
        System.out.println("getCode");
        AssetProperty instance = new AssetProperty();
        instance.setCode("aCode1234");
        String expResult = "aCode1234";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodeSystem method, of class AssetProperty.
     */
    public void testSetGetCodeSystem() {
        System.out.println("getCodeSystem");
        AssetProperty instance = new AssetProperty();
        instance.setCodeSystem("code.system");
        String expResult = "code.system";
        String result = instance.getCodeSystem();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplayName method, of class AssetProperty.
     */
    public void testSetGetDisplayName() {
        System.out.println("getDisplayName");
        AssetProperty instance = new AssetProperty();
        instance.setDisplayName("myDispName");
        String expResult = "myDispName";
        String result = instance.getDisplayName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyValue method, of class AssetProperty.
     */
    public void testSetGetPropertyValue() {
        System.out.println("getPropertyValue");
        AssetProperty instance = new AssetProperty();
        instance.setPropertyValue("12345");
        String expResult = "12345";
        String result = instance.getPropertyValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAsset method, of class AssetProperty.
     */
    public void testSetGetAsset() {
        System.out.println("getAsset");
        AssetProperty instance = new AssetProperty();
        Asset asset = new Asset(BigDecimal.ONE);
        instance.setAsset(asset);
        Asset expResult = new Asset(BigDecimal.ONE);
        Asset result = instance.getAsset();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGeneratedByCode method, of class AssetProperty.
     */
    public void testSetGeneratedByCode() {
        System.out.println("setGeneratedByCode");
        String generatedByCode = "myBrain";
        AssetProperty instance = new AssetProperty();
        instance.setGeneratedByCode(generatedByCode);
        String expResult = instance.getGeneratedByCode();
        assertEquals(expResult,generatedByCode);
    }

    /**
     * Test of hashCode method, of class AssetProperty.
     */
    public void testHashCode1() {
        System.out.println("hashCode");
        AssetProperty instance = new AssetProperty();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    public void testHashCode2() {
        System.out.println("hashCode");
        AssetProperty instance = new AssetProperty();
        instance.setAssetPropertyId(BigDecimal.ONE);
        int expResult = (BigDecimal.ONE).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class AssetProperty.
     */
    public void testEquals1() {
        System.out.println("equals");
        Object object = null;
        AssetProperty instance = new AssetProperty();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    public void testEquals2() {
        System.out.println("equals");
        AssetProperty instance = new AssetProperty();
        instance.setAssetPropertyId(BigDecimal.ONE);
        AssetProperty instance2 = new AssetProperty();
        instance2.setAssetPropertyId(BigDecimal.ONE);
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals3() {
        System.out.println("equals");
        AssetProperty instance = new AssetProperty();
        AssetProperty instance2 = new AssetProperty();
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals4() {
        System.out.println("equals");
        AssetProperty instance = new AssetProperty();
        instance.setAssetPropertyId(BigDecimal.ONE);
        AssetProperty instance2 = new AssetProperty();
        instance.setAssetPropertyId(BigDecimal.TEN);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals5() {
        System.out.println("equals");
        AssetProperty instance = new AssetProperty();
        AssetProperty instance2 = null;
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals6() {
        System.out.println("equals");
        AssetProperty instance = new AssetProperty();
        AssetProperty instance2 = new AssetProperty();
        instance2.setAssetPropertyId(BigDecimal.ONE);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    /**
     * Test of toString method, of class AssetProperty.
     */
    public void testToString() {
        System.out.println("toString");
        AssetProperty instance = new AssetProperty();
        instance.setAssetPropertyId(BigDecimal.ONE);
        String expResult = "org.openinfobutton.app.model.AssetProperty[ assetPropertyId=" + BigDecimal.ONE + " ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
