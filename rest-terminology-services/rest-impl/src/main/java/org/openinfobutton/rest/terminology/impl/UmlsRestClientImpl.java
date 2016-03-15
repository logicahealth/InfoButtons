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

    private static String CS_PARAMETER = "sabs";

    private String PAGE_SIZE_PARAMETER = "pageSize";

    private String PAGE_SIZE_VALUE = "25";

    private static String PAGE_PARAMETER = "pageNumber";

    private static String TICKET_PARAMETER = "ticket";

    private String ticketGrantingTicketURL = "";

    /**
     *
     * UMLS Authentication parameters
     */

    private static String UMLS_AUTH_API_URL = "https://utslogin.nlm.nih.gov/cas/v1/tickets";


    /**
     *Instantiates REST client by retrieving TGT
     *
     * @param userName
     * @param password
     */
    public UmlsRestClientImpl (String userName, String password) {

        getTicketGrantingTicket(userName, password);
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

        try {
            URIBuilder b = new URIBuilder(UTS_REST_API_URL + SEARCH_PATH);
            b.addParameter(SEARCH_PARAMETER, search);
            b.addParameter(CS_PARAMETER, codeSytem);
            b.addParameter(PAGE_SIZE_PARAMETER, PAGE_SIZE_VALUE);
            b.addParameter(TICKET_PARAMETER, sts);
            result = Request.Get(b.build())
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute().returnContent().asString();
        } catch (URISyntaxException e) {
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
     * @param userName UMLS Username
     * @param password UMLS Password
     */
    private void getTicketGrantingTicket(String userName, String password)
    {


        try {
            ticketGrantingTicketURL = Request.Post(UMLS_AUTH_API_URL)
                    .useExpectContinue()
                    .version(HttpVersion.HTTP_1_1)
                    .bodyForm(Form.form().add("username", userName).add("password", password).build())
                    .execute().returnResponse().getFirstHeader("location").getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * Gets single use ticket for search request to UTS
     *
     * @return Singe use ticket
     */
    private String getSingleUseTicket() {

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

        return ticket;
    }
}
