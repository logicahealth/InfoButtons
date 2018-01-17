package io.swagger.api;

import io.swagger.model.*;

import io.swagger.annotations.*;

import org.hl7.v3.AggregateKnowledgeResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static utils.XmlUtil.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-26T20:35:01.320Z")

@Controller
public class CdsServicesApiController implements CdsServicesApi {




    public ResponseEntity<CDSServiceInformation> cdsServicesGet() {
        // do some magic!
        CDSServiceInformation information = new CDSServiceInformation();
        CDSService service = new CDSService();
        service.setHook(Hook.MEDICATION_PRESCRIBE);
        service.setTitle("OpenInfobutton Knowledge Response Service");
        service.description("A Protype OpenInfobutton to CDS-Hooks Wrapper");
        service.setId("oibResponse");
        information.addServicesItem(service);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<CDSServiceInformation>(information, headers, HttpStatus.OK);
    }

    public ResponseEntity<Void> cdsServicesIdAnalyticsUuidPost(@ApiParam(value = "The id of this CDS service",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "The UUID of the event (for example, a suggestion)",required=true ) @PathVariable("uuid") String uuid) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<CDSResponse> cdsServicesIdPost(@ApiParam(value = "The id of this CDS service",required=true ) @PathVariable("id") String id,
        @ApiParam(value = "Body of CDS service request" ,required=true )  @Valid @RequestBody CDSRequest request) {
        HashMap context = (HashMap)request.getContext().get(0);
        HashMap codes = ((HashMap) ((List) ((HashMap) context.get("medicationCodeableConcept")).get("coding")).get(0));
        String oibResponse = new RestTemplate().getForObject("http://service.oib.utah.edu:8080/infobutton-service/infoRequest?representedOrganization.id.root=cdshookstest.org&taskContext.c.c=MLREV&mainSearchCriteria.v.c=" + codes.get("code") +"&mainSearchCriteria.v.cs=2.16.840.1.113883.6.88&mainSearchCriteria.v.dn=" + codes.get("display") +"&knowledgeResponseType=application/xml", String.class);
        String title = "";
        String link = "";
        String label = "";
        String url = "";
        CDSResponse response = new CDSResponse();
        Card oibCard;
        List<Link> links;
        Link oibLink;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(oibResponse.getBytes())));
            doc.getDocumentElement().normalize();
            Element eElement;
            NodeList nodes = (NodeList)doc.getElementsByTagName("feed");
            for (Node n : asList(doc.getElementsByTagName("feed")))
            {
                oibCard = new Card();
                oibCard.setSummary("Patient education on " + codes.get("display"));
                oibCard.setDetail("");
                oibCard.setIndicator(Card.IndicatorEnum.INFO);
                eElement = (Element)n;
                label = eElement.getElementsByTagName("title").item(0).getTextContent();
                Source source = new Source();
                links = new ArrayList<>();
                for (Node nl : asList(eElement.getElementsByTagName("entry")))
                {
                    oibLink = new Link();
                    eElement = (Element)nl;
                    title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    link = eElement.getElementsByTagName("link").item(0).getAttributes().getNamedItem("href").getTextContent();
                    URI uri = new URI(link);
                    url = "http://" + uri.getHost();
                    oibLink.setLabel(title);
                    oibLink.setUrl(link);
                    oibLink.setType("online");
                    links.add(oibLink);
                    if (links.size() >= 3 )
                    {
                        break;
                    }
                }
                oibCard.setSuggestions(new ArrayList<Suggestion>());
                oibCard.setLinks(links);
                source.setLabel(label);
                source.setUrl(url);
                oibCard.setSource(source);
                response.addCardsItem(oibCard);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<CDSResponse>(response, headers, HttpStatus.OK);
    }



}
