package org.openinfobutton.schema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hl7.v3.CategoryType;
import org.hl7.v3.REDSMT010001UVKnowledgeRequestNotification;
import org.openinfobutton.schemas.kb.Code;


/*
$Rev:: 1097          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2010-10-01 1#$:  Date of last commit
*/


public class KnowledgeRequest {

	private  PatientContext patientContext;
	
	private  Holder holder;
	
	private  Performer performer;
	
	private  InformationRecipient informationRecipient;
	
	private  TaskContext taskContext;
		
	private  MainSearchCriteria mainSearchCriteria;
	
	private  Encounter encounter;
	
	private  Date effectiveTime;
	
	private  String executionMode;
	
	/*searchCodes are used to hold all the codes within one request so that we don't have to call UTS
	multiple times*/
	public ArrayList<Code> searchCodes;
	
	Map<String,List<CategoryType>> CategoryHashMap;
	
	public KnowledgeRequest(PatientContext patientContext, Holder holder, 
			Performer performer, InformationRecipient informationRecipient, 
			TaskContext taskContext,MainSearchCriteria mainSearchCriteria, Encounter encounter,
			Date effectiveTime, String executionMode) {
		if (patientContext != null) {
			this.patientContext = new PatientContext(PatientContext.getJAXBElement(patientContext).getValue());
		} else {
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
	
	public KnowledgeRequest() {
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
	
	public KnowledgeRequest(REDSMT010001UVKnowledgeRequestNotification knowledgeRequest) {
		if (knowledgeRequest.getPatientContext() != null) {
			this.patientContext = new PatientContext(knowledgeRequest.getPatientContext().getValue());
		} else {
			this.patientContext = new PatientContext();
		}
		if (knowledgeRequest.getHolder() != null ) {
			this.holder = new Holder(knowledgeRequest.getHolder().getValue());
		} else {
			this.holder = new Holder();
		}
		if (knowledgeRequest.getPerformer() != null) { 
			this.performer = new Performer(knowledgeRequest.getPerformer().getValue());
		} else {
			this.performer = new Performer();
		}
		if (knowledgeRequest.getInformationRecipient() != null) {
			this.informationRecipient = new InformationRecipient(knowledgeRequest.getInformationRecipient().getValue());
		} else {
			this.informationRecipient = new InformationRecipient();
		}
		if (knowledgeRequest.getTaskContext() != null) {
			this.taskContext = new TaskContext(knowledgeRequest.getTaskContext());
		} else {
			this.taskContext = new TaskContext();
		}
		if (knowledgeRequest.getMainSearchCriteria() != null) {
			this.mainSearchCriteria = new MainSearchCriteria(knowledgeRequest.getMainSearchCriteria());
		} else {
			this.mainSearchCriteria = new MainSearchCriteria();
		}
		if (knowledgeRequest.getEncounter() != null) {
			this.encounter = new Encounter(knowledgeRequest.getEncounter().getValue());
		} else {
			this.encounter = new Encounter();
		}
		this.effectiveTime = new Date();
		this.executionMode = knowledgeRequest.getExecutionMode();
	}
	
	public PatientContext getPatientContext() {
		return this.patientContext;
	}

	public Holder getHolder() {
		return this.holder;
	}

	public Performer getPerformer() {
		return this.performer;
	}

	public InformationRecipient getInformationRecipient() {
		return this.informationRecipient;
	}

	public TaskContext getTaskContext() {
		return this.taskContext;
	}

	public MainSearchCriteria getMainSearchCriteria() {
		return this.mainSearchCriteria;
	}

	public Encounter getEncounter() {
		return this.encounter;
	}

	public Date getEffectiveTime() {
		return this.effectiveTime;
	}
	
	public String getExecutionMode() {
		return this.executionMode;
	}
	
	
	public Map<String, List<CategoryType>> getCategoryHashMap() {
		return CategoryHashMap;
	}

	public void setCategoryHashMap(Map<String, List<CategoryType>> categoryHashMap) {
		CategoryHashMap = categoryHashMap;
	}

	public static REDSMT010001UVKnowledgeRequestNotification getJAXBElement(KnowledgeRequest knowledgeRequest) {
		REDSMT010001UVKnowledgeRequestNotification jaxBElement = new REDSMT010001UVKnowledgeRequestNotification();
		jaxBElement.setMainSearchCriteria(MainSearchCriteria.getJAXBElement(knowledgeRequest.getMainSearchCriteria()));
		jaxBElement.setTaskContext(TaskContext.getJAXBElement(knowledgeRequest.getTaskContext()));
		jaxBElement.setPatientContext(PatientContext.getJAXBElement(knowledgeRequest.getPatientContext()));
		jaxBElement.setEncounter(Encounter.getJAXBElement(knowledgeRequest.getEncounter()));
		jaxBElement.setHolder(Holder.getJAXBElement(knowledgeRequest.getHolder()));
		jaxBElement.setPerformer(Performer.getJAXBElement(knowledgeRequest.getPerformer()));
		jaxBElement.setInformationRecipient(InformationRecipient.getJAXBElement(knowledgeRequest.getInformationRecipient()));
		jaxBElement.setExecutionMode(knowledgeRequest.getExecutionMode());
		return jaxBElement;
	}
	
	public void addSearchCode(Code c)
	{
		searchCodes.add(c);
	}

	public ArrayList<Code> getSearchCodes() {
		return searchCodes;
	}

	public void setSearchCodes(ArrayList<Code> searchCodes) {
		this.searchCodes = searchCodes;
	}

	public void setPatientContext(PatientContext patientContext) {
		this.patientContext = patientContext;
	}

	public void setHolder(Holder holder) {
		this.holder = holder;
	}

	public void setPerformer(Performer performer) {
		this.performer = performer;
	}

	public void setInformationRecipient(InformationRecipient informationRecipient) {
		this.informationRecipient = informationRecipient;
	}

	public void setTaskContext(TaskContext taskContext) {
		this.taskContext = taskContext;
	}

	public void setMainSearchCriteria(MainSearchCriteria mainSearchCriteria) {
		this.mainSearchCriteria = mainSearchCriteria;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public void setExecutionMode(String executionMode) {
		this.executionMode = executionMode;
	}
	
}
