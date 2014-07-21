package org.openinfobutton.responder.controller;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.responder.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Rick Bradshaw
 */
@Controller
public class OpenInfobuttonResponderController {

    /**
     * Name of the index page returned when requested - public for test
     * utilization
     */
    public static final String INDEX_PAGE = "index";

    /**
     * Name of the atom page returned when atom-based search results are
     * requested - public for test utilization
     */
    public static final String ATOM_PAGE = "searchResultsAtom";

    /**
     * Name of the html page returned when html-based search results are
     * requested - public for test utilization
     */
    public static final String HTML_PAGE = "searchResultsHtml";

    /**
     * The property key for atom feed properties
     */
    public static final String ATOM_FEED_KEY = "atom.feed";

    @Autowired
    private ResponderService responderService;

    private Properties atomFeedMetadata;
    private Map<String, Map<String, String>> indexPropertyInterpretationMap;

    /**
     *
     * @param responderService
     */
    public void setResponderService(ResponderService responderService) {
        this.responderService = responderService;
    }

    /**
     *
     * @param atomFeedMetadata
     */
    public void setAtomFeedMetadata(Properties atomFeedMetadata) {
        this.atomFeedMetadata = atomFeedMetadata;
    }

    /**
     *
     * @param indexPropertyInterpretationMap
     */
    public void setIndexPropertyInterpretationMap(final Map<String, Map<String, String>> indexPropertyInterpretationMap) {
        this.indexPropertyInterpretationMap = indexPropertyInterpretationMap;
    }

    private void setRequiredResponseObjects() {

        if (this.atomFeedMetadata == null) {
            this.atomFeedMetadata = responderService.getApplicationProperties(ATOM_FEED_KEY);
        }
        if (this.indexPropertyInterpretationMap == null) {
            this.indexPropertyInterpretationMap = responderService.getIndexPropertyInterpretationMap();
        }

    }

    /**
     *
     * @return
     */
    @RequestMapping("/")
    public String indexPageRequest() {
        return INDEX_PAGE;
    }

    /**
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws MissingServletRequestParameterException
     * @throws HttpMediaTypeNotSupportedException
     * @throws IllegalArgumentException
     */
    @RequestMapping("/responder")
    public String openInfobuttonRequestHandler(final HttpServletRequest request, final HttpServletResponse response, final ModelMap model)
            throws MissingServletRequestParameterException, HttpMediaTypeNotSupportedException, IllegalArgumentException {

        response.setHeader("Cache-Control", "no-cache");
        // todo: if authorization is required return 401 when not authorized

        setRequiredResponseObjects();

        // throws IllegalArgumentException
        Map<String, String> requestParameters = responderService.getKnowledgeRequestParameterMap(request.getParameterMap());

        // throws MissingServletRequestParameterException
        responderService.requestContainsRequiredParameters(requestParameters);
        Collection<Asset> matchedAssets = responderService.findAssetsByInfobuttonRequest(requestParameters);

        model.addAttribute("atomFeedMetadata", this.atomFeedMetadata);
        model.addAttribute("indexPropertyInterpretationMap", this.indexPropertyInterpretationMap);
        model.addAttribute("requestParameters", requestParameters);
        model.addAttribute("assets", matchedAssets);

        String viewType = requestParameters.get("knowledgeResponseType");

        if (viewType == null) { // default
            return ATOM_PAGE;
        } else if ("text/html".equals(viewType)) {
            return HTML_PAGE;
        } else if ("text/xml".equals(viewType)) {
            return ATOM_PAGE;
        } else {
            throw new HttpMediaTypeNotSupportedException("Unsupported knowledgeResponseType: " + viewType);
        }

    }

    /**
     * Handles HttpMediaTypeNotSupportedException via Spring's exception handler
     * annotation strategy
     */
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE,
            reason = "Requested knowedgeResourceType not supported.")
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public void handleHttpMediaTypeNotSupportedException() {
        // logic handled by annotations
    }

    /**
     * Handles MissingServletRequestParameterException via Spring's exception
     * handler annotation strategy
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Missing required parameter(s): mainSearchCriteria.v.c, mainSearchCriteria.v.cs, or taskContext.c.c")  // 400
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingServletRequestParameterException() {
        // logic handled by annotations
    }

    /**
     * Handles IllegalArgumentException via Spring's exception handler
     * annotation strategy
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal argument: each parameter name must be distict.  "
            + "Parameters that support cardinality greater than 1 require distinct trailing numeric values.")  // 400
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException() {
        // logic handled by annotations
    }

}
