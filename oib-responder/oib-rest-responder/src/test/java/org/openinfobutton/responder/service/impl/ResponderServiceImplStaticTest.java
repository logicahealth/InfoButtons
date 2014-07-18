package org.openinfobutton.responder.service.impl;

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
        } catch ( Exception ee ) {
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