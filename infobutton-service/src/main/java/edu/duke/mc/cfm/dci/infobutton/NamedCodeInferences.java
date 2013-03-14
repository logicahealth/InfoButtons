/*******************************************************************************
 * Source File: NamedCodeInferences.java
 ******************************************************************************/
package edu.duke.mc.cfm.dci.infobutton;

import java.io.IOException;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
import edu.utah.openinfobutton.inference.rxnorm.service.RxNormService;

/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2012 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Aug 13, 2012
 */
public enum NamedCodeInferences
{
	getRxNormCode
	{
		@Override
		public Code getCodeFromDisplayName(final Code code)
		{
				try
				{
					return RxNormService.getCode(code);
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					return code;
				}
		}
				
	};
	
	public abstract Code getCodeFromDisplayName(final Code code);
}
