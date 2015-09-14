/*******************************************************************************
 * Source File: ProfileManagerServiceTest.java
 ******************************************************************************/
package org.openinfobutton.service.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import edu.utah.further.liteprofiledb.domain.CustomProfiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
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
@ContextConfiguration( locations = { "/core-liteprofile-datasource-context.xml", "/core-data-annotation-context.xml", "/core-data-datasource-context.xml",
                       "/core-profile-datasource-context.xml"})
public class ProfileManagerServiceTest
{
    @Autowired
    ProfileManagerService service;
    
    @Test
    public void returnProfilesAndCheckCount(){
        
       final List<CustomProfiles> profiles = service.getCustomProfiles();
       assertFalse(profiles.isEmpty());
    }
}
