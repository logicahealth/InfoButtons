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
package org.openinfobutton.service.dao;

import java.util.Properties;
import org.openinfobutton.app.dao.AppPropertyDaoI;

// TODO: Auto-generated Javadoc
/**
 * The Interface AppPropertyDao.
 *
 * @author rick
 */
public interface AppPropertyDao
    extends AppPropertyDaoI
{

    /**
     * Gets the app properties.
     *
     * @param propertyGroup the property group
     * @return the app properties
     */
    public Properties getAppProperties( String propertyGroup );

}
