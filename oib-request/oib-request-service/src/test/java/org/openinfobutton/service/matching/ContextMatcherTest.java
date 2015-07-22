/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Jun 13, 2014
 */
package org.openinfobutton.service.matching;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.service.fixture.OibServiceTestFixture;
import org.openinfobutton.service.utility.WebServiceUtility;
import org.openinfobutton.service.web.KnowledgeRequestEngine;
import org.springframework.beans.factory.annotation.Autowired;

public class ContextMatcherTest
    extends OibServiceTestFixture
{

    @Autowired
    KnowledgeRequestEngine engine;

    @Test
    public void cysticICD9RequestTest()
    {

        final KnowledgeRequest request = WebServiceUtility.getServiceRequest( cystitisICD9Request() );
        final String xml = marshallXML( engine.getResponse( request ) );
        Assert.assertThat( xml, containsString( "http://www.nlm.nih.gov/medlineplus/bladderdiseases.html" ) );
        Assert.assertThat( xml,
                           containsString( "http://www.elsinfobutton.com/info/1030?taskContext.c.c=PROBLISTREV&amp;"
                               + "taskContext.c.cs=2.16.840.1.113883.5.4&amp;"
                               + "mainSearchCriteria.v.c=595.9&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.103&amp;"
                               + "mainSearchCriteria.v.dn=Cystitis" ) );
        Assert.assertThat( xml,
                           containsString( "http://www.uptodate.com/online/content/search.do?searchType=HL7&amp;" +
                                 "taskContext.c.c=PROBLISTREV&amp;"
                               + "taskContext.c.cs=2.16.840.1.113883.5.4&amp;"
                               + "ageGroup.v.c=D008875&amp;ageGroup.v.cs=2.16.840.1.113883.6.177&amp;"
                               + "patientPerson.administrativeGenderCode.c=F&amp;"
                               + "patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1&amp;"
                               + "mainSearchCriteria.v.c=595.9&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.103&amp;"
                               + "mainSearchCriteria.v.dn=Cystitis&amp;"
                               + "subTopic.v.c=Q000175&amp;subTopic.v.cs=2.16.840.1.113883.6.177&amp;" +
                               "subTopic.v.dn=Diagnosis" ) );
        Assert.assertThat( xml, containsString( "http://www.google.com/search?hl=en&amp;btnI=Im+Feeling+Lucky&amp;"
            + "q=Cystitis+site:www.mayoclinic.com/health/" ) );
        Assert.assertThat( xml, containsString( "http://www.ncbi.nlm.nih.gov/pubmed?term=hasabstract[text]" ) );

    }
    
    @Test
    public void ageDecedentTest()
    {

        final KnowledgeRequest request = WebServiceUtility.getServiceRequest( decedentAgeRangeTest() );
        final String xml = marshallXML( engine.getResponse( request ) );
        Assert.assertThat( xml, containsString( "http://www.google.com/search?hl=en&amp;btnI=Im+Feeling+Lucky&amp;"
                        + "q=ICD-9+237.79+site:www.medicalhomeportal.org" ) );

    }

    @Test
    public void subsetMatchingTest()
    {

        final KnowledgeRequest request = WebServiceUtility.getServiceRequest( subsetRequest() );
        final String xml = marshallXML( engine.getResponse( request ) );
        Assert.assertThat( xml, containsString( "VisualDx" ) );
    }
    
    @Test
    public void cysticUMLSRequestTest()
    {

        final KnowledgeRequest request = WebServiceUtility.getServiceRequest( cystitisUMLSRequest() );
        final String xml = marshallXML( engine.getResponse( request ) );
        Assert.assertThat( xml, containsString( "http://www.uptodate.com/online/content/search.do?searchType=HL7&amp;"
            + "taskContext.c.c=PROBLISTREV&amp;taskContext.c.cs=2.16.840.1.113883.5.4&amp;"
            + "ageGroup.v.c=D008875&amp;ageGroup.v.cs=2.16.840.1.113883.6.177&amp;"
            + "patientPerson.administrativeGenderCode.c=F&amp;"
            + "patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1&amp;"
            + "mainSearchCriteria.v.c=595.0&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.103&amp;"
            + "mainSearchCriteria.v.dn=Acute+cystitis&amp;subTopic.v.c=Q000175&amp;"
            + "subTopic.v.cs=2.16.840.1.113883.6.177&amp;subTopic.v.dn=Diagnosis" ) );
    }

    @Test
    public void clopidogrelRxNormRequestTest()
    {

        final KnowledgeRequest request = WebServiceUtility.getServiceRequest( clopidogrelRxNormRequest() );
        final String xml = marshallXML( engine.getResponse( request ) );
        Assert.assertThat( xml, containsString( "http://www.uptodate.com/online/content/search.do?searchType=HL7&amp;"
            + "taskContext.c.c=MEDOE&amp;taskContext.c.cs=2.16.840.1.113883.5.4&amp;"
            + "ageGroup.v.c=D008875&amp;ageGroup.v.cs=2.16.840.1.113883.6.177&amp;"
            + "patientPerson.administrativeGenderCode.c=F&amp;"
            + "patientPerson.administrativeGenderCode.cs=2.16.840.1.113883.5.1&amp;"
            + "mainSearchCriteria.v.c=32968&amp;mainSearchCriteria.v.cs=2.16.840.1.113883.6.88&amp;"
            + "mainSearchCriteria.v.dn=clopidogrel" ) );
    }

    @Test
    public void neurofibromatosisSubsetRequestTest()
    {

        final KnowledgeRequest request = WebServiceUtility.getServiceRequest( neurofibromatosisSubsetRequest() );
        final String xml = marshallXML( engine.getResponse( request ) );
        Assert.assertThat( xml, containsString( "http://www.google.com/search?hl=en&amp;btnI=Im+Feeling+Lucky&amp;"
            + "q=Neurofibromatosis+site:http://ghr.nlm.nih.gov/" ) );
        Assert.assertThat( xml, containsString( "http://www.google.com/search?hl=en&amp;btnI=Im+Feeling+Lucky&amp;"
            + "q=ICD-9+237.7+site:www.medicalhomeportal.org" ) );
    }
}
