package edu.duke.mc.cfm.dci.infobutton;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;

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
