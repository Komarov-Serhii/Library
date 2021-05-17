package com.komarov_s_s.final_project.library.model;

import java.util.Objects;

public class Person extends Model{
    private String name;
    private String email;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name);
    }
}
