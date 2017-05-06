package edu.utah.further.liteprofiledb.service;

import edu.utah.further.liteprofiledb.domain.CloudProfiles;
import edu.utah.further.liteprofiledb.domain.CustomProfiles;
import edu.utah.further.liteprofiledb.domain.UserAuthentication;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository( "lDao" )
public class LiteProfilesDaoImpl implements LiteProfilesDao {

    /**
     * The session factory.
     */
    @Autowired
    @Qualifier ("liteprofilesessionFactory")
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

    @Transactional
    public List<CustomProfiles> getCustomProfiles()
    {

        List<CustomProfiles> profiles = getSessionFactory().getCurrentSession().
                createCriteria(CustomProfiles.class).list();
        return profiles;
    }

    @Transactional
    public List<CloudProfiles> getCloudProfiles()
    {

        List<CloudProfiles> profiles = getSessionFactory().getCurrentSession().
                createCriteria(CloudProfiles.class).list();
        return profiles;
    }

    @Transactional
    public CustomProfiles getCustomProfile(Long id)
    {

        CustomProfiles profile = (CustomProfiles)getSessionFactory().getCurrentSession().createCriteria(CustomProfiles.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        return profile;
    }

    @Transactional
    public void createOrUpdateCustomProfile (CustomProfiles profile)
    {

        getSessionFactory().getCurrentSession().saveOrUpdate(profile);
    }

    @Transactional
    public UserAuthentication getUser(String user, String password)
    {

        UserAuthentication authUser = (UserAuthentication)getSessionFactory().getCurrentSession().
                get(UserAuthentication.class, user);
        if (authUser != null && authUser.getPassword().equals(password))
            return authUser;
        else
            return null;
    }

    @Transactional
    public void createOrUpdateUser(UserAuthentication user)
    {
        getSessionFactory().getCurrentSession().saveOrUpdate(user);
    }

    @Transactional
    public List<UserAuthentication> getUsers()
    {
        return getSessionFactory().getCurrentSession().createCriteria(UserAuthentication.class).
                add(Restrictions.eq("role", "USER")).list();
    }

    @Transactional
    public void deleteUser(UserAuthentication user)
    {
        getSessionFactory().getCurrentSession().delete(user);
    }

    @Transactional
    public void createOrUpdateCloudProfile (CloudProfiles profile)
    {

        getSessionFactory().getCurrentSession().saveOrUpdate(profile);
    }
}
