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
package org.openinfobutton.schema;
import org.hl7.v3.CDLite;
import org.hl7.v3.CategoryType;
import org.openinfobutton.schemas.kb.Code;

public class CodeUtility {

	public static Code getCode()
	{
		Code c = new Code();
		c.setCode("");
		c.setCodeSystem("");
		c.setCodeSystemName("");
		c.setDisplayName("");
		return c;
	}
	public static Code getCode(CDLite cd) {
		Code c = new Code();
		c.setCode(cd.getCode());
		c.setCodeSystem(cd.getCodeSystem());
		c.setCodeSystemName(cd.getCodeSystemName());
		c.setDisplayName(cd.getDisplayName());
		return c;
	}

	public static Code getCode(String code, String codeSystem,
			String displayName, String codeSystemName) {
		Code c = new Code();
		c.setCode(code);
		c.setCodeSystem(codeSystem);
		c.setCodeSystemName(codeSystemName);
		c.setDisplayName(displayName);
		return c;
	}

	public static Code getCode(Code cd)
	{
		Code c = new Code();
		c.setCode(cd.getCode());
		c.setCodeSystem(cd.getCodeSystem());
		c.setCodeSystemName(cd.getCodeSystemName());
		c.setDisplayName(cd.getDisplayName());
		return c;
	}
	public static CDLite getJAXBElement(Code code) {
		CDLite jaxBElementCDLite = new CDLite();
		jaxBElementCDLite.setCode(code.getCode());
		jaxBElementCDLite.setCodeSystem(code.getCodeSystem());
		jaxBElementCDLite.setDisplayName(code.getDisplayName());
		jaxBElementCDLite.setCodeSystemName(code.getCodeSystemName());
		return jaxBElementCDLite;
	}
	
   public static CategoryType convertIntoCategoryType(String term,String scheme)
   {
	   CategoryType c = new CategoryType();
	   c.setTerm(term);
	   c.setScheme(scheme);
	   return c;
   }
}
