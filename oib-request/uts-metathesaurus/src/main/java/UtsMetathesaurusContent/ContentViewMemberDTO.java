
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contentViewMemberDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contentViewMemberDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}metathesaurusDataDTO">
 *       &lt;sequence>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="contentViewHandle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentViewMemberDTO", propOrder = {
    "attributeCount",
    "contentViewHandle"
})
@XmlSeeAlso({
    AtomContentViewMemberDTO.class,
    RelationContentViewMemberDTO.class,
    ConceptContentViewMemberDTO.class,
    SourceConceptContentViewMemberDTO.class
})
public class ContentViewMemberDTO
    extends MetathesaurusDataDTO
{

    protected int attributeCount;
    protected String contentViewHandle;

    /**
     * Gets the value of the attributeCount property.
     * 
     */
    public int getAttributeCount() {
        return attributeCount;
    }

    /**
     * Sets the value of the attributeCount property.
     * 
     */
    public void setAttributeCount(int value) {
        this.attributeCount = value;
    }

    /**
     * Gets the value of the contentViewHandle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentViewHandle() {
        return contentViewHandle;
    }

    /**
     * Sets the value of the contentViewHandle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentViewHandle(String value) {
        this.contentViewHandle = value;
    }

}
