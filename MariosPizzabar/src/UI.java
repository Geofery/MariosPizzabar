import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UI {
  private Scanner scan = new Scanner(System.in);

  public int getScanInt(String errorMessage) {
    while (!scan.hasNextInt()) {
      printString(errorMessage);
      scan.next();
    }
    int readInt = scan.nextInt();
    scan.nextLine();
    return readInt;
  }

  public int getScanInt() {
    return this.getScanInt("Not a valid input");
  }

  public String getScanString() {
    return scan.nextLine();
  }

  public void sortOrdersByTime(OrderList orderList){
    orderList.getOrders().sort(Comparator.naturalOrder());
  }

  public void sortOrdersByOrderNr(OrderList orderList) {
    orderList.getOrders().sort(Comparator.comparingInt(Order::getOrderNr));
  }

  public void printTotal(int message) {
    System.out.println(message + "kr.");
  }

  public void printString(String message) {
    System.out.println(message);
  }
}
