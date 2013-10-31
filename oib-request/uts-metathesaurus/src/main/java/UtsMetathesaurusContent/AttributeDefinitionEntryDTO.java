
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for attributeDefinitionEntryDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="attributeDefinitionEntryDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}valueSetDefinitionDTO">
 *       &lt;sequence>
 *         &lt;element name="atn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attributeDefinitionEntryDTO", propOrder = {
    "atn",
    "matchText",
    "matchType"
})
public class AttributeDefinitionEntryDTO
    extends ValueSetDefinitionDTO
{

    protected String atn;
    protected String matchText;
    protected String matchType;

    /**
     * Gets the value of the atn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtn() {
        return atn;
    }

    /**
     * Sets the value of the atn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtn(String value) {
        this.atn = value;
    }

    /**
     * Gets the value of the matchText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchText() {
        return matchText;
    }

    /**
     * Sets the value of the matchText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchText(String value) {
        this.matchText = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchType(String value) {
        this.matchType = value;
    }

}
