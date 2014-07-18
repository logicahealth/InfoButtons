package org.openinfobutton.responder.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.RequestParameter;
import org.openinfobutton.app.model.ValueSetCode;
import org.openinfobutton.responder.dao.ResponderAppPropertyDao;
import org.openinfobutton.responder.dao.ResponderAssetDao;
import org.openinfobutton.responder.dao.ResponderRequestParameterDao;
import org.openinfobutton.responder.dao.ResponderValueSetDao;
import org.openinfobutton.responder.service.ResponderService;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 *
 * @author rick
 */
@RunWith(MockitoJUnitRunner.class)
public class ResponderServiceImplMockitoTest {

    @Mock
    ResponderRequestParameterDao responderRequestParameterDao;

    @Mock
    ResponderAppPropertyDao responderAppPropertyDao;

    @Mock
    ResponderAssetDao responderAssetDao;

    @Mock
    ResponderValueSetDao responderValueSetDao;

    @InjectMocks
    ResponderServiceImpl responderServiceImpl;

    /**
     * Test of getRxNormQueryExpansionTermTypes method, of class
     * ResponderServiceImpl.
     */
    @Test
    public void testGetRxNormQueryExpansionTermTypes() {
        System.out.println("getRxNormQueryExpansionTermTypes");

        List<ValueSetCode> valueSet = getRxNormFilterValueSet();
        List<AppProperty> appPropertyList = getAppPropertyList();
        String propertyGroup = "app.valueset.id";

        when(responderAppPropertyDao.getAppPropertyGroup(propertyGroup)).thenReturn(appPropertyList);
        when(responderValueSetDao.getValueSetCodes(new BigDecimal("1"))).thenReturn(valueSet);

        Set<String> result = responderServiceImpl.getRxNormQueryExpansionTermTypes();
        assertEquals(result.size(), 2);
    }

    /**
     * Test of getIndexPropertyInterpretationMap method, of class
     * ResponderServiceImpl.
     */
    @Test
    public void testGetIndexPropertyInterpretationMap() {
        System.out.println("getIndexPropertyInterpretationMap");

        List<RequestParameter> requestParameters = getRequestParameters();

        when(responderRequestParameterDao.getSupportedOpenInfobuttonRequestParametersOrdered()).thenReturn(requestParameters);

        Map<String, Map<String, String>> result = responderServiceImpl.getIndexPropertyInterpretationMap();
        assertTrue(result.containsKey("informationRecipient")
                && result.containsKey("mainSearchCriteria.v")
                && result.containsKey("patientPerson.administrativeGenderCode"));
    }

    @Test
    public void testGetIndexInterpretationMap() {

        System.out.println("testGetIndexInterpretationMap");

        ResponderService service = new ResponderServiceImpl();
        Map<String, Map<String, String>> params = service.getIndexPropertyInterpretationMap(getRequestParameters());

        for (String param : params.keySet()) {
            Map<String, String> paramTypeMap = params.get(param);
            for (String code : paramTypeMap.keySet()) {
                System.out.println(param + ":" + code + ":" + paramTypeMap.get(code));
            }
        }

        assertTrue("mainSearchCriteria.v.c".equals(params.get("mainSearchCriteria.v").get("CODE")));
    }

//    /**
//     * Test of getIndexPropertyInterpretationMap method, of class ResponderServiceImpl.
//     */
//    @Test
//    public void testGetIndexPropertyInterpretationMap_0args() {
//        System.out.println("getIndexPropertyInterpretationMap");
//        ResponderServiceImpl instance = new ResponderServiceImpl();
//        Map<String, Map<String, String>> expResult = null;
//        Map<String, Map<String, String>> result = instance.getIndexPropertyInterpretationMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getKnowledgeRequestParameterMap method, of class ResponderServiceImpl.
//     */
//    @Test
//    public void testGetKnowledgeRequestParameterMap() {
//        System.out.println("getKnowledgeRequestParameterMap");
//        Map httpRequestParameters = null;
//        ResponderServiceImpl instance = new ResponderServiceImpl();
//        Map<String, String> expResult = null;
//        Map<String, String> result = instance.getKnowledgeRequestParameterMap(httpRequestParameters);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of requestContainsRequiredParameters method, of class
     * ResponderServiceImpl.
     */
    @Test
    public void testRequestContainsRequiredParametersWithValid() throws Exception {
        System.out.println("requestContainsRequiredParameters");

        when(responderRequestParameterDao.getRequiredOpenInfobuttonRequestParameters()).thenReturn(getRequiredRequestParmeters());
        boolean expResult = true;
        boolean result = responderServiceImpl.requestContainsRequiredParameters(getValidRequestParameters());
        assertEquals(expResult, result);
    }

    @Test
    public void testRequestContainsRequiredParametersWithInvalid() throws Exception {
        System.out.println("requestContainsRequiredParameters");

        boolean exception = false;

        when(responderRequestParameterDao.getRequiredOpenInfobuttonRequestParameters()).thenReturn(getRequiredRequestParmeters());

        try {
            boolean result = responderServiceImpl.requestContainsRequiredParameters(getInvalidRequestParameters());
        }
        catch (MissingServletRequestParameterException e) {
            exception = true;
        }

        assertTrue(exception);
    }

