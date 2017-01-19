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
package org.openinfobutton.service.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Access;
import javax.xml.datatype.DatatypeConfigurationException;

import org.hl7.v3.AggregateKnowledgeResponse;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.service.matching.AccessCheckHandler;
import org.openinfobutton.service.matching.ContextProfileHandler;
import org.openinfobutton.service.matching.RequestResult;
import org.openinfobutton.service.matching.TaskCheckHandler;
import org.openinfobutton.service.response.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class KnowledgeRequestEngine.
 */
@Component
public class KnowledgeRequestEngine
{

    ResponseGenerator rg;

    /**The Context Profile Handler**
     *
     */
    @Autowired
    ContextProfileHandler contextProfileHandler;

    /**
     * Gets the response.
     *
     * @param knowledgeRequest built from the input request parameters
     * @return Document which contains the aggregateKnowledgeResponse after processing the infobutton request
     */
    public AggregateKnowledgeResponse getResponse( KnowledgeRequest knowledgeRequest )
    {
        final List<RequestResult> result = returnResult( knowledgeRequest );
        Collections.sort( result );
        AggregateKnowledgeResponse responseType = new AggregateKnowledgeResponse();
        rg = new ResponseGenerator();
        try
        {
            if ( !result.isEmpty() )
            {
                responseType = rg.returnResponse( knowledgeRequest, result );
            }
        }
        catch ( final DatatypeConfigurationException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return responseType;
    }

    /**
     * Based on the knowledge Request, access and task checks are done. Then based on the qualified resource profiles,
     * matching is done to produce the results.
     *
     * @param request the request
     * @return List of Results
     */
    private List<RequestResult> returnResult( KnowledgeRequest request )
    {
        List<RequestResult> result = new ArrayList<RequestResult>();
        AccessCheckHandler accessChecker = new AccessCheckHandler();
        if ( accessChecker.handleRequest( request ) )
        {
            return result;
        }
        else if ( TaskCheckHandler.handleRequest( request ) )
        {
            return result;
        }
        else
        {
            result = contextProfileHandler.handleRequest( request );
            return result;
        }
    }
}
