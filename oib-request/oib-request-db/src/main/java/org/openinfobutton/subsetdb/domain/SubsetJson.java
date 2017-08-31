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
package org.openinfobutton.subsetdb.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 * The Class Subset.
 */
@Entity
@Table( name = "subset_json" )
public class SubsetJson implements Serializable
{
    // ========================= CONSTANTS =================================

    /**
     * The Constant serialVersionUID.
     *
     * @serial Serializable version identifier.
     */
    private static final long serialVersionUID = 1L;

    // ========================= FIELDS ====================================

    /**
     * The unique identifier of this entity.
     */
    @Id
    public int id;

    /**
     * Name of subset.
     */
    @Column( name = "name", nullable = false )
    private String name;

    /**
     *Last updated
     */
    @UpdateTimestamp
    @Column( name = "last_updated", nullable = false )
    private Timestamp lastUpdated;

    /**
     *The Content
     */
    @Column (name = "value_set")
    private Blob valueSet;

    // ========================= CONSTRUCTORS ==============================

    // ========================= IMPLEMENTATION: Object ====================

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     * @see Object#equals(Object)
     */
    @Override
    public final boolean equals( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final SubsetJson that = (SubsetJson) obj;
        return new EqualsBuilder().append( this.id, that.id ).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     * @see Object#hashCode()
     */
    @Override
    public final int hashCode()
    {
        return new HashCodeBuilder().append( id ).toHashCode();
    }

    /**
     * To string.
     *
     * @return the string
     * @see Object#toString()
     */
    @Override
    public String toString()
    {
        return new ToStringBuilder( this, ToStringStyle.DEFAULT_STYLE ).
                        append( "id", id ).append( "name", name ).
                        toString();
    }

    // ========================= IMPLEMENTATION: PersistentEntity ==========

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets the subset id.
     *
     * @param id the new subset id
     */
    public void setId( int id )
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
     * Gets the date
     *
     * @return lastUpdated
     */
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the date
     *
     * @param lastUpdated
     */
    private void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Gets the Value Set
     *
     * @return valueSet
     */
    public Blob getValueSet() {
        return valueSet;
    }

    /**
     * Sets the Value Set
     *
     * @param valueSet
     */
    public void setValueSet(Blob valueSet) {
        this.valueSet = valueSet;
    }
}
