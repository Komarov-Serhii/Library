package com.komarov_s_s.final_project.library.dao.Connection;

import com.komarov_s_s.final_project.library.dao.impl.PersonDatabaseDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
    private static Connector pool;

    public static synchronized Connector getInstance() {
            if (pool == null) {
                pool = new Connector();
            }
        return pool;
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
