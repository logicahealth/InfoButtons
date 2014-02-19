package edu.utah.further.subsetdb.service;



import edu.utah.further.core.api.context.Api;



@Api
public interface LogsDao {
		
	public String saveRequest(String req,String clip,String org,String origParams);
	
	
}
