package com.komarov_s_s.final_project.library.dao;

import com.komarov_s_s.final_project.library.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao extends CrudDao<Integer, Person> {
     List<Person> findAllEntity();
}
