package org.openinfobutton.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rick
 */
@Entity
@Table(name = "OIB_VALUE_SET_CODE")
@XmlRootElement
public class ValueSetCode implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "VALUE_SET_CODE_ID")
    private BigDecimal valueSetCodeId;

    @Column(name = "VALUE_SET_ID")
    private BigDecimal valueSetId;
    
    @Column(name = "CODE")
    private String code;
    
    @Column(name = "CODE_SYSTEM_OID")
    private String codeSystemOid;
    
    @Column(name = "CODE_DISPLAY_NAME")
    private String codeDisplayName;
    
    @Column(name =  "LIST_ORDER")
    private Integer listOrder;
    
    @Column(name = "PARENT_VALUE_SET_CODE_ID")
    private BigDecimal parentValueSetCodeId;
    
    @Column(name = "CODE_URI")
    private String codeUri;

    public BigDecimal getValueSetCodeId() {
        return valueSetCodeId;
    }

    public void setValueSetCodeId(BigDecimal valueSetCodeId) {
        this.valueSetCodeId = valueSetCodeId;
    }

    public BigDecimal getValueSetId() {
        return valueSetId;
    }

    public void setValueSetId(BigDecimal valueSetId) {
        this.valueSetId = valueSetId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeSystemOid() {
        return codeSystemOid;
    }

    public void setCodeSystemOid(String codeSystemOid) {
        this.codeSystemOid = codeSystemOid;
    }

    public String getCodeDisplayName() {
        return codeDisplayName;
    }

    public void setCodeDisplayName(String codeDisplayName) {
        this.codeDisplayName = codeDisplayName;
    }

    public Integer getListOrder() {
        return listOrder;
    }

    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
    }

    public BigDecimal getParentValueSetCodeId() {
        return parentValueSetCodeId;
    }

    public void setParentValueSetCodeId(BigDecimal parentValueSetCodeId) {
        this.parentValueSetCodeId = parentValueSetCodeId;
    }

    public String getCodeUri() {
        return codeUri;
    }

    public void setCodeUri(String codeUri) {
        this.codeUri = codeUri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valueSetCodeId != null ? valueSetCodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValueSetCode)) {
            return false;
        }
        ValueSetCode other = (ValueSetCode) object;
        if ((this.valueSetCodeId == null && other.valueSetCodeId != null) || (this.valueSetCodeId != null && !this.valueSetCodeId.equals(other.valueSetCodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openinfobutton.responder.model.ValueSetCode[ valueSetCodeId=" + valueSetCodeId + "\t" + codeDisplayName + " ]";
    }
    
}
