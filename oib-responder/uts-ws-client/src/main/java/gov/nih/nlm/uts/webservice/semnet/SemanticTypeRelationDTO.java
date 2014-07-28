
package gov.nih.nlm.uts.webservice.semnet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for semanticTypeRelationDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="semanticTypeRelationDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="classType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defined" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inherited" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="relatedSemanticType" type="{http://webservice.uts.umls.nlm.nih.gov/}semanticTypeDTO" minOccurs="0"/>
 *         &lt;element name="relationLabel" type="{http://webservice.uts.umls.nlm.nih.gov/}semanticNetworkRelationLabelDTO" minOccurs="0"/>
 *         &lt;element name="semanticType" type="{http://webservice.uts.umls.nlm.nih.gov/}semanticTypeDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "semanticTypeRelationDTO", propOrder = {
    "blocked",
    "classType",
    "defined",
    "handle",
    "inherited",
    "relatedSemanticType",
    "relationLabel",
    "semanticType"
})
public class SemanticTypeRelationDTO {

    protected boolean blocked;
    protected String classType;
    protected boolean defined;
    protected String handle;
    protected boolean inherited;
    protected SemanticTypeDTO relatedSemanticType;
    protected SemanticNetworkRelationLabelDTO relationLabel;
    protected SemanticTypeDTO semanticType;

    /**
     * Gets the value of the blocked property.
     * 
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     */
    public void setBlocked(boolean value) {
        this.blocked = value;
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
     * Gets the value of the defined property.
     * 
     */
    public boolean isDefined() {
        return defined;
    }

    /**
     * Sets the value of the defined property.
     * 
     */
    public void setDefined(boolean value) {
        this.defined = value;
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
     * Gets the value of the inherited property.
     * 
     */
    public boolean isInherited() {
        return inherited;
    }

    /**
     * Sets the value of the inherited property.
     * 
     */
    public void setInherited(boolean value) {
        this.inherited = value;
    }

    /**
     * Gets the value of the relatedSemanticType property.
     * 
     * @return
     *     possible object is
     *     {@link SemanticTypeDTO }
     *     
     */
    public SemanticTypeDTO getRelatedSemanticType() {
        return relatedSemanticType;
    }

    /**
     * Sets the value of the relatedSemanticType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SemanticTypeDTO }
     *     
     */
    public void setRelatedSemanticType(SemanticTypeDTO value) {
        this.relatedSemanticType = value;
    }

    /**
     * Gets the value of the relationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link SemanticNetworkRelationLabelDTO }
     *     
     */
    public SemanticNetworkRelationLabelDTO getRelationLabel() {
        return relationLabel;
    }

    /**
     * Sets the value of the relationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link SemanticNetworkRelationLabelDTO }
     *     
     */
    public void setRelationLabel(SemanticNetworkRelationLabelDTO value) {
        this.relationLabel = value;
    }

    /**
     * Gets the value of the semanticType property.
     * 
     * @return
     *     possible object is
     *     {@link SemanticTypeDTO }
     *     
     */
    public SemanticTypeDTO getSemanticType() {
        return semanticType;
    }

    /**
     * Sets the value of the semanticType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SemanticTypeDTO }
     *     
     */
    public void setSemanticType(SemanticTypeDTO value) {
        this.semanticType = value;
    }

}
