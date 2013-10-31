
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSourceDescriptorDefinitions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSourceDescriptorDefinitions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ticket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceDescriptor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rootSourceAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psf" type="{http://webservice.uts.umls.nlm.nih.gov/}psf" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSourceDescriptorDefinitions", propOrder = {
    "ticket",
    "version",
    "sourceDescriptor",
    "rootSourceAbbreviation",
    "psf"
})
public class GetSourceDescriptorDefinitions {

    protected String ticket;
    protected String version;
    protected String sourceDescriptor;
    protected String rootSourceAbbreviation;
    protected Psf psf;

    /**
     * Gets the value of the ticket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * Sets the value of the ticket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicket(String value) {
        this.ticket = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the sourceDescriptor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceDescriptor() {
        return sourceDescriptor;
    }

    /**
     * Sets the value of the sourceDescriptor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceDescriptor(String value) {
        this.sourceDescriptor = value;
    }

    /**
     * Gets the value of the rootSourceAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootSourceAbbreviation() {
        return rootSourceAbbreviation;
    }

    /**
     * Sets the value of the rootSourceAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootSourceAbbreviation(String value) {
        this.rootSourceAbbreviation = value;
    }

    /**
     * Gets the value of the psf property.
     * 
     * @return
     *     possible object is
     *     {@link Psf }
     *     
     */
    public Psf getPsf() {
        return psf;
    }

    /**
     * Sets the value of the psf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Psf }
     *     
     */
    public void setPsf(Psf value) {
        this.psf = value;
    }

}
