package com.integrant.amazonjob.util;


import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class ConnectionUtil {

    public Connection getConnection() {
        Connection connection = null;
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=amaznon;"
                        + "user=sa;"
                        + "password=P@$$w0rd123";

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection con, PreparedStatement pmst) {
        try {
            pmst.close();
           con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
