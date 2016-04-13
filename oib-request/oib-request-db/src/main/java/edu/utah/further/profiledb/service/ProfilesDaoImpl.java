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
package edu.utah.further.profiledb.service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import edu.utah.further.profiledb.domain.ProfileBlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import edu.utah.further.core.api.context.Implementation;
import edu.utah.further.core.api.data.Dao;
import edu.utah.further.profiledb.domain.Profiles;

/**
 * The Class ProfilesDaoImpl.
 */
@Implementation
@Repository( "profilesdbDao" )
public class ProfilesDaoImpl
    implements ProfilesDao
{

    /** The dao. */
    @Autowired
    @Qualifier( "profilesDao" )
    private Dao dao;

    /*
     * (non-Javadoc)
     * @see edu.utah.further.profiledb.service.ProfilesDao#getResourceProfile(int)
     */
    @Override
    @Transactional
    public List<Profiles> getResourceProfiles( int status )
    {

        Profiles p = null;
        final List<Profiles> profiles = dao.findByProperty( Profiles.class, "status", new Integer( status ) );
        // return fm;
        return profiles;
    }

    /*
     * (non-Javadoc)
     * @see edu.utah.further.profiledb.service.ProfilesDao#count(int)
     */
    @Override
    @Transactional
    public long count( int status )
    {
        // Get the number of the profiles of the required status
        long count = 0;
        final long i = 1;
        final Integer temp = new Integer( status );
        final List no = dao.findByProperty( Profiles.class, "status", temp );
        count = no.size();
        return count;
    }

    @Override
    @Transactional
    public boolean isBlackListed(String profileTitle, String userId) {

        Map properties = new HashMap<String,String>();
        properties.put("userId", userId);
        properties.put("profileTitle", profileTitle);
        final List blackListed = dao.findByProperties(ProfileBlackList.class, properties);
        if (blackListed.isEmpty()) {

            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean isBlackListed(long profileId, String userId) {

        Map properties = new HashMap<String,String>();
        properties.put("userId", userId);
        properties.put("profileID", (int) profileId);
        final List blackListed = dao.findByProperties(ProfileBlackList.class, properties);
        if (blackListed.isEmpty()) {

            return false;
        }
        return true;
    }
}
