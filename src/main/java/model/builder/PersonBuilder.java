package model.builder;

import model.entity.Person;

public interface PersonBuilder {
    PersonBuilder setId(int id);
    PersonBuilder setName(String name);
    PersonBuilder setEmail(String email);
    PersonBuilder setPassword(String password);
    PersonBuilder setAccessLevel(int accessLevel);
    PersonBuilder setStatus(int status);
    Person build();
}
