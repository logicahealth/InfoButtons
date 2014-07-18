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
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

// TODO: Auto-generated Javadoc
/**
 * The Class Asset.
 *
 * @author rick
 */

@Entity
@Table( name = "OIB_ASSET" )
@XmlRootElement
public class Asset
    implements Serializable
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce
    // field validation

    /** The asset id. */
    @Id
    // @SequenceGenerator(name = "objectIdSequence", sequenceName = "OIB_ID_SEQ")
    // @GeneratedValue(strategy = GenerationType.AUTO, generator="objectIdSequence")
    @Basic( optional = false )
    @Column( name = "ASSET_ID" )
    private BigDecimal assetId;

    /** The namespace cd. */
    @Column( name = "NAMESPACE_CD" )
    private String namespaceCd;

    /** The display name. */
    @Column( name = "DISPLAY_NAME" )
    private String displayName;

    /** The last update date. */
    @Column( name = "LAST_UPDATE_DTS" )
    @Temporal( javax.persistence.TemporalType.DATE )
    private Date lastUpdateDate;

    /** The asset url. */
    @Column( name = "ASSET_URL" )
    private String assetUrl;

    /** The asset mime type. */
    @Column( name = "ASSET_MIME_TYPE" )
    private String assetMimeType;

    /** The asset properties. */
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "asset" )
    private List<AssetProperty> assetProperties;

    /**
     * Instantiates a new asset.
     */
    public Asset()
    {
    }

    /**
     * Instantiates a new asset.
     *
     * @param assetId the asset id
     */
    public Asset( BigDecimal assetId )
    {
        this.assetId = assetId;
    }

    /**
     * Gets the asset id.
     *
     * @return the asset id
     */
    public BigDecimal getAssetId()
    {
        return assetId;
    }

    /**
     * Sets the asset id.
     *
     * @param assetId the new asset id
     */
    public void setAssetId( BigDecimal assetId )
    {
        this.assetId = assetId;
    }

    /**
     * Gets the namespace cd.
     *
     * @return the namespace cd
     */
    public String getNamespaceCd()
    {
        return namespaceCd;
    }

    /**
     * Sets the namespace cd.
     *
     * @param namespaceCd the new namespace cd
     */
    public void setNamespaceCd( String namespaceCd )
    {
        this.namespaceCd = namespaceCd;
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
     * Gets the last update date.
     *
     * @return the last update date
     */
    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    /**
     * Sets the last update date.
     *
     * @param lastUpdateDate the new last update date
     */
    public void setLastUpdateDate( Date lastUpdateDate )
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Gets the asset url.
     *
     * @return the asset url
     */
    public String getAssetUrl()
    {
        return assetUrl;
    }

    /**
     * Sets the asset url.
     *
     * @param assetUrl the new asset url
     */
    public void setAssetUrl( String assetUrl )
    {
        this.assetUrl = assetUrl;
    }

    /**
     * Gets the asset mime type.
     *
     * @return the asset mime type
     */
    public String getAssetMimeType()
    {
        return assetMimeType;
    }

    /**
     * Sets the asset mime type.
     *
     * @param assetMimeType the new asset mime type
     */
    public void setAssetMimeType( String assetMimeType )
    {
        this.assetMimeType = assetMimeType;
    }

    /**
     * Gets the asset properties.
     *
     * @return the asset properties
     */
    @XmlTransient
    public List<AssetProperty> getAssetProperties()
    {
        return assetProperties;
    }

    /**
     * Sets the asset properties.
     *
     * @param assetProperties the new asset properties
     */
    public void setAssetProperties( List<AssetProperty> assetProperties )
    {
        this.assetProperties = assetProperties;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( assetId != null ? assetId.hashCode() : 0 );
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
        if ( !( object instanceof Asset ) )
        {
            return false;
        }
        final Asset other = (Asset) object;
        if ( ( this.assetId == null && other.assetId != null )
            || ( this.assetId != null && !this.assetId.equals( other.assetId ) ) )
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
        return "org.openinfobutton.content.model.Asset[ assetId=" + assetId + "\t" + displayName + " ]";
    }

}