    @Test
    public void testRequestContainsRequiredParametersWithInvalid2() throws Exception {
        System.out.println("requestContainsRequiredParameters");

        boolean exception = false;

        when(responderRequestParameterDao.getRequiredOpenInfobuttonRequestParameters()).thenReturn(getRequiredRequestParmeters());

        try {
            boolean result = responderServiceImpl.requestContainsRequiredParameters(getInvalidRequestParameters2());
        }
        catch (MissingServletRequestParameterException e) {
            exception = true;
        }

        assertTrue(exception);
    }

    /**
     * Test of getApplicationProperties method, of class ResponderServiceImpl.
     */
    @Test
    public void testGetApplicationProperties() {
        System.out.println("getApplicationProperties");

        String propertyGroup = "atom.feed";
        when(responderAppPropertyDao.getAppPropertyGroup(propertyGroup)).thenReturn(getAppPropertyList());

        Properties result = responderServiceImpl.getApplicationProperties(propertyGroup);

        assertTrue(result.size() == getAppPropertyList().size());
    }

    @Test
    public void testGetApplicationProperties2() {
        System.out.println("getApplicationProperties");

        String propertyGroup = "atom.feed";
        when(responderAppPropertyDao.getAppPropertyGroup(propertyGroup)).thenReturn(getAppPropertyList());

        Properties first = responderServiceImpl.getApplicationProperties(propertyGroup);
        responderServiceImpl.setAppProperties(first);
        Properties result = responderServiceImpl.getApplicationProperties(propertyGroup);

        assertTrue(result.size() == getAppPropertyList().size());
    }

    @Test
    public void testFindAssetsByInfobuttonRequest() {

        Map<String, String> requestParameters = getValidRequestParameters();
        when(responderAssetDao.findByInfobuttonRequest(requestParameters)).thenReturn(getTestAssets());

        Collection<Asset> assets = responderServiceImpl.findAssetsByInfobuttonRequest(requestParameters);

        assertTrue(assets.size() == getTestAssets().size());
    }

//    /**
//     * Test of findAssetsByInfobuttonRequest method, of class ResponderServiceImpl.
//     */
//    @Test
//    public void testFindAssetsByInfobuttonRequest() {
//        System.out.println("findAssetsByInfobuttonRequest");
//        Map<String, String> requestParameters = null;
//        ResponderServiceImpl instance = new ResponderServiceImpl();
//        Collection<Asset> expResult = null;
//        Collection<Asset> result = instance.findAssetsByInfobuttonRequest(requestParameters);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
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

    private Map<String, String> getInvalidRequestParameters2() {

        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("mainSearchCriteria.v.c", "");

        return requestParameters;
    }

    private List<AppProperty> getAppPropertyList() {

        List<AppProperty> props = new ArrayList<>();
        AppProperty p1 = new AppProperty();
        p1.setPropertyName("p1");
        p1.setPropertyValue("v1");

        AppProperty p2 = new AppProperty();
        p2.setPropertyName("RXNORM_QUERY_EXPANSION_TERM_TYPE_CODES");
        p2.setPropertyValue("1");

        props.add(p1);
        props.add(p2);

        return props;
    }

    private Collection<Asset> getTestAssets() {

        Collection<Asset> assets = new ArrayList<>();

        Asset a1 = new Asset();
        a1.setAssetId(BigDecimal.ONE);
        a1.setDisplayName("a1");

        Asset a10 = new Asset();
        a10.setAssetId(BigDecimal.TEN);
        a10.setDisplayName("a10");

        assets.add(a1);
        assets.add(a10);

        return assets;

    }

    public List<ValueSetCode> getRxNormFilterValueSet() {

        List<ValueSetCode> valueSet = new ArrayList<>();
        ValueSetCode v1 = new ValueSetCode();
        v1.setValueSetId(BigDecimal.ZERO);
        v1.setCode("A");

        ValueSetCode v2 = new ValueSetCode();
        v2.setValueSetId(BigDecimal.ONE);
        v2.setCode("B");

        valueSet.add(v1);
        valueSet.add(v2);

        return valueSet;
    }

    private Properties getRxNormValueSetId() {

        Properties props = new Properties();
        props.setProperty("RXNORM_QUERY_EXPANSION_TERM_TYPE_CODES", "1");

        return props;
    }

    private List<RequestParameter> getRequestParameters() {

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
        p4.setRequestParameterId(new BigDecimal(5));
        p4.setParameterName("patientPerson.administrativeGenderCode.cs");
        p4.setParameterRoot("patientPerson.administrativeGenderCode");
        p4.setTypeCode("CODE_SYSTEM");

        List<RequestParameter> pc = new ArrayList<>();
        pc.add(p);
        pc.add(p0);
        pc.add(p1);
        pc.add(p2);
        pc.add(p3);
        pc.add(p4);

        return pc;
    }

}
