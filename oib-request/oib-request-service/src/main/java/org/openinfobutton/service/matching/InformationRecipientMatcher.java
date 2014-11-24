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

import org.openinfobutton.schema.InformationRecipient;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.CodedContextElement;

// TODO: Auto-generated Javadoc
/**
 * The Class InformationRecipientMatcher.
 */
public class InformationRecipientMatcher
    extends ContextMatcher
{

    /** The information recipient. */
    public InformationRecipient informationRecipient;

    /** The information recipient language. */
    public CodedContextElement informationRecipientLanguage;

    /** The information recipient discipline. */
    public CodedContextElement informationRecipientDiscipline;

    /** The information recipient knowledge user type. */
    public CodedContextElement informationRecipientKnowledgeUserType;

    /** The supported code systems. */
    List<String> supportedCodeSystems;

    /** The request. */
    KnowledgeRequest request;

    /**
     * Instantiates a new information recipient matcher.
     *
     * @param informationRecipientLanguage the information recipient language
     * @param informationRecipientDiscipline the information recipient discipline
     * @param informationRecipientKnowledgeUserType the information recipient knowledge user type
     * @param request the request
     * @param supportedCodeSystems the supported code systems
     */
    public InformationRecipientMatcher( CodedContextElement informationRecipientLanguage,
                                        CodedContextElement informationRecipientDiscipline,
                                        CodedContextElement informationRecipientKnowledgeUserType,
                                        KnowledgeRequest request, List<String> supportedCodeSystems )
    {

        this.informationRecipientLanguage = informationRecipientLanguage;
        this.informationRecipientDiscipline = informationRecipientDiscipline;
        this.informationRecipientKnowledgeUserType = informationRecipientKnowledgeUserType;
        this.informationRecipient = request.getInformationRecipient();
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
        if ( !CodeMatch( informationRecipient.getProviderOrPatient(), informationRecipientKnowledgeUserType,
                         supportedCodeSystems, false, request ) )
        {
            return false;
        }
        if ( !CodeMatch( informationRecipient.getLanguage(), informationRecipientLanguage, supportedCodeSystems, false,
                         request ) )
        {
            return false;
        }
        if ( !CodeMatch( informationRecipient.getHealthCareProvider(), informationRecipientDiscipline,
                         supportedCodeSystems, false, request ) )
        {
            return false;
        }
        return true;
    }

}
