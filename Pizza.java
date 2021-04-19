import java.util.ArrayList;

public class Pizza {
  private String name;
  private int number;
  private ArrayList<String> toppings;
  private int price;

  public Pizza(String name, int number, ArrayList toppings, int price){
    this.name = name;
    this.number = number;
    this.toppings = toppings;
    this.price = price;
  }
}
