package service.impl;

import controller.command.utils.CommandUtil;
import model.dao.BookDao;
import model.dao.PersonDao;
import model.dao.factory.DaoFactory;
import model.entity.Book;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.BookService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    Logger logger = Logger.getLogger(BookServiceImpl.class);

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private BookDao bookDAO = daoFactory.getBookDAO();
    private PersonDao personDao = daoFactory.getPersonDAO();

    @Override
    public Book getEntity(Integer id) throws DataBaseException, ServiceException {
        return bookDAO.getById(id);
    }

    @Override
    public boolean add(Book entity) throws ServiceException {
        boolean flag = false;
        try {
            flag = bookDAO.add(entity);
        } catch (SQLException |NamingException | DataBaseException e) {
            logger.error(e.getMessage());
        }
        return flag;
    }

    @Override
    public Book update(Book entity) {
        return bookDAO.updateEntity(entity);
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        try {
            flag = bookDAO.deleteEntity(id);
        } catch (SQLException | NamingException e) {
            logger.error(e.getMessage());
        }
        return flag;
    }

    @Override
    public List<Book> getAllFree() throws ServiceException {
        return bookDAO.getAllFree();
    }

    @Override
    public List<Book> getAll() throws ServiceException {
        return bookDAO.getAll();
    }

    /**
     * If book name or author contains text
     * print this book
     * @param text
     * @return All book by author or name
     */
    @Override
    public List<Book> findByAuthorOrName(String text) {
        return bookDAO.getAllFree().stream()
                .filter(o -> o.getName().toUpperCase().contains(text.toUpperCase())
                        || o.getAuthor().toUpperCase().contains(text.toUpperCase()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean setBookForApprove(int book_id, int person_id) {
        Book book = null;
        try {
            book = bookDAO.getById(book_id);
            book.setStatus(2);
            book.setPerson_id(person_id);
            bookDAO.updateEntity(book);
            return true;
        } catch (DataBaseException e) {
            logger.error("error setBookForApprove");
            return false;
        }
    }

    @Override
    public List<Book> getAllBusyBooks() {
        return bookDAO.getAllBusyBooks();
    }


    /**
     * print orders for each person separately
     * @return All user orders
     */
    @Override
    public Map<Book, Person> getAllInfoByOrder() {
        List<Book> list = bookDAO.getAllOrder();
        Person person;
        Book book;
        Map<Book, Person> map = new HashMap<>();
        try {
            for (Book value : list) {
                book = value;
                person = personDao.getById(book.getPerson_id());
                map.put(book, person);
            }
        } catch (DataBaseException e) {
            logger.error(e.getMessage());
            return Collections.emptyMap();
        }

        return map;
    }

    @Override
    public List<Book> getAllOrder() {
        return bookDAO.getAllOrder();
    }


    /**
     * check returnDate and if current date after return date
     * will be debt to current person
     *
     * @param person_id
     * @return All user`s book
     */
    @Override
    public List<Book> getAllBooksByPersonIDAndAddDebt(int person_id) {
        List<Book> list = bookDAO.getAllBooksByPersonID(person_id);
        list.stream()
                .filter(o -> CommandUtil.getCurrentDate().after(o.getReturnDate()))
                .forEach(o -> o.setDebt(o.getPrice() / 100 * 30));
        for (Book book : list) {
            bookDAO.updateEntity(book);
        }
        return list;
    }

    @Override
    public List<Book> getAllOrderByPersonID(int person_id) {
        return bookDAO.getAllOrderByPersonID(person_id);
    }
}
