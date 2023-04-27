package de.neuefische;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws OrderNotFoundException {

       Map<String,Order> orderMap = new HashMap<>(
       );

        OrderDB orderDB = new OrderDB(orderMap);
        Order orderToAdd = new Order("123","Pasta",OrderStatus.OPEN);
        orderDB.addOrder(orderToAdd);
        System.out.println("Before update: " + orderDB.getOrderMap());
        orderDB.updateOrderStatus("123",OrderStatus.DELIVERED);
        System.out.println("After update: " + orderDB.getOrderMap());

        System.out.println(orderDB.getOrderById("123").getStatus());

        orderDB.outputOrderStatusAsString(orderToAdd);



    }
}