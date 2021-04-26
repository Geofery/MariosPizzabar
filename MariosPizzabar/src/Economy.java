import java.util.ArrayList;

public class Economy {
  public void getTotalOfDay(UI ui, ArrayList<Order> finishedOrders) {
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
