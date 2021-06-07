package service.impl;

import model.dao.PersonDao;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.NotFoundPersonException;
import model.exception.ServiceException;
import model.exception.WrongDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class PersonServiceImplTest {

    @Mock
    PersonDao personDaoMock;
    @InjectMocks
    PersonServiceImpl testingInstance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getByLoginAndPass() throws NotFoundPersonException, WrongDataException {
        when(personDaoMock.getByLoginAndPass(any(),any())).thenReturn(new Person());
        Person result = testingInstance.getByLoginAndPass("basket@gmail.com", "1234567");
        assertEquals(new Person.PersonBuilderImpl().setId(0).setName(null).setEmail(null)
                .setPassword(null).setAccessLevel(0).setStatus(0).build(), result);
    }

    @Test
    void getByLogin() {
        when(personDaoMock.getByLogin(any())).thenReturn(new Person());
        Person result = testingInstance.getByLogin("basket@gmail.com");
        assertEquals(new Person.PersonBuilderImpl().setId(0).setName(null).setEmail(null)
                .setPassword(null).setAccessLevel(0).setStatus(0).build(), result);
    }

    @Test
    void getEntity() throws DataBaseException, ServiceException {
        when(personDaoMock.getById(any())).thenReturn(new Person());
        Person result = testingInstance.getEntity(0);
        assertEquals(new Person.PersonBuilderImpl().setId(0).setName(null).setEmail(null)
                .setPassword(null).setAccessLevel(0).setStatus(0).build(), result);
    }

    @Test
    void add() throws DataBaseException, ServiceException {
        when(personDaoMock.add(any())).thenReturn(true);
        boolean result = testingInstance.add(new Person.PersonBuilderImpl().setId(0).setName(null).setEmail(null)
                .setPassword(null).setAccessLevel(0).setStatus(0).build());
        assertTrue(result);
    }

    @Test
    void update() {
        when(personDaoMock.updateEntity(any())).thenReturn(new Person());
        Person result = testingInstance.update(new Person.PersonBuilderImpl().setId(0).setName(null).setEmail(null)
                .setPassword(null).setAccessLevel(0).setStatus(0).build());
        assertEquals(new Person.PersonBuilderImpl().setId(0).setName(null).setEmail(null)
                .setPassword(null).setAccessLevel(0).setStatus(0).build(), result);
    }

    @Test
    void delete() {
        when(personDaoMock.deleteEntity(any())).thenReturn(true);
        boolean result = testingInstance.delete(0);
        assertTrue(result);
    }

    @Test
    void getAll() throws ServiceException {
        when(personDaoMock.getAll()).thenReturn(Collections.singletonList(new Person()));
        List<Person> result = testingInstance.getAll();
        assertFalse(result.isEmpty());
    }

    @Test
    void getAllPerson() throws ServiceException {
        when(personDaoMock.getAll()).thenReturn(getPersons());
        List<Person> result = testingInstance.getAllPerson();
        assertEquals(2, result.size());
    }

    @Test
    void getAllBlocked() {
        when(personDaoMock.getCountBlocked(personDaoMock.getAll())).thenReturn(4);
        int count = testingInstance.getAllBlocked();
        assertEquals(4, count);
    }

    private List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        Person person = new Person.PersonBuilderImpl()
                .setName("name")
                .setEmail("email")
                .setPassword("esvge124E")
                .setAccessLevel(1)
                .setStatus(1)
                .build();

        Person person1 = new Person.PersonBuilderImpl()
                .setName("name")
                .setEmail("email")
                .setPassword("esvge124E")
                .setAccessLevel(2)
                .setStatus(1)
                .build();
        Person person2 = new Person.PersonBuilderImpl()
                .setName("name")
                .setEmail("email")
                .setPassword("esvge124E")
                .setAccessLevel(2)
                .setStatus(1)
                .build();
        list.add(person);
        list.add(person1);
        list.add(person2);
        return list;
    }
}