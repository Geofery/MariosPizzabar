import java.util.ArrayList;
public class UIStub extends UI {
  private ArrayList<String> anwsers = new ArrayList<>();
  private ArrayList<Integer> numbers = new ArrayList<>();


  public int getScanInt() {
    return this.numbers.remove(0);
  }

  public String getScanString() {
    return this.anwsers.remove(0);
  }

  public void confirmGetScanInt(int nextValue) {
    this.numbers.add(nextValue);
  }

  public void confirmGetScanString(String nextValue) {
    this.anwsers.add(nextValue);

  }
}
