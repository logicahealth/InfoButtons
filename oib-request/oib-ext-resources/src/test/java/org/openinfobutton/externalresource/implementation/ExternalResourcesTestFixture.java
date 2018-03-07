/*******************************************************************************
 * Source File: ExternalResourcesTestFixture.java
 ******************************************************************************/
package org.openinfobutton.externalresource.implementation;

import org.junit.runner.RunWith;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schemas.kb.Code;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "/core-data-annotation-context.xml", "/core-data-datasource-context.xml",
    "/core-profile-datasource-context.xml" } )
@TestPropertySource("/serviceParams.properties")
public abstract class ExternalResourcesTestFixture
{
    
    final static Code CONCEPT_IN_SUBSET = CodeUtility.getCode( "614164", "2.16.840.1.113883.6.174", "GLUTATHIONE PEROXIDASE DEFICIENCY", "Genetic Codes" );
    
    final static Code VALID_MAPPING_CONCEPT = CodeUtility.getCode( "109769000", "2.16.840.1.113883.6.96", "Necrotizing sialometaplasia", "SNOMEDCT_US" );
    
    final static String ICD10 = "2.16.840.1.113883.6.90";
    
    final static String SUBSET_ID = "OMIM_GENETIC_CONDITIONS";
    
    final static Code DIABETES = CodeUtility.getCode( "250", "2.16.840.1.113883.6.103", "Diabetes mellitus", "ICD9CM" );
    
    final static Code DIABETES_DECEDENT = CodeUtility.getCode( "250.01", "2.16.840.1.113883.6.103", "Diabetes mellitus type i", "ICD9CM" );
    
    final static String FREE_TEXT = "Diabetes mellitus";

}