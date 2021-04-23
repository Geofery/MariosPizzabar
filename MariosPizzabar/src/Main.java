public class Main {
    private UI ui;

    public Main(UI ui) {
        this.ui = ui;
    }

    public static void main(String[] args) {
        new Main(new UI()).run();
    }

    public void run() {
        OrderList orderList = new OrderList();
        PizzaMenu menu = new PizzaMenu();

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
                    addOrder(orderList, menu);
                    break;
                case 4:
                    ui.printString("Mark as finished");
                    markOrderReady(orderList);
                    break;
                case 5:
                    ui.printString("Statistics");
                    showStatistics();
                    break;
                case 6:
                    ui.printString("Cancel Order");
                    cancelOrder(orderList);
                    //Lav logik i metode
                case 9:
                    ui.printString("Quitting...");
                    ui.printString("Have a nice evening!");
                    ui.printString("Your total of the day:");
                    getTotalOfDay(orderList, menu);
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

    public void addOrder(OrderList orderList, PizzaMenu menu) {
        orderList.addOrder(menu);
    }

    public void markOrderReady(OrderList orderList) {
        boolean removal = true;
        do {
            showOrdersByOrderNr(orderList);
            if (orderList.getOrders().size() == 0) {
                run();
            } else
                ui.printString("Please enter order number for removal.");
            int orderToRemove = ui.getScanInt();

            if (orderToRemove > orderList.getOrders().size()) {
                ui.printString("There's no orderNr on that index");
            } else {
            }
            orderList.getOrders().remove(orderToRemove - 1);
            ui.printString("Order has successfully been removed");
            removal = false;
        }
        while (removal);
//Læg total ind i fil!
        //display ordre der bliver filtreret copi af orginal
        //Slet ordre, sletter fra orginal som ikke er filtreret.
    }

    public void cancelOrder(OrderList orderList) {
        //skal finde en måde at tilgå den midlertidige arralist der hedder orders som tilhører den enkelte ordre.
        //Laves færdig fratræk fra total
    }

    public void showStatistics() {

    }

    public void getTotalOfDay(OrderList orderList, PizzaMenu menu) {
        ui.printTotal(orderList.getTotal());
    }
}

