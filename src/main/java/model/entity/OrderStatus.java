package model.entity;

public enum OrderStatus {

    NOTAPPROVED(1),
    APPROVED(2);

    private int orderStatus;

    OrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderStatus() {
        return orderStatus;
    }
}
