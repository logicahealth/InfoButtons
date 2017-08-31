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
package org.openinfobutton.profiledb.service;

import java.util.List;

import org.openinfobutton.profiledb.domain.ProfileBlackList;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.openinfobutton.profiledb.domain.Profiles;

/**
 * The Class ProfilesDaoImpl.
 */
@Repository( "profilesdbDao" )
public class ProfilesDaoImpl
    implements ProfilesDao
{
    /**
     * The session factory.
     */
    @Autowired
    @Qualifier ("profilesessionFactory")
    SessionFactory sessionFactory;

    /**
     * Sets the session factory.
     *
     * @param sessionFactory the new session factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*
     * (non-Javadoc)
     * @see ProfilesDao#getResourceProfile(int)
     */
    @Override
    @Transactional
    public List<Profiles> getResourceProfiles( int status )
    {

        final List<Profiles> profiles = getSessionFactory().getCurrentSession().createCriteria(Profiles.class).
                add(Restrictions.eq("status", new Integer( status ))).list();
        // return fm;
        return profiles;
    }

    /*
     * (non-Javadoc)
     * @see ProfilesDao#count(int)
     */
    @Override
    @Transactional
    public long count( int status )
    {
        // Get the number of the profiles of the required status
        long count = 0;
        final long i = 1;
        final Integer temp = new Integer( status );
        final List no = getSessionFactory().getCurrentSession().createCriteria(Profiles.class).
                add(Restrictions.eq("status", temp)).list();
        count = no.size();
        return count;
    }

    @Override
    @Transactional
    public boolean isBlackListed(String profileTitle, String userId) {

        final List blackListed = getSessionFactory().getCurrentSession().createCriteria(ProfileBlackList.class).
                add(Restrictions.eq("userId", userId)).add(Restrictions.eq("profileTitle", profileTitle)).list();
        if (blackListed.isEmpty()) {

            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean isBlackListed(long profileId, String userId) {

        final List blackListed = getSessionFactory().getCurrentSession().createCriteria(ProfileBlackList.class).
                add(Restrictions.eq("userId", userId)).add(Restrictions.eq("profileID", ((Long)profileId).intValue())).list();
        if (blackListed.isEmpty()) {

            return false;
        }
        return true;
    }
}
