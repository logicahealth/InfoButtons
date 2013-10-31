
package gov.nih.nlm.uts.webservice.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subsetDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subsetDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}sourceDataDTO">
 *       &lt;sequence>
 *         &lt;element name="atomMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceConceptMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subsetDTO", propOrder = {
    "atomMemberCount",
    "attributeCount",
    "description",
    "name",
    "relationMemberCount",
    "sourceConceptMemberCount"
})
public class SubsetDTO
    extends SourceDataDTO
{

    protected int atomMemberCount;
    protected int attributeCount;
    protected String description;
    protected String name;
    protected int relationMemberCount;
    protected int sourceConceptMemberCount;

    /**
     * Gets the value of the atomMemberCount property.
     * 
     */
    public int getAtomMemberCount() {
        return atomMemberCount;
    }

    /**
     * Sets the value of the atomMemberCount property.
     * 
     */
    public void setAtomMemberCount(int value) {
        this.atomMemberCount = value;
    }

    /**
     * Gets the value of the attributeCount property.
     * 
     */
    public int getAttributeCount() {
        return attributeCount;
    }

    /**
     * Sets the value of the attributeCount property.
     * 
     */
    public void setAttributeCount(int value) {
        this.attributeCount = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the relationMemberCount property.
     * 
     */
    public int getRelationMemberCount() {
        return relationMemberCount;
    }

    /**
     * Sets the value of the relationMemberCount property.
     * 
     */
    public void setRelationMemberCount(int value) {
        this.relationMemberCount = value;
    }

    /**
     * Gets the value of the sourceConceptMemberCount property.
     * 
     */
    public int getSourceConceptMemberCount() {
        return sourceConceptMemberCount;
    }

    /**
     * Sets the value of the sourceConceptMemberCount property.
     * 
     */
    public void setSourceConceptMemberCount(int value) {
        this.sourceConceptMemberCount = value;
    }

}
