package org.openinfobutton.app.dao;

/*
 * #%L
 * Project:  oib-app-model
 * Director: Guilherme Del Fiol, MD, PhD
 *           University of Utah
 *           Biomedical Informatics
 *           421 Wakara Way, Suite 140
 *           Salt Lake City, UT 84108-3514
 * Phone:    801-581-4080
 * %%
 * Copyright (C) 2010 - 2014 University of Utah
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class DaoBase.
 *
 * @author Rick Bradshaw Generic Dao pattern
 * @param <T> the generic type
 */
public abstract class DaoBase<T>
        implements DaoBaseI<T> {

    /**
     * The entity class.
     */
    private final Class<T> entityClass;

    /**
     * The session factory.
     */
    @Autowired
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

    /**
     * Instantiates a new dao base.
     */
    public DaoBase() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    // public List<T> loadAll() {
    // return getSessionFactory().getCurrentSession()
    // }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#delete(java.lang.Object)
     */
    @Override
    @Transactional
    public void delete(Serializable id) {
        T domain = get(id);
        getSessionFactory().getCurrentSession().delete(domain);
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#save(java.lang.Object)
     */
    @Override
    @Transactional
    public void save(T domain) {
        getSessionFactory().getCurrentSession().saveOrUpdate(domain);

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#update(java.lang.Object)
     */
    @Override
    public void update(T domain) {
        getSessionFactory().getCurrentSession().merge(domain);
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.DaoBaseI#get(java.io.Serializable)
     */
    @Override
    @Transactional
    public T get(Serializable id) {
        final T o = (T) getSessionFactory().getCurrentSession().get(entityClass, id);
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
