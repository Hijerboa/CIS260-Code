public class Fool {
   private int x;
   private int y;
   
   private Fool(){
      x = 42;
   }
   public Fool(int v) {
      this();
      y = v + x;
   }
   public int getY() {
      return y; 
   }
}