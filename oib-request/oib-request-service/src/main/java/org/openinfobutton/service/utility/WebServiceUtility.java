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
package org.openinfobutton.service.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.v3.CategoryType;
import org.openinfobutton.schema.CodeConstants;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Code;

/**
 * The Class WebServiceUtility.
 */
public final class WebServiceUtility
{
    
    /**
     * Instantiates a new web service utility.
     */
    private WebServiceUtility(){}
    
    /**
     * Gets the service request.
     *
     * @param requestParameters The parameters that were passed in the infobutton request
     * @return KnowledgeRequest which holds the passed request parameters in a well defined format of
     *         CodedContextElements
     */
    public static KnowledgeRequest getServiceRequest( Map<String, String[]> requestParameters )
    {
        
        Date effectiveTime = new Date();
        String executionMode = new String();
        final Map<String, List<CategoryType>> categoryHashMap = new HashMap<String, List<CategoryType>>();
        // Set time
        final SimpleDateFormat formatter = new SimpleDateFormat( "yyyymmddhhmmss" );
        if ( requestParameters.containsKey( CodeConstants.EFFECTIVE_TIME ) )
        {

            try
            {
                effectiveTime = formatter.parse( requestParameters.get( CodeConstants.EFFECTIVE_TIME )[0] );
            }
            catch ( final ParseException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        final KnowledgeRequest knowledgeRequest =  new KnowledgeRequest(requestParameters, categoryHashMap);
        Code ageGroup = knowledgeRequest.getPatientContext().getPatient().getAgeGroup();
        List<CategoryType> category = new ArrayList<CategoryType>();
        if ( !ageGroup.getCode().equals( "" ) )
        {
            category = new ArrayList<CategoryType>();
            CategoryType c = new CategoryType();
            c.setScheme( CodeConstants.AGEGROUP_CODE );
            c.setTerm( ageGroup.getCode() );
            category.add( c );
            c = new CategoryType();
            c.setScheme( CodeConstants.AGEGROUP_CODESYSTEM );
            c.setTerm( ageGroup.getCodeSystem() );
            category.add( c );
            categoryHashMap.put( CodeConstants.PATIENT_AGEGROUP_KEY, category );
        }
        knowledgeRequest.setCategoryHashMap( categoryHashMap );
        return knowledgeRequest;
    }
}
