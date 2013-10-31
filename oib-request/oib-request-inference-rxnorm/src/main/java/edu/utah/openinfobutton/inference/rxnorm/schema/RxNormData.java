/*******************************************************************************
 * Source File: RxNormData.java
 ******************************************************************************/
package edu.utah.openinfobutton.inference.rxnorm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
@XmlRootElement(namespace="", name="rxnormdata")
@XmlType(name="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RxNormData
{
	@XmlElement(name="relatedGroup", required=false)
	private RelatedGroup relatedGroup;
	
	@XmlElement(name="approxGroup", required=false)
	private ApproxGroup approxGroup;
	
	/**
	 * Return the relatedGroup property.
	 *
	 * @return the relatedGroup
	 */
	public RelatedGroup getRelatedGroup()
	{
		return relatedGroup;
	}

	/**
	 * Set a new value for the relatedGroup property.
	 *
	 * @param relatedGroup the relatedGroup to set
	 */
	public void setRelatedGroup(RelatedGroup relatedGroup)
	{
		this.relatedGroup = relatedGroup;
	}

	/**
	 * Return the approxGroup property.
	 *
	 * @return the approxGroup
	 */
	public ApproxGroup getApproxGroup()
	{
		return approxGroup;
	}

	/**
	 * Set a new value for the approxGroup property.
	 *
	 * @param approxGroup the approxGroup to set
	 */
	public void setApproxGroup(ApproxGroup approxGroup)
	{
		this.approxGroup = approxGroup;
	}
}
