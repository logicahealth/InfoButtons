package edu.utah.further.profiledb.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import edu.utah.further.core.api.context.Implementation;
import edu.utah.further.core.api.data.Dao;
import edu.utah.further.profiledb.domain.Profiles;

@Implementation
@Repository("profilesdbDao")
public class ProfilesDaoImpl implements ProfilesDao {


	@Autowired
	@Qualifier("profilesDao")
	private Dao dao;
	
		
	@Transactional
	public void getResourceProfile(long id,int status,FileandMarker fm) {
	    
	    boolean finish = false;
		Profiles p = null;
		//FileandMarker fm = new FileandMarker();
		
		while(!finish)
		{
				Map <String, Object> properties = new HashMap<String, Object>();
				properties.put("id", new Long(id));
				properties.put("status", new Integer(status));
				List l = dao.findByProperties(Profiles.class, properties);
				id++;
				fm.setMarker((int) id);
				if(l.size()!=0)
				{
					
					p = (Profiles)l.get(0);
					finish = true;
				}
		}
		
		
		try{
		Blob b=p.getContent();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(b.getBinaryStream());
		fm.setBlobFile(doc);
		//A temporary file is created here
//		fm.setBlobFile(new File("fetch.xml")) ; 
//		
//		InputStream in = b.getBinaryStream(); 
//		BufferedInputStream bufferedInputStream = new BufferedInputStream( in);
//		FileOutputStream  outStream  = new FileOutputStream(fm.getBlobFile());
//	    int data = -1; 
//	    while ( (data = bufferedInputStream.read( )) != -1 ) 
//	    { 
//	    	outStream.write( data); 
//	    } 
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	    //return fm;
	}

	@Transactional
	public long count(int status) {
		//Get the number of the profiles of the required status
		 long count=0,i=1;
		 Integer temp = new Integer(status);
		 List no = dao.findByProperty(Profiles.class,"status",temp);
		 count = no.size();
		 return count;
	}


	
	

}
