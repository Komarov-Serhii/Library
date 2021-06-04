package model;

import java.sql.Date;
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
    private Date returnDate;
    private int debt;

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

    public Book(String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status, int person_id, int orderStatus, Date returnDate) {

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
        this.returnDate = returnDate;
    }

    public Book(String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status, int person_id, int orderStatus, Date returnDate, int debt) {

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
        this.returnDate = returnDate;
        this.debt = debt;
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

    public Book(int id, String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status, int person_id, int orderStatus, Date returnDate) {
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
        this.returnDate = returnDate;
    }
    public Book(int id, String name, String author, String publisher, String publisher_date, String description, int price, String genre, int status, int person_id, int orderStatus, Date returnDate, int debt) {
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
        this.returnDate = returnDate;
        this.debt = debt;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }


    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (publisher_date != null ? publisher_date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + status;
        result = 31 * result + person_id;
        result = 31 * result + orderStatus;
        result = 31 * result + debt;
        return result;
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
                ", status=" + status +
                ", person_id=" + person_id +
                ", orderStatus=" + orderStatus +
                ", returnDate=" + returnDate +
                ", debt=" + debt +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        var book = (Book) obj;

        if (price != book.price) return false;
        if (status != book.status) return false;
        if (person_id != book.person_id) return false;
        if (orderStatus != book.orderStatus) return false;
        if (returnDate != book.returnDate) return false;
        if (debt != book.debt) return false;
        if (!Objects.equals(name, book.name)) return false;
        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(publisher, book.publisher)) return false;
        if (!Objects.equals(publisher_date, book.publisher_date)) return false;
        if (!Objects.equals(description, book.description)) return false;
        return Objects.equals(genre, book.genre);
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
