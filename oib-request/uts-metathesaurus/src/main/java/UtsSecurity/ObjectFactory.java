
package UtsSecurity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the UtsSecurity package. 
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

    private final static QName _ValidateProxyTicketResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "validateProxyTicketResponse");
    private final static QName _GetProxyGrantTicketResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getProxyGrantTicketResponse");
    private final static QName _GetProxyTicket_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getProxyTicket");
    private final static QName _GetProxyTicketResponse_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getProxyTicketResponse");
    private final static QName _ValidateProxyTicket_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "validateProxyTicket");
    private final static QName _GetProxyGrantTicket_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "getProxyGrantTicket");
    private final static QName _UtsFault_QNAME = new QName("http://webservice.uts.umls.nlm.nih.gov/", "UtsFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: UtsSecurity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProxyGrantTicketResponse }
     * 
     */
    public GetProxyGrantTicketResponse createGetProxyGrantTicketResponse() {
        return new GetProxyGrantTicketResponse();
    }

    /**
     * Create an instance of {@link GetProxyGrantTicket }
     * 
     */
    public GetProxyGrantTicket createGetProxyGrantTicket() {
        return new GetProxyGrantTicket();
    }

    /**
     * Create an instance of {@link ValidateProxyTicketResponse }
     * 
     */
    public ValidateProxyTicketResponse createValidateProxyTicketResponse() {
        return new ValidateProxyTicketResponse();
    }

    /**
     * Create an instance of {@link ValidateProxyTicket }
     * 
     */
    public ValidateProxyTicket createValidateProxyTicket() {
        return new ValidateProxyTicket();
    }

    /**
     * Create an instance of {@link GetProxyTicketResponse }
     * 
     */
    public GetProxyTicketResponse createGetProxyTicketResponse() {
        return new GetProxyTicketResponse();
    }

    /**
     * Create an instance of {@link UtsFault }
     * 
     */
    public UtsFault createUtsFault() {
        return new UtsFault();
    }

    /**
     * Create an instance of {@link GetProxyTicket }
     * 
     */
    public GetProxyTicket createGetProxyTicket() {
        return new GetProxyTicket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateProxyTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "validateProxyTicketResponse")
    public JAXBElement<ValidateProxyTicketResponse> createValidateProxyTicketResponse(ValidateProxyTicketResponse value) {
        return new JAXBElement<ValidateProxyTicketResponse>(_ValidateProxyTicketResponse_QNAME, ValidateProxyTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProxyGrantTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getProxyGrantTicketResponse")
    public JAXBElement<GetProxyGrantTicketResponse> createGetProxyGrantTicketResponse(GetProxyGrantTicketResponse value) {
        return new JAXBElement<GetProxyGrantTicketResponse>(_GetProxyGrantTicketResponse_QNAME, GetProxyGrantTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProxyTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getProxyTicket")
    public JAXBElement<GetProxyTicket> createGetProxyTicket(GetProxyTicket value) {
        return new JAXBElement<GetProxyTicket>(_GetProxyTicket_QNAME, GetProxyTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProxyTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getProxyTicketResponse")
    public JAXBElement<GetProxyTicketResponse> createGetProxyTicketResponse(GetProxyTicketResponse value) {
        return new JAXBElement<GetProxyTicketResponse>(_GetProxyTicketResponse_QNAME, GetProxyTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateProxyTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "validateProxyTicket")
    public JAXBElement<ValidateProxyTicket> createValidateProxyTicket(ValidateProxyTicket value) {
        return new JAXBElement<ValidateProxyTicket>(_ValidateProxyTicket_QNAME, ValidateProxyTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProxyGrantTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.uts.umls.nlm.nih.gov/", name = "getProxyGrantTicket")
    public JAXBElement<GetProxyGrantTicket> createGetProxyGrantTicket(GetProxyGrantTicket value) {
        return new JAXBElement<GetProxyGrantTicket>(_GetProxyGrantTicket_QNAME, GetProxyGrantTicket.class, null, value);
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
