package model.entity;

import model.builder.BookBuilder;

import java.sql.Date;
import java.util.Comparator;

import java.util.Objects;

public class Book extends Model {
    private String name;
    private String author;
    private String publisher;
    private String publisherDate;
    private String description;
    private int price;
    private String genre;
    private int status;
    private int person_id;
    private int orderStatus;
    private Date returnDate;
    private int debt;


    private Book(Book.BookBuilderImpl builder) {
        super(builder.id);
        this.name = builder.name;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.publisherDate = builder.publisherDate;
        this.description = builder.description;
        this.price = builder.price;
        this.genre = builder.genre;
        this.status = builder.status;
        this.person_id = builder.person_id;
        this.orderStatus = builder.orderStatus;
        this.returnDate = builder.returnDate;
        this.debt = builder.debt;
    }

    public static class BookBuilderImpl implements BookBuilder {

        private int id;
        private String name;
        private String author;
        private String publisher;
        private String publisherDate;
        private String description;
        private int price;
        private String genre;
        private int status;
        private int person_id;
        private int orderStatus;
        private Date returnDate;
        private int debt;


        @Override
        public BookBuilder setId(int id) {
            this.id = id;
            return this;
        }

        @Override
        public BookBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        @Override
        public BookBuilder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        @Override
        public BookBuilder setPublisherDate(String publisherDate) {
            this.publisherDate = publisherDate;
            return this;
        }

        @Override
        public BookBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public BookBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        @Override
        public BookBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        @Override
        public BookBuilder setStatus(int status) {
            this.status = status;
            return this;
        }

        @Override
        public BookBuilder setPersonId(int person_id) {
            this.person_id = person_id;
            return this;
        }

        @Override
        public BookBuilder setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        @Override
        public BookBuilder setReturnDate(Date returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        @Override
        public BookBuilder setDebt(int debt) {
            this.debt = debt;
            return this;
        }

        @Override
        public Book build() {
            return new Book(this);
        }
    }

    public Book() {

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

    public String getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(String publisherDate) {
        this.publisherDate = publisherDate;
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
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publisherDate='" + publisherDate + '\'' +
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var book = (Book) o;
        return price == book.price && status == book.status && person_id == book.person_id
                && orderStatus == book.orderStatus && debt == book.debt && Objects.equals(name, book.name)
                && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher)
                && Objects.equals(publisherDate, book.publisherDate) && Objects.equals(description, book.description)
                && Objects.equals(genre, book.genre) && Objects.equals(returnDate, book.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publisher, publisherDate, description, price, genre, status, person_id, orderStatus, returnDate, debt);
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
            return p1.getPublisherDate().compareTo(p2.getPublisherDate());
        }
    }
}
