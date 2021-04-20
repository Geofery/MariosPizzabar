import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class OrderList {
    private ArrayList<Order> orderList = new ArrayList<>();
    private UI ui = new UI();

    public void addOrder() {
        int orderNr = generateOrderNr();
        String time = generateDateTime();
        int pizza = 0;



        Order order = new Order(orderNr, time, pizza);
        orderList.add(order);
    }

    public int generateOrderNr() {
        int orderNr = orderList.size() + 1;
        return orderNr;
    }


    public LocalDateTime houseOrPhoneOrder() {
        ui.getString("Is it a phone order or a house order? p/h");
        String answer = ui.getScanString().toLowerCase();

        if (answer.equals("p")) {
            LocalDateTime time = LocalDateTime.now().plusHours(1);
            return time;
        } else if (answer.equals("h")) {
            LocalDateTime time = LocalDateTime.now().plusMinutes(25);
            return time;
        } else {
            ui.getString("Wrong input, please enter p for phone or h for house");
        }
        return houseOrPhoneOrder();

    }

    public String generateDateTime() {
        LocalDateTime timeOfOrder = houseOrPhoneOrder();
        DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
        String formatDateTime = timeOfOrder.format(time);
        return formatDateTime;
    }

    public void addPizza(){
        
    }

    @Override
    public String toString() {
        for(int i=0; i<orderList.size();i++){
             orderList.get(i);
        }
        return "Orderlist: " + orderList;

    }
}
