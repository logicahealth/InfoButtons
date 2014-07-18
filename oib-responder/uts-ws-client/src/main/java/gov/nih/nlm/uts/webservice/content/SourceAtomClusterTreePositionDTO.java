
package gov.nih.nlm.uts.webservice.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceAtomClusterTreePositionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceAtomClusterTreePositionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}treePositionDTO">
 *       &lt;sequence>
 *         &lt;element name="cluster" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceAtomClusterDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceAtomClusterTreePositionDTO", propOrder = {
    "cluster"
})
public class SourceAtomClusterTreePositionDTO
    extends TreePositionDTO
{

    protected SourceAtomClusterDTO cluster;

    /**
     * Gets the value of the cluster property.
     * 
     * @return
     *     possible object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public SourceAtomClusterDTO getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public void setCluster(SourceAtomClusterDTO value) {
        this.cluster = value;
    }

}
