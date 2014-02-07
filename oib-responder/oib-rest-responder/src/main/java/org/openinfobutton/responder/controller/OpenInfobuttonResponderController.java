package org.openinfobutton.responder.controller;

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
 * @author rick
 */
@Controller
public class OpenInfobuttonResponderController {

    public static final String INDEX_PAGE = "index";
    public static final String ATOM_PAGE = "searchResultsAtom";
    public static final String HTML_PAGE = "searchResultsHtml";
    public static final String ATOM_FEED_KEY = "atom.feed";
    
    @Autowired
    private ResponderService responderService;
    
    private Properties atomFeedMetadata;
    private Map<String, Map<String, String>> indexPropertyInterpretationMap;
    
    public void setResponderService(ResponderService responderService) {
        this.responderService = responderService;
    }

    public void setAtomFeedMetadata(Properties atomFeedMetadata) {
        this.atomFeedMetadata = atomFeedMetadata;
    }

    public void setIndexPropertyInterpretationMap(Map<String, Map<String, String>> indexPropertyInterpretationMap) {
        this.indexPropertyInterpretationMap = indexPropertyInterpretationMap;
    }

    private void setRequiredResponseObjects(){

        if ( this.atomFeedMetadata == null ) {
            this.atomFeedMetadata = responderService.getApplicationProperties( ATOM_FEED_KEY );
        }
        if ( this.indexPropertyInterpretationMap == null ) {
            this.indexPropertyInterpretationMap = responderService.getIndexPropertyInterpretationMap();
        }

    }

    @RequestMapping("/")
    public String indexPageRequest() {
        return INDEX_PAGE;
    }

    @RequestMapping("/responder")
    public String openInfobuttonRequestHandler(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws MissingServletRequestParameterException, HttpMediaTypeNotSupportedException, IllegalArgumentException {

        response.setHeader("Cache-Control", "no-cache");
        // todo: authorization - return 401 when not authorized
        
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

    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE, 
            reason = "Requested knowedgeResourceType not supported.")
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public void handleHttpMediaTypeNotSupportedException() {
        // logic handled by annotations
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, 
            reason = "Missing required parameter(s): mainSearchCriteria.v.c, mainSearchCriteria.v.cs, or taskContext.c.c")  // 400
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingServletRequestParameterException() {
        // logic handled by annotations
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal argument: each parameter name must be distict.  "
            + "Parameters that support cardinality greater than 1 require distinct trailing numeric values.")  // 400
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException() {
        // logic handled by annotations
    }
    
}
