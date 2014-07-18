
package gov.nih.nlm.uts.webservice.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}atomClusterDTO">
 *       &lt;sequence>
 *         &lt;element name="atomCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="luinormForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="normForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termStringCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termDTO", propOrder = {
    "atomCount",
    "language",
    "luinormForm",
    "normForm",
    "termStringCount"
})
public class TermDTO
    extends AtomClusterDTO
{

    protected int atomCount;
    protected String language;
    protected String luinormForm;
    protected String normForm;
    protected int termStringCount;

    /**
     * Gets the value of the atomCount property.
     * 
     */
    public int getAtomCount() {
        return atomCount;
    }

    /**
     * Sets the value of the atomCount property.
     * 
     */
    public void setAtomCount(int value) {
        this.atomCount = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the luinormForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLuinormForm() {
        return luinormForm;
    }

    /**
     * Sets the value of the luinormForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLuinormForm(String value) {
        this.luinormForm = value;
    }

    /**
     * Gets the value of the normForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormForm() {
        return normForm;
    }

    /**
     * Sets the value of the normForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormForm(String value) {
        this.normForm = value;
    }

    /**
     * Gets the value of the termStringCount property.
     * 
     */
    public int getTermStringCount() {
        return termStringCount;
    }

    /**
     * Sets the value of the termStringCount property.
     * 
     */
    public void setTermStringCount(int value) {
        this.termStringCount = value;
    }

}
