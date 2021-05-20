package com.komarov_s_s.final_project.library.service;

import com.komarov_s_s.final_project.library.exception.NotFoundPersonException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.exception.WrongDataException;
import com.komarov_s_s.final_project.library.model.Person;
import com.komarov_s_s.final_project.library.service.factory.ItemService;

import java.util.List;

public interface PersonService extends ItemService<Integer, Person> {
    Person getByLoginAndPass(String login, String password) throws NotFoundPersonException, WrongDataException;

    //List<Person> registrationUserForSite(Person person, String[] personId) throws ServiceException;
}
