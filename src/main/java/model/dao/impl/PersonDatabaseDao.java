package model.dao.impl;

import model.dao.Connection.Connector;
import model.dao.PersonDao;
import model.dao.constant.Constants;
import model.entity.Person;
import model.exception.DataBaseException;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonDatabaseDao implements PersonDao {

    private static Logger logger = Logger.getLogger(PersonDatabaseDao.class);


    public PersonDatabaseDao() {
    }

    @Override
    public boolean add(Person person) throws DataBaseException, SQLException, NamingException {
        Connection connection = Connector.getInstance().getConnection();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(Constants.INSERT_PERSON)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getPassword());
            statement.setInt(4, person.getAccessLevel());
            statement.setInt(5, person.getStatus());
            statement.execute();
            logger.info("successful add person");
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw new DataBaseException("Cannot add person", e);
        }
    }

    @Override
    public Person getById(Integer id) throws DataBaseException {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_ID_PERSON)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            logger.info("successful getById person");
            return new Person.PersonBuilderImpl()
                    .setId(id)
                    .setName(resultSet.getString("name"))
                    .setEmail(resultSet.getString("email"))
                    .setPassword(resultSet.getString("password"))
                    .setAccessLevel(resultSet.getInt("level"))
                    .setStatus(resultSet.getInt("status"))
                    .build();
        } catch (SQLException | NamingException e) {
            throw new DataBaseException(String.format("Cannot get person by id=%d", id), e);
        }
    }


    @Override
    public boolean deleteEntity(Integer id) throws NamingException, SQLException {
        Connection connection = Connector.getInstance().getConnection();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(Constants.DELETE_PERSON)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            logger.info("successful delete person");
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
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
            statement.setInt(4, person.getStatus());
            statement.setInt(5, person.getId());
            statement.executeUpdate();
            logger.info("successful update person");
            return person;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot update person", e);
        }
    }

    @Override
    public List<Person> getAll() {
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
                person.setStatus(rs.getInt(6));
                outerPeople.add(person);
            }
            logger.info("successful getAll person");
            return outerPeople;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllPerson", e);
        }
    }

    @Override
    public Person getByLoginAndPass(String login, String password) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_LOGIN_AND_PASS)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            Person person = null;

            if (resultSet.next()) {
                person = new Person.PersonBuilderImpl()
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setEmail(resultSet.getString("email"))
                        .setPassword(resultSet.getString("password"))
                        .setAccessLevel(resultSet.getInt("level"))
                        .setStatus(resultSet.getInt("status"))
                        .build();
            }
            logger.info("successful getByLoginAndPass person");
            return person;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getByLoginAndPass person", e);
        }
    }

    @Override
    public Person getByLogin(String login) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            Person person = null;

            if (resultSet.next()) {
                person = new Person.PersonBuilderImpl()
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setEmail(resultSet.getString("email"))
                        .setPassword(resultSet.getString("password"))
                        .setAccessLevel(resultSet.getInt("level"))
                        .setStatus(resultSet.getInt("status"))
                        .build();
            }
            logger.info("successful getByLogin person");
            return person;
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getByLogin person", e);
        }
    }

    @Override
    public int getCountBlocked(List<Person> person) {
        var count = 0;
        for (Person num : person) {
            if (num.getStatus() == 2) {
                count++;
            }
        }
        return count;
    }
}
