import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class OrderList {
  private ArrayList<Order> orderList = new ArrayList<>();
  private UI ui = new UI();
  private ArrayList<Integer> pizzaList = new ArrayList<>();

  public void addOrder() {
    int orderNr = generateOrderNr();
    String time = generateDateTime();
    ArrayList pizza = addPizza();


    Order order = new Order(orderNr, time, pizza);
    orderList.add(order);
  }

  public int generateOrderNr() {
    int orderNr = orderList.size() + 1;
    return orderNr;
  }


  public LocalDateTime houseOrPhoneOrder() {
    ui.getString("Is it a phone order or a house order? p/h");
    String answer = ui.getScanString().toLowerCase();

    if (answer.equals("p")) {
      LocalDateTime time = LocalDateTime.now().plusHours(1);
      return time;
    } else if (answer.equals("h")) {
      LocalDateTime time = LocalDateTime.now().plusMinutes(25);
      return time;
    } else {
      ui.getString("Wrong input, please enter p for phone or h for house");
    }
    return houseOrPhoneOrder();

  }

  public String generateDateTime() {
    LocalDateTime timeOfOrder = houseOrPhoneOrder();
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    String formatDateTime = timeOfOrder.format(time);
    return formatDateTime;
  }

  public ArrayList<Integer> addPizza() {
    ui.getString("Enter pizza number: ");
    int choice = ui.getScanInt();

    while (choice <= 31 && choice >= 1) {

      pizzaList.add(choice);
      ui.getString("Enter number 0, to exit: ");
      ui.getString("Enter pizza number: ");
      choice = ui.getScanInt();

      if (choice > 30) {
        ui.getString("Wrong input, please enter nummber from 1 to 30: ");
        addPizza();

      } else if (choice == 0) {
        System.out.println(pizzaList);
      }
    }
    return pizzaList;
  }

  @Override
  public String toString() {
    for (int i = 0; i < orderList.size(); i++) {
      orderList.get(i);
    }
    return "Orderlist: " + orderList;
  }
}
