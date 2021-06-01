package service;

import model.Person;
import service.factory.ItemService;
import model.Book;

import java.util.List;
import java.util.Map;

public interface BookService extends ItemService<Integer, Book> {
        public List<Book> findByAuthorOrName(String text);

        public void setBookForApprove(int book_id, int person_id);

        public Map<Person, Book> getAllInfoByOrder();


        public List<Book> getAllOrder();

}
