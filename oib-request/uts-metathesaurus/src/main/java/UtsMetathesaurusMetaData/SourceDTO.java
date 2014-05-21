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

package UtsMetathesaurusMetaData;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for sourceDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}validDTO">
 *       &lt;sequence>
 *         &lt;element name="assertsRelDirection" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="atomCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="charset" type="{http://webservice.uts.umls.nlm.nih.gov/}characterSetDTO" minOccurs="0"/>
 *         &lt;element name="citation" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceCitationDTO" minOccurs="0"/>
 *         &lt;element name="conceptCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="insertMetaVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preferredName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="removeMetaVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rootSource" type="{http://webservice.uts.umls.nlm.nih.gov/}rootSourceDTO" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="synonymousNames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versionsAgo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceDTO", propOrder = {
    "assertsRelDirection",
    "atomCount",
    "charset",
    "citation",
    "conceptCount",
    "endDate",
    "insertMetaVersion",
    "preferredName",
    "removeMetaVersion",
    "rootSource",
    "startDate",
    "synonymousNames",
    "version",
    "versionsAgo"
})
public class SourceDTO
    extends ValidDTO
{

    protected boolean assertsRelDirection;
    protected int atomCount;
    protected CharacterSetDTO charset;
    protected SourceCitationDTO citation;
    protected int conceptCount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected String insertMetaVersion;
    protected String preferredName;
    protected String removeMetaVersion;
    protected RootSourceDTO rootSource;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(nillable = true)
    protected List<String> synonymousNames;
    protected String version;
    protected int versionsAgo;

    /**
     * Gets the value of the assertsRelDirection property.
     * 
     */
    public boolean isAssertsRelDirection() {
        return assertsRelDirection;
    }

    /**
     * Sets the value of the assertsRelDirection property.
     * 
     */
    public void setAssertsRelDirection(boolean value) {
        this.assertsRelDirection = value;
    }

    /**
     * Gets the value of the atomCount property.
     * 
     */
    public int getAtomCount() {
        return atomCount;
    }

    /**
     * Sets the value of the atomCount property.
     * 
     */
    public void setAtomCount(int value) {
        this.atomCount = value;
    }

    /**
     * Gets the value of the charset property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterSetDTO }
     *     
     */
    public CharacterSetDTO getCharset() {
        return charset;
    }

    /**
     * Sets the value of the charset property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterSetDTO }
     *     
     */
    public void setCharset(CharacterSetDTO value) {
        this.charset = value;
    }

    /**
     * Gets the value of the citation property.
     * 
     * @return
     *     possible object is
     *     {@link SourceCitationDTO }
     *     
     */
    public SourceCitationDTO getCitation() {
        return citation;
    }

    /**
     * Sets the value of the citation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceCitationDTO }
     *     
     */
    public void setCitation(SourceCitationDTO value) {
        this.citation = value;
    }

    /**
     * Gets the value of the conceptCount property.
     * 
     */
    public int getConceptCount() {
        return conceptCount;
    }

    /**
     * Sets the value of the conceptCount property.
     * 
     */
    public void setConceptCount(int value) {
        this.conceptCount = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the insertMetaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsertMetaVersion() {
        return insertMetaVersion;
    }

    /**
     * Sets the value of the insertMetaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsertMetaVersion(String value) {
        this.insertMetaVersion = value;
    }

    /**
     * Gets the value of the preferredName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredName() {
        return preferredName;
    }

    /**
     * Sets the value of the preferredName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredName(String value) {
        this.preferredName = value;
    }

    /**
     * Gets the value of the removeMetaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoveMetaVersion() {
        return removeMetaVersion;
    }

    /**
     * Sets the value of the removeMetaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoveMetaVersion(String value) {
        this.removeMetaVersion = value;
    }

    /**
     * Gets the value of the rootSource property.
     * 
     * @return
     *     possible object is
     *     {@link RootSourceDTO }
     *     
     */
    public RootSourceDTO getRootSource() {
        return rootSource;
    }

    /**
     * Sets the value of the rootSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link RootSourceDTO }
     *     
     */
    public void setRootSource(RootSourceDTO value) {
        this.rootSource = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the synonymousNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the synonymousNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSynonymousNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSynonymousNames() {
        if (synonymousNames == null) {
            synonymousNames = new ArrayList<String>();
        }
        return this.synonymousNames;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the versionsAgo property.
     * 
     */
    public int getVersionsAgo() {
        return versionsAgo;
    }

    /**
     * Sets the value of the versionsAgo property.
     * 
     */
    public void setVersionsAgo(int value) {
        this.versionsAgo = value;
    }

}
