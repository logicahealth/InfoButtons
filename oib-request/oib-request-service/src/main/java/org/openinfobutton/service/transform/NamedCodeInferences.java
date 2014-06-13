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
 * @version Jun 13, 2014
 */
package org.openinfobutton.service.transform;

import java.io.IOException;

import org.openinfobutton.schemas.kb.Code;

import edu.utah.openinfobutton.inference.rxnorm.service.RxNormService;

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
