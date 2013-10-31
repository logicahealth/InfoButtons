
package gov.nih.nlm.uts.webservice.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCooccurrenceTypeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCooccurrenceTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.uts.umls.nlm.nih.gov/}cooccurrenceTypeDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCooccurrenceTypeResponse", propOrder = {
    "_return"
})
public class GetCooccurrenceTypeResponse {

    @XmlElement(name = "return")
    protected CooccurrenceTypeDTO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link CooccurrenceTypeDTO }
     *     
     */
    public CooccurrenceTypeDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link CooccurrenceTypeDTO }
     *     
     */
    public void setReturn(CooccurrenceTypeDTO value) {
        this._return = value;
    }

}
