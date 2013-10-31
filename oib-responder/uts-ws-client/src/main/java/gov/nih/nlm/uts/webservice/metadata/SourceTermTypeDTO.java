
package gov.nih.nlm.uts.webservice.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceTermTypeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceTermTypeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="literal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="origValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rootSource" type="{http://webservice.uts.umls.nlm.nih.gov/}rootSourceDTO" minOccurs="0"/>
 *         &lt;element name="sourceOriginated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="suppressible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="termType" type="{http://webservice.uts.umls.nlm.nih.gov/}termTypeDTO" minOccurs="0"/>
 *         &lt;element name="versionsAgo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceTermTypeDTO", propOrder = {
    "classType",
    "handle",
    "literal",
    "origValue",
    "rootSource",
    "sourceOriginated",
    "suppressible",
    "termType",
    "versionsAgo"
})
public class SourceTermTypeDTO {

    protected String classType;
    protected String handle;
    protected boolean literal;
    protected String origValue;
    protected RootSourceDTO rootSource;
    protected boolean sourceOriginated;
    protected boolean suppressible;
    protected TermTypeDTO termType;
    protected int versionsAgo;

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

    /**
     * Gets the value of the suppressible property.
     * 
     */
    public boolean isSuppressible() {
        return suppressible;
    }

    /**
     * Sets the value of the suppressible property.
     * 
     */
    public void setSuppressible(boolean value) {
        this.suppressible = value;
    }

    /**
     * Gets the value of the termType property.
     * 
     * @return
     *     possible object is
     *     {@link TermTypeDTO }
     *     
     */
    public TermTypeDTO getTermType() {
        return termType;
    }

    /**
     * Sets the value of the termType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermTypeDTO }
     *     
     */
    public void setTermType(TermTypeDTO value) {
        this.termType = value;
    }

    /**
     * Gets the value of the versionsAgo property.
     * 
     */
    public int getVersionsAgo() {
        return versionsAgo;
    }

    /**
     * Sets the value of the versionsAgo property.
     * 
     */
    public void setVersionsAgo(int value) {
        this.versionsAgo = value;
    }

}
