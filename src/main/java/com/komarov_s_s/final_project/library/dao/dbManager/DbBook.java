package com.komarov_s_s.final_project.library.dao.dbManager;

import com.komarov_s_s.final_project.library.dao.entity.Book;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbBook extends ConnectionSupport implements ImplEntity<Book> {


        private Connection conn;

        public DbBook(Connector connector) {
            super(connector);
        }

        @Override
        public boolean insertEntity(Book entity) throws SQLException {
            conn = Connector.getInstance().getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement statement = conn.prepareStatement(Constants.INSERT_BOOK);
                 ResultSet ids = conn.createStatement().executeQuery(Constants.SELECT_MAX_ID_BOOK)) {
                while (ids.next()) {
                    entity.setId(ids.getInt(1) + 1);
                }
                statement.setInt(1, entity.getId());
                statement.setString(2, entity.getName());
                statement.setString(3, entity.getAuthor());
                statement.setString(4, entity.getPublisher());
                statement.setString(5, entity.getPublisher_date());
                statement.setString(6, entity.getDescription());
                statement.setInt(7, entity.getPrice());
                statement.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                Logger.getLogger(DbBook.class.getName()).log(Level.WARNING, e.getMessage(), e);
                return false;
            } finally {
                conn.setAutoCommit(true);
                conn.close();
            }
            return true;
        }

        @Override
        public Book getEntity(int id) throws SQLException {
            conn = Connector.getInstance().getConnection();
            Book foundBook;
            int count = 0;
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery(Constants.ALL_BOOK)) {
                    foundBook = null;
                    while (rs.next()) {
                        count++;
                        if (rs.getInt(1) == id) {
                            foundBook = new Book(rs.getString(2));
                            foundBook.setId(count);
                        }
                    }
                }
            } finally {
                conn.close();
            }
            return foundBook;
        }

        @Override
        public boolean deleteEntity(int id) throws SQLException {
            conn = Connector.getInstance().getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement statement = conn.prepareStatement(Constants.DELETE_BOOK)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                Logger.getLogger(DbBook.class.getName()).log(Level.WARNING, e.getMessage(), e);
                conn.rollback();
                return false;
            } finally {
                conn.setAutoCommit(true);
            }
            return true;
        }

        @Override
        public boolean updateEntity(Book entity) throws SQLException {
            conn = Connector.getInstance().getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement statement = conn.prepareStatement(Constants.UPDATE_BOOK)) {
                statement.setString(1, entity.getName());
                statement.setString(2, entity.getAuthor());
                statement.setString(3, entity.getPublisher());
                statement.setString(4, entity.getPublisher_date());
                statement.setString(5, entity.getDescription());
                statement.setInt(6, entity.getPrice());
                statement.setInt(7, entity.getId());
                statement.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                Logger.getLogger(DbBook.class.getName()).log(Level.WARNING, e.getMessage(), e);
                conn.rollback();
            } finally {
                conn.close();
            }
            return false;
        }

        @Override
        public List<Book> findAllEntity() throws SQLException {
            List<Book> outerBooks = new ArrayList<>();
            conn = Connector.getInstance().getConnection();
            try (Statement statement = conn.createStatement()) {
                try (ResultSet rs = statement.executeQuery(Constants.ALL_BOOK)) {
                    while (rs.next()) {
                        Book book = new Book();
                        book.setId(rs.getInt(1));
                        book.setName(rs.getString(2));
                        book.setAuthor(rs.getString(3));
                        book.setPublisher(rs.getString(4));
                        book.setPublisher_date(rs.getString(5));
                        book.setDescription(rs.getString(6));
                        book.setPrice(rs.getInt(7));
                        outerBooks.add(new Book(rs.getString(2)));
                    }
                }
            } finally {
                conn.close();
            }
            return outerBooks;
        }
}
