package org.openinfobutton.responder.dao;

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
import org.openinfobutton.app.dao.RequestParameterDaoI;
import org.openinfobutton.app.model.RequestParameter;

/**
 *
 * @author Rick Bradshaw
 */
public interface ResponderRequestParameterDao extends RequestParameterDaoI {

    /**
     *
     * @param allOpenInfobuttonRequestParameters
     */
    void setAllOpenInfobuttonRequestParameters(List<RequestParameter> allOpenInfobuttonRequestParameters);

    /**
     *
     * @return
     */
    List<RequestParameter> getSupportedOpenInfobuttonRequestParametersOrdered();

    /**
     *
     * @param minCardinality
     * @return
     */
    Collection<RequestParameter> getOpenInfobuttonRequestParametersByMinCardinality(int minCardinality);

    /**
     *
     * @return
     */
    Collection<RequestParameter> getRequiredOpenInfobuttonRequestParameters();

    /**
     *
     * @param paramaterName
     * @return
     */
    RequestParameter getOpenInfobuttonRequestParameterByName(String paramaterName);

}
