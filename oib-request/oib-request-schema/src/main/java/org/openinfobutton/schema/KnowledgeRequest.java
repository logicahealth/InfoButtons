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
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hl7.v3.CategoryType;
import org.hl7.v3.REDSMT010001UVKnowledgeRequestNotification;
import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1097          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2010-10-01 1#$:  Date of last commit
 */

/**
 * The Class KnowledgeRequest.
 */
public class KnowledgeRequest
{

    /** The patient context. */
    private PatientContext patientContext;

    /** The holder. */
    private Holder holder;

    /** The performer. */
    private Performer performer;

    /** The information recipient. */
    private InformationRecipient informationRecipient;

    /** The task context. */
    private TaskContext taskContext;

    /** The main search criteria. */
    private MainSearchCriteria mainSearchCriteria;

    /** The encounter. */
    private Encounter encounter;

    /** The effective time. */
    private Date effectiveTime;

    /** The execution mode. */
    private String executionMode;

    /*
     * searchCodes are used to hold all the codes within one request so that we don't have to call UTS multiple times
     */
    /** The search codes. */
    public ArrayList<Code> searchCodes;

    /** The Category hash map. */
    Map<String, List<CategoryType>> CategoryHashMap;

    /**
     * Instantiates a new knowledge request.
     *
     * @param patientContext the patient context
     * @param holder the holder
     * @param performer the performer
     * @param informationRecipient the information recipient
     * @param taskContext the task context
     * @param mainSearchCriteria the main search criteria
     * @param encounter the encounter
     * @param effectiveTime the effective time
     * @param executionMode the execution mode
     */
    public KnowledgeRequest( PatientContext patientContext, Holder holder, Performer performer,
                             InformationRecipient informationRecipient, TaskContext taskContext,
                             MainSearchCriteria mainSearchCriteria, Encounter encounter, Date effectiveTime,
                             String executionMode )
    {
        if ( patientContext != null )
        {
            this.patientContext = new PatientContext( PatientContext.getJAXBElement( patientContext ).getValue() );
        }
        else
        {
            this.patientContext = new PatientContext();
        }
        this.holder = holder;
        this.performer = performer;
        this.informationRecipient = informationRecipient;
        this.taskContext = taskContext;
        this.mainSearchCriteria = mainSearchCriteria;
        this.encounter = encounter;
        this.effectiveTime = effectiveTime;
        this.executionMode = executionMode;
        this.searchCodes = new ArrayList<Code>();
    }

    /**
     * Instantiates a new knowledge request.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public KnowledgeRequest(Map<String, String[]> requestParameters, final Map<String, List<CategoryType>> categoryHashMap) {
        
        this.holder = new Holder(requestParameters, categoryHashMap);
        this.patientContext = new PatientContext(requestParameters, categoryHashMap);
        this.taskContext = new TaskContext(requestParameters, categoryHashMap);
        this.mainSearchCriteria = new MainSearchCriteria(requestParameters, categoryHashMap);
        this.performer = new Performer(requestParameters, categoryHashMap);
        this.informationRecipient = new InformationRecipient(requestParameters, categoryHashMap);
        this.encounter = new Encounter(requestParameters, categoryHashMap);
        this.executionMode = new String();
        if ( requestParameters.containsKey( CodeConstants.EXECUTION_MODE ) )
        {
            executionMode = requestParameters.get( CodeConstants.EXECUTION_MODE )[0];
        }
        this.searchCodes = new ArrayList<Code>();
    }
    
    /**
     * Instantiates a new knowledge request.
     */
    public KnowledgeRequest()
    {
        this.patientContext = new PatientContext();
        this.holder = new Holder();
        this.performer = new Performer();
        this.informationRecipient = new InformationRecipient();
        this.taskContext = new TaskContext();
        this.mainSearchCriteria = new MainSearchCriteria();
        this.encounter = new Encounter();
        this.effectiveTime = new Date();
        this.executionMode = new String();
        this.searchCodes = new ArrayList<Code>();
    }

    /**
     * Instantiates a new knowledge request.
     *
     * @param knowledgeRequest the knowledge request
     */
    public KnowledgeRequest( REDSMT010001UVKnowledgeRequestNotification knowledgeRequest )
    {
        if ( knowledgeRequest.getPatientContext() != null )
        {
            this.patientContext = new PatientContext( knowledgeRequest.getPatientContext().getValue() );
        }
        else
        {
            this.patientContext = new PatientContext();
        }
        if ( knowledgeRequest.getHolder() != null )
        {
            this.holder = new Holder( knowledgeRequest.getHolder().getValue() );
        }
        else
        {
            this.holder = new Holder();
        }
        if ( knowledgeRequest.getPerformer() != null )
        {
            this.performer = new Performer( knowledgeRequest.getPerformer().getValue() );
        }
        else
        {
            this.performer = new Performer();
        }
        if ( knowledgeRequest.getInformationRecipient() != null )
        {
            this.informationRecipient =
                new InformationRecipient( knowledgeRequest.getInformationRecipient().getValue() );
        }
        else
        {
            this.informationRecipient = new InformationRecipient();
        }
        if ( knowledgeRequest.getTaskContext() != null )
        {
            this.taskContext = new TaskContext( knowledgeRequest.getTaskContext() );
        }
        else
        {
            this.taskContext = new TaskContext();
        }
        if ( knowledgeRequest.getMainSearchCriteria() != null )
        {
            this.mainSearchCriteria = new MainSearchCriteria( knowledgeRequest.getMainSearchCriteria() );
        }
        else
        {
            this.mainSearchCriteria = new MainSearchCriteria();
        }
        if ( knowledgeRequest.getEncounter() != null )
        {
            this.encounter = new Encounter( knowledgeRequest.getEncounter().getValue() );
        }
        else
        {
            this.encounter = new Encounter();
        }
        this.effectiveTime = new Date();
        this.executionMode = knowledgeRequest.getExecutionMode();
    }

