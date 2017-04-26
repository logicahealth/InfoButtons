package edu.utah.openinfobutton.valuset.matcher.impl.cloud;

import edu.utah.openinfobutton.valuset.matcher.api.ValueSetMatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by andrew on 4/26/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {  "/testContext.xml"})
public class CloudValueSetMatcherImplTest {

    @Autowired
    ValueSetMatcher matcher;

    @org.junit.Test
    public void testIsConceptInSubset() throws Exception {

        assertTrue(matcher.isConceptInSubset("148520", "2.16.840.1.113883.6.174", "OMIM_GENETIC_CONDITIONS"));

    }
}