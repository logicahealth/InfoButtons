package org.openinfobutton.responder.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import org.apache.commons.lang.IncompleteArgumentException;
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

    private static final Logger log = Logger.getLogger(ResponderServiceImpl.class.getCanonicalName());
    private ResponderRequestParameterDao responderRequestParameterDao;
    private ResponderAssetDao responderAssetDao;
    private ResponderValueSetDao responderValueSetDao;
    private ResponderAppPropertyDao responderAppPropertyDao;
    private Map<String, Map<String, String>> requestParameterCodeMap;
    private Properties appProperties;
    private Set<String> rxNormQueryExpansionTermTypes;

    @Autowired
    public void setResponderRequestParameterDao(ResponderRequestParameterDao responderRequestParameterDao) {
        this.responderRequestParameterDao = responderRequestParameterDao;
    }

    @Autowired
    public void setResponderAssetDao(ResponderAssetDao responderAssetDao) {
        this.responderAssetDao = responderAssetDao;
    }

    @Autowired
    public void setResponderValueSetDao(ResponderValueSetDao responderValueSetDao) {
        this.responderValueSetDao = responderValueSetDao;
    }

    @Autowired
    public void setResponderAppPropertyDao(ResponderAppPropertyDao responderAppPropertyDao) {
        this.responderAppPropertyDao = responderAppPropertyDao;
    }

    public void setAppProperties(Properties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    @Transactional
    public Set<String> getRxNormQueryExpansionTermTypes() {

        if (rxNormQueryExpansionTermTypes != null) {
            return rxNormQueryExpansionTermTypes;
        }

        rxNormQueryExpansionTermTypes = new HashSet<>();

        Properties valueSetIds = getApplicationProperties("app.valueset.id");
        String rxNormQueryExpansionValueSetId = (String) valueSetIds.get("RXNORM_QUERY_EXPANSION_TERM_TYPE_CODES");
        List<ValueSetCode> valueSet = responderValueSetDao.getValueSetCodes(new BigDecimal(rxNormQueryExpansionValueSetId));

        for (ValueSetCode termType : valueSet) {
            rxNormQueryExpansionTermTypes.add(termType.getCode());
        }

        return rxNormQueryExpansionTermTypes;

    }

    @Override
    public Map<String, Map<String, String>> getIndexPropertyInterpretationMap(Collection<RequestParameter> requestParameters) {

        if (requestParameterCodeMap != null) { // if already built, don't need to rebuild; static
            return requestParameterCodeMap;
        }

        requestParameterCodeMap = new HashMap<>();

        String lastParameterRoot = null;
        Map<String, String> parameterMap = new HashMap<>();

        for (RequestParameter requestParameter : requestParameters) {

            if (isIncompleteRequestParameter(requestParameter)) {
                throw new IncompleteArgumentException("Supported request parameters must have a parameterName, parameterRoot, and typeCode. "
                        + "Invalid parameter id = " + requestParameter.getRequestParameterId());
            }

            if (lastParameterRoot != null && !lastParameterRoot.equals(requestParameter.getParameterRoot())) {

                requestParameterCodeMap.put(lastParameterRoot, parameterMap);
                parameterMap = new HashMap<>();

            }

            parameterMap.put(requestParameter.getTypeCode(), requestParameter.getParameterName());
            lastParameterRoot = requestParameter.getParameterRoot();

        }

        requestParameterCodeMap.put(lastParameterRoot, parameterMap);

        return requestParameterCodeMap;
    }

    private boolean isIncompleteRequestParameter(RequestParameter requestParameter) {
        if (requestParameter.getParameterName() == null || "".equals(requestParameter.getParameterName())
                && requestParameter.getParameterRoot() == null || "".equals(requestParameter.getParameterRoot())
                && requestParameter.getTypeCode() == null || "".equals(requestParameter.getTypeCode())) {

            return true;

        }
        return false;
    }

    @Override
    @Transactional
    public Map<String, Map<String, String>> getIndexPropertyInterpretationMap() {

        if (requestParameterCodeMap != null) { // if already built, don't need to rebuild; static
            return requestParameterCodeMap;
        }

        Collection<RequestParameter> requestParameters = responderRequestParameterDao.getSupportedOpenInfobuttonRequestParametersOrdered();

        return getIndexPropertyInterpretationMap(requestParameters);

    }

    @Override
    public Map<String, String> getKnowledgeRequestParameterMap(Map httpRequestParameters) {

        Map<String, String> requestParameters = new HashMap<>();

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

        return requestParameters;
    }

    @Override
    @Transactional
    public boolean requestContainsRequiredParameters(Map<String, String> requestParameters) throws MissingServletRequestParameterException {

        StringBuilder errorMessage = new StringBuilder();

        Collection<RequestParameter> requiredRequestParmeters = responderRequestParameterDao.getRequiredOpenInfobuttonRequestParameters();

        int i = 0;
        for (RequestParameter requiredRequestParmeter : requiredRequestParmeters) {
            if (!requestParameters.containsKey(requiredRequestParmeter.getParameterName())) {
                if (i > 1) {
                    errorMessage.append(", ");
                }
                errorMessage.append(requiredRequestParmeter.getParameterName());
                i++;
            }
        }

        if (errorMessage.length() > 0) {

            String messagePrefix = null;
            String messageSuffix = null;

            if (i > 1) {
                messagePrefix = " are";
                messageSuffix = "s.";
            } else {
                messagePrefix = " is a";
                messageSuffix = ".";
            }

            throw new MissingServletRequestParameterException(errorMessage.toString(), messagePrefix + " required request parameter" + messageSuffix);
        }

        return true;

    }

    @Override
    @Transactional
    public Properties getApplicationProperties(String propertyGroup) {

        if (appProperties != null) { // only retrieve from the db and configure once
            return appProperties;
        }

        appProperties = new Properties();

        Collection<AppProperty> appPropertyCollection = responderAppPropertyDao.getAppPropertyGroup(propertyGroup);

        for (AppProperty appProperty : appPropertyCollection) {
            appProperties.put(appProperty.getPropertyName(), appProperty.getPropertyValue());
        }

        return appProperties;

    }

    @Override
    @Transactional
    public Collection<Asset> findAssetsByInfobuttonRequest(Map<String, String> requestParameters) {

        return responderAssetDao.findByInfobuttonRequest(requestParameters);

    }

}
