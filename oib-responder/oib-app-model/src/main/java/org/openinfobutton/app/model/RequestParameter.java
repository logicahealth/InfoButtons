package org.openinfobutton.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rick
 */
@Entity
@Table(name = "OIB_REQUEST_PARAMETER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestParameter.findAll", query = "SELECT o FROM RequestParameter o"),
    @NamedQuery(name = "RequestParameter.findByRequestParameterId", query = "SELECT o FROM RequestParameter o WHERE o.requestParameterId = :requestParameterId"),
    @NamedQuery(name = "RequestParameter.findByParameterName", query = "SELECT o FROM RequestParameter o WHERE o.parameterName = :parameterName"),
    @NamedQuery(name = "RequestParameter.findByParameterDescription", query = "SELECT o FROM RequestParameter o WHERE o.parameterDescription = :parameterDescription"),
    @NamedQuery(name = "RequestParameter.findByCardinalityMin", query = "SELECT o FROM RequestParameter o WHERE o.cardinalityMin = :cardinalityMin"),
    @NamedQuery(name = "RequestParameter.findByCardinalityMax", query = "SELECT o FROM RequestParameter o WHERE o.cardinalityMax = :cardinalityMax")})

public class RequestParameter implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "REQUEST_PARAMETER_ID")
    private BigDecimal requestParameterId;
    @Column(name = "PARAMETER_NAME")
    private String parameterName;
    @Column(name = "PARAMETER_ROOT")
    private String parameterRoot;
    @Column(name = "TYPE_CD")
    private String typeCode;
    @Column(name = "PARAMETER_DSC")
    private String parameterDescription;
    @Column(name = "CARDINALITY_MIN")
    private Long cardinalityMin;
    @Column(name = "CARDINALITY_MAX")
    private BigInteger cardinalityMax;

    public RequestParameter() {
    }

    public RequestParameter(BigDecimal requestParameterId) {
        this.requestParameterId = requestParameterId;
    }

    public BigDecimal getRequestParameterId() {
        return requestParameterId;
    }

    public void setRequestParameterId(BigDecimal requestParameterId) {
        this.requestParameterId = requestParameterId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterRoot() {
        return parameterRoot;
    }

    public void setParameterRoot(String parameterRoot) {
        this.parameterRoot = parameterRoot;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getParameterDescription() {
        return parameterDescription;
    }

    public void setParameterDescription(String parameterDescription) {
        this.parameterDescription = parameterDescription;
    }

    public Long getCardinalityMin() {
        return cardinalityMin;
    }

    public void setCardinalityMin(Long cardinalityMin) {
        this.cardinalityMin = cardinalityMin;
    }

    public BigInteger getCardinalityMax() {
        return cardinalityMax;
    }

    public void setCardinalityMax(BigInteger cardinalityMax) {
        this.cardinalityMax = cardinalityMax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestParameterId != null ? requestParameterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestParameter)) {
            return false;
        }
        RequestParameter other = (RequestParameter) object;
        if ((this.requestParameterId == null && other.requestParameterId != null) || (this.requestParameterId != null && !this.requestParameterId.equals(other.requestParameterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openinfobutton.request.model.RequestParameter[ requestParameterId=" + requestParameterId + " ]";
    }
    
}
