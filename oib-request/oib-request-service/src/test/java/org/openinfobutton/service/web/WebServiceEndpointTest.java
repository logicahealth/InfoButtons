/*******************************************************************************
 * Source File: WebServiceEndpointTest.java
 ******************************************************************************/
package org.openinfobutton.service.web;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.openinfobutton.service.fixture.OibServiceTestFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.HttpRequestHandler;

/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version May 5, 2014
 */
public class WebServiceEndpointTest
    extends OibServiceTestFixture
{
    @Autowired
    @Qualifier("knowledgeRequestServlet")
    HttpRequestHandler handler;
    
    @Test
    public void webServiceTest()
    {
        
        MockHttpServletRequest req = new MockHttpServletRequest();
        final MockHttpServletResponse resp = new MockHttpServletResponse();
        req.addParameters( cystitisICD9Request() );
        try
        {
            handler.handleRequest( req, resp );
        }
        catch ( ServletException | IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            Assert.assertThat( resp.getContentAsString(), 
                               containsString( "http://www.nlm.nih.gov/medlineplus/urinarytractinfections.html" ) );
        }
        catch ( UnsupportedEncodingException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
