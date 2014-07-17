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

// TODO: Auto-generated Javadoc
/**
 * The Class ResponderServiceImpl.
 *
 * @author rick
 */
@Service
public class ResponderServiceImpl
    implements ResponderService
{

    // private static final Logger log = Logger.getLogger(ResponderServiceImpl.class);

    /** The responder request parameter dao. */
    @Autowired
    private ResponderRequestParameterDao responderRequestParameterDao;

    /** The responder asset dao. */
    @Autowired
    private ResponderAssetDao responderAssetDao;

    /** The responder value set dao. */
    @Autowired
    private ResponderValueSetDao responderValueSetDao;

    /** The responder app property dao. */
    @Autowired
    private ResponderAppPropertyDao responderAppPropertyDao;

    /** The request parameter code map. */
    private Map<String, Map<String, String>> requestParameterCodeMap;

    /** The app properties. */
    private Properties appProperties;

    /** The rx norm query expansion term types. */
    private Set<String> rxNormQueryExpansionTermTypes;

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.service.ResponderService#getRxNormQueryExpansionTermTypes()
     */
    @Override
    @Transactional
    public Set<String> getRxNormQueryExpansionTermTypes()
    { // TODO this could be moved to the query implementation

        if ( rxNormQueryExpansionTermTypes == null )
        {
            return rxNormQueryExpansionTermTypes;
        }

        rxNormQueryExpansionTermTypes = new HashSet<String>();

        final Properties valueSetIds = getApplicationProperties( "app.valueset.id" );
        final String rxNormQueryExpansionValueSetId =
            (String) valueSetIds.get( "RXNORM_QUERY_EXPANSION_TERM_TYPE_CODES" );
        final List<ValueSetCode> valueSet =
            responderValueSetDao.getValueSetCodes( new BigDecimal( rxNormQueryExpansionValueSetId ) );

        for ( final ValueSetCode termType : valueSet )
        {
            rxNormQueryExpansionTermTypes.add( termType.getCode() );
        }

        return rxNormQueryExpansionTermTypes;

    }

    /**
     * Gets the index property interpretation map.
     *
     * @param requestParameters the request parameters
     * @return the index property interpretation map
     */
    public Map<String, Map<String, String>> getIndexPropertyInterpretationMap( Collection<RequestParameter> requestParameters )
    {

        if ( requestParameterCodeMap != null )
        { // if already built, don't need to rebuild; static
            return requestParameterCodeMap;
        }

        requestParameterCodeMap = new HashMap<String, Map<String, String>>();

        String lastParameterRoot = null;
        Map<String, String> parameterMap = new HashMap<String, String>();

        for ( final RequestParameter requestParameter : requestParameters )
        {

            if ( requestParameter.getParameterName() == null || "".equals( requestParameter.getParameterName() )
                && requestParameter.getParameterRoot() == null || "".equals( requestParameter.getParameterRoot() )
                && requestParameter.getTypeCode() == null || "".equals( requestParameter.getTypeCode() ) )
            {

                System.out.println( "Supported request parameters must have a parameterName, parameterRoot, and typeCode. "
                    + "Invalid parameter id = " + requestParameter.getRequestParameterId() );
            }

            if ( lastParameterRoot != null && !lastParameterRoot.equals( requestParameter.getParameterRoot() ) )
            {

                requestParameterCodeMap.put( lastParameterRoot, parameterMap );
                parameterMap = new HashMap<String, String>();

            }

            parameterMap.put( requestParameter.getTypeCode(), requestParameter.getParameterName() );
            lastParameterRoot = requestParameter.getParameterRoot();

        }

        requestParameterCodeMap.put( lastParameterRoot, parameterMap );

        return requestParameterCodeMap;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.service.ResponderService#getIndexPropertyInterpretationMap()
     */
    @Override
    @Transactional
    public Map<String, Map<String, String>> getIndexPropertyInterpretationMap()
    {

        if ( requestParameterCodeMap != null )
        { // if already built, don't need to rebuild; static
            return requestParameterCodeMap;
        }

        final Collection<RequestParameter> requestParameters =
            responderRequestParameterDao.getSupportedOpenInfobuttonRequestParametersOrdered();

        return getIndexPropertyInterpretationMap( requestParameters );

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.service.ResponderService#getKnowledgeRequestParameterMap(java.util.Map)
     */
    @Override
    public Map<String, String> getKnowledgeRequestParameterMap( Map httpRequestParameters )
    {

        final Map<String, String> requestParameters = new HashMap<String, String>();

        for ( final Object parameterName : httpRequestParameters.keySet() )
        {

            final String parameterNameString = (String) parameterName;
            final String[] parameterValues = (String[]) httpRequestParameters.get( parameterNameString );

            int i = 0;
            for ( final String parameterValue : parameterValues )
            { // multiple parameters with the same name are not supported by the specification

                if ( i == 0 )
                {
                    requestParameters.put( parameterNameString, parameterValue );
                }
                else
                {
                    throw new IllegalArgumentException( 
                             "Invalid request argument: there are mutiple values for " + parameterNameString
                              + ". Parameters that support multple values require an index number appended " +
                              "to the end of the parameter name."
                              + " Example: Two values for 'mainSearchCriteria.c.c' " +
                              "requires a second parameter 'mainsearchCriteria.c.c1'." );
                }
                i++;
            }

        }

        return requestParameters;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.service.ResponderService#requestContainsRequiredParameters(java.util.Map)
     */
    @Override
    @Transactional
    public boolean requestContainsRequiredParameters( Map<String, String> requestParameters )
        throws MissingServletRequestParameterException
    {

        final StringBuffer errorMessage = new StringBuffer();

        final Collection<RequestParameter> requiredRequestParmeters =
            responderRequestParameterDao.getRequiredOpenInfobuttonRequestParameters();

        int i = 0;
        for ( final RequestParameter requiredRequestParmeter : requiredRequestParmeters )
        {
            if ( !requestParameters.containsKey( requiredRequestParmeter.getParameterName() ) )
            {
                if ( i > 1 )
                {
                    errorMessage.append( ", " );
                }
                errorMessage.append( requiredRequestParmeter.getParameterName() );
                i++;
            }
        }

        if ( errorMessage.length() > 0 )
        {

            String messagePrefix = null;
            String messageSuffix = null;
            if ( i > 1 )
            {
                messagePrefix = " are";
                messageSuffix = "s.";
            }
            else
            {
                messagePrefix = " is a";
                messageSuffix = ".";
            }

            throw new MissingServletRequestParameterException( errorMessage.toString(), messagePrefix
                + " required request parameter" + messageSuffix );
        }

        return true;

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.service.ResponderService#getApplicationProperties(java.lang.String)
     */
    @Override
    @Transactional
    public Properties getApplicationProperties( String propertyGroup )
    {

        if ( appProperties != null )
        { // only retrieve from the db and configure once when empty, doesn't change
            return appProperties;
        }

        appProperties = new Properties();

        final Collection<AppProperty> appPropertyCollection =
            responderAppPropertyDao.getAppPropertyGroup( propertyGroup );

        for ( final AppProperty appProperty : appPropertyCollection )
        {
            appProperties.put( appProperty.getPropertyName(), appProperty.getPropertyValue() );
        }

        return appProperties;

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.service.ResponderService#findAssetsByInfobuttonRequest(java.util.Map)
     */
    @Override
    @Transactional
    public Collection<Asset> findAssetsByInfobuttonRequest( Map<String, String> requestParameters )
    {

        return responderAssetDao.findByInfobuttonRequest( requestParameters );

    }

}
