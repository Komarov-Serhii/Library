package model.dao.impl;

import model.dao.BookDao;
import model.dao.Connection.Connector;
import model.dao.Constant.Constants;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import model.Book;


import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDatabaseDao implements BookDao {

    public BookDatabaseDao() {
    }


    @Override
    public boolean add(Book book) throws DataBaseException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.INSERT_BOOK)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setString(4, book.getPublisher_date());
            statement.setString(5, book.getDescription());
            statement.setInt(6, book.getPrice());
            statement.setString(7, book.getGenre());
            statement.setInt(8, book.getStatus());
            statement.setInt(9, book.getPerson_id());
            statement.setInt(10, book.getOrderStatus());
            statement.execute();
            return true;
        } catch (SQLException | NamingException e) {
            throw new DataBaseException("Cannot add book", e);
        }
    }

    @Override
    public Book getById(Integer id) throws DataBaseException, ServiceException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_ID_BOOK)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            String publisher_date = resultSet.getString("publisher_date");
            String description = resultSet.getString("description");
            int price = resultSet.getInt("price");
            String genre = resultSet.getString("genre");
            int status = resultSet.getInt("status");
            int person_id = resultSet.getInt("person_id");
            int orderStatus = resultSet.getInt("order_status");

            return new Book(id, name, author, publisher, publisher_date, description, price, genre, status, person_id, orderStatus);
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
            return true;
        } catch (SQLException | NamingException e) {
            Logger.getLogger(BookDatabaseDao.class.getName()).log(Level.WARNING, e.getMessage(), e);
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
            statement.setString(4, book.getPublisher_date());
            statement.setString(5, book.getDescription());
            statement.setInt(6, book.getPrice());
            statement.setString(7, book.getGenre());
            statement.setInt(8, book.getStatus());
            statement.setInt(9, book.getPerson_id());
            statement.setInt(10, book.getOrderStatus());
            statement.setInt(11, book.getId());
            statement.executeUpdate();
            return book;
        } catch (SQLException | NamingException e) {
            Logger.getLogger(BookDatabaseDao.class.getName()).log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Cannot update book", e);
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> outerBooks = new ArrayList<>();
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_BOOK)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisher(rs.getString(4));
                book.setPublisher_date(rs.getString(5));
                book.setDescription(rs.getString(6));
                book.setPrice(rs.getInt(7));
                book.setGenre(rs.getString(8));
                book.setStatus(rs.getInt(9));
                book.setOrderStatus(rs.getInt(10));
                book.setPerson_id(rs.getInt(11));
                outerBooks.add(book);
            }
            return outerBooks;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllEntity book", e);
        }
    }

    @Override
    public List<Book> getAllOrder() {
        List<Book> outerBooks = new ArrayList<>();
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_BOOK_STATUS_2)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisher(rs.getString(4));
                book.setPublisher_date(rs.getString(5));
                book.setDescription(rs.getString(6));
                book.setPrice(rs.getInt(7));
                book.setGenre(rs.getString(8));
                book.setStatus(rs.getInt(9));
                book.setPerson_id(rs.getInt(10));
                book.setOrderStatus(rs.getInt(11));
                outerBooks.add(book);
            }
            return outerBooks;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllOrder book", e);
        }
    }

}
