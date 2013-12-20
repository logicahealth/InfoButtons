package edu.utah.openinfobutton.externalresource.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.Id;
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

@Component
public class UTSHandler implements ExternalResourceHandler {

	Logger log = Logger.getLogger(UTSHandler.class.getName());
	@Value("${umls.umlsRelease}") 
	String umlsRelease;
	String serviceName = "http://umlsks.nlm.nih.gov";
	@Value("${umls.username}")
	String username;
	@Value("${umls.password}")
	String password;
	UtsWsContentController utsContentService;
    UtsWsSecurityController securityService;
    UtsWsFinderController utsFinderService;
    String ticketGrantingTicket;
    
   public Code transformCode(Code code, String targetCS) {
		Code retCode = null;
		try {
			String ticketGrantingTicket = getTicketGrantingTicket();
	        String singleUseTicket1 = securityService.getProxyTicket(ticketGrantingTicket, serviceName);
	        String singleUseTicket2 = securityService.getProxyTicket(ticketGrantingTicket, serviceName);
	        List<AtomDTO> myAtoms = new ArrayList<AtomDTO>();
	        UtsMetathesaurusContent.Psf myPsf = new UtsMetathesaurusContent.Psf();
	        String cui = null;
	        myAtoms = utsContentService.getCodeAtoms(singleUseTicket1, umlsRelease, code.getCode(), code.getCodeSystemName(), myPsf);
	        if(myAtoms.size()==0)
	          	throw new Exception("UTS FAIL: Failed to get the CUI for the first time");
	        for (int i = 0; i < myAtoms.size(); i++) 
	        {
		        AtomDTO myAtomDTO = myAtoms.get(i);
		        cui = myAtomDTO.getConcept().getUi();
		        break;
		    }
	        myPsf.getIncludedSources().add(targetCS);
	        myAtoms = utsContentService.getConceptAtoms(singleUseTicket2,umlsRelease,cui,myPsf);
	        for (int i = 0; i < myAtoms.size(); i++) 
	        {
		        AtomDTO myAtomDTO = myAtoms.get(i);
		        retCode = CodeUtility.getCode();;
		        retCode.setCode(myAtomDTO.getCode().getUi());
		        break;
	        }
	        log.debug("Transformed: "+code.getCode()+" -> "+retCode.getCode());
		} catch (NullPointerException ex) {
			log.error("Code transformation Failed");
		}catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return retCode;
	}

