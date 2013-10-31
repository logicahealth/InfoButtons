
package UtsMetathesaurusHistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termDeathDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termDeathDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}changeRecordDTO">
 *       &lt;sequence>
 *         &lt;element name="defaultPreferredName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termDeathDTO", propOrder = {
    "defaultPreferredName"
})
public class TermDeathDTO
    extends ChangeRecordDTO
{

    protected String defaultPreferredName;

    /**
     * Gets the value of the defaultPreferredName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultPreferredName() {
        return defaultPreferredName;
    }

    /**
     * Sets the value of the defaultPreferredName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultPreferredName(String value) {
        this.defaultPreferredName = value;
    }

}
