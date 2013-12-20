package org.openinfobutton.service.matching;

import java.util.ArrayList;
import java.util.List;

import org.openinfobutton.schemas.kb.Context;
import org.openinfobutton.schemas.kb.Id;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile.ProfileDefinition.SupportedTerminologies;



public class RequestResult implements Comparable<RequestResult>{
	
	private List <Context> contexts;
	private KnowledgeResourceProfile.Header header;
	private KnowledgeResourceProfile.ProfileDefinition profileDefinition;
	private List<String> supportedCodeSystems;
	public RequestResult(KnowledgeResourceProfile profile) {
		
		contexts = new ArrayList<Context>();
		this.header = profile.getHeader();
		this.profileDefinition = profile.getProfileDefinition();
		SupportedTerminologies supportedTerminologies =profile.getProfileDefinition().getSupportedTerminologies();
		List<Id> terminologyList = new ArrayList<Id>();
		supportedCodeSystems = new ArrayList<String>();
		if(supportedTerminologies!=null)
		{
			terminologyList = supportedTerminologies.getSupportedTerminology();
			for(int i=0;i<terminologyList.size();i++)
			{
				String cs = terminologyList.get(i).getId();
				supportedCodeSystems.add(cs);
			}
		}
	}
	
	public String getUrlStyle()
	{
		return profileDefinition.getUrlStyle();
	}
	
	public boolean isHl7URLCompliant()
	{
		return profileDefinition.isHl7URLCompliant();
	}
	
	public boolean isHl7KnowledgeResponseCompliant()
	{
		return profileDefinition.isHl7KnowledgeResponseCompliant();
	}
	
	public void addResult(Context context) {
		
		contexts.add(context);
	}
	
	public List<Context> getContexts() {
		
		return contexts;
	}
	
	public KnowledgeResourceProfile.Header getHeader() {
		
		return header;
	}
	
	
	public List<String> getSupportedCodeSystems() {
		return supportedCodeSystems;
	}


	public void setSupportedCodeSystems(List<String> supportedCodeSystems) {
		this.supportedCodeSystems = supportedCodeSystems;
	}


	@Override 
	public int compareTo (RequestResult r) {
		
		return (this.header.getTitle()).compareTo(r.getHeader().getTitle());
	}
}
