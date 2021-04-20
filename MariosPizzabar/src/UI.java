import java.util.Scanner;

public class UI {
   private Scanner scan = new Scanner(System.in);

   public int getScanInt(){
       return scan.nextInt();
   }

   public void getString(String message){
       System.out.println(message);
   }

   public String getScanString(){
       return scan.nextLine();
   }
}
