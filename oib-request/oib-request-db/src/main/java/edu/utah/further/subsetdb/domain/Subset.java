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
package edu.utah.further.subsetdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * The Class Subset.
 */
@Entity
@Table( name = "subset" )
public class Subset implements Serializable
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
    public Long subsetId;

    /**
     * Name of subset.
     */
    @Column( name = "name", nullable = true )
    private String name;

    /** Description of subset. */
    @Column( name = "description", nullable = true )
    private String description;

    /** Internal concept id. */
    @Column( name = "internalconceptid", nullable = true )
    private Integer internalConceptId;

    /** Methodology concept id. */
    @Column( name = "methodologyconceptid", nullable = true )
    private String methodologyConceptId;

    // ========================= CONSTRUCTORS ==============================

    // ========================= IMPLEMENTATION: Object ====================

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     * @see java.lang.Object#equals(java.lang.Object)
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
        final Subset that = (Subset) obj;
        return new EqualsBuilder().append( this.subsetId, that.subsetId ).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode()
    {
        return new HashCodeBuilder().append( subsetId ).toHashCode();
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return new ToStringBuilder( this, ToStringStyle.DEFAULT_STYLE ).
                        append( "subsetId", subsetId ).append( "name", name ).
                        append( "description",description ).
                        append( "internalconceptid",internalConceptId ).
                        append( "methodologyconceptid",methodologyConceptId ).
                        toString();
    }

    // ========================= IMPLEMENTATION: PersistentEntity ==========

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId()
    {
        return subsetId;
    }

    /**
     * Sets the subset id.
     *
     * @param subsetId the new subset id
     */
    public void setSubsetId( Long subsetId )
    {
        this.subsetId = subsetId;
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
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription( String description )
    {
        this.description = description;
    }

    /**
     * Gets the internal concept id.
     *
     * @return the internal concept id
     */
    public Integer getInternalConceptId()
    {
        return internalConceptId;
    }

    /**
     * Sets the internal concept id.
     *
     * @param internalConceptId the new internal concept id
     */
    public void setInternalConceptId( Integer internalConceptId )
    {
        this.internalConceptId = internalConceptId;
    }

    /**
     * Gets the methodology concept id.
     *
     * @return the methodology concept id
     */
    public String getMethodologyConceptId()
    {
        return methodologyConceptId;
    }

    /**
     * Sets the methodology concept id.
     *
     * @param methodologyConceptId the new methodology concept id
     */
    public void setMethodologyConceptId( String methodologyConceptId )
    {
        this.methodologyConceptId = methodologyConceptId;
    }

    // ========================= IMPLEMENTATION: Person ====================

}
