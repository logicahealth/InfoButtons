
package UtsMetathesaurusContent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceAtomClusterTreePositionPathDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceAtomClusterTreePositionPathDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="treePositions" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceAtomClusterTreePositionDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceAtomClusterTreePositionPathDTO", propOrder = {
    "classType",
    "treePositions"
})
public class SourceAtomClusterTreePositionPathDTO {

    protected String classType;
    @XmlElement(nillable = true)
    protected List<SourceAtomClusterTreePositionDTO> treePositions;

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
     * Gets the value of the treePositions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the treePositions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTreePositions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceAtomClusterTreePositionDTO }
     * 
     * 
     */
    public List<SourceAtomClusterTreePositionDTO> getTreePositions() {
        if (treePositions == null) {
            treePositions = new ArrayList<SourceAtomClusterTreePositionDTO>();
        }
        return this.treePositions;
    }

}
