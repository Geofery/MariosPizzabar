import java.util.ArrayList;

public class Economy {
  private double total;
  private double VAT = 0.8;
  private double marginCalculator = 0.25;

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
  public double totalRevenue(OrderList orderList) {
    return 0;
  }

  public double margin() {
    total = (total * VAT) * marginCalculator;
    return total;
  }
}
