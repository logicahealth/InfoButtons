package org.openinfobutton.service.configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.DatabaseConfiguration;
import org.apache.commons.configuration2.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.spring.ConfigurationPropertiesFactoryBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Properties;

@org.springframework.context.annotation.Configuration
@PropertySource(value = { "classpath:serviceParams.properties" }, ignoreResourceNotFound=true)
public class OibPropertiesConfig {
    private static final Logger log = LogManager.getLogger(OibPropertiesConfig.class);

    @Autowired
    private org.springframework.core.env.Environment env;

    @Autowired
    @Qualifier("profiledataSource")
    DataSource datasource;

    @PostConstruct
    public void initializeDatabasePropertySourceUsage() {
        MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
        if (propertySources.contains("dbPropertySource")) {

            propertySources.remove("dbPropertySource");
        }
        try {

            Parameters params = new Parameters();

            BasicConfigurationBuilder<DatabaseConfiguration> builder =
                    new BasicConfigurationBuilder<DatabaseConfiguration>(DatabaseConfiguration.class);

            builder.configure(
                    params.database()
                            .setDataSource(datasource)
                            .setTable("oib_app_property")
                            .setKeyColumn("prop_name")
                            .setValueColumn("prop_value")
            );


            Configuration databaseConfiguration = builder.getConfiguration();

            ConfigurationPropertiesFactoryBean commonsConfigurationFactoryBean = new ConfigurationPropertiesFactoryBean(databaseConfiguration);

            Properties dbProps = commonsConfigurationFactoryBean.getObject();
            PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", dbProps);

            //By being First, Database Properties take precedence over all other properties that have the same key name
            propertySources.addFirst(dbPropertySource);
        } catch (Exception e) {
            log.error("Error during database properties setup", e);
            throw new RuntimeException(e);
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}