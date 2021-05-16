package com.komarov_s_s.final_project.library;

import com.komarov_s_s.final_project.library.dao.Book_PhotoDao;
import com.komarov_s_s.final_project.library.dao.Connection.Connector;
import com.komarov_s_s.final_project.library.dao.impl.BookDatabaseDao;
import com.komarov_s_s.final_project.library.dao.impl.Book_PhotoDatabaseDao;
import com.komarov_s_s.final_project.library.dao.impl.PersonDatabaseDao;
import com.komarov_s_s.final_project.library.exception.DataBaseException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.model.Book;
import com.komarov_s_s.final_project.library.model.Book_Photo;
import com.komarov_s_s.final_project.library.model.Person;

import java.util.List;

public class Solution {

    private static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) throws ServiceException, DataBaseException {
        PersonDatabaseDao personDao = new PersonDatabaseDao(Connector.getInstance());
      //  personDao.add(new Person("ivanov","Nikita"));
//        personDao.add(new Person("petrov","pitrov"));
//        personDao.add(new Person("obama","Abama"));
//
       // Person s = personDao.getEntity(1);
      //  s.setName("lox");
      //  personDao.updateEntity(s);
        personDao.deleteEntity(1);

    //    printList(personDao.findAllEntity());
    //   personDao.deleteEntity(1);


//        BookDatabaseDao bookDatabaseDao = new BookDatabaseDao(Connector.getInstance());
//        dbBook.insertEntity(new Book("15 нигерс", "Nikita", "dshh", "2008", "Super class", 500, "sb"));
//        dbBook.insertEntity(new Book("10 нигерс", "BORY", "nhgng", "2010", "Super class", 700, "sb"));
//        dbBook.insertEntity(new Book("5 нигерс", "NOR", "qwdf", "2012", "Super class", 1000, "sb"));

//        dbBook.getEntity(9).setName("House");
//        dbBook.updateEntity(dbBook.getEntity(9));
//        printList(dbBook.findAllEntity());
  //      Book teamC = bookDatabaseDao.getEntity(30);
        //teamC.setName("House");
 //       System.out.println(teamC);
//        dbBook.updateEntity(teamC);
        //printList(dbBook.findAllEntity());

//        Person teamA = dbPerson.getEntity(6);
//        teamA.setName("Matros");
//        dbPerson.updateEntity(teamA);

//        Book_PhotoDao book_photoDao = new Book_PhotoDatabaseDao(Connector.getInstance());
//        book_photoDao.add(new Book_Photo("asf",1));

    }
}
