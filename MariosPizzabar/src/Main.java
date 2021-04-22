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
            choice = digitalMenu.readChoice();
            keepRunning = true;
            switch (choice) {
                case 1:
                    ui.printString("Pizza Menu");
                    showMenu(menu);
                    break;
                case 2:
                    ui.printString("Orderlist");
                    showOrderList(orderList);
                    break;
                case 3:
                    ui.printString("New Order");
                    addOrder(orderList, menu);
                    break;
                case 4:
                    ui.printString("Remove Order");
                    removeOrder(orderList);
                    break;
                case 5:
                    ui.printString("Statistics");
                    showStatistics();
                    break;
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

    public void showOrderList(OrderList orderList) {
        if (orderList.getOrders().size() == 0) {
            ui.printString("\nThere are no orders!\n");
        }
        ui.sortOrderlistByTime(orderList);
        for (int i = 0; i < orderList.getOrders().size(); i++) {
            ui.printString(orderList.getOrders().get(i).toString());
        }
    }

    public void addOrder(OrderList orderList, PizzaMenu menu) {
        orderList.addOrder(menu);
    }

    public void removeOrder(OrderList orderList) {
        boolean removal = true;
        do {
            showOrderList(orderList);
            if (orderList.getOrders().size() == 0) {
                run();
            } else
            ui.printString("Please enter order number for removal.");
            int orderToRemove = ui.getScanInt();

                if (orderToRemove > orderList.getOrders().size()) {

                    ui.printString("There's no orderNr on that index");

                } else {

                    orderList.getOrders().remove(orderToRemove - 1);
                    ui.printString("Order has successfully been removed");
                    removal = false;
                }

        }
        while (removal);

    }


    public void showStatistics() {

    }

    public void getTotalOfDay(OrderList orderList, PizzaMenu menu) {
        ui.printTotal(orderList.getTotal());
    }
}

