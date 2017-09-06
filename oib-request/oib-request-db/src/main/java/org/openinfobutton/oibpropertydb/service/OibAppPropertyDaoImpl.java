package org.openinfobutton.oibpropertydb.service;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.oibpropertydb.domain.OibAppProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 8/29/17.
 */
@Repository( "oibAppPropertyDao" )
public class OibAppPropertyDaoImpl implements OibAppPropertyDao {

    /**
     * The session factory.
     */
    @Autowired
    @Qualifier("profilesessionFactory")
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


    @Override
    @Transactional
    public List<OibAppProperty> getPropertiesByName(String name) {

        List<OibAppProperty> properties = new ArrayList<>();
        properties = getSessionFactory().getCurrentSession().createCriteria(OibAppProperty.class).
                add(Restrictions.eq("propName", name)).list();
        return properties;
    }

    @Override
    @Transactional
    public OibAppProperty getPropertyByName(String name) {

        OibAppProperty property = null;
        property = (OibAppProperty)getSessionFactory().getCurrentSession().createCriteria(OibAppProperty.class).
                add(Restrictions.eq("propName", name)).list().get(0);
        return property;
    }

    @Override
    @Transactional
    public void updateProperty(OibAppProperty property) {

        getSessionFactory().getCurrentSession().saveOrUpdate(property);
    }
}
