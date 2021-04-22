public class Pizza {
  private String name;
  private int number;
  private String toppings;
  private int price;
  private final String VALUTA = "kr.";

  public Pizza(String name, int number, String toppings, int price){
    this.name = name;
    this.number = number;
    this.toppings = toppings;
    this.price = price;
  }

  @Override
  public String toString() {
    return number + "." + name +
        "\n Toppings:\n " + toppings +
        "\n " + price + VALUTA +
        "\n";
  }
}