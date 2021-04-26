import java.util.ArrayList;

public class CommandMenu {
  private UI ui;
  private ArrayList<Order> finishedOrders = new ArrayList<>();

  public CommandMenu(UI ui) {
    this.ui = ui;
  }

  public void run() {
    OrderList orderList = new OrderList(ui);
    PizzaMenu menu = new PizzaMenu();
    Statistics stats = new Statistics();

    Menu digitalMenu = new Menu("Marios pizzabar", "Please choose: ", ui);
    boolean keepRunning;
    int choice;

    do {
      digitalMenu.printMenu();
      choice = ui.getScanInt();
      keepRunning = true;
      switch (choice) {
        case 1:
          ui.printString("Pizza Menu");
          showMenu(menu);
          break;
        case 2:
          ui.printString("Orders");
          showOrders(orderList);
          break;
        case 3:
          ui.printString("New Order");
          addOrder(orderList, menu, stats);
          break;
        case 4:
          ui.printString("Mark as finished");
          markAsFinished(orderList);
          break;
        case 5:
          ui.printString("Statistics");
          //showStatistics(orderList, stats);
          break;
        case 6:
          ui.printString("Cancel Order");
          cancelOrder(orderList);
          break;
        case 9:
          ui.printString("Quitting...");
          ui.printString("Have a nice evening!");
          ui.printString("Your total of the day:");
          getTotalOfDay();
          keepRunning = false;
          break;
        default:
          ui.printString("You chose poorly... Try again!");
          break;
      }
    } while (keepRunning);
  }

  public void showMenu(PizzaMenu menu) {
    for (int i = 0; i < menu.getPizzaMenu().size(); i++) {
      ui.printString(menu.getPizzaMenu().get(i).toString());
    }
  }

  public void showOrders(OrderList orderList) {
    if (orderList.getOrders().size() == 0) {
      ui.printString("\nThere are no orders!\n");
    }
    ui.sortOrdersByTime(orderList);

    for (int i = 0; i < orderList.getOrders().size(); i++) {
      ui.printString(orderList.getOrders().get(i).toString());
    }
  }

  public void showOrdersByOrderNr(OrderList orderList) {
    if (orderList.getOrders().size() == 0) {
      ui.printString("\nThere are no orders!\n");
    }
    ui.sortOrdersByOrderNr(orderList);
    for (int i = 0; i < orderList.getOrders().size(); i++) {
      ui.printString(orderList.getOrders().get(i).toString());
    }
  }

  public void addOrder(OrderList orderList, PizzaMenu menu, Statistics stats) {
    orderList.addOrder(menu);
    //showStatistics(orderList, stats);
  }

  public void markAsFinished(OrderList orderList) {
    int orderNr;
    Order order;
    showOrdersByOrderNr(orderList);

    do {
      ui.printString("Enter ordernumber");
      orderNr = ui.getScanInt("This is not a number.");
      order = null;
      for (int i = 0; i < orderList.getOrders().size(); i++) {
        if (orderList.getOrders().get(i).getOrderNr() == orderNr) {
          order = orderList.getOrders().get(i);
        }
      }
    } while (order == null);

    finishedOrders.add(order);
    orderList.getOrders().remove(order);

    ui.printString("Order has successfully been finished");
  }

  public void cancelOrder(OrderList orderList) {
    int orderNr;
    Order order;
    showOrdersByOrderNr(orderList);

    do {
      ui.printString("Enter ordernumber");
      orderNr = ui.getScanInt("This is not a number.");
      order = null;
      for (int i = 0; i < orderList.getOrders().size(); i++) {
        if (orderList.getOrders().get(i).getOrderNr() == orderNr) {
          order = orderList.getOrders().get(i);
        }
      }
    } while (order == null);

    orderList.getOrders().remove(order);

    ui.printString("Order is cancelled");
  }

  public void showStatistics() {
   
   }

  public void getTotalOfDay() {
    int total = 0;
    for (int i = 0; i < finishedOrders.size(); i++) {
      ArrayList<Pizza> finishedPizzas = finishedOrders.get(i).getOrderedPizzas();
      for (int j = 0; j < finishedPizzas.size(); j++) {
        total += finishedPizzas.get(j).getPrice();
      }
    }
    ui.printTotal(total);
  }
}

