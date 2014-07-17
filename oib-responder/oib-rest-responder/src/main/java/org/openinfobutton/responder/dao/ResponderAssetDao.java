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
package org.openinfobutton.responder.dao;

import java.util.Collection;
import java.util.Map;
import org.openinfobutton.app.dao.IAssetDao;
import org.openinfobutton.app.model.Asset;

// TODO: Auto-generated Javadoc
/**
 * The Interface ResponderAssetDao.
 *
 * @author rick
 */
public interface ResponderAssetDao
    extends IAssetDao
{

    /**
     * Find by infobutton request.
     *
     * @param requestParameters the request parameters
     * @return the collection
     */
    Collection<Asset> findByInfobuttonRequest( Map<String, String> requestParameters );

}