   public ArrayList<Code> transformFreeText(String FreeText) {
		log.debug("Got Free text: "+FreeText);
		ArrayList<Code> searchCodes = new ArrayList<Code>();
		String ticketGrantingTicket;
		String singleUseTicket1;
		try {
			ticketGrantingTicket = getTicketGrantingTicket();
			singleUseTicket1 = securityService.getProxyTicket(ticketGrantingTicket, serviceName);
			UtsMetathesaurusFinder.Psf myPsf = new UtsMetathesaurusFinder.Psf();
	        myPsf.getIncludedSources().add("SNOMEDCT");
	        myPsf.getIncludedSources().add("ICD10CM");
	        myPsf.getIncludedSources().add("ICD9CM");
	        ArrayList<String> lookupList = new ArrayList<String>();
	        lookupList.add("SNOMEDCT");
	        lookupList.add("ICD10CM");
	        lookupList.add("ICD9CM");
	        myPsf.setIncludedLanguage("ENG");
	        myPsf.setPageLn(50);
	        List<UiLabelRootSource> myUiLabelsRootSource = new ArrayList<UiLabelRootSource>();
	        myUiLabelsRootSource = utsFinderService.findCodes(singleUseTicket1, umlsRelease, "atom", FreeText, "approximate", myPsf);
	        if(myUiLabelsRootSource.size()==0)
	        	throw new Exception("UTS FAIL: Could not get the Free Text Codes after querying for the first time");
	        for (int i = 0; i < myUiLabelsRootSource.size(); i++) {
		        UiLabelRootSource myUiLabelRootSource = myUiLabelsRootSource.get(i);
		        String ui = myUiLabelRootSource.getUi();
		        String label = myUiLabelRootSource.getLabel(); 
		        String source = myUiLabelRootSource.getRootSource();
		        for(int j=0;j<lookupList.size();j++)
		        {
		        	String s = lookupList.get(j);
		        	if(s.equals(source))
		        	{
		        		Code c = CodeUtility.getCode(ui, getCodeSystemId(source), label, source);
		        		log.debug(ui+" "+label+" "+source);
		        		searchCodes.add(c);
		        		lookupList.remove(source);
		        		j=0;
		        	}
		        }
		        if(lookupList.size()==0)
		        	break;
	      }
		} catch (UtsFault_Exception e) {
			e.printStackTrace();
		} catch (UtsMetathesaurusFinder.UtsFault_Exception e) {
			e.printStackTrace();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
        return searchCodes;
	}
	
	private String getCodeSystemId(String source) {
		if(source.equals("SNOMEDCT")) return "2.16.840.1.113883.6.96";
		else if(source.equals("ICD10CM")) return "2.16.840.1.113883.6.90";
		else if(source.equals("ICD9CM")) return "2.16.840.1.113883.6.103";
		return "";
	}

	private String getCodeSystemNameFromId(String source) {
		if(source.equals("2.16.840.1.113883.6.96")) return "SNOMEDCT";
		else if(source.equals("2.16.840.1.113883.6.90")) return "ICD10CM";
		else if(source.equals("2.16.840.1.113883.6.103")) return "ICD9CM";
		return "";
	}
	
	public boolean isDescendant(Code code1, Code code2)
	{
		if(!(code1.getCodeSystem().equals(code2.getCodeSystem())))
			return false;
		
		try {
			ticketGrantingTicket = getTicketGrantingTicket();
			
		} catch (UtsFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recursiveDescendantCheck(code1, code2.getCode(),getCodeSystemNameFromId(code2.getCodeSystem()));
	}

	public boolean recursiveDescendantCheck(Code code1,String code2,String codeSystem)
	{
		String singleUseTicket1;
		try {
			
			singleUseTicket1 = securityService.getProxyTicket(ticketGrantingTicket,serviceName);
			
		    List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
		    Psf myPsf = new Psf();
		    myPsf.getIncludedRelationLabels().add("PAR");
			myAtomClusterRelations = utsContentService.getSourceDescriptorSourceDescriptorRelations(singleUseTicket1, umlsRelease,
		    		code2,codeSystem,myPsf);
	        for (int i = 0; i < myAtomClusterRelations.size(); i++) {
	        	
		        AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get(i);
		        String otherAtomClusterUi = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
		        String otherAtomClusterName = myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();
		        String otherAtomClusterRel = myAtomClusterRelationDTO.getRelationLabel();
		        String otherAtomClusterRela = myAtomClusterRelationDTO.getAdditionalRelationLabel();
		        System.out.println(otherAtomClusterUi+" "+otherAtomClusterName+" "+otherAtomClusterRel+" "+otherAtomClusterRela);
		        if(otherAtomClusterUi.equals(code1.getCode()))
		        	return true;
		        if(recursiveDescendantCheck(code1,otherAtomClusterUi,codeSystem))
		        	return true;
	        }
	      
		} catch (UtsFault_Exception e) {
			e.printStackTrace();
		} catch (UtsMetathesaurusContent.UtsFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static void main (String[] args) {
	
		try {
			
			UTSHandler uts = new UTSHandler();
//	        uts.transformFreeText("Diabetes Mellitus");
//	        myPsf.getIncludedRelationLabels().add("PAR");
//	        List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
//
//	        myAtomClusterRelations = utsContentService.getSourceDescriptorSourceDescriptorRelations(singleUseTicket2,umlsRelease,"E11","ICD10CM", myPsf);
//
//	        for (int i = 0; i < myAtomClusterRelations.size(); i++) {
//
//	        AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get(i);
//	        String otherAtomClusterUi = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
//	        String otherAtomClusterName = myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();
//	        String otherAtomClusterRel = myAtomClusterRelationDTO.getRelationLabel();
//	        String otherAtomClusterRela = myAtomClusterRelationDTO.getAdditionalRelationLabel();
//	        System.out.println(otherAtomClusterUi+" "+otherAtomClusterName+" "+otherAtomClusterRel+" "+otherAtomClusterRela);
//	        }
//	        Code c1 = CodeUtility.getCode("E11.5", "2.16.840.1.113883.6.90", "", "");
	        Code c2 = CodeUtility.getCode("E11", "2.16.840.1.113883.6.96", "", "ICD10CM");
	        uts.transformCode(c2, "SNOMEDCT");
//	        System.out.println(uts.isDescendant(c1, c2));
	    
	       
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	


	 public String getTicketGrantingTicket() throws UtsFault_Exception
	    {
	    	utsContentService = (new UtsWsContentControllerImplService()).getUtsWsContentControllerImplPort();
	        securityService = (new UtsWsSecurityControllerImplService()).getUtsWsSecurityControllerImplPort();
	        utsFinderService=(new UtsWsFinderControllerImplService()).getUtsWsFinderControllerImplPort();
	      //get the Proxy Grant Ticket - this is good for 8 hours and is needed to generate single use tickets.
	        String ticketGrantingTicket = securityService.getProxyGrantTicket(username, password);
	        return ticketGrantingTicket;
	    }
}
