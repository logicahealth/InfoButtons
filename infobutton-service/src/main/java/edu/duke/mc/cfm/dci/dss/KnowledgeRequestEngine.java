package edu.duke.mc.cfm.dci.dss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hl7.v3.AggregateKnowledgeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import edu.duke.mc.cfm.dci.infobutton.AccessCheckHandler;
import edu.duke.mc.cfm.dci.infobutton.ContextProfileHandler;
import edu.duke.mc.cfm.dci.infobutton.KnowledgeRequest;
import edu.duke.mc.cfm.dci.infobutton.RequestResult;
import edu.duke.mc.cfm.dci.infobutton.ResponseGenerator;
import edu.duke.mc.cfm.dci.infobutton.TaskCheckHandler;


/*
$Rev:: 2138          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2011-02-11 1#$:  Date of last commit
*/

@Component
public class KnowledgeRequestEngine {

	@Autowired
	ResponseGenerator rg;
	public Document getResponse(KnowledgeRequest knowledgeRequest) {
		Document doc = null ;
		List<RequestResult> result = returnResult(knowledgeRequest);
		Collections.sort(result);
		AggregateKnowledgeResponse responseType = new AggregateKnowledgeResponse();
		try {
			if (!result.isEmpty()) 
				responseType = rg.returnResponse(knowledgeRequest, result);
			JAXBContext ctx = JAXBContext.newInstance(AggregateKnowledgeResponse.class);
			Marshaller m =ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			m.marshal(new JAXBElement<AggregateKnowledgeResponse>(
					  new QName("knowledgeResponse"), AggregateKnowledgeResponse.class, responseType ), doc);
		} catch (PropertyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

	private List<RequestResult> returnResult(KnowledgeRequest request) {
		
		List<RequestResult> result = new ArrayList<RequestResult>();
		if (AccessCheckHandler.handleRequest(request)) {
			return result;
		} else if (TaskCheckHandler.handleRequest(request)) {
			return result;
		} else {
			ContextProfileHandler contextProfileHandlerObject = new ContextProfileHandler();
			result = contextProfileHandlerObject.handleRequest(request);
			return result;
		}	
	}
}
