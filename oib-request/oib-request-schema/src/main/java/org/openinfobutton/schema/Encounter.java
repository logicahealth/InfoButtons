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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.REDSMT010001UVEncounter;
import org.hl7.v3.REDSMT010001UVServiceDeliveryLocation;
import org.openinfobutton.schemas.kb.Code;


/*
$Rev:: 1097          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2010-10-01 1#$:  Date of last commit
*/

public class Encounter {
	
	private Code code;
	private IDLite serviceDeliveryLocation;
	
	public Encounter(Code code, IDLite serviceDeliveryLocation) {
		
		this.code = code;
		this.serviceDeliveryLocation = serviceDeliveryLocation;
	}
	
	public Encounter() {
		
		this(CodeUtility.getCode(), new IDLite());
	}
	
	public Encounter(REDSMT010001UVEncounter encounter) {
	
		JAXBElement<REDSMT010001UVServiceDeliveryLocation> element = encounter.getServiceDeliveryLocation();
		REDSMT010001UVServiceDeliveryLocation serviceDeliveryLocation = element.getValue();
		this.code = CodeUtility.getCode(encounter.getCode());
		this.serviceDeliveryLocation = new IDLite(serviceDeliveryLocation.getId());
	}
	
	public Code getCode() {
		
		return this.code;
	}
	
	public IDLite getServiceDeliveryLocation() {
		
		return this.serviceDeliveryLocation;
	}
	
	public void setCode(Code code) {
		
		this.code = code;
	}
	
	public void setServiceDeliveryLocation(IDLite serviceDeliveryLocation) {
		
		this.serviceDeliveryLocation = serviceDeliveryLocation;
	}
	
	public static JAXBElement<REDSMT010001UVEncounter> getJAXBElement(Encounter encounter) {
		
		REDSMT010001UVEncounter element = new REDSMT010001UVEncounter();
		element.setCode(CodeUtility.getJAXBElement(encounter.getCode()));
		REDSMT010001UVServiceDeliveryLocation serviceDeliveryLocation = new REDSMT010001UVServiceDeliveryLocation();
		serviceDeliveryLocation.setId(IDLite.getJAXBElement(encounter.getServiceDeliveryLocation()));
		JAXBElement<REDSMT010001UVServiceDeliveryLocation> sdl = new JAXBElement<REDSMT010001UVServiceDeliveryLocation>(new QName("urn:hl7-org:v3", "serviceDeliveryLocation"), 
				REDSMT010001UVServiceDeliveryLocation.class, serviceDeliveryLocation);
		element.setServiceDeliveryLocation(sdl);
		JAXBElement<REDSMT010001UVEncounter> jaxBElement = new JAXBElement<REDSMT010001UVEncounter>(new QName("urn:hl7-org:v3", "encounter"), 
				REDSMT010001UVEncounter.class, element);
		return jaxBElement;
	}
}
