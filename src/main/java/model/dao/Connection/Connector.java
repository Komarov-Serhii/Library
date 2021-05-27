package model.dao.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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
