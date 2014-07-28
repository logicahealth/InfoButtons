package org.openinfobutton.responder.service;

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
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.RequestParameter;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 *
 * @author rick
 */
public interface ResponderService {

    /**
     *
     * @return
     */
    Set<String> getRxNormQueryExpansionTermTypes();

    /**
     *
     * @param httpRequestParameters
     * @return
     */
    Map<String, String> getKnowledgeRequestParameterMap(Map httpRequestParameters);

    /**
     *
     * @return
     */
    Map<String, Map<String, String>> getIndexPropertyInterpretationMap();

    /**
     *
     * @param requestParameters
     * @return
     */
    Collection<Asset> findAssetsByInfobuttonRequest(Map<String, String> requestParameters);

    /**
     *
     * @param propertyGroup
     * @return
     */
    Properties getApplicationProperties(String propertyGroup);

    /**
     *
     * @param requestParameters
     * @return
     * @throws MissingServletRequestParameterException
     */
    boolean requestContainsRequiredParameters(Map<String, String> requestParameters) throws MissingServletRequestParameterException;

    /**
     *
     * @param requestParameters
     * @return
     */
    Map<String, Map<String, String>> getIndexPropertyInterpretationMap(Collection<RequestParameter> requestParameters);

}
