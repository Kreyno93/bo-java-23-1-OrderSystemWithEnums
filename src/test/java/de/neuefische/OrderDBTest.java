package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderDBTest {

    Order order1 = new Order("1","Pizza",OrderStatus.OPEN);
    Map<String,Order> testOrderMap = new HashMap<>(
            Map.of(
                    order1.getId(),order1
            )
    );

    OrderDB testOrderDB = new OrderDB(testOrderMap);

    @Test
    void whenGetOrderById_withNotValidId_thenThrowOrderNotFoundException(){

        try{
            testOrderDB.getOrderById("2");
            fail();
        } catch (OrderNotFoundException e){
            assertEquals("Order with id 2 not found",e.getMessage());
        }
    }

    @Test
    void whenGetOrderById_ReturnOrder(){
        Order expected = order1;
        Order actual = testOrderDB.getOrderById("1");
        assertEquals(expected,actual);
    }

    @Test
    void whenUpdateOrder_checkNewStatus(){
        Order expected = order1;
        testOrderDB.updateOrderStatus("1",OrderStatus.DELIVERED);
        Order actual = testOrderDB.getOrderById("1");
        assertEquals(expected,actual);
    }
}