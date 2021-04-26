public class TUI {

  public void showMenu(PizzaMenu menu, UI ui) {
    for (int i = 0; i < menu.getPizzaMenu().size(); i++) {
      ui.printString(menu.getPizzaMenu().get(i).toString());
    }
  }

  public void showOrders(OrderList orderList, UI ui) {
    if (orderList.getOrders().size() == 0) {
      ui.printString("\nThere are no orders!\n");
    }
    ui.sortOrdersByTime(orderList);

    for (int i = 0; i < orderList.getOrders().size(); i++) {
      ui.printString(orderList.getOrders().get(i).toString());
    }
  }

  public void showOrdersByOrderNr(OrderList orderList, UI ui) {
    if (orderList.getOrders().size() == 0) {
      ui.printString("\nThere are no orders!\n");
    }
    ui.sortOrdersByOrderNr(orderList);
    for (int i = 0; i < orderList.getOrders().size(); i++) {
      ui.printString(orderList.getOrders().get(i).toString());
    }
  }
}
