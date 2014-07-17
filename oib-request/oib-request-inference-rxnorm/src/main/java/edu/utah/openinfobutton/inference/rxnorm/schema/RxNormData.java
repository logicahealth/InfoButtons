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
 * @version Jul 15, 2014
 */
package edu.utah.openinfobutton.inference.rxnorm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class RxNormData.
 */
@XmlRootElement( namespace = "", name = "rxnormdata" )
@XmlType( name = "" )
@XmlAccessorType( XmlAccessType.FIELD )
public class RxNormData
{
    
    /** The related group. */
    @XmlElement( name = "relatedGroup", required = false )
    private RelatedGroup relatedGroup;

    /** The approx group. */
    @XmlElement( name = "approxGroup", required = false )
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
    public void setRelatedGroup( RelatedGroup relatedGroup )
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
    public void setApproxGroup( ApproxGroup approxGroup )
    {
        this.approxGroup = approxGroup;
    }
}
