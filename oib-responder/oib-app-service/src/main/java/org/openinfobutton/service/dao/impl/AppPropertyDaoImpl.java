package org.openinfobutton.service.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.service.dao.AppPropertyDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rick
 */
@Repository
public class AppPropertyDaoImpl extends DaoBase<AppProperty> implements AppPropertyDao {
    
    Properties appProperties;

    @Override
    public List<AppProperty> getAppPropertyGroup( String propertyGroup ) {
        return getSessionFactory()
                .getCurrentSession()
                .createCriteria(AppProperty.class)
                .add(Restrictions.eq("propertyGroup", propertyGroup))
                .list();
    }
    
    @Override
    public Properties getAppProperties(String propertyGroup ) {
        
        if ( appProperties != null ) { // only retrieve from the db and configure once when empty, doesn't change
            return appProperties;
        }
        
        appProperties = new Properties();
        
        Collection<AppProperty> appPropertyCollection = getAppPropertyGroup( propertyGroup );
        
        for ( AppProperty appProperty: appPropertyCollection ) {
            appProperties.put( appProperty.getPropertyName(), appProperty.getPropertyValue() );
        }
        
        return appProperties;
    
    }

    
}
