package com.komarov_s_s.final_project.library.exception;

public class DataBaseException extends Exception {

    public DataBaseException() {
    }

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(Exception e) {
        super(e);
    }

    public DataBaseException(String message, Exception e) {
        super(message, e);
    }
}
