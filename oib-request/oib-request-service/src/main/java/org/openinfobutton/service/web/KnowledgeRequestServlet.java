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
package org.openinfobutton.service.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import javax.xml.transform.stream.StreamSource;

import org.hl7.v3.AggregateKnowledgeResponse;
import org.hl7.v3.CategoryType;
import org.hl7.v3.REDSMT010001UVKnowledgeRequestNotification;
import org.openinfobutton.schema.CodeConstants;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schema.Encounter;
import org.openinfobutton.schema.Holder;
import org.openinfobutton.schema.IDLite;
import org.openinfobutton.schema.InformationRecipient;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.MainSearchCriteria;
import org.openinfobutton.schema.Patient;
import org.openinfobutton.schema.PatientContext;
import org.openinfobutton.schema.Performer;
import org.openinfobutton.schema.SeverityObservation;
import org.openinfobutton.schema.TaskContext;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.service.profile.ResourceProfileLoaderNew;
import org.openinfobutton.service.utility.WebServiceUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.w3c.dom.Document;

import com.google.gson.Gson;

import edu.utah.further.subsetdb.service.LogsDao;



@Component("knowledgeRequestServlet")
public class KnowledgeRequestServlet implements HttpRequestHandler {
	
	@Autowired
	@Qualifier("logDao")
	private LogsDao dao;
	private static final long serialVersionUID = 1L;
	@Autowired
	KnowledgeRequestEngine engine;
	/**
	 * Starting point. This is where the infobutton request enters the system
	 */
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		Map<String, String[]> requestParameters = req.getParameterMap();
		KnowledgeRequest knowledgeRequest=WebServiceUtility.getServiceRequest(requestParameters);
		ResourceProfileLoaderNew.setMode(knowledgeRequest.getExecutionMode());
		REDSMT010001UVKnowledgeRequestNotification request = KnowledgeRequest.getJAXBElement(knowledgeRequest);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		JAXBContext ctx;
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;
		try {
			ctx = JAXBContext.newInstance(REDSMT010001UVKnowledgeRequestNotification.class);
			Marshaller m =ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			m.marshal(new JAXBElement<REDSMT010001UVKnowledgeRequestNotification>(
					  new QName("knowledgeRequestNotification"), REDSMT010001UVKnowledgeRequestNotification.class, request ), doc);
			//Code below is for getting the large xml string from request
			Source source = new DOMSource(doc);
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult(stringWriter);
            TransformerFactory tfactory = TransformerFactory.newInstance();
            Transformer transformer;
			transformer = tfactory.newTransformer();
			transformer.transform(source, result);
			String orgid= knowledgeRequest.getHolder().getRepresentedOrganization().getRoot();
			dao.saveRequest(stringWriter.toString(), req.getRemoteAddr(), orgid);//Log written here
			AggregateKnowledgeResponse response = engine.getResponse(knowledgeRequest);
			ctx = JAXBContext.newInstance(AggregateKnowledgeResponse.class);
			m =ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			m.marshal(new JAXBElement<AggregateKnowledgeResponse>(
					  new QName("aggregateKnowledgeResponse"), AggregateKnowledgeResponse.class, response ), doc);
			resp.setContentType("text/html");
            source = new DOMSource(doc);
            stringWriter = new StringWriter();
            result = new StreamResult(stringWriter);
            tfactory = TransformerFactory.newInstance();
            transformer = tfactory.newTransformer();
            transformer.transform(source, result);//now stringwriter has xml.
            String knowledgeResType = req.getParameter(CodeConstants.KNOWLEDGE_RESPONSE_TYPE);
            if ((req.getParameter("transform") != null)||(knowledgeResType!=null)) 
            {
            	if(knowledgeResType!=null)
            	{
            		if(knowledgeResType.equals("application/json"))
            		{
            			Gson gson = new Gson();
            			resp.setContentType("application/json");
            			out.println(gson.toJson(response));
            		}
            		else if(knowledgeResType.equals("text/xml"))
            		{
                		resp.setContentType("text/xml");
                		out.println(stringWriter.getBuffer().toString());
                	}
            	}
            	else//for backward compatibility with 'transform' in URL
            	{
            		resp.setContentType("text/xml");
            		out.println(stringWriter.getBuffer().toString());
            	}
            } 
            else
            {
            	String transformation = "Infobutton_UI";
            	if (req.getParameter("xsltTransform") != null)
            		transformation = req.getParameter("xsltTransform");
            	transformer = tfactory.newTransformer(new StreamSource(req.getSession().getServletContext().getResourceAsStream("/WEB-INF/xslts/"+transformation + ".xslt")));
            	stringWriter=new StringWriter();
            	result = new StreamResult(stringWriter);
            	transformer.transform(source, result);
            	out.println(stringWriter.getBuffer().toString());
            }
		
			} catch (JAXBException e) {
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
			finally{
				out.close();
			}
	}
}
