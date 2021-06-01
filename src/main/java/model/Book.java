package model;

import java.util.Comparator;
import java.util.Objects;

public class Book extends Model {
    private String name;
    private String author;
    private String publisher;
    private String publisher_date;
    private String description;
    private int price;
    private String genre;
    private int status;
    private int person_id;
    private int orderStatus;


    public Book() {

    }

    public Book(String name, String author, String publisher, String publisher_date, String description, int price, String genre) {

        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publisher_date = publisher_date;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }

    public Book(String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status) {

        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publisher_date = publisher_date;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.status = status;
    }

    public Book(String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status, int person_id , int orderStatus) {

        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publisher_date = publisher_date;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.status = status;
        this.person_id = person_id;
        this.orderStatus = orderStatus;
    }

    public Book(int id, String name, String author, String publisher, String publisher_date, String description, int price, String genre) {
        super(id);
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publisher_date = publisher_date;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }
    public Book(int id, String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status) {
        super(id);
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publisher_date = publisher_date;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.status = status;
    }

    public Book(int id, String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status, int person_id, int orderStatus) {
        super(id);
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publisher_date = publisher_date;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.status = status;
        this.person_id = person_id;
        this.orderStatus = orderStatus;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publisher_date='" + publisher_date + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(name, book.name);
    }

    public static class NameComparator implements Comparator<Book> {
        @Override
        public int compare(Book p1, Book p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    public static class AuthorComparator implements Comparator<Book> {
        @Override
        public int compare(Book p1, Book p2) {
            return p1.getAuthor().compareTo(p2.getAuthor());
        }
    }

    public static class PublisherComparator implements Comparator<Book> {
        @Override
        public int compare(Book p1, Book p2) {
            return p1.getPublisher().compareTo(p2.getPublisher());
        }
    }

    public static class PublisherDateComparator implements Comparator<Book> {
        @Override
        public int compare(Book p1, Book p2) {
            return p1.getPublisher_date().compareTo(p2.getPublisher_date());
        }
    }
}
