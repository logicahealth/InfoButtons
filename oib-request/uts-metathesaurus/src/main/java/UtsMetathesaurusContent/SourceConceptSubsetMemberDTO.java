
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceConceptSubsetMemberDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceConceptSubsetMemberDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}subsetMemberDTO">
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
@XmlType(name = "sourceConceptSubsetMemberDTO", propOrder = {
    "sourceConcept"
})
public class SourceConceptSubsetMemberDTO
    extends SubsetMemberDTO
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
