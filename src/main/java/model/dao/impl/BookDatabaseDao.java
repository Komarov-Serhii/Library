package model.dao.impl;

import model.dao.BookDao;
import model.dao.Connection.Connector;
import model.dao.constant.Constants;
import model.exception.DataBaseException;
import model.entity.Book;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class BookDatabaseDao implements BookDao {

    private static Logger logger = Logger.getLogger(BookDatabaseDao.class);


    public BookDatabaseDao() {
    }


    @Override
    public boolean add(Book book) throws DataBaseException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.INSERT_BOOK)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setString(4, book.getPublisherDate());
            statement.setString(5, book.getDescription());
            statement.setInt(6, book.getPrice());
            statement.setString(7, book.getGenre());
            statement.setInt(8, book.getStatus());
            statement.setInt(9, book.getPerson_id());
            statement.setInt(10, book.getOrderStatus());
            statement.setDate(11, book.getReturnDate());
            statement.setInt(12, book.getDebt());
            statement.execute();

            logger.info("successful add book");
            return true;
        } catch (SQLException | NamingException e) {
            throw new DataBaseException("Cannot add book", e);
        }
    }

    @Override
    public Book getById(Integer id) throws DataBaseException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_ID_BOOK)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            logger.info("successful getById book");
            return new Book.BookBuilderImpl()
                    .setId(id)
                    .setName(resultSet.getString("name"))
                    .setAuthor(resultSet.getString("author"))
                    .setPublisher(resultSet.getString("publisher"))
                    .setPublisherDate(resultSet.getString("publisher_date"))
                    .setDescription(resultSet.getString("description"))
                    .setPrice(resultSet.getInt("price"))
                    .setGenre(resultSet.getString("genre"))
                    .setStatus(resultSet.getInt("status"))
                    .setPersonId(resultSet.getInt("person_id"))
                    .setOrderStatus(resultSet.getInt("order_status"))
                    .setReturnDate(resultSet.getDate("return_date"))
                    .setDebt(resultSet.getInt("debt"))
                    .build();
        } catch (SQLException | NamingException e) {
            throw new DataBaseException(String.format("Cannot get book by id=%d", id), e);
        }
    }

    @Override
    public boolean deleteEntity(Integer id) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_BOOK)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            logger.info("successful delete book");
            return true;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot delete book", e);
        }
    }


    @Override
    public Book updateEntity(Book book) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_BOOK)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setString(4, book.getPublisherDate());
            statement.setString(5, book.getDescription());
            statement.setInt(6, book.getPrice());
            statement.setString(7, book.getGenre());
            statement.setInt(8, book.getStatus());
            statement.setInt(9, book.getPerson_id());
            statement.setInt(10, book.getOrderStatus());
            statement.setDate(11, book.getReturnDate());
            statement.setInt(12, book.getDebt());
            statement.setInt(13, book.getId());
            statement.executeUpdate();
            logger.info("successful update book");
            return book;
        } catch (SQLException | NamingException e) {
            logger.info(e);
            throw new RuntimeException("Cannot update book", e);
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> listBook = new ArrayList<>();
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_BOOK)) {
            ResultSet rs = statement.executeQuery();
            listBook = initBook(rs);
            logger.info("successful getAll book");
            return listBook;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllEntity book", e);
        }
    }

    @Override
    public List<Book> getAllOrder() {
        List<Book> listBook = null;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_BOOK_STATUS_2)) {
            ResultSet rs = statement.executeQuery();
            listBook = initBook(rs);
            logger.info("successful getAllOrder");
            return listBook;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllOrder book", e);
        }
    }

    @Override
    public List<Book> getAllBooksByPersonID(int person_id) {
        List<Book> listBooks = null;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_BOOK_PERSON_ID)) {
            statement.setInt(1, person_id);
            ResultSet rs = statement.executeQuery();
            listBooks = initBook(rs);
            logger.info("successful getAllBooksByPersonID");
            return listBooks;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllBooksByPersonID book", e);
        }
    }

    @Override
    public List<Book> getAllOrderByPersonID(int person_id) {
        List<Book> listBooks = null;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_ORDER_PERSON_ID)) {
            statement.setInt(1, person_id);
            ResultSet rs = statement.executeQuery();
            listBooks = initBook(rs);
            logger.info("successful getAllOrderByPersonID");
            return listBooks;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllBooksByPersonID book", e);
        }
    }

    private List<Book> initBook(ResultSet rs) throws SQLException {
        List<Book> outerBooks = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setName(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setPublisher(rs.getString(4));
            book.setPublisherDate(rs.getString(5));
            book.setDescription(rs.getString(6));
            book.setPrice(rs.getInt(7));
            book.setGenre(rs.getString(8));
            book.setStatus(rs.getInt(9));
            book.setPerson_id(rs.getInt(10));
            book.setOrderStatus(rs.getInt(11));
            book.setReturnDate(rs.getDate(12));
            book.setDebt(rs.getInt(13));
            outerBooks.add(book);
        }
        return outerBooks;
    }

}
