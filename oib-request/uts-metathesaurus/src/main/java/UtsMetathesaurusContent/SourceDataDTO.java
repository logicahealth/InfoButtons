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
 * <p>Java class for sourceDataDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceDataDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}metathesaurusDataDTO">
 *       &lt;sequence>
 *         &lt;element name="literal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="obsolete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rootSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceOriginated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sourceUi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceDataDTO", propOrder = {
    "literal",
    "obsolete",
    "rootSource",
    "sourceOriginated",
    "sourceUi"
})
@XmlSeeAlso({
    DefinitionDTO.class,
    SubsetDTO.class,
    AttributeDTO.class,
    ValueSetDTO.class,
    MappingDTO.class,
    TreePositionDTO.class,
    MapObjectDTO.class,
    MapsetDTO.class,
    AtomDTO.class,
    RelationDTO.class,
    SubsetMemberDTO.class
})
public class SourceDataDTO
    extends MetathesaurusDataDTO
{

    protected boolean literal;
    protected boolean obsolete;
    protected String rootSource;
    protected boolean sourceOriginated;
    protected String sourceUi;

    /**
     * Gets the value of the literal property.
     * 
     */
    public boolean isLiteral() {
        return literal;
    }

    /**
     * Sets the value of the literal property.
     * 
     */
    public void setLiteral(boolean value) {
        this.literal = value;
    }

    /**
     * Gets the value of the obsolete property.
     * 
     */
    public boolean isObsolete() {
        return obsolete;
    }

    /**
     * Sets the value of the obsolete property.
     * 
     */
    public void setObsolete(boolean value) {
        this.obsolete = value;
    }

    /**
     * Gets the value of the rootSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootSource() {
        return rootSource;
    }

    /**
     * Sets the value of the rootSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootSource(String value) {
        this.rootSource = value;
    }

    /**
     * Gets the value of the sourceOriginated property.
     * 
     */
    public boolean isSourceOriginated() {
        return sourceOriginated;
    }

    /**
     * Sets the value of the sourceOriginated property.
     * 
     */
    public void setSourceOriginated(boolean value) {
        this.sourceOriginated = value;
    }

    /**
     * Gets the value of the sourceUi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceUi() {
        return sourceUi;
    }

    /**
     * Sets the value of the sourceUi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceUi(String value) {
        this.sourceUi = value;
    }

}
