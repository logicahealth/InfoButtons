package org.openinfobutton.oibpropertydb.domain;

import javax.persistence.*;

@Entity
@Table(name = "oib_app_property")
public class OibAppProperty {

    private int appPropertyId;
    private String propName;
    private String propDescription;
    private String propValue;

    @Id
    @Column(name = "app_property_id")
    @GeneratedValue( strategy = GenerationType.AUTO )
    public int getAppPropertyId() {
        return appPropertyId;
    }

    public void setAppPropertyId(int appPropertyId) {
        this.appPropertyId = appPropertyId;
    }

    @Basic
    @Column(name = "prop_name")
    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    @Basic
    @Column(name = "prop_description")
    public String getPropDescription() {
        return propDescription;
    }

    public void setPropDescription(String propDescription) {
        this.propDescription = propDescription;
    }

    @Basic
    @Column(name = "prop_value")
    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OibAppProperty that = (OibAppProperty) o;

        if (appPropertyId != that.appPropertyId) return false;
        if (propName != null ? !propName.equals(that.propName) : that.propName != null) return false;
        if (propDescription != null ? !propDescription.equals(that.propDescription) : that.propDescription != null)
            return false;
        if (propValue != null ? !propValue.equals(that.propValue) : that.propValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appPropertyId;
        result = 31 * result + (propName != null ? propName.hashCode() : 0);
        result = 31 * result + (propDescription != null ? propDescription.hashCode() : 0);
        result = 31 * result + (propValue != null ? propValue.hashCode() : 0);
        return result;
    }
}
