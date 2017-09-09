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

    @RequestMapping(value="updateProperty/{propertyName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateProperty (@PathVariable final String propertyName, @RequestBody final String propertyValue)
    {

        OibAppProperty property = pDao.getPropertyByName(propertyName);
        property.setPropValue(propertyValue);
        pDao.updateProperty(property);
        oibPropertiesConfig.initializeDatabasePropertySourceUsage();
    }

    @RequestMapping(value="addProperty/{propertyName}/{propertyValue}/{propertyDescription}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void addProperty (@PathVariable final String propertyName, @PathVariable final String propertyValue,
                             @PathVariable final String propertyDescription)
    {

        OibAppProperty property = new OibAppProperty();
        property.setPropName(propertyName);
        property.setPropValue(propertyValue);
        property.setPropDescription(propertyDescription);
        pDao.updateProperty(property);
    }

    @RequestMapping(value="deleteProperty/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProperty (@PathVariable final int id) {

        pDao.deletePropertyById(id);
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
