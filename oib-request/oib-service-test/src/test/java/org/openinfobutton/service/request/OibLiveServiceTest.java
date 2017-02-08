package org.openinfobutton.service.request;

import org.junit.Ignore;
import org.junit.Test;
import org.openinfobutton.service.fixture.OibRequestTestingFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by andrew on 9/3/15.
 */
public class OibLiveServiceTest extends OibRequestTestingFixture{

    @Autowired
    private Environment env;

    @Test
    public void testServiceAlive() {

        String OIBHtml = new RestTemplate()
                .getForObject(
                        env.getProperty("infobutton.location") + "infoRequest?", String.class);

        assertThat(OIBHtml, containsString(env.getProperty("infobutton.expectedResponse")));
    }

    @Test
    public void testProfileRequest() {

        String OIBHtml = new RestTemplate()
                .getForObject(
                        env.getProperty("infobutton.location") + "infoRequest?" + env.getProperty("infobutton.profileQuery"), String.class);

        assertThat(OIBHtml, containsString(env.getProperty("infobutton.expectedProfile")));
    }

    @Test
    @Ignore
    public void testTerminologyRequest() {

        String OIBHtml = new RestTemplate()
                .getForObject(
                        env.getProperty("infobutton.location") + "infoRequest?" + env.getProperty("infobutton.terminologyQuery"), String.class);

        assertThat(OIBHtml, containsString(env.getProperty("infobutton.expectedCode")));
    }
}
