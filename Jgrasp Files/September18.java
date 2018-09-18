import java.util.Scanner;
class September18 {
  public static void main(String args[]) {
    int sum = 0;
    //int n = 0; 
    int runs = 0;
    /*while (sum < 1000){
      runs++;
      System.out.println(runs);
      sum = sum + n;
      n = n + 2;
    }*/
    /*while (sum < 1000);{
      sum = sum +n;
      n = n + 2;
    }*/
    Scanner input = new Scanner (System.in);
    int n = input.nextInt();
    int count = 0;
    while (n != 1){
      if(n  % 2 != 0){
         n = 3 * n + 1;
      }else {
         n = n / 2;
      }
      System.out.print(n + " ");
      count = count + 1;
    }
  }
}