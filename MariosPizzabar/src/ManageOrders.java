import java.util.ArrayList;

public class ManageOrders {

  public void addOrder(OrderList orderList, PizzaMenu menu) {
    orderList.addOrder(menu);
  }

  public void markAsFinished(OrderList orderList, UI ui, ArrayList<Order> finishedOrders, TUI tui) {
    int orderNr;
    Order order;
    tui.showOrdersByOrderNr(orderList, ui);

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

  public void cancelOrder(OrderList orderList, UI ui, TUI tui) {
    int orderNr;
    Order order;
    tui.showOrdersByOrderNr(orderList, ui);

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
}
