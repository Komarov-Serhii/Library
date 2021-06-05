package model.dao;

import model.Person;


import java.util.List;

public interface PersonDao extends CrudDao<Integer, Person> {
     List<Person> getAll();

     Person getByLoginAndPass(String login, String password);

     Person getByLogin(String login);

     int getAllBlocked(List<Person> person);

     int getAllUnblocked(List<Person> person);

}
