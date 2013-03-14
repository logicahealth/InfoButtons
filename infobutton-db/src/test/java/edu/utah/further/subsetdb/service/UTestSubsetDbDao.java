package edu.utah.further.subsetdb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.utah.further.core.api.data.Dao;
import edu.utah.further.core.test.annotation.UnitTest;
import static org.junit.Assert.assertTrue;
import edu.utah.further.subsetdb.service.SubsetDbDao;
import edu.utah.further.subsetdb.domain.Concept;
import edu.utah.further.subsetdb.domain.Subset;

@UnitTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/core-data-test-annotation-context.xml",
		"/core-data-test-datasource-context.xml" }, inheritLocations = false)
public class UTestSubsetDbDao {

	@Autowired
	@Qualifier("subsetDbDao")
	private SubsetDbDao dao;
	
	@SuppressWarnings("boxing")
	@Test
	public void testGetConcept() {
		
		String concept_code = "250.02";
		String concept_codesystem = "2.16.840.1.113883.6.2";
		Concept concept = dao.getConceptByCodeAndCodeSystem(concept_code, concept_codesystem);
		assertTrue(concept.getCode().equals(concept_code));
		assertTrue(concept.getCodeSystem().equals(concept_codesystem));
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testGetSubset() {
		
		String subset_name = "DIABETES_MELLITUS";
		Subset subset = dao.getSubsetByName(subset_name);
		assertTrue(subset.getName().equals(subset_name));
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testCheckMatch() {
		
		String concept_code = "250.02";
		String concept_codesystem = "2.16.840.1.113883.6.2";
		Concept concept = dao.getConceptByCodeAndCodeSystem(concept_code, concept_codesystem);
		String subset_name = "DIABETES_MELLITUS";
		Subset subset = dao.getSubsetByName(subset_name);
		
		assertTrue(dao.isConceptInSubset(concept.getId(), subset.getId()));
	}
}
