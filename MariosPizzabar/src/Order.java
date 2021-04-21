import java.util.ArrayList;

public class Order {
    private int orderNr;
    private String localDateTime;
    private ArrayList<Pizza> orderedPizzas;

  public Order(int orderNr, String localDateTime, ArrayList orderedPizzas){
      this.orderNr = orderNr;
      this.localDateTime = localDateTime;
      this.orderedPizzas = orderedPizzas;
  }

  @Override
  public String toString() {
    return "\nOrder number: " +orderNr +
        "\nTimestamp: " + localDateTime +
        "\n\nPizzas: \n" + orderedPizzas.toString().replace("[", "")
        .replace("]", "").replace(",", "\n") + "\n";
  }
}
