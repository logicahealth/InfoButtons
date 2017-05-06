package org.openinfobutton.valuset.matcher.impl.cloud;

import org.openinfobutton.valuset.matcher.api.ValueSetMatcher;
import org.openinfobutton.valuset.matcher.model.ValueSets;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 4/26/17.
 */
@Service("cloudValueSets")
public class CloudValueSetMatcherImpl implements ValueSetMatcher {

    final List<ValueSets> valueSetCache = new ArrayList<ValueSets>();

    private String code;

    private String codeSystem;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /**Headers**/
    private HttpHeaders headers;

    @Autowired
    public CloudValueSetMatcherImpl(@Value( "${github.username}" ) final String username,
                                    @Value( "${github.password}" ) final String password) {

        this.username = username;
        this.password = password;
        headers = new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set("Accept", "application/vnd.github.raw+json");
        }};
    }

    /**
     *
     * Checks valueset in Github for valueset match
     *
     */
    public Boolean isConceptInSubset( String code, String codeSystem, String subsetName ) {

        if (!codeSystem.equals(this.codeSystem) || !code.equals(this.code))
        {
            this.codeSystem = codeSystem;
            this.code = code;
            valueSetCache.clear();
        }
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<ValueSets> response;
        ValueSets valueSet = isSubsetInCache(subsetName);
        if (valueSet != null)
        {

            return ProcessValueSet(valueSet, code, codeSystem);
        }
        try {
            response = restTemplate.exchange("https://api.github.com/repos/VHAINNOVATIONS/InfoButtons/contents/valuesets/"
                    + subsetName + ".json?ref=development", HttpMethod.GET, new HttpEntity<Object>(headers), ValueSets.class);
        } catch (HttpClientErrorException e) {

            if (e.getStatusCode().value() == 404)
            {
                return GitHubWorkAround(code, codeSystem, subsetName);
            }
            return false;
        }

        valueSet = response.getBody();
        valueSetCache.add(valueSet);
        return ProcessValueSet(valueSet, code, codeSystem);
    }

    private ValueSets isSubsetInCache (String subsetName)
    {

        for (ValueSets valueSet : valueSetCache)
        {
            if (valueSet.getValueSet().getName().equals(subsetName))
            {
                return valueSet;
            }
        }

        return null;
    }

    private Boolean ProcessValueSet (ValueSets valueSet, String code, String codeSystem) {

        for (ValueSets.CodeSystem vsCodeSystem : valueSet.getValueSet().getCodeSystems())
        {

            if (vsCodeSystem.getCodeSystem().equals(codeSystem)) {

                for (ValueSets.Code vsCode : vsCodeSystem.getCodes())
                {
                    if (vsCode.getCode().equals(code))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private Boolean GitHubWorkAround (String code, String codeSystem, String subsetName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ValueSets> response;
        int count = 2;
        do {

            try {

                response = restTemplate.exchange("https://api.github.com/repos/VHAINNOVATIONS/InfoButtons/contents/valuesets/"
                        + subsetName + "[1of" + count + "].json?ref=development", HttpMethod.GET, new HttpEntity<Object>(headers), ValueSets.class);
                return ProcessMultiPartValueSet( code, codeSystem, subsetName, count, response);
            } catch (HttpClientErrorException e) {

                System.err.println("Github file " + subsetName + "[1of" + count + "].json not found.");
            }
            count ++;
        } while (count <= 10);


        return false;
    }

    private Boolean ProcessMultiPartValueSet (String code, String codeSystem, String subsetName, int count, ResponseEntity response)
    {

        ValueSets valueSet = (ValueSets)response.getBody();
        RestTemplate restTemplate = new RestTemplate();
        int c = 2;
        while (c <= count) {

            response = restTemplate.exchange("https://api.github.com/repos/VHAINNOVATIONS/InfoButtons/contents/valuesets/"
                    + subsetName + "[" + c + "of" + count + "].json?ref=development", HttpMethod.GET, new HttpEntity<Object>(headers),
                    ValueSets.class);
            valueSet.getValueSet().getCodeSystems().addAll(((ValueSets) response.getBody()).getValueSet().getCodeSystems());
            c++;
        }
        valueSetCache.add(valueSet);
        return ProcessValueSet(valueSet, code, codeSystem);
    }



}
