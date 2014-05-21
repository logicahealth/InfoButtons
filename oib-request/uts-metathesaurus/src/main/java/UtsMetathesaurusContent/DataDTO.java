/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah<br>
 * Contact: {@code <andrew.iskander@utah.edu>}<br>
 * Biomedical Informatics<br>
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version May 5, 2014
 */

package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataDTO", propOrder = {
    "classType",
    "handle"
})
@XmlSeeAlso({
    ValueSetDefinitionDTO.class,
    AtomCooccurrenceDTO.class,
    MetathesaurusDataDTO.class
})
public class DataDTO {

    protected String classType;
    protected String handle;

    /**
     * Gets the value of the classType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassType() {
        return classType;
    }

    /**
     * Sets the value of the classType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassType(String value) {
        this.classType = value;
    }

    /**
     * Gets the value of the handle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Sets the value of the handle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandle(String value) {
        this.handle = value;
    }

}
