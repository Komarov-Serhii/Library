package model.dao.constant;

public final class Constants {
    private Constants() {}
    public static final String UPDATE_PERSON = "UPDATE PERSON SET NAME = ?, EMAIL = ?, PASSWORD = ?, STATUS = ? WHERE ID = ?";
    public static final String UPDATE_BOOK = "UPDATE BOOK SET NAME = ?, AUTHOR = ?, PUBLISHER = ?, PUBLISHER_DATE = ?, DESCRIPTION = ?, PRICE = ?, GENRE = ?, STATUS = ?, person_id = ?, order_status = ?, return_date = ?, debt = ? WHERE ID = ?";

    public static final String ALL_PERSON = "SELECT * FROM person";
    public static final String ALL_BOOK_FREE = "SELECT * FROM book WHERE status = 1";
    public static final String ALL_BOOK = "SELECT * FROM book";
    public static final String ALL_BOOK_BUSY = "SELECT * FROM book WHERE status = 2 and order_status = 2";
    public static final String ALL_BOOK_PERSON_ID = "SELECT * FROM book WHERE order_status = 2 and person_id = ?";
    public static final String ALL_ORDER_PERSON_ID = "SELECT * FROM book WHERE order_status = 1 and status = 2 and person_id = ?";
    public static final String ALL_BOOK_STATUS_2 = "SELECT * FROM book WHERE status = 2 and order_status = 1";

    public static final String SELECT_BY_ID_PERSON = "SELECT * FROM person WHERE id = ?";
    public static final String SELECT_BY_ID_BOOK = "SELECT * FROM book WHERE id = ?";
    public static final String SELECT_BY_LOGIN_AND_PASS = "SELECT * FROM person WHERE email = ? AND password = ?";
    public static final String SELECT_BY_LOGIN = "SELECT * FROM person WHERE email = ?";

    public static final String INSERT_PERSON = "INSERT INTO PERSON (name, email, password, level, status) VALUES (?,?,?,?,?)";
    public static final String INSERT_BOOK = "INSERT INTO BOOK (name, author, publisher, publisher_date, description, price, genre, status, person_id, order_status, return_date, debt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String DELETE_PERSON = "DELETE FROM PERSON WHERE ID = ?";
    public static final String DELETE_BOOK = "DELETE FROM book WHERE ID = ?";
}
