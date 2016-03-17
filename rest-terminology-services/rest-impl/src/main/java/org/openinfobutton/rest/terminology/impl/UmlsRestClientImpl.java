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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Andrew on 3/14/2016.
 */
@Service
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

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    private long lastUpdate = -1;

    /**
     *
     * UMLS Authentication parameters
     */

    private static String UMLS_AUTH_API_URL = "https://utslogin.nlm.nih.gov/cas/v1/tickets";


    /**
     *Instantiates REST client by retrieving TGT
     *
     */
    @Autowired
    public UmlsRestClientImpl (@Value( "${umls.username}" ) String username, @Value( "${umls.password}" ) String password) {

        this.username = username;
        this.password = password;
        getTicketGrantingTicket();
    }

    /**
     *
     * @param search Search term
     * @return Array of search results serialized to JSON
     */
    public String getTerms (String search) {

        String result = "";
        return result;
    }

    /**
     *
     * @param search Search term
     * @param codeSytem Code System
     * @return Array of search results serialized to JSON
     */
    public String getTerms (String search, String codeSytem){

        String sts = getSingleUseTicket();
        String result = "";
        logger.error("SEARCHING");
        try {
            URIBuilder b = new URIBuilder(UTS_REST_API_URL + SEARCH_PATH);
            b.addParameter(SEARCH_PARAMETER, search);
            b.addParameter(RETURN_TYPE_PARAMETER, RETURN_TYPE);
            b.addParameter(SEARCH_TYPE_PARAMETER, SEARCH_TYPE);
            b.addParameter(CS_PARAMETER, codeSytem);
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
     * Gets Ticket Granting Ticket from UMLS
     *
     */
    private void getTicketGrantingTicket()
    {
        if (lastUpdate + 21600000000000l < System.nanoTime()) {
            logger.error("GETTING TGT");
            try {
                ticketGrantingTicketURL = Request.Post(UMLS_AUTH_API_URL)
                        .useExpectContinue()
                        .version(HttpVersion.HTTP_1_1)
                        .bodyForm(Form.form().add("username", username).add("password", password).build())
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
