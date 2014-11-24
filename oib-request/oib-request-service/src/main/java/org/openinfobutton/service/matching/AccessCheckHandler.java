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

import java.util.Iterator;
import java.util.List;

import org.openinfobutton.schema.Holder;
import org.openinfobutton.schema.IDLite;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.openinfobutton.service.profile.ResourceProfileProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class AccessCheckHandler.
 */
public final class AccessCheckHandler
{

    /** The profiles. */
    public static List<KnowledgeResourceProfile> profiles;

    /** The provider. */
    public static ResourceProfileProvider provider;

    /** The access id. */
    private static String accessID;

    /**
     * Instantiates a new access check handler.
     */
    private AccessCheckHandler(){}
    
    /**
     * Inits the profiles.
     */
    private static void initProfiles()
    {

        provider = ResourceProfileProvider.getInstance();
        profiles = provider.getProfiles();
    }

    /**
     * Handle request.
     *
     * @param request the request
     * @return true, if successful
     */
    public static boolean handleRequest( KnowledgeRequest request )
    {

        initProfiles();
        final Holder holder = request.getHolder();
        final IDLite representedOrganization = holder.getRepresentedOrganization();
        accessID = representedOrganization.getRoot();
        KnowledgeResourceProfile profile;
        for ( final Iterator<KnowledgeResourceProfile> iter = profiles.iterator(); iter.hasNext(); )
        {
            profile = iter.next();
            if ( !checkProfile( profile ) )
            {
                iter.remove();
            }
        }
        provider.setProfiles( profiles );
        return profiles.isEmpty();
    }

    /**
     * Check profile.
     *
     * @param profile the profile
     * @return the boolean
     */
    private static Boolean checkProfile( KnowledgeResourceProfile profile )
    {

        Boolean match = false;

        final List<KnowledgeResourceProfile.ProfileDefinition.AuthorizedOrganizations.AuthorizedOrganization> 
            authorizedOrganizations =
            profile.getProfileDefinition().getAuthorizedOrganizations().getAuthorizedOrganization();
        final int authCount = authorizedOrganizations.size();
        Id id;
        for ( int x = 0; x < authCount; x++ )
        {
            id = authorizedOrganizations.get( x );
            if ( accessID.equals( id.getId() ) )
            {

                match = true;
                break;
            }
        }
        return match;
    }

}
