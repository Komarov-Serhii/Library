package model.dao;

import model.Book_Photo;

import java.util.List;

public interface BookPhotoDao extends CrudDao<Integer, Book_Photo> {
    List<Book_Photo> getAllBook_Photo() ;

}
