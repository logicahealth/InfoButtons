/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author rick
 */
@Entity
@Table(name = "OIB_VALUE_SET")
@XmlRootElement
public class ValueSet implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "VALUE_SET_ID")
    private BigDecimal valueSetId;

    @Column(name = "VALUE_SET_TYPE_CD")
    private String valueSetTypeCode;
    
    @Column(name = "VALUE_SET_OID")
    private String valueSetOid;
    
    @Column(name = "VALUE_SET_DISPLAY_NAME")
    private String valueSetDisplayName;
    
    @Column(name = "VALUE_SET_URI")
    private String valueSetUri;
    
    @OneToMany(fetch=FetchType.EAGER , mappedBy = "valueSetId")
    private Collection<ValueSetCode> valueSetCodes;
    
    public BigDecimal getValueSetId() {
        return valueSetId;
    }

    public void setValueSetId(BigDecimal valueSetId) {
        this.valueSetId = valueSetId;
    }

    public String getValueSetTypeCode() {
        return valueSetTypeCode;
    }

    public void setValueSetTypeCode(String valueSetTypeCode) {
        this.valueSetTypeCode = valueSetTypeCode;
    }

    public String getValueSetOid() {
        return valueSetOid;
    }

    public void setValueSetOid(String valueSetOid) {
        this.valueSetOid = valueSetOid;
    }

    public String getValueSetDisplayName() {
        return valueSetDisplayName;
    }

    public void setValueSetDisplayName(String valueSetDisplayName) {
        this.valueSetDisplayName = valueSetDisplayName;
    }

    public String getValueSetUri() {
        return valueSetUri;
    }

    public void setValueSetUri(String valueSetUri) {
        this.valueSetUri = valueSetUri;
    }

    @XmlTransient
    public Collection<ValueSetCode> getValueSetCodes() {
        return valueSetCodes;
    }

    public void setValueSetCodes(Collection<ValueSetCode> valueSetCodes) {
        this.valueSetCodes = valueSetCodes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valueSetId != null ? valueSetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValueSet)) {
            return false;
        }
        ValueSet other = (ValueSet) object;
        if ((this.valueSetId == null && other.valueSetId != null) || (this.valueSetId != null && !this.valueSetId.equals(other.valueSetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openinfobutton.responder.model.ValueSet[ valueSetId=" + valueSetId + "\t" + valueSetDisplayName + " ]";
    }
}
