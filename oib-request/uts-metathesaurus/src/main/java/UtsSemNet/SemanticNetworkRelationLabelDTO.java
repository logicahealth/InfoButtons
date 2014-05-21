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

package UtsSemNet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for semanticNetworkRelationLabelDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="semanticNetworkRelationLabelDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="classType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="definition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="example" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverseLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="treeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ui" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usageNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "semanticNetworkRelationLabelDTO", propOrder = {
    "abbreviation",
    "childCount",
    "classType",
    "definition",
    "example",
    "inverseLabel",
    "label",
    "relationCount",
    "treeNumber",
    "ui",
    "usageNote"
})
public class SemanticNetworkRelationLabelDTO {

    protected String abbreviation;
    protected int childCount;
    protected String classType;
    protected String definition;
    protected String example;
    protected String inverseLabel;
    protected String label;
    protected int relationCount;
    protected String treeNumber;
    protected String ui;
    protected String usageNote;

    /**
     * Gets the value of the abbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the value of the abbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbreviation(String value) {
        this.abbreviation = value;
    }

    /**
     * Gets the value of the childCount property.
     * 
     */
    public int getChildCount() {
        return childCount;
    }

    /**
     * Sets the value of the childCount property.
     * 
     */
    public void setChildCount(int value) {
        this.childCount = value;
    }

    /**
     * Gets the value of the classType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassType() {
        return classType;
    }

    /**
     * Sets the value of the classType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassType(String value) {
        this.classType = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
    }

    /**
     * Gets the value of the example property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExample() {
        return example;
    }

    /**
     * Sets the value of the example property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExample(String value) {
        this.example = value;
    }

    /**
     * Gets the value of the inverseLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInverseLabel() {
        return inverseLabel;
    }

    /**
     * Sets the value of the inverseLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInverseLabel(String value) {
        this.inverseLabel = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the relationCount property.
     * 
     */
    public int getRelationCount() {
        return relationCount;
    }

    /**
     * Sets the value of the relationCount property.
     * 
     */
    public void setRelationCount(int value) {
        this.relationCount = value;
    }

    /**
     * Gets the value of the treeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreeNumber() {
        return treeNumber;
    }

    /**
     * Sets the value of the treeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreeNumber(String value) {
        this.treeNumber = value;
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

    /**
     * Gets the value of the usageNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageNote() {
        return usageNote;
    }

    /**
     * Sets the value of the usageNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageNote(String value) {
        this.usageNote = value;
    }

}
