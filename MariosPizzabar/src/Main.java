import java.util.ArrayList;

public class Main {
    UI ui = new UI();

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        String[] menuItems = {
                "1. Show menu",
                "2. Show orderlist",
                "3. Add order",
                "4. Remove order",
                "5. Order finished",
                "6. Show statistics",
                "9. Quit"
        };

        Menu digitalMenu = new Menu("Marios pizzabar", "Please choose: ", menuItems);
        boolean keepRunning;
        int choice;

        do {
            digitalMenu.printMenu();
            choice = digitalMenu.readChoice();
            keepRunning = true;
            switch (choice) {
                case 1:
                    ui.getString("Pizza Menu");
                    showMenu();
                    break;
                case 2:
                    ui.getString("Orderlist");
                    showOrderlist();
                    break;
                case 3:
                    ui.getString("New Order");
                    addOrder();
                    break;
                case 4:
                    ui.getString("Remove Order");
                    removeOrder();
                    break;
                case 5:
                    ui.getString("Finishing Order");
                    finishOrder();
                    break;
                case 6:
                    ui.getString("Statistics");
                    showStatistics();
                    break;
                case 9:
                    ui.getString("Quitting...");
                    ui.getString("Have a nice evening!");
                    ui.getString("Your total of the day:");
                    getTotal();
                    keepRunning = false;
                    break;
                default:
                    ui.getString("You chose poorly... Try again!");
                    break;
            }
        } while (keepRunning);
    }

    public void showMenu() {
        PizzaMenu menu = new PizzaMenu();
        menu.createPizzas();
        for (int i = 0; i < menu.getMariosPizzaMenu().size(); i++) {
            ui.getString(menu.getMariosPizzaMenu().get(i).toString());
        }
    }

    public void showOrderlist() {

    }

    public void addOrder() {
        OrderList orderlist = new OrderList();
        orderlist.addOrder();
        //Ved godt den ikke skal printes her. Det var for at teste.
        //Printstatement nedenunder skal op i "ShowOrderList" ovenover :) 
        ui.getString(orderlist.toString());
    }

    public void removeOrder() {

    }

    public void finishOrder() {

    }

    public void showStatistics() {

    }

    public void getTotal() {
    }
}

