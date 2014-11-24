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

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.Performer;
import org.openinfobutton.schemas.kb.CodedContextElement;

// TODO: Auto-generated Javadoc
/**
 * The Class PerformerMatcher.
 */
public class PerformerMatcher
    extends ContextMatcher
{

    /** The performer. */
    public Performer performer;

    /** The performer language. */
    public CodedContextElement performerLanguage;

    /** The performer discipline. */
    public CodedContextElement performerDiscipline;

    /** The performer knowledge user type. */
    public CodedContextElement performerKnowledgeUserType;

    /** The supported code systems. */
    List<String> supportedCodeSystems;

    /** The request. */
    KnowledgeRequest request;

    /**
     * Instantiates a new performer matcher.
     *
     * @param performerLanguage the performer language
     * @param performerDiscipline the performer discipline
     * @param performerKnowledgeUserType the performer knowledge user type
     * @param request the request
     * @param supportedCodeSystems the supported code systems
     */
    public PerformerMatcher( CodedContextElement performerLanguage, CodedContextElement performerDiscipline,
                             CodedContextElement performerKnowledgeUserType, KnowledgeRequest request,
                             List<String> supportedCodeSystems )
    {

        this.performerLanguage = performerLanguage;
        this.performerDiscipline = performerDiscipline;
        this.performerKnowledgeUserType = performerKnowledgeUserType;
        this.performer = request.getPerformer();
        this.supportedCodeSystems = supportedCodeSystems;
        this.request = request;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.matching.ContextMatcher#MatchContext()
     */
    @Override
    public Boolean MatchContext()
    {
        if ( !CodeMatch( performer.getProviderOrPatient(), performerKnowledgeUserType, supportedCodeSystems, false,
                         request ) )
        {
            return false;
        }
        if ( !CodeMatch( performer.getLanguage(), performerLanguage, supportedCodeSystems, false, request ) )
        {
            return false;
        }
        if ( !CodeMatch( performer.getHealthCareProvider(), performerDiscipline, supportedCodeSystems, false, request ) )
        {
            return false;
        }
        return true;
    }
}
