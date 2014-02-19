package org.openinfobutton.request.service;

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
import java.util.Enumeration;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.w3c.dom.Document;

import com.google.gson.Gson;

import edu.utah.further.subsetdb.service.LogsDao;



@Configurable(dependencyCheck = false)
public class LogServlet extends HttpServlet {
	
	@Autowired
	@Qualifier("logDao")
	private LogsDao dao;
	private static final long serialVersionUID = 1L;
	/**
	 * Starting point. This is where the logging request enters the system
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		try {
			out.println("The log service is available.");
		}
		finally{
			out.close();
		}
	}
	
	
	/**
	 * Starting point. This is where the logging request enters the system
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		Map<String, String[]> requestParameters = req.getParameterMap();
		resp.setCharacterEncoding("UTF-8");
		try {
			String logType = req.getParameter("type");
			if (logType == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
			} else if (logType.equals("resourceRequest")) {
				String formattedRequest = String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><resourceRequest><url>%s</url><requestUUID>%s</requestUUID></resourceRequest>",
						req.getParameter("url"), req.getParameter("requestUUID"));
				dao.saveRequest(formattedRequest, req.getRemoteAddr(), "", req.getQueryString());
				resp.setStatus(HttpServletResponse.SC_OK);
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
			}
		}
		finally{
			//out.close();
		}
	}
}
