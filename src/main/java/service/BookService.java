package service;

import service.factory.ItemService;
import model.Book;

import java.util.List;

public interface BookService extends ItemService<Integer, Book> {
        public List<Book> findByAuthorOrName(String text);

}
