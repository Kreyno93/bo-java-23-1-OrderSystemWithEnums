package de.neuefische;


public class Order {
    private String id;
    private String product;
    private OrderStatus status;

    public Order(String id, String product, OrderStatus status) {
        this.id = id;
        this.product = product;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
