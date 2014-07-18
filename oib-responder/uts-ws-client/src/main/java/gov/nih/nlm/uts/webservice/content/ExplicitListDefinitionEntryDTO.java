
package gov.nih.nlm.uts.webservice.content;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for explicitListDefinitionEntryDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="explicitListDefinitionEntryDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}valueSetDefinitionDTO">
 *       &lt;sequence>
 *         &lt;element name="vsCodes" type="{http://webservice.uts.umls.nlm.nih.gov/}vsCodeDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "explicitListDefinitionEntryDTO", propOrder = {
    "vsCodes"
})
public class ExplicitListDefinitionEntryDTO
    extends ValueSetDefinitionDTO
{

    @XmlElement(nillable = true)
    protected List<VsCodeDTO> vsCodes;

    /**
     * Gets the value of the vsCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vsCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVsCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VsCodeDTO }
     * 
     * 
     */
    public List<VsCodeDTO> getVsCodes() {
        if (vsCodes == null) {
            vsCodes = new ArrayList<VsCodeDTO>();
        }
        return this.vsCodes;
    }

}
