import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderList {
  private ArrayList<Order> listOfOrders = new ArrayList<>();
  private UI ui;
  private int nextOrderNr = 1;

  public OrderList(UI ui) {
    this.ui = ui;
  }

  public void addOrder(PizzaMenu menu) {
    int orderNr = generateOrderNr();
    String time = generateDateTime();
    ArrayList<Pizza> order = convertNrToPizza(menu);

    if (order.isEmpty()) {
      ui.printString("Order is annulled");
      return;
    }
    listOfOrders.add(new Order(orderNr, time, order));
  }

  public int generateOrderNr() {
    return nextOrderNr++;
  }

  public LocalDateTime houseOrPhoneOrder() {
    ui.printString("Is it a phone order or a house order?");
    ui.printString("Type \"p\" for phone order or \"h\" for house order");
    String answer = ui.getScanString().toLowerCase();

    if (answer.equals("p")) {
      LocalDateTime time = LocalDateTime.now().plusHours(1);
      return time;
    } else if (answer.equals("h")) {
      LocalDateTime time = LocalDateTime.now().plusMinutes(25);
      return time;
    } else {
      ui.printString("Wrong input! Please enter \"p\" for phone or \"h\" for house");
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
      ui.printString("Enter pizza number: ");
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

  public ArrayList<Order> getOrders() {
    return listOfOrders;
  }
}
