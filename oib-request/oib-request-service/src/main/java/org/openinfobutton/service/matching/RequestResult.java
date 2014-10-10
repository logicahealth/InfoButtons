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

import org.openinfobutton.schemas.kb.Context;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.openinfobutton.schemas.kb.ProfileDefinition;
import org.openinfobutton.schemas.kb.ProfileDefinition.SupportedTerminologies;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestResult.
 */
public class RequestResult
    implements Comparable<RequestResult>
{

    /** The contexts. */
    private final List<Context> contexts;

    /** The header. */
    private final KnowledgeResourceProfile.Header header;

    /** The profile definition. */
    private final ProfileDefinition profileDefinition;

    /** The supported code systems. */
    private List<String> supportedCodeSystems;
    
    /** Organization specific base URL */
    private String organizationURL;
    
    /** Use Assigned Authorized Person **/
    private boolean useAssignedAuthorizedPerson;

    /**
     * Instantiates a new request result.
     *
     * @param profile the profile
     */
    public RequestResult( KnowledgeResourceProfile profile )
    {

        contexts = new ArrayList<Context>();
        this.header = profile.getHeader();
        this.profileDefinition = profile.getProfileDefinition();
        final SupportedTerminologies supportedTerminologies =
            profile.getProfileDefinition().getSupportedTerminologies();
        List<Id> terminologyList = new ArrayList<Id>();
        supportedCodeSystems = new ArrayList<String>();
        if ( supportedTerminologies != null )
        {
            terminologyList = supportedTerminologies.getSupportedTerminology();
            for ( int i = 0; i < terminologyList.size(); i++ )
            {
                final String cs = terminologyList.get( i ).getId();
                supportedCodeSystems.add( cs );
            }
        }
    }

    /**
     * Gets the url style.
     *
     * @return the url style
     */
    public String getUrlStyle()
    {
        return profileDefinition.getUrlStyle();
    }

    /**
     * Checks if is hl7 url compliant.
     *
     * @return true, if is hl7 url compliant
     */
    public boolean isHl7URLCompliant()
    {
        return profileDefinition.isHl7URLCompliant();
    }

    /**
     * Checks if is hl7 knowledge response compliant.
     *
     * @return true, if is hl7 knowledge response compliant
     */
    public boolean isHl7KnowledgeResponseCompliant()
    {
        return profileDefinition.isHl7KnowledgeResponseCompliant();
    }

    /**
     * Adds the result.
     *
     * @param context the context
     */
    public void addResult( Context context )
    {

        contexts.add( context );
    }

    /**
     * Gets the contexts.
     *
     * @return the contexts
     */
    public List<Context> getContexts()
    {

        return contexts;
    }

    /**
     * Gets the header.
     *
     * @return the header
     */
    public KnowledgeResourceProfile.Header getHeader()
    {

        return header;
    }

    /**
     * Gets the supported code systems.
     *
     * @return the supported code systems
     */
    public List<String> getSupportedCodeSystems()
    {
        return supportedCodeSystems;
    }

    /**
     * Sets the supported code systems.
     *
     * @param supportedCodeSystems the new supported code systems
     */
    public void setSupportedCodeSystems( List<String> supportedCodeSystems )
    {
        this.supportedCodeSystems = supportedCodeSystems;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo( RequestResult r )
    {

        return ( this.header.getTitle() ).compareTo( r.getHeader().getTitle() );
    }

    /**
     * Return the organizationURL property.
     *
     * @return the organizationURL
     */
    public String getOrganizationURL()
    {
        return organizationURL;
    }

    /**
     * Set a new value for the organizationURL property.
     *
     * @param organizationURL the organizationURL to set
     */
    public void setOrganizationURL( String organizationURL )
    {
        this.organizationURL = organizationURL;
    }

    /**
     * Return the useAssignedAuthorizedPerson property.
     *
     * @return the useAssignedAuthorizedPerson
     */
    public boolean getUseAssignedAuthorizedPerson()
    {
        return useAssignedAuthorizedPerson;
    }

    /**
     * Set a new value for the useAssignedAuthorizedPerson property.
     *
     * @param useAssignedAuthorizedPerson the useAssignedAuthorizedPerson to set
     */
    public void setUseAssignedAuthorizedPerson( boolean useAssignedAuthorizedPerson )
    {
        this.useAssignedAuthorizedPerson = useAssignedAuthorizedPerson;
    }
}
