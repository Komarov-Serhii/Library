package com.komarov_s_s.final_project.library.dao.impl;

import com.komarov_s_s.final_project.library.dao.CartDao;
import com.komarov_s_s.final_project.library.dao.Connection.Connector;
import com.komarov_s_s.final_project.library.dao.Constant.Constants;
import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartDatabaseDao implements CartDao {

    public CartDatabaseDao() {
    }

    @Override
    public boolean add(Cart entity) throws DataBaseException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.INSERT_CART)) {
            statement.setInt(1, entity.getPerson_id());
            statement.setInt(2, entity.getBook_id());
            statement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot add cart", e);
        }
    }

    @Override
    public Cart getEntity(Integer id) throws DataBaseException, ServiceException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_ID_CART)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int person_id = resultSet.getInt("person_id");
            int book_id = resultSet.getInt("book_id");


            return new Cart(id, person_id, book_id);
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Cannot get cart by id=%d", id), e);
        }
    }

    @Override
    public boolean deleteEntity(Integer id) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_CART)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(BookPhotoDatabaseDao.class.getName()).log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Cannot delete cart", e);
        }
    }

    @Override
    public Cart updateEntity(Cart entity) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_CART)) {
            statement.setInt(1, entity.getPerson_id());
            statement.setInt(2, entity.getBook_id());
            statement.setInt(3, entity.getId());

            statement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            Logger.getLogger(BookDatabaseDao.class.getName()).log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Cannot update book_photo", e);
        }
    }
}
