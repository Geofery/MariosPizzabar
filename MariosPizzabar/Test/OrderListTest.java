import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderListTest {
  UIStub uiStub;
  OrderList orderList;


  @BeforeEach
  void before() {
    uiStub = new UIStub();
    orderList = new OrderList(uiStub);
  }

  @Test
  void addOrder() {
    //Arrange
    PizzaMenu menu = new PizzaMenu();
    uiStub.confirmGetScanString("p");
    uiStub.confirmGetScanInt(30);
    uiStub.confirmGetScanInt(1);
    uiStub.confirmGetScanInt(0);
    int expected = 1;

    //Act
    orderList.addOrder(menu);

    // Assert
    int actual = orderList.getOrders().size();
    assertEquals(expected, actual);
  }

  @Test
  void generateOrderNr() {
    //Arrange
    ArrayList<Integer> list = new ArrayList<Integer>();
    int expected = list.size() + 1;

    //Act
    int actual = orderList.generateOrderNr();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void houseOrPhoneOrderP() {
    // Arrange
    uiStub.confirmGetScanString("p");
    LocalDateTime expected = LocalDateTime.now().plusHours(1);

    // Act
    LocalDateTime actual = orderList.houseOrPhoneOrder();

    // Assert
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    assertEquals(expected.format(time), actual.format(time));
  }

  @Test
  void houseOrPhoneOrderH() {
    // Arrange
    UIStub uiStub= new UIStub();
    OrderList orderList = new OrderList(uiStub);
    uiStub.confirmGetScanString("h");
    LocalDateTime expected = LocalDateTime.now().plusMinutes(25);

    // Act
    LocalDateTime actual = orderList.houseOrPhoneOrder();

    // Assert
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    assertEquals(expected.format(time), actual.format(time));
  }

  @Test
  void generateDateTimePhone() {

    //Arrange husk at ændre tid og dato når du tester til din ejen pc tid
    LocalDateTime expected1 = LocalDateTime.now().plusHours(1);
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    String expected = expected1.format(time);
    uiStub.confirmGetScanString("p");

    //Act
    String actual = orderList.generateDateTime();
    //Assert

    assertEquals(expected, actual);

  }

  @Test
  void generateDateTimeHouse() {

    //Arrange husk at ændre tid og dato når du tester til din ejen pc tid
    LocalDateTime expected1 = LocalDateTime.now().plusMinutes(25);
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    String expected = expected1.format(time);
    uiStub.confirmGetScanString("h");

    //Act
    String actual = orderList.generateDateTime();
    //Assert

    assertEquals(expected, actual);

  }

  @Test
  void addPizza() {
    
  }

  @Test
  void convertNrToPizza() {
  }
}