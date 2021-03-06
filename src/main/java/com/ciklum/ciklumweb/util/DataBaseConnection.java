package com.ciklum.ciklumweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
        } else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DataBaseConnection.class.getClassLoader().getResourceAsStream("/app.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
