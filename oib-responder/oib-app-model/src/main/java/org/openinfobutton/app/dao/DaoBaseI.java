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

// TODO: Auto-generated Javadoc
/**
 * The Interface DaoBaseI.
 *
 * @author Rick BradshawBradshawBase interface for basic DAO operations Generic Dao pattern
 * @param <T> the generic type
 */
public interface DaoBaseI<T>
{

    /**
     * Save.
     *
     * @param domain the domain
     */
    public void save( T domain );

    /**
     * Update.
     *
     * @param domain the domain
     */
    public void update( T domain );

    /**
     * Delete.
     *
     * @param domain the domain
     */
    public void delete( T domain );

    /**
     * Gets the.
     *
     * @param id the id
     * @return the t
     */
    public T get( Serializable id );

}