import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class OrderList {
  private ArrayList<Order> orderList = new ArrayList<>();
  private UI ui = new UI();
  private ArrayList<Integer> pizzaList = new ArrayList<>();
  private ArrayList<Pizza> orderedPizzas = new ArrayList<>();

  public void addOrder(PizzaMenu menu) {
    int orderNr = generateOrderNr();
    String time = generateDateTime();
    ArrayList pizzaList = addPizza();
    addPizzaToOrder(menu);
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

  //Denne metode tager pizzaList fra addPizza metoden (August og Jens).
  //Løber den igennem og finder hver indeks position i PizzaMenu og ligger dem i en Arrayliste ved navn Orderedpizzas.
  //Den bliver "kaldt" når metoden addOrder bliver kaldt.
  public ArrayList addPizzaToOrder(PizzaMenu menu) {
    for (int i = 0; i < pizzaList.size(); i++) {
      int temp = pizzaList.get(i);
      orderedPizzas.add(menu.mariosPizzaMenu.get(temp - 1));
    }
    return orderedPizzas;
}

  @Override
  //Til ære for dig Michala :):):)!
  public String toString() {
    return "Orders\n " + orderedPizzas.toString().replace("[", "")
        .replace("]", "").replace(",", "\n") + "\n";
  }
}
