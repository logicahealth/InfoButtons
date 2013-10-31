
package UtsMetathesaurusContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sourceAtomClusterDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sourceAtomClusterDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}atomClusterDTO">
 *       &lt;sequence>
 *         &lt;element name="atomCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="atomRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codeRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="definitionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="literal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="obsolete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rootSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceConceptRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceDescriptorRelationCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceOriginated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sourceUi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subsetMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="treePositionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cVMemberCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceAtomClusterDTO", propOrder = {
    "atomCount",
    "atomRelationCount",
    "attributeCount",
    "codeRelationCount",
    "definitionCount",
    "literal",
    "obsolete",
    "rootSource",
    "sourceConceptRelationCount",
    "sourceDescriptorRelationCount",
    "sourceOriginated",
    "sourceUi",
    "subType",
    "subsetMemberCount",
    "treePositionCount",
    "cvMemberCount"
})
public class SourceAtomClusterDTO
    extends AtomClusterDTO
{

    protected int atomCount;
    protected int atomRelationCount;
    protected int attributeCount;
    protected int codeRelationCount;
    protected int definitionCount;
    protected boolean literal;
    protected boolean obsolete;
    protected String rootSource;
    protected int sourceConceptRelationCount;
    protected int sourceDescriptorRelationCount;
    protected boolean sourceOriginated;
    protected String sourceUi;
    protected String subType;
    protected int subsetMemberCount;
    protected int treePositionCount;
    @XmlElement(name = "cVMemberCount")
    protected int cvMemberCount;

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
     * Gets the value of the literal property.
     * 
     */
    public boolean isLiteral() {
        return literal;
    }

    /**
     * Sets the value of the literal property.
     * 
     */
    public void setLiteral(boolean value) {
        this.literal = value;
    }

    /**
     * Gets the value of the obsolete property.
     * 
     */
    public boolean isObsolete() {
        return obsolete;
    }

    /**
     * Sets the value of the obsolete property.
     * 
     */
    public void setObsolete(boolean value) {
        this.obsolete = value;
    }

    /**
     * Gets the value of the rootSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootSource() {
        return rootSource;
    }

    /**
     * Sets the value of the rootSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootSource(String value) {
        this.rootSource = value;
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
     * Gets the value of the sourceOriginated property.
     * 
     */
    public boolean isSourceOriginated() {
        return sourceOriginated;
    }

    /**
     * Sets the value of the sourceOriginated property.
     * 
     */
    public void setSourceOriginated(boolean value) {
        this.sourceOriginated = value;
    }

    /**
     * Gets the value of the sourceUi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceUi() {
        return sourceUi;
    }

    /**
     * Sets the value of the sourceUi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceUi(String value) {
        this.sourceUi = value;
    }

    /**
     * Gets the value of the subType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubType(String value) {
        this.subType = value;
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

    /**
     * Gets the value of the cvMemberCount property.
     * 
     */
    public int getCVMemberCount() {
        return cvMemberCount;
    }

    /**
     * Sets the value of the cvMemberCount property.
     * 
     */
    public void setCVMemberCount(int value) {
        this.cvMemberCount = value;
    }

}
