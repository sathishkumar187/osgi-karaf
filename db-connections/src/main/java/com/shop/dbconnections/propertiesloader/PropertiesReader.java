package com.shop.dbconnections.propertiesloader;

import com.shop.dbconnections.exceptions.UnableToLoadException;
import org.apache.felix.utils.properties.Properties;

import java.io.File;

/**
 * Properties file reader.
 *
 * @author SathishKumarS
 */
public class PropertiesReader {

    /**
     * Gets the properties.
     *
     * @return properties
     */
    public static Properties getProperties() {

        try {
            File karafEtc = new File(System.getenv("KARAF_ETC"));
            Properties jdbcProperties = new Properties();

            jdbcProperties.load(new File(karafEtc, "jdbc.properties"));
            return  jdbcProperties;
        } catch (Exception exception) {
            throw new UnableToLoadException(exception.getMessage());
        }
    }
}
