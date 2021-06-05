package model.entity;

public enum StatusBook {
    FREE(1),
    BUSY(2);

    private int status;

    StatusBook(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
