package service;

import model.exception.*;
import model.Person;
import service.factory.ItemService;

import java.util.List;


public interface PersonService extends ItemService<Integer, Person> {
    Person getByLoginAndPass(String login, String password) throws NotFoundPersonException, WrongDataException;

    Person getByLogin(String login);

    int getAllBlocked();

    List<Person> getAllPerson() throws ServiceException;
}
