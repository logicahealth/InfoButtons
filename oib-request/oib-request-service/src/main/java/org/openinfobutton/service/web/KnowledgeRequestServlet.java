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
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.google.gson.Gson;

import org.openinfobutton.subsetdb.service.LogsDao;

/**
 * The Class KnowledgeRequestServlet.
 */
@RestController
@RequestMapping("infoRequest")
public class KnowledgeRequestServlet
{

    /** The dao. */
    @Autowired
    @Qualifier( "logsDbDao" )
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
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @GetMapping
    public ResponseEntity<String> infoRequest(@RequestParam final Map<String,String[]> requestParameters, HttpServletRequest req)
    {

        final KnowledgeRequest knowledgeRequest = WebServiceUtility.getServiceRequest( req.getParameterMap() );
        ResourceProfileLoaderNew.setMode( knowledgeRequest.getExecutionMode() );
        final REDSMT010001UVKnowledgeRequestNotification request = KnowledgeRequest.getJAXBElement( knowledgeRequest );
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
            source = new DOMSource( doc );
            stringWriter = new StringWriter();
            result = new StreamResult( stringWriter );
            tfactory = TransformerFactory.newInstance();
            transformer = tfactory.newTransformer();
            transformer.transform( source, result );// now stringwriter has xml.
            String finalXml = new String();
            final HttpHeaders httpHeaders= new HttpHeaders();
            final String knowledgeResType = req.getParameter( CodeConstants.KNOWLEDGE_RESPONSE_TYPE );
            if ( ( req.getParameter( "transform" ) != null ) || ( knowledgeResType != null ) )
            {
                if ( knowledgeResType != null )
                {
                    if ( knowledgeResType.equals( "application/json" ) )
                    {
                        final Gson gson = new Gson();
                        finalXml = gson.toJson(response);
                        dao.saveRequest( req.getQueryString(), finalXml, req.getRemoteAddr(), orgid );// Log written here
                        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                        return new ResponseEntity<>(finalXml, httpHeaders, HttpStatus.OK);
                    }
                    else if ( knowledgeResType.equals( "text/xml" ) )
                    {

                        //temp fix for conforming to output standard
                        finalXml = stringWriter.getBuffer().toString();
                        finalXml = finalXml.replace("<aggregateKnowledgeResponse xml:lang=\"en\">", "<aggregateKnowledgeResponse xmlns=\"http://www.w3.org/2005/Atom\" xml:lang=\"en\">");
                        httpHeaders.setContentType(MediaType.APPLICATION_XML);
                        return new ResponseEntity<>(finalXml, httpHeaders, HttpStatus.OK);
                    }
                    else
                    {
                        //temp fix for conforming to output standard
                        finalXml = stringWriter.getBuffer().toString();
                        finalXml = finalXml.replace("<aggregateKnowledgeResponse xml:lang=\"en\">", "<aggregateKnowledgeResponse xmlns=\"http://www.w3.org/2005/Atom\" xml:lang=\"en\">");
                        httpHeaders.setContentType(MediaType.APPLICATION_XML);
                        return new ResponseEntity<>(finalXml, httpHeaders, HttpStatus.OK);
                    }
                }
                else
                // for backward compatibility with 'transform' in URL
                {

                    //temp fix for conforming to output standard
                    finalXml = stringWriter.getBuffer().toString();
                    finalXml = finalXml.replace("<aggregateKnowledgeResponse xml:lang=\"en\">", "<aggregateKnowledgeResponse xmlns=\"http://www.w3.org/2005/Atom\" xml:lang=\"en\">");
                    dao.saveRequest( req.getQueryString(), finalXml, req.getRemoteAddr(), orgid );// Log written here
                    httpHeaders.setContentType(MediaType.APPLICATION_XML);
                    return new ResponseEntity<>(finalXml, httpHeaders, HttpStatus.OK);
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
                dao.saveRequest( req.getQueryString(), finalXml, req.getRemoteAddr(), orgid );// Log written here
                httpHeaders.setContentType(MediaType.TEXT_HTML);
                return new ResponseEntity<>(stringWriter.getBuffer().toString(), httpHeaders, HttpStatus.OK);
            }
        }
        catch ( final JAXBException e )
        {
            e.printStackTrace();
            final HttpHeaders httpHeaders= new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch ( final TransformerConfigurationException e )
        {
            e.printStackTrace();
            final HttpHeaders httpHeaders= new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch ( final TransformerException e )
        {
            e.printStackTrace();
            final HttpHeaders httpHeaders= new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch ( final ParserConfigurationException e )
        {
            e.printStackTrace();
            final HttpHeaders httpHeaders= new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (final OIBProfileProcessingException e)
        {
            final HttpHeaders httpHeaders= new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (final RuntimeException e)
        {
            e.printStackTrace();
            final HttpHeaders httpHeaders= new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
