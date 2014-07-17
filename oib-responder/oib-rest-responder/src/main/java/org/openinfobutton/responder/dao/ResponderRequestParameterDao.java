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
import java.util.List;
import org.openinfobutton.app.dao.IRequestParameterDao;
import org.openinfobutton.app.model.RequestParameter;

// TODO: Auto-generated Javadoc
/**
 * The Interface ResponderRequestParameterDao.
 *
 * @author rick
 */
public interface ResponderRequestParameterDao
    extends IRequestParameterDao
{

    /**
     * Sets the all open infobutton request parameters.
     *
     * @param allOpenInfobuttonRequestParameters the new all open infobutton request parameters
     */
    void setAllOpenInfobuttonRequestParameters( List<RequestParameter> allOpenInfobuttonRequestParameters );

    /**
     * Gets the supported open infobutton request parameters ordered.
     *
     * @return the supported open infobutton request parameters ordered
     */
    List<RequestParameter> getSupportedOpenInfobuttonRequestParametersOrdered();

    /**
     * Gets the open infobutton request parameters by min cardinality.
     *
     * @param minCardinality the min cardinality
     * @return the open infobutton request parameters by min cardinality
     */
    Collection<RequestParameter> getOpenInfobuttonRequestParametersByMinCardinality( int minCardinality );

    /**
     * Gets the required open infobutton request parameters.
     *
     * @return the required open infobutton request parameters
     */
    Collection<RequestParameter> getRequiredOpenInfobuttonRequestParameters();

    /**
     * Gets the open infobutton request parameter by name.
     *
     * @param paramaterName the paramater name
     * @return the open infobutton request parameter by name
     */
    RequestParameter getOpenInfobuttonRequestParameterByName( String paramaterName );

}
