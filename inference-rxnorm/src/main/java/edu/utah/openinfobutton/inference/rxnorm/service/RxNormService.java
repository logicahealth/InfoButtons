/*******************************************************************************
 * Source File: RxNormService.java
 ******************************************************************************/
package edu.utah.openinfobutton.inference.rxnorm.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;

import edu.duke.mc.cfm.dci.infobutton.CodeUtility;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
import edu.utah.further.core.api.xml.XmlService;
import edu.utah.further.core.xml.jaxb.XmlServiceImpl;
import edu.utah.openinfobutton.inference.rxnorm.schema.ApproxGroup.Candidate;
import edu.utah.openinfobutton.inference.rxnorm.schema.RelatedGroup;
import edu.utah.openinfobutton.inference.rxnorm.schema.RelatedGroup.ConceptGroup.ConceptProperties;
import edu.utah.openinfobutton.inference.rxnorm.schema.RxNormData;

/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2012 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Aug 13, 2012
 */
public class RxNormService
{
	private static final String RXNORM_REST_URL = "http://rxnav.nlm.nih.gov/REST/";
	
	private static final String APPROX_TERM_ARG ="approx?term=";
	
	private static final String RXCUI_ARG="rxcui/";
	
	private static final String RELATED_TTY_IN_ARG="/related?tty=IN";
	
	private static final String RXNORM ="2.16.840.1.113883.6.88";
	
	private static final XmlService xmlService = new XmlServiceImpl();
	
	public static Code getCode(final Code code) throws IOException
	{
		
		List<Candidate> candidates = getCandidates(code.getDisplayName());
		final Code transformedCode = CodeUtility.getCode(code);
		for (Candidate candidate : candidates)
		{
			RelatedGroup group = getRelatedGroup(candidate.getRxcui());
			List<ConceptProperties> properties = group.getConceptGroup().get(0).getConceptProperties();
			if (properties != null)
			{
				transformedCode.setCode(properties.get(0).getRxcui());
				transformedCode.setDisplayName(properties.get(0).getName());
				transformedCode.setCodeSystem(RXNORM);
				break;
			}
		}
		
		
		return transformedCode;
	}
	
	private static List<Candidate> getCandidates(final String displayName) throws IOException
	{
		List<Candidate> candidates = new ArrayList<Candidate>();
		StringBuilder arg = new StringBuilder(APPROX_TERM_ARG);
		arg.append(URLEncoder.encode(displayName, "UTF-8"));
		final InputStream response = getResponse(arg.toString());
		
		try 
		{
			final RxNormData data = xmlService.unmarshal(response, RxNormData.class);
			candidates = data.getApproxGroup().getCandidates();
		}
		catch (JAXBException e)
		{
			System.err.println("ApproxGroup unmarshalling failed");
			e.printStackTrace();
		}
		
		return candidates;
	}
	
	private static RelatedGroup getRelatedGroup(final String rxcui) throws IOException
	{
		RelatedGroup group = new RelatedGroup();
		StringBuilder arg = new StringBuilder(RXCUI_ARG);
		arg.append(rxcui);
		arg.append(RELATED_TTY_IN_ARG);
		final InputStream response = getResponse(arg.toString());
		
		try
		{
			RxNormData data = xmlService.unmarshal(response, RxNormData.class);
			group = data.getRelatedGroup();
		}
		catch (JAXBException e)
		{	
			System.err.println("RelatedGroup unmarshalling failed");
			e.printStackTrace();
		}
		
		return group;
	}
	
	private static InputStream getResponse(String arg) throws IOException
	{	
		final HttpClient httpClient = new DefaultHttpClient();
		//Two lines added for the proxy
//		HttpHost proxy = new HttpHost("155.100.9.11", 8080);
//		httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		final HttpGet get = new HttpGet(RXNORM_REST_URL + arg);
		HttpResponse response = httpClient.execute(get);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}
}
