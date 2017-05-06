/*******************************************************************************
 * Source File: RxNormServiceText.java
 ******************************************************************************/
package org.openinfobutton.inference.rxnorm.service;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Test;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schemas.kb.Code;

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
public class RxNormServiceTest
{
    
    
    @Test
    public void testTranslateFreeTexttoRxNorm() throws IOException {
        
        final Code code = RxNormService.getTransformedCode( CodeUtility.getCode( "E935.4", "2.16.840.1.113883.6.103", "Acetaminophen", "ICD9CM" ) );
        assertFalse(code.getCode().equals(""));
    }

}
