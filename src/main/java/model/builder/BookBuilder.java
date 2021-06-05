package model.builder;

import model.entity.Book;

import java.sql.Date;

public interface BookBuilder {
    BookBuilder setId(int id);
    BookBuilder setName(String name);
    BookBuilder setAuthor(String author);
    BookBuilder setPublisher(String publisher);
    BookBuilder setPublisherDate(String publisherDate);
    BookBuilder setDescription(String description);
    BookBuilder setPrice(int price);
    BookBuilder setGenre(String genre);
    BookBuilder setStatus(int status);
    BookBuilder setPersonId(int person_id);
    BookBuilder setOrderStatus(int orderStatus);
    BookBuilder setReturnDate(Date returnDate);
    BookBuilder setDebt(int debt);
    Book build();
}
