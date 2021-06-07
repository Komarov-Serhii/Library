package model.dao;

import model.exception.DataBaseException;
import model.exception.ServiceException;
import model.entity.Model;



public interface CrudDao<K, T extends Model> {

    boolean add(T entity) throws DataBaseException;

    T getById(K id) throws DataBaseException;

    boolean deleteEntity(K id);

    T updateEntity(T entity);


}
