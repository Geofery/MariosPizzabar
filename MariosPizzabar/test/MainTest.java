import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class MainTest {
  PizzaMenu menu = new PizzaMenu();
  OrderList orderList = new OrderList();

  @Test
  void addOrder() throws FileNotFoundException {
    UIStub uiStub = new UIStub();
    Main main = new Main(uiStub);
    uiStub.confirmGetScanInt(3);
    main.run();
    //derefter tjekkes metoder i orderList
    //altså addOrder og de indlejrede metoder deri. kan laves når hele "flowet" er lavet
  }
}