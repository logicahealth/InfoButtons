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
package org.openinfobutton.externalresource.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openinfobutton.externalresource.json.AtomSearchResult;
import org.openinfobutton.externalresource.json.CodeTransformer;
import org.openinfobutton.externalresource.json.CodeTransformerResultList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openinfobutton.externalresource.json.SourceAtomCluster;
import org.openinfobutton.rest.terminology.api.RestTermClient;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schemas.kb.Code;
import org.springframework.beans.factory.annotation.Autowired;

import org.openinfobutton.externalresource.api.ExternalResourceHandler;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * The Class UTSHandler.
 */
@Service
public class UTSHandler
    implements ExternalResourceHandler
{

    /** The log. */
    Logger log = LogManager.getLogger( UTSHandler.class.getName() );


    @Autowired
    RestTermClient umlsRestClient;

    public UTSHandler() {

    }

    /*
     * (non-Javadoc)
     * @see ExternalResourceHandler#transformCode(org.openinfobutton.schemas.kb.Code, java.lang.String)
     */
    @Override
    public Code transformCode( Code code, String targetCS )
    {
        final org.apache.logging.log4j.Logger logger = LogManager.getLogger(UTSHandler.class);
        logger.error("BEGIN TRANSFORM CODE");
        Code retCode = new Code();

        logger.error("CODE: " + code.getCode());
        logger.error("DISPLAY NAME: " + code.getCodeSystemName());

        String tempCode = "ICD9CM";
        String tempDiab = "250.0";
        String results = "";
        try {
             results = umlsRestClient.getCodes(code.getCode(), code.getCodeSystemName());
        }
        catch(Exception e) {
            e.printStackTrace();
            return code;
        }


        logger.error(results);

        ObjectMapper mapper = new ObjectMapper();
        CodeTransformer codeTransformer = new CodeTransformer();

        try {
            codeTransformer  = mapper.readValue(results, CodeTransformer.class);
        } catch (IOException e) {
            e.printStackTrace();
            return code;
        }

        List<CodeTransformerResultList> temp = new ArrayList<CodeTransformerResultList>(codeTransformer.getResult().getResults());

        String ui = "";
        int index = 0;
        for(index = 0; index < temp.size(); index++) {
            ui = temp.get(index).getUi();
            log.error( ui );
            break;
        }
        String codeResult = "";
        List<String> elephantList = new ArrayList<String>();
        try {
            if(targetCS == "ICD10CM") {
                targetCS = "ICD10AM";
            }
            String results2 = umlsRestClient.getCodes(ui, targetCS, temp.get(index).getName());
            logger.error(results2);

            elephantList = Arrays.asList(results2.split(","));
            for (int i = 0; i < elephantList.size(); i++) {
                logger.error(elephantList.get(i));
                codeResult = elephantList.get(i);
                if (codeResult.startsWith("\"results\"")) {
                    break;
                }
            }

            elephantList = Arrays.asList(codeResult.split(":"));
            codeResult = elephantList.get((elephantList.size() - 1));
            codeResult = codeResult.replaceAll("^\"|\"$", "");

        }

        catch (Exception e) {
            e.printStackTrace();
            return code;
        }

        retCode.setCode(codeResult);
        retCode.setCodeSystemName(targetCS);

        return retCode;
    }

    /*
     * (non-Javadoc)
     * @see ExternalResourceHandler#transformFreeText(java.lang.String)
     */
    @Override
    public ArrayList<Code> transformFreeText( String FreeText )
    {
        log.debug( "Got Free text: " + FreeText );
        final ArrayList<Code> searchCodes = new ArrayList<Code>();
        String results;

        try {
             results = umlsRestClient.getTerms(FreeText, "SNOMEDCT_US, ICD10CM, ICD9CM, RXNORM, ICD10, MSH, LNC, CPT");
        } catch (Exception e)
        {
            e.printStackTrace();
            return searchCodes;
        }

        ObjectMapper mapper = new ObjectMapper();
        CodeTransformer codeTransformer = new CodeTransformer();

        try {
           codeTransformer  = mapper.readValue(results, CodeTransformer.class);
        } catch (IOException e) {
            e.printStackTrace();
            return searchCodes;
        }

        List<CodeTransformerResultList> temp =
                new ArrayList<CodeTransformerResultList>(codeTransformer.getResult().getResults());

        if (!temp.get(0).getUi().equals("NONE")) {
            for (int i = 0; i < temp.size(); i++) {

                final String ui = temp.get(i).getUi();
                final String label = temp.get(i).getName();
                final String source = temp.get(i).getRootSource();
                final Code c = CodeUtility.getCode(ui, getCodeSystemId(source), label, source);
                log.debug(ui + " " + label + " " + source);
                searchCodes.add(c);
            }
        }

        return searchCodes;
    }

    /**
     * Gets the code system id.
     *
     * @param source the source
     * @return the code system id
     */
    private String getCodeSystemId( String source )
    {
        if ( source.equals( "SNOMEDCT_US" ) )
        {
            return "2.16.840.1.113883.6.96";
        }
        else if ( source.equals( "ICD10CM" ) )
        {
            return "2.16.840.1.113883.6.90";
        }
        else if ( source.equals( "ICD9CM" ) )
        {
            return "2.16.840.1.113883.6.103";
        }
        else if ( source.equals( "ICD10" ) )
        {
            return "2.16.840.1.113883.6.3";
        }
        else if ( source.equals( "RXNORM" ) )
        {
            return "2.16.840.1.113883.6.88";
        }
        else if ( source.equals( "MSH" ) )
        {
            return "2.16.840.1.113883.6.177";
        }
        else if ( source.equals( "LNC" ) )
        {
            return "2.16.840.1.113883.6.1";
        }
        else if ( source.equals( "CPT" ) )
        {
            return "2.16.840.1.113883.6.12";
        }


        return "";
    }

    /**
     * Gets the code system name from id.
     *
     * @param source the source
     * @return the code system name from id
     */
    private String getCodeSystemNameFromId( String source )
    {
        if ( source.equals( "2.16.840.1.113883.6.96" ) )
        {
            return "SNOMEDCT_US";
        }
        else if ( source.equals( "2.16.840.1.113883.6.90" ) )
        {
            return "ICD10CM";
        }
        else if ( source.equals( "2.16.840.1.113883.6.103" ) )
        {
            return "ICD9CM";
        }

        else if ( source.equals( "2.16.840.1.113883.6.3" ) )
        {
            return "ICD10";
        }
        else if ( source.equals( "2.16.840.1.113883.6.88" ) )
        {
            return "RXNORM";
        }
        else if ( source.equals( "2.16.840.1.113883.6.177" ) )
        {
            return "MSH";
        }
        else if ( source.equals( "2.16.840.1.113883.6.1" ) )
        {
            return "LNC";
        }
        else if ( source.equals( "2.16.840.1.113883.6.12" ) )
        {
            return "CPT";
        }
        return "";
    }

    /*
     * (non-Javadoc)
     * @see ExternalResourceHandler#isDescendant(org.openinfobutton.schemas.kb.Code, org.openinfobutton.schemas.kb.Code)
     */
    @Override
    public boolean isDescendant( Code code1, Code code2 )
    {
        if ( !( code1.getCodeSystem().equals( code2.getCodeSystem() ) ) )
        {
            return false;
        }

        return descendantCheck( code1, code2.getCode(), getCodeSystemNameFromId( code2.getCodeSystem() ) );
    }

    /**
     *  descendant check.
     *
     * @param code1 the code1
     * @param code2 the code2
     * @param codeSystem the code system
     * @return true, if successful
     */
    public boolean descendantCheck( Code code1, String code2, String codeSystem )
    {

       String output = umlsRestClient.getDescendants( code2, codeSystem);

       ObjectMapper mapper = new ObjectMapper();
       AtomSearchResult descendants;
       try {
           descendants = mapper.readValue(output, AtomSearchResult.class);
       } catch (IOException e) {

           e.printStackTrace();
           return false;
       }

        for ( int i = 0; i < descendants.getResult().size(); i++ )
        {

            final SourceAtomCluster myAtomClusterRelationDTO = descendants.getResult().get( i );
            final String otherAtomClusterUi = myAtomClusterRelationDTO.getUi();
            final String otherAtomClusterName =
                myAtomClusterRelationDTO.getName();
            System.out.println( otherAtomClusterUi + " " + otherAtomClusterName  );
            if ( otherAtomClusterUi.equals( code1.getCode() ) )
            {
                return true;
            }
        }

        return false;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args )
    {

        try
        {

            final UTSHandler uts = new UTSHandler();
            // uts.transformFreeText("Diabetes Mellitus");
            // myPsf.getIncludedRelationLabels().add("PAR");
            // List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
            //
            // myAtomClusterRelations =
            // utsContentService.getSourceDescriptorSourceDescriptorRelations(singleUseTicket2,umlsRelease,"E11","ICD10CM",
            // myPsf);
            //
            // for (int i = 0; i < myAtomClusterRelations.size(); i++) {
            //
            // AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get(i);
            // String otherAtomClusterUi = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
            // String otherAtomClusterName = myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();
            // String otherAtomClusterRel = myAtomClusterRelationDTO.getRelationLabel();
            // String otherAtomClusterRela = myAtomClusterRelationDTO.getAdditionalRelationLabel();
            // System.out.println(otherAtomClusterUi+" "+otherAtomClusterName+" "+otherAtomClusterRel+" "+otherAtomClusterRela);
            // }
            // Code c1 = CodeUtility.getCode("E11.5", "2.16.840.1.113883.6.90", "", "");
            final Code c2 = CodeUtility.getCode( "E11", "2.16.840.1.113883.6.96", "", "ICD10CM" );
            uts.transformCode( c2, "SNOMEDCT" );
            // System.out.println(uts.isDescendant(c1, c2));

        }
        catch ( final Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
