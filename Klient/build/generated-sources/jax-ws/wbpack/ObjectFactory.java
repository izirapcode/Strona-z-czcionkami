
package wbpack;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wbpack package. 
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

    private final static QName _DajCzcionki_QNAME = new QName("http://wbpack/", "dajCzcionki");
    private final static QName _DajCzcionkiResponse_QNAME = new QName("http://wbpack/", "dajCzcionkiResponse");
    private final static QName _DodajCzcionke_QNAME = new QName("http://wbpack/", "dodajCzcionke");
    private final static QName _Hello_QNAME = new QName("http://wbpack/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://wbpack/", "helloResponse");
    private final static QName _UsunCzcionke_QNAME = new QName("http://wbpack/", "usunCzcionke");
    private final static QName _DodajCzcionkeData_QNAME = new QName("", "data");
    private final static QName _DajCzcionkiResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wbpack
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DajCzcionki }
     * 
     */
    public DajCzcionki createDajCzcionki() {
        return new DajCzcionki();
    }

    /**
     * Create an instance of {@link DajCzcionkiResponse }
     * 
     */
    public DajCzcionkiResponse createDajCzcionkiResponse() {
        return new DajCzcionkiResponse();
    }

    /**
     * Create an instance of {@link DodajCzcionke }
     * 
     */
    public DodajCzcionke createDodajCzcionke() {
        return new DodajCzcionke();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link UsunCzcionke }
     * 
     */
    public UsunCzcionke createUsunCzcionke() {
        return new UsunCzcionke();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DajCzcionki }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wbpack/", name = "dajCzcionki")
    public JAXBElement<DajCzcionki> createDajCzcionki(DajCzcionki value) {
        return new JAXBElement<DajCzcionki>(_DajCzcionki_QNAME, DajCzcionki.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DajCzcionkiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wbpack/", name = "dajCzcionkiResponse")
    public JAXBElement<DajCzcionkiResponse> createDajCzcionkiResponse(DajCzcionkiResponse value) {
        return new JAXBElement<DajCzcionkiResponse>(_DajCzcionkiResponse_QNAME, DajCzcionkiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DodajCzcionke }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wbpack/", name = "dodajCzcionke")
    public JAXBElement<DodajCzcionke> createDodajCzcionke(DodajCzcionke value) {
        return new JAXBElement<DodajCzcionke>(_DodajCzcionke_QNAME, DodajCzcionke.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wbpack/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wbpack/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsunCzcionke }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wbpack/", name = "usunCzcionke")
    public JAXBElement<UsunCzcionke> createUsunCzcionke(UsunCzcionke value) {
        return new JAXBElement<UsunCzcionke>(_UsunCzcionke_QNAME, UsunCzcionke.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "data", scope = DodajCzcionke.class)
    public JAXBElement<byte[]> createDodajCzcionkeData(byte[] value) {
        return new JAXBElement<byte[]>(_DodajCzcionkeData_QNAME, byte[].class, DodajCzcionke.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = DajCzcionkiResponse.class)
    public JAXBElement<byte[]> createDajCzcionkiResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_DajCzcionkiResponseReturn_QNAME, byte[].class, DajCzcionkiResponse.class, ((byte[]) value));
    }

}
