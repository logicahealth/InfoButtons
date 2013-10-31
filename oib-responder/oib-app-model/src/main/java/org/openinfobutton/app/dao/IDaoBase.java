package org.openinfobutton.app.dao;

import java.io.Serializable;

/**
 *
 * @author rick 
 * Base interface for basic DAO operations Generic Dao pattern
 */
public interface IDaoBase<T> {

    public void save(T domain);

    public void update(T domain);

    public void delete(T domain);

    public T get(Serializable id);

}