
package gov.nih.nlm.uts.webservice.history;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atomMovementDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="atomMovementDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}changeRecordDTO">
 *       &lt;sequence>
 *         &lt;element name="newConceptUi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldConceptUi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atomMovementDTO", propOrder = {
    "newConceptUi",
    "oldConceptUi"
})
public class AtomMovementDTO
    extends ChangeRecordDTO
{

    protected String newConceptUi;
    protected String oldConceptUi;

    /**
     * Gets the value of the newConceptUi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewConceptUi() {
        return newConceptUi;
    }

    /**
     * Sets the value of the newConceptUi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewConceptUi(String value) {
        this.newConceptUi = value;
    }

    /**
     * Gets the value of the oldConceptUi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldConceptUi() {
        return oldConceptUi;
    }

    /**
     * Sets the value of the oldConceptUi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldConceptUi(String value) {
        this.oldConceptUi = value;
    }

}
