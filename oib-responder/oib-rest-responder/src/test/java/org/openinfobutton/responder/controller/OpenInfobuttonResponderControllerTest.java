package org.openinfobutton.responder.controller;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;

/**
 *
 * @author rick
 */
public class OpenInfobuttonResponderControllerTest {
    
    public OpenInfobuttonResponderControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of openInfobuttonRequestHandler method, of class OpenInfobuttonResponderController.
     */
    @Test
    public void testOpenInfobuttonRequestHandler() throws Exception {
        System.out.println("openInfobuttonRequestHandler");
        HttpServletRequest request = new MockHttpServletRequest();
        ModelMap model = null;
//        OpenInfobuttonResponderController instance = new OpenInfobuttonResponderController();
//        String expResult = "";
//        String result = instance.openInfobuttonRequestHandler(request, model);
//        assertEquals(expResult, result);
    }
}