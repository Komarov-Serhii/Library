package model.entity;

import model.builder.PersonBuilder;

import java.util.Objects;

public class Person extends Model {
    private String name;
    private String email;
    private String password;
    private int accessLevel;
    private int status;


    private Person(PersonBuilderImpl builder) {
        super(builder.id);
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.accessLevel = builder.accessLevel;
        this.status = builder.status;
    }

    public static class PersonBuilderImpl implements PersonBuilder {

        private int id;
        private String name;
        private String email;
        private String password;
        private int accessLevel;
        private int status;

        @Override
        public PersonBuilder setId(int id) {
            this.id = id;
            return this;
        }

        @Override
        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public PersonBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public PersonBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        @Override
        public PersonBuilder setAccessLevel(int accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        @Override
        public PersonBuilder setStatus(int status) {
            this.status = status;
            return this;
        }

        @Override
        public Person build() {
            return new Person(this);
        }
    }

    public Person() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var person = (Person) o;
        return accessLevel == person.accessLevel && status == person.status
                && Objects.equals(name, person.name) && Objects.equals(email, person.email)
                && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, accessLevel, status);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accessLevel=" + accessLevel +
                ", status=" + status +
                '}';
    }
}
