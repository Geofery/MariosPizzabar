public class Statistics {
    private int total;

    public int countTotal(OrderList orderList) {
        for (int i = 0; i < orderList.getOrders().size(); i++) {
            total = orderList.getTotal();
        }
        return total;
    }

    public int getTotalCash() {
        return total;
    }

    public void nrOfPizzaSold() {

    }
}
