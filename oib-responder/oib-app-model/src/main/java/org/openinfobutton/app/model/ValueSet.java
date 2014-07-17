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
package org.openinfobutton.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueSet.
 *
 * @author rick
 */
@Entity
@Table( name = "OIB_VALUE_SET" )
@XmlRootElement
public class ValueSet
    implements Serializable
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The value set id. */
    @Id
    @Basic( optional = false )
    @Column( name = "VALUE_SET_ID" )
    private BigDecimal valueSetId;

    /** The value set type code. */
    @Column( name = "VALUE_SET_TYPE_CD" )
    private String valueSetTypeCode;

    /** The value set oid. */
    @Column( name = "VALUE_SET_OID" )
    private String valueSetOid;

    /** The value set display name. */
    @Column( name = "VALUE_SET_DISPLAY_NAME" )
    private String valueSetDisplayName;

    /** The value set uri. */
    @Column( name = "VALUE_SET_URI" )
    private String valueSetUri;

    /** The value set codes. */
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "valueSetId" )
    private Collection<ValueSetCode> valueSetCodes;

    /**
     * Gets the value set id.
     *
     * @return the value set id
     */
    public BigDecimal getValueSetId()
    {
        return valueSetId;
    }

    /**
     * Sets the value set id.
     *
     * @param valueSetId the new value set id
     */
    public void setValueSetId( BigDecimal valueSetId )
    {
        this.valueSetId = valueSetId;
    }

    /**
     * Gets the value set type code.
     *
     * @return the value set type code
     */
    public String getValueSetTypeCode()
    {
        return valueSetTypeCode;
    }

    /**
     * Sets the value set type code.
     *
     * @param valueSetTypeCode the new value set type code
     */
    public void setValueSetTypeCode( String valueSetTypeCode )
    {
        this.valueSetTypeCode = valueSetTypeCode;
    }

    /**
     * Gets the value set oid.
     *
     * @return the value set oid
     */
    public String getValueSetOid()
    {
        return valueSetOid;
    }

    /**
     * Sets the value set oid.
     *
     * @param valueSetOid the new value set oid
     */
    public void setValueSetOid( String valueSetOid )
    {
        this.valueSetOid = valueSetOid;
    }

    /**
     * Gets the value set display name.
     *
     * @return the value set display name
     */
    public String getValueSetDisplayName()
    {
        return valueSetDisplayName;
    }

    /**
     * Sets the value set display name.
     *
     * @param valueSetDisplayName the new value set display name
     */
    public void setValueSetDisplayName( String valueSetDisplayName )
    {
        this.valueSetDisplayName = valueSetDisplayName;
    }

    /**
     * Gets the value set uri.
     *
     * @return the value set uri
     */
    public String getValueSetUri()
    {
        return valueSetUri;
    }

    /**
     * Sets the value set uri.
     *
     * @param valueSetUri the new value set uri
     */
    public void setValueSetUri( String valueSetUri )
    {
        this.valueSetUri = valueSetUri;
    }

    /**
     * Gets the value set codes.
     *
     * @return the value set codes
     */
    @XmlTransient
    public Collection<ValueSetCode> getValueSetCodes()
    {
        return valueSetCodes;
    }

    /**
     * Sets the value set codes.
     *
     * @param valueSetCodes the new value set codes
     */
    public void setValueSetCodes( Collection<ValueSetCode> valueSetCodes )
    {
        this.valueSetCodes = valueSetCodes;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( valueSetId != null ? valueSetId.hashCode() : 0 );
        return hash;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof ValueSet ) )
        {
            return false;
        }
        final ValueSet other = (ValueSet) object;
        if ( ( this.valueSetId == null && other.valueSetId != null )
            || ( this.valueSetId != null && !this.valueSetId.equals( other.valueSetId ) ) )
        {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "org.openinfobutton.responder.model.ValueSet[ valueSetId=" + valueSetId + "\t" + valueSetDisplayName
            + " ]";
    }
}
