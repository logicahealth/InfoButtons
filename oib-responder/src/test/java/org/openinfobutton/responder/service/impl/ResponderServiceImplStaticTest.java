package org.openinfobutton.responder.service.impl;

/*
 * #%L
 * Project: oib-rest-responder
 * Inception Year: 2,010
 * Director: 
 * Guilherme Del Fiol, MD, PhD
 * University of Utah
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Phone: 801-581-4080
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.openinfobutton.app.model.RequestParameter;
import org.openinfobutton.responder.service.ResponderService;

/**
 *
 * @author rick
 */
public class ResponderServiceImplStaticTest extends TestCase {

    /**
     * Test of getKnowledgeRequestParameterMap method, of class
     * ResponderServiceImpl.
     */
    public void testGetFlatRequestMap() {

        System.out.println("testGetFlatRequestMap");

        Map httpRequestParameters = new HashMap();
        String parameterName = "mainSearchCriteria.v.c";
        String parameterValue = "aCode";
        httpRequestParameters.put(parameterName, new String[]{parameterValue});
        ResponderService instance = new ResponderServiceImpl();

        Map<String, String> expResult = new HashMap<>();
        expResult.put(parameterName, parameterValue);

        Map result = instance.getKnowledgeRequestParameterMap(httpRequestParameters);
        assertEquals(expResult, result);
    }

    public void testInvalidArgumentGetFlatRequestMap() {

        System.out.println("testInvalidArgumentGetFlatRequestMap");

        Map httpRequestParameters = new HashMap();
        String parameterName = "mainSearchCriteria.v.c";
        String parameterValue = "aCode";
        httpRequestParameters.put(parameterName, new String[]{parameterValue, parameterValue}); // two values should fail
        ResponderService instance = new ResponderServiceImpl();

        Map<String, String> expResult = new HashMap<>();
        expResult.put(parameterName, parameterValue);

        try {
            Map result = instance.getKnowledgeRequestParameterMap(httpRequestParameters); // should throw excpetion
            fail("Should have thrown an InvalidArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        } catch (Exception ee) {
            ee.printStackTrace();
            fail("Should have thrown IllegalArgumentException.");
        }
    }

    private Collection<RequestParameter> getRequiredRequestParmeters() {

        Collection<RequestParameter> requiredRequestParmeters = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter();
        rp1.setParameterName("mainSearchCriteria.v.c");
        RequestParameter rp2 = new RequestParameter();
        rp2.setParameterName("mainSearchCriteria.v.cs");
        RequestParameter rp3 = new RequestParameter();
        rp3.setParameterName("taskContext.c.c");
        requiredRequestParmeters.add(rp1);
        requiredRequestParmeters.add(rp2);
        requiredRequestParmeters.add(rp3);

        return requiredRequestParmeters;
    }

    private Map<String, String> getValidRequestParameters() {

        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("mainSearchCriteria.v.c", "");
        requestParameters.put("mainSearchCriteria.v.cs", "");
        requestParameters.put("taskContext.c.c", "");

        return requestParameters;
    }

    private Map<String, String> getInvalidRequestParameters() {

        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("mainSearchCriteria.v.c", "");
        requestParameters.put("mainSearchCriteria.v.cs", "");

        return requestParameters;
    }

}
