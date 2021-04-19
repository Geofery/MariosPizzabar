import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    int id;
    private Pizza pizza;
    private ArrayList<Integer> orderNr;
    private LocalDateTime localDateTime = LocalDateTime.now();

  public Order(int id, ArrayList orderNr, LocalDateTime localDateTime){
      this.id = id;
      this.orderNr = orderNr;
      this.localDateTime = localDateTime;
  }

  public void createOrder(Menu menu){

  }
}
