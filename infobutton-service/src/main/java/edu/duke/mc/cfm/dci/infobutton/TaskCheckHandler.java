package edu.duke.mc.cfm.dci.infobutton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Context;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.KnowledgeResourceProfile;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.KnowledgeResourceProfile.ProfileDefinition.SupportedTerminologies;


public class TaskCheckHandler {

	public static List<KnowledgeResourceProfile> profiles;
	public static ResourceProfileProvider provider;
	public static KnowledgeRequest request;
	
	private static void initProfiles() {
		
		provider = ResourceProfileProvider.getInstance();
		profiles = provider.getProfiles();
	}
	
	public static boolean handleRequest(KnowledgeRequest knowledgeRequest) {
		initProfiles();
		request = knowledgeRequest;
		KnowledgeResourceProfile profile;
		for (Iterator<KnowledgeResourceProfile> iter = profiles.iterator(); iter.hasNext();) {
			profile = iter.next();
			if (!checkProfile(profile)) {
				iter.remove();
			}
		}
		provider.setProfiles(profiles);
		return profiles.isEmpty();
	}
	
	private static Boolean checkProfile (KnowledgeResourceProfile profile) {
		
		Boolean match = false;
		List<Context> contexts = profile.getProfileDefinition().getContexts().getContext();
		int count = contexts.size();
		CodedContextElement task = new  CodedContextElement();
		for (int x = 0; x < count; x++) {
			task = contexts.get(x).getContextDefinition().getTask();
			SupportedTerminologies supportedTerminologies = profile.getProfileDefinition().getSupportedTerminologies();
			List<Id> terminologyList = new ArrayList<Id>();
			List<String> supportedCodeSystems = new ArrayList<String>();
			if(supportedTerminologies!=null)
			{
				terminologyList = supportedTerminologies.getSupportedTerminology();
				for(int i=0;i<terminologyList.size();i++)
				{
					String cs = terminologyList.get(i).getId();
					supportedCodeSystems.add(cs);
				}
			}
			TaskContextMatcher matcher = new TaskContextMatcher(task, request,supportedCodeSystems);
			match = matcher.MatchContext();
			if (match) {
				break;
			}
		}
		return match;
	}
}
