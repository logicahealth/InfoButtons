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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author rick
 */
public class AssetTest extends TestCase {

    public AssetTest(String testName) {
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
     * Test of getAssetId method, of class Asset.
     */
    public void testAssetConstructor() {
        System.out.println("Test Asset(assetId)");
        Asset instance = new Asset(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getAssetId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssetId method, of class Asset.
     */
    public void testSetGetAssetId() {
        System.out.println("getAssetId");
        Asset instance = new Asset();
        instance.setAssetId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getAssetId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNamespaceCd method, of class Asset.
     */
    public void testSetGetNamespaceCd() {
        System.out.println("getNamespaceCd");
        Asset instance = new Asset();
        instance.setNamespaceCd("myNamespace");
        String expResult = "myNamespace";
        String result = instance.getNamespaceCd();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplayName method, of class Asset.
     */
    public void testSetGetDisplayName() {
        System.out.println("getDisplayName");
        Asset instance = new Asset();
        instance.setDisplayName("aDisplayName");
        String expResult = "aDisplayName";
        String result = instance.getDisplayName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastUpdateDate method, of class Asset.
     */
    public void testSetGetLastUpdateDate() {
        System.out.println("getLastUpdateDate");
        Asset instance = new Asset();
        Date testDate = new Date();
        instance.setLastUpdateDate(testDate);
        Date expResult = testDate;
        Date result = instance.getLastUpdateDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssetUrl method, of class Asset.
     */
    public void testSetGetAssetUrl() {
        System.out.println("getAssetUrl");
        Asset instance = new Asset();
        instance.setAssetUrl("http://boogie.us");
        String expResult = "http://boogie.us";
        String result = instance.getAssetUrl();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssetMimeType method, of class Asset.
     */
    public void testSetGetAssetMimeType() {
        System.out.println("getAssetMimeType");
        Asset instance = new Asset();
        instance.setAssetMimeType("text/xml");
        String expResult = "text/xml";
        String result = instance.getAssetMimeType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssetProperties method, of class Asset.
     */
    public void testSetGetAssetProperties() {
        System.out.println("getAssetProperties");
        Asset instance = new Asset();

        List<AssetProperty> testList = new ArrayList<AssetProperty>();
        AssetProperty testAssetProperty = new AssetProperty();
        testAssetProperty.setAssetPropertyId(BigDecimal.ONE);
        testList.add(testAssetProperty);
        instance.setAssetProperties(testList);

        assertEquals(testList, instance.getAssetProperties());
    }

    /**
     * Test of hashCode method, of class Asset.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Asset instance = new Asset();
        instance.setAssetId(BigDecimal.ONE);

        Asset instance2 = new Asset();
        instance2.setAssetId(BigDecimal.ONE);

        assertEquals(instance.hashCode(), instance2.hashCode());
    }

    public void testHashCode2() {
        System.out.println("hashCode");
        Asset instance = new Asset();
        instance.setAssetId(BigDecimal.ONE);

        Asset instance2 = new Asset();
        instance2.setAssetId(null);

        assertTrue(instance.hashCode() != instance2.hashCode());
    }

    /**
     * Test of equals method, of class Asset.
     */
    public void testEquals() {
        System.out.println("equals");
        Asset instance = new Asset();
        instance.setAssetId(BigDecimal.ONE);

        Asset instance2 = new Asset();
        instance2.setAssetId(BigDecimal.ONE);

        assertTrue(instance.equals(instance2));
    }

    public void testEquals2() {
        System.out.println("equals");
        Asset instance = new Asset(BigDecimal.ONE);

        Asset instance2 = new Asset();

        assertTrue(!instance.equals(instance2));
    }

    public void testEquals3() {
        System.out.println("equals");
        Asset instance = new Asset(BigDecimal.ONE);
        Object instance2 = new Object();

        assertTrue(!instance.equals(instance2));
    }

    public void testEquals4() {
        System.out.println("equals");
        Asset instance = new Asset(BigDecimal.ONE);
        Asset instance2 = new Asset(BigDecimal.TEN);

        assertTrue(!instance.equals(instance2));
    }

    public void testEquals5() {
        System.out.println("equals");
        Asset instance = new Asset(BigDecimal.ONE);
        Asset instance2 = new Asset(null);

        assertTrue(!instance.equals(instance2));
    }

    public void testEquals6() {
        System.out.println("equals");
        Asset instance = new Asset(BigDecimal.ONE);
        Asset instance2 = new Asset(null);

        assertTrue(!instance2.equals(instance));
    }

    /**
     * Test of toString method, of class Asset.
     */
    public void testToString() {
        System.out.println("toString");
        Asset instance = new Asset();
        instance.setAssetId(BigDecimal.ONE);
        String expResult = "org.openinfobutton.content.model.Asset[ assetId=" + BigDecimal.ONE + "\t" + null + " ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
