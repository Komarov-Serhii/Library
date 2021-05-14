package com.komarov_s_s.final_project.library.dao.dbManager;

import com.komarov_s_s.final_project.library.dao.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbPerson extends ConnectionSupport implements ImplEntity<Person> {

    private Connection conn;

    public DbPerson(Connector connector) {
        super(connector);
    }

    @Override
    public boolean insertEntity(Person entity) throws SQLException {
        conn = Connector.getInstance().getConnection();
        conn.setAutoCommit(false);
        try (PreparedStatement statement = conn.prepareStatement(Constants.INSERT_PERSON);
             ResultSet ids = conn.createStatement().executeQuery(Constants.SELECT_MAX_ID_PERSON)) {
            while (ids.next()) {
                entity.setId(ids.getInt(1) + 1);
            }
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getEmail());
            statement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            Logger.getLogger(DbPerson.class.getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
        return true;
    }

    @Override
    public Person getEntity(int id) throws SQLException {
        conn = Connector.getInstance().getConnection();
        Person foundPerson;
        int count = 0;
        try (Statement statement = conn.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Constants.ALL_PERSON)) {
                foundPerson = null;
                while (rs.next()) {
                    count++;
                    if (rs.getInt(1) == id) {
                        foundPerson = new Person(rs.getString(2));
                        foundPerson.setId(count);
                    }
                }
            }
        } finally {
            conn.close();
        }
        return foundPerson;
    }

    @Override
    public boolean deleteEntity(int id) throws SQLException {
        conn = Connector.getInstance().getConnection();
        conn.setAutoCommit(false);
        try (PreparedStatement statement = conn.prepareStatement(Constants.DELETE_PERSON)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            Logger.getLogger(DbPerson.class.getName()).log(Level.WARNING, e.getMessage(), e);
            conn.rollback();
            return false;
        } finally {
            conn.setAutoCommit(true);
        }
        return true;
    }

    @Override
    public boolean updateEntity(Person entity) throws SQLException {
        conn = Connector.getInstance().getConnection();
        conn.setAutoCommit(false);
        try (PreparedStatement statement = conn.prepareStatement(Constants.UPDATE_PERSON)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getEmail());
            statement.setInt(3, entity.getId());
            statement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        } finally {
            conn.close();
        }
        return false;
    }

    @Override
    public List<Person> findAllEntity() throws SQLException {
        List<Person> outerPeople = new ArrayList<>();
        conn = Connector.getInstance().getConnection();
        try (Statement statement = conn.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Constants.ALL_PERSON)) {
                while (rs.next()) {
                    Person person = new Person();
                    person.setId(rs.getInt(1));
                    person.setName(rs.getString(2));
                    person.setEmail(rs.getString(3));
                    outerPeople.add(new Person(rs.getString(2)));
                }
            }
        } finally {
            conn.close();
        }
        return outerPeople;
    }
}
