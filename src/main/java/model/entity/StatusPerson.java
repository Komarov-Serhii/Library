package model.entity;

public enum StatusPerson {

    UNBLOCKED(1),
    BLOCKED(2);

    private int status;

    StatusPerson(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
