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
package edu.utah.further.subsetdb.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.utah.further.core.api.context.Implementation;
import edu.utah.further.core.api.data.Dao;
import edu.utah.further.subsetdb.domain.Logs;

// TODO: Auto-generated Javadoc
/**
 * The Class LogsDaoImpl.
 */
@Implementation
@Repository( "logsDbDao" )
public class LogsDaoImpl
    implements LogsDao
{

    /** The dao. */
    @Autowired
    @Qualifier( "subsetlogDao" )
    private Dao dao;

    /** The sf. */
    private SessionFactory sf;

    /*
     * (non-Javadoc)
     * @see edu.utah.further.subsetdb.service.LogsDao#saveRequest(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public String saveRequest( String req, String clientIP, String orgID, String origParams )
    {
        final Date d = new Date();
        final Logs log = new Logs();
        log.setRequest( req );
        log.setClientIP( clientIP );
        log.setOrgID( orgID );
        log.setTimestamp( new Timestamp( d.getTime() ) );
		log.setOrigParams( origParams );
		String uuid = UUID.randomUUID().toString();
		log.setRequestUUID( uuid );

        dao.create( log );
        return uuid;
    }
}