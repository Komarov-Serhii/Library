package model.dao;

import model.entity.Book;
import java.util.List;

public interface BookDao extends CrudDao<Integer, Book> {
    List<Book> getAll();

    List<Book> getAllOrder();

    List<Book> getAllBooksByPersonID(int person_id);

    List<Book> getAllOrderByPersonID(int person_id);


}
