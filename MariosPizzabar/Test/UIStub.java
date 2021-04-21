public class UIStub extends UI{
  private int nextValue;

 public int getScanInt() {
   return nextValue;
 }

 public void confirmGetScanInt(int nextValue) {
   this.nextValue = nextValue;
 }
}
