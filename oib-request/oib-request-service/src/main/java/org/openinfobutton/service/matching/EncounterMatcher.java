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

import org.openinfobutton.schema.Encounter;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.openinfobutton.schemas.kb.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class EncounterMatcher.
 */
public class EncounterMatcher
    extends ContextMatcher
{

    /** The encounter. */
    public Encounter encounter;

    /** The encounter type. */
    public CodedContextElement encounterType;

    /** The service delivery location. */
    public List<Id> serviceDeliveryLocation;

    /** The request. */
    KnowledgeRequest request;

    /** The supported code systems. */
    List<String> supportedCodeSystems;

    /**
     * Instantiates a new encounter matcher.
     *
     * @param encounterType the encounter type
     * @param serviceDeliveryLocation the service delivery location
     * @param request the request
     * @param supportedCodeSystems the supported code systems
     */
    public EncounterMatcher( CodedContextElement encounterType, List<Id> serviceDeliveryLocation,
                             KnowledgeRequest request, List<String> supportedCodeSystems )
    {

        this.encounter = request.getEncounter();
        this.encounterType = encounterType;
        this.serviceDeliveryLocation = serviceDeliveryLocation;
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
        if ( !CodeMatch( encounter.getCode(), encounterType, supportedCodeSystems, false, request ) )
        {
            return false;
        }
        return true;
    }

}
