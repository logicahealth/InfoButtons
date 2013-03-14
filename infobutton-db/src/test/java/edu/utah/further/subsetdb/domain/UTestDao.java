package edu.utah.further.subsetdb.domain;

/*******************************************************************************
 * Source File: UTestDao.java
 ******************************************************************************/

import static edu.utah.further.core.util.io.LoggingUtil.debugPrintAndCenter;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.utah.further.core.api.data.Dao;
import edu.utah.further.core.test.annotation.UnitTest;

/**
 * A unit test class of the Hibernate configuration and DAO.
 * <p>
 * ----------------------------------------------------------------------------
 * -------<br>
 * (c) 2008-2011 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: Dr. Scott Narus {@code <scott.narus@hsc.utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-213-3288<br>
 * ----------------------------------------------------------------------------
 * -------
 * 
 * @author Oren E. Livne {@code <oren.livne@utah.edu>}
 * @version Jan 28, 2009
 */
@UnitTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/core-data-test-annotation-context.xml",
		"/core-data-test-datasource-context.xml" }, inheritLocations = false)
public class UTestDao {
	// ========================= CONSTANTS =================================

	/**
	 * A logger that helps identify this class' printouts.
	 */
	private static final Logger log = getLogger(UTestDao.class);

	// ========================= FIELDS ====================================

	/**
	 * Handles generic DAO operations and searches.
	 */
	@Autowired
	@Qualifier("dao")
	private Dao dao;

	// ========================= SETUP METHODS =============================

	// ========================= TESTING METHODS ===========================

	/**
	 * A unit test of this service that runs when the bundle is started.
	 */
	@SuppressWarnings("boxing")
	@Transactional
	@Test
	public void listEntities() {
		// Create and save entity
		// final SubsetMember entity = new SubsetMember();
		// getDao().create(entity);
		// if (log.isDebugEnabled())
		// {
		// log.debug("Entity: " + entity);
		// }
		// assertNotNull(entity.getId());

		// Search for entities in the database
		Concept concept = dao.findById(Concept.class, new Long(2));
		Subset subset = dao.findById(Subset.class, new Long(1));
		if (log.isDebugEnabled()) {
			log.debug("Entities in database: " + concept);
		}
		
		Set<Subset> subsets = new HashSet<Subset>();
		subsets = concept.getSubsets();
		assertTrue(subsets.contains(subset));
		debugPrintAndCenter(log, "saveEntity() end");
	}

	// ========================= PRIVATE METHODS ===========================
}
