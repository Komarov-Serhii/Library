package service.impl;

import controller.command.utils.CommandUtil;
import model.entity.Book;
import model.entity.Person;
import model.dao.BookDao;
import model.dao.PersonDao;
import model.dao.factory.DaoFactory;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.BookService;

import java.util.*;

import org.apache.log4j.Logger;

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
        try {
            return bookDAO.add(entity);
        } catch (DataBaseException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Book update(Book entity) {
        return bookDAO.updateEntity(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return bookDAO.deleteEntity(id);
    }

    @Override
    public List<Book> getAll() throws ServiceException {
        return bookDAO.getAll();
    }


    @Override
    public List<Book> findByAuthorOrName(String text) {
        return bookDAO.getAll().stream()
                .filter(o -> o.getName().toUpperCase().contains(text.toUpperCase())
                        || o.getAuthor().toUpperCase().contains(text.toUpperCase()))
                .collect(Collectors.toList());
    }

    @Override
    public void setBookForApprove(int book_id, int person_id) {
        try {
            Book book = bookDAO.getById(book_id);
            book.setStatus(2);
            book.setPerson_id(person_id);
            bookDAO.updateEntity(book);
        } catch (DataBaseException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Person, Book> getAllInfoByOrder() {
        List<Book> list = bookDAO.getAllOrder();
        Person person;
        Book book;
        Map<Person, Book> map = new HashMap<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                book = list.get(i);
                person = personDao.getById(book.getPerson_id());
                map.put(person, book);
            }
        } catch (DataBaseException | ServiceException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }

        return map;
    }

    @Override
    public List<Book> getAllOrder() {
        return bookDAO.getAllOrder();
    }

    @Override
    public List<Book> getAllBooksByPersonIDAndAddDebt(int person_id) {
        List<Book> list = bookDAO.getAllBooksByPersonID(person_id);

        list.stream()
                .filter(o -> CommandUtil.getCurrentDate().after(o.getReturnDate()))
                .forEach(o -> o.setDebt(o.getPrice() / 100 * 30));

        return list;
    }

    @Override
    public List<Book> getAllOrderByPersonID(int person_id) {
        return bookDAO.getAllOrderByPersonID(person_id);
    }
}
