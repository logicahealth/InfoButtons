package org.openinfobutton.rest.terminology.impl;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openinfobutton.rest.terminology.api.RestTermClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Tests the UMLS Rest Client
 *
 * -----------------------------------------------------------------------------------
 * (c) 2010-2016 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version March 13, 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context.xml"})
@TestPropertySource("classpath:testParams.properties")
public class UmlsRestClientImplTest {

    @Autowired
    private RestTermClient client;

    @org.junit.Test
    public void testGetTerms() throws Exception {

        String result = "";

        result = client.getTerms("diabetes", "SNOMEDCT_US");

        System.out.println(result);
        Assert.assertTrue(result.contains("diabetes"));
    }
}

