package edu.duke.mc.cfm.dci.infobutton;

import java.util.ArrayList;
import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.KnowledgeResourceProfile;

/*
$Rev:: 2216          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2011-02-24 1#$:  Date of last commit
*/

public class ResourceProfileProvider {
	
	private static ResourceProfileProvider instance;
	
	private List<KnowledgeResourceProfile> profiles;

	private ResourceProfileProvider () {
		
		profiles = new ArrayList<KnowledgeResourceProfile>();
		//changed
		ResourceProfileLoaderNew rpn = new ResourceProfileLoaderNew();
		profiles.addAll(rpn.getProfiles());
	}
	
	public static ResourceProfileProvider getInstance() {

		if (instance == null) {
			
			instance = new ResourceProfileProvider();
		}
		
		return instance;
	}
	
	public List<KnowledgeResourceProfile> getProfiles() {
		
		return profiles;
	}
	
	public void setProfiles (List<KnowledgeResourceProfile> profiles) {
		
		this.profiles = profiles;
		if (profiles.isEmpty()) {
			resetInstance();
		}
	}
	
	public static void resetInstance() {
		
		instance = null;
	}
}
