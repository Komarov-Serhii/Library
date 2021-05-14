package com.komarov_s_s.final_project.library.dao.entity;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private String publisher_date;
    private String description;
    private int price;

    public Book() {

    }

    public Book(String name, String author, String publisher, String publisher_date, String description, int price) {

        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publisher_date = publisher_date;
        this.description = description;
        this.price = price;
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher_date() {
        return publisher_date;
    }

    public void setPublisher_date(String publisher_date) {
        this.publisher_date = publisher_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Book createBook(String name) {
        return new Book(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(name, book.name);
    }
}
