package com.komarov_s_s.final_project.library.service.impl;

import com.komarov_s_s.final_project.library.dao.PersonDao;
import com.komarov_s_s.final_project.library.dao.factory.DaoFactory;
import com.komarov_s_s.final_project.library.dao.impl.PersonDatabaseDao;
import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.NotFoundPersonException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.exception.WrongDataException;
import com.komarov_s_s.final_project.library.model.Person;
import com.komarov_s_s.final_project.library.service.PersonService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonServiceImpl implements PersonService {

   // private static Logger logger = Logger.getLogger(String.valueOf(PersonServiceImpl.class));

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private PersonDao personDao = daoFactory.getPersonDAO();

    @Override
    public Person getByLoginAndPass(String login, String password) throws NotFoundPersonException, WrongDataException {
        return null;
    }

//    @Override
//    public List<Person> registrationUserForSite(Person person, String[] personId) throws ServiceException {
//        return null;
//    }

    @Override
    public Person getEntity(Integer id) throws DataBaseException, ServiceException {
        try {
            Person person = personDao.getById(id);
            return person;
        } catch (DataBaseException e) {
            Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.WARNING, e.getMessage(), e);
            throw new ServiceException("Cannot get person in service",e);
        }
    }

    @Override
    public boolean add(Person entity) {
        return false;
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
