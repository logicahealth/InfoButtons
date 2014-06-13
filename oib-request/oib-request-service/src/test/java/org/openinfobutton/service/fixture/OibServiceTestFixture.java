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
 * @version Jun 13, 2014
 */
package org.openinfobutton.service.fixture;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hl7.v3.AggregateKnowledgeResponse;
import org.hl7.v3.CategoryType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openinfobutton.schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "/core-data-annotation-context.xml", "/core-data-datasource-context.xml",
		"/core-profile-datasource-context.xml" })
public abstract class OibServiceTestFixture
{
	

	@SuppressWarnings("deprecation")
	@Autowired
	@Qualifier("simpleJdbcTemplate")
	protected SimpleJdbcTemplate jdbcTemplate;
	
	/**
	 * Builds test request object
	 * 
	 * @return request
	 */
	@SuppressWarnings("boxing")
	public static Map<String, String[]> cystitisICD9Request() {
		
		Map<String, String[]> requestParameters = new HashMap<String, String[]>();
		requestParameters.put("representedOrganization.id.root", new String[]{"1.3.6.1.4.1.5884"});
		requestParameters.put("patientPerson.administrativeGenderCode.c", new String[]{"F"});
		requestParameters.put("age.v.v", new String[]{"47"});
		requestParameters.put("age.v.u", new String[]{"a"});
		requestParameters.put("taskContext.c.c", new String[]{"PROBLISTREV"});
		requestParameters.put("mainSearchCriteria.v.c", new String[]{"595.9"});
		requestParameters.put("mainSearchCriteria.v.cs", new String[]{"2.16.840.1.113883.6.103"});
		requestParameters.put("mainSearchCriteria.v.dn", new String[]{"Cystitis"});
		requestParameters.put("performer", new String[]{"PROV"});
		requestParameters.put("informationRecipient", new String[]{"PROV"});
		requestParameters.put("knowledgeResponseType", new String[]{"text/xml"});
		return requestParameters;
		
	}
	
	/**
	 * Builds test request object
	 * 
	 * @return request
	 */
	@SuppressWarnings("boxing")
	public static Map<String, String[]> cystitisUMLSRequest() {
		
		Map<String, String[]> requestParameters = new HashMap<String, String[]>();
		requestParameters.put("representedOrganization.id.root", new String[]{"1.3.6.1.4.1.5884"});
		requestParameters.put("patientPerson.administrativeGenderCode.c", new String[]{"F"});
		requestParameters.put("age.v.v", new String[]{"47"});
		requestParameters.put("age.v.u", new String[]{"a"});
		requestParameters.put("taskContext.c.c", new String[]{"PROBLISTREV"});
		requestParameters.put("mainSearchCriteria.v.dn", new String[]{"acute+cystitis"});
		requestParameters.put("performer", new String[]{"PROV"});
		requestParameters.put("informationRecipient", new String[]{"PROV"});
		requestParameters.put("knowledgeResponseType", new String[]{"text/xml"});
		return requestParameters;
		
	}
	
	/**
	 * Builds test request object
	 * 
	 * @return request
	 */
	@SuppressWarnings("boxing")
	public static Map<String, String[]> clopidogrelRxNormRequest() {
		
		Map<String, String[]> requestParameters = new HashMap<String, String[]>();
		requestParameters.put("representedOrganization.id.root", new String[]{"1.3.6.1.4.1.5884"});
		requestParameters.put("patientPerson.administrativeGenderCode.c", new String[]{"F"});
		requestParameters.put("age.v.v", new String[]{"47"});
		requestParameters.put("age.v.u", new String[]{"a"});
		requestParameters.put("taskContext.c.c", new String[]{"MEDOE"});
		requestParameters.put("mainSearchCriteria.v.dn", new String[]{"Clopidogrel+75mg+oral+tablet"});
		requestParameters.put("performer", new String[]{"PROV"});
		requestParameters.put("informationRecipient", new String[]{"PROV"});
		requestParameters.put("knowledgeResponseType", new String[]{"text/xml"});
		return requestParameters;
		
	}
	
	/**
	 * Builds test request object
	 * 
	 * @return request
	 */
	@SuppressWarnings("boxing")
	public static Map<String, String[]> neurofibromatosisSubsetRequest() {
		
		Map<String, String[]> requestParameters = new HashMap<String, String[]>();
		requestParameters.put("representedOrganization.id.root", new String[]{"1.3.6.1.4.1.5884"});
		requestParameters.put("patientPerson.administrativeGenderCode.c", new String[]{"F"});
		requestParameters.put("age.v.v", new String[]{"5"});
		requestParameters.put("age.v.u", new String[]{"a"});
		requestParameters.put("taskContext.c.c", new String[]{"PROBLISTREV"});
		requestParameters.put("mainSearchCriteria.v.c", new String[]{"237.7"});
		requestParameters.put("mainSearchCriteria.v.cs", new String[]{"2.16.840.1.113883.6.103"});
		requestParameters.put("mainSearchCriteria.v.dn", new String[]{"Neurofibromatosis"});
		requestParameters.put("performer", new String[]{"PROV"});
		requestParameters.put("informationRecipient", new String[]{"PROV"});
		requestParameters.put("knowledgeResponseType", new String[]{"text/xml"});
		return requestParameters;
		
	}
	
	
	@Test
	public void assertNumberProfiles() {
		
		assertEquals(countRowsInTable("resource_profiles"), 22);
	}
	
	@SuppressWarnings("deprecation")
	protected final int countRowsInTable(final String tableName)
	{
		return jdbcTemplate.queryForInt("SELECT COUNT(0) from " + tableName);
	}
	
	protected final String loadResponseXML(URI path, Charset encoding) throws IOException 
	{ 
		
		  byte[] encoded = Files.readAllBytes(Paths.get(path));
		  return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}
	
	/**
	 * Marshalls response object to XML for comparison
	 * 
	 * @param response
	 * @return xml
	 */
	@SuppressWarnings("boxing")
	protected final String marshallXML(AggregateKnowledgeResponse response)
	{
		StringWriter xml = new StringWriter();
		try {
			JAXBContext ctx = JAXBContext.newInstance(AggregateKnowledgeResponse.class);
			Marshaller m =ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			m.marshal(new JAXBElement<AggregateKnowledgeResponse>(
					  new QName("aggregateKnowledgeResponse"), AggregateKnowledgeResponse.class, response ), doc);
			Source source = new DOMSource(doc);
			xml = new StringWriter();
			Result result = new StreamResult(xml);
			TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer transformer = tfactory.newTransformer();
	        transformer.transform(source, result);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
        return xml.getBuffer().toString();
	        
	}
 
}
