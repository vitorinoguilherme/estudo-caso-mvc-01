package org.example.models;

import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://suleiman.db.elephantsql.com:5432/nerszyvg";
            Properties props = new Properties();
            props.setProperty("user", "nerszyvg");
            props.setProperty("password", "LTbMODx9e5nMoWqBSIkGhlJf7N8nKFDh");
            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return null;
    }
}
