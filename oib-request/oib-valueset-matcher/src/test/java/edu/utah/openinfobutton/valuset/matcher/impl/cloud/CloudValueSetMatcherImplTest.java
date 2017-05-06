package edu.utah.openinfobutton.valuset.matcher.impl.cloud;

import edu.utah.openinfobutton.valuset.matcher.api.ValueSetMatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by andrew on 4/26/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {  "/testContext.xml"})
@WebAppConfiguration
public class CloudValueSetMatcherImplTest {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    MockHttpServletRequest request;

    @Autowired
    MockHttpSession session;

    @Autowired
    ValueSetMatcher matcher;

    @org.junit.Test
    public void testIsConceptInSubset() throws Exception {

        assertTrue(matcher.isConceptInSubset("ZNF884P", "2.16.840.1.113883.6.281", "HGNC_GENE_SYMBOLS"));

    }
}