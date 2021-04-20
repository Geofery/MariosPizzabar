import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
  private String name;
  private int number;
  private String toppings;
  private int price;

  public Pizza(String name, int number, String toppings, int price){
    this.name = name;
    this.number = number;
    this.toppings = toppings;
    this.price = price;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return number + "." +
        "\nName: " + name +
        "\nToppings: " + toppings +
        "\nPrice: " + price;
  }
}
