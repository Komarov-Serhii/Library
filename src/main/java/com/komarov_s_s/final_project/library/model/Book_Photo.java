package com.komarov_s_s.final_project.library.model;

public class Book_Photo extends Model{

    private String url;
    private int id_book;

    public Book_Photo() {
    }

    public Book_Photo(String url) {
        this.url = url;
    }

    public Book_Photo(int id, String url) {
        super(id);
        this.url = url;
    }

    public Book_Photo(String url, int id_book) {
        this.url = url;
        this.id_book = id_book;

    }

    public Book_Photo(int id) {
        super(id);
    }

    public Book_Photo(int id, String url, int id_book) {
        super(id);
        this.url = url;
        this.id_book = id_book;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Book_Photo{" +
                "url='" + url + '\'' +
                ", id_book=" + id_book +
                '}';
    }
}
