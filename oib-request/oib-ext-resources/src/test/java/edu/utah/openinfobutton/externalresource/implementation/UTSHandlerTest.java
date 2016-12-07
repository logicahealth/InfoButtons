/*******************************************************************************
 * Source File: UTSHandlerTest.java
 ******************************************************************************/
package edu.utah.openinfobutton.externalresource.implementation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schemas.kb.Code;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler;

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
public class UTSHandlerTest
    extends ExternalResourcesTestFixture
{

    @Autowired
    ExternalResourceHandler handler;
    
    @Test
    public void testIsDecedent() {
        
        assertTrue(handler.isDescendant( DIABETES_DECEDENT, DIABETES ));
        assertFalse(handler.isDescendant( DIABETES_DECEDENT, CONCEPT_IN_SUBSET ));
    }
    
    @Test
    public void testTransformFreeText() {
        
        boolean transformed = false;
        final List<Code> codes = handler.transformFreeText( FREE_TEXT );
        for (Code code : codes)
        {
            if (code.getCode().equals( DIABETES.getCode() ))
            {
                transformed = true;
            }
        }
        assertTrue(transformed);
    }

    @Test
    public void testTransformCode() {
        final Code c2 = CodeUtility.getCode( "E11", "2.16.840.1.113883.6.96", "", "ICD10CM" );
        final Code c1 = CodeUtility.getCode( "250.0", "2.16.840.1.113883.6.103 ", "", "ICD9CM" );
        final Code answer1 = CodeUtility.getCode("E14.9", "2.16.840.1.113883.6.96", "", "ICD10CM");
        final Code answer2 = CodeUtility.getCode("111552007", "2.16.840.1.113883.6.96", "", "SNOMEDCT_US");
      //  handler.transformCode( c1, "SNOMEDCT_US" );
        Code c = handler.transformCode( c1, "SNOMEDCT_US" );
        System.out.print(c.getCode());
        assertTrue(answer2.getCode().equals(c.getCode()));

    }

}
