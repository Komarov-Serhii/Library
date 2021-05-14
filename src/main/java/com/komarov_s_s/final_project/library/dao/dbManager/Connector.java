package com.komarov_s_s.final_project.library.dao.dbManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

    private String user;
    private String pass;
    private String url;
    private Connection conn;

    public static Connector getInstance() {
        return new Connector();
    }
    public Connection getConnection() throws SQLException {
        try (InputStream input = new FileInputStream("app.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty("connection.url");
            user = prop.getProperty("user");
            pass = prop.getProperty("password");
        } catch (IOException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.WARNING, "Exception: ", ex);
        }
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }
}
