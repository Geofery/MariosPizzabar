import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;

public class Main {
    private UI ui;

    public Main(UI ui) {
        this.ui = ui;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Main(new UI()).run();
    }

    public void run() throws FileNotFoundException {
        OrderList orderList = new OrderList();
        PizzaMenu menu = new PizzaMenu();
        Statistics stats = new Statistics();

        Menu digitalMenu = new Menu("Marios pizzabar", "Please choose: ", ui);
        boolean keepRunning;
        int choice;

        do {
            digitalMenu.printMenu();
            choice = ui.getScanInt();
            keepRunning = true;
            switch (choice) {
                case 1:
                    ui.printString("Pizza Menu");
                    showMenu(menu);
                    break;
                case 2:
                    ui.printString("Orders");
                    showOrders(orderList);
                    break;
                case 3:
                    ui.printString("New Order");
                    addOrder(orderList, menu, stats);
                    break;
                case 4:
                    ui.printString("Mark as finished");
                    markOrderReady(orderList);
                    break;
                case 5:
                    ui.printString("Statistics");
                    showStatistics(orderList, stats);
                    break;
                case 6:
                    ui.printString("Cancel Order");
                    cancelOrder(orderList);
                    //Lav logik i metode
                case 9:
                    ui.printString("Quitting...");
                    ui.printString("Have a nice evening!");
                    ui.printString("Your total of the day:");
                    getTotalOfDay(stats);
                    keepRunning = false;
                    break;
                default:
                    ui.printString("You chose poorly... Try again!");
                    break;
            }
        } while (keepRunning);
    }

    public void showMenu(PizzaMenu menu) {
        for (int i = 0; i < menu.getPizzaMenu().size(); i++) {
            ui.printString(menu.getPizzaMenu().get(i).toString());
        }
    }

    public void showOrders(OrderList orderList) {
        if (orderList.getOrders().size() == 0) {
            ui.printString("\nThere are no orders!\n");
        }
        ui.sortOrdersByTime(orderList);

        for (int i = 0; i < orderList.getOrders().size(); i++) {
            ui.printString(orderList.getOrders().get(i).toString());
        }
    }

    public void showOrdersByOrderNr(OrderList orderList) {
        if (orderList.getOrders().size() == 0) {
            ui.printString("\nThere are no orders!\n");
        }
        ui.sortOrdersByOrderNr(orderList);
        for (int i = 0; i < orderList.getOrders().size(); i++) {
            ui.printString(orderList.getOrders().get(i).toString());
        }
    }

    public void addOrder(OrderList orderList, PizzaMenu menu, Statistics stats)  {
        orderList.addOrder(menu);
        showStatistics(orderList, stats);
        System.out.println("hej");
    }

    public void markOrderReady(OrderList orderList) throws FileNotFoundException {
        boolean removal;
        do {
            showOrdersByOrderNr(orderList);
            if (orderList.getOrders().size() == 0) {
                run();
            } else
                ui.printString("Please enter order number for removal.");
            int orderToRemove = ui.getScanInt();

     /* for (int i = 0; i < orderList.getOrders().size(); i++) {
        if (orderToRemove > orderList.getOrders().get(i).getOrderNr()) {
          ui.printString("There's no such order number");
        }
      }*/
            for (int i = 0; i < orderList.getOrders().size(); i++) {
                if (orderToRemove == orderList.getOrders().get(i).getOrderNr()) {
                    orderList.getOrders().remove(i);
                }
            }
            ui.printString("Order has successfully been removed");
            removal = false;
        }
        while (removal);
//Læg total ind i fil!
        //display ordre der bliver filtreret copi af orginal
        //Slet ordre, sletter fra orginal som ikke er filtreret.
    }

    public void cancelOrder(OrderList orderList) throws FileNotFoundException {
        //skal finde en måde at tilgå den midlertidige arralist der hedder orders som tilhører den enkelte ordre.
        //Laves færdig fratræk fra total
        boolean removal;
        do {
            showOrdersByOrderNr(orderList);
            if (orderList.getOrders().size() == 0) {
                run();
            } else
                ui.printString("Please enter order you want to cancel.");
            int orderToRemove = ui.getScanInt();

     /* for (int i = 0; i < orderList.getOrders().size(); i++) {
        if (orderToRemove > orderList.getOrders().get(i).getOrderNr()) {
          ui.printString("There's no such order number");
        }
      }*/
            for (int i = 0; i < orderList.getOrders().size(); i++) {
                if (orderToRemove == orderList.getOrders().get(i).getOrderNr()) {
                    orderList.getOrders().remove(i);
                }
            }
            ui.printString("Order has successfully been removed");
            removal = false;
            //Her skal der laves en -total som fjerner den enkelte ordres total fra overall Total.
        }
        while (removal);
    }

   /* public void showStatistics(OrderList orderList, Statistics stats) {
        // PrintStream fileOut = new PrintStream("Stats.txt");

        for (int i = 0; i < orderList.getOrders().size(); i++) {
            for (int j = 0; j < orderList.getOrders().size(); j++) {
                Statistics pizzaTracker = new Statistics("Pizza nr: " + i++, orderList.getOrders().get(i).getOrderedPizzas().get(j).getNumber());
                for (int k = 0; k < orderList.getOrders().get(i).getOrderedPizzas().size(); k++) {
                    stats.getPizzaPointBoard()[k] = pizzaTracker;
                }
            }
        }

    }
*/
    public void getTotalOfDay(Statistics stats) {

    }
}

