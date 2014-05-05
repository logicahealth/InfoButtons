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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rootSourceDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rootSourceDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}validDTO">
 *       &lt;sequence>
 *         &lt;element name="acquisitionContact" type="{http://webservice.uts.umls.nlm.nih.gov/}contactInformationDTO" minOccurs="0"/>
 *         &lt;element name="contentContact" type="{http://webservice.uts.umls.nlm.nih.gov/}contactInformationDTO" minOccurs="0"/>
 *         &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hierarchicalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://webservice.uts.umls.nlm.nih.gov/}languageDTO" minOccurs="0"/>
 *         &lt;element name="licenseContact" type="{http://webservice.uts.umls.nlm.nih.gov/}contactInformationDTO" minOccurs="0"/>
 *         &lt;element name="preferredName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="restrictionLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="synonymousNames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rootSourceDTO", propOrder = {
    "acquisitionContact",
    "contentContact",
    "contextType",
    "family",
    "hierarchicalName",
    "language",
    "licenseContact",
    "preferredName",
    "restrictionLevel",
    "shortName",
    "synonymousNames"
})
public class RootSourceDTO
    extends ValidDTO
{

    protected ContactInformationDTO acquisitionContact;
    protected ContactInformationDTO contentContact;
    protected String contextType;
    protected String family;
    protected String hierarchicalName;
    protected LanguageDTO language;
    protected ContactInformationDTO licenseContact;
    protected String preferredName;
    protected int restrictionLevel;
    protected String shortName;
    @XmlElement(nillable = true)
    protected List<String> synonymousNames;

    /**
     * Gets the value of the acquisitionContact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInformationDTO }
     *     
     */
    public ContactInformationDTO getAcquisitionContact() {
        return acquisitionContact;
    }

    /**
     * Sets the value of the acquisitionContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInformationDTO }
     *     
     */
    public void setAcquisitionContact(ContactInformationDTO value) {
        this.acquisitionContact = value;
    }

    /**
     * Gets the value of the contentContact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInformationDTO }
     *     
     */
    public ContactInformationDTO getContentContact() {
        return contentContact;
    }

    /**
     * Sets the value of the contentContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInformationDTO }
     *     
     */
    public void setContentContact(ContactInformationDTO value) {
        this.contentContact = value;
    }

    /**
     * Gets the value of the contextType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextType() {
        return contextType;
    }

    /**
     * Sets the value of the contextType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextType(String value) {
        this.contextType = value;
    }

    /**
     * Gets the value of the family property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamily(String value) {
        this.family = value;
    }

    /**
     * Gets the value of the hierarchicalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchicalName() {
        return hierarchicalName;
    }

    /**
     * Sets the value of the hierarchicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchicalName(String value) {
        this.hierarchicalName = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageDTO }
     *     
     */
    public LanguageDTO getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageDTO }
     *     
     */
    public void setLanguage(LanguageDTO value) {
        this.language = value;
    }

    /**
     * Gets the value of the licenseContact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInformationDTO }
     *     
     */
    public ContactInformationDTO getLicenseContact() {
        return licenseContact;
    }

    /**
     * Sets the value of the licenseContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInformationDTO }
     *     
     */
    public void setLicenseContact(ContactInformationDTO value) {
        this.licenseContact = value;
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
     * Gets the value of the restrictionLevel property.
     * 
     */
    public int getRestrictionLevel() {
        return restrictionLevel;
    }

    /**
     * Sets the value of the restrictionLevel property.
     * 
     */
    public void setRestrictionLevel(int value) {
        this.restrictionLevel = value;
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
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

}
