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

// TODO: Auto-generated Javadoc
/**
 * The Class ResponderValueSetDaoImpl.
 *
 * @author rick
 */
@Repository
public class ResponderValueSetDaoImpl
    extends DaoBase<ValueSet>
    implements ResponderValueSetDao
{

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.IValueSetDao#getValueSetCodes(java.math.BigDecimal)
     */
    @Override
    public List<ValueSetCode> getValueSetCodes( BigDecimal valueSetId )
    {

        final List<ValueSetCode> results =
            getSessionFactory().getCurrentSession().createCriteria( ValueSetCode.class ).add
            ( Restrictions.eq( "valueSetId",
             valueSetId ) ).addOrder( Order.asc( "listOrder" ) ).addOrder( Order.asc( "codeDisplayName" ) )
             .list();

        return results;
    }

}
