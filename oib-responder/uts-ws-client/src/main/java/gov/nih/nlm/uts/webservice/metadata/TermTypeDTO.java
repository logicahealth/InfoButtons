
package gov.nih.nlm.uts.webservice.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termTypeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termTypeDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}validDTO">
 *       &lt;sequence>
 *         &lt;element name="codeVariantType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hierarchicalType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameVariantType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="obsolete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sourceTermType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="style" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termTypeDTO", propOrder = {
    "codeVariantType",
    "hierarchicalType",
    "nameVariantType",
    "obsolete",
    "sourceTermType",
    "style",
    "usage"
})
public class TermTypeDTO
    extends ValidDTO
{

    protected String codeVariantType;
    protected String hierarchicalType;
    protected String nameVariantType;
    protected boolean obsolete;
    protected String sourceTermType;
    protected String style;
    protected String usage;

    /**
     * Gets the value of the codeVariantType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeVariantType() {
        return codeVariantType;
    }

    /**
     * Sets the value of the codeVariantType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeVariantType(String value) {
        this.codeVariantType = value;
    }

    /**
     * Gets the value of the hierarchicalType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchicalType() {
        return hierarchicalType;
    }

    /**
     * Sets the value of the hierarchicalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchicalType(String value) {
        this.hierarchicalType = value;
    }

    /**
     * Gets the value of the nameVariantType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameVariantType() {
        return nameVariantType;
    }

    /**
     * Sets the value of the nameVariantType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameVariantType(String value) {
        this.nameVariantType = value;
    }

    /**
     * Gets the value of the obsolete property.
     * 
     */
    public boolean isObsolete() {
        return obsolete;
    }

    /**
     * Sets the value of the obsolete property.
     * 
     */
    public void setObsolete(boolean value) {
        this.obsolete = value;
    }

    /**
     * Gets the value of the sourceTermType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceTermType() {
        return sourceTermType;
    }

    /**
     * Sets the value of the sourceTermType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceTermType(String value) {
        this.sourceTermType = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsage(String value) {
        this.usage = value;
    }

}
