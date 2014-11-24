/*******************************************************************************
 * Source File: LocalSubsetTest.java
 ******************************************************************************/
package edu.utah.openinfobutton.externalresource.implementation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.utah.openinfobutton.externalresource.api.TerminologyHandler;

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
public class LocalSubsetTest
    extends ExternalResourcesTestFixture
{
    
    @Autowired
    @Qualifier( "externalSet" )
    TerminologyHandler handler;
    
    @Test
    public void testIsSubsetMember() {
        
        List<Id> subsetIdList = new ArrayList<Id>();
        Id subsetId = new Id();
        subsetId.setId( SUBSET_ID );
        subsetIdList.add( subsetId );
        assertTrue(handler.isSubsetMember( CONCEPT_IN_SUBSET, subsetIdList));
        
    }
    
    @Test
    public void testTransformCode() {
        
        Code transformedCode = handler.transformCode( VALID_MAPPING_CONCEPT, ICD10);
        assertNotNull(transformedCode);
        transformedCode = handler.transformCode( VALID_MAPPING_CONCEPT, "asdfasdfs" );
        assertNull(transformedCode);
    }
}
