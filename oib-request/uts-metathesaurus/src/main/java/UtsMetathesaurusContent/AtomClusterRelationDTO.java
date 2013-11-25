
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atomClusterRelationDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="atomClusterRelationDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}relationDTO">
 *       &lt;sequence>
 *         &lt;element name="relatedAtomCluster" type="{http://webservice.uts.umls.nlm.nih.gov/}atomClusterDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atomClusterRelationDTO", propOrder = {
    "relatedAtomCluster"
})
public class AtomClusterRelationDTO
    extends RelationDTO
{

    protected AtomClusterDTO relatedAtomCluster;

    /**
     * Gets the value of the relatedAtomCluster property.
     * 
     * @return
     *     possible object is
     *     {@link AtomClusterDTO }
     *     
     */
    public AtomClusterDTO getRelatedAtomCluster() {
        return relatedAtomCluster;
    }

    /**
     * Sets the value of the relatedAtomCluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link AtomClusterDTO }
     *     
     */
    public void setRelatedAtomCluster(AtomClusterDTO value) {
        this.relatedAtomCluster = value;
    }

}
