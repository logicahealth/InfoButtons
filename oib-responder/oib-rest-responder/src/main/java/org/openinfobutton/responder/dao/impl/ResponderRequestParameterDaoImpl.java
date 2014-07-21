package org.openinfobutton.responder.dao.impl;

/*
 * #%L
 * Project:  oib-rest-responder
 * Director: Guilherme Del Fiol, MD, PhD
 *           University of Utah
 *           Biomedical Informatics
 *           421 Wakara Way, Suite 140
 *           Salt Lake City, UT 84108-3514
 * Phone:    801-581-4080
 * %%
 * Copyright (C) 2010 - 2014 University of Utah
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
 * @author Rick Bradshaw
 */
@Repository
public class ResponderRequestParameterDaoImpl extends DaoBase<RequestParameter> implements ResponderRequestParameterDao {

    List<RequestParameter> supportedOpenInfobuttonRequestParameters = null;

    /**
     *
     * @return
     */
    @Override
    public Collection<RequestParameter> getRequiredOpenInfobuttonRequestParameters() {
        return this.getOpenInfobuttonRequestParametersByMinCardinality(1);
    }

    /**
     *
     * @param supportedOpenInfobuttonRequestParameters
     */
    @Override
    public void setAllOpenInfobuttonRequestParameters(List<RequestParameter> supportedOpenInfobuttonRequestParameters) {
        this.supportedOpenInfobuttonRequestParameters = supportedOpenInfobuttonRequestParameters;
    }

    /**
     *
     * @return
     */
    @Override
    public List<RequestParameter> getSupportedOpenInfobuttonRequestParametersOrdered() {

        if (supportedOpenInfobuttonRequestParameters == null) {
            supportedOpenInfobuttonRequestParameters = getSessionFactory()
                    .getCurrentSession()
                    .createCriteria(RequestParameter.class)
                    .add(Restrictions.isNotNull("parameterRoot"))
                    .add(Restrictions.isNotNull("parameterName"))
                    .add(Restrictions.isNotNull("typeCode"))
                    .addOrder(Order.asc("parameterName"))
                    .list();
        }

        return supportedOpenInfobuttonRequestParameters;
    }

    /**
     *
     * @param minCardinality
     * @return
     */
    @Override
    public Collection<RequestParameter> getOpenInfobuttonRequestParametersByMinCardinality(int minCardinality) {
        return getSessionFactory()
                .getCurrentSession()
                .createCriteria(RequestParameter.class)
                .add(Restrictions.eq("cardinalityMin", new Long(minCardinality)))
                .list();
    }

    /**
     *
     * @param paramaterName
     * @return
     */
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
