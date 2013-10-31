package org.openinfobutton.app.dao;

import java.util.List;
import org.openinfobutton.app.model.AppProperty;

/**
 *
 * @author rick
 */
public interface IAppPropertyDao extends IDaoBase<AppProperty> {
 
    List<AppProperty> getAppPropertyGroup( String propertyGroup );

}
