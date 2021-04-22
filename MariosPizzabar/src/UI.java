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

  public void sortOrderlistByTime(OrderList orderList ){
    orderList.getOrders().sort(Comparator.naturalOrder());
  }

  public void unsortOrderlistByTime(OrderList orderList) {
    orderList.getOrders().sort(Comparator.reverseOrder());
    //Hvis reverseOrdrer ikke virker. så lav ny metode som sortere på ordrenr.
  }

  public int getScanInt() {
    return this.getScanInt("Not a valid input");
  }

  public void printString(String message) {
    System.out.println(message);
  }

  public void printTotal(int message) {
    System.out.println(message + "kr.");
  }

  public String getScanString() {
    return scan.nextLine();
  }


}
