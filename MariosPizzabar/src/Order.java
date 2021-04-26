import java.util.ArrayList;

public class Order implements Comparable<Order> {
  private int orderNr;
  private String dateTime;
  private ArrayList<Pizza> orderedPizzas;

  public Order(int orderNr, String dateTime, ArrayList orderedPizzas) {
    this.orderNr = orderNr;
    this.dateTime = dateTime;
    this.orderedPizzas = orderedPizzas;
  }

  public ArrayList<Pizza> getOrderedPizzas() {
    return orderedPizzas;
  }

  public int getOrderNr() {
    return orderNr;
  }

  private String getLocalDateTime() {
    return dateTime;
  }

  @Override
  public int compareTo(Order o) {
    return this.dateTime.compareTo(o.getLocalDateTime());
  }

  @Override
  public String toString() {
    return "\nOrder number: " + orderNr +
        "\nTimestamp: " + dateTime +
        "\n\nPizzas:\n" + orderedPizzas.toString().replace("[", "")
        .replace("]", "").replace(",", "\n") + "\n";
  }
}
