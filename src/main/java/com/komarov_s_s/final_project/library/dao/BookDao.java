package com.komarov_s_s.final_project.library.dao;

import com.komarov_s_s.final_project.library.model.Book;
import java.util.List;

public interface BookDao extends CrudDao<Integer, Book> {
    List<Book> getAllBook();
}
