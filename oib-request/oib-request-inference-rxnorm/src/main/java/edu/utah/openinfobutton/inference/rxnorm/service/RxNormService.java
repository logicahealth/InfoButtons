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
package edu.utah.openinfobutton.inference.rxnorm.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schemas.kb.Code;

import edu.utah.further.core.api.xml.XmlService;
import edu.utah.further.core.xml.jaxb.XmlServiceImpl;
import edu.utah.openinfobutton.inference.rxnorm.schema.ApproximateGroup.Candidate;
import edu.utah.openinfobutton.inference.rxnorm.schema.RelatedGroup;
import edu.utah.openinfobutton.inference.rxnorm.schema.RelatedGroup.ConceptGroup.ConceptProperties;
import edu.utah.openinfobutton.inference.rxnorm.schema.RxNormData;

/**
 * The Class RxNormService.
 */
public final class RxNormService
{
    
    /** The Constant RXNORM_REST_URL. */
    private static final String RXNORM_REST_URL = "http://rxnav.nlm.nih.gov/REST/";

    /** The Constant APPROX_TERM_ARG. */
    private static final String APPROX_TERM_ARG = "approximateTerm?term=";

    /** The Constant RXCUI_ARG. */
    private static final String RXCUI_ARG = "rxcui/";

    /** The Constant RELATED_TTY_IN_ARG. */
    private static final String RELATED_TTY_IN_ARG = "/related?tty=IN";

    /** The Constant RXNORM. */
    private static final String RXNORM = "2.16.840.1.113883.6.88";

    /** The Constant xmlService. */
    private static final XmlService xmlService = new XmlServiceImpl();

    /**
     * Instantiates a new rx norm service.
     */
    private RxNormService(){}
    
    /**
     * Gets the code.
     *
     * @param code the code
     * @return the code
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Code getTransformedCode( final Code code )
        throws IOException
    {

        final List<Candidate> candidates = getCandidates( code.getDisplayName() );
        final Code transformedCode = CodeUtility.getCode( code );
        for ( final Candidate candidate : candidates )
        {
            final RelatedGroup group = getRelatedGroup( candidate.getRxcui() );
            final List<ConceptProperties> properties = group.getConceptGroup().get( 0 ).getConceptProperties();
            if ( properties != null )
            {
                transformedCode.setCode( properties.get( 0 ).getRxcui() );
                transformedCode.setDisplayName( properties.get( 0 ).getName() );
                transformedCode.setCodeSystem( RXNORM );
                break;
            }
        }

        return transformedCode;
    }

    /**
     * Gets the candidates.
     *
     * @param displayName the display name
     * @return the candidates
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static List<Candidate> getCandidates( final String displayName )
        throws IOException
    {
        List<Candidate> candidates = new ArrayList<Candidate>();
        final StringBuilder arg = new StringBuilder( APPROX_TERM_ARG );
        arg.append( URLEncoder.encode( displayName, "UTF-8" ) );
        final InputStream response = getResponse( arg.toString() );

        try
        {
            final RxNormData data = xmlService.unmarshal( response, RxNormData.class );
            candidates = data.getApproximateGroup().getCandidates();
        }
        catch ( final JAXBException e )
        {
            System.err.println( "ApproxGroup unmarshalling failed" );
            e.printStackTrace();
        }

        return candidates;
    }

    /**
     * Gets the related group.
     *
     * @param rxcui the rxcui
     * @return the related group
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static RelatedGroup getRelatedGroup( final String rxcui )
        throws IOException
    {
        RelatedGroup group = new RelatedGroup();
        final StringBuilder arg = new StringBuilder( RXCUI_ARG );
        arg.append( rxcui );
        arg.append( RELATED_TTY_IN_ARG );
        final InputStream response = getResponse( arg.toString() );

        try
        {
            final RxNormData data = xmlService.unmarshal( response, RxNormData.class );
            group = data.getRelatedGroup();
        }
        catch ( final JAXBException e )
        {
            System.err.println( "RelatedGroup unmarshalling failed" );
            e.printStackTrace();
        }

        return group;
    }

    /**
     * Gets the response.
     *
     * @param arg the arg
     * @return the response
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static InputStream getResponse( String arg )
        throws IOException
    {
        final HttpClient httpClient = new DefaultHttpClient();
        // Two lines added for the proxy
        // HttpHost proxy = new HttpHost("155.100.9.11", 8080);
        // httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        final HttpGet get = new HttpGet( RXNORM_REST_URL + arg );
        final HttpResponse response = httpClient.execute( get );
        final HttpEntity entity = response.getEntity();
        return entity.getContent();
    }
}
