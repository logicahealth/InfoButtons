
package UtsMetathesaurusFinder;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the UtsMetathesaurusFinder package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindConceptsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findConceptsResponse");
    private final static QName _FindSourceDescriptorsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findSourceDescriptorsResponse");
    private final static QName _FindSourceDescriptors_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findSourceDescriptors");
    private final static QName _FindCodesResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findCodesResponse");
    private final static QName _GetCountResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getCountResponse");
    private final static QName _FindCodes_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findCodes");
    private final static QName _FindConcepts_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findConcepts");
    private final static QName _FindSourceConcepts_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findSourceConcepts");
    private final static QName _FindAtomsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findAtomsResponse");
    private final static QName _FindSourceConceptsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findSourceConceptsResponse");
    private final static QName _UtsFault_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "UtsFault");
    private final static QName _FindAtoms_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "findAtoms");
    private final static QName _GetCount_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getCount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: UtsMetathesaurusFinder
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindConceptsResponse }
     * 
     */
    public FindConceptsResponse createFindConceptsResponse() {
        return new FindConceptsResponse();
    }

    /**
     * Create an instance of {@link FindSourceConcepts }
     * 
     */
    public FindSourceConcepts createFindSourceConcepts() {
        return new FindSourceConcepts();
    }

    /**
     * Create an instance of {@link FindSourceDescriptors }
     * 
     */
    public FindSourceDescriptors createFindSourceDescriptors() {
        return new FindSourceDescriptors();
    }

    /**
     * Create an instance of {@link FindAtoms }
     * 
     */
    public FindAtoms createFindAtoms() {
        return new FindAtoms();
    }

    /**
     * Create an instance of {@link UiLabelRootSource }
     * 
     */
    public UiLabelRootSource createUiLabelRootSource() {
        return new UiLabelRootSource();
    }

    /**
     * Create an instance of {@link FindCodesResponse }
     * 
     */
    public FindCodesResponse createFindCodesResponse() {
        return new FindCodesResponse();
    }

    /**
     * Create an instance of {@link FindCodes }
     * 
     */
    public FindCodes createFindCodes() {
        return new FindCodes();
    }

    /**
     * Create an instance of {@link Psf }
     * 
     */
    public Psf createPsf() {
        return new Psf();
    }

    /**
     * Create an instance of {@link UtsFault }
     * 
     */
    public UtsFault createUtsFault() {
        return new UtsFault();
    }

    /**
     * Create an instance of {@link GetCount }
     * 
     */
    public GetCount createGetCount() {
        return new GetCount();
    }

    /**
     * Create an instance of {@link FindSourceDescriptorsResponse }
     * 
     */
    public FindSourceDescriptorsResponse createFindSourceDescriptorsResponse() {
        return new FindSourceDescriptorsResponse();
    }

    /**
     * Create an instance of {@link UiLabel }
     * 
     */
    public UiLabel createUiLabel() {
        return new UiLabel();
    }

    /**
     * Create an instance of {@link GetCountResponse }
     * 
     */
    public GetCountResponse createGetCountResponse() {
        return new GetCountResponse();
    }

    /**
     * Create an instance of {@link FindAtomsResponse }
     * 
     */
    public FindAtomsResponse createFindAtomsResponse() {
        return new FindAtomsResponse();
    }

    /**
     * Create an instance of {@link FindSourceConceptsResponse }
     * 
     */
    public FindSourceConceptsResponse createFindSourceConceptsResponse() {
        return new FindSourceConceptsResponse();
    }

    /**
     * Create an instance of {@link FindConcepts }
     * 
     */
    public FindConcepts createFindConcepts() {
        return new FindConcepts();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindConceptsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findConceptsResponse")
    public JAXBElement<FindConceptsResponse> createFindConceptsResponse(FindConceptsResponse value) {
        return new JAXBElement<FindConceptsResponse>(_FindConceptsResponse_QNAME, FindConceptsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSourceDescriptorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findSourceDescriptorsResponse")
    public JAXBElement<FindSourceDescriptorsResponse> createFindSourceDescriptorsResponse(FindSourceDescriptorsResponse value) {
        return new JAXBElement<FindSourceDescriptorsResponse>(_FindSourceDescriptorsResponse_QNAME, FindSourceDescriptorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSourceDescriptors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findSourceDescriptors")
    public JAXBElement<FindSourceDescriptors> createFindSourceDescriptors(FindSourceDescriptors value) {
        return new JAXBElement<FindSourceDescriptors>(_FindSourceDescriptors_QNAME, FindSourceDescriptors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCodesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findCodesResponse")
    public JAXBElement<FindCodesResponse> createFindCodesResponse(FindCodesResponse value) {
        return new JAXBElement<FindCodesResponse>(_FindCodesResponse_QNAME, FindCodesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getCountResponse")
    public JAXBElement<GetCountResponse> createGetCountResponse(GetCountResponse value) {
        return new JAXBElement<GetCountResponse>(_GetCountResponse_QNAME, GetCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCodes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findCodes")
    public JAXBElement<FindCodes> createFindCodes(FindCodes value) {
        return new JAXBElement<FindCodes>(_FindCodes_QNAME, FindCodes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindConcepts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findConcepts")
    public JAXBElement<FindConcepts> createFindConcepts(FindConcepts value) {
        return new JAXBElement<FindConcepts>(_FindConcepts_QNAME, FindConcepts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSourceConcepts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findSourceConcepts")
    public JAXBElement<FindSourceConcepts> createFindSourceConcepts(FindSourceConcepts value) {
        return new JAXBElement<FindSourceConcepts>(_FindSourceConcepts_QNAME, FindSourceConcepts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAtomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findAtomsResponse")
    public JAXBElement<FindAtomsResponse> createFindAtomsResponse(FindAtomsResponse value) {
        return new JAXBElement<FindAtomsResponse>(_FindAtomsResponse_QNAME, FindAtomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSourceConceptsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findSourceConceptsResponse")
    public JAXBElement<FindSourceConceptsResponse> createFindSourceConceptsResponse(FindSourceConceptsResponse value) {
        return new JAXBElement<FindSourceConceptsResponse>(_FindSourceConceptsResponse_QNAME, FindSourceConceptsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UtsFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "UtsFault")
    public JAXBElement<UtsFault> createUtsFault(UtsFault value) {
        return new JAXBElement<UtsFault>(_UtsFault_QNAME, UtsFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAtoms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "findAtoms")
    public JAXBElement<FindAtoms> createFindAtoms(FindAtoms value) {
        return new JAXBElement<FindAtoms>(_FindAtoms_QNAME, FindAtoms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getCount")
    public JAXBElement<GetCount> createGetCount(GetCount value) {
        return new JAXBElement<GetCount>(_GetCount_QNAME, GetCount.class, null, value);
    }

}
