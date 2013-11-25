
package UtsMetathesaurusHistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termMergeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termMergeDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}changeRecordDTO">
 *       &lt;sequence>
 *         &lt;element name="newTermUi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termMergeDTO", propOrder = {
    "newTermUi"
})
public class TermMergeDTO
    extends ChangeRecordDTO
{

    protected String newTermUi;

    /**
     * Gets the value of the newTermUi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTermUi() {
        return newTermUi;
    }

    /**
     * Sets the value of the newTermUi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTermUi(String value) {
        this.newTermUi = value;
    }

}
