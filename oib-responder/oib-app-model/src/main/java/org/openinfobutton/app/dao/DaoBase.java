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
package org.openinfobutton.app.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * The Class DaoBase.
 *
 * @author rick Generic Dao pattern
 * @param <T> the generic type
 */
public abstract class DaoBase<T>
    implements DaoBaseI<T>
{

    /** The entity class. */
    private final Class<T> entityClass;

    /** The session factory. */
    @Autowired
    SessionFactory sessionFactory;

    /**
     * Sets the session factory.
     *
     * @param sessionFactory the new session factory
     */
    public void setSessionFactory( SessionFactory sessionFactory )
    {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    /**
     * Instantiates a new dao base.
     */
    public DaoBase()
    {
        entityClass = (Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
    }

    // public List<T> loadAll() {
    // return getSessionFactory().getCurrentSession()
    // }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#delete(java.lang.Object)
     */
    @Override
    public void delete( T domain )
    {
        getSessionFactory().getCurrentSession().delete( domain );
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#save(java.lang.Object)
     */
    @Override
    public void save( T domain )
    {
        getSessionFactory().getCurrentSession().saveOrUpdate( domain );

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#update(java.lang.Object)
     */
    @Override
    public void update( T domain )
    {
        getSessionFactory().getCurrentSession().merge( domain );
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#get(java.io.Serializable)
     */
    @Override
    public T get( Serializable id )
    {
        final T o = (T) getSessionFactory().getCurrentSession().get( entityClass, id );
        return o;
    }

    // public List<T> getListByCriteria(DetachedCriteria detachedCriteria,
    // int offset, int size) {
    // return getSessionFactory().getCurrentSession(). .findByCriteria(detachedCriteria, offset, size);
    // }
    //
    // public List<T> getListByCriteria(DetachedCriteria detachedCriteria) {
    // return getHibernateTemplate().findByCriteria(detachedCriteria);
    // }
    //
    // public List<T> getListByHqlQuery(String hql, Map<String,Object> hqlParameters ) {
    // return null;
    // }
}