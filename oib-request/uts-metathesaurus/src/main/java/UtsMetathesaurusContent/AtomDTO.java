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
 * <p>Java class for atomDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="atomDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}sourceDataDTO">
 *       &lt;sequence>
 *         &lt;element name="atomRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cocCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="code" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceAtomClusterDTO" minOccurs="0"/>
 *         &lt;element name="codeRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="concept" type="{http://webservice.uts.umls.nlm.nih.gov/}conceptDTO" minOccurs="0"/>
 *         &lt;element name="conceptRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cooccurrenceCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cvMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="definitionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="relationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceConcept" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceAtomClusterDTO" minOccurs="0"/>
 *         &lt;element name="sourceConceptRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceDescriptor" type="{http://webservice.uts.umls.nlm.nih.gov/}sourceAtomClusterDTO" minOccurs="0"/>
 *         &lt;element name="sourceDescriptorRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="subsetMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="termString" type="{http://webservice.uts.umls.nlm.nih.gov/}termStringDTO" minOccurs="0"/>
 *         &lt;element name="termType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="treePositionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atomDTO", propOrder = {
    "atomRelationCount",
    "attributeCount",
    "cocCount",
    "code",
    "codeRelationCount",
    "concept",
    "conceptRelationCount",
    "cooccurrenceCount",
    "cvMemberCount",
    "definitionCount",
    "relationCount",
    "sourceConcept",
    "sourceConceptRelationCount",
    "sourceDescriptor",
    "sourceDescriptorRelationCount",
    "subsetMemberCount",
    "termString",
    "termType",
    "treePositionCount"
})
public class AtomDTO
    extends SourceDataDTO
{

    protected int atomRelationCount;
    protected int attributeCount;
    protected int cocCount;
    protected SourceAtomClusterDTO code;
    protected int codeRelationCount;
    protected ConceptDTO concept;
    protected int conceptRelationCount;
    protected int cooccurrenceCount;
    protected int cvMemberCount;
    protected int definitionCount;
    protected int relationCount;
    protected SourceAtomClusterDTO sourceConcept;
    protected int sourceConceptRelationCount;
    protected SourceAtomClusterDTO sourceDescriptor;
    protected int sourceDescriptorRelationCount;
    protected int subsetMemberCount;
    protected TermStringDTO termString;
    protected String termType;
    protected int treePositionCount;

    /**
     * Gets the value of the atomRelationCount property.
     * 
     */
    public int getAtomRelationCount() {
        return atomRelationCount;
    }

    /**
     * Sets the value of the atomRelationCount property.
     * 
     */
    public void setAtomRelationCount(int value) {
        this.atomRelationCount = value;
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
     * Gets the value of the cocCount property.
     * 
     */
    public int getCocCount() {
        return cocCount;
    }

    /**
     * Sets the value of the cocCount property.
     * 
     */
    public void setCocCount(int value) {
        this.cocCount = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public SourceAtomClusterDTO getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public void setCode(SourceAtomClusterDTO value) {
        this.code = value;
    }

    /**
     * Gets the value of the codeRelationCount property.
     * 
     */
    public int getCodeRelationCount() {
        return codeRelationCount;
    }

    /**
     * Sets the value of the codeRelationCount property.
     * 
     */
    public void setCodeRelationCount(int value) {
        this.codeRelationCount = value;
    }

    /**
     * Gets the value of the concept property.
     * 
     * @return
     *     possible object is
     *     {@link ConceptDTO }
     *     
     */
    public ConceptDTO getConcept() {
        return concept;
    }

    /**
     * Sets the value of the concept property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConceptDTO }
     *     
     */
    public void setConcept(ConceptDTO value) {
        this.concept = value;
    }

    /**
     * Gets the value of the conceptRelationCount property.
     * 
     */
    public int getConceptRelationCount() {
        return conceptRelationCount;
    }

    /**
     * Sets the value of the conceptRelationCount property.
     * 
     */
    public void setConceptRelationCount(int value) {
        this.conceptRelationCount = value;
    }

    /**
     * Gets the value of the cooccurrenceCount property.
     * 
     */
    public int getCooccurrenceCount() {
        return cooccurrenceCount;
    }

    /**
     * Sets the value of the cooccurrenceCount property.
     * 
     */
    public void setCooccurrenceCount(int value) {
        this.cooccurrenceCount = value;
    }

    /**
     * Gets the value of the cvMemberCount property.
     * 
     */
    public int getCvMemberCount() {
        return cvMemberCount;
    }

    /**
     * Sets the value of the cvMemberCount property.
     * 
     */
    public void setCvMemberCount(int value) {
        this.cvMemberCount = value;
    }

    /**
     * Gets the value of the definitionCount property.
     * 
     */
    public int getDefinitionCount() {
        return definitionCount;
    }

    /**
     * Sets the value of the definitionCount property.
     * 
     */
    public void setDefinitionCount(int value) {
        this.definitionCount = value;
    }

    /**
     * Gets the value of the relationCount property.
     * 
     */
    public int getRelationCount() {
        return relationCount;
    }

    /**
     * Sets the value of the relationCount property.
     * 
     */
    public void setRelationCount(int value) {
        this.relationCount = value;
    }

    /**
     * Gets the value of the sourceConcept property.
     * 
     * @return
     *     possible object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public SourceAtomClusterDTO getSourceConcept() {
        return sourceConcept;
    }

    /**
     * Sets the value of the sourceConcept property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public void setSourceConcept(SourceAtomClusterDTO value) {
        this.sourceConcept = value;
    }

    /**
     * Gets the value of the sourceConceptRelationCount property.
     * 
     */
    public int getSourceConceptRelationCount() {
        return sourceConceptRelationCount;
    }

    /**
     * Sets the value of the sourceConceptRelationCount property.
     * 
     */
    public void setSourceConceptRelationCount(int value) {
        this.sourceConceptRelationCount = value;
    }

    /**
     * Gets the value of the sourceDescriptor property.
     * 
     * @return
     *     possible object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public SourceAtomClusterDTO getSourceDescriptor() {
        return sourceDescriptor;
    }

    /**
     * Sets the value of the sourceDescriptor property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceAtomClusterDTO }
     *     
     */
    public void setSourceDescriptor(SourceAtomClusterDTO value) {
        this.sourceDescriptor = value;
    }

    /**
     * Gets the value of the sourceDescriptorRelationCount property.
     * 
     */
    public int getSourceDescriptorRelationCount() {
        return sourceDescriptorRelationCount;
    }

    /**
     * Sets the value of the sourceDescriptorRelationCount property.
     * 
     */
    public void setSourceDescriptorRelationCount(int value) {
        this.sourceDescriptorRelationCount = value;
    }

    /**
     * Gets the value of the subsetMemberCount property.
     * 
     */
    public int getSubsetMemberCount() {
        return subsetMemberCount;
    }

    /**
     * Sets the value of the subsetMemberCount property.
     * 
     */
    public void setSubsetMemberCount(int value) {
        this.subsetMemberCount = value;
    }

    /**
     * Gets the value of the termString property.
     * 
     * @return
     *     possible object is
     *     {@link TermStringDTO }
     *     
     */
    public TermStringDTO getTermString() {
        return termString;
    }

    /**
     * Sets the value of the termString property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermStringDTO }
     *     
     */
    public void setTermString(TermStringDTO value) {
        this.termString = value;
    }

    /**
     * Gets the value of the termType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermType() {
        return termType;
    }

    /**
     * Sets the value of the termType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermType(String value) {
        this.termType = value;
    }

    /**
     * Gets the value of the treePositionCount property.
     * 
     */
    public int getTreePositionCount() {
        return treePositionCount;
    }

    /**
     * Sets the value of the treePositionCount property.
     * 
     */
    public void setTreePositionCount(int value) {
        this.treePositionCount = value;
    }

}
