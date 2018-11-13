public class Car{
   protected String make;
   protected String model;
   protected String year;
   
   protected Car{ } 
   public Car(String make, String model, String year){
      this.make = make;
      this.model = model;
      this.year = year;
   }
   public String getMake() {
      return make;
   }
   public String getModel() {
      return model;
   }
   public String getYear(){
      return year;
   }
   public void refuel() {
      System.out.println("Done refueling");
   }
   public String toSTring() {
      return year + " " + make " " + model;
   }
}