package com.komarov_s_s.final_project.library.dao.impl;

import com.komarov_s_s.final_project.library.dao.BookDao;
import com.komarov_s_s.final_project.library.dao.Book_PhotoDao;
import com.komarov_s_s.final_project.library.dao.Connection.ConnectionSupport;
import com.komarov_s_s.final_project.library.dao.Connection.Connector;
import com.komarov_s_s.final_project.library.dao.Constant.Constants;
import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Book;
import com.komarov_s_s.final_project.library.model.Book_Photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book_PhotoDatabaseDao extends ConnectionSupport implements Book_PhotoDao {

    public Book_PhotoDatabaseDao(Connector connector) {
        super(connector);
    }

    @Override
    public boolean add(Book_Photo entity) throws DataBaseException {
        try (Connection connection = connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.INSERT_BOOK_PHOTO)) {
            statement.setString(1, entity.getUrl());
            statement.setInt(2, entity.getId_book());
            statement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot add add book_photo", e);
        }
    }

    @Override
    public Book_Photo getEntity(Integer id) throws DataBaseException, ServiceException {
        return null;
    }

    @Override
    public boolean deleteEntity(Integer id) throws SQLException {
        return false;
    }

    @Override
    public Book_Photo updateEntity(Book_Photo entity) throws SQLException {
        return null;
    }
}
