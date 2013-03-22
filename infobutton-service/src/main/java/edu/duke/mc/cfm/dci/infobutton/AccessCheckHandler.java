package edu.duke.mc.cfm.dci.infobutton;

import java.util.Iterator;
import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.KnowledgeResourceProfile;


public class AccessCheckHandler {

	public static List<KnowledgeResourceProfile> profiles;
	
	public static ResourceProfileProvider provider;
	
	private static String accessID;
	
	private static void initProfiles() {
		
		provider = ResourceProfileProvider.getInstance();
		profiles = provider.getProfiles();
	}
	
	public static boolean handleRequest(KnowledgeRequest request) {
		
		initProfiles();
		Holder holder = request.getHolder();
		IDLite representedOrganization = holder.getRepresentedOrganization();
		accessID = representedOrganization.getRoot();
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
		
		List<KnowledgeResourceProfile.ProfileDefinition.AuthorizedOrganizations.AuthorizedOrganization> authorizedOrganizations = profile.getProfileDefinition().getAuthorizedOrganizations().getAuthorizedOrganization();
		int authCount = authorizedOrganizations.size();
		Id id;
		for (int x = 0; x < authCount; x++) {
			id = authorizedOrganizations.get(x);
			if (accessID.equals(id.getId())) {
				
				match = true;
				break;
			}
		}
		return match;
	}

}
