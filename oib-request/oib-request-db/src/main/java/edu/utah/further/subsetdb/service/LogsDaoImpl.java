package edu.utah.further.subsetdb.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

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
	public String saveRequest(String req,String clientIP,String orgID,String origParams)
	{
		Date d=new Date();
		Logs log=new Logs();
		log.setRequest(req);
		log.setClientIP(clientIP);
		log.setOrgID(orgID);
		log.setTimestamp(new Timestamp(d.getTime()));
		log.setOrigParams(origParams);
		String uuid = UUID.randomUUID().toString();
		log.setRequestUUID(uuid);
		
		dao.create(log);
		return uuid;
	}
}