    /**
     * Gets the patient context.
     *
     * @return the patient context
     */
    public PatientContext getPatientContext()
    {
        return this.patientContext;
    }

    /**
     * Gets the holder.
     *
     * @return the holder
     */
    public Holder getHolder()
    {
        return this.holder;
    }

    /**
     * Gets the performer.
     *
     * @return the performer
     */
    public Performer getPerformer()
    {
        return this.performer;
    }

    /**
     * Gets the information recipient.
     *
     * @return the information recipient
     */
    public InformationRecipient getInformationRecipient()
    {
        return this.informationRecipient;
    }

    /**
     * Gets the task context.
     *
     * @return the task context
     */
    public TaskContext getTaskContext()
    {
        return this.taskContext;
    }

    /**
     * Gets the main search criteria.
     *
     * @return the main search criteria
     */
    public MainSearchCriteria getMainSearchCriteria()
    {
        return this.mainSearchCriteria;
    }

    /**
     * Gets the encounter.
     *
     * @return the encounter
     */
    public Encounter getEncounter()
    {
        return this.encounter;
    }

    /**
     * Gets the effective time.
     *
     * @return the effective time
     */
    public Date getEffectiveTime()
    {
        return this.effectiveTime;
    }

    /**
     * Gets the execution mode.
     *
     * @return the execution mode
     */
    public String getExecutionMode()
    {
        return this.executionMode;
    }

    /**
     * Gets the category hash map.
     *
     * @return the category hash map
     */
    public Map<String, List<CategoryType>> getCategoryHashMap()
    {
        return CategoryHashMap;
    }

    /**
     * Sets the category hash map.
     *
     * @param categoryHashMap the category hash map
     */
    public void setCategoryHashMap( Map<String, List<CategoryType>> categoryHashMap )
    {
        CategoryHashMap = categoryHashMap;
    }

    /**
     * Gets the JAXB element.
     *
     * @param knowledgeRequest the knowledge request
     * @return the JAXB element
     */
    public static REDSMT010001UVKnowledgeRequestNotification getJAXBElement( KnowledgeRequest knowledgeRequest )
    {
        final REDSMT010001UVKnowledgeRequestNotification jaxBElement = new REDSMT010001UVKnowledgeRequestNotification();
        jaxBElement.setMainSearchCriteria( MainSearchCriteria.getJAXBElement( knowledgeRequest.getMainSearchCriteria() ) );
        jaxBElement.setTaskContext( TaskContext.getJAXBElement( knowledgeRequest.getTaskContext() ) );
        jaxBElement.setPatientContext( PatientContext.getJAXBElement( knowledgeRequest.getPatientContext() ) );
        jaxBElement.setEncounter( Encounter.getJAXBElement( knowledgeRequest.getEncounter() ) );
        jaxBElement.setHolder( Holder.getJAXBElement( knowledgeRequest.getHolder() ) );
        jaxBElement.setPerformer( Performer.getJAXBElement( knowledgeRequest.getPerformer() ) );
        jaxBElement.setInformationRecipient( InformationRecipient.getJAXBElement( 
                                             knowledgeRequest.getInformationRecipient() ) );
        jaxBElement.setExecutionMode( knowledgeRequest.getExecutionMode() );
        return jaxBElement;
    }

    /**
     * Adds the search code.
     *
     * @param c the c
     */
    public void addSearchCode( Code c )
    {
        searchCodes.add( c );
    }

    /**
     * Gets the search codes.
     *
     * @return the search codes
     */
    public ArrayList<Code> getSearchCodes()
    {
        return searchCodes;
    }

    /**
     * Sets the search codes.
     *
     * @param searchCodes the new search codes
     */
    public void setSearchCodes( ArrayList<Code> searchCodes )
    {
        this.searchCodes = searchCodes;
    }

    /**
     * Sets the patient context.
     *
     * @param patientContext the new patient context
     */
    public void setPatientContext( PatientContext patientContext )
    {
        this.patientContext = patientContext;
    }

    /**
     * Sets the holder.
     *
     * @param holder the new holder
     */
    public void setHolder( Holder holder )
    {
        this.holder = holder;
    }

    /**
     * Sets the performer.
     *
     * @param performer the new performer
     */
    public void setPerformer( Performer performer )
    {
        this.performer = performer;
    }

    /**
     * Sets the information recipient.
     *
     * @param informationRecipient the new information recipient
     */
    public void setInformationRecipient( InformationRecipient informationRecipient )
    {
        this.informationRecipient = informationRecipient;
    }

    /**
     * Sets the task context.
     *
     * @param taskContext the new task context
     */
    public void setTaskContext( TaskContext taskContext )
    {
        this.taskContext = taskContext;
    }

    /**
     * Sets the main search criteria.
     *
     * @param mainSearchCriteria the new main search criteria
     */
    public void setMainSearchCriteria( MainSearchCriteria mainSearchCriteria )
    {
        this.mainSearchCriteria = mainSearchCriteria;
    }

    /**
     * Sets the encounter.
     *
     * @param encounter the new encounter
     */
    public void setEncounter( Encounter encounter )
    {
        this.encounter = encounter;
    }

    /**
     * Sets the effective time.
     *
     * @param effectiveTime the new effective time
     */
    public void setEffectiveTime( Date effectiveTime )
    {
        this.effectiveTime = effectiveTime;
    }

    /**
     * Sets the execution mode.
     *
     * @param executionMode the new execution mode
     */
    public void setExecutionMode( String executionMode )
    {
        this.executionMode = executionMode;
    }

}
