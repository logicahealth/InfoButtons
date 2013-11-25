
package UtsSemNet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for semanticTypeGroupDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="semanticTypeGroupDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.uts.umls.nlm.nih.gov/}validDTO">
 *       &lt;sequence>
 *         &lt;element name="semanticTypeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "semanticTypeGroupDTO", propOrder = {
    "semanticTypeCount"
})
public class SemanticTypeGroupDTO
    extends ValidDTO
{

    protected int semanticTypeCount;

    /**
     * Gets the value of the semanticTypeCount property.
     * 
     */
    public int getSemanticTypeCount() {
        return semanticTypeCount;
    }

    /**
     * Sets the value of the semanticTypeCount property.
     * 
     */
    public void setSemanticTypeCount(int value) {
        this.semanticTypeCount = value;
    }

}
