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
package org.openinfobutton.service.profile;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edu.utah.further.profiledb.domain.Profiles;
import org.apache.log4j.Logger;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.utah.further.profiledb.service.ProfilesDao;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceProfileLoaderNew.
 */
@Service
@Configurable( dependencyCheck = true )
public class ResourceProfileLoaderNew
{

    /** The log. */
    Logger log = Logger.getLogger( ResourceProfileLoaderNew.class.getName() );

    /** The status. */
    static boolean status;

    /** The pdao. */
    @Autowired
    @Qualifier( "pDao" )
    private ProfilesDao pdao;

    /**
     * Gets the profiles.
     *
     * @return the profiles
     */
    @SuppressWarnings( "boxing" )
    public Map<Long, KnowledgeResourceProfile> getProfiles()
    {
        log.info( "Loading Profiles from the Database" );
        final Map<Long, KnowledgeResourceProfile> newProfiles = new HashMap<Long,KnowledgeResourceProfile>();
        JAXBContext context;
        Unmarshaller u = null;
        try
        {
            context = JAXBContext.newInstance( KnowledgeResourceProfile.class );
            u = context.createUnmarshaller();
        }
        catch ( final JAXBException e1 )
        {
            e1.printStackTrace();
            log.error( "Failed to get the Unmarshaller.Cannot proceed with loading the profiles" );
            return newProfiles;
        }

        long length;
        int s;// 1 or 2 (status)
        if ( status )
        {
            s = 2;// under development = 2
        }
        else
        {
            s = 1;// active = 1
        }
        length = pdao.count( s );
        final List<Profiles> profiles = pdao.getResourceProfiles( s );
        InputStream bdata = null;
        Blob blob;
        KnowledgeResourceProfile content;
        for (Profiles profile : profiles)
        {
            blob = profile.getContent();
            try
            {
                bdata = blob.getBinaryStream();
                content = (KnowledgeResourceProfile) u.unmarshal( bdata);
                newProfiles.put(profile.getId(), content );
                log.debug( "Loaded Profile : " + content.getHeader().getTitle() );
            }
            catch ( final JAXBException e )
            {
                e.printStackTrace();
                log.error( "Bad profile found and being skipped.Profile ID=" + profile.getId() + " Status=" + s );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return newProfiles;
    }

    /**
     * Sets the mode.
     *
     * @param str the new mode
     */
    public static void setMode( String str )
    {

        if ( str.equals( "" ) )
        {
            status = false;
        }
        else
        {
            status = true;

        }
    }

}
