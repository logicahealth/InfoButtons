package org.openinfobutton.service.profile;


import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.utah.further.profiledb.service.FileandMarker;
import edu.utah.further.profiledb.service.ProfilesDao;


@Service
@Configurable(dependencyCheck = true)
public class ResourceProfileLoaderNew {
	
	Logger log = Logger.getLogger(ResourceProfileLoaderNew.class.getName());
	static boolean status;

	@Autowired
	@Qualifier("pDao")
	private ProfilesDao pdao; 
	
	@SuppressWarnings("boxing") 
	public ArrayList<KnowledgeResourceProfile> getProfiles() {
		log.info("Loading Profiles from the Database");
		ArrayList<KnowledgeResourceProfile> newProfiles = new ArrayList<KnowledgeResourceProfile>();
		JAXBContext context;
		Unmarshaller u = null;
		try {
			context = JAXBContext.newInstance(KnowledgeResourceProfile.class);
			u = context.createUnmarshaller();
		} catch (JAXBException e1) {
			e1.printStackTrace();
			log.error("Failed to get the Unmarshaller.Cannot proceed with loading the profiles");
			return newProfiles;
		}

		long length;
		int s;// 1 or 2 (status)
		if (status)
			s = 2;// under development = 2
		else
			s = 1;// active = 1
		length = pdao.count(s);
		length++;
		KnowledgeResourceProfile profile = null;
		FileandMarker fm = new FileandMarker();
		fm.setMarker(1);
		for (int x = 1; x < length; x++) {
			int marker = fm.getMarker();
			pdao.getResourceProfile((long) marker, s, fm);
			try {
				profile = (KnowledgeResourceProfile) u.unmarshal(fm.getBlobFile());
				newProfiles.add(profile);
				log.debug("Loaded Profile : "+profile.getHeader().getTitle());
			} catch (JAXBException e) {
				e.printStackTrace();
				log.error("Bad profile found and being skipped.Profile ID="+marker+" Status="+s);
			}
		}
		return newProfiles;
	}

	public static void setMode(String str)
	{
		
		if(str.equals(""))
		{   
			status=false;
		}
		else
		{	status=true;
		    
		}
	}

	
	
}
