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
package org.openinfobutton.app.dao;

import java.util.List;
import org.openinfobutton.app.model.AppProperty;

// TODO: Auto-generated Javadoc
/**
 * The Interface AppPropertyDaoI.
 *
 * @author rick
 */
public interface AppPropertyDaoI
    extends DaoBaseI<AppProperty>
{

    /**
     * Gets the app property group.
     *
     * @param propertyGroup the property group
     * @return the app property group
     */
    List<AppProperty> getAppPropertyGroup( String propertyGroup );

}
