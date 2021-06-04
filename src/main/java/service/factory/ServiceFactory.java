package service.factory;

import service.BookService;
import service.PersonService;
import service.impl.BookServiceImpl;
import service.impl.PersonServiceImpl;
import org.apache.log4j.Logger;

public class ServiceFactory {

    private static Logger logger = Logger.getLogger(ServiceFactory.class);


    private PersonService personService = new PersonServiceImpl();
    private BookService bookService = new BookServiceImpl();


    private static ServiceFactory instance;

    public static ServiceFactory getInstance() {
        if (instance == null) {
            logger.info("Create ServiceFactory");
            instance = new ServiceFactory();
        }
        return instance;
    }

    private ServiceFactory() {

    }


    public PersonService getPersonService() {
        return personService;
    }

    public BookService getBookService() {
        return bookService;
    }

}
