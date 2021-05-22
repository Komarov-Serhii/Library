package com.komarov_s_s.final_project.library;

import com.komarov_s_s.final_project.library.dao.impl.BookDatabaseDao;
import com.komarov_s_s.final_project.library.dao.impl.BookPhotoDatabaseDao;
import com.komarov_s_s.final_project.library.dao.impl.CartDatabaseDao;
import com.komarov_s_s.final_project.library.dao.impl.PersonDatabaseDao;
import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Person;

import java.util.List;

public class Solution {

    private static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) throws DataBaseException, ServiceException {
//        PersonDatabaseDao personDao = new PersonDatabaseDao();
//        BookDatabaseDao bookDao = new BookDatabaseDao();
//        BookPhotoDatabaseDao book_photoDao = new BookPhotoDatabaseDao();
//        CartDatabaseDao cartDao = new CartDatabaseDao();

  //      personDao.add(new Person("admin", "admin@gmail.com", "1111",3));
//        personDao.add(new Person("petrov", "pitrov@gmail.com", "12345678",2));
//        personDao.add(new Person("obama", "Abama@gmail.com", "qazwsxedc",3));

     //   personDao.deleteEntity(18);
//        printList(personDao.getAllPerson());
  //      System.out.println(personDao.getById(20));
//
//        Person person = personDao.getById(20);
//        person.setName("Matros");
//        personDao.updateEntity(person);

//-----------------------------------------------------------

//        bookDatabaseDao.add(new Book("15 нигерс", "Nikita", "dshh", "2008", "Super class", 500, "sb"));
//        bookDatabaseDao.add(new Book("10 нигерс", "BORY", "nhgng", "2010", "Super class", 700, "sb"));
//        bookDatabaseDao.add(new Book("5 нигерс", "NOR", "qwdf", "2012", "Super class", 1000, "sb"));

        //bookDao.deleteEntity(9);
        //  printList(bookDao.getAllBook());
        //    System.out.println(bookDao.getEntity(14));

//        Book book = bookDao.getEntity(13);
//        book.setName("Matros");
//        bookDao.updateEntity(book);
        //-----------------------------------------------------------

//        book_photoDao.add(new Book_Photo("picture_1", 12));
//        book_photoDao.add(new Book_Photo("picture_2", 13));
//        book_photoDao.add(new Book_Photo("picture_3", 14));
//
        // book_photoDao.deleteEntity(5);
        //     printList(book_photoDao.getAllBook_Photo());
        //     System.out.println(book_photoDao.getEntity(6));

//        Book_Photo book_photo = book_photoDao.getEntity(6);
//        book_photo.setUrl("AAAAAAAA");
//        book_photoDao.updateEntity(book_photo);

        //-----------------------------------------------------------

//        cartDao.add(new Cart(13, 12));
//        cartDao.add(new Cart(14, 13));
//        cartDao.add(new Cart(15, 14 ));

//
        //   cartDao.deleteEntity(14);
        //    System.out.println(cartDao.getEntity(15));

//        Cart cart = cartDao.getEntity(15);
//        cart.setPerson_id(16);
//        cartDao.updateEntity(cart);




    }
}
