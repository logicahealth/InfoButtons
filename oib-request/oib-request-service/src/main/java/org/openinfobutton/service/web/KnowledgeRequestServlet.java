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
 * @version Jul 15, 2014
 */
package org.openinfobutton.service.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.ServletException;
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
import org.hl7.v3.REDSMT010001UVKnowledgeRequestNotification;
import org.openinfobutton.exception.OIBProfileProcessingException;
import org.openinfobutton.schema.CodeConstants;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.service.profile.ResourceProfileLoaderNew;
import org.openinfobutton.service.utility.WebServiceUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.w3c.dom.Document;

import com.google.gson.Gson;

import edu.utah.further.subsetdb.service.LogsDao;

/**
 * The Class KnowledgeRequestServlet.
 */
@Component( "knowledgeRequestServlet" )
public class KnowledgeRequestServlet
    implements HttpRequestHandler
{

    /** The dao. */
    @Autowired
    @Qualifier( "logDao" )
    private LogsDao dao;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The engine. */
    @Autowired
    KnowledgeRequestEngine engine;

    /**
     * Starting point. This is where the infobutton request enters the system
     *
     * @param req the req
     * @param resp the resp
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void handleRequest( HttpServletRequest req, HttpServletResponse resp )
        throws ServletException, IOException
    {
        final Map<String, String[]> requestParameters = req.getParameterMap();
        final KnowledgeRequest knowledgeRequest = WebServiceUtility.getServiceRequest( requestParameters );
        ResourceProfileLoaderNew.setMode( knowledgeRequest.getExecutionMode() );
        final REDSMT010001UVKnowledgeRequestNotification request = KnowledgeRequest.getJAXBElement( knowledgeRequest );
        resp.setCharacterEncoding( "UTF-8" );
        final PrintWriter out = resp.getWriter();
        JAXBContext ctx;
        DocumentBuilderFactory dbf;
        DocumentBuilder db;
        Document doc;
        try
        {
            ctx = JAXBContext.newInstance( REDSMT010001UVKnowledgeRequestNotification.class );
            Marshaller m = ctx.createMarshaller();
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware( true );
            db = dbf.newDocumentBuilder();
            doc = db.newDocument();
            m.marshal( new JAXBElement<REDSMT010001UVKnowledgeRequestNotification>(
                       new QName("knowledgeRequestNotification" ), REDSMT010001UVKnowledgeRequestNotification.class,request ), 
                       doc );
            // Code below is for getting the large xml string from request
            Source source = new DOMSource( doc );
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult( stringWriter );
            TransformerFactory tfactory = TransformerFactory.newInstance();
            Transformer transformer;
            transformer = tfactory.newTransformer();
            transformer.transform(source, result);
            final String orgid = knowledgeRequest.getHolder().getRepresentedOrganization().getRoot();
            final AggregateKnowledgeResponse response = engine.getResponse( knowledgeRequest );
            ctx = JAXBContext.newInstance(AggregateKnowledgeResponse.class);
            m = ctx.createMarshaller();
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware( true );
            db = dbf.newDocumentBuilder();
            doc = db.newDocument();
            m.marshal(new JAXBElement<AggregateKnowledgeResponse>(new QName("aggregateKnowledgeResponse"),
                    AggregateKnowledgeResponse.class, response), doc);
            resp.setContentType( "text/html" );
            source = new DOMSource( doc );
            stringWriter = new StringWriter();
            result = new StreamResult( stringWriter );
            tfactory = TransformerFactory.newInstance();
            transformer = tfactory.newTransformer();
            transformer.transform( source, result );// now stringwriter has xml.
            String finalXml = new String();
            final String knowledgeResType = req.getParameter( CodeConstants.KNOWLEDGE_RESPONSE_TYPE );
            if ( ( req.getParameter( "transform" ) != null ) || ( knowledgeResType != null ) )
            {
                if ( knowledgeResType != null )
                {
                    if ( knowledgeResType.equals( "application/json" ) )
                    {
                        final Gson gson = new Gson();
                        resp.setContentType( "application/json" );
                        finalXml = gson.toJson(response);
                        out.println( finalXml );
                    }
                    else if ( knowledgeResType.equals( "text/xml" ) )
                    {
                        resp.setContentType( "text/xml" );
                        //temp fix for conforming to output standard
                        finalXml = stringWriter.getBuffer().toString();
                        finalXml = finalXml.replace("<aggregateKnowledgeResponse xml:lang=\"en\">", "<aggregateKnowledgeResponse xmlns=\"http://www.w3.org/2005/Atom\" xml:lang=\"en\">");
                        out.println( finalXml );
                    }
                }
                else
                // for backward compatibility with 'transform' in URL
                {
                    resp.setContentType( "text/xml" );
                    //temp fix for conforming to output standard
                    finalXml = stringWriter.getBuffer().toString();
                    finalXml = finalXml.replace("<aggregateKnowledgeResponse xml:lang=\"en\">", "<aggregateKnowledgeResponse xmlns=\"http://www.w3.org/2005/Atom\" xml:lang=\"en\">");
                    out.println( finalXml );
                }
            }
            else
            {
                finalXml = stringWriter.getBuffer().toString();
                String transformation = "Infobutton_UI";
                if ( req.getParameter( "xsltTransform" ) != null )
                {
                    transformation = req.getParameter( "xsltTransform" );
                }
                transformer =
                    tfactory.newTransformer( new StreamSource(req.getSession().
                                             getServletContext().getResourceAsStream( 
                                             "/WEB-INF/classes/xslts/" + transformation + ".xslt")));
                stringWriter = new StringWriter();
                result = new StreamResult( stringWriter );
                transformer.transform( source, result );
                stringWriter.getBuffer().toString();
                out.println( stringWriter.getBuffer().toString() );
            }
            dao.saveRequest( req.getQueryString(), finalXml, req.getRemoteAddr(), orgid );// Log written here

        }
        catch ( final JAXBException e )
        {
            e.printStackTrace();
        }
        catch ( final TransformerConfigurationException e )
        {
            e.printStackTrace();
        }
        catch ( final TransformerException e )
        {
            e.printStackTrace();
        }
        catch ( final ParserConfigurationException e )
        {
            e.printStackTrace();
        }
        catch (final OIBProfileProcessingException e)
        {
            out.println(e);
            throw e;
        }
        catch (final RuntimeException e)
        {
            e.printStackTrace();
        }
        finally
        {
            out.close();
        }
    }
}
