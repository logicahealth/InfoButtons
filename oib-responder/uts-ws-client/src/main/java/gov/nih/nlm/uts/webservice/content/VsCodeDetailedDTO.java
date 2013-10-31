
package gov.nih.nlm.uts.webservice.content;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vsCodeDetailedDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vsCodeDetailedDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}vsCodeDTO">
 *       &lt;sequence>
 *         &lt;element name="rel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rela" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rels" type="{http://webservice.uts.umls.nlm.nih.gov/}vsCodeDetailedDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vsCodeDetailedDTO", propOrder = {
    "rel",
    "rela",
    "rels"
})
public class VsCodeDetailedDTO
    extends VsCodeDTO
{

    protected String rel;
    protected String rela;
    @XmlElement(nillable = true)
    protected List<VsCodeDetailedDTO> rels;

    /**
     * Gets the value of the rel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRel() {
        return rel;
    }

    /**
     * Sets the value of the rel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRel(String value) {
        this.rel = value;
    }

    /**
     * Gets the value of the rela property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRela() {
        return rela;
    }

    /**
     * Sets the value of the rela property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRela(String value) {
        this.rela = value;
    }

    /**
     * Gets the value of the rels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VsCodeDetailedDTO }
     * 
     * 
     */
    public List<VsCodeDetailedDTO> getRels() {
        if (rels == null) {
            rels = new ArrayList<VsCodeDetailedDTO>();
        }
        return this.rels;
    }

}
