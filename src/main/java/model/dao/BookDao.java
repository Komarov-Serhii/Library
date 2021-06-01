package model.dao;

import model.Book;
import java.util.List;

public interface BookDao extends CrudDao<Integer, Book> {
    List<Book> getAll();
    List<Book> getAllOrder();


}
