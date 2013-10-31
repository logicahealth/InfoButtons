package org.openinfobutton.responder.service;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Asset;

/**
 *
 * @author rick
 */
public interface ResponderService {

    Set<String> getRxNormQueryExpansionTermTypes();

    Map<String, String> getFlatRequestMapFromHttpRequestParameterMap(Map httpRequestParameters);

    Map<String, Map<String, String>> getRequestParameterDbMap();

    Collection<Asset> findAssetsByInfobuttonRequest(Map<String, String> requestParameters);

    Properties getAppProperties(String propertyGroup);

    int validateRequest(Map<String, String> requestParameters);
    
}
