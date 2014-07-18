package org.openinfobutton.responder.dao.impl;

import java.util.Collection;
import java.util.List;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.RequestParameter;
import org.openinfobutton.responder.dao.ResponderRequestParameterDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rick
 */
@Repository
public class ResponderRequestParameterDaoImpl extends DaoBase<RequestParameter> implements ResponderRequestParameterDao {
    
    List<RequestParameter> supportedOpenInfobuttonRequestParameters = null;

    @Override
    public Collection<RequestParameter> getRequiredOpenInfobuttonRequestParameters() {
        return this.getOpenInfobuttonRequestParametersByMinCardinality(1);
    }
    
    @Override
    public void setAllOpenInfobuttonRequestParameters(List<RequestParameter> supportedOpenInfobuttonRequestParameters) {
        this.supportedOpenInfobuttonRequestParameters = supportedOpenInfobuttonRequestParameters;
    }

    @Override
    public List<RequestParameter> getSupportedOpenInfobuttonRequestParametersOrdered() {

        if (supportedOpenInfobuttonRequestParameters == null) {
            supportedOpenInfobuttonRequestParameters = getSessionFactory()
                    .getCurrentSession()
                    .createCriteria(RequestParameter.class)
                    .add( Restrictions.isNotNull("parameterRoot") )
                    .add( Restrictions.isNotNull("parameterName") )
                    .add( Restrictions.isNotNull("typeCode") )
                    .addOrder(Order.asc("parameterName"))
                    .list();
        }
        
        return supportedOpenInfobuttonRequestParameters;
    }

    @Override
    public Collection<RequestParameter> getOpenInfobuttonRequestParametersByMinCardinality(int minCardinality) {
        return getSessionFactory()
                .getCurrentSession()
                .createCriteria(RequestParameter.class)
                .add(Restrictions.eq("cardinalityMin", new Long(minCardinality)))
                .list();
    }

    @Override
    public RequestParameter getOpenInfobuttonRequestParameterByName(String paramaterName) {

        RequestParameter requestParameterExample = new RequestParameter();
        requestParameterExample.setParameterName(paramaterName);

        return (RequestParameter) getSessionFactory()
                .getCurrentSession()
                .createCriteria(RequestParameter.class)
                .add(Example.create(requestParameterExample))
                .list()
                .get(0);

    }

}
