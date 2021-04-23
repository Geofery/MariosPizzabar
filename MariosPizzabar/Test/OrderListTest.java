import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderListTest {

  @Test
  void addOrder() {
    //Arrange
    int orderNr = 1;
    String time = "21-04-23 09:58";

    ArrayList<Pizza> pizzas = new ArrayList<>();
    Pizza pizza = new Pizza("Jens", 1, "ost", 100);
    pizzas.add(pizza);

    ArrayList<Order> orders = new ArrayList<>();
    orders.add(new Order(orderNr, time, pizzas));

    int expected = 1;

    //Act
    int actual = orders.size();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void generateOrderNr() {
    //Arrange
    ArrayList<Integer> OrderList = new ArrayList<Integer>();
    OrderList ordernr = new OrderList();
    int actual = OrderList.size() + 1;

    //Act
    int expected = 1;

    // Assert
    assertEquals(expected, actual);

  }

  @Test
  void houseOrPhoneOrderP() {
    //husk at ændre tid og dato når du tester til din ejen pc tid
    String expectedP = "21-04-23 11:38";

    LocalDateTime actualp = LocalDateTime.now().plusHours(1);
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");

    //Act
    String actual = actualp.format(time);

    //Assert
    assertEquals(expectedP, actual);
  }

  @Test
  void houseOrPhoneOrderH() {
    //Arrange
    //husk at ændre tid og dato når du tester til din ejen pc tid
    String expectedH = "21-04-23 11:06";

    LocalDateTime actualh = LocalDateTime.now().plusMinutes(25);
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");

    //Act
    String actual = actualh.format(time);

    //Assert
    assertEquals(expectedH, actual);
  }

  @Test
  void generateDateTime() {

    //Arrange husk at ændre tid og dato når du tester til din ejen pc tid
    String expected = "21-04-23 09:58";

    //Act
    LocalDateTime actual1 = LocalDateTime.now();
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    String actual = actual1.format(time);

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