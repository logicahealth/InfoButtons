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
package org.openinfobutton.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hl7.v3.CategoryType;
import org.hl7.v3.REDSMT010001UVTaskContext;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskContext.
 */
public class TaskContext
{

    /** The code. */
    private Code code;

    /**
     * Instantiates a new task context.
     *
     * @param code the code
     * @param codeSystem the code system
     * @param displayName the display name
     * @param codeSystemName the code system name
     */
    public TaskContext( String code, String codeSystem, String displayName, String codeSystemName )
    {
        this.code = CodeUtility.getCode( code, codeSystem, displayName, codeSystemName );
    }

    /**
     * Instantiates a new task context.
     *
     * @param code the code
     */
    public TaskContext( Code code )
    {
        this.code = code;
    }

    /**
     * Instantiates a new task context.
     *
     * @param taskContext the task context
     */
    public TaskContext( REDSMT010001UVTaskContext taskContext )
    {
        this.code = CodeUtility.getCode( taskContext.getCode() );
    }
    
    /**
     * Instantiates a new task context.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public TaskContext(Map<String, String[]> requestParameters, final Map<String, List<CategoryType>> categoryHashMap) {
        
        List<CategoryType> category = new ArrayList<CategoryType>();
        final Code task = CodeUtility.getCode( CodeConstants.TASKCONTEXT );
        if ( requestParameters.containsKey( CodeConstants.TASKCONTEXT_CODE ) )
        {
            task.setCode( requestParameters.get( CodeConstants.TASKCONTEXT_CODE )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.TASKCONTEXT_CODE )[0] );
            c.setScheme( CodeConstants.TASKCONTEXT_CODE );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.TASKCONTEXT_DISPLAYNAME ) )
        {
            task.setDisplayName( requestParameters.get( CodeConstants.TASKCONTEXT_DISPLAYNAME )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.TASKCONTEXT_DISPLAYNAME )[0] );
            c.setScheme( CodeConstants.TASKCONTEXT_DISPLAYNAME );
            category.add( c );
        }
        if ( requestParameters.containsKey( CodeConstants.TASKCONTEXT_CODESYSTEM ) )
        {
            task.setCodeSystem( requestParameters.get( CodeConstants.TASKCONTEXT_CODESYSTEM )[0] );
            final CategoryType c = new CategoryType();
            c.setTerm( requestParameters.get( CodeConstants.TASKCONTEXT_CODESYSTEM )[0] );
            c.setScheme( CodeConstants.TASKCONTEXT_CODESYSTEM );
            category.add( c );
        }
        this.setCode( task );
        categoryHashMap.put( CodeConstants.TASK_KEY, category );

    }

    /**
     * Instantiates a new task context.
     */
    public TaskContext()
    {
        this( CodeUtility.getCode() );
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public Code getCode()
    {

        return this.code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode( Code code )
    {

        this.code = code;
    }

    /**
     * Gets the JAXB element.
     *
     * @param taskContext the task context
     * @return the JAXB element
     */
    public static REDSMT010001UVTaskContext getJAXBElement( TaskContext taskContext )
    {
        final REDSMT010001UVTaskContext jaxBElement = new REDSMT010001UVTaskContext();

        /*
         * jaxBElement.setCode(Code.getJAXBElement(taskContext.getCode())); edu.duke.mc.cfm.dci.infobutton.Code had a
         * few methods to do these transformations but to maintain uniformity throughout the project, now only the
         * Code-class from infobutton-kbschema is used.
         */
        jaxBElement.setCode( CodeUtility.getJAXBElement( taskContext.getCode() ) );
        return jaxBElement;
    }

}
