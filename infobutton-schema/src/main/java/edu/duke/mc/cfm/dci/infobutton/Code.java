package edu.duke.mc.cfm.dci.infobutton;

import org.hl7.v3.CDLite;

/*
$Rev:: 1251          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2010-10-26 1#$:  Date of last commit
*/

public class Code {

	private String code;
	
	private String codeSystem;
	
	private String displayName;
	
	private String codeSystemName;
	
	public Code(String code, String codeSystem, 
			String displayName, String codeSystemName) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayName = displayName;
		this.codeSystemName = codeSystemName;
	}
	
	public Code(CDLite code) {
		
		this(code.getCode(), code.getCodeSystem(), code.getDisplayName(), 
				code.getCodeSystemName());
	}
	
	public Code (Code code) {
		
		this (code.getSearchCode(), code.getCodeSystem(), code.getDisplayName(), code.getCodeSystemName());
	}
	
	public Code() {
		this(new String(), new String(), new String(), new String());
	}
	
	public String getSearchCode () {
		return this.code;
	}

	public String getCodeSystem() {
		return this.codeSystem;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	public String getCodeSystemName() {
		return this.codeSystemName;
	}
	
	public void setSearchCode(String searchCode) {
		this.code = searchCode;
	}
	
	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}
	
	public void setDisplayname(String displayName) {
		this.displayName = displayName;
	}
	
	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}	
	
	public static CDLite getJAXBElement(Code code) {
		CDLite jaxBElement = new CDLite();
		jaxBElement.setCode(code.getSearchCode());
		jaxBElement.setCodeSystem(code.getCodeSystem());
		jaxBElement.setDisplayName(code.getDisplayName());
		jaxBElement.setCodeSystemName(code.getCodeSystemName());
		return jaxBElement;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
