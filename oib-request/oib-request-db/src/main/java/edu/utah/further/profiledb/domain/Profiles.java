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
package edu.utah.further.profiledb.domain;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openinfobutton.service.json.BlobJsonSerializer;

import edu.utah.further.core.api.data.PersistentEntity;

/**
 * The Class Profiles.
 */
@Entity
@Table( name = "resource_profiles" )
public class Profiles
    implements PersistentEntity<Long>
{
    // ========================= CONSTANTS =================================
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    // ========================= FIELDS ====================================

    /**
     * The unique identifier of this entity.
     */

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    public Long id;

    /** The name. */
    @Column( name = "name" )
    public String name;

    /** The version. */
    @Column( name = "version" )
    public int version;

    /** The published. */
    @Column( name = "published" )
    public Timestamp published;

    // status 1=active; 2=under development; 3=inactive
    /** The status. */
    @Column( name = "status" )
    public int status;

    /** The content. */
    @Column( name = "content", columnDefinition = "BLOB" )
    public Blob content;

    // ========================= IMPLEMENTATION: PersistentEntity ==========

    /*
     * (non-Javadoc)
     * @see edu.utah.further.core.api.discrete.HasIdentifier#getId()
     */
    @Override
    public Long getId()
    {
        // TODO Auto-generated method stub
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId( Long id )
    {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion()
    {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion( int version )
    {
        this.version = version;
    }

    /**
     * Gets the published.
     *
     * @return the published
     */
    public Timestamp getPublished()
    {
        return published;
    }

    /**
     * Sets the published.
     *
     * @param published the new published
     */
    public void setPublished( Timestamp published )
    {
        this.published = published;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus( int status )
    {
        this.status = status;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    @JsonSerialize(using=BlobJsonSerializer.class)
    public Blob getContent()
    {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent( Blob content )
    {
        this.content = content;
    }

}
