package com.komarov_s_s.final_project.library.dao;

import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Model;

import java.sql.SQLException;

public interface CrudDao<K, T extends Model> {

    boolean add(T entity) throws DataBaseException, SQLException;

    T getEntity(K id) throws DataBaseException, ServiceException;

    boolean deleteEntity(K id) throws SQLException;

    T updateEntity(T entity) throws SQLException;


}
