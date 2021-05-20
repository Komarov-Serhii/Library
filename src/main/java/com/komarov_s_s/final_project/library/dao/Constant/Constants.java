package com.komarov_s_s.final_project.library.dao.Constant;

public final class Constants {
    private Constants() {}
    public static final String UPDATE_PERSON = "UPDATE PERSON SET NAME = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?";
    public static final String UPDATE_BOOK = "UPDATE BOOK SET NAME = ?, AUTHOR = ?, PUBLISHER = ?, PUBLISHER_DATE = ?, DESCRIPTION = ?, PRICE = ?, GENRE = ? WHERE ID = ?";
    public static final String UPDATE_BOOK_PHOTO = "UPDATE BOOK_PHOTO SET  URL = ?, book_id = ? WHERE ID = ?";
    public static final String UPDATE_CART = "UPDATE CART SET  person_id = ?, book_id = ? WHERE ID = ?";

    public static final String ALL_PERSON = "SELECT * FROM person";
    public static final String ALL_BOOK = "SELECT * FROM book";
    public static final String ALL_BOOK_PHOTO = "SELECT * FROM BOOK_PHOTO";

    public static final String SELECT_BY_ID_PERSON = "SELECT * FROM person WHERE id = ?";
    public static final String SELECT_BY_ID_BOOK = "SELECT * FROM book WHERE id = ?";
    public static final String SELECT_BY_ID_BOOK_PHOTO = "SELECT * FROM book_photo WHERE id = ?";
    public static final String SELECT_BY_ID_CART = "SELECT * FROM cart WHERE id = ?";
    public static final String SELECT_BY_LOGIN = "SELECT * FROM user WHERE email = ? AND password = ?";

    public static final String INSERT_PERSON = "INSERT INTO PERSON (name, email, password, level) VALUES (?,?,?,?)";
    public static final String INSERT_BOOK = "INSERT INTO BOOK (name, author, publisher, publisher_date, description, price, genre) VALUES (?,?,?,?,?,?,?)";
    public static final String INSERT_BOOK_PHOTO = "INSERT INTO BOOK_PHOTO (url, book_id) VALUES (?,?)";
    public static final String INSERT_CART = "INSERT INTO CART (person_id, book_id) VALUES (?,?)";

    public static final String SELECT_MAX_ID_BOOK = "SELECT MAX(ID) FROM BOOK";
    public static final String SELECT_MAX_ID_PERSON = "SELECT MAX(ID) FROM PERSON";

    public static final String DELETE_PERSON = "DELETE FROM PERSON WHERE ID = ?";
    public static final String DELETE_BOOK = "DELETE FROM book WHERE ID = ?";
    public static final String DELETE_BOOK_PHOTO = "DELETE FROM BOOK_PHOTO WHERE ID = ?";
    public static final String DELETE_CART = "DELETE FROM cart WHERE ID = ?";
}
