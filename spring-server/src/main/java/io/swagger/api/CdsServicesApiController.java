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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    private static final Map<String, String> genders;
    static {

        Map<String, String> map = new HashMap<>();
        map.put("male", "M");
        map.put("female", "F");
        genders = Collections.unmodifiableMap(map);
    }

    public ResponseEntity<CDSServiceInformation> cdsServicesGet() {
        // do some magic!
        CDSServiceInformation information = new CDSServiceInformation();
        CDSService service = new CDSService();
        service.setHook(Hook.MEDICATION_PRESCRIBE);
        service.setTitle("OpenInfobutton Knowledge Response Service");
        service.description("A Protype OpenInfobutton to CDS-Hooks Wrapper");
        service.setId("oibResponseMedications");
        information.addServicesItem(service);
        CDSService probservice = new CDSService();
        probservice.setHook(Hook.PATIENT_VIEW);
        probservice.setTitle("OpenInfobutton Knowledge Response Service");
        probservice.description("A Protype OpenInfobutton to CDS-Hooks Wrapper");
        probservice.setId("oibResponseConditions");
        information.addServicesItem(probservice);
        Prefetch prefetch = new Prefetch();
        prefetch.put("problems" , "Condition?patient={{context.patientId}}&_sort=clinicalstatus&_sort:desc=onset");
        prefetch.put("p", "Patient/{{context.patientId}}");
        service.setPrefetch(prefetch);
        probservice.setPrefetch(prefetch);
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
        if (request.getHook().equals(Hook.MEDICATION_PRESCRIBE)) {
            HashMap context = (HashMap) request.getContext();
            HashMap codes;
            if (((HashMap) context.get("medicationCodeableConcept")) != null) {

                codes = ((HashMap) ((List) ((HashMap) context.get("medicationCodeableConcept")).get("coding")).get(0));
            } else {

                codes = ((HashMap) ((List) ((HashMap) ((HashMap) ((HashMap) ((List) ((HashMap) context.get("medications")).get("entry")).get(0)).get("resource")).get("medicationCodeableConcept")).get("coding")).get(0));
            }
            String oibAge = new String();
            String oibGender = new String();
            if (!((HashMap) request.getPrefetch()).isEmpty()) {
                HashMap patientContext = (HashMap) ((HashMap) ((HashMap) request.getPrefetch()).get("p")).get("resource");
                String gender = (String) patientContext.get("gender");
                String birthDate = (String) patientContext.get("birthDate");
                oibAge = "&age.v.v=" + birthDateToAge(birthDate) + "&age.v.u=a";
                oibGender = "&patientPerson.administrativeGenderCode.c=" + genders.get(gender) + "&patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1";
            }
            String oibRequest = "http://service.oib.utah.edu:8080/infobutton-service/infoRequest?representedOrganization.id.root=cdshookstest.org&taskContext.c.c=MLREV&mainSearchCriteria.v.c=" + codes.get("code") + "&mainSearchCriteria.v.cs=2.16.840.1.113883.6.88&mainSearchCriteria.v.dn=" + codes.get("display") + oibAge + oibGender + "&performer=PROV&knowledgeResponseType=application/xml";
            String oibResponse = new RestTemplate().getForObject(oibRequest, String.class);
            return getHooksResponse(oibResponse);
        } else if (request.getHook().equals(Hook.PATIENT_VIEW))
        {

            String oibAge = new String();
            String oibGender = new String();
            String problemCode = new String();
            String problemName = new String();
            if (!((HashMap) request.getPrefetch()).isEmpty()) {
                HashMap patientContext = (HashMap) ((HashMap) ((HashMap) request.getPrefetch()).get("p")).get("resource");
                String gender = (String) patientContext.get("gender");
                String birthDate = (String) patientContext.get("birthDate");
                oibAge = "&age.v.v=" + birthDateToAge(birthDate) + "&age.v.u=a";
                oibGender = "&patientPerson.administrativeGenderCode.c=" + genders.get(gender) + "&patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1";
                HashMap problems = (HashMap) ((HashMap) ((HashMap) request.getPrefetch()).get("problems")).get("resource");
                HashMap problem = ((HashMap) ((ArrayList) ((HashMap) ((HashMap) ((HashMap) ((ArrayList) problems.get("entry")).get(0)).get("resource")).get("code")).get("coding")).get(0));
                problemCode = ((String) problem.get("code"));
                problemName = ((String) problem.get("display"));

            }
            String oibRequest = "http://service.oib.utah.edu:8080/infobutton-service/infoRequest?representedOrganization.id.root=cdshookstest.org&taskContext.c.c=PROBLISTREV&mainSearchCriteria.v.c=" + problemCode + "&mainSearchCriteria.v.cs=2.16.840.1.113883.6.96&mainSearchCriteria.v.dn=" + problemName + oibAge + oibGender + "&performer=PROV&knowledgeResponseType=application/xml";
            String oibResponse = new RestTemplate().getForObject(oibRequest, String.class);

            return getHooksResponse(oibResponse);
        }
        return null;
    }


    private int birthDateToAge (String birthDateString)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = new Date();
        try {

            dateOfBirth = dateFormat.parse(birthDateString);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(dateOfBirth);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("You don't exist yet");
        }
        int todayYear = today.get(Calendar.YEAR);
        int birthDateYear = birthDate.get(Calendar.YEAR);
        int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
        int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
        int todayMonth = today.get(Calendar.MONTH);
        int birthDateMonth = birthDate.get(Calendar.MONTH);
        int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
        int age = todayYear - birthDateYear;

        // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
        if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
            age--;

            // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
        } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
            age--;
        }
        return age;
    }

    private ResponseEntity getHooksResponse (String oibResponse) {

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
            NodeList nodes = (NodeList) doc.getElementsByTagName("feed");
            for (Node n : asList(doc.getElementsByTagName("feed"))) {
                oibCard = new Card();
                oibCard.setIndicator(Card.IndicatorEnum.INFO);
                oibCard.setDetail("");
                eElement = (Element) n;
                label = eElement.getElementsByTagName("title").item(0).getTextContent();
                if (!label.equals("MedlinePlus"))
                {

                    oibCard.setSummary("Information on " + eElement.getElementsByTagName("subtitle").item(0).getTextContent());
                } else {

                    oibCard.setSummary("Patient education on " + eElement.getElementsByTagName("subtitle").item(0).getTextContent());
                }
                Source source = new Source();
                links = new ArrayList<>();
                for (Node nl : asList(eElement.getElementsByTagName("entry"))) {
                    oibLink = new Link();
                    eElement = (Element) nl;
                    title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    link = eElement.getElementsByTagName("link").item(0).getAttributes().getNamedItem("href").getTextContent();
                    URI uri = new URI(link);
                    url = "http://" + uri.getHost();
                    oibLink.setLabel(title);
                    oibLink.setUrl(link);
                    if (eElement.getElementsByTagName("summary").item(0) != null && oibCard.getDetail().isEmpty()) {
                        oibCard.setDetail(eElement.getElementsByTagName("summary").item(0).getTextContent());
                    }
                    oibLink.setType("absolute");
                    links.add(oibLink);
                    if (links.size() >= 3) {
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
