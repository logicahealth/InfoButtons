package org.openinfobutton.app.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rick
 *
 * Generic Dao pattern
 */
public abstract class DaoBase<T> implements IDaoBase<T> {

    private Class<T> entityClass;

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public DaoBase() {
        entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

//    public List<T> loadAll() {
//        return getSessionFactory().getCurrentSession()
//    }

    public void delete(T domain) {
        getSessionFactory().getCurrentSession().delete(domain);
    }

    public void save(T domain) {
        getSessionFactory().getCurrentSession().saveOrUpdate(domain);

    }

    public void update(T domain) {
        getSessionFactory().getCurrentSession().merge(domain);
    }

    public T get(Serializable id) {
        T o = (T) getSessionFactory().getCurrentSession().get(entityClass, id);
        return o;
    }

//    public List<T> getListByCriteria(DetachedCriteria detachedCriteria,
//            int offset, int size) {
//        return getSessionFactory().getCurrentSession(). .findByCriteria(detachedCriteria, offset, size);
//    }
//
//    public List<T> getListByCriteria(DetachedCriteria detachedCriteria) {
//        return getHibernateTemplate().findByCriteria(detachedCriteria);
//    }
//    
//    public List<T> getListByHqlQuery(String hql, Map<String,Object> hqlParameters ) {
//        return null;
//    }
}