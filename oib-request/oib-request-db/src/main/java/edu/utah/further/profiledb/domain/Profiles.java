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
 * @version Jun 13, 2014
 */
package edu.utah.further.profiledb.domain;

import java.io.File;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.BlobType;

import edu.utah.further.core.api.data.PersistentEntity;

@Entity
@Table(name = "resource_profiles")
public class Profiles implements PersistentEntity<Long> {
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "version")
	public int version;
	
	@Column(name = "published")
	public Timestamp published;
	
	//status 1=active; 2=under development; 3=inactive
	@Column(name = "status")
	public int status;
	
	@Column(name = "content",columnDefinition="BLOB")
	public Blob content;
	
	
	
	// ========================= IMPLEMENTATION: PersistentEntity ==========
	
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Timestamp getPublished() {
		return published;
	}

	public void setPublished(Timestamp published) {
		this.published = published;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}
	
	
}
