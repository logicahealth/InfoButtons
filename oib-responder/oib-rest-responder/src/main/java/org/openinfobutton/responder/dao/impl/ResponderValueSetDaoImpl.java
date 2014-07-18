package org.openinfobutton.responder.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.ValueSet;
import org.openinfobutton.app.model.ValueSetCode;
import org.openinfobutton.responder.dao.ResponderValueSetDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rick
 */
@Repository
public class ResponderValueSetDaoImpl extends DaoBase<ValueSet> implements ResponderValueSetDao {

    @Override
    public List<ValueSetCode> getValueSetCodes(BigDecimal valueSetId) {

        List<ValueSetCode> results = getSessionFactory()
                .getCurrentSession()
                .createCriteria(ValueSetCode.class)
                .add(Restrictions.eq("valueSetId", valueSetId))
                .addOrder(Order.asc("listOrder"))
                .addOrder(Order.asc("codeDisplayName"))
                .list();

        return results;
    }

}
