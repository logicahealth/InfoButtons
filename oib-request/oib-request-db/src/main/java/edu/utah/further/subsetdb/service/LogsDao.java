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
package edu.utah.further.subsetdb.service;


import edu.utah.further.core.api.context.Api;
//TODO: Auto-generated Javadoc
/**
* The Interface LogsDao.
*/
@Api
public interface LogsDao
{

 /**
  * Save request.
  *
  * @param req the req
  * @param clip the clip
  * @param org the org
  */
	public String saveRequest(String req,String clip,String org,String origParams);
	
	
}