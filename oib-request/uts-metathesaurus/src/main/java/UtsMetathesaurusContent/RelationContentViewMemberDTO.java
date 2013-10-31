
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relationContentViewMemberDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relationContentViewMemberDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}contentViewMemberDTO">
 *       &lt;sequence>
 *         &lt;element name="relation" type="{http://webservice.uts.umls.nlm.nih.gov/}relationDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relationContentViewMemberDTO", propOrder = {
    "relation"
})
public class RelationContentViewMemberDTO
    extends ContentViewMemberDTO
{

    protected RelationDTO relation;

    /**
     * Gets the value of the relation property.
     * 
     * @return
     *     possible object is
     *     {@link RelationDTO }
     *     
     */
    public RelationDTO getRelation() {
        return relation;
    }

    /**
     * Sets the value of the relation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationDTO }
     *     
     */
    public void setRelation(RelationDTO value) {
        this.relation = value;
    }

}
