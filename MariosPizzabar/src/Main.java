public class Main {
  UI ui = new UI();

  public static void main(String[] args) {
    new Main().run();
  }

  public void run() {
    OrderList orderList = new OrderList();
    PizzaMenu menu = new PizzaMenu();

    Menu digitalMenu = new Menu("Marios pizzabar", "Please choose: ");
    boolean keepRunning;
    int choice;

    do {
      digitalMenu.printMenu();
      choice = digitalMenu.readChoice();
      keepRunning = true;
      switch (choice) {
        case 1:
          ui.getString("Pizza Menu");
          showMenu(menu);
          break;
        case 2:
          ui.getString("Orderlist");
          showOrderList(orderList);
          break;
        case 3:
          ui.getString("New Order");
          addOrder(orderList, menu);
          break;
        case 4:
          ui.getString("Remove Order");
          removeOrder(orderList);
          break;
        case 5:
          ui.getString("Finishing Order");
          finishOrder();
          break;
        case 6:
          ui.getString("Statistics");
          showStatistics();
          break;
        case 9:
          ui.getString("Quitting...");
          ui.getString("Have a nice evening!");
          ui.getString("Your total of the day:");
          getTotalOfDay();
          keepRunning = false;
          break;
        default:
          ui.getString("You chose poorly... Try again!");
          break;
      }
    } while (keepRunning);
  }

  public void showMenu(PizzaMenu menu) {
    for (int i = 0; i < menu.getPizzaMenu().size(); i++) {
      ui.getString(menu.getPizzaMenu().get(i).toString());
    }
  }

  public void showOrderList(OrderList orderList) {
    for (int i = 0; i < orderList.getOrders().size(); i++) {
      ui.getString(orderList.getOrders().get(i).toString());
    }
  }

  public void addOrder(OrderList orderList, PizzaMenu menu) {
    orderList.addOrder(menu);
  }

  public void removeOrder(OrderList orderList) {
    ui.getString("Please enter order number for removal.");
    int orderNr = ui.getScanInt();

    orderList.getOrders().remove(orderNr - 1);
  }

  public void finishOrder() {

  }

  public void showStatistics() {

  }

  public void getTotalOfDay() {

  }
}

