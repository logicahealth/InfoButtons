
package UtsMetathesaurusHistory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the UtsMetathesaurusHistory package. 
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

    private final static QName _GetMergedToConceptCuiResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getMergedToConceptCuiResponse");
    private final static QName _GetConceptMergesResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getConceptMergesResponse");
    private final static QName _GetBequeathedToConceptCuisResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getBequeathedToConceptCuisResponse");
    private final static QName _GetMovedToConceptCuiResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getMovedToConceptCuiResponse");
    private final static QName _GetMergedToTermUi_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getMergedToTermUi");
    private final static QName _GetConceptMerges_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getConceptMerges");
    private final static QName _GetTermStringDeletionsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getTermStringDeletionsResponse");
    private final static QName _GetSourceAtomChangesResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getSourceAtomChangesResponse");
    private final static QName _GetConceptBequeathalsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getConceptBequeathalsResponse");
    private final static QName _GetConceptBequeathals_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getConceptBequeathals");
    private final static QName _GetMergedToTermUiResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getMergedToTermUiResponse");
    private final static QName _GetMergedToConceptCui_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getMergedToConceptCui");
    private final static QName _GetTermMerges_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getTermMerges");
    private final static QName _GetConceptDeletionsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getConceptDeletionsResponse");
    private final static QName _GetTermStringDeletions_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getTermStringDeletions");
    private final static QName _GetConceptDeletions_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getConceptDeletions");
    private final static QName _GetAtomMovementsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getAtomMovementsResponse");
    private final static QName _GetAtomMovements_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getAtomMovements");
    private final static QName _GetTermDeletions_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getTermDeletions");
    private final static QName _GetBequeathedToConceptCuis_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getBequeathedToConceptCuis");
    private final static QName _GetSourceAtomChanges_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getSourceAtomChanges");
    private final static QName _GetTermMergesResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getTermMergesResponse");
    private final static QName _GetTermDeletionsResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getTermDeletionsResponse");
    private final static QName _GetMovedToConceptCui_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getMovedToConceptCui");
    private final static QName _UtsFault_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "UtsFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: UtsMetathesaurusHistory
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetConceptBequeathals }
     * 
     */
    public GetConceptBequeathals createGetConceptBequeathals() {
        return new GetConceptBequeathals();
    }

    /**
     * Create an instance of {@link SourceAtomChangeDTO }
     * 
     */
    public SourceAtomChangeDTO createSourceAtomChangeDTO() {
        return new SourceAtomChangeDTO();
    }

    /**
     * Create an instance of {@link GetMovedToConceptCuiResponse }
     * 
     */
    public GetMovedToConceptCuiResponse createGetMovedToConceptCuiResponse() {
        return new GetMovedToConceptCuiResponse();
    }

    /**
     * Create an instance of {@link GetTermDeletionsResponse }
     * 
     */
    public GetTermDeletionsResponse createGetTermDeletionsResponse() {
        return new GetTermDeletionsResponse();
    }

    /**
     * Create an instance of {@link GetTermStringDeletions }
     * 
     */
    public GetTermStringDeletions createGetTermStringDeletions() {
        return new GetTermStringDeletions();
    }

    /**
     * Create an instance of {@link GetTermStringDeletionsResponse }
     * 
     */
    public GetTermStringDeletionsResponse createGetTermStringDeletionsResponse() {
        return new GetTermStringDeletionsResponse();
    }

    /**
     * Create an instance of {@link GetConceptMerges }
     * 
     */
    public GetConceptMerges createGetConceptMerges() {
        return new GetConceptMerges();
    }

    /**
     * Create an instance of {@link GetMergedToTermUiResponse }
     * 
     */
    public GetMergedToTermUiResponse createGetMergedToTermUiResponse() {
        return new GetMergedToTermUiResponse();
    }

    /**
     * Create an instance of {@link GetAtomMovements }
     * 
     */
    public GetAtomMovements createGetAtomMovements() {
        return new GetAtomMovements();
    }

    /**
     * Create an instance of {@link GetSourceAtomChangesResponse }
     * 
     */
    public GetSourceAtomChangesResponse createGetSourceAtomChangesResponse() {
        return new GetSourceAtomChangesResponse();
    }

    /**
     * Create an instance of {@link TermStringDeathDTO }
     * 
     */
    public TermStringDeathDTO createTermStringDeathDTO() {
        return new TermStringDeathDTO();
    }

    /**
     * Create an instance of {@link ConceptBequeathalDTO }
     * 
     */
    public ConceptBequeathalDTO createConceptBequeathalDTO() {
        return new ConceptBequeathalDTO();
    }

    /**
     * Create an instance of {@link GetConceptBequeathalsResponse }
     * 
     */
    public GetConceptBequeathalsResponse createGetConceptBequeathalsResponse() {
        return new GetConceptBequeathalsResponse();
    }

    /**
     * Create an instance of {@link GetTermMerges }
     * 
     */
    public GetTermMerges createGetTermMerges() {
        return new GetTermMerges();
    }

    /**
     * Create an instance of {@link GetConceptDeletions }
     * 
     */
    public GetConceptDeletions createGetConceptDeletions() {
        return new GetConceptDeletions();
    }

    /**
     * Create an instance of {@link ChangeRecordDTO }
     * 
     */
    public ChangeRecordDTO createChangeRecordDTO() {
        return new ChangeRecordDTO();
    }

    /**
     * Create an instance of {@link GetBequeathedToConceptCuis }
     * 
     */
    public GetBequeathedToConceptCuis createGetBequeathedToConceptCuis() {
        return new GetBequeathedToConceptCuis();
    }

    /**
     * Create an instance of {@link ConceptDeathDTO }
     * 
     */
    public ConceptDeathDTO createConceptDeathDTO() {
        return new ConceptDeathDTO();
    }

    /**
     * Create an instance of {@link GetTermMergesResponse }
     * 
     */
    public GetTermMergesResponse createGetTermMergesResponse() {
        return new GetTermMergesResponse();
    }

    /**
     * Create an instance of {@link ConceptMergeDTO }
     * 
     */
    public ConceptMergeDTO createConceptMergeDTO() {
        return new ConceptMergeDTO();
    }

    /**
     * Create an instance of {@link GetAtomMovementsResponse }
     * 
     */
    public GetAtomMovementsResponse createGetAtomMovementsResponse() {
        return new GetAtomMovementsResponse();
    }

    /**
     * Create an instance of {@link GetTermDeletions }
     * 
     */
    public GetTermDeletions createGetTermDeletions() {
        return new GetTermDeletions();
    }

    /**
     * Create an instance of {@link TermMergeDTO }
     * 
     */
    public TermMergeDTO createTermMergeDTO() {
        return new TermMergeDTO();
    }

    /**
     * Create an instance of {@link GetMovedToConceptCui }
     * 
     */
    public GetMovedToConceptCui createGetMovedToConceptCui() {
        return new GetMovedToConceptCui();
    }

    /**
     * Create an instance of {@link UtsFault }
     * 
     */
    public UtsFault createUtsFault() {
        return new UtsFault();
    }

    /**
     * Create an instance of {@link AtomMovementDTO }
     * 
     */
    public AtomMovementDTO createAtomMovementDTO() {
        return new AtomMovementDTO();
    }

    /**
     * Create an instance of {@link TermDeathDTO }
     * 
     */
    public TermDeathDTO createTermDeathDTO() {
        return new TermDeathDTO();
    }

    /**
     * Create an instance of {@link GetMergedToConceptCuiResponse }
     * 
     */
    public GetMergedToConceptCuiResponse createGetMergedToConceptCuiResponse() {
        return new GetMergedToConceptCuiResponse();
    }

    /**
     * Create an instance of {@link GetConceptDeletionsResponse }
     * 
     */
    public GetConceptDeletionsResponse createGetConceptDeletionsResponse() {
        return new GetConceptDeletionsResponse();
    }

    /**
     * Create an instance of {@link GetSourceAtomChanges }
     * 
     */
    public GetSourceAtomChanges createGetSourceAtomChanges() {
        return new GetSourceAtomChanges();
    }

    /**
     * Create an instance of {@link GetBequeathedToConceptCuisResponse }
     * 
     */
    public GetBequeathedToConceptCuisResponse createGetBequeathedToConceptCuisResponse() {
        return new GetBequeathedToConceptCuisResponse();
    }

    /**
     * Create an instance of {@link GetConceptMergesResponse }
     * 
     */
    public GetConceptMergesResponse createGetConceptMergesResponse() {
        return new GetConceptMergesResponse();
    }

    /**
     * Create an instance of {@link GetMergedToTermUi }
     * 
     */
    public GetMergedToTermUi createGetMergedToTermUi() {
        return new GetMergedToTermUi();
    }

    /**
     * Create an instance of {@link GetMergedToConceptCui }
     * 
     */
    public GetMergedToConceptCui createGetMergedToConceptCui() {
        return new GetMergedToConceptCui();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMergedToConceptCuiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getMergedToConceptCuiResponse")
    public JAXBElement<GetMergedToConceptCuiResponse> createGetMergedToConceptCuiResponse(GetMergedToConceptCuiResponse value) {
        return new JAXBElement<GetMergedToConceptCuiResponse>(_GetMergedToConceptCuiResponse_QNAME, GetMergedToConceptCuiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConceptMergesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getConceptMergesResponse")
    public JAXBElement<GetConceptMergesResponse> createGetConceptMergesResponse(GetConceptMergesResponse value) {
        return new JAXBElement<GetConceptMergesResponse>(_GetConceptMergesResponse_QNAME, GetConceptMergesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBequeathedToConceptCuisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getBequeathedToConceptCuisResponse")
    public JAXBElement<GetBequeathedToConceptCuisResponse> createGetBequeathedToConceptCuisResponse(GetBequeathedToConceptCuisResponse value) {
        return new JAXBElement<GetBequeathedToConceptCuisResponse>(_GetBequeathedToConceptCuisResponse_QNAME, GetBequeathedToConceptCuisResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovedToConceptCuiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getMovedToConceptCuiResponse")
    public JAXBElement<GetMovedToConceptCuiResponse> createGetMovedToConceptCuiResponse(GetMovedToConceptCuiResponse value) {
        return new JAXBElement<GetMovedToConceptCuiResponse>(_GetMovedToConceptCuiResponse_QNAME, GetMovedToConceptCuiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMergedToTermUi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getMergedToTermUi")
    public JAXBElement<GetMergedToTermUi> createGetMergedToTermUi(GetMergedToTermUi value) {
        return new JAXBElement<GetMergedToTermUi>(_GetMergedToTermUi_QNAME, GetMergedToTermUi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConceptMerges }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getConceptMerges")
    public JAXBElement<GetConceptMerges> createGetConceptMerges(GetConceptMerges value) {
        return new JAXBElement<GetConceptMerges>(_GetConceptMerges_QNAME, GetConceptMerges.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTermStringDeletionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getTermStringDeletionsResponse")
    public JAXBElement<GetTermStringDeletionsResponse> createGetTermStringDeletionsResponse(GetTermStringDeletionsResponse value) {
        return new JAXBElement<GetTermStringDeletionsResponse>(_GetTermStringDeletionsResponse_QNAME, GetTermStringDeletionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSourceAtomChangesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getSourceAtomChangesResponse")
    public JAXBElement<GetSourceAtomChangesResponse> createGetSourceAtomChangesResponse(GetSourceAtomChangesResponse value) {
        return new JAXBElement<GetSourceAtomChangesResponse>(_GetSourceAtomChangesResponse_QNAME, GetSourceAtomChangesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConceptBequeathalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getConceptBequeathalsResponse")
    public JAXBElement<GetConceptBequeathalsResponse> createGetConceptBequeathalsResponse(GetConceptBequeathalsResponse value) {
        return new JAXBElement<GetConceptBequeathalsResponse>(_GetConceptBequeathalsResponse_QNAME, GetConceptBequeathalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConceptBequeathals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getConceptBequeathals")
    public JAXBElement<GetConceptBequeathals> createGetConceptBequeathals(GetConceptBequeathals value) {
        return new JAXBElement<GetConceptBequeathals>(_GetConceptBequeathals_QNAME, GetConceptBequeathals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMergedToTermUiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getMergedToTermUiResponse")
    public JAXBElement<GetMergedToTermUiResponse> createGetMergedToTermUiResponse(GetMergedToTermUiResponse value) {
        return new JAXBElement<GetMergedToTermUiResponse>(_GetMergedToTermUiResponse_QNAME, GetMergedToTermUiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMergedToConceptCui }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getMergedToConceptCui")
    public JAXBElement<GetMergedToConceptCui> createGetMergedToConceptCui(GetMergedToConceptCui value) {
        return new JAXBElement<GetMergedToConceptCui>(_GetMergedToConceptCui_QNAME, GetMergedToConceptCui.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTermMerges }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getTermMerges")
    public JAXBElement<GetTermMerges> createGetTermMerges(GetTermMerges value) {
        return new JAXBElement<GetTermMerges>(_GetTermMerges_QNAME, GetTermMerges.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConceptDeletionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getConceptDeletionsResponse")
    public JAXBElement<GetConceptDeletionsResponse> createGetConceptDeletionsResponse(GetConceptDeletionsResponse value) {
        return new JAXBElement<GetConceptDeletionsResponse>(_GetConceptDeletionsResponse_QNAME, GetConceptDeletionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTermStringDeletions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getTermStringDeletions")
    public JAXBElement<GetTermStringDeletions> createGetTermStringDeletions(GetTermStringDeletions value) {
        return new JAXBElement<GetTermStringDeletions>(_GetTermStringDeletions_QNAME, GetTermStringDeletions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConceptDeletions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getConceptDeletions")
    public JAXBElement<GetConceptDeletions> createGetConceptDeletions(GetConceptDeletions value) {
        return new JAXBElement<GetConceptDeletions>(_GetConceptDeletions_QNAME, GetConceptDeletions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAtomMovementsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getAtomMovementsResponse")
    public JAXBElement<GetAtomMovementsResponse> createGetAtomMovementsResponse(GetAtomMovementsResponse value) {
        return new JAXBElement<GetAtomMovementsResponse>(_GetAtomMovementsResponse_QNAME, GetAtomMovementsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAtomMovements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getAtomMovements")
    public JAXBElement<GetAtomMovements> createGetAtomMovements(GetAtomMovements value) {
        return new JAXBElement<GetAtomMovements>(_GetAtomMovements_QNAME, GetAtomMovements.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTermDeletions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getTermDeletions")
    public JAXBElement<GetTermDeletions> createGetTermDeletions(GetTermDeletions value) {
        return new JAXBElement<GetTermDeletions>(_GetTermDeletions_QNAME, GetTermDeletions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBequeathedToConceptCuis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getBequeathedToConceptCuis")
    public JAXBElement<GetBequeathedToConceptCuis> createGetBequeathedToConceptCuis(GetBequeathedToConceptCuis value) {
        return new JAXBElement<GetBequeathedToConceptCuis>(_GetBequeathedToConceptCuis_QNAME, GetBequeathedToConceptCuis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSourceAtomChanges }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getSourceAtomChanges")
    public JAXBElement<GetSourceAtomChanges> createGetSourceAtomChanges(GetSourceAtomChanges value) {
        return new JAXBElement<GetSourceAtomChanges>(_GetSourceAtomChanges_QNAME, GetSourceAtomChanges.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTermMergesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getTermMergesResponse")
    public JAXBElement<GetTermMergesResponse> createGetTermMergesResponse(GetTermMergesResponse value) {
        return new JAXBElement<GetTermMergesResponse>(_GetTermMergesResponse_QNAME, GetTermMergesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTermDeletionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getTermDeletionsResponse")
    public JAXBElement<GetTermDeletionsResponse> createGetTermDeletionsResponse(GetTermDeletionsResponse value) {
        return new JAXBElement<GetTermDeletionsResponse>(_GetTermDeletionsResponse_QNAME, GetTermDeletionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovedToConceptCui }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getMovedToConceptCui")
    public JAXBElement<GetMovedToConceptCui> createGetMovedToConceptCui(GetMovedToConceptCui value) {
        return new JAXBElement<GetMovedToConceptCui>(_GetMovedToConceptCui_QNAME, GetMovedToConceptCui.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UtsFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "UtsFault")
    public JAXBElement<UtsFault> createUtsFault(UtsFault value) {
        return new JAXBElement<UtsFault>(_UtsFault_QNAME, UtsFault.class, null, value);
    }

}
