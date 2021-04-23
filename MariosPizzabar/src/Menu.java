public class Menu {
  private String menuHeader;
  private String leadText;
  private String[] menuItems;

  private UI ui;

  public Menu(String menuHeader, String leadText, UI ui) {
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.ui = ui;

    String[] menuItems = {
        "1. Show menu",
        "2. Show orderlist",
        "3. Add order",
        "4. Mark as finished",
        "6. Show statistics",
        "9. Quit"
    };

    this.menuItems = menuItems;
  }

  public void printMenu() {
    String printMenu = menuHeader + "\n";
    for (int i = 0; i < menuItems.length; i++) {
      printMenu += menuItems[i] + "\n";
    }
    printMenu += leadText;

    ui.printString(printMenu);
  }
}
