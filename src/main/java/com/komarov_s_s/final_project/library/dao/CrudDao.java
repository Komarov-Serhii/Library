package com.komarov_s_s.final_project.library.dao;

import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Model;



public interface CrudDao<K, T extends Model> {

    boolean add(T entity) throws DataBaseException;

    T getEntity(K id) throws DataBaseException, ServiceException;

    boolean deleteEntity(K id);

    T updateEntity(T entity);


}
