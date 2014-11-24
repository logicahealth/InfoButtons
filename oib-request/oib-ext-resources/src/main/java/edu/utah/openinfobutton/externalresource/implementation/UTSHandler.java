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
package edu.utah.openinfobutton.externalresource.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schemas.kb.Code;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import UtsMetathesaurusContent.AtomClusterRelationDTO;
import UtsMetathesaurusContent.AtomDTO;
import UtsMetathesaurusContent.Psf;
import UtsMetathesaurusContent.UtsWsContentController;
import UtsMetathesaurusContent.UtsWsContentControllerImplService;
import UtsMetathesaurusFinder.UiLabelRootSource;
import UtsMetathesaurusFinder.UtsWsFinderController;
import UtsMetathesaurusFinder.UtsWsFinderControllerImplService;
import UtsSecurity.UtsFault_Exception;
import UtsSecurity.UtsWsSecurityController;
import UtsSecurity.UtsWsSecurityControllerImplService;
import edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler;

/**
 * The Class UTSHandler.
 */
@Component
public class UTSHandler
    implements ExternalResourceHandler
{

    /** The log. */
    Logger log = Logger.getLogger( UTSHandler.class.getName() );

    /** The umls release. */
    @Value( "${umls.umlsRelease}" )
    String umlsRelease;

    /** The service name. */
    String serviceName = "http://umlsks.nlm.nih.gov";

    /** The username. */
    @Value( "${umls.username}" )
    String username;

    /** The password. */
    @Value( "${umls.password}" )
    String password;

    /** The uts content service. */
    UtsWsContentController utsContentService;

    /** The security service. */
    UtsWsSecurityController securityService;

    /** The uts finder service. */
    UtsWsFinderController utsFinderService;

    /** The ticket granting ticket. */
    String ticketGrantingTicket;

    /*
     * (non-Javadoc)
     * @see edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler#transformCode(org.openinfobutton.schemas.kb.Code, java.lang.String)
     */
    @Override
    public Code transformCode( Code code, String targetCS )
    {
        Code retCode = null;
        try
        {
            final String ticketGrantingTicket = getTicketGrantingTicket();
            final String singleUseTicket1 = securityService.getProxyTicket( ticketGrantingTicket, serviceName );
            final String singleUseTicket2 = securityService.getProxyTicket( ticketGrantingTicket, serviceName );
            List<AtomDTO> myAtoms = new ArrayList<AtomDTO>();
            final UtsMetathesaurusContent.Psf myPsf = new UtsMetathesaurusContent.Psf();
            String cui = null;
            myAtoms =
                utsContentService.getCodeAtoms( singleUseTicket1, umlsRelease, code.getCode(),
                                                code.getCodeSystemName(), myPsf );
            if ( myAtoms.size() == 0 )
            {
                throw new Exception( "UTS FAIL: Failed to get the CUI for the first time" );
            }
            for ( int i = 0; i < myAtoms.size(); i++ )
            {
                final AtomDTO myAtomDTO = myAtoms.get( i );
                cui = myAtomDTO.getConcept().getUi();
                break;
            }
            myPsf.getIncludedSources().add( targetCS );
            myAtoms = utsContentService.getConceptAtoms( singleUseTicket2, umlsRelease, cui, myPsf );
            for ( int i = 0; i < myAtoms.size(); i++ )
            {
                final AtomDTO myAtomDTO = myAtoms.get( i );
                retCode = CodeUtility.getCode();
                
                retCode.setCode( myAtomDTO.getCode().getUi() );
                break;
            }
            log.debug( "Transformed: " + code.getCode() + " -> " + retCode.getCode() );
        }
        catch ( final NullPointerException ex )
        {
            log.error( "Code transformation Failed" );
        }
        catch ( final Exception ex )
        {
            log.error( ex.getMessage() );
        }
        return retCode;
    }

    /*
     * (non-Javadoc)
     * @see edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler#transformFreeText(java.lang.String)
     */
    @Override
    public ArrayList<Code> transformFreeText( String FreeText )
    {
        log.debug( "Got Free text: " + FreeText );
        final ArrayList<Code> searchCodes = new ArrayList<Code>();
        String ticketGrantingTicket;
        String singleUseTicket1;
        try
        {
            ticketGrantingTicket = getTicketGrantingTicket();
            singleUseTicket1 = securityService.getProxyTicket( ticketGrantingTicket, serviceName );
            final UtsMetathesaurusFinder.Psf myPsf = new UtsMetathesaurusFinder.Psf();
            myPsf.getIncludedSources().add( "SNOMEDCT" );
            myPsf.getIncludedSources().add( "ICD10CM" );
            myPsf.getIncludedSources().add( "ICD9CM" );
            final ArrayList<String> lookupList = new ArrayList<String>();
            lookupList.add( "SNOMEDCT" );
            lookupList.add( "ICD10CM" );
            lookupList.add( "ICD9CM" );
            myPsf.setIncludedLanguage( "ENG" );
            myPsf.setPageLn( 50 );
            List<UiLabelRootSource> myUiLabelsRootSource = new ArrayList<UiLabelRootSource>();
            myUiLabelsRootSource =
                utsFinderService.findCodes( singleUseTicket1, umlsRelease, "atom", FreeText, "approximate", myPsf );
            if ( myUiLabelsRootSource.size() == 0 )
            {
                throw new Exception( "UTS FAIL: Could not get the Free Text Codes after querying for the first time" );
            }
            for ( int i = 0; i < myUiLabelsRootSource.size(); i++ )
            {
                final UiLabelRootSource myUiLabelRootSource = myUiLabelsRootSource.get( i );
                final String ui = myUiLabelRootSource.getUi();
                final String label = myUiLabelRootSource.getLabel();
                final String source = myUiLabelRootSource.getRootSource();
                for ( int j = 0; j < lookupList.size(); j++ )
                {
                    final String s = lookupList.get( j );
                    if ( s.equals( source ) )
                    {
                        final Code c = CodeUtility.getCode( ui, getCodeSystemId( source ), label, source );
                        log.debug( ui + " " + label + " " + source );
                        searchCodes.add( c );
                        lookupList.remove( source );
                        j = 0;
                    }
                }
                if ( lookupList.size() == 0 )
                {
                    break;
                }
            }
        }
        catch ( final UtsFault_Exception e )
        {
            e.printStackTrace();
        }
        catch ( final UtsMetathesaurusFinder.UtsFault_Exception e )
        {
            e.printStackTrace();
        }
        catch ( final Exception e )
        {
            log.error( e.getMessage() );
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
        if ( source.equals( "SNOMEDCT" ) )
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
            return "SNOMEDCT";
        }
        else if ( source.equals( "2.16.840.1.113883.6.90" ) )
        {
            return "ICD10CM";
        }
        else if ( source.equals( "2.16.840.1.113883.6.103" ) )
        {
            return "ICD9CM";
        }
        return "";
    }

    /*
     * (non-Javadoc)
     * @see edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler#isDescendant(org.openinfobutton.schemas.kb.Code, org.openinfobutton.schemas.kb.Code)
     */
    @Override
    public boolean isDescendant( Code code1, Code code2 )
    {
        if ( !( code1.getCodeSystem().equals( code2.getCodeSystem() ) ) )
        {
            return false;
        }

        try
        {
            ticketGrantingTicket = getTicketGrantingTicket();

        }
        catch ( final UtsFault_Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return recursiveDescendantCheck( code1, code2.getCode(), getCodeSystemNameFromId( code2.getCodeSystem() ) );
    }

    /**
     * Recursive descendant check.
     *
     * @param code1 the code1
     * @param code2 the code2
     * @param codeSystem the code system
     * @return true, if successful
     */
    public boolean recursiveDescendantCheck( Code code1, String code2, String codeSystem )
    {
        String singleUseTicket1;
        try
        {

            singleUseTicket1 = securityService.getProxyTicket( ticketGrantingTicket, serviceName );

            List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
            final Psf myPsf = new Psf();
            myPsf.getIncludedRelationLabels().add( "PAR" );
            myAtomClusterRelations =
                utsContentService.getSourceDescriptorSourceDescriptorRelations( singleUseTicket1, umlsRelease, code2,
                                                                                codeSystem, myPsf );
            for ( int i = 0; i < myAtomClusterRelations.size(); i++ )
            {

                final AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get( i );
                final String otherAtomClusterUi = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
                final String otherAtomClusterName =
                    myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();
                final String otherAtomClusterRel = myAtomClusterRelationDTO.getRelationLabel();
                final String otherAtomClusterRela = myAtomClusterRelationDTO.getAdditionalRelationLabel();
                System.out.println( otherAtomClusterUi + " " + otherAtomClusterName + " " + otherAtomClusterRel + " "
                    + otherAtomClusterRela );
                if ( otherAtomClusterUi.equals( code1.getCode() ) )
                {
                    return true;
                }
                if ( recursiveDescendantCheck( code1, otherAtomClusterUi, codeSystem ) )
                {
                    return true;
                }
            }

        }
        catch ( final UtsFault_Exception e )
        {
            e.printStackTrace();
        }
        catch ( final UtsMetathesaurusContent.UtsFault_Exception e )
        {
            e.printStackTrace();
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

    /**
     * Gets the ticket granting ticket.
     *
     * @return the ticket granting ticket
     * @throws UtsFault_Exception the uts fault_ exception
     */
    public String getTicketGrantingTicket()
        throws UtsFault_Exception
    {
        utsContentService = ( new UtsWsContentControllerImplService() ).getUtsWsContentControllerImplPort();
        securityService = ( new UtsWsSecurityControllerImplService() ).getUtsWsSecurityControllerImplPort();
        utsFinderService = ( new UtsWsFinderControllerImplService() ).getUtsWsFinderControllerImplPort();
        // get the Proxy Grant Ticket - this is good for 8 hours and is needed to generate single use tickets.
        final String ticketGrantingTicket = securityService.getProxyGrantTicket( username, password );
        return ticketGrantingTicket;
    }
}
