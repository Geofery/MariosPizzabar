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

  public void printString(String message) {
    System.out.println(message);
  }

  public String getScanString() {
    return scan.nextLine();
  }

  public void validateInt() {

  }
}
