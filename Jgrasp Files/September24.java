class September24{
   public static void main(String args[]){
      double aCount = 0;
      double bCount = 0; 
         for(double i = 0; i < 200; i++){
            boolean x9 = Math.random() > 0.5;
         if(x9) {
            aCount++;
         } else {
            bCount++;
         }
      }
      System.out.println(aCount + " " + bCount);
   }
}