public class Menu {
  private String menuHeader;
  private String leadText;
  private String[] menuItems;

  UI ui;

  public Menu(String menuHeader, String leadText, UI ui) {
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.ui = ui;

    String[] menuItems = {
        "1. Show menu",
        "2. Show orderlist",
        "3. Add order",
        "4. Remove order",
        "5. Order finished",
        "6. Show statistics",
        "9. Quit"
    };

    this.menuItems = menuItems;
  }

  public String getLeadText() {
    return leadText;
  }

  public void printMenu() {
    String printMenu = menuHeader + "\n";
    for (int i = 0; i < menuItems.length; i++) {
      printMenu += menuItems[i] + "\n";
    }
    printMenu += leadText;

    ui.printString(printMenu);
  }

  public int readChoice() {
    return ui.getScanInt();
  }
}
