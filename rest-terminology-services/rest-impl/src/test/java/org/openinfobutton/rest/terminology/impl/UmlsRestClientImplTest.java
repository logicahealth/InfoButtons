package org.openinfobutton.rest.terminology.impl;

import org.junit.Assert;
import org.openinfobutton.rest.terminology.api.RestTermClient;

/**
 * Created by Andrew on 3/15/2016.
 */
public class UmlsRestClientImplTest {

    @org.junit.Test
    public void testGetTerms() throws Exception {

        RestTermClient client = new UmlsRestClientImpl("", "");

        String result = "";

        result = client.getTerms("diabetes", "SNOMEDCT_US");

        System.out.println(result);
        Assert.assertNotNull(result);
    }
}

