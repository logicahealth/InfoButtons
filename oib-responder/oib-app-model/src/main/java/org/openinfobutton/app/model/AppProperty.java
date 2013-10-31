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
@Table(name = "OIB_APP_PROPERTY")
@XmlRootElement
public class AppProperty implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @Basic(optional = false)
    @Column(name = "APP_PROPERTY_ID")
    private BigDecimal appPropertyId;
    
    @Column(name = "PROP_GROUP_CD")
    private String propertyGroup;
    
    @Column(name = "PROP_NAME")
    private String propertyName;
    
    @Column(name = "PROP_VALUE")
    private String propertyValue;

    public BigDecimal getAppPropertyId() {
        return appPropertyId;
    }

    public void setAppPropertyId(BigDecimal appPropertyId) {
        this.appPropertyId = appPropertyId;
    }

    public String getPropertyGroup() {
        return propertyGroup;
    }

    public void setPropertyGroup(String propertyGroup) {
        this.propertyGroup = propertyGroup;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
        
}
