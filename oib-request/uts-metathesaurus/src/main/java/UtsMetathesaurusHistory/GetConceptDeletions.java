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

package UtsMetathesaurusHistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getConceptDeletions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getConceptDeletions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ticket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newerVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conceptId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="olderVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConceptDeletions", propOrder = {
    "ticket",
    "newerVersion",
    "conceptId",
    "olderVersion"
})
public class GetConceptDeletions {

    protected String ticket;
    protected String newerVersion;
    protected String conceptId;
    protected String olderVersion;

    /**
     * Gets the value of the ticket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * Sets the value of the ticket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicket(String value) {
        this.ticket = value;
    }

    /**
     * Gets the value of the newerVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewerVersion() {
        return newerVersion;
    }

    /**
     * Sets the value of the newerVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewerVersion(String value) {
        this.newerVersion = value;
    }

    /**
     * Gets the value of the conceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConceptId() {
        return conceptId;
    }

    /**
     * Sets the value of the conceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConceptId(String value) {
        this.conceptId = value;
    }

    /**
     * Gets the value of the olderVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOlderVersion() {
        return olderVersion;
    }

    /**
     * Sets the value of the olderVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOlderVersion(String value) {
        this.olderVersion = value;
    }

}
