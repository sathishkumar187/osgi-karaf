package com.shop.dbconnections.connections;

import com.shop.dbconnections.exceptions.UnableToConnectException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * DB connections.
 *
 * @author SathishKumarS
 */
@Component(immediate = true, name = "jdbc")
public class DBConnections {

    private static Map<String, String> properties;

    /**
     * It connects database.
     * @return established connection by connection.
     */
    public Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(properties.get("url"),
                    properties.get("username"), properties.get("password"));
            return connection;
        } catch (ClassNotFoundException e) {
            throw new UnableToConnectException(e.getMessage());
        } catch (Exception exception) {
            throw new UnableToConnectException(exception.getMessage());
        }
    }

    @Activate
    public void activate(Map<String, String> properties) {
        this.properties = properties;
    }
}
