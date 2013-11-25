
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relationDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relationDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}sourceDataDTO">
 *       &lt;sequence>
 *         &lt;element name="additionalRelationLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assertedDirection" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cvMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="relationLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subsetMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relationDTO", propOrder = {
    "additionalRelationLabel",
    "assertedDirection",
    "attributeCount",
    "cvMemberCount",
    "groupId",
    "relationCount",
    "relationLabel",
    "subsetMemberCount"
})
@XmlSeeAlso({
    AtomClusterRelationDTO.class,
    ConceptRelationDTO.class,
    AtomRelationDTO.class
})
public class RelationDTO
    extends SourceDataDTO
{

    protected String additionalRelationLabel;
    protected boolean assertedDirection;
    protected int attributeCount;
    protected int cvMemberCount;
    protected String groupId;
    protected int relationCount;
    protected String relationLabel;
    protected int subsetMemberCount;

    /**
     * Gets the value of the additionalRelationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalRelationLabel() {
        return additionalRelationLabel;
    }

    /**
     * Sets the value of the additionalRelationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalRelationLabel(String value) {
        this.additionalRelationLabel = value;
    }

    /**
     * Gets the value of the assertedDirection property.
     * 
     */
    public boolean isAssertedDirection() {
        return assertedDirection;
    }

    /**
     * Sets the value of the assertedDirection property.
     * 
     */
    public void setAssertedDirection(boolean value) {
        this.assertedDirection = value;
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
     * Gets the value of the cvMemberCount property.
     * 
     */
    public int getCvMemberCount() {
        return cvMemberCount;
    }

    /**
     * Sets the value of the cvMemberCount property.
     * 
     */
    public void setCvMemberCount(int value) {
        this.cvMemberCount = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the relationCount property.
     * 
     */
    public int getRelationCount() {
        return relationCount;
    }

    /**
     * Sets the value of the relationCount property.
     * 
     */
    public void setRelationCount(int value) {
        this.relationCount = value;
    }

    /**
     * Gets the value of the relationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationLabel() {
        return relationLabel;
    }

    /**
     * Sets the value of the relationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationLabel(String value) {
        this.relationLabel = value;
    }

    /**
     * Gets the value of the subsetMemberCount property.
     * 
     */
    public int getSubsetMemberCount() {
        return subsetMemberCount;
    }

    /**
     * Sets the value of the subsetMemberCount property.
     * 
     */
    public void setSubsetMemberCount(int value) {
        this.subsetMemberCount = value;
    }

}
