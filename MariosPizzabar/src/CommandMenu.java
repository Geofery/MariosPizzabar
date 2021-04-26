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
    ManageOrders manageOrders = new ManageOrders();
    TUI tui = new TUI();
    Economy economy = new Economy();

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
          tui.showMenu(menu, ui);
          break;
        case 2:
          ui.printString("Orders");
          tui.showOrders(orderList, ui);
          break;
        case 3:
          ui.printString("New Order");
          manageOrders.addOrder(orderList, menu);
          break;
        case 4:
          ui.printString("Mark as finished");
          manageOrders.markFinished(orderList, ui, finishedOrders, tui);
          break;
        case 5:
          ui.printString("Statistics");
          break;
        case 6:
          ui.printString("Cancel Order");
          manageOrders.cancelOrder(orderList, ui, tui);
          break;
        case 9:
          ui.printString("Quitting...");
          ui.printString("Have a nice evening!");
          ui.printString("Your total of the day:");
          economy.getTotalOfDay(ui, finishedOrders);
          keepRunning = false;
          break;
        default:
          ui.printString("You chose poorly... Try again fool!");
          break;
      }
    } while (keepRunning);
  }
}

