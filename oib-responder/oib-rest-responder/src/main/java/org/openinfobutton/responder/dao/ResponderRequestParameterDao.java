package org.openinfobutton.responder.dao;

import java.util.Collection;
import java.util.List;
import org.openinfobutton.app.dao.IRequestParameterDao;
import org.openinfobutton.app.model.RequestParameter;

/**
 *
 * @author rick
 */
public interface ResponderRequestParameterDao extends IRequestParameterDao {
 
    void setAllOpenInfobuttonRequestParameters(List<RequestParameter> allOpenInfobuttonRequestParameters);

    List<RequestParameter> getSupportedOpenInfobuttonRequestParametersOrdered();

    Collection<RequestParameter> getOpenInfobuttonRequestParametersByMinCardinality( int minCardinality, String version );
    
    RequestParameter getOpenInfobuttonRequestParameterByName( String paramaterName);

}
