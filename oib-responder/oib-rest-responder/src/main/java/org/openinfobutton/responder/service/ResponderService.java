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
package org.openinfobutton.responder.service;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Asset;
import org.springframework.web.bind.MissingServletRequestParameterException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ResponderService.
 *
 * @author rick
 */
public interface ResponderService
{

    /**
     * Gets the rx norm query expansion term types.
     *
     * @return the rx norm query expansion term types
     */
    Set<String> getRxNormQueryExpansionTermTypes();

    /**
     * Gets the knowledge request parameter map.
     *
     * @param httpRequestParameters the http request parameters
     * @return the knowledge request parameter map
     */
    Map<String, String> getKnowledgeRequestParameterMap( Map httpRequestParameters );

    /**
     * Gets the index property interpretation map.
     *
     * @return the index property interpretation map
     */
    Map<String, Map<String, String>> getIndexPropertyInterpretationMap();

    /**
     * Find assets by infobutton request.
     *
     * @param requestParameters the request parameters
     * @return the collection
     */
    Collection<Asset> findAssetsByInfobuttonRequest( Map<String, String> requestParameters );

    /**
     * Gets the application properties.
     *
     * @param propertyGroup the property group
     * @return the application properties
     */
    Properties getApplicationProperties( String propertyGroup );

    /**
     * Request contains required parameters.
     *
     * @param requestParameters the request parameters
     * @return true, if successful
     * @throws MissingServletRequestParameterException the missing servlet request parameter exception
     */
    boolean requestContainsRequiredParameters( Map<String, String> requestParameters )
        throws MissingServletRequestParameterException;

}
