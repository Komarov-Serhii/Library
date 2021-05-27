package model;

public enum Status {

    UNBLOCKED(1),
    BLOCKED(2);

    private int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
