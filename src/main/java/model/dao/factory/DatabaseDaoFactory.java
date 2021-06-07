package model.dao.factory;


import model.dao.*;
import model.dao.PersonDao;
import model.dao.impl.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseDaoFactory extends DaoFactory{

    private static Logger logger = Logger.getLogger(DatabaseDaoFactory.class);

    private PersonDao personDao = new PersonDatabaseDao();
    private BookDao bookDao = new BookDatabaseDao();


    @Override
    public PersonDao getPersonDAO() {
        logger.info("Get PersonDatabaseDao");
        return personDao;
    }

    @Override
    public BookDao getBookDAO() {
        logger.info("Get BookDatabaseDao");
        return bookDao;
    }

}
