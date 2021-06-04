package model.dao.factory;


import model.dao.*;
import model.dao.PersonDao;
import model.dao.impl.*;
import org.apache.log4j.Logger;

public class DatabaseDaoFactory extends DaoFactory{

    private static Logger logger = Logger.getLogger(DatabaseDaoFactory.class);

    private PersonDao personDao = new PersonDatabaseDao();
    private BookDao bookDao = new BookDatabaseDao();
    private BookPhotoDao book_photoDao = new BookPhotoDatabaseDao();



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


}
