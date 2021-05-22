package com.komarov_s_s.final_project.library.dao.impl;

import com.komarov_s_s.final_project.library.dao.Connection.Connector;
import com.komarov_s_s.final_project.library.dao.Constant.Constants;
import com.komarov_s_s.final_project.library.dao.PersonDao;
import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Book;
import com.komarov_s_s.final_project.library.model.Person;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDatabaseDao implements PersonDao {

    public PersonDatabaseDao() {
    }

    @Override
    public boolean add(Person person) throws DataBaseException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.INSERT_PERSON)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getPassword());
            statement.setInt(4, person.getAccessLevel());
            statement.execute();
            return true;
        } catch (SQLException | NamingException e) {
            throw new DataBaseException("Cannot add person", e);
        }
    }

    @Override
    public Person getById(Integer id) throws DataBaseException, ServiceException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_ID_PERSON)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            int level = resultSet.getInt("level");

            return new Person(id, name, email, password , level);
        } catch (SQLException | NamingException e) {
            throw new DataBaseException(String.format("Cannot get person by id=%d", id), e);
        }
    }


    @Override
    public boolean deleteEntity(Integer id) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_PERSON)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | NamingException e) {
            Logger.getLogger(PersonDatabaseDao.class.getName()).log(Level.WARNING, e.getMessage(), e);
            throw new RuntimeException("Cannot delete person", e);
        }
    }

    @Override
    public Person updateEntity(Person person) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_PERSON)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getPassword());
            statement.setInt(4, person.getId());
            statement.executeUpdate();
            return person;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot update person", e);
        }
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> outerPeople = new ArrayList<>();
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_PERSON)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setName(rs.getString(2));
                person.setEmail(rs.getString(3));
                person.setPassword(rs.getString(4));
                person.setAccessLevel(rs.getInt(5));
                outerPeople.add(person);
            }
            return outerPeople;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllPerson", e);
        }
    }

    @Override
    public Person getByLoginAndPass(String login, String password) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_LOGIN)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            Person person = null;

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                int level = resultSet.getInt("level");


                person = new Person(id, name, email, pass, level);
            }

            return person;
        } catch (SQLException | NamingException e) {
            Logger.getLogger(PersonDatabaseDao.class.getName()).log(Level.WARNING, "Cannot get user by login = %s");
            throw new RuntimeException("Cannot getByLoginAndPass person", e);
        }
    }
}
