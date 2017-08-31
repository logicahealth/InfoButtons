package org.openinfobutton.oibpropertydb.service;

import org.openinfobutton.oibpropertydb.domain.OibAppProperty;

import java.util.List;

/**
 * Created by andrew on 8/29/17.
 */
public interface OibAppPropertyDao {

    List<OibAppProperty> getPropertiesByName(String name);

    OibAppProperty getPropertyByName(String name);
}
