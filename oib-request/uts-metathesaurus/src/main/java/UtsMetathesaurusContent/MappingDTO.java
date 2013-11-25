
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mappingDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mappingDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}sourceDataDTO">
 *       &lt;sequence>
 *         &lt;element name="additionalLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mapFrom" type="{http://webservice.uts.umls.nlm.nih.gov/}mapObjectDTO" minOccurs="0"/>
 *         &lt;element name="mapSetHandle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mapTo" type="{http://webservice.uts.umls.nlm.nih.gov/}mapObjectDTO" minOccurs="0"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="restriction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subsetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mappingDTO", propOrder = {
    "additionalLabel",
    "attributeCount",
    "label",
    "mapFrom",
    "mapSetHandle",
    "mapTo",
    "rank",
    "restriction",
    "rule",
    "subsetId",
    "type"
})
public class MappingDTO
    extends SourceDataDTO
{

    protected String additionalLabel;
    protected int attributeCount;
    protected String label;
    protected MapObjectDTO mapFrom;
    protected String mapSetHandle;
    protected MapObjectDTO mapTo;
    protected String rank;
    protected String restriction;
    protected String rule;
    protected String subsetId;
    protected String type;

    /**
     * Gets the value of the additionalLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalLabel() {
        return additionalLabel;
    }

    /**
     * Sets the value of the additionalLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalLabel(String value) {
        this.additionalLabel = value;
    }

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
     * Gets the value of the mapFrom property.
     * 
     * @return
     *     possible object is
     *     {@link MapObjectDTO }
     *     
     */
    public MapObjectDTO getMapFrom() {
        return mapFrom;
    }

    /**
     * Sets the value of the mapFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapObjectDTO }
     *     
     */
    public void setMapFrom(MapObjectDTO value) {
        this.mapFrom = value;
    }

    /**
     * Gets the value of the mapSetHandle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapSetHandle() {
        return mapSetHandle;
    }

    /**
     * Sets the value of the mapSetHandle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapSetHandle(String value) {
        this.mapSetHandle = value;
    }

    /**
     * Gets the value of the mapTo property.
     * 
     * @return
     *     possible object is
     *     {@link MapObjectDTO }
     *     
     */
    public MapObjectDTO getMapTo() {
        return mapTo;
    }

    /**
     * Sets the value of the mapTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapObjectDTO }
     *     
     */
    public void setMapTo(MapObjectDTO value) {
        this.mapTo = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRank(String value) {
        this.rank = value;
    }

    /**
     * Gets the value of the restriction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestriction() {
        return restriction;
    }

    /**
     * Sets the value of the restriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestriction(String value) {
        this.restriction = value;
    }

    /**
     * Gets the value of the rule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRule(String value) {
        this.rule = value;
    }

    /**
     * Gets the value of the subsetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubsetId() {
        return subsetId;
    }

    /**
     * Sets the value of the subsetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubsetId(String value) {
        this.subsetId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
