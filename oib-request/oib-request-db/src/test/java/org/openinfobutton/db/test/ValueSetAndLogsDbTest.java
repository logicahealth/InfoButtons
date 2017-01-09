/*******************************************************************************
 * Source File: ValueSetDbTest.java
 ******************************************************************************/
package org.openinfobutton.db.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utah.further.subsetdb.domain.Concept;
import edu.utah.further.subsetdb.domain.Subset;
import edu.utah.further.subsetdb.service.LogsDao;
import edu.utah.further.subsetdb.service.SubsetDbDao;

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
@ContextConfiguration( locations = { "/core-valuelogs-annotation-context.xml","/core-data-datasource-context.xml" } )
public class ValueSetAndLogsDbTest
{

   @Autowired
   @Qualifier( "subsetDbDao" )
    private SubsetDbDao subsetDao;

    @Autowired
    @Qualifier( "logDao" )
    private LogsDao logsDao;
    
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    @Before
    public void insertLogEntry() {
        
        logsDao.saveRequest( "TEST", "TEST", "1.1.1.1", "TEST" );
    }
    
    @Test
    public void testLogEntry() {
        
        String sql = "SELECT request FROM logs WHERE request = ?";
        String request = jdbcTemplate.queryForObject(sql, new Object[] { "TEST" }, String.class);
        assertEquals("TEST", request);
    }
    
    @Test
    public void testValueSetLookUp() {
        
        Concept concept = subsetDao.getConceptByCodeAndCodeSystem( "250.00", "2.16.840.1.113883.6.103" );
        Subset subset = subsetDao.getSubsetByName( "DIABETES_MELLITUS" );
        assertTrue(subsetDao.isConceptInSubset( concept.getId(), subset.getId() ));
    }
    
    
    @After
    public void tearDown() {
        
        jdbcTemplate.update( "DELETE FROM logs WHERE request = ?", new Object[] { "TEST"} );
    }
}
