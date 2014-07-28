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
public class RequestParameterTest extends TestCase {
    
    /**
     * Test of Constructor method, of class RequestParameter.
     */
    public void testRequestParameter() {
        System.out.println("RequestParameter(id)");
        RequestParameter instance = new RequestParameter(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getRequestParameterId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequestParameterId method, of class RequestParameter.
     */
    public void testSetGetRequestParameterId() {
        System.out.println("getRequestParameterId");
        RequestParameter instance = new RequestParameter();
        instance.setRequestParameterId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getRequestParameterId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParameterName method, of class RequestParameter.
     */
    public void testSetGetParameterName() {
        System.out.println("getParameterName");
        RequestParameter instance = new RequestParameter();
        instance.setParameterName("myParameterName");
        String expResult = "myParameterName";
        String result = instance.getParameterName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParameterRoot method, of class RequestParameter.
     */
    public void testSetGetParameterRoot() {
        System.out.println("getParameterRoot");
        RequestParameter instance = new RequestParameter();
                instance.setParameterRoot("myRoot");
        String expResult = "myRoot";
        String result = instance.getParameterRoot();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypeCode method, of class RequestParameter.
     */
    public void testSetGetTypeCode() {
        System.out.println("getTypeCode");
        RequestParameter instance = new RequestParameter();
        instance.setTypeCode("myTypeCode");
        String expResult = "myTypeCode";
        String result = instance.getTypeCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParameterDescription method, of class RequestParameter.
     */
    public void testSetGetParameterDescription() {
        System.out.println("getParameterDescription");
        RequestParameter instance = new RequestParameter();
        instance.setParameterDescription("description1234");
        String expResult = "description1234";
        String result = instance.getParameterDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardinalityMin method, of class RequestParameter.
     */
    public void testSetGetCardinalityMin() {
        System.out.println("getCardinalityMin");
        RequestParameter instance = new RequestParameter();
        instance.setCardinalityMin(Long.MIN_VALUE);
        Long expResult = Long.MIN_VALUE;
        Long result = instance.getCardinalityMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardinalityMax method, of class RequestParameter.
     */
    public void testSetGetCardinalityMax() {
        System.out.println("getCardinalityMax");
        RequestParameter instance = new RequestParameter();
        instance.setCardinalityMax(BigInteger.ONE);
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = instance.getCardinalityMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class RequestParameter.
     */
    public void testHashCode1() {
        System.out.println("hashCode");
        RequestParameter instance = new RequestParameter();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    public void testHashCode2() {
        System.out.println("hashCode");
        RequestParameter instance = new RequestParameter();
        instance.setRequestParameterId(BigDecimal.ONE);
        int expResult = (BigDecimal.ONE).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class RequestParameter.
     */
    public void testEquals1() {
        System.out.println("equals");
        Object object = null;
        RequestParameter instance = new RequestParameter();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    public void testEquals2() {
        System.out.println("equals");
        RequestParameter instance = new RequestParameter();
        instance.setRequestParameterId(BigDecimal.ONE);
        RequestParameter instance2 = new RequestParameter();
        instance2.setRequestParameterId(BigDecimal.ONE);
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    
    public void testEquals3() {
        System.out.println("equals");
        RequestParameter instance = new RequestParameter();
        RequestParameter instance2 = new RequestParameter();
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    
    public void testEquals4() {
        System.out.println("equals");
        RequestParameter instance = new RequestParameter();
        instance.setRequestParameterId(BigDecimal.ONE);
        RequestParameter instance2 = new RequestParameter();
        instance2.setRequestParameterId(BigDecimal.TEN);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    
    public void testEquals5() {
        System.out.println("equals");
        RequestParameter instance = new RequestParameter();
        instance.setRequestParameterId(BigDecimal.ONE);
        RequestParameter instance2 = null;
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals6() {
        System.out.println("equals");
        RequestParameter instance = new RequestParameter();
        RequestParameter instance2 = new RequestParameter();
        instance.setRequestParameterId(BigDecimal.ONE);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class RequestParameter.
     */
    public void testToString() {
        System.out.println("toString");
        RequestParameter instance = new RequestParameter();
        instance.setRequestParameterId(BigDecimal.ONE);
        String expResult = "org.openinfobutton.request.model.RequestParameter[ requestParameterId=" + BigDecimal.ONE + " ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
