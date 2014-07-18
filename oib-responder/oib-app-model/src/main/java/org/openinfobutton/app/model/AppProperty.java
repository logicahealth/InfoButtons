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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class AppProperty.
 *
 * @author rick
 */

@Entity
@Table( name = "OIB_APP_PROPERTY" )
@XmlRootElement
public class AppProperty
    implements Serializable
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The app property id. */
    @Id
    @Basic( optional = false )
    @Column( name = "APP_PROPERTY_ID" )
    private BigDecimal appPropertyId;

    /** The property group. */
    @Column( name = "PROP_GROUP_CD" )
    private String propertyGroup;

    /** The property name. */
    @Column( name = "PROP_NAME" )
    private String propertyName;

    /** The property value. */
    @Column( name = "PROP_VALUE" )
    private String propertyValue;

    /**
     * Gets the app property id.
     *
     * @return the app property id
     */
    public BigDecimal getAppPropertyId()
    {
        return appPropertyId;
    }

    /**
     * Sets the app property id.
     *
     * @param appPropertyId the new app property id
     */
    public void setAppPropertyId( BigDecimal appPropertyId )
    {
        this.appPropertyId = appPropertyId;
    }

    /**
     * Gets the property group.
     *
     * @return the property group
     */
    public String getPropertyGroup()
    {
        return propertyGroup;
    }

    /**
     * Sets the property group.
     *
     * @param propertyGroup the new property group
     */
    public void setPropertyGroup( String propertyGroup )
    {
        this.propertyGroup = propertyGroup;
    }

    /**
     * Gets the property name.
     *
     * @return the property name
     */
    public String getPropertyName()
    {
        return propertyName;
    }

    /**
     * Sets the property name.
     *
     * @param propertyName the new property name
     */
    public void setPropertyName( String propertyName )
    {
        this.propertyName = propertyName;
    }

    /**
     * Gets the property value.
     *
     * @return the property value
     */
    public String getPropertyValue()
    {
        return propertyValue;
    }

    /**
     * Sets the property value.
     *
     * @param propertyValue the new property value
     */
    public void setPropertyValue( String propertyValue )
    {
        this.propertyValue = propertyValue;
    }

}
