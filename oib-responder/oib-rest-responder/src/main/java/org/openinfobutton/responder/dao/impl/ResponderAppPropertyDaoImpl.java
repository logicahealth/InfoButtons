package org.openinfobutton.responder.dao.impl;

import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.responder.dao.ResponderAppPropertyDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rick
 */
@Repository
public class ResponderAppPropertyDaoImpl extends DaoBase<AppProperty> implements ResponderAppPropertyDao {

    @Override
    public List<AppProperty> getAppPropertyGroup(String propertyGroup) {
        return getSessionFactory()
                .getCurrentSession()
                .createCriteria(AppProperty.class)
                .add(Restrictions.eq("propertyGroup", propertyGroup))
                .list();
    }

}
