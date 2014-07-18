
package gov.nih.nlm.uts.webservice.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relationLabelDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relationLabelDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}validDTO">
 *       &lt;sequence>
 *         &lt;element name="inverse" type="{http://webservice.uts.umls.nlm.nih.gov/}relationLabelDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relationLabelDTO", propOrder = {
    "inverse"
})
public class RelationLabelDTO
    extends ValidDTO
{

    protected RelationLabelDTO inverse;

    /**
     * Gets the value of the inverse property.
     * 
     * @return
     *     possible object is
     *     {@link RelationLabelDTO }
     *     
     */
    public RelationLabelDTO getInverse() {
        return inverse;
    }

    /**
     * Sets the value of the inverse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationLabelDTO }
     *     
     */
    public void setInverse(RelationLabelDTO value) {
        this.inverse = value;
    }

}
