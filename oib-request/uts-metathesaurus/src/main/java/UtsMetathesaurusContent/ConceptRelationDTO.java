
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conceptRelationDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conceptRelationDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}relationDTO">
 *       &lt;sequence>
 *         &lt;element name="relatedConcept" type="{http://webservice.uts.umls.nlm.nih.gov/}conceptDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conceptRelationDTO", propOrder = {
    "relatedConcept"
})
public class ConceptRelationDTO
    extends RelationDTO
{

    protected ConceptDTO relatedConcept;

    /**
     * Gets the value of the relatedConcept property.
     * 
     * @return
     *     possible object is
     *     {@link ConceptDTO }
     *     
     */
    public ConceptDTO getRelatedConcept() {
        return relatedConcept;
    }

    /**
     * Sets the value of the relatedConcept property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConceptDTO }
     *     
     */
    public void setRelatedConcept(ConceptDTO value) {
        this.relatedConcept = value;
    }

}
