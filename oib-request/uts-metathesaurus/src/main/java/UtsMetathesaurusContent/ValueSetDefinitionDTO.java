/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah<br>
 * Contact: {@code <andrew.iskander@utah.edu>}<br>
 * Biomedical Informatics<br>
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version May 5, 2014
 */

package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for valueSetDefinitionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="valueSetDefinitionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}dataDTO">
 *       &lt;sequence>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceui" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valueSetDefinitionDTO", propOrder = {
    "operator",
    "sourceui",
    "version"
})
@XmlSeeAlso({
    RelationDefinitionEntryDTO.class,
    AttributeDefinitionEntryDTO.class,
    CompleteValueSetDefinitionEntryDTO.class,
    ExplicitListDefinitionEntryDTO.class,
    ExplicitListDetailedDefinitionEntryDTO.class,
    CompleteSourceDefinitionEntryDTO.class
})
public class ValueSetDefinitionDTO
    extends DataDTO
{

    protected String operator;
    protected String sourceui;
    protected String version;

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * Gets the value of the sourceui property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceui() {
        return sourceui;
    }

    /**
     * Sets the value of the sourceui property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceui(String value) {
        this.sourceui = value;
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

}
