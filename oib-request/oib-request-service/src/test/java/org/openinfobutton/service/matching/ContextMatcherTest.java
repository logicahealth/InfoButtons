/*******************************************************************************
 * Source File: ContextMatcherTest.java
 ******************************************************************************/
package org.openinfobutton.service.matching;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.service.fixture.OibServiceTestFixture;
import org.openinfobutton.service.utility.WebServiceUtility;
import org.openinfobutton.service.web.KnowledgeRequestEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2010-2013 OpenInfobutton Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <andrew.iskander@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Dec 11, 2013
 */
public class ContextMatcherTest extends OibServiceTestFixture
{
	
	@Autowired
	KnowledgeRequestEngine engine;
	
	@Test
	public void cysticICD9RequestTest(){
		
		KnowledgeRequest request = WebServiceUtility.getServiceRequest(cystitisICD9Request());
		final String xml = marshallXML(engine.getResponse(request));
		Assert.assertThat(xml, containsString("http://www.nlm.nih.gov/medlineplus/bladderdiseases.html"));
		Assert.assertThat(xml, containsString("http://www.elsinfobutton.com/info/1030?taskContext.c.c=PROBLISTREV&amp;taskContext.c.cs=2.16.840.1.113883.5.4&amp;mainSearchCriteria.v.c=595.9&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.103&amp;mainSearchCriteria.v.dn=Cystitis&amp;"));
		Assert.assertThat(xml, containsString("http://www.uptodate.com/online/content/search.do?searchType=HL7&amp;taskContext.c.c=PROBLISTREV&amp;taskContext.c.cs=2.16.840.1.113883.5.4&amp;ageGroup.v.c=D008875&amp;ageGroup.v.cs=2.16.840.1.113883.6.177&amp;patientPerson.administrativeGenderCode.c=F&amp;patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1&amp;mainSearchCriteria.v.c=595.9&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.103&amp;mainSearchCriteria.v.dn=Cystitis&amp;subTopic.v.c=Q000175&amp;subTopic.v.cs=2.16.840.1.113883.6.177&amp;subTopic.v.dn=Diagnosis"));
		Assert.assertThat(xml, containsString("http://www.google.com/search?hl=en&amp;btnI=Im+Feeling+Lucky&amp;q=Cystitis+site:www.mayoclinic.com/health/&amp;"));
		Assert.assertThat(xml, containsString("http://www.ncbi.nlm.nih.gov/pubmed?term=hasabstract[text]"));
		
	}
	
	@Test
	public void cysticUMLSRequestTest(){
		
		KnowledgeRequest request = WebServiceUtility.getServiceRequest(cystitisUMLSRequest());
		final String xml = marshallXML(engine.getResponse(request));
		Assert.assertThat(xml, containsString("http://www.uptodate.com/online/content/search.do?searchType=HL7&amp;taskContext.c.c=PROBLISTREV&amp;taskContext.c.cs=2.16.840.1.113883.5.4&amp;ageGroup.v.c=D008875&amp;ageGroup.v.cs=2.16.840.1.113883.6.177&amp;patientPerson.administrativeGenderCode.c=F&amp;patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1&amp;mainSearchCriteria.v.c=595.0&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.103&amp;mainSearchCriteria.v.dn=Acute cystitis&amp;subTopic.v.c=Q000175&amp;subTopic.v.cs=2.16.840.1.113883.6.177&amp;subTopic.v.dn=Diagnosis"));
	}
	
	@Test
	public void clopidogrelRxNormRequestTest(){
		
		KnowledgeRequest request = WebServiceUtility.getServiceRequest(clopidogrelRxNormRequest());
		final String xml = marshallXML(engine.getResponse(request));
		Assert.assertThat(xml, containsString("http://www.uptodate.com/online/content/search.do?searchType=HL7&amp;taskContext.c.c=MEDOE&amp;taskContext.c.cs=2.16.840.1.113883.5.4&amp;ageGroup.v.c=D008875&amp;ageGroup.v.cs=2.16.840.1.113883.6.177&amp;patientPerson.administrativeGenderCode.c=F&amp;patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1&amp;mainSearchCriteria.v.c=32968&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.88&amp;mainSearchCriteria.v.dn=clopidogrel&amp;"));
	}
	
	@Test
	public void neurofibromatosisSubsetRequestTest(){
		
		KnowledgeRequest request = WebServiceUtility.getServiceRequest(neurofibromatosisSubsetRequest());
		final String xml = marshallXML(engine.getResponse(request));
		Assert.assertThat(xml, containsString("http://www.google.com/search?hl=en&amp;btnI=Im+Feeling+Lucky&amp;q=Neurofibromatosis+site:http://ghr.nlm.nih.gov/&amp;"));
		Assert.assertThat(xml, containsString("http://www.google.com/search?hl=en&amp;btnI=Im+Feeling+Lucky&amp;q=ICD-9+237.7+site:www.medicalhomeportal.org&amp;"));
	}
}
