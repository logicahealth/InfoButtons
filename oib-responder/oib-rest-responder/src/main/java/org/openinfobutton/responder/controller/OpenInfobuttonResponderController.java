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
package org.openinfobutton.responder.controller;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.responder.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class OpenInfobuttonResponderController.
 *
 * @author rick
 */
@Controller
public class OpenInfobuttonResponderController
{

    /** The Constant INDEX_PAGE. */
    public static final String INDEX_PAGE = "index";

    /** The Constant ATOM_PAGE. */
    public static final String ATOM_PAGE = "searchResultsAtom";

    /** The Constant HTML_PAGE. */
    public static final String HTML_PAGE = "searchResultsHtml";

    /** The Constant ATOM_FEED_KEY. */
    public static final String ATOM_FEED_KEY = "atom.feed";

    /** The responder service. */
    @Autowired
    private ResponderService responderService;

    /** The atom feed metadata. */
    private Properties atomFeedMetadata;

    /** The index property interpretation map. */
    private Map<String, Map<String, String>> indexPropertyInterpretationMap;

    /**
     * Sets the responder service.
     *
     * @param responderService the new responder service
     */
    public void setResponderService( ResponderService responderService )
    {
        this.responderService = responderService;
    }

    /**
     * Sets the atom feed metadata.
     *
     * @param atomFeedMetadata the new atom feed metadata
     */
    public void setAtomFeedMetadata( Properties atomFeedMetadata )
    {
        this.atomFeedMetadata = atomFeedMetadata;
    }

    /**
     * Sets the index property interpretation map.
     *
     * @param indexPropertyInterpretationMap the index property interpretation map
     */
    public void setIndexPropertyInterpretationMap( Map<String, Map<String, String>> indexPropertyInterpretationMap )
    {
        this.indexPropertyInterpretationMap = indexPropertyInterpretationMap;
    }

    /**
     * Sets the required response objects.
     */
    private void setRequiredResponseObjects()
    {

        if ( this.atomFeedMetadata == null )
        {
            this.atomFeedMetadata = responderService.getApplicationProperties( ATOM_FEED_KEY );
        }
        if ( this.indexPropertyInterpretationMap == null )
        {
            this.indexPropertyInterpretationMap = responderService.getIndexPropertyInterpretationMap();
        }

    }

    /**
     * Index page request.
     *
     * @return the string
     */
    @RequestMapping( "/" )
    public String indexPageRequest()
    {
        return INDEX_PAGE;
    }

    /**
     * Open infobutton request handler.
     *
     * @param request the request
     * @param response the response
     * @param model the model
     * @return the string
     * @throws MissingServletRequestParameterException the missing servlet request parameter exception
     * @throws HttpMediaTypeNotSupportedException the http media type not supported exception
     * @throws IllegalArgumentException the illegal argument exception
     */
    @RequestMapping( "/responder" )
    public String openInfobuttonRequestHandler( HttpServletRequest request, HttpServletResponse response, ModelMap model )
        throws MissingServletRequestParameterException, HttpMediaTypeNotSupportedException, IllegalArgumentException
    {

        response.setHeader( "Cache-Control", "no-cache" );
        // todo: if authorization is required return 401 when not authorized

        setRequiredResponseObjects();

        // throws IllegalArgumentException
        final Map<String, String> requestParameters =
            responderService.getKnowledgeRequestParameterMap( request.getParameterMap() );

        // throws MissingServletRequestParameterException
        responderService.requestContainsRequiredParameters( requestParameters );
        final Collection<Asset> matchedAssets = responderService.findAssetsByInfobuttonRequest( requestParameters );

        model.addAttribute( "atomFeedMetadata", this.atomFeedMetadata );
        model.addAttribute( "indexPropertyInterpretationMap", this.indexPropertyInterpretationMap );
        model.addAttribute( "requestParameters", requestParameters );
        model.addAttribute( "assets", matchedAssets );

        final String viewType = requestParameters.get( "knowledgeResponseType" );

        if ( viewType == null )
        { // default
            return ATOM_PAGE;
        }
        else if ( "text/html".equals( viewType ) )
        {
            return HTML_PAGE;
        }
        else if ( "text/xml".equals( viewType ) )
        {
            return ATOM_PAGE;
        }
        else
        {
            throw new HttpMediaTypeNotSupportedException( "Unsupported knowledgeResponseType: " + viewType );
        }

    }

    /**
     * Handle http media type not supported exception.
     */
    @ResponseStatus( value = HttpStatus.UNSUPPORTED_MEDIA_TYPE, reason = "Requested knowedgeResourceType not supported." )
    @ExceptionHandler( HttpMediaTypeNotSupportedException.class )
    public void handleHttpMediaTypeNotSupportedException()
    {
        // logic handled by annotations
    }

    /**
     * Handle missing servlet request parameter exception.
     */
    @ResponseStatus( value = HttpStatus.BAD_REQUEST, 
                    reason = "Missing required parameter(s): mainSearchCriteria.v.c, " +
                               "mainSearchCriteria.v.cs, or taskContext.c.c" )
    // 400
    @ExceptionHandler( MissingServletRequestParameterException.class )
    public void handleMissingServletRequestParameterException()
    {
        // logic handled by annotations
    }

    /**
     * Handle illegal argument exception.
     */
    @ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "Illegal argument: each parameter name must be distict.  "
        + "Parameters that support cardinality greater than 1 require distinct trailing numeric values." )
    // 400
    @ExceptionHandler( IllegalArgumentException.class )
    public void handleIllegalArgumentException()
    {
        // logic handled by annotations
    }

}
