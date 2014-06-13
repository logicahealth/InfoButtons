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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.CategoryType;
import org.hl7.v3.EDLite;
import org.hl7.v3.IILite;
import org.hl7.v3.REDSMT010001UVAssignedEntity;
import org.hl7.v3.REDSMT010001UVAuthorizedPerson;
import org.hl7.v3.REDSMT010001UVHolder;
import org.hl7.v3.REDSMT010001UVOrganization;
import org.hl7.v3.REDSMT010001UVPatientContext;
import org.hl7.v3.STLite;

/*
$Rev:: 1097          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2010-10-01 1#$:  Date of last commit
*/

public class Holder {
	
	private String name;
	
	private String certificateText;
	
	private IDLite assignedAuthorizedPerson;
	
	private IDLite representedOrganization;
	
	List<CategoryType> category;
	
	public Holder(String name, String certificateText, 
			IDLite assignedAuthorizedPerson, IDLite representedOrganization) {
		
		this.name = name;
		this.certificateText = certificateText;
		this.assignedAuthorizedPerson = assignedAuthorizedPerson;
		this.representedOrganization = representedOrganization;
		category = new ArrayList<CategoryType>();
	}
	
	public Holder() {
		
		this(new String(), new String(), new IDLite(), new IDLite());
	}
	
	public Holder(REDSMT010001UVHolder holder) {
		
		REDSMT010001UVAssignedEntity assignedEntity = holder.getAssignedEntity();
		this.name = assignedEntity.getName().getContent();
		this.certificateText = assignedEntity.getCertificateText().getContent();
		this.assignedAuthorizedPerson = new IDLite(assignedEntity.getAssignedAuthorizedPerson()
				.getValue().getId().get(0));
		this.representedOrganization = new IDLite(assignedEntity.getRepresentedOrganization()
				.getValue().getId().get(0));
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public String getCertificateText() {
		
		return this.certificateText;
	}
	
	public IDLite getAssignedAuthorizedPerson() {
		
		return this.assignedAuthorizedPerson;
	}
	
	public IDLite getRepresentedOrganization() {
		
		return this.representedOrganization;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setCertificateText(String certificateText) {
		
		this.certificateText = certificateText;
		CategoryType c = new CategoryType();
		c.setTerm(certificateText);
		c.setScheme(CodeConstants.HOLDER_CERTIFICATETEXT);
		category.add(c);
	}
	
	public void setAssignedAuthorizedPerson(IDLite assignedAuthorizedPerson) {
		
		this.assignedAuthorizedPerson = assignedAuthorizedPerson;
	}
	
	public void setRepresentedOrganization(IDLite representedOrganization) {
		
		this.representedOrganization = representedOrganization;
	}
	
	
	public List<CategoryType> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryType> category) {
		this.category = category;
	}

	public static JAXBElement<REDSMT010001UVHolder> getJAXBElement(Holder holder) {
		
		REDSMT010001UVHolder element = new REDSMT010001UVHolder();
		REDSMT010001UVAssignedEntity assignedEntity = new REDSMT010001UVAssignedEntity();
		REDSMT010001UVAuthorizedPerson authorizedPerson = new REDSMT010001UVAuthorizedPerson();
		REDSMT010001UVOrganization authorizedOrganization = new REDSMT010001UVOrganization();
		STLite name = new STLite();
		name.setContent(holder.getName());
		assignedEntity.setName(name);
		EDLite certificateText = new EDLite();
		certificateText.setContent(holder.getCertificateText());
		assignedEntity.setCertificateText(certificateText);
		authorizedPerson.getId().add(IDLite.getJAXBElement(holder.getAssignedAuthorizedPerson()));
		assignedEntity.setAssignedAuthorizedPerson(new JAXBElement<REDSMT010001UVAuthorizedPerson>(new QName("urn:hl7-org:v3", "assignedAuthorizedPerson"), 
				REDSMT010001UVAuthorizedPerson.class, authorizedPerson));
		authorizedOrganization.getId().add(IDLite.getJAXBElement(holder.getRepresentedOrganization()));
		assignedEntity.setRepresentedOrganization(new JAXBElement<REDSMT010001UVOrganization>(new QName("urn:hl7-org:v3", "representedOrganization"), 
				REDSMT010001UVOrganization.class, authorizedOrganization));
		element.setAssignedEntity(assignedEntity);
		JAXBElement<REDSMT010001UVHolder> jaxBElement = new JAXBElement<REDSMT010001UVHolder>(new QName("urn:hl7-org:v3", "holder"), 
				REDSMT010001UVHolder.class, element);
		return jaxBElement;		
	}
}
