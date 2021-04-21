import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderListTest {

    @Test
    void addOrder() {

    }

    @Test
    void generateOrderNr() {
//Arrange
        ArrayList<Integer> OrderList = new ArrayList<Integer>();
        OrderList ordernr = new OrderList();
        int actual = OrderList.size()+1;
//Act
        int expected = 1;

// Assert
        assertEquals(expected, actual);

    }

    @Test
    void houseOrPhoneOrder() {
    }

    @Test
    void generateDateTime() {

        //Arrange
        LocalDateTime expected = LocalDateTime.now().plusHours(1);

        //Act
        LocalDateTime actual = LocalDateTime.now().plusHours(1);
        //Assert

        assertEquals(expected, actual);

    }

    @Test
    void addPizza() {
    }

    @Test
    void convertNrToPizza() {
    }

    @Test
    void getOrders() {
    }
}