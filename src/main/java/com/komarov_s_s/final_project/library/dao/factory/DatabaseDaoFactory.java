package com.komarov_s_s.final_project.library.dao.factory;

import com.komarov_s_s.final_project.library.dao.*;
import com.komarov_s_s.final_project.library.dao.impl.*;
import java.util.logging.Logger;

public class DatabaseDaoFactory extends DaoFactory{

    private static Logger logger = Logger.getLogger(String.valueOf(DatabaseDaoFactory.class)); // setting variable

    private PersonDao personDao = new PersonDatabaseDao();
    private BookDao bookDao = new BookDatabaseDao();
    private BookPhotoDao book_photoDao = new BookPhotoDatabaseDao();
    private CartDao cartDao = new CartDatabaseDao();


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

    @Override
    public BookPhotoDao getBookPhotoDAO() {
        logger.info("Get Book_PhotoDatabaseDao");
        return book_photoDao;
    }

    @Override
    public CartDao getCartDAO() {
        logger.info("Get CartDatabaseDao");
        return cartDao;
    }
}
