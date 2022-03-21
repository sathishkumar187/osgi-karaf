package com.shop.dbconnections;

import com.shop.dbconnections.exceptions.UnableToConnectException;
import com.shop.dbconnections.propertiesloader.PropertiesReader;
import org.apache.felix.utils.properties.Properties;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DB connections.
 *
 * @author SathishKumarS
 */
public class DBConnections {

    private static DBConnections dbConnections;

    private DBConnections() {

    }

    /**
     * It connects database.
     * @return established connection by connection.
     */
    public Connection getConnection() {
        Properties databaseProperties = PropertiesReader.getProperties();

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(databaseProperties.getProperty("url"),
                    databaseProperties.getProperty("username"), databaseProperties.getProperty("password"));
            return connection;
        } catch (ClassNotFoundException e) {
            throw new UnableToConnectException(e.getMessage());
        } catch (Exception exception) {
            throw new UnableToConnectException("Connection Failed \n    Please Check Connection");
        }
    }

    public static DBConnections getInstance() {
        if (dbConnections == null) {
            dbConnections = new DBConnections();
        }
        return dbConnections;
    }
}
