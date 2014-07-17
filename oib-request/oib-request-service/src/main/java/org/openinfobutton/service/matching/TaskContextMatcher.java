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
package org.openinfobutton.service.matching;

import java.util.List;

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.TaskContext;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskContextMatcher.
 */
public class TaskContextMatcher
    extends ContextMatcher
{

    /** The task context. */
    public TaskContext taskContext;

    /** The context. */
    public CodedContextElement context;

    /** The request. */
    KnowledgeRequest request;

    /** The supported code systems. */
    List<String> supportedCodeSystems;

    /**
     * Instantiates a new task context matcher.
     *
     * @param context the context
     * @param request the request
     * @param supportedCodeSystems the supported code systems
     */
    public TaskContextMatcher( CodedContextElement context, KnowledgeRequest request, List<String> supportedCodeSystems )
    {
        this.context = context;
        this.taskContext = request.getTaskContext();
        this.supportedCodeSystems = supportedCodeSystems;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.matching.ContextMatcher#MatchContext()
     */
    @Override
    public Boolean MatchContext()
    {
        Boolean match = false;
        final Code code = taskContext.getCode();
        match = CodeMatch( code, context, supportedCodeSystems, false, request );
        return match;
    }
}
