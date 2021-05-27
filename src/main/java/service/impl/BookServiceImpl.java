package service.impl;

import model.Book;
import model.Person;
import model.dao.BookDao;
import model.dao.factory.DaoFactory;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private BookDao bookDAO = daoFactory.getBookDAO();

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


}
