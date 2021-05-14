package com.komarov_s_s.final_project.library.dao.dbManager;

public final class Constants {
    private Constants() {}
    public static final String UPDATE_PERSON = "UPDATE PERSON SET NAME = ?, EMAIL = ?, WHERE ID = ?";
    public static final String UPDATE_BOOK = "UPDATE BOOK SET NAME = ?, AUTHOR = ?, PUBLISHER = ?, PUBLISHER_DATE = ?, DESCRIPTION = ?, PRICE = ? WHERE ID = ?";
    public static final String ALL_PERSON = "SELECT * FROM PERSON";
    public static final String ALL_BOOK = "SELECT * FROM BOOK";
    public static final String INSERT_PERSON = "INSERT INTO PERSON VALUES (?,?,?)";
    public static final String INSERT_BOOK = "INSERT INTO BOOK VALUES (?,?,?,?,?,?,?)";
    public static final String SELECT_MAX_ID_BOOK = "SELECT MAX(ID) FROM BOOK";
    public static final String SELECT_MAX_ID_PERSON = "SELECT MAX(ID) FROM PERSON";
    public static final String DELETE_PERSON = "DELETE FROM PERSON WHERE ID = ?";
    public static final String DELETE_BOOK = "DELETE FROM BOOK WHERE ID = ?";
}
