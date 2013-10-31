package org.openinfobutton.responder.controller;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.responder.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rick
 */

@Controller
public class OpenInfobuttonResponderController {

    @Autowired
    private ResponderService responderService;
    
    @RequestMapping("/")
    public String indexPageRequest(ModelMap model, HttpServletRequest request){
        return "index";
    }
    
    //@RequestMapping(method = RequestMethod.GET)
    @RequestMapping("/responder")
    public String openInfobuttonRequestHandler(HttpServletRequest request, ModelMap model) 
                throws MissingServletRequestParameterException {
        
        Properties atomFeedMetadata = responderService.getAppProperties( "atom.feed" );
        Map<String,Map<String,String>> requestParameterTypeMap = responderService.getRequestParameterDbMap();
        Map<String,String> requestParameters = responderService.getFlatRequestMapFromHttpRequestParameterMap( request.getParameterMap() );
        Collection<Asset> matchedAssets = responderService.findAssetsByInfobuttonRequest( requestParameters );
                
        model.addAttribute("atomFeedMetadata", atomFeedMetadata);
        model.addAttribute("requestParameterTypeMap", requestParameterTypeMap);
        model.addAttribute("requestParameters", requestParameters);
        model.addAttribute("assets", matchedAssets);
        
        String viewType = requestParameters.get("knowledgeResponseType");
        
        if ( "text/html".equals(viewType) ) {
            return "searchResultsHtml";
        }
        
        return "searchResultsAtom";

    }

    
}
