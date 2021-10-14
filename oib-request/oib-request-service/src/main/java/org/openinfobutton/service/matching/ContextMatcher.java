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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.CDset;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.service.transform.TransformCode;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;

import org.openinfobutton.externalresource.api.ExternalResourceHandler;
import org.openinfobutton.externalresource.api.TerminologyHandler;

/**
 * The Class ContextMatcher.
 */
@Configurable( preConstruction = true )
public abstract class ContextMatcher
{

    /**
     * Match context.
     *
     * @return the boolean
     */
    public abstract Boolean MatchContext();

    /** The log. */
    Logger log = LogManager.getLogger( ContextMatcher.class.getName() );

    /** The ES handler. */
    @Autowired
    @Qualifier( "externalSet" )
    private TerminologyHandler ESHandler;

    /** The handler. */
    @Autowired
    ExternalResourceHandler handler;

    /** The tc. */
    @Autowired
    TransformCode tc;

    /**
     * Code match.
     *
     * @param c the c
     * @param context the context
     * @param supportedCodeSystems the supported code systems
     * @param runTerminologyInference the run terminology inference
     * @param request the request
     * @return the boolean
     */
    protected final Boolean CodeMatch( Code c, CodedContextElement context, List<String> supportedCodeSystems,
                                 boolean runTerminologyInference, KnowledgeRequest request )
    {

        Code code = c;
        Boolean match = false;
        if ( context != null && context.isMatch() )
        {
            if ( runTerminologyInference )
            {
                code = tc.transformInput( context, code, supportedCodeSystems, request );
            }
            List<Code> codes;
            if ( context.getMatchingDomain().getEnumeration() != null )
            {
                codes = getCodeListFromContext( context );
                for ( final Code contextCode : codes )
                {
                    if ( code.getCodeSystem().equals( contextCode.getCodeSystem() ) )
                    {
                        if ( code.getCode().equals( contextCode.getCode() ) )
                        {
                            match = true;
                            break;
                        }
                    }
                }
                if ( context.getMatchingDomain().getEnumeration().isIncludeDescendants() && !match )
                {
                    for ( final Code contextCode : codes )
                    {
                        if ( handler.isDescendant( code, contextCode ) )
                        {
                            match = true;
                            log.debug( code.getCode() + " is a Descendant of " + contextCode.getCode() );
                            break;
                        }
                    }
                }
            }
            else
            {
                final List<Id> subsetIdList = context.getMatchingDomain().getExternalValueSet();
                match = ESHandler.isSubsetMember( code, subsetIdList );
            }
        }
        else
        {
            match = true;
        }
        return match;
    }

    /**
     * Gets the code list from context.
     *
     * @param context the context
     * @return the code list from context
     */
    private List<Code> getCodeListFromContext( CodedContextElement context )
    {

        List<Code> codes = new ArrayList<Code>();
        final CDset codeset = context.getMatchingDomain().getEnumeration();
        codes = codeset.getCode();
        return codes;
    }
}
