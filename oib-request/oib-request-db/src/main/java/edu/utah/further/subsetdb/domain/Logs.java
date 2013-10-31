
package edu.utah.further.subsetdb.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.utah.further.core.api.data.PersistentEntity;
import edu.utah.further.core.api.lang.Final;


@Entity
@Table(name = "logs")
public class Logs implements PersistentEntity<Long> {
	// ========================= CONSTANTS =================================
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ========================= FIELDS ====================================
	
	/**
	 * The unique identifier of this entity.
	 */
	@Id
	//@Final
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long logsId;
	
	@Column(name = "request", nullable = true,columnDefinition="MEDIUMTEXT")
	public String request;
	
	@Column(name = "timestamp", nullable = true)
	public Timestamp timestamp;
	
	@Column(name = "clientIP", nullable = true)
	public String clientIP;
	
	@Column(name = "orgID", nullable = true)
	public String orgID;
	
	// ========================= IMPLEMENTATION: PersistentEntity ==========

	public Long getId() {
		// TODO Auto-generated method stub
		return logsId;
	}
	
	
	public void setLogsId(Long logsId) {
		this.logsId = logsId;
	}



	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp2) {
		this.timestamp = timestamp2;
	}


	public String getClientIP() {
		return clientIP;
	}


	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}


	public String getOrgID() {
		return orgID;
	}


	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}


	


	

	
	
	
}
