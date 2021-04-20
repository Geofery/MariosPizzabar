public class Order {
    private int orderNr;
    private String localDateTime;
    private int pizza;


  public Order(int orderNr, String localDateTime, int pizza){
      this.pizza = pizza;
      this.orderNr = orderNr;
      this.localDateTime = localDateTime;
  }
}
