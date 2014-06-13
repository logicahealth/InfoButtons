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
 * @version Jun 13, 2014
 */
package org.openinfobutton.service.transform;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.openinfobutton.schemas.kb.TerminologyInference;
import org.openinfobutton.schemas.kb.TerminologyInference.CodeInference.InferenceDefinition.LocalMappings.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import edu.utah.openinfobutton.externalresource.api.ExternalResourceHandler;
import edu.utah.openinfobutton.externalresource.api.TerminologyHandler;
import edu.utah.openinfobutton.externalresource.implementation.TerminologyMappings;


@Component
public class TransformCode {
	
	@Value("${service.terminologyLocation}") 
	String terminologyInferenceLocation;
	@Autowired
	ExternalResourceHandler handler;
	@Autowired
	TerminologyMappings terminologyMappings;
	@Autowired
	@Qualifier("externalSet")
	private TerminologyHandler ESHandler;
	List<Mapping> validMappings;
	
	/**
	 * 
	 * @param element required for rxnorm
	 * @param code the code that we are trying to transform
	 * @param supportedCodeSystems from the profile
	 * @param request the already transformed codes are stored in the request
	 * @return
	 */
	public  Code transformInput(CodedContextElement element, Code code, List<String> supportedCodeSystems, KnowledgeRequest request )
	{
		if(supportedCodeSystems.size()>0)
		{
			if(supportedCodeSystems.contains(code.getCodeSystem()))
				return code;
			else if(request.getSearchCodes().size()>0)
			{
				ArrayList<Code> searchCodes = request.getSearchCodes();
				for(Code c:searchCodes)
				{
					if(supportedCodeSystems.contains(c.getCodeSystem()))
						return c;
				}
			}
			else
			{
				//do mappings
				validMappings=terminologyMappings.getValidMappings();
				for(int i=0;i<validMappings.size();i++)
				{
					Mapping m=validMappings.get(i);
					if((m.getSourceValue().equals(code.getCodeSystem()))&&(supportedCodeSystems.contains(m.getTargetValue())))
					{
						//new method will transform into m.gettarget
						code.setCodeSystemName(m.getSourceName());
						Code transformedCode= ESHandler.transformCode(code,m.getTargetValue());
						if(transformedCode!=null)
						{
							request.addSearchCode(transformedCode);
							return transformedCode;
						}
					}
				}
				
			}
		}
		
		if (element.getOutputDisplayNameTransformation() != null)
		{
			String id = element.getOutputDisplayNameTransformation().getId();
			TerminologyInference inference = getTerminologyInference(id);
			Code newCode = NamedCodeInferences.valueOf(inference.getCallInferenceByName()).getCodeFromDisplayName(code);
			return newCode;
		}
		else
		{
			return code;
		}		
	}

	public  Code transformOutput( CodedContextElement element,  Code code ,List<String> supportedCodeSystems, KnowledgeRequest request ) {
		
		if(supportedCodeSystems.size()>0)
		{
			if(supportedCodeSystems.contains(code.getCodeSystem()))
				return code;
			else if(request.getSearchCodes().size()>0)
			{
				ArrayList<Code> searchCodes = request.getSearchCodes();
				for(Code c:searchCodes)
				{
					if(supportedCodeSystems.contains(c.getCodeSystem()))
						return c;
				}
			}
			else
			{
				//do mappings
				validMappings=terminologyMappings.getValidMappings();
				for(int i=0;i<validMappings.size();i++)
				{
					Mapping m=validMappings.get(i);
					if((m.getSourceValue().equals(code.getCodeSystem()))&&(supportedCodeSystems.contains(m.getTargetValue())))
					{
						//new method will transform into m.gettarget
						code.setCodeSystemName(m.getSourceName());
						Code transformedCode= ESHandler.transformCode(code,m.getTargetValue());
						if(transformedCode!=null)
							return transformedCode;
					}
				}
				
			}
		}
	
		if (element.getOutputDisplayNameTransformation() != null)
		{
			String id = element.getOutputDisplayNameTransformation().getId();
			TerminologyInference inference = getTerminologyInference(id);
			Code newCode = NamedCodeInferences.valueOf(inference.getCallInferenceByName()).getCodeFromDisplayName(code);
			return newCode;
		}
		else
		{
			return code;
		}
	}
	
	private TerminologyInference getTerminologyInference (final String id)
	{
		TerminologyInference inference = new TerminologyInference();
		try {
			
			JAXBContext context = JAXBContext.newInstance(TerminologyInference.class);
			Unmarshaller u = context.createUnmarshaller();
			File profile = new File(terminologyInferenceLocation + "/" + id + ".xml");
			inference = (TerminologyInference)u.unmarshal(profile);
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
		return inference;
	}

}
