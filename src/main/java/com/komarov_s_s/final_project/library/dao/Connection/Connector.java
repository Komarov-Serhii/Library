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

    private static Connector pool;
    private final DataSource dataSource;

    public Connector() throws NamingException {
        Context initialContext = new InitialContext();
        dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/library");
    }

    public static synchronized Connector getInstance() throws NamingException {
        if (pool == null) {
            pool = new Connector();
        }
        return pool;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
