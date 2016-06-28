package org.utah.edu.semmed.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by JoeNarus on 6/28/16.
 */

@Component
public class PropertiesHandler {

    Logger log = Logger.getLogger( PropertiesHandler.class.getName() );

    /** The database url. */
    @Value( "${prop.dburl}" )
    String dburl;

    /** The database driver. */
    String dbdriver = "com.mysql.jdbc.Driver";

    /** The database username. */
    @Value( "${prop.dbusername}" )
    String dbusername;

    /** The database password. */
    @Value( "${prop.dbpassword}" )
    String dbpassword;

    /** The username. */
    @Value( "${prop.username}" )
    String username;

    /** The password. */
    @Value( "${prop.password}" )
    String password;
}
