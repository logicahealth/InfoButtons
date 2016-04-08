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

import edu.utah.further.profiledb.service.ProfilesDao;
import org.apache.log4j.Logger;
import org.openinfobutton.exception.OIBProfileProcessingException;
import org.openinfobutton.schema.Holder;
import org.openinfobutton.schema.IDLite;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.openinfobutton.schemas.kb.ProfileDefinition;
import org.openinfobutton.service.profile.ResourceProfileProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class AccessCheckHandler.
 */
@Service
@Configurable( dependencyCheck = true )
public final class AccessCheckHandler
{

    /** The log. */
    private static Logger log = Logger.getLogger( AccessCheckHandler.class.getName() );

    /** The profiles. */
    public static List<KnowledgeResourceProfile> profiles;

    /** The provider. */
    public static ResourceProfileProvider provider;

    /** The access id. */
    private static String accessID;

    /** The user id. */
    private static String userId;

    /** The pdao. */
    @Autowired
    @Qualifier( "pDao" )
    private ProfilesDao pdao;
    
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
     * @param request the request
     * @return true, if successful
     */
    public boolean handleRequest( KnowledgeRequest request )
    {

        initProfiles();
        final Holder holder = request.getHolder();
        final IDLite representedOrganization = holder.getRepresentedOrganization();
        accessID = representedOrganization.getRoot();
        userId = holder.getAssignedAuthorizedPerson().getRoot();
        KnowledgeResourceProfile profile;
        for ( final Iterator<KnowledgeResourceProfile> iter = profiles.iterator(); iter.hasNext(); )
        {
            profile = iter.next();
            try {
                if (!checkProfile(profile)) {
                    iter.remove();
                }
            } catch (RuntimeException e)
            {
                log.debug("\t\tProfile Processing Error While Doing Access Check Caused By: " + profile.getHeader().getTitle());
                e.printStackTrace();
                throw new OIBProfileProcessingException("Access Check Error Caused By Configuration Problem In: " + profile.getHeader().getTitle(), e);
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
    private Boolean checkProfile( KnowledgeResourceProfile profile )
    {

        Boolean match = false;

        final List<ProfileDefinition.AuthorizedOrganizations.AuthorizedOrganization> 
            authorizedOrganizations =
            profile.getProfileDefinition().getAuthorizedOrganizations().getAuthorizedOrganization();
        final int authCount = authorizedOrganizations.size();
        Id id;
        if (pdao.isBlackListed(profile.getHeader().getTitle(), userId)) {

            return false;
        }
        for ( int x = 0; x < authCount; x++ )
        {
            id = authorizedOrganizations.get( x );
            if ( accessID.contains(id.getId()) )
            {

                match = true;
                break;
            }
        }
        return match;
    }

}
