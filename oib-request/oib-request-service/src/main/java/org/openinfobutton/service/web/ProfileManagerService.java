/*******************************************************************************
 * Source File: ProfileManagerService.java
 ******************************************************************************/
package org.openinfobutton.service.web;

import java.util.ArrayList;
import java.util.List;

import edu.utah.further.liteprofiledb.service.LiteProfilesDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.utah.further.liteprofiledb.service.LiteProfilesDao;
import edu.utah.further.liteprofiledb.domain.CloudProfiles;
import edu.utah.further.liteprofiledb.domain.CustomProfiles;

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
 * @version May 5, 2014
 */
@Controller
@RequestMapping("/liteManager")
public class ProfileManagerService
{
    
    @Autowired
    @Qualifier("lDao")
    private LiteProfilesDao lDao;
    
    @RequestMapping(produces="application/json", value = "/cloudProfiles", method = RequestMethod.GET)
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

    @RequestMapping(produces="application/json", value = "/customProfiles", method = RequestMethod.GET)
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

    @RequestMapping(produces = "application/json", value = "/getProfile/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value="/createProfile", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createProfile (@RequestBody final CustomProfiles profile)
    {

        lDao.createOrUpdateCustomProfile(profile);
    }

    @RequestMapping(value="/createCloudProfile", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createCloudProfile (@RequestBody final CloudProfiles profile)
    {

        lDao.createOrUpdateCloudProfile(profile);
    }
}