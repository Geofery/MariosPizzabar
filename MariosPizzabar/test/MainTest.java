import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void addOrder(){
    UIStub uiStub = new UIStub();
    //Main main = new Main(uiStub);
    uiStub.confirmGetScanInt(3);
    //Main.run();
    //derefter tjekkes metoder i orderList
    //altså addOrder og de indlejrede metoder deri. kan laves når hele "flowet" er lavet
  }

  @Test
  void markAsFinished() {

  }

  @Test
  void cancelOrder() {

  }

  @Test
  void getTotalOfDay() {

  }
}