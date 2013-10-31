
package UtsMetathesaurusHistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conceptBequeathalDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conceptBequeathalDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}conceptDeathDTO">
 *       &lt;sequence>
 *         &lt;element name="additionalLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedConceptUi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conceptBequeathalDTO", propOrder = {
    "additionalLabel",
    "label",
    "relatedConceptUi"
})
public class ConceptBequeathalDTO
    extends ConceptDeathDTO
{

    protected String additionalLabel;
    protected String label;
    protected String relatedConceptUi;

    /**
     * Gets the value of the additionalLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalLabel() {
        return additionalLabel;
    }

    /**
     * Sets the value of the additionalLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalLabel(String value) {
        this.additionalLabel = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the relatedConceptUi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedConceptUi() {
        return relatedConceptUi;
    }

    /**
     * Sets the value of the relatedConceptUi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedConceptUi(String value) {
        this.relatedConceptUi = value;
    }

}
