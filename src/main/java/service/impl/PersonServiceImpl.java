package service.impl;

import model.dao.*;
import model.entity.Person;
import model.exception.*;
import model.dao.factory.DaoFactory;
import service.PersonService;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {

     private static Logger logger = Logger.getLogger(PersonServiceImpl.class);

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private PersonDao personDao = daoFactory.getPersonDAO();

    @Override
    public Person getByLoginAndPass(String login, String password) throws NotFoundPersonException, WrongDataException {
        Person person = personDao.getByLoginAndPass(login, password);

        if (Objects.isNull(person)) {
            throw new NotFoundPersonException();
        }

        return person;
    }

    @Override
    public Person getByLogin(String login) {
        return personDao.getByLogin(login);
    }

    @Override
    public Person getEntity(Integer id) throws DataBaseException, ServiceException {
        try {
            Person person = personDao.getById(id);
            return person;
        } catch (DataBaseException e) {
           logger.info(e);
            throw new ServiceException("Cannot get person in service", e);
        }
    }

    @Override
    public boolean add(Person entity) throws ServiceException {
        try {
            personDao.add(entity);
            return true;
        } catch (DataBaseException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Person update(Person entity) {
        return personDao.updateEntity(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return personDao.deleteEntity(id);
    }

    @Override
    public List<Person> getAll() throws ServiceException {
        return personDao.getAll();
    }

    @Override
    public List<Person> getAllPerson() throws ServiceException {
        List<Person> all = personDao.getAll();

        return all.stream()
                .filter(p -> p.getAccessLevel() == 2)
                .collect(Collectors.toList());
    }


    @Override
    public int getAllBlocked() {
        return personDao.getCountBlocked(personDao.getAll());
    }
}
