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
package org.openinfobutton.subsetdb.service;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.openinfobutton.subsetdb.domain.Logs;

// TODO: Auto-generated Javadoc
/**
 * The Class LogsDaoImpl.
 */
@Repository( "logsDbDao" )
public class LogsDaoImpl
    implements LogsDao
{

    /**
     * The session factory.
     */
    @Autowired
    @Qualifier ("sessionFactory")
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
     * @see LogsDao#saveRequest(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void saveRequest( String req, String rep, String clientIP, String orgID )
    {
        final Date d = new Date();
        final Logs log = new Logs();
        log.setRequest( req );
        log.setResponse(rep);
        log.setClientIP( clientIP );
        log.setOrgID( orgID );
        log.setTimestamp( new Timestamp( d.getTime() ) );
        getSessionFactory().getCurrentSession().saveOrUpdate(log);


    }
}
