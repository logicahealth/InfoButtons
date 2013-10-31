package org.openinfobutton.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rick
 */

@Entity
@Table(name = "OIB_ASSET")
@XmlRootElement
public class Asset implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Id
//    @SequenceGenerator(name = "objectIdSequence", sequenceName = "OIB_ID_SEQ")
//    @GeneratedValue(strategy = GenerationType.AUTO, generator="objectIdSequence")  
    @Basic(optional = false)
    @Column(name = "ASSET_ID")
    private BigDecimal assetId;
    
    @Column(name = "NAMESPACE_CD")
    private String namespaceCd;
    
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    
    @Column(name = "LAST_UPDATE_DTS")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdateDate;
        
    @Column(name = "ASSET_URL")
    private String assetUrl;
    
    @Column(name = "ASSET_MIME_TYPE")
    private String assetMimeType;
    
    @OneToMany(fetch=FetchType.EAGER , mappedBy = "asset")
    private List<AssetProperty> assetProperties;

    public Asset() {
    }

    public Asset(BigDecimal assetId) {
        this.assetId = assetId;
    }

    public BigDecimal getAssetId() {
        return assetId;
    }
    
    public void setAssetId(BigDecimal assetId) {
        this.assetId = assetId;
    }

    public String getNamespaceCd() {
        return namespaceCd;
    }

    public void setNamespaceCd(String namespaceCd) {
        this.namespaceCd = namespaceCd;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl;
    }

    public String getAssetMimeType() {
        return assetMimeType;
    }

    public void setAssetMimeType(String assetMimeType) {
        this.assetMimeType = assetMimeType;
    }
    
    @XmlTransient
    public List<AssetProperty> getAssetProperties() {
        return assetProperties;
    }

    public void setAssetProperties(List<AssetProperty> assetProperties) {
        this.assetProperties = assetProperties;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetId != null ? assetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.assetId == null && other.assetId != null) || (this.assetId != null && !this.assetId.equals(other.assetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openinfobutton.content.model.Asset[ assetId=" + assetId + "\t" + displayName + " ]";
    }
    
}
