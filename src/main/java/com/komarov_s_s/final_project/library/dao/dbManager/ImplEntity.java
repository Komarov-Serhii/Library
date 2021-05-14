package com.komarov_s_s.final_project.library.dao.dbManager;

import java.sql.SQLException;
import java.util.List;

public interface ImplEntity<E> {

    public boolean insertEntity(E entity) throws SQLException;

    public E getEntity(int id) throws SQLException;

    public boolean deleteEntity(int id) throws SQLException;

    public boolean updateEntity(E entity) throws SQLException;

    public List<E> findAllEntity() throws SQLException;
}
