package com.komarov_s_s.final_project.library.dao;

import com.komarov_s_s.final_project.library.model.Book_Photo;

import java.util.List;

public interface BookPhotoDao extends CrudDao<Integer, Book_Photo> {
    List<Book_Photo> getAllBook_Photo() ;

}
