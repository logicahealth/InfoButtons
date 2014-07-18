
package gov.nih.nlm.uts.webservice.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mapsetDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mapsetDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}sourceDataDTO">
 *       &lt;sequence>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="complexity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromComplexity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromExhaustive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromRootSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mappingCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="separatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toComplexity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toExhaustive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toNullObject" type="{http://webservice.uts.umls.nlm.nih.gov/}mapObjectDTO" minOccurs="0"/>
 *         &lt;element name="toRootSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="umlsSeparator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mapsetDTO", propOrder = {
    "attributeCount",
    "complexity",
    "fromComplexity",
    "fromExhaustive",
    "fromRootSource",
    "fromSource",
    "mappingCount",
    "name",
    "separatorCode",
    "toComplexity",
    "toExhaustive",
    "toNullObject",
    "toRootSource",
    "toSource",
    "type",
    "umlsSeparator",
    "version"
})
public class MapsetDTO
    extends SourceDataDTO
{

    protected int attributeCount;
    protected String complexity;
    protected String fromComplexity;
    protected String fromExhaustive;
    protected String fromRootSource;
    protected String fromSource;
    protected int mappingCount;
    protected String name;
    protected String separatorCode;
    protected String toComplexity;
    protected String toExhaustive;
    protected MapObjectDTO toNullObject;
    protected String toRootSource;
    protected String toSource;
    protected String type;
    protected String umlsSeparator;
    protected String version;

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
     * Gets the value of the complexity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplexity() {
        return complexity;
    }

    /**
     * Sets the value of the complexity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplexity(String value) {
        this.complexity = value;
    }

    /**
     * Gets the value of the fromComplexity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromComplexity() {
        return fromComplexity;
    }

    /**
     * Sets the value of the fromComplexity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromComplexity(String value) {
        this.fromComplexity = value;
    }

    /**
     * Gets the value of the fromExhaustive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromExhaustive() {
        return fromExhaustive;
    }

    /**
     * Sets the value of the fromExhaustive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromExhaustive(String value) {
        this.fromExhaustive = value;
    }

    /**
     * Gets the value of the fromRootSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromRootSource() {
        return fromRootSource;
    }

    /**
     * Sets the value of the fromRootSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromRootSource(String value) {
        this.fromRootSource = value;
    }

    /**
     * Gets the value of the fromSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromSource() {
        return fromSource;
    }

    /**
     * Sets the value of the fromSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromSource(String value) {
        this.fromSource = value;
    }

    /**
     * Gets the value of the mappingCount property.
     * 
     */
    public int getMappingCount() {
        return mappingCount;
    }

    /**
     * Sets the value of the mappingCount property.
     * 
     */
    public void setMappingCount(int value) {
        this.mappingCount = value;
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
     * Gets the value of the separatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeparatorCode() {
        return separatorCode;
    }

    /**
     * Sets the value of the separatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeparatorCode(String value) {
        this.separatorCode = value;
    }

    /**
     * Gets the value of the toComplexity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToComplexity() {
        return toComplexity;
    }

    /**
     * Sets the value of the toComplexity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToComplexity(String value) {
        this.toComplexity = value;
    }

    /**
     * Gets the value of the toExhaustive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToExhaustive() {
        return toExhaustive;
    }

    /**
     * Sets the value of the toExhaustive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToExhaustive(String value) {
        this.toExhaustive = value;
    }

    /**
     * Gets the value of the toNullObject property.
     * 
     * @return
     *     possible object is
     *     {@link MapObjectDTO }
     *     
     */
    public MapObjectDTO getToNullObject() {
        return toNullObject;
    }

    /**
     * Sets the value of the toNullObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapObjectDTO }
     *     
     */
    public void setToNullObject(MapObjectDTO value) {
        this.toNullObject = value;
    }

    /**
     * Gets the value of the toRootSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToRootSource() {
        return toRootSource;
    }

    /**
     * Sets the value of the toRootSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToRootSource(String value) {
        this.toRootSource = value;
    }

    /**
     * Gets the value of the toSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSource() {
        return toSource;
    }

    /**
     * Sets the value of the toSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSource(String value) {
        this.toSource = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the umlsSeparator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmlsSeparator() {
        return umlsSeparator;
    }

    /**
     * Sets the value of the umlsSeparator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmlsSeparator(String value) {
        this.umlsSeparator = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
