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

import org.apache.log4j.Logger;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Context;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.openinfobutton.service.profile.ResourceProfileProvider;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextProfileHandler.
 */
public class ContextProfileHandler
{

    /** The log. */
    Logger log = Logger.getLogger( ContextProfileHandler.class.getName() );

    /** The matcher. */
    @Autowired
    ContextMatcher matcher;

    /** The profiles. */
    public List<KnowledgeResourceProfile> profiles;

    /** The provider. */
    public ResourceProfileProvider provider;

    /** The request. */
    @Autowired
    public KnowledgeRequest request;

    /** The results. */
    public List<RequestResult> results;

    /**
     * Inits the profiles.
     */
    private void initProfiles()
    {
        provider = ResourceProfileProvider.getInstance();
        profiles = provider.getProfiles();
    }

    /**
     * Handle request.
     *
     * @param r the r
     * @return the list
     */
    public List<RequestResult> handleRequest( KnowledgeRequest r )
    {
        initProfiles();
        results = new ArrayList<RequestResult>();
        request = r;
        KnowledgeResourceProfile profile;
        for ( int i = 0; i < profiles.size(); i++ )
        {
            profile = profiles.get( i );
            results.add( matchContexts( profile ) );
        }
        ResourceProfileProvider.resetInstance();
        return results;
    }

    /**
     * The contexts in a profile are matched against the request.If successful the context is added to the result.
     *
     * @param profile the profile
     * @return RequestResult
     */
    private RequestResult matchContexts( KnowledgeResourceProfile profile )
    {
        log.debug( "Matching profile... " + profile.getHeader().getTitle() );
        final RequestResult result = new RequestResult( profile );
        final List<String> supportedCodeSystems = result.getSupportedCodeSystems();
        log.debug( "    SupportedCS " + supportedCodeSystems );
        final List<Context> contexts = profile.getProfileDefinition().getContexts().getContext();
        final int count = contexts.size();
        Context context;
        for ( int x = 0; x < count; x++ )
        {
            log.debug( "\tMatching Context Started..." );
            context = contexts.get( x );
            matcher = new TaskContextMatcher( context.getContextDefinition().getTask(), request, supportedCodeSystems );
            if ( !matcher.MatchContext() )
            {
                log.debug( "\t\tTaskContextMatcher FAILED" );
                continue;
            }
            matcher =
                new PerformerMatcher( context.getContextDefinition().getPerformerLanguage(),
                                      context.getContextDefinition().getPerformerDiscipline(),
                                      context.getContextDefinition().getPerformerKnowledgeUserType(), request,
                                      supportedCodeSystems );
            if ( !matcher.MatchContext() )
            {
                log.debug( "\t\tPerformerMatcher FAILED" );
                continue;
            }
            matcher =
                new InformationRecipientMatcher( context.getContextDefinition().getInformationRecipientLanguage(),
                                                 context.getContextDefinition().getInformationRecipientDiscipline(),
                                                 context.getContextDefinition().getInformationRecipientUserType(),
                                                 request, supportedCodeSystems );
            if ( !matcher.MatchContext() )
            {
                log.debug( "\t\tInformationRecipientMatcher FAILED" );
                continue;
            }
            matcher =
                new EncounterMatcher( context.getContextDefinition().getEncounterType(),
                                      context.getContextDefinition().getServiceDeliveryLocation(), request,
                                      supportedCodeSystems );
            if ( !matcher.MatchContext() )
            {
                log.debug( "\t\tEncounterMatcher FAILED" );
                continue;
            }
            matcher =
                new PatientContextMatcher( context.getContextDefinition().getPatientGender(),
                                           context.getContextDefinition().getPatientAgeGroup(), request,
                                           supportedCodeSystems );
            if ( !matcher.MatchContext() )
            {
                log.debug( "\t\tPatientContextMatcher FAILED" );
                continue;
            }
            matcher =
                new MainSearchCriteriaMatcher( context.getContextDefinition().getConceptOfInterest(), request,
                                               supportedCodeSystems );
            if ( !matcher.MatchContext() )
            {
                log.debug( "\t\tMainSearchCriteriaMatcher FAILED" );
                continue;
            }
            log.debug( "\t\tAdding Context to result..." );
            result.addResult( context );
        }
        return result;
    }
}
