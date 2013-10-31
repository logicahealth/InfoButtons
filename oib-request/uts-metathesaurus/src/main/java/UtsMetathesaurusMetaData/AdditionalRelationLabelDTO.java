
package UtsMetathesaurusMetaData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for additionalRelationLabelDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="additionalRelationLabelDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}validDTO">
 *       &lt;sequence>
 *         &lt;element name="inverse" type="{http://webservice.uts.umls.nlm.nih.gov/}additionalRelationLabelDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "additionalRelationLabelDTO", propOrder = {
    "inverse"
})
public class AdditionalRelationLabelDTO
    extends ValidDTO
{

    protected AdditionalRelationLabelDTO inverse;

    /**
     * Gets the value of the inverse property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalRelationLabelDTO }
     *     
     */
    public AdditionalRelationLabelDTO getInverse() {
        return inverse;
    }

    /**
     * Sets the value of the inverse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalRelationLabelDTO }
     *     
     */
    public void setInverse(AdditionalRelationLabelDTO value) {
        this.inverse = value;
    }

}
