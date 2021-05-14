package com.komarov_s_s.final_project.library.dao.dbManager;

import com.komarov_s_s.final_project.library.dao.entity.Book;
import com.komarov_s_s.final_project.library.dao.entity.Person;

import java.sql.SQLException;
import java.util.List;

public class Solution {

    private static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) throws SQLException {
        DbPerson dbPerson = new DbPerson(Connector.getInstance());
//        dbPerson.insertEntity(new Person("ivanov","Nikita"));
//        dbPerson.insertEntity(new Person("petrov","pitrov"));
//        dbPerson.insertEntity(new Person("obama","Abama"));
//
//        printList(dbPerson.findAllEntity());
//        dbPerson.deleteEntity(1);


        DbBook dbBook = new DbBook(Connector.getInstance());
//        dbBook.insertEntity(new Book("15 нигерс", "Nikita", "dshh", "2008", "Super class", 500));
//        dbBook.insertEntity(new Book("10 нигерс", "BORY", "nhgng", "2010", "Super class", 700));
//        dbBook.insertEntity(new Book("5 нигерс", "NOR", "qwdf", "2012", "Super class", 1000));

//        dbBook.getEntity(9).setName("House");
//        dbBook.updateEntity(dbBook.getEntity(9));

        Book teamC = dbBook.getEntity(9);
        teamC.setName("House");
        dbBook.updateEntity(teamC);
        //printList(dbBook.findAllEntity());

        Person teamA = dbPerson.getEntity(6);
        teamA.setName("Matros");
        dbPerson.updateEntity(teamA);
    }
}
