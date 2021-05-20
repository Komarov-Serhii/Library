package com.komarov_s_s.final_project.library.service.factory;

import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Model;

public interface ItemService <K, T extends Model> {

    T getEntity(K id) throws DataBaseException, ServiceException;

    boolean add(T entity) throws ServiceException;

    T update(T entity);

    boolean delete(K id);
}
