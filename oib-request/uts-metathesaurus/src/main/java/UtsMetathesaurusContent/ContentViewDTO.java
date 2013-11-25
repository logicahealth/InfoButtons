
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for contentViewDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contentViewDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}metathesaurusDataDTO">
 *       &lt;sequence>
 *         &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="atomMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cascade" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="conceptMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="contentViewClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contributor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contributorDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="contributorURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contributorVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="includeObsolete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maintainer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maintainerDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="maintainerURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maintainerVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="previousMeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceConceptMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="subCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentViewDTO", propOrder = {
    "algorithm",
    "atomMemberCount",
    "attributeCount",
    "cascade",
    "category",
    "code",
    "conceptMemberCount",
    "contentViewClass",
    "contributor",
    "contributorDate",
    "contributorURL",
    "contributorVersion",
    "description",
    "generated",
    "includeObsolete",
    "maintainer",
    "maintainerDate",
    "maintainerURL",
    "maintainerVersion",
    "name",
    "previousMeta",
    "relationMemberCount",
    "sourceConceptMemberCount",
    "subCategory"
})
public class ContentViewDTO
    extends MetathesaurusDataDTO
{

    protected String algorithm;
    protected int atomMemberCount;
    protected int attributeCount;
    protected boolean cascade;
    protected String category;
    protected long code;
    protected int conceptMemberCount;
    protected String contentViewClass;
    protected String contributor;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contributorDate;
    protected String contributorURL;
    protected String contributorVersion;
    protected String description;
    protected boolean generated;
    protected boolean includeObsolete;
    protected String maintainer;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar maintainerDate;
    protected String maintainerURL;
    protected String maintainerVersion;
    protected String name;
    protected String previousMeta;
    protected int relationMemberCount;
    protected int sourceConceptMemberCount;
    protected String subCategory;

    /**
     * Gets the value of the algorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

    /**
     * Gets the value of the atomMemberCount property.
     * 
     */
    public int getAtomMemberCount() {
        return atomMemberCount;
    }

    /**
     * Sets the value of the atomMemberCount property.
     * 
     */
    public void setAtomMemberCount(int value) {
        this.atomMemberCount = value;
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
     * Gets the value of the cascade property.
     * 
     */
    public boolean isCascade() {
        return cascade;
    }

    /**
     * Sets the value of the cascade property.
     * 
     */
    public void setCascade(boolean value) {
        this.cascade = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the code property.
     * 
     */
    public long getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(long value) {
        this.code = value;
    }

    /**
     * Gets the value of the conceptMemberCount property.
     * 
     */
    public int getConceptMemberCount() {
        return conceptMemberCount;
    }

    /**
     * Sets the value of the conceptMemberCount property.
     * 
     */
    public void setConceptMemberCount(int value) {
        this.conceptMemberCount = value;
    }

    /**
     * Gets the value of the contentViewClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentViewClass() {
        return contentViewClass;
    }

    /**
     * Sets the value of the contentViewClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentViewClass(String value) {
        this.contentViewClass = value;
    }

    /**
     * Gets the value of the contributor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContributor() {
        return contributor;
    }

    /**
     * Sets the value of the contributor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContributor(String value) {
        this.contributor = value;
    }

    /**
     * Gets the value of the contributorDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContributorDate() {
        return contributorDate;
    }

    /**
     * Sets the value of the contributorDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContributorDate(XMLGregorianCalendar value) {
        this.contributorDate = value;
    }

    /**
     * Gets the value of the contributorURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContributorURL() {
        return contributorURL;
    }

    /**
     * Sets the value of the contributorURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContributorURL(String value) {
        this.contributorURL = value;
    }

    /**
     * Gets the value of the contributorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContributorVersion() {
        return contributorVersion;
    }

    /**
     * Sets the value of the contributorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContributorVersion(String value) {
        this.contributorVersion = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the generated property.
     * 
     */
    public boolean isGenerated() {
        return generated;
    }

    /**
     * Sets the value of the generated property.
     * 
     */
    public void setGenerated(boolean value) {
        this.generated = value;
    }

    /**
     * Gets the value of the includeObsolete property.
     * 
     */
    public boolean isIncludeObsolete() {
        return includeObsolete;
    }

    /**
     * Sets the value of the includeObsolete property.
     * 
     */
    public void setIncludeObsolete(boolean value) {
        this.includeObsolete = value;
    }

    /**
     * Gets the value of the maintainer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaintainer() {
        return maintainer;
    }

    /**
     * Sets the value of the maintainer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaintainer(String value) {
        this.maintainer = value;
    }

    /**
     * Gets the value of the maintainerDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMaintainerDate() {
        return maintainerDate;
    }

    /**
     * Sets the value of the maintainerDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMaintainerDate(XMLGregorianCalendar value) {
        this.maintainerDate = value;
    }

    /**
     * Gets the value of the maintainerURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaintainerURL() {
        return maintainerURL;
    }

    /**
     * Sets the value of the maintainerURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaintainerURL(String value) {
        this.maintainerURL = value;
    }

    /**
     * Gets the value of the maintainerVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaintainerVersion() {
        return maintainerVersion;
    }

    /**
     * Sets the value of the maintainerVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaintainerVersion(String value) {
        this.maintainerVersion = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the previousMeta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousMeta() {
        return previousMeta;
    }

    /**
     * Sets the value of the previousMeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousMeta(String value) {
        this.previousMeta = value;
    }

    /**
     * Gets the value of the relationMemberCount property.
     * 
     */
    public int getRelationMemberCount() {
        return relationMemberCount;
    }

    /**
     * Sets the value of the relationMemberCount property.
     * 
     */
    public void setRelationMemberCount(int value) {
        this.relationMemberCount = value;
    }

    /**
     * Gets the value of the sourceConceptMemberCount property.
     * 
     */
    public int getSourceConceptMemberCount() {
        return sourceConceptMemberCount;
    }

    /**
     * Sets the value of the sourceConceptMemberCount property.
     * 
     */
    public void setSourceConceptMemberCount(int value) {
        this.sourceConceptMemberCount = value;
    }

    /**
     * Gets the value of the subCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * Sets the value of the subCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubCategory(String value) {
        this.subCategory = value;
    }

}
