package org.openinfobutton.responder.service;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Asset;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 *
 * @author rick
 */
public interface ResponderService {

    Set<String> getRxNormQueryExpansionTermTypes();

    Map<String, String> getKnowledgeRequestParameterMap(Map httpRequestParameters) throws MissingServletRequestParameterException;

    Map<String, Map<String, String>> getIndexPropertyInterpretationMap();

    Collection<Asset> findAssetsByInfobuttonRequest(Map<String, String> requestParameters);

    Properties getApplicationProperties(String propertyGroup);

    int validateRequest(Map<String, String> requestParameters);
    
}
