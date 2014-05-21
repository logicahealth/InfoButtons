/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah<br>
 * Contact: {@code <andrew.iskander@utah.edu>}<br>
 * Biomedical Informatics<br>
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version May 5, 2014
 */
package edu.utah.further.subsetdb.service;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.utah.further.core.api.context.Implementation;
import edu.utah.further.core.api.data.Dao;
import edu.utah.further.core.data.service.DaoHibernateImpl;
import edu.utah.further.subsetdb.domain.Logs;


@Implementation
@Repository("logsDbDao")
public class LogsDaoImpl implements LogsDao {
	
	
	
	@Autowired
	@Qualifier("subsetlogDao")
	private Dao dao;
	
	private SessionFactory sf ;
	
	@Transactional
	public void saveRequest(String req,String clientIP,String orgID)
	{
		Date d=new Date();
		Logs log=new Logs();
		log.setRequest(req);
		log.setClientIP(clientIP);
		log.setOrgID(orgID);
		log.setTimestamp(new Timestamp(d.getTime()));
		
		
		dao.create(log);
	
	}
}
