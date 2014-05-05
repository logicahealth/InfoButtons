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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relationDefinitionEntryDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relationDefinitionEntryDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}valueSetDefinitionDTO">
 *       &lt;sequence>
 *         &lt;element name="additionalRelationLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forwardDirection" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="leafOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="relationLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transitive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "relationDefinitionEntryDTO", propOrder = {
    "additionalRelationLabel",
    "forwardDirection",
    "leafOnly",
    "relationLabel",
    "transitive",
    "ui"
})
public class RelationDefinitionEntryDTO
    extends ValueSetDefinitionDTO
{

    protected String additionalRelationLabel;
    protected boolean forwardDirection;
    protected boolean leafOnly;
    protected String relationLabel;
    protected boolean transitive;
    protected String ui;

    /**
     * Gets the value of the additionalRelationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalRelationLabel() {
        return additionalRelationLabel;
    }

    /**
     * Sets the value of the additionalRelationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalRelationLabel(String value) {
        this.additionalRelationLabel = value;
    }

    /**
     * Gets the value of the forwardDirection property.
     * 
     */
    public boolean isForwardDirection() {
        return forwardDirection;
    }

    /**
     * Sets the value of the forwardDirection property.
     * 
     */
    public void setForwardDirection(boolean value) {
        this.forwardDirection = value;
    }

    /**
     * Gets the value of the leafOnly property.
     * 
     */
    public boolean isLeafOnly() {
        return leafOnly;
    }

    /**
     * Sets the value of the leafOnly property.
     * 
     */
    public void setLeafOnly(boolean value) {
        this.leafOnly = value;
    }

    /**
     * Gets the value of the relationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationLabel() {
        return relationLabel;
    }

    /**
     * Sets the value of the relationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationLabel(String value) {
        this.relationLabel = value;
    }

    /**
     * Gets the value of the transitive property.
     * 
     */
    public boolean isTransitive() {
        return transitive;
    }

    /**
     * Sets the value of the transitive property.
     * 
     */
    public void setTransitive(boolean value) {
        this.transitive = value;
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
