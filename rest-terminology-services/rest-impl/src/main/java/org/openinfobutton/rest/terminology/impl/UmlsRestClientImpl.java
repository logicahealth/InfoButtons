package org.openinfobutton.rest.terminology.impl;

import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

// Import log4j classes.
import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openinfobutton.rest.terminology.api.RestTermClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * This UMLS Rest Client uses the UMLS Rest API to search
 * for terminology content using a search string.
 *
 * -----------------------------------------------------------------------------------
 * (c) 2010-2016 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version March 13, 2016
 */
@Component
public class UmlsRestClientImpl implements RestTermClient {

    // Logger
    private static final Logger logger = LogManager.getLogger(UmlsRestClientImpl.class);

    /**
     *
     * UTS Search API paramaters
     *
     */

    private static String UTS_REST_API_URL = "https://uts-ws.nlm.nih.gov/rest";

    private static String SEARCH_PATH = "/search/current";

    private static String DESCENDANT_PATH = "/content/current/source/";

    private static String SEARCH_CODE_PATH = "/crosswalk/current/source";

    private static String SEARCH_PARAMETER = "string";

    private static String SEARCH_TYPE_PARAMETER = "searchType";

    private static String SEARCH_TYPE = "rightTruncation";

    private static String RETURN_TYPE_PARAMETER = "returnIdType";

    private static String RETURN_TYPE = "code";

    private static String CS_PARAMETER = "sabs";

    private String PAGE_SIZE_PARAMETER = "pageSize";

    private String PAGE_SIZE_VALUE = "1000";

    private static String TICKET_PARAMETER = "ticket";

    private String ticketGrantingTicketURL = "";

    @Autowired
    Environment env;

    private long lastUpdate = -1;

    /**
     *
     * UMLS Authentication parameters
     */

    private static String UMLS_AUTH_API_URL = "https://utslogin.nlm.nih.gov/cas/v1/tickets";

    /**
     *
     * UMLS Authentication parameters
     */

    private static String UMLS_AUTH_API_KEY_URL = "https://utslogin.nlm.nih.gov/cas/v1/api-key";

