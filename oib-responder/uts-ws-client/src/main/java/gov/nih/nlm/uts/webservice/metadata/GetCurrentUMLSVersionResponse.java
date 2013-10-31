
package gov.nih.nlm.uts.webservice.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCurrentUMLSVersionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCurrentUMLSVersionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCurrentUMLSVersionResponse", propOrder = {
    "_return"
})
public class GetCurrentUMLSVersionResponse {

    @XmlElement(name = "return")
    protected String _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturn(String value) {
        this._return = value;
    }

}
