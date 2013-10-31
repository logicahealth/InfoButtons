
package gov.nih.nlm.uts.webservice.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for completeValueSetDefinitionEntryDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="completeValueSetDefinitionEntryDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}valueSetDefinitionDTO">
 *       &lt;sequence>
 *         &lt;element name="valueSet" type="{http://webservice.uts.umls.nlm.nih.gov/}valueSetDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "completeValueSetDefinitionEntryDTO", propOrder = {
    "valueSet"
})
public class CompleteValueSetDefinitionEntryDTO
    extends ValueSetDefinitionDTO
{

    protected ValueSetDTO valueSet;

    /**
     * Gets the value of the valueSet property.
     * 
     * @return
     *     possible object is
     *     {@link ValueSetDTO }
     *     
     */
    public ValueSetDTO getValueSet() {
        return valueSet;
    }

    /**
     * Sets the value of the valueSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueSetDTO }
     *     
     */
    public void setValueSet(ValueSetDTO value) {
        this.valueSet = value;
    }

}
