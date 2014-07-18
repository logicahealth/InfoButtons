package org.openinfobutton.responder.dao;

import java.util.Collection;
import java.util.List;
import org.openinfobutton.app.dao.RequestParameterDaoI;
import org.openinfobutton.app.model.RequestParameter;

/**
 *
 * @author rick
 */
public interface ResponderRequestParameterDao extends RequestParameterDaoI {
 
    void setAllOpenInfobuttonRequestParameters(List<RequestParameter> allOpenInfobuttonRequestParameters);

    List<RequestParameter> getSupportedOpenInfobuttonRequestParametersOrdered();

    Collection<RequestParameter> getOpenInfobuttonRequestParametersByMinCardinality( int minCardinality );

    Collection<RequestParameter> getRequiredOpenInfobuttonRequestParameters();

    RequestParameter getOpenInfobuttonRequestParameterByName( String paramaterName);

}
