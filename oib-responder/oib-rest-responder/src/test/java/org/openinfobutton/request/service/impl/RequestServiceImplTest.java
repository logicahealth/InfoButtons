package org.openinfobutton.request.service.impl;

import org.openinfobutton.responder.service.impl.ResponderServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.openinfobutton.app.model.RequestParameter;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 *
 * @author rick
 */
public class RequestServiceImplTest extends TestCase {

    public RequestServiceImplTest(String testName) {
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
     * Test of getKnowledgeRequestParameterMap method, of class
     * ResponderServiceImpl.
     */
    public void testGetFlatRequestMap() {
        
        System.out.println("testGetFlatRequestMap");
        
        Map httpRequestParameters = new HashMap();
        String parameterName = "mainSearchCriteria.v.c";
        String parameterValue = "aCode";
        httpRequestParameters.put(parameterName, new String[]{parameterValue});
        ResponderServiceImpl instance = new ResponderServiceImpl();
        
        Map<String, String> expResult = new HashMap<String, String>();
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
        ResponderServiceImpl instance = new ResponderServiceImpl();
        
        Map<String, String> expResult = new HashMap<String, String>();
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

    public void testGetIndexInterpretationMap() {

        System.out.println("testGetIndexInterpretationMap");
        
        RequestParameter p = new RequestParameter();
        p.setRequestParameterId(new BigDecimal(0));
        p.setParameterName("informationRecipient");
        p.setParameterRoot("informationRecipient");
        p.setTypeCode("CODE");

        RequestParameter p0 = new RequestParameter();
        p0.setRequestParameterId(new BigDecimal(1));
        p0.setParameterName("mainSearchCriteria.v.c");
        p0.setParameterRoot("mainSearchCriteria.v");
        p0.setTypeCode("CODE");

        RequestParameter p1 = new RequestParameter();
        p1.setRequestParameterId(new BigDecimal(2));
        p1.setParameterName("mainSearchCriteria.v.cs");
        p1.setParameterRoot("mainSearchCriteria.v");
        p1.setTypeCode("CODE_SYSTEM");

        RequestParameter p2 = new RequestParameter();
        p2.setRequestParameterId(new BigDecimal(3));
        p2.setParameterName("mainSearchCriteria.v.dn");
        p2.setParameterRoot("mainSearchCriteria.v");
        p2.setTypeCode("DISPLAY_NAME");

        RequestParameter p3 = new RequestParameter();
        p3.setRequestParameterId(new BigDecimal(4));
        p3.setParameterName("patientPerson.administrativeGenderCode.c");
        p3.setParameterRoot("patientPerson.administrativeGenderCode");
        p3.setTypeCode("CODE");

        RequestParameter p4 = new RequestParameter();
        p4.setRequestParameterId(new BigDecimal(4));
        p4.setParameterName("patientPerson.administrativeGenderCode.cs");
        p4.setParameterRoot("patientPerson.administrativeGenderCode");
        p4.setTypeCode("CODE_SYSTEM");

        Collection<RequestParameter> pc = new ArrayList<RequestParameter>();
        pc.add(p);
        pc.add(p0);
        pc.add(p1);
        pc.add(p2);
        pc.add(p3);
        pc.add(p4);
        
        ResponderServiceImpl service = new ResponderServiceImpl();
        Map<String,Map<String,String>> params = service.getIndexPropertyInterpretationMap( pc );

        for ( String param:params.keySet() ) {
            Map<String,String> paramTypeMap = params.get(param);
            for( String code:paramTypeMap.keySet() ) {
                System.out.println(param + ":" + code + ":" + paramTypeMap.get(code));
            }
        }
        
        assertTrue( "mainSearchCriteria.v.c".equals( params.get("mainSearchCriteria.v").get("CODE") ) );
        
    }
}