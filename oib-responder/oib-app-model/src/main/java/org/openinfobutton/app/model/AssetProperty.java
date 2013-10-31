package org.openinfobutton.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rick
 */
@Entity
@Table(name = "OIB_ASSET_PROPERTY")
@XmlRootElement
public class AssetProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "objectIdSequence2", sequenceName = "OIB_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="objectIdSequence2")  
    @Basic(optional = false)
    @Column(name = "ASSET_PROPERTY_ID")
    private BigDecimal assetPropertyId;
    
    @Column(name = "PROP_GROUP_NUM")
    private BigInteger propertyGroupNumber;
    @Column(name = "PROP_NAME")
    private String propertyName;
    @Column(name = "PROP_TYPE_CD")
    private String propertyType;
    @Column(name = "CODE")
    private String code;
    @Column(name = "CODE_SYSTEM")
    private String codeSystem;
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Column(name = "PROP_VALUE")
    private String propertyValue;
    @Column(name = "GENERATED_BY_CD")
    private String generatedByCode;
    @JoinColumn(name = "ASSET_ID", referencedColumnName = "ASSET_ID")
    @ManyToOne
    private Asset asset;

    public AssetProperty() {
    }

    public AssetProperty(BigDecimal assetPropertyId) {
        this.assetPropertyId = assetPropertyId;
    }

    public BigDecimal getAssetPropertyId() {
        return assetPropertyId;
    }

    public void setAssetPropertyId(BigDecimal assetPropertyId) {
        this.assetPropertyId = assetPropertyId;
    }

    public BigInteger getPropertyGroupNumber() {
        return propertyGroupNumber;
    }

    public void setPropertyGroupNumber(BigInteger propertyGroupNumber) {
        this.propertyGroupNumber = propertyGroupNumber;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeSystem() {
        return codeSystem;
    }

    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setGeneratedByCode(String generatedByCode) {
        this.generatedByCode = generatedByCode;
    }

    public String getGeneratedByCode() {
        return generatedByCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetPropertyId != null ? assetPropertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssetProperty)) {
            return false;
        }
        AssetProperty other = (AssetProperty) object;
        if ((this.assetPropertyId == null && other.assetPropertyId != null) || (this.assetPropertyId != null && !this.assetPropertyId.equals(other.assetPropertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openinfobutton.app.model.AssetProperty[ assetPropertyId=" + assetPropertyId + " ]";
    }
}
