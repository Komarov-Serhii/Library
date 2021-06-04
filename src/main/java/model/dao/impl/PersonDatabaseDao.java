package model.dao.impl;

import model.dao.Connection.Connector;
import model.dao.Constant.Constants;
import model.dao.PersonDao;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import model.Person;
import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


public class PersonDatabaseDao implements PersonDao {

    private static Logger logger = Logger.getLogger(PersonDatabaseDao.class);


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
            statement.setInt(5, person.getStatus());
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
            int status = resultSet.getInt("status");

            return new Person(id, name, email, password , level, status);
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
            logger.info(e);
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
                int status = resultSet.getInt("status");


                person = new Person(id, name, email, pass, level, status);
            }

            return person;
        } catch (SQLException | NamingException e) {
            logger.info("Cannot get user by login = %s");
            throw new RuntimeException("Cannot getByLoginAndPass person", e);
        }
    }

    @Override
    public int getAllBlocked(List<Person> person) {
        int count = 0;
        for (Person num : person) {
            if (num.getStatus() == 2) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getAllUnblocked(List<Person> person) {
        int count = 0;
        for (Person num : person) {
            if (num.getStatus() == 1) {
                count++;
            }
        }
        return count;
    }
}
