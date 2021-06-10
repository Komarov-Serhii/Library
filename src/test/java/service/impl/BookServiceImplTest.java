package service.impl;

import model.dao.BookDao;
import model.dao.PersonDao;
import model.entity.Book;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.naming.NamingException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class BookServiceImplTest {

    @Mock
    BookDao bookDaoMock;
    @Mock
    PersonDao personDaoMock;
    @InjectMocks
    BookServiceImpl testingInstance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getEntity() throws ServiceException, DataBaseException {
        when(bookDaoMock.getById(any())).thenReturn(new Book());
        Book result = testingInstance.getEntity(0);
        assertEquals(new Book.BookBuilderImpl()
                .setId(0)
                .setName(null)
                .setAuthor(null)
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(0)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(0)
                .setOrderStatus(0)
                .setReturnDate(null)
                .setDebt(0)
                .build(), result);
    }

    @Test
    void add() throws ServiceException, DataBaseException, SQLException, NamingException {
        when(bookDaoMock.add(any())).thenReturn(true);
        boolean result = testingInstance.add(new Book.BookBuilderImpl()
                .setId(0)
                .setName(null)
                .setAuthor(null)
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(0)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(0)
                .setOrderStatus(0)
                .setReturnDate(null)
                .setDebt(0)
                .build());
        assertTrue(result);
    }

    @Test
    void update() {
        when(bookDaoMock.updateEntity(any())).thenReturn(new Book());
        Book result = testingInstance.update(new Book.BookBuilderImpl()
                .setId(0)
                .setName(null)
                .setAuthor(null)
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(0)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(0)
                .setOrderStatus(0)
                .setReturnDate(null)
                .setDebt(0)
                .build());
        assertEquals(new Book.BookBuilderImpl()
                .setId(0)
                .setName(null)
                .setAuthor(null)
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(0)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(0)
                .setOrderStatus(0)
                .setReturnDate(null)
                .setDebt(0)
                .build(), result);
    }

    @Test
    void delete() throws SQLException, NamingException {
        when(bookDaoMock.deleteEntity(any())).thenReturn(true);
        boolean result = testingInstance.delete(0);
        assertTrue(result);
    }

    @Test
    void getAll() throws ServiceException {
        when(bookDaoMock.getAllFree()).thenReturn(Collections.singletonList(new Book()));
        List<Book> result = testingInstance.getAllFree();
        assertFalse(result.isEmpty());
    }

    @Test
    void findByAuthorOrName() {
        when(bookDaoMock.getAllFree()).thenReturn(getBooks());
        List<Book> result = testingInstance.findByAuthorOrName("GHR");
        assertEquals(2, result.size());
    }

    @Test
    void setBookForApprove() throws DataBaseException {
        when(bookDaoMock.getById(2)).thenReturn(getBook());
        boolean a = testingInstance.setBookForApprove(2, 8);
        assertTrue(a);
    }

    @Test
    void getAllInfoByOrder() throws DataBaseException { ///////
        when(bookDaoMock.getAllOrder()).thenReturn(getBooks());
        when(personDaoMock.getAll()).thenReturn(getPersons());
        //when(personDaoMock.getById(1)).thenReturn(getBook());
        Map<Book, Person> result = testingInstance.getAllInfoByOrder();
        assertEquals(1, result.size());
    }

    @Test
    void getAllOrder() {
        when(bookDaoMock.getAllOrder()).thenReturn(Collections.singletonList(new Book()));
        List<Book> result = testingInstance.getAllOrder();
        assertFalse(result.isEmpty());
    }

    @Test
    void getAllBooksByPersonIDAndAddDebt() {
        when(bookDaoMock.getAllBooksByPersonID(1)).thenReturn(getBooks());
        List<Book> result = testingInstance.getAllBooksByPersonIDAndAddDebt(1);
        assertEquals(300, result.get(0).getDebt());
        assertEquals(0, result.get(1).getDebt());
    }

    @Test
    void getAllOrderByPersonID() {
        when(bookDaoMock.getAllOrderByPersonID(0)).thenReturn(Collections.singletonList(new Book()));
        List<Book> result = testingInstance.getAllOrderByPersonID(0);
        assertFalse(result.isEmpty());
    }

    private List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        Book book1 = new Book.BookBuilderImpl()
                .setId(1)
                .setName("GHR")
                .setAuthor("bdfb")
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(1000)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(1)
                .setOrderStatus(0)
                .setReturnDate(Date.valueOf("2021-05-03"))
                .setDebt(0).build();

        Book book2 = new Book.BookBuilderImpl()
                .setId(2)
                .setName("GHR")
                .setAuthor("bdfb")
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(1000)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(2)
                .setOrderStatus(0)
                .setReturnDate(Date.valueOf("2021-07-03"))
                .setDebt(0)
                .build();

        Book book3 = new Book.BookBuilderImpl()
                .setId(3)
                .setName("eahr")
                .setAuthor("earhg")
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(1000)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(2)
                .setOrderStatus(0)
                .setReturnDate(Date.valueOf("2021-07-03"))
                .setDebt(0)
                .build();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        return list;
    }

    private Book getBook() {
        Book book1 = new Book.BookBuilderImpl()
                .setId(1)
                .setName("eg")
                .setAuthor("arh")
                .setPublisher(null)
                .setPublisher(null)
                .setDescription(null)
                .setPrice(1000)
                .setGenre(null)
                .setStatus(0)
                .setPersonId(2)
                .setOrderStatus(0)
                .setReturnDate(Date.valueOf("2021-05-03"))
                .setDebt(0)
                .build();
        return book1;
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