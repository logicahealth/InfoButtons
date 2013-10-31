
package gov.nih.nlm.uts.webservice.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProxyTicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProxyTicket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TGT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProxyTicket", propOrder = {
    "tgt",
    "service"
})
public class GetProxyTicket {

    @XmlElement(name = "TGT")
    protected String tgt;
    protected String service;

    /**
     * Gets the value of the tgt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTGT() {
        return tgt;
    }

    /**
     * Sets the value of the tgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTGT(String value) {
        this.tgt = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

}
