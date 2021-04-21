public class Main {
  UI ui = new UI();
  //hej

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
          removeOrder(orderList, menu);
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
          getTotal();
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
    for (int i = 0; i < orderList.getOrderList().size(); i++) {
      ui.getString(orderList.getOrderList().get(i).toString());
    }
  }

  public void addOrder(OrderList orderList, PizzaMenu menu) {
    orderList.addOrder(menu);
    //Ved godt den ikke skal printes her. Det var for at teste.
    //Printstatement nedenunder skal op i "ShowOrderList" ovenover :)
    ui.getString(orderList.toString());
  }

  public void removeOrder(OrderList orderList, PizzaMenu menu) {

  }

  public void finishOrder() {

  }

  public void showStatistics() {

  }

  public void getTotal() {
  }
}

