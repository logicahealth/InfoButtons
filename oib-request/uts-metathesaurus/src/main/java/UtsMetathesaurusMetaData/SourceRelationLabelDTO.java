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

package UtsMetathesaurusMetaData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceRelationLabelDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceRelationLabelDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalRelationLabel" type="{http://webservice.uts.umls.nlm.nih.gov/}additionalRelationLabelDTO" minOccurs="0"/>
 *         &lt;element name="classType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="domainId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="functional" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverse" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceRelationLabelDTO" minOccurs="0"/>
 *         &lt;element name="inverseFunctional" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="literal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="origValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rangeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationLabel" type="{http://webservice.uts.umls.nlm.nih.gov/}relationLabelDTO" minOccurs="0"/>
 *         &lt;element name="rootSource" type="{http://webservice.uts.umls.nlm.nih.gov/}rootSourceDTO" minOccurs="0"/>
 *         &lt;element name="sourceOriginated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="symmetric" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="transitive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "sourceRelationLabelDTO", propOrder = {
    "additionalRelationLabel",
    "classType",
    "domainId",
    "functional",
    "handle",
    "inverse",
    "inverseFunctional",
    "literal",
    "origValue",
    "rangeId",
    "relationLabel",
    "rootSource",
    "sourceOriginated",
    "symmetric",
    "transitive",
    "versionsAgo"
})
public class SourceRelationLabelDTO {

    protected AdditionalRelationLabelDTO additionalRelationLabel;
    protected String classType;
    protected String domainId;
    protected boolean functional;
    protected String handle;
    protected SourceRelationLabelDTO inverse;
    protected boolean inverseFunctional;
    protected boolean literal;
    protected String origValue;
    protected String rangeId;
    protected RelationLabelDTO relationLabel;
    protected RootSourceDTO rootSource;
    protected boolean sourceOriginated;
    protected boolean symmetric;
    protected boolean transitive;
    protected int versionsAgo;

    /**
     * Gets the value of the additionalRelationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalRelationLabelDTO }
     *     
     */
    public AdditionalRelationLabelDTO getAdditionalRelationLabel() {
        return additionalRelationLabel;
    }

    /**
     * Sets the value of the additionalRelationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalRelationLabelDTO }
     *     
     */
    public void setAdditionalRelationLabel(AdditionalRelationLabelDTO value) {
        this.additionalRelationLabel = value;
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
     * Gets the value of the inverse property.
     * 
     * @return
     *     possible object is
     *     {@link SourceRelationLabelDTO }
     *     
     */
    public SourceRelationLabelDTO getInverse() {
        return inverse;
    }

    /**
     * Sets the value of the inverse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceRelationLabelDTO }
     *     
     */
    public void setInverse(SourceRelationLabelDTO value) {
        this.inverse = value;
    }

    /**
     * Gets the value of the inverseFunctional property.
     * 
     */
    public boolean isInverseFunctional() {
        return inverseFunctional;
    }

    /**
     * Sets the value of the inverseFunctional property.
     * 
     */
    public void setInverseFunctional(boolean value) {
        this.inverseFunctional = value;
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
     * Gets the value of the rangeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRangeId() {
        return rangeId;
    }

    /**
     * Sets the value of the rangeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRangeId(String value) {
        this.rangeId = value;
    }

    /**
     * Gets the value of the relationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link RelationLabelDTO }
     *     
     */
    public RelationLabelDTO getRelationLabel() {
        return relationLabel;
    }

    /**
     * Sets the value of the relationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationLabelDTO }
     *     
     */
    public void setRelationLabel(RelationLabelDTO value) {
        this.relationLabel = value;
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
     * Gets the value of the symmetric property.
     * 
     */
    public boolean isSymmetric() {
        return symmetric;
    }

    /**
     * Sets the value of the symmetric property.
     * 
     */
    public void setSymmetric(boolean value) {
        this.symmetric = value;
    }

    /**
     * Gets the value of the transitive property.
     * 
     */
    public boolean isTransitive() {
        return transitive;
    }

    /**
     * Sets the value of the transitive property.
     * 
     */
    public void setTransitive(boolean value) {
        this.transitive = value;
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
