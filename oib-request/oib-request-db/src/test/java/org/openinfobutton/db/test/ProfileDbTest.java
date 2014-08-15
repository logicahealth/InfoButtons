/*******************************************************************************
 * Source File: ProfileDbTest.java
 ******************************************************************************/
package org.openinfobutton.db.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import edu.utah.further.profiledb.service.FileandMarker;
import edu.utah.further.profiledb.service.ProfilesDao;

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
@ContextConfiguration( locations = { "/core-data-annotation-context.xml","/core-profile-datasource-context.xml" } )
public class ProfileDbTest
{
    /** The pdao. */
    @Autowired
    @Qualifier( "pDao" )
    private ProfilesDao pdao;
    
    @Autowired
    @Qualifier("profileJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    @Before
    public void insertProfile() {
        
        String sql = "INSERT INTO resource_profiles (id, name, version, published, status, content) values (?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[] {300l, "TestProfile", 2, new Date(), 2, "<?xml version=\"1.0\" encoding=\"utf-8\"?><a>PROFILETEST</a>"};
        jdbcTemplate.update( sql, params );
    }
    
    @Test
    public void testCount() {
        
        assertEquals(19l, pdao.count(1));
    }
    
    @Test
    public void testProfileRead() {
        
        FileandMarker marker = new FileandMarker();
        pdao.getResourceProfile( 300, 2, marker );
        DOMImplementationLS domImplementation = (DOMImplementationLS) marker.getBlobFile().getImplementation();
        LSSerializer lsSerializer = domImplementation.createLSSerializer();
        assertTrue(lsSerializer.writeToString(marker.getBlobFile()).contains( "PROFILETEST" ));
    }
    
    
    @After
    public void tearDown() {
        
        jdbcTemplate.update( "DELETE FROM resource_profiles WHERE id = ?", new Object[] { 300l} );
    }
}
