import java.util.Scanner;
public class October16{
   /*public static int foo(int a, int b){
      return a+b;
   }
   public static int foo(double a, int b){
      return a*b;
   }
   public static void main(String args[]){
      foo(3,4);
   }*/
   public static void main(String args[]){
      Scanner input = new Scanner(System.in);
      int[] a = new int[10];
      int i = 0;
      int x;
      do{
         x = input.nextInt();
      } while (x != 0);
      System.out.println(a);
   }
}
