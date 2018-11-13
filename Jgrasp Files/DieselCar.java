public class DieselCar extends Car{
   protected DieselCar(){}
   public DieselCar(String make, String model, String year){
      super(make, model, year);
   }
   public void refuel(){
      System.out.println("Just filled up with low-sulphur diesel");
   }
}