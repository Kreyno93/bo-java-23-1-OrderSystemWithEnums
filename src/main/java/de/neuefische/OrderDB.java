package de.neuefische;


import java.util.HashMap;
import java.util.Map;

public class OrderDB {
    private Map<String, Order> orderMap = new HashMap<>();

    public OrderDB(Map<String, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public void addOrder(Order order) {
        orderMap.put(order.getId(), order);
    }

    public Map<String, Order> getOrderMap() {
        return orderMap;
    }

    public Order getOrderById(String id) {
        if (orderMap.containsKey(id)) {
            return orderMap.get(id);
        }
        throw new OrderNotFoundException("Order with id " + id + " not found");
    }

    public void updateOrderStatus(String id, OrderStatus status) {
        Order updatedOrder = orderMap.get(id);
        updatedOrder.setStatus(status);
        orderMap.put(id, updatedOrder);
    }

    public void outputOrderStatusAsString(Order orderToGetStatusFrom) {
        Order orderToFind = orderMap.get(orderToGetStatusFrom.getId());
        switch (orderToFind.getStatus()) {
            case OPEN, DELIVERED, IN_PROGRESS ->
                    System.out.println(orderToFind.getStatus().getDescription()); // ihr könnt auch mehrere Cases in eine Zeile schreiben =^-^=
            default -> System.out.println("Order status not found");
        }
    }

    public void outputOrderStatusAsStringVersion2(Order orderToGetStatusFrom) {
        Order orderToFind = orderMap.get(orderToGetStatusFrom.getId());
        switch (orderToFind.getStatus()) {
            case OPEN -> System.out.println("Die Bestellung: " + orderToFind.getId() + " ist offen");
            case IN_PROGRESS -> System.out.println("Die Bestellung: " + orderToFind.getId() + " wird bearbeitet");
            case DELIVERED -> System.out.println("Die Bestellung: " + orderToFind.getId() + " ist ausgeliefert");
            default -> System.out.println("Order status not found");
        }
    }
}
