import java.util.ArrayList;

public class Order {
    private int orderNr;
    private String localDateTime;
    private ArrayList pizza;


  public Order(int orderNr, String localDateTime, ArrayList pizza){
      this.pizza = pizza;
      this.orderNr = orderNr;
      this.localDateTime = localDateTime;
  }
}
