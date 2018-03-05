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

import java.util.List;

import org.openinfobutton.externalresource.api.TerminologyHandler;
import org.openinfobutton.valuset.matcher.api.ValueSetMatcher;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.schemas.kb.TerminologyInference.CodeInference.InferenceDefinition.LocalMappings.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.openinfobutton.externalresource.api.ExternalResourceHandler;

import javax.annotation.Resource;

/**
 * The Class LocalTerminologyHandler.
 */
@Component
public class LocalTerminologyHandler
    implements TerminologyHandler
{

    /** The dao. */
    @Autowired
    @Resource( name = "${service.SubsetImplementation}" )
    private ValueSetMatcher matcher;

    /** The handler. */
    @Autowired
    ExternalResourceHandler handler;

    /** The terminology mappings. */
    @Autowired
    TerminologyMappings terminologyMappings;

    /** The valid mappings. */
    List<Mapping> validMappings;

    /*
     * (non-Javadoc)
     * @see TerminologyHandler#isSubsetMember(org.openinfobutton.schemas.kb.Code, java.utils.List)
     */
    @Override
    public Boolean isSubsetMember( Code code, List<Id> subsetIdList )
    {

        Boolean match = false;
        for ( final Id subsetId : subsetIdList )
        {
            match = matcher.isConceptInSubset( code.getCode(), code.getCodeSystem(), subsetId.getId() );
            if ( match )
            {
                break;
            }
        }
        // This is no longer necessary as all of the values sets are present in the UofU local OIB.
        // If required, your own implementation can be given.
        // if(!match)
        // {
        // match = handler.matchCodeSet(subsetIdList, code);
        // }
        return match;
    }

    /*
     * (non-Javadoc)
     * @see TerminologyHandler#transformCode(org.openinfobutton.schemas.kb.Code, java.lang.String)
     */
    @Override
    public Code transformCode( Code code, String codeSystem )
    {
        // TODO Auto-generated method stub
        validMappings = terminologyMappings.getValidMappings();
        for ( int i = 0; i < validMappings.size(); i++ )
        {
            final Mapping m = validMappings.get( i );
            if ( ( m.getSourceValue().equals( code.getCodeSystem() ) ) && ( m.getTargetValue().equals( codeSystem ) ) )
            {
                final Code transformedCode = handler.transformCode( code, m.getTargetName() );
                if ( transformedCode != null )
                {
                    transformedCode.setCodeSystem( m.getTargetValue() );
                    return transformedCode;
                }
            }
        }
        return null;
    }

    /**
     * Checks if is descendant.
     *
     * @param code1 the code1
     * @param code2 the code2
     * @return true, if is descendant
     */
    public boolean isDescendant( Code code1, Code code2 )
    {
        return handler.isDescendant( code1, code2 );
    }
}
