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
package org.openinfobutton.service.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.service.dao.AppPropertyDao;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class AppPropertyDaoImpl.
 *
 * @author rick
 */
@Repository
public class AppPropertyDaoImpl
    extends DaoBase<AppProperty>
    implements AppPropertyDao
{

    /** The app properties. */
    Properties appProperties;

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.IAppPropertyDao#getAppPropertyGroup(java.lang.String)
     */
    @Override
    public List<AppProperty> getAppPropertyGroup( String propertyGroup )
    {
        return getSessionFactory().getCurrentSession().createCriteria( AppProperty.class ).add
                        ( Restrictions.eq( "propertyGroup",
                          propertyGroup ) ).list();
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.AppPropertyDao#getAppProperties(java.lang.String)
     */
    @Override
    public Properties getAppProperties( String propertyGroup )
    {

        if ( appProperties != null )
        { // only retrieve from the db and configure once when empty, doesn't change
            return appProperties;
        }

        appProperties = new Properties();

        final Collection<AppProperty> appPropertyCollection = getAppPropertyGroup( propertyGroup );

        for ( final AppProperty appProperty : appPropertyCollection )
        {
            appProperties.put( appProperty.getPropertyName(), appProperty.getPropertyValue() );
        }

        return appProperties;

    }

}