    /**
     *
     * @param search Search term
     * @return Array of search results serialized to JSON
     */
    public String getTerms (String search) {

        String sts = getSingleUseTicket();
        String result = "";
        logger.error("SEARCHING");
        try {
            URIBuilder b = new URIBuilder(UTS_REST_API_URL + SEARCH_PATH);
            b.addParameter(SEARCH_PARAMETER, search);
            b.addParameter(RETURN_TYPE_PARAMETER, RETURN_TYPE);
            b.addParameter(SEARCH_TYPE_PARAMETER, SEARCH_TYPE);
            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
            b.addParameter(TICKET_PARAMETER, sts);
            result = Request.Get(b.build())
                    .connectTimeout(3000)
                    .socketTimeout(3000)
                    .execute().returnContent().asString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.error("RESULTS: " + result);
        return result;
    }

    /**
     *
     * @param search Search term
     * @param codeSystem Code System
     * @return Array of search results serialized to JSON
     */
    public String getTerms (String search, String codeSystem){

        String sts = getSingleUseTicket();
        String result = "";
        logger.error("SEARCHING");
        try {
            URIBuilder b = new URIBuilder(UTS_REST_API_URL + SEARCH_PATH);
            b.addParameter(SEARCH_PARAMETER, search);
            b.addParameter(RETURN_TYPE_PARAMETER, RETURN_TYPE);
            b.addParameter(SEARCH_TYPE_PARAMETER, SEARCH_TYPE);
            b.addParameter(CS_PARAMETER, codeSystem);
            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
            b.addParameter(TICKET_PARAMETER, sts);

            result = Request.Get(b.build())
                    .connectTimeout(3000)
                    .socketTimeout(3000)
                    .execute().returnContent().asString();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.error("RESULTS: " + result);
        return result;
    }

    public String getCodes (String code, String codeSystem) {
        String sts = getSingleUseTicket();
        String result = "";
        String url = UTS_REST_API_URL + SEARCH_PATH;
        logger.error(codeSystem);

        try {
            URIBuilder b = new URIBuilder(url);

            b.addParameter(SEARCH_PARAMETER, code);
            b.addParameter("inputType", "sourceUi");
            b.addParameter("searchType", "exact");
            b.addParameter(CS_PARAMETER, codeSystem);
            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
            b.addParameter(TICKET_PARAMETER, sts);

            result = Request.Get(b.build())
                    .connectTimeout(3000)
                    .socketTimeout(3000)
                    .execute().returnContent().asString();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getCodes (String CUI, String targetCS, String search)  {
        String sts = getSingleUseTicket();
        String result = "";
//        String url = UTS_REST_API_URL + "/content/current/CUI/"+ CUI +"/atoms?sabs=" + targetCS;
//
//        try {
//            URIBuilder b = new URIBuilder(url);
//            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
//            b.addParameter(TICKET_PARAMETER, sts);
//
//            result = Request.Get(b.build())
//                    .connectTimeout(3000)
//                    .socketTimeout(3000)
//                    .execute().returnContent().asString();
//        }
        String url = UTS_REST_API_URL + SEARCH_PATH;
        logger.error("TARGET: " + targetCS);
        logger.error("SEARCH: "+ search);

        try {
            URIBuilder b = new URIBuilder(url);

            b.addParameter(SEARCH_PARAMETER, search);
            b.addParameter(CS_PARAMETER, targetCS);
            b.addParameter("returnIdType", "code");
            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
            b.addParameter(TICKET_PARAMETER, sts);

            result = Request.Get(b.build())
                    .connectTimeout(3000)
                    .socketTimeout(3000)
                    .execute().returnContent().asString();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getDescendants(String parentCode, String codeSystem) {

        String sts = getSingleUseTicket();
        String result = "";
//        String url = UTS_REST_API_URL + "/content/current/CUI/"+ CUI +"/atoms?sabs=" + targetCS;
//
//        try {
//            URIBuilder b = new URIBuilder(url);
//            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
//            b.addParameter(TICKET_PARAMETER, sts);
//
//            result = Request.Get(b.build())
//                    .connectTimeout(3000)
//                    .socketTimeout(3000)
//                    .execute().returnContent().asString();
//        }
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(UTS_REST_API_URL).append(DESCENDANT_PATH).append(codeSystem).append('/').append(parentCode)
                .append("/descendants");
        logger.error("TARGET: " + codeSystem + ":" + parentCode);

        try {
            URIBuilder b = new URIBuilder(urlBuilder.toString());
            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
            b.addParameter(TICKET_PARAMETER, sts);

            result = Request.Get(b.build())
                    .connectTimeout(3000)
                    .socketTimeout(3000)
                    .execute().returnContent().asString();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     *
     * Gets Ticket Granting Ticket from UMLS
     *
     */
    private void getTicketGrantingTicket()
    {
        if (lastUpdate + 600000000000l < System.nanoTime()) {
            logger.error("GETTING TGT");
            try {
                ticketGrantingTicketURL = Request.Post(UMLS_AUTH_API_KEY_URL)
                        .useExpectContinue()
                        .version(HttpVersion.HTTP_1_1)
                        .bodyForm(Form.form().add("apikey", env.getProperty("umls.apikey")).build())
                        .execute().returnResponse().getFirstHeader("location").getValue();
            } catch (IOException e) {
                e.printStackTrace();
            }
            lastUpdate = System.nanoTime();
            logger.error("GOT TGT");
        }
    }


    /**
     *
     * Gets single use ticket for search request to UTS
     *
     * @return Singe use ticket
     */
    private String getSingleUseTicket() {

        getTicketGrantingTicket();
        logger.error("GETTING ST");
        String ticket = "";
        try {
            ticket = Request.Post(ticketGrantingTicketURL)
                    .useExpectContinue()
                    .version(HttpVersion.HTTP_1_1)
                    .bodyForm(Form.form().add("service", "http://umlsks.nlm.nih.gov").build())
                    .execute().returnContent().asString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.error("GOT ST");
        return ticket;
    }
}
