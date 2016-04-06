/*******************************************************************************
 * Source File: ProfileManagerService.java
 ******************************************************************************/
package org.openinfobutton.service.web;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.fasterxml.jackson.module.jsonSchema.customProperties.HyperSchemaFactoryWrapper;
import edu.utah.further.liteprofiledb.service.LiteProfilesDao;
import org.apache.log4j.Logger;
import org.openinfobutton.rest.terminology.api.RestTermClient;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.utah.further.liteprofiledb.domain.CloudProfiles;
import edu.utah.further.liteprofiledb.domain.CustomProfiles;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
 * @version March 13, 2016
 */
@Controller
public class ProfileManagerService
{

    /** The log. */
    Logger log = Logger.getLogger( ProfileManagerService.class.getName() );

    @Autowired
    @Qualifier("lDao")
    private LiteProfilesDao lDao;

    @Autowired
    private RestTermClient restTermClient;
    
    @RequestMapping(produces="application/json", value = "cloudProfiles", method = RequestMethod.GET)
    @ResponseBody
    public List<CloudProfiles> getCloudProfiles() {
        
        List<CloudProfiles> profiles = new ArrayList<>();
        try {
            
           profiles = lDao.getCloudProfiles();
        } 
        catch (Exception e) 
        {
            
            String eMessage = "Error connecting to database and getting profiles";
            System.err.println(eMessage);

        }
        
        return profiles;
        
    }

    @RequestMapping(produces="application/json", value = "customProfiles", method = RequestMethod.GET)
    @ResponseBody
    public List<CustomProfiles> getCustomProfiles() {

        List<CustomProfiles> profiles = new ArrayList<>();
        try {

            profiles = lDao.getCustomProfiles();
        }
        catch (Exception e)
        {

            String eMessage = "Error connecting to database and getting profiles";
            System.err.println(eMessage);

        }

        return profiles;

    }

    @RequestMapping(produces = "application/json", value = "getProfile/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CustomProfiles getCustomProfile(@PathVariable final Long id) {

        CustomProfiles profile = new CustomProfiles();
        try {

            profile = lDao.getCustomProfile(id);
        } catch (Exception e) {

            String eMessage = "Error connecting to database and getting profile";
            System.err.println(eMessage);
        }

        return profile;
    }

    @RequestMapping(value="createProfile", method = RequestMethod.POST)
    @ResponseBody
    public String createProfile (@RequestBody final CustomProfiles profile) {

        StringWriter sw = new StringWriter();

        if (profile.getId() == null) {
            try {
                getProfileJAXBMarshaller().marshal(KnowledgeResourceProfile.builder().
                        withProfileDefinition().withHl7URLCompliant(true).withAuthorizedOrganizations().end().end().build(), sw);
                profile.setContent(sw.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        lDao.createOrUpdateCustomProfile(profile);
        return Long.toString(profile.getId());
    }

    @RequestMapping(produces="application/xml", value="updateCustomProfile/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateCustomProfile ( @PathVariable final Long id, @RequestBody final String json) throws IOException, JAXBException {

        CustomProfiles profile = new CustomProfiles();
        try {

            profile = lDao.getCustomProfile(id);
        } catch (Exception e) {

            String eMessage = "Error connecting to database and getting profile";
            System.err.println(eMessage);
        }
        ObjectMapper mapper = createJaxbObjectMapper();
        KnowledgeResourceProfile jaxbProfile = mapper.readValue(json, KnowledgeResourceProfile.class);

        StringWriter sw = new StringWriter();
        getProfileJAXBMarshaller().marshal(jaxbProfile, sw);
        try {
            profile.setContent(sw.toString());
        } catch (SQLException e) {
            System.err.println("Error updating profile content");
            e.printStackTrace();
        }
        lDao.createOrUpdateCustomProfile(profile);
        return sw.toString();
    }

    @RequestMapping(value="createCloudProfile", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createCloudProfile (@RequestBody final CloudProfiles profile)
    {

        lDao.createOrUpdateCloudProfile(profile);
    }

    @RequestMapping(produces = "application/json", value="jsonProfile/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getJsonProfile(@PathVariable final Long id) throws JsonProcessingException {

        CustomProfiles profile = new CustomProfiles();
        try {

            profile = lDao.getCustomProfile(id);
        } catch (Exception e) {

            String eMessage = "Error connecting to database and getting profile";
            System.err.println(eMessage);
        }
        JAXBContext context;
        Unmarshaller u = null;
        try
        {
            context = JAXBContext.newInstance( KnowledgeResourceProfile.class );
            u = context.createUnmarshaller();
        }
        catch ( final JAXBException e1 )
        {
            e1.printStackTrace();
            log.error( "Failed to get the Unmarshaller.Cannot proceed with returning the profile" );
        }
        KnowledgeResourceProfile jaxbProfile = new KnowledgeResourceProfile();
        try
        {
            jaxbProfile = (KnowledgeResourceProfile) u.unmarshal( profile.getContent().getBinaryStream());
            log.debug( "Loaded Profile : " + profile.getName() );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = createJaxbObjectMapper();
        return mapper.writeValueAsString(jaxbProfile);
    }

    @RequestMapping(produces = "application/json", value="jsonProfileSchema", method = RequestMethod.GET)
    @ResponseBody
    public String getJsonProfileSchema() {

        HyperSchemaFactoryWrapper visitor = new HyperSchemaFactoryWrapper();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.acceptJsonFormatVisitor(mapper.constructType(Class.forName(KnowledgeResourceProfile.class.getName())), visitor);
            final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema);
        } catch (ClassNotFoundException cnfEx) {
            return "Unable to find class ";
        } catch (JsonMappingException jsonEx) {
            return "Unable to map JSON: " + jsonEx;
        } catch (JsonProcessingException jsonEx) {
            return "Unable to process JSON: " + jsonEx;
        }
    }

    @RequestMapping(produces = "application/json", value="searchUts/{codeSystem}/{search}", method = RequestMethod.GET)
    @ResponseBody
    public String searchUts (@PathVariable String codeSystem, @PathVariable String search) {

        return restTermClient.getTerms(search, codeSystem);
    }

    /**
     * Create instance of ObjectMapper with JAXB introspector
     * and default type factory.
     *
     * @return Instance of ObjectMapper with JAXB introspector
     *    and default type factory.
     */
    private ObjectMapper createJaxbObjectMapper()
    {
        final ObjectMapper mapper = new ObjectMapper();
        final TypeFactory typeFactory = TypeFactory.defaultInstance();
        final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(typeFactory);
        // make deserializer use JAXB annotations (only)
        mapper.getDeserializationConfig().with(introspector);
        // make serializer use JAXB annotations (only)
        mapper.getSerializationConfig().with(introspector);
        return mapper;
    }

    private Marshaller getProfileJAXBMarshaller () {

        Marshaller marshaller = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(KnowledgeResourceProfile.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return marshaller;
    }
}