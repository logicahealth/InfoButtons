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

package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atomRelationDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="atomRelationDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}relationDTO">
 *       &lt;sequence>
 *         &lt;element name="relatedAtom" type="{http://webservice.uts.umls.nlm.nih.gov/}atomDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atomRelationDTO", propOrder = {
    "relatedAtom"
})
public class AtomRelationDTO
    extends RelationDTO
{

    protected AtomDTO relatedAtom;

    /**
     * Gets the value of the relatedAtom property.
     * 
     * @return
     *     possible object is
     *     {@link AtomDTO }
     *     
     */
    public AtomDTO getRelatedAtom() {
        return relatedAtom;
    }

    /**
     * Sets the value of the relatedAtom property.
     * 
     * @param value
     *     allowed object is
     *     {@link AtomDTO }
     *     
     */
    public void setRelatedAtom(AtomDTO value) {
        this.relatedAtom = value;
    }

}
