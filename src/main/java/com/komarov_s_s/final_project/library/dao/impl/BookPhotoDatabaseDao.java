package com.komarov_s_s.final_project.library.dao.impl;

import com.komarov_s_s.final_project.library.dao.BookPhotoDao;
import com.komarov_s_s.final_project.library.dao.Connection.Connector;
import com.komarov_s_s.final_project.library.dao.Constant.Constants;
import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Book_Photo;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookPhotoDatabaseDao implements BookPhotoDao {

    public BookPhotoDatabaseDao() {
    }

    @Override
    public boolean add(Book_Photo entity) throws DataBaseException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.INSERT_BOOK_PHOTO)) {
            statement.setString(1, entity.getUrl());
            statement.setInt(2, entity.getId_book());
            statement.execute();
            return true;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot add add book_photo", e);
        }
    }

    @Override
    public Book_Photo getById(Integer id) throws DataBaseException, ServiceException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_ID_BOOK_PHOTO)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            String url = resultSet.getString("url");
            int id_book = resultSet.getInt("book_id");


            return new Book_Photo(id, url, id_book);
        } catch (SQLException | NamingException e) {
            throw new DataBaseException(String.format("Cannot get book_photo by id=%d", id), e);
        }
    }

    @Override
    public boolean deleteEntity(Integer id) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_BOOK_PHOTO)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | NamingException e) {
            Logger.getLogger(BookPhotoDatabaseDao.class.getName()).log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Cannot delete book_photo", e);
        }
    }

    @Override
    public Book_Photo updateEntity(Book_Photo book_photo) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_BOOK_PHOTO)) {
            statement.setString(1, book_photo.getUrl());
            statement.setInt(2, book_photo.getId_book());
            statement.setInt(3, book_photo.getId());

            statement.executeUpdate();
            return book_photo;
        } catch (SQLException | NamingException e) {
            Logger.getLogger(BookDatabaseDao.class.getName()).log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Cannot update book_photo", e);
        }
    }

    @Override
    public List<Book_Photo> getAllBook_Photo() {
        List<Book_Photo> outerBooks_photo = new ArrayList<>();
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_BOOK_PHOTO)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("url");
                int book_id = rs.getInt("book_id");

                Book_Photo outerBooks_photos = new Book_Photo(id, url, book_id);
                outerBooks_photo.add(outerBooks_photos);
            }
            return outerBooks_photo;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllEntity book_photo", e);
        }
    }
}
