/*******************************************************************************
 * Source File: ProfileManagerService.java
 ******************************************************************************/
package org.openinfobutton.service.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.utah.further.profiledb.service.ProfilesDao;
import edu.utah.further.profiledb.domain.Profiles;

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
@RequestMapping("/manager")
public class ProfileManagerService
{
    
    @Autowired
    @Qualifier("pDao")
    private ProfilesDao pdao; 
    
    @RequestMapping(produces="application/json", value = "/profiles", method = RequestMethod.GET)
    @ResponseBody
    public List<Profiles> getProfiles() {
        
        List<Profiles> profiles = new ArrayList<Profiles>();
        try 
        {
            
           profiles = pdao.getProfiles();
        } 
        catch (Exception e) 
        {
            
            String eMessage = "Error connecting to database and getting profiles";
            System.err.println(eMessage);

        }
        
        return profiles;
        
    }
}