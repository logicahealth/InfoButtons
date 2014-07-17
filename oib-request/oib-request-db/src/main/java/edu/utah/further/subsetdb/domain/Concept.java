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

import static edu.utah.further.core.api.text.ToStringCustomStyles.SHORT_WITH_SPACES_STYLE;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import edu.utah.further.core.api.data.PersistentEntity;
import edu.utah.further.core.api.lang.Final;

// TODO: Auto-generated Javadoc
/**
 * The Class Concept.
 */
@Entity
@Table( name = "concept" )
public class Concept
    implements PersistentEntity<Long>
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
    @Final
    public Long conceptId;

    /**
     * Code of concept.
     */
    @Column( name = "code", nullable = true )
    private String code;

    /** Display name of concept. */
    @Column( name = "displayname", nullable = true )
    private String displayName;

    /** Code system of concept. */
    @Column( name = "codesystem", nullable = true )
    private String codeSystem;

    /** Code system display name of concept. */
    @Column( name = "codesystemname", nullable = true )
    private String codeSystemName;

    /** The subsets. */
    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "subsetmember", joinColumns = { @JoinColumn( name = "conceptid" ) }, 
                inverseJoinColumns = { @JoinColumn( name = "subsetid" ) } )
    private Set<Subset> subsets = new HashSet<Subset>( 0 );

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
        final Concept that = (Concept) obj;
        return new EqualsBuilder().append( this.conceptId, that.conceptId ).isEquals();
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
        return new HashCodeBuilder().append( conceptId ).toHashCode();
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
        return new ToStringBuilder( this, SHORT_WITH_SPACES_STYLE ).append( "conceptId", conceptId ).append( "code",
                                    code ).append( "displayName",displayName ).append( "codeSystem", codeSystem ).
                                    append( "codeSystemName",codeSystemName ).toString();
    }

    // ========================= IMPLEMENTATION: PersistentEntity ==========

    /**
     * Gets the id.
     *
     * @return the id
     * @see edu.utah.further.core.util.data.PersistentEntity#getId()
     */

    @Override
    public Long getId()
    {
        return conceptId;
    }

    /**
     * Sets the concept id.
     *
     * @param conceptId the new concept id
     */
    public void setConceptId( Long conceptId )
    {
        this.conceptId = conceptId;
    }

    /**
     * Gets the display name.
     *
     * @return the display name
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Sets the display name.
     *
     * @param displayName the new display name
     */
    public void setDisplayName( String displayName )
    {
        this.displayName = displayName;
    }

    /**
     * Gets the code system.
     *
     * @return the code system
     */
    public String getCodeSystem()
    {
        return codeSystem;
    }

    /**
     * Sets the code system.
     *
     * @param codeSystem the new code system
     */
    public void setCodeSystem( String codeSystem )
    {
        this.codeSystem = codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name
     */
    public String getCodeSystemName()
    {
        return codeSystemName;
    }

    /**
     * Sets the code system name.
     *
     * @param codeSystemName the new code system name
     */
    public void setCodeSystemName( String codeSystemName )
    {
        this.codeSystemName = codeSystemName;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode( String code )
    {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Gets the subsets.
     *
     * @return the subsets
     */
    public Set<Subset> getSubsets()
    {
        return subsets;
    }

    /**
     * Sets the subsets.
     *
     * @param subsets the new subsets
     */
    public void setSubsets( Set<Subset> subsets )
    {
        this.subsets = subsets;
    }

    // ========================= IMPLEMENTATION: Person ====================

}
