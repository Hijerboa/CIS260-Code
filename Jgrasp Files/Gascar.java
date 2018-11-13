public class Gascar extends Car {
   protected GasCar();
   public GasCar(String make, String model, String year){
      super(make, model, year);
   }
   public void refuel() {
      System.out.println("Just filled up with 91 octane gas");
   }
}