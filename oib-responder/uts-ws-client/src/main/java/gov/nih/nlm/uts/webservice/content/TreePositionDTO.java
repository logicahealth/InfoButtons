
package gov.nih.nlm.uts.webservice.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for treePositionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="treePositionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}sourceDataDTO">
 *       &lt;sequence>
 *         &lt;element name="additionalRelationLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="defaultPreferredName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathsToRootCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="siblingCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "treePositionDTO", propOrder = {
    "additionalRelationLabel",
    "childCount",
    "defaultPreferredName",
    "pathsToRootCount",
    "siblingCount"
})
@XmlSeeAlso({
    AtomTreePositionDTO.class,
    SourceAtomClusterTreePositionDTO.class
})
public class TreePositionDTO
    extends SourceDataDTO
{

    protected String additionalRelationLabel;
    protected int childCount;
    protected String defaultPreferredName;
    protected int pathsToRootCount;
    protected int siblingCount;

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

    /**
     * Gets the value of the pathsToRootCount property.
     * 
     */
    public int getPathsToRootCount() {
        return pathsToRootCount;
    }

    /**
     * Sets the value of the pathsToRootCount property.
     * 
     */
    public void setPathsToRootCount(int value) {
        this.pathsToRootCount = value;
    }

    /**
     * Gets the value of the siblingCount property.
     * 
     */
    public int getSiblingCount() {
        return siblingCount;
    }

    /**
     * Sets the value of the siblingCount property.
     * 
     */
    public void setSiblingCount(int value) {
        this.siblingCount = value;
    }

}
