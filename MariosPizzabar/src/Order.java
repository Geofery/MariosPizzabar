import java.util.ArrayList;


public class Order implements Comparable <Order> {
    private int orderNr;
    private String localDateTime;
    private ArrayList<Pizza> orderedPizzas;

  public Order(int orderNr, String localDateTime, ArrayList orderedPizzas){
      this.orderNr = orderNr;
      this.localDateTime = localDateTime;
      this.orderedPizzas = orderedPizzas;
  }

  public Order(int orderNr, String localDateTime){
    this.orderNr = orderNr;
    this.localDateTime = localDateTime;
  }

  public int getOrderNr() {
    return orderNr;
  }

  @Override
  public String toString() {
    return "\nOrder number: " + orderNr +
        "\nTimestamp: " + localDateTime +
        "\n\nPizzas:\n" + orderedPizzas.toString().replace("[", "")
        .replace("]", "").replace(",", "\n") + "\n";
  }

  @Override
  public int compareTo(Order o) {
    return this.localDateTime.compareTo(o.getLocalDateTime());
  }

  private String getLocalDateTime() {
    return localDateTime;
  }
}
