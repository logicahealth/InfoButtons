package edu.utah.openinfobutton.valuset.matcher.impl.cloud;

import edu.utah.openinfobutton.valuset.matcher.api.ValueSetMatcher;
import edu.utah.openinfobutton.valuset.matcher.model.ValueSets;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Created by andrew on 4/26/17.
 */
@Service("cloudMatcher")
public class CloudValueSetMatcherImpl implements ValueSetMatcher {

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    @Autowired
    public CloudValueSetMatcherImpl(@Value( "${github.username}" ) String username,
                                    @Value( "${github.password}" ) String password) {

        this.username = username;
        this.password = password;
    }

    /**
     *
     * Checks valueset in Github for valueset match
     *
     */
    public Boolean isConceptInSubset( String code, String codeSystem, String subsetName ) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set("Accept", "application/vnd.github.raw+json");
        }};
        ResponseEntity<ValueSets> response;
        response = restTemplate.exchange("https://api.github.com/repos/VHAINNOVATIONS/InfoButtons/contents/valuesets/"
                + subsetName + ".json?ref=development", HttpMethod.GET, new HttpEntity<Object>(headers), ValueSets.class);

        for (ValueSets.CodeSystem vsCodeSystem : response.getBody().getValueSet().getCodeSystems())
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



}
