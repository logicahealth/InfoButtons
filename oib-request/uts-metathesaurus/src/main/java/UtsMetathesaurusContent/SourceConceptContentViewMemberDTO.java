
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceConceptContentViewMemberDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceConceptContentViewMemberDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}contentViewMemberDTO">
 *       &lt;sequence>
 *         &lt;element name="sourceConcept" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceAtomClusterDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceConceptContentViewMemberDTO", propOrder = {
    "sourceConcept"
})
public class SourceConceptContentViewMemberDTO
    extends ContentViewMemberDTO
{

    protected SourceAtomClusterDTO sourceConcept;

    /**
     * Gets the value of the sourceConcept property.
     * 
     * @return
     *     possible object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public SourceAtomClusterDTO getSourceConcept() {
        return sourceConcept;
    }

    /**
     * Sets the value of the sourceConcept property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public void setSourceConcept(SourceAtomClusterDTO value) {
        this.sourceConcept = value;
    }

}
