package org.openinfobutton.service.web;

import org.openinfobutton.oibpropertydb.domain.OibAppProperty;
import org.openinfobutton.oibpropertydb.service.OibAppPropertyDao;
import org.openinfobutton.service.configuration.OibPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrew on 9/6/17.
 */
@RestController
@RequestMapping("propertiesManager")
public class PropertiesManagerService {

    @Autowired
    OibPropertiesConfig oibPropertiesConfig;

    @Autowired
    OibAppPropertyDao pDao;

    @RequestMapping(value="updateProperty", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateProperty (@RequestBody final OibAppProperty user)
    {

        pDao.updateProperty(user);
        oibPropertiesConfig.initializeDatabasePropertySourceUsage();
    }

    @RequestMapping(produces = "application/json",value="getProperty/{propertyName}", method = RequestMethod.GET)
    @ResponseBody
    public OibAppProperty getProperty (@PathVariable final String propertyName)
    {

        return pDao.getPropertyByName(propertyName);
    }

    @RequestMapping(produces = "application/json",value="getProperties/{propertyName}", method = RequestMethod.GET)
    @ResponseBody
    public List<OibAppProperty> getProperties (@PathVariable final String propertyName)
    {

        return pDao.getPropertiesByName(propertyName);
    }
}
