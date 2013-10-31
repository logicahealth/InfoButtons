package org.openinfobutton.responder.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.RequestParameter;
import org.openinfobutton.app.model.ValueSetCode;
import org.openinfobutton.responder.dao.ResponderAppPropertyDao;
import org.openinfobutton.responder.dao.ResponderAssetDao;
import org.openinfobutton.responder.dao.ResponderRequestParameterDao;
import org.openinfobutton.responder.dao.ResponderValueSetDao;
import org.openinfobutton.responder.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rick
 */
@Service
public class ResponderServiceImpl implements ResponderService {
    
//    private static final Logger log = Logger.getLogger(ResponderServiceImpl.class);

    @Autowired
    private ResponderRequestParameterDao responderRequestParameterDao;

    @Autowired
    private ResponderAssetDao responderAssetDao;

    @Autowired
    private ResponderValueSetDao responderValueSetDao;
    
    @Autowired
    private ResponderAppPropertyDao responderAppPropertyDao;
    
    private Map<String, Map<String, String>> requestParameterCodeMap;
    
    private Properties appProperties;

    private Set<String> rxNormQueryExpansionTermTypes;

    
    @Override
    @Transactional
    public Set<String> getRxNormQueryExpansionTermTypes() { //TODO this could be moved to the query implementation
        
        if ( rxNormQueryExpansionTermTypes == null ) {
            return rxNormQueryExpansionTermTypes;
        }
        
        rxNormQueryExpansionTermTypes = new HashSet<String>();
        
        Properties valueSetIds = getAppProperties("app.valueset.id");
        String rxNormQueryExpansionValueSetId = (String)valueSetIds.get("RXNORM_QUERY_EXPANSION_TERM_TYPE_CODES");
        List<ValueSetCode> valueSet = responderValueSetDao.getValueSetCodes( new BigDecimal( rxNormQueryExpansionValueSetId ) );
                
        for ( ValueSetCode termType:valueSet ) {
            rxNormQueryExpansionTermTypes.add( termType.getCode() );
        }
        
        return rxNormQueryExpansionTermTypes;
        
    }
    
    public Map<String, Map<String, String>> getOpenInfobuttonRequestParameterTypeCodeMap(Collection<RequestParameter> requestParameters) {

        if ( requestParameterCodeMap != null ) { // only retrieve data from the db and configure once when empty, doesn't change
            return requestParameterCodeMap;
        }

        requestParameterCodeMap = new HashMap<String,Map<String,String>>();
        
        String lastParameterRoot = null;
        Map<String, String> parameterMap = new HashMap<String, String>();

        for (RequestParameter requestParameter : requestParameters) {

            if (requestParameter.getParameterName() == null || "".equals(requestParameter.getParameterName())
                    && requestParameter.getParameterRoot() == null || "".equals(requestParameter.getParameterRoot())
                    && requestParameter.getTypeCode() == null || "".equals(requestParameter.getTypeCode())) {
                
                System.out.println("Supported request parameters must have a parameterName, parameterRoot, and typeCode. "
                        + "Invalid parameter id = " + requestParameter.getRequestParameterId() );
            }

            if ( lastParameterRoot != null && !lastParameterRoot.equals( requestParameter.getParameterRoot() ) ) {
                                
                requestParameterCodeMap.put(lastParameterRoot, parameterMap);
                parameterMap = new HashMap<String, String>();

            }

            parameterMap.put( requestParameter.getTypeCode(), requestParameter.getParameterName() );
            lastParameterRoot = requestParameter.getParameterRoot();

        }

        requestParameterCodeMap.put(lastParameterRoot, parameterMap);

        return requestParameterCodeMap;
    }

    @Override
    @Transactional
    public Map<String, Map<String, String>> getRequestParameterDbMap() {
        
        if ( requestParameterCodeMap != null ) { // only retrieve from the db and configure once when empty, doesn't change
            return requestParameterCodeMap;
        }
        
        Collection<RequestParameter> requestParameters = responderRequestParameterDao.getSupportedOpenInfobuttonRequestParametersOrdered();

        return getOpenInfobuttonRequestParameterTypeCodeMap(requestParameters);

    }

    @Override
    @Transactional
    public int validateRequest(Map<String, String> requestParameters) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, String> getFlatRequestMapFromHttpRequestParameterMap(Map httpRequestParameters) {

        Map<String, String> requestParameters = new HashMap<String, String>();

        for (Object parameterName : httpRequestParameters.keySet()) {

            String parameterNameString = (String) parameterName;
            String[] parameterValues = (String[]) httpRequestParameters.get(parameterNameString);

            int i = 0;
            for (String parameterValue : parameterValues) {

                if (i == 0) {
                    requestParameters.put(parameterNameString, parameterValue);
                } else {
                    throw new IllegalArgumentException("Invalid request argument: there are mutiple values for " + parameterNameString
                            + ". Parameters that support multple values require an index number appended to the end of the parameter name."
                            + " For example, when there are two values for 'mainSearchCriteria.c.c', the second parameter name is 'mainsearchCriteria.c.c1'.");
                }
                i++;
            }

        }

        return requestParameters;
    }

    @Override
    @Transactional
    public Properties getAppProperties(String propertyGroup ) {
        
        if ( appProperties != null ) { // only retrieve from the db and configure once when empty, doesn't change
            return appProperties;
        }
        
        appProperties = new Properties();
        
        Collection<AppProperty> appPropertyCollection = responderAppPropertyDao.getAppPropertyGroup( propertyGroup );
        
        for ( AppProperty appProperty: appPropertyCollection ) {
            appProperties.put( appProperty.getPropertyName(), appProperty.getPropertyValue() );
        }
        
        return appProperties;
    
    }

    @Override
    @Transactional
    public Collection<Asset> findAssetsByInfobuttonRequest(Map<String, String> requestParameters) {

        return responderAssetDao.findByInfobuttonRequest(requestParameters);
        
    }
}
