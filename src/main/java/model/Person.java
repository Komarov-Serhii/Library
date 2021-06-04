package model;

import java.util.Objects;

public class Person extends Model{
    private String name;
    private String email;
    private String password;
    private int accessLevel;
    private int status;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Person(String name, String email, String password, int accessLevel, int status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
        this.status = status;
    }

    public Person(String name, String email, String password, int accessLevel) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public Person(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Person(int id, String name, String email, String password, int accessLevel, int status) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
        this.status = status;
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

        if (accessLevel != person.accessLevel) return false;
        if (status != person.status) return false;
        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(email, person.email)) return false;
        return Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + accessLevel;
        result = 31 * result + status;
        return result;
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
