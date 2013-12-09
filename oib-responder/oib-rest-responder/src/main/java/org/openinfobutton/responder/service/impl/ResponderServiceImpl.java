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
import org.springframework.web.bind.MissingServletRequestParameterException;

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
        
        Properties valueSetIds = getApplicationProperties("app.valueset.id");
        String rxNormQueryExpansionValueSetId = (String)valueSetIds.get("RXNORM_QUERY_EXPANSION_TERM_TYPE_CODES");
        List<ValueSetCode> valueSet = responderValueSetDao.getValueSetCodes( new BigDecimal( rxNormQueryExpansionValueSetId ) );
                
        for ( ValueSetCode termType:valueSet ) {
            rxNormQueryExpansionTermTypes.add( termType.getCode() );
        }
        
        return rxNormQueryExpansionTermTypes;
        
    }
    
    public Map<String, Map<String, String>> getIndexPropertyInterpretationMap(Collection<RequestParameter> requestParameters) {

        if ( requestParameterCodeMap != null ) { // if already built, don't need to rebuild; static
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
    public Map<String, Map<String, String>> getIndexPropertyInterpretationMap() {
        
        if ( requestParameterCodeMap != null ) { // if already built, don't need to rebuild; static
            return requestParameterCodeMap;
        }
        
        Collection<RequestParameter> requestParameters = responderRequestParameterDao.getSupportedOpenInfobuttonRequestParametersOrdered();

        return getIndexPropertyInterpretationMap(requestParameters);

    }

    @Override
    @Transactional
    public int validateRequest(Map<String, String> requestParameters) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, String> getKnowledgeRequestParameterMap(Map httpRequestParameters) throws MissingServletRequestParameterException {

        Map<String, String> requestParameters = new HashMap<String, String>();

        for (Object parameterName : httpRequestParameters.keySet()) {

            String parameterNameString = (String) parameterName;
            String[] parameterValues = (String[]) httpRequestParameters.get(parameterNameString);

            int i = 0;
            for (String parameterValue : parameterValues) { // multiple parameters with the same name are not supported by the specification

                if (i == 0) {
                    requestParameters.put(parameterNameString, parameterValue);
                } else {
                    throw new IllegalArgumentException("Invalid request argument: there are mutiple values for " + parameterNameString
                            + ". Parameters that support multple values require an index number appended to the end of the parameter name."
                            + " Example: Two values for 'mainSearchCriteria.c.c' requires a second parameter 'mainsearchCriteria.c.c1'.");
                }
                i++;
            }

        }

        containsRequiredParameters(requestParameters);
        
        return requestParameters;
    }
    
    private void containsRequiredParameters(Map<String, String> requestParameters) throws MissingServletRequestParameterException {
        
        StringBuffer errorMessage = new StringBuffer();
        
        if ( requestParameters.get("mainSearchCriteria.c.c") != null ) {
            errorMessage.append("mainSearchCriteria.c.c: ");
        }
        else if ( requestParameters.get("mainSearchCriteria.c.cs") != null ) {
            errorMessage.append("mainSearchCriteria.c.cs: ");            
        }
        else if ( requestParameters.get("taskContext.c.c") != null ) {
            errorMessage.append("taskContext.c.c: ");            
        }
            
        else
            throw new MissingServletRequestParameterException(errorMessage.toString(),"is/are required. ");
        
    }

    @Override
    @Transactional
    public Properties getApplicationProperties(String propertyGroup ) {
        
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
