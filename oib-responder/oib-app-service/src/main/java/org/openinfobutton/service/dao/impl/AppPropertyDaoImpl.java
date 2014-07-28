package org.openinfobutton.service.dao.impl;

/*
 * #%L
 * Project:  oib-app-service
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
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.service.dao.AppPropertyDao;
import org.springframework.stereotype.Repository;

/**
 * The Class AppPropertyDaoImpl.
 *
 * @author rick
 */
@Repository
public class AppPropertyDaoImpl
        extends DaoBase<AppProperty>
        implements AppPropertyDao {

    /**
     * The app properties.
     */
    Properties appProperties;

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.IAppPropertyDao#getAppPropertyGroup(java.lang.String)
     */
    @Override
    public List<AppProperty> getAppPropertyGroup(String propertyGroup) {
        return getSessionFactory().getCurrentSession().createCriteria(AppProperty.class).add(Restrictions.eq("propertyGroup",
                propertyGroup)).list();
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.AppPropertyDao#getAppProperties(java.lang.String)
     */
    @Override
    public Properties getAppProperties(String propertyGroup) {

        if (appProperties != null) { // only retrieve from the db and configure once when empty, doesn't change
            return appProperties;
        }

        appProperties = new Properties();

        final Collection<AppProperty> appPropertyCollection = getAppPropertyGroup(propertyGroup);

        for (final AppProperty appProperty : appPropertyCollection) {
            appProperties.put(appProperty.getPropertyName(), appProperty.getPropertyValue());
        }

        return appProperties;

    }

}
