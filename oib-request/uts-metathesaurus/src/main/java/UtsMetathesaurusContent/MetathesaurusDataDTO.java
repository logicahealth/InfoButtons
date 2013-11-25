
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for metathesaurusDataDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metathesaurusDataDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}dataDTO">
 *       &lt;sequence>
 *         &lt;element name="suppressible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ui" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metathesaurusDataDTO", propOrder = {
    "suppressible",
    "ui"
})
@XmlSeeAlso({
    AtomClusterDTO.class,
    ContentViewDTO.class,
    ContentViewMemberDTO.class,
    SourceDataDTO.class
})
public class MetathesaurusDataDTO
    extends DataDTO
{

    protected boolean suppressible;
    protected String ui;

    /**
     * Gets the value of the suppressible property.
     * 
     */
    public boolean isSuppressible() {
        return suppressible;
    }

    /**
     * Sets the value of the suppressible property.
     * 
     */
    public void setSuppressible(boolean value) {
        this.suppressible = value;
    }

    /**
     * Gets the value of the ui property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUi() {
        return ui;
    }

    /**
     * Sets the value of the ui property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUi(String value) {
        this.ui = value;
    }

}
