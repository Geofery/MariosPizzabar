import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//
public class OrderList {
  private ArrayList<Order> orderList = new ArrayList<>();
  private UI ui = new UI();
  private int total = 0;

  public void addOrder(PizzaMenu menu) {
    int orderNr = generateOrderNr();
    String time = generateDateTime();
    ArrayList<Pizza> order = convertNrToPizza(menu);

    if (order.isEmpty()) {
      ui.printString("Order is annulled");
      return;
    }
    orderList.add(new Order(orderNr, time, order));
    subTotal(order);
  }

  public void subTotal(ArrayList<Pizza> order) {
    int total = 0;
    for (int i = 0; i < order.size(); i++) {
      total += order.get(i).getPrice();
    }
    this.total += total;
  }

  public int generateOrderNr() {
    int orderNr = orderList.size() + 1;
    return orderNr;
  }

  public LocalDateTime houseOrPhoneOrder() {
    ui.printString("Is it a phone order or a house order? p/h");
    String answer = ui.getScanString().toLowerCase();

    if (answer.equals("p")) {
      LocalDateTime time = LocalDateTime.now().plusHours(1);
      return time;
    } else if (answer.equals("h")) {
      LocalDateTime time = LocalDateTime.now().plusMinutes(25);
      return time;
    } else {
      ui.printString("Wrong input, please enter p for phone or h for house");
    }
    return houseOrPhoneOrder();
  }

  public String generateDateTime() {
    LocalDateTime timeOfOrder = houseOrPhoneOrder();
    DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    String formatDateTime = timeOfOrder.format(time);
    return formatDateTime;
  }

  public ArrayList<Integer> addPizzaNr(PizzaMenu menu) {
    ArrayList<Integer> pizzaList = new ArrayList<>();
    boolean validChoice;
    int choice;

    do {
      ui.printString("Enter number 0, to exit: ");
      ui.printString("Enter pizzanumber :");
      choice = ui.getScanInt();
      validChoice = true;
      if (choice == 0) {
        validChoice = false;
      } else if (choice <= menu.getPizzaMenu().size() && choice >= 1) {
        pizzaList.add(choice);
      } else {
        ui.printString("Wrong input, please enter number from 1 to 30: ");
      }
    } while (validChoice);

    return pizzaList;
  }

  public ArrayList convertNrToPizza(PizzaMenu menu) {
    ArrayList<Integer> pizzaList = addPizzaNr(menu);
    ArrayList<Pizza> ordered = new ArrayList<>();
    for (int i = 0; i < pizzaList.size(); i++) {
      int temp = pizzaList.get(i);
      ordered.add(menu.pizzaMenu.get(temp - 1));
    }
    return ordered;
  }

  //Skal laves færdig, kan kun ændres ved at ændre time fra en String.
  public ArrayList sortOrderByTime(ArrayList orderList) {
    orderList.sort(Comparator.naturalOrder());
    return orderList;
  }

  public ArrayList<Order> getOrders() {
    return orderList;
  }

  public int getTotal() {
    return total;
  }
}
