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
package org.openinfobutton.service.matching;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.MainSearchCriteria;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.springframework.beans.factory.annotation.Autowired;

import org.openinfobutton.externalresource.api.ExternalResourceHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class MainSearchCriteriaMatcher.
 */
public class MainSearchCriteriaMatcher
    extends ContextMatcher
{

    /** The main search. */
    public MainSearchCriteria mainSearch;

    /** The log. */
    Logger log = LogManager.getLogger( MainSearchCriteriaMatcher.class.getName() );

    /** The context. */
    public CodedContextElement context;

    /** The handler. */
    @Autowired
    ExternalResourceHandler handler;

    /** The request. */
    KnowledgeRequest request;

    /** The supported code systems. */
    List<String> supportedCodeSystems;

    /**
     * Instantiates a new main search criteria matcher.
     *
     * @param context the context
     * @param request the request
     * @param supportedCodeSystems the supported code systems
     */
    public MainSearchCriteriaMatcher( CodedContextElement context, KnowledgeRequest request,
                                      List<String> supportedCodeSystems )
    {

        this.mainSearch = request.getMainSearchCriteria();
        this.context = context;
        this.request = request;
        this.supportedCodeSystems = supportedCodeSystems;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.matching.ContextMatcher#MatchContext()
     */
    @Override
    public Boolean MatchContext()
    {
        Boolean match = false;
        Code code = mainSearch.getCode();
        log.debug( "Matching MainSearchCriteria..." );
        if ( code.getCode().equals( "" ) && request.getSearchCodes().size() > 0 )
        {
            for (Code searchCode : request.getSearchCodes()) {
                 if (supportedCodeSystems.contains(searchCode.getCodeSystem()))
                 {
                     code = searchCode;
                 }
             }// this is to ensure the free text is also matched with a valid code
        }
        match = CodeMatch( code, context, supportedCodeSystems, true, request );
        log.debug( "Match MainSearchCriteria RESULT = " + match );
        return match;
    }
}
