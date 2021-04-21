import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//
public class OrderList {
  private ArrayList<Order> orderList = new ArrayList<>();
  private UI ui = new UI();

  private ArrayList<Pizza> orderedPizzas = new ArrayList<>();

  public void addOrder(PizzaMenu menu) {
    int orderNr = generateOrderNr();
    String time = generateDateTime();
    ArrayList<Pizza> order= convertNrToPizza(menu);

    if (order == null) {
      ui.getString("Order is annulled");

    } else {
      orderedPizzas = order;
    }
    orderList.add(new Order(orderNr, time, orderedPizzas));
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

  public ArrayList<Integer> addPizza(PizzaMenu menu) {
    ArrayList<Integer> pizzaList = new ArrayList<>();
    boolean validChoice;
    int choice;

    do {
      ui.getString("Enter number 0, to exit: ");
      ui.getString("Enter pizzanumber :");
      choice = ui.getScanInt();
      validChoice = true;
      if (choice == 0) {
        validChoice = false;
      } else if (choice <= menu.getPizzaMenu().size() + 1 && choice >= 1) {
        pizzaList.add(choice);
      } else {
        ui.getString("Wrong input, please enter number from 1 to 30: ");
      }
    } while (validChoice);

    return pizzaList;
  }

  public ArrayList convertNrToPizza(PizzaMenu menu) {
    ArrayList<Integer> pizzaList = addPizza(menu);
    for (int i = 0; i < pizzaList.size(); i++) {
      int temp = pizzaList.get(i);
      orderedPizzas.add(menu.pizzaMenu.get(temp - 1));
    }
    return orderedPizzas;
  }

  public ArrayList<Order> getOrders() {
    return orderList;
  }

/*
  @Override
  //Til ære for dig Michala :):):)!
  public String toString() {
    return "Orders\n " + orderedPizzas.toString().replace("[", "")
        .replace("]", "").replace(",", "\n") + "\n";
  }

 */
}
