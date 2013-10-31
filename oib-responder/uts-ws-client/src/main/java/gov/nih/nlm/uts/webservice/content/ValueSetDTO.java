
package gov.nih.nlm.uts.webservice.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for valueSetDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="valueSetDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}sourceDataDTO">
 *       &lt;sequence>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="definitionEntryCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dynamicallyBound" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceAtomClusterMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valueSetDTO", propOrder = {
    "attributeCount",
    "definitionEntryCount",
    "description",
    "dynamicallyBound",
    "name",
    "purpose",
    "sourceAtomClusterMemberCount",
    "uri"
})
public class ValueSetDTO
    extends SourceDataDTO
{

    protected int attributeCount;
    protected int definitionEntryCount;
    protected String description;
    protected boolean dynamicallyBound;
    protected String name;
    protected String purpose;
    protected int sourceAtomClusterMemberCount;
    protected String uri;

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
     * Gets the value of the definitionEntryCount property.
     * 
     */
    public int getDefinitionEntryCount() {
        return definitionEntryCount;
    }

    /**
     * Sets the value of the definitionEntryCount property.
     * 
     */
    public void setDefinitionEntryCount(int value) {
        this.definitionEntryCount = value;
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
     * Gets the value of the dynamicallyBound property.
     * 
     */
    public boolean isDynamicallyBound() {
        return dynamicallyBound;
    }

    /**
     * Sets the value of the dynamicallyBound property.
     * 
     */
    public void setDynamicallyBound(boolean value) {
        this.dynamicallyBound = value;
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
     * Gets the value of the purpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurpose(String value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the sourceAtomClusterMemberCount property.
     * 
     */
    public int getSourceAtomClusterMemberCount() {
        return sourceAtomClusterMemberCount;
    }

    /**
     * Sets the value of the sourceAtomClusterMemberCount property.
     * 
     */
    public void setSourceAtomClusterMemberCount(int value) {
        this.sourceAtomClusterMemberCount = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

}
