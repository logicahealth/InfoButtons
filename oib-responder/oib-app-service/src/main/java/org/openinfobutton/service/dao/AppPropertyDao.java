package org.openinfobutton.service.dao;

import java.util.Properties;
import org.openinfobutton.app.dao.IAppPropertyDao;

/**
 *
 * @author rick
 */
public interface AppPropertyDao extends IAppPropertyDao {

    public Properties getAppProperties(String propertyGroup);

}
