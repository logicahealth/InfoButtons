
package UtsMetathesaurusMetaData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceAttributeNameDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceAttributeNameDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attributeName" type="{http://webservice.uts.umls.nlm.nih.gov/}attributeNameDTO" minOccurs="0"/>
 *         &lt;element name="classType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="domainId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="functional" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="literal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="origValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rootSource" type="{http://webservice.uts.umls.nlm.nih.gov/}rootSourceDTO" minOccurs="0"/>
 *         &lt;element name="sourceOriginated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceAttributeNameDTO", propOrder = {
    "attributeName",
    "classType",
    "domainId",
    "functional",
    "handle",
    "literal",
    "origValue",
    "rootSource",
    "sourceOriginated"
})
public class SourceAttributeNameDTO {

    protected AttributeNameDTO attributeName;
    protected String classType;
    protected String domainId;
    protected boolean functional;
    protected String handle;
    protected boolean literal;
    protected String origValue;
    protected RootSourceDTO rootSource;
    protected boolean sourceOriginated;

    /**
     * Gets the value of the attributeName property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeNameDTO }
     *     
     */
    public AttributeNameDTO getAttributeName() {
        return attributeName;
    }

    /**
     * Sets the value of the attributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeNameDTO }
     *     
     */
    public void setAttributeName(AttributeNameDTO value) {
        this.attributeName = value;
    }

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
     * Gets the value of the domainId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * Sets the value of the domainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainId(String value) {
        this.domainId = value;
    }

    /**
     * Gets the value of the functional property.
     * 
     */
    public boolean isFunctional() {
        return functional;
    }

    /**
     * Sets the value of the functional property.
     * 
     */
    public void setFunctional(boolean value) {
        this.functional = value;
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

    /**
     * Gets the value of the literal property.
     * 
     */
    public boolean isLiteral() {
        return literal;
    }

    /**
     * Sets the value of the literal property.
     * 
     */
    public void setLiteral(boolean value) {
        this.literal = value;
    }

    /**
     * Gets the value of the origValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigValue() {
        return origValue;
    }

    /**
     * Sets the value of the origValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigValue(String value) {
        this.origValue = value;
    }

    /**
     * Gets the value of the rootSource property.
     * 
     * @return
     *     possible object is
     *     {@link RootSourceDTO }
     *     
     */
    public RootSourceDTO getRootSource() {
        return rootSource;
    }

    /**
     * Sets the value of the rootSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link RootSourceDTO }
     *     
     */
    public void setRootSource(RootSourceDTO value) {
        this.rootSource = value;
    }

    /**
     * Gets the value of the sourceOriginated property.
     * 
     */
    public boolean isSourceOriginated() {
        return sourceOriginated;
    }

    /**
     * Sets the value of the sourceOriginated property.
     * 
     */
    public void setSourceOriginated(boolean value) {
        this.sourceOriginated = value;
    }

}
