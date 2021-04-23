public class UIStub extends UI {
  private int nextValue;
  private String nextValueS;


  public int getScanInt() {
    return nextValue;
  }

  public String getScanString() {
    return nextValueS;
  }

  public void confirmGetScanInt(int nextValue) {
    this.nextValue = nextValue;
  }

  public void confirmGetScanString(String nextValue) {
    this.nextValueS = nextValue;

  }
}
