import java.util.ArrayList;

public class Pizza {
  private String name;
  private int number;
  private ArrayList<String> toppings;

  public Pizza(String name, int number, ArrayList toppings){
    this.name = name;
    this.number = number;
    this.toppings = toppings;
  }
}
