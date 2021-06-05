package service;

import model.entity.Person;
import service.factory.ItemService;
import model.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService extends ItemService<Integer, Book> {
        public List<Book> findByAuthorOrName(String text);

        public void setBookForApprove(int book_id, int person_id);

        public Map<Person, Book> getAllInfoByOrder();


        public List<Book> getAllOrder();

        List<Book> getAllBooksByPersonIDAndAddDebt(int person_id);

        List<Book> getAllOrderByPersonID(int person_id);


}
