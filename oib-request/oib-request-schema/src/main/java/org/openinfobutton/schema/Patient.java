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

import org.openinfobutton.schemas.kb.Code;

public class Patient {
	
	private Code gender;
	
	private Code ageGroup;
	
	private Float age;
	
	
	
	public Patient (Code gender, Code ageGroup, 
			Float age) {
		
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.age = age;
		
	}
	
	public Patient () {
		
		this(CodeUtility.getCode(), CodeUtility.getCode(), new Float(0));
	}
	
	public Code getGender() {
		
		return this.gender;
	}
	
	public Code getAgeGroup() {
		
		return this.ageGroup;
	}
	
	public Float getAge() {
		
		return this.age;
	}
	
	public void setGender(Code gender) {
		
		this.gender = gender;
		
	}
	
	public void setAgeGroup(Code ageGroup) {
		
		this.ageGroup = ageGroup;
	}
	
	public void setAge(Float age) {
		
		this.age = age;
	}
	
}
