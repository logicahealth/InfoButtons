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

import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.responder.dao.ResponderAppPropertyDao;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponderAppPropertyDaoImpl.
 *
 * @author rick
 */
@Repository
public class ResponderAppPropertyDaoImpl
    extends DaoBase<AppProperty>
    implements ResponderAppPropertyDao
{

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.app.dao.IAppPropertyDao#getAppPropertyGroup(java.lang.String)
     */
    @Override
    public List<AppProperty> getAppPropertyGroup( String propertyGroup )
    {
        return getSessionFactory().getCurrentSession().createCriteria( AppProperty.class ).
                        add( Restrictions.eq( "propertyGroup",
                        propertyGroup ) ).list();
    }

}
