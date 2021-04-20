public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;

    UI ui = new UI();

    public Menu(String menuHeader, String leadText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
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

        ui.getString(printMenu);
    }

    public int readChoice() {
        /*while (!scanner.hasNext) {
            ui.getString(getLeadText());
            scanner.next;
        }*/
        return ui.getScanInt();
    }
}
