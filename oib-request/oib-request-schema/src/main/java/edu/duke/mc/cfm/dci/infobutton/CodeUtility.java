package edu.duke.mc.cfm.dci.infobutton;
import org.hl7.v3.CDLite;
import org.hl7.v3.CategoryType;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
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
