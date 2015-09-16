package org.openinfobutton.app.model;

/*
 * #%L
 * Project:  oib-app-model
 * Director: Guilherme Del Fiol, MD, PhD
 *           University of Utah
 *           Biomedical Informatics
 *           421 Wakara Way, Suite 140
 *           Salt Lake City, UT 84108-3514
 * Phone:    801-581-4080
 * %%
 * Copyright (C) 2010 - 2014 University of Utah
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class ValueSetCode.
 *
 * @author rick
 */
@Entity
@Table(name = "OIB_VALUE_SET_CODE")
@XmlRootElement
public class ValueSetCode
        implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The value set code id.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "VALUE_SET_CODE_ID")
    private BigDecimal valueSetCodeId;

    /**
     * The value set id.
     */
    @Column(name = "VALUE_SET_ID")
    private BigDecimal valueSetId;

    /**
     * The code.
     */
    @Column(name = "CODE")
    private String code;

    /**
     * The code system oid.
     */
    @Column(name = "CODE_SYSTEM_OID")
    private String codeSystemOid;

    /**
     * The code display name.
     */
    @Column(name = "CODE_DISPLAY_NAME")
    private String codeDisplayName;

    /**
     * The list order.
     */
    @Column(name = "LIST_ORDER")
    private Integer listOrder;

    /**
     * The parent value set code id.
     */
    @Column(name = "PARENT_VALUE_SET_CODE_ID")
    private BigDecimal parentValueSetCodeId;

    /**
     * The code uri.
     */
    @Column(name = "CODE_URI")
    private String codeUri;

    /**
     * Gets the value set code id.
     *
     * @return the value set code id
     */
    public BigDecimal getValueSetCodeId() {
        return valueSetCodeId;
    }

    /**
     * Sets the value set code id.
     *
     * @param valueSetCodeId the new value set code id
     */
    public void setValueSetCodeId(BigDecimal valueSetCodeId) {
        this.valueSetCodeId = valueSetCodeId;
    }

    /**
     * Gets the value set id.
     *
     * @return the value set id
     */
    public BigDecimal getValueSetId() {
        return valueSetId;
    }

    /**
     * Sets the value set id.
     *
     * @param valueSetId the new value set id
     */
    public void setValueSetId(BigDecimal valueSetId) {
        this.valueSetId = valueSetId;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the code system oid.
     *
     * @return the code system oid
     */
    public String getCodeSystemOid() {
        return codeSystemOid;
    }

    /**
     * Sets the code system oid.
     *
     * @param codeSystemOid the new code system oid
     */
    public void setCodeSystemOid(String codeSystemOid) {
        this.codeSystemOid = codeSystemOid;
    }

    /**
     * Gets the code display name.
     *
     * @return the code display name
     */
    public String getCodeDisplayName() {
        return codeDisplayName;
    }

    /**
     * Sets the code display name.
     *
     * @param codeDisplayName the new code display name
     */
    public void setCodeDisplayName(String codeDisplayName) {
        this.codeDisplayName = codeDisplayName;
    }

    /**
     * Gets the list order.
     *
     * @return the list order
     */
    public Integer getListOrder() {
        return listOrder;
    }

    /**
     * Sets the list order.
     *
     * @param listOrder the new list order
     */
    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
    }

    /**
     * Gets the parent value set code id.
     *
     * @return the parent value set code id
     */
    public BigDecimal getParentValueSetCodeId() {
        return parentValueSetCodeId;
    }

    /**
     * Sets the parent value set code id.
     *
     * @param parentValueSetCodeId the new parent value set code id
     */
    public void setParentValueSetCodeId(BigDecimal parentValueSetCodeId) {
        this.parentValueSetCodeId = parentValueSetCodeId;
    }

    /**
     * Gets the code uri.
     *
     * @return the code uri
     */
    public String getCodeUri() {
        return codeUri;
    }

    /**
     * Sets the code uri.
     *
     * @param codeUri the new code uri
     */
    public void setCodeUri(String codeUri) {
        this.codeUri = codeUri;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valueSetCodeId != null ? valueSetCodeId.hashCode() : 0);
        return hash;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValueSetCode)) {
            return false;
        }
        final ValueSetCode other = (ValueSetCode) object;
        if ((this.valueSetCodeId == null && other.valueSetCodeId != null)
                || (this.valueSetCodeId != null && !this.valueSetCodeId.equals(other.valueSetCodeId))) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "org.openinfobutton.responder.model.ValueSetCode[ valueSetCodeId=" + valueSetCodeId + "\t"
                + codeDisplayName + " ]";
    }

}
