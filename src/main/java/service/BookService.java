package service;

import model.entity.Book;
import model.entity.Person;
import model.exception.ServiceException;
import service.factory.ItemService;

import java.util.List;
import java.util.Map;

public interface BookService extends ItemService<Integer, Book> {
        public List<Book> findByAuthorOrName(String text);

        public boolean setBookForApprove(int book_id, int person_id);

        public Map<Book, Person> getAllInfoByOrder();

        List<Book> getAllBusyBooks();

        List<Book> getAll() throws ServiceException;

        public List<Book> getAllOrder();

        List<Book> getAllBooksByPersonIDAndAddDebt(int person_id);

        List<Book> getAllOrderByPersonID(int person_id);


}
