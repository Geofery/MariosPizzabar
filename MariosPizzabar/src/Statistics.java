import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

public class Statistics {
    private double total;
    //private OrderList orderList = new OrderList();
    private double VAT = 0.8;
    private double marginCalculator = 0.25;
    private Statistics[] pizzaPointBoard = new Statistics[30];
    private int pizzaNr;
    private String name;

    public Statistics(String name, int pizzaNr) {
        this.name = name;
        this.pizzaNr = pizzaNr;

    }

    public Statistics (){
        
    }

    public double totalRevenue(OrderList orderList) {
        total = orderList.getTotal();
        return total;
    }

    public double margin() {
        total = (total * VAT) * marginCalculator;
        return total;
    }


    public void nrOfPizzaSold(OrderList orderList) throws FileNotFoundException {
        boolean yes;
        PrintStream fileOut = new PrintStream("Stats.txt");


        File pizzasSold = new File("/mostPopularPizzas");

    }

    public void popularityOfPizza() {

    }

    public void mostSoldPizza() {

    }

    public void leastSoldPizza() {

    }

    public void showRushHour() {

    }

    public Statistics[] getPizzaPointBoard() {
        return pizzaPointBoard;
    }

    public void setPizzaPointBoard(Statistics[] pizzaPointBoard) {
        this.pizzaPointBoard = pizzaPointBoard;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "pizzaPointBoard=" + Arrays.toString(pizzaPointBoard) +
                '}';
    }
}
