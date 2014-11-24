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

import java.util.ArrayList;
import java.util.List;

import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceProfileProvider.
 */
public final class ResourceProfileProvider
{

    /** The instance. */
    private static ResourceProfileProvider instance;

    /** The profiles. */
    private List<KnowledgeResourceProfile> profiles;

    /**
     * Instantiates a new resource profile provider.
     */
    private ResourceProfileProvider()
    {

        profiles = new ArrayList<KnowledgeResourceProfile>();
        final ResourceProfileLoaderNew rpn = new ResourceProfileLoaderNew();
        profiles.addAll( rpn.getProfiles() );
    }

    /**
     * Gets the single instance of ResourceProfileProvider.
     *
     * @return single instance of ResourceProfileProvider
     */
    public static ResourceProfileProvider getInstance()
    {

        if ( instance == null )
        {

            instance = new ResourceProfileProvider();
        }

        return instance;
    }

    /**
     * Gets the profiles.
     *
     * @return the profiles
     */
    public List<KnowledgeResourceProfile> getProfiles()
    {

        return profiles;
    }

    /**
     * Sets the profiles.
     *
     * @param profiles the new profiles
     */
    public void setProfiles( List<KnowledgeResourceProfile> profiles )
    {

        this.profiles = profiles;
        if ( profiles.isEmpty() )
        {
            resetInstance();
        }
    }

    /**
     * Reset instance.
     */
    public static void resetInstance()
    {

        instance = null;
    }
}
