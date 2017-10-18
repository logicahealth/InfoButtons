package org.openinfobutton.rest.terminology.impl;

import org.junit.Assert;
import org.openinfobutton.rest.terminology.api.RestTermClient;

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
public class UmlsRestClientImplTest {

    @org.junit.Test
    public void testGetTerms() throws Exception {

        RestTermClient client = new UmlsRestClientImpl();

        String result = "";

        result = client.getTerms("diabetes", "SNOMEDCT_US");

        System.out.println(result);
        Assert.assertTrue(result.contains("diabetes"));
    }
}

