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
package org.openinfobutton.service.transform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.openinfobutton.inference.rxnorm.service.RxNormService;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.openinfobutton.schemas.kb.TerminologyInference;
import org.openinfobutton.schemas.kb.TerminologyInference.CodeInference.InferenceDefinition.LocalMappings.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.openinfobutton.externalresource.api.ExternalResourceHandler;
import org.openinfobutton.externalresource.api.TerminologyHandler;
import org.openinfobutton.externalresource.implementation.TerminologyMappings;

/**
 * The Class TransformCode.
 */
@Component
public class TransformCode
{

    /** The terminology inference location. */
    @Value( "${service.terminologyLocation}" )
    String terminologyInferenceLocation;

    /** The handler. */
    @Autowired
    ExternalResourceHandler handler;

    /** The terminology mappings. */
    @Autowired
    TerminologyMappings terminologyMappings;

    /** The ES handler. */
    @Autowired
    @Qualifier( "externalSet" )
    private TerminologyHandler ESHandler;

    /** The valid mappings. */
    List<Mapping> validMappings;

    /**
     * Transform input.
     *
     * @param element required for rxnorm
     * @param code the code that we are trying to transform
     * @param supportedCodeSystems from the profile
     * @param request the already transformed codes are stored in the request
     * @return the code
     */
    public Code transformInput( CodedContextElement element, Code code, List<String> supportedCodeSystems,
                                KnowledgeRequest request )
    {
        if ( supportedCodeSystems.size() > 0 )
        {
            if ( supportedCodeSystems.contains( code.getCodeSystem() ) )
            {
                return code;
            }
            else if ( request.getSearchCodes().size() > 0 )
            {
                final ArrayList<Code> searchCodes = request.getSearchCodes();
                for ( final Code c : searchCodes )
                {
                    if ( supportedCodeSystems.contains( c.getCodeSystem() ) )
                    {
                        return c;
                    }
                }
            }
            else
            {
                // do mappings
                validMappings = terminologyMappings.getValidMappings();
                for ( int i = 0; i < validMappings.size(); i++ )
                {
                    final Mapping m = validMappings.get( i );
                    if ( ( m.getSourceValue().equals( code.getCodeSystem() ) )
                        && ( supportedCodeSystems.contains( m.getTargetValue() ) ) )
                    {
                        // new method will transform into m.gettarget
                        code.setCodeSystemName( m.getSourceName() );
                        if ((request.getTaskContext().getCode().getCode().equals("MLREV") || request.getTaskContext().getCode().getCode().equals("MEDOE")) && m.getTargetName().equals("RxNorm"))
                        {
                            try {
                                return RxNormService.getTransformedCode(code);
                            } catch (IOException e) {

                                e.printStackTrace();
                            }
                        }
                        final Code transformedCode = ESHandler.transformCode( code, m.getTargetValue() );
                        if ( transformedCode != null )
                        {
                            request.addSearchCode( transformedCode );
                            return transformedCode;
                        }
                    }
                }

            }
        }

        if ( element.getOutputDisplayNameTransformation() != null )
        {
            final String id = element.getOutputDisplayNameTransformation().getId();
            final TerminologyInference inference = getTerminologyInference( id );
            final Code newCode =
                NamedCodeInferences.valueOf( inference.getCallInferenceByName() ).getCodeFromDisplayName( code );
            return newCode;
        }
        else
        {
            return code;
        }
    }

    /**
     * Transform output.
     *
     * @param element the element
     * @param code the code
     * @param supportedCodeSystems the supported code systems
     * @param request the request
     * @return the code
     */
    public Code transformOutput( CodedContextElement element, Code code, List<String> supportedCodeSystems,
                                 KnowledgeRequest request )
    {

        if ( supportedCodeSystems.size() > 0 )
        {
            if ( supportedCodeSystems.contains( code.getCodeSystem() ) )
            {
                return code;
            }
            else if ( request.getSearchCodes().size() > 0 )
            {
                final ArrayList<Code> searchCodes = request.getSearchCodes();
                for ( final Code c : searchCodes )
                {
                    if ( supportedCodeSystems.contains( c.getCodeSystem() ) )
                    {
                        return c;
                    }
                }
            }
            else
            {
                // do mappings
                validMappings = terminologyMappings.getValidMappings();
                for ( int i = 0; i < validMappings.size(); i++ )
                {
                    final Mapping m = validMappings.get( i );
                    if ( ( m.getSourceValue().equals( code.getCodeSystem() ) )
                        && ( supportedCodeSystems.contains( m.getTargetValue() ) ) )
                    {
                        // new method will transform into m.gettarget
                        code.setCodeSystemName( m.getSourceName() );
                        if ((request.getTaskContext().getCode().getCode().equals("MLREV") || request.getTaskContext().getCode().getCode().equals("MEDOE")) && m.getTargetName().equals("RxNorm"))
                        {
                            try {
                                return RxNormService.getTransformedCode(code);
                            } catch (IOException e) {

                                e.printStackTrace();
                            }
                        }
                        final Code transformedCode = ESHandler.transformCode( code, m.getTargetValue() );
                        if ( transformedCode != null )
                        {
                            return transformedCode;
                        }
                    }
                }

            }
        }

        if ( element.getOutputDisplayNameTransformation() != null )
        {
            final String id = element.getOutputDisplayNameTransformation().getId();
            final TerminologyInference inference = getTerminologyInference( id );
            final Code newCode =
                NamedCodeInferences.valueOf( inference.getCallInferenceByName() ).getCodeFromDisplayName( code );
            return newCode;
        }
        else
        {
            return code;
        }
    }

    /**
     * Gets the terminology inference.
     *
     * @param id the id
     * @return the terminology inference
     */
    private TerminologyInference getTerminologyInference( final String id )
    {
        TerminologyInference inference = new TerminologyInference();
        try
        {

            final JAXBContext context = JAXBContext.newInstance( TerminologyInference.class );
            final Unmarshaller u = context.createUnmarshaller();
            final File profile = new File( terminologyInferenceLocation + "/" + id + ".xml" );
            inference = (TerminologyInference) u.unmarshal( profile );
        }
        catch ( final JAXBException e )
        {

            e.printStackTrace();
        }
        return inference;
    }

}
