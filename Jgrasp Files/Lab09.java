import java.util.Scanner;
import java.io.File;

public class Lab09 {
   public static void main(String[] args) {
      // Create a new Scanner object to obtain 
      // input from System.in
      // --> TODO
      Scanner userInput = new Scanner(System.in);
      // Ask user for a word to search for. Print 
      // out a prompt
      // --> TODO
      System.out.println("Please enter the word you a looking for:");
      // Use the Scanner object you created above to 
      // take a word of input from the user. 
      // --> TODO
      String word = userInput.next(); 
      // *** Don't modify this line
      // Create a new file object to represent the 
      // file we are reading from. 
      // *** Important: Make sure that the file 
      // movieReviews.txt is in the same directory as
      // your Java source.  
      File file = new File("movieReviews.txt");
      
      // Read from the file, and print out each line
      try {
         // Just like we've created a Scanner object
         // to read from System.in, we can create one
         // to read from any File object. 
         Scanner fInput = new Scanner(file);
       
         // Variables to keep track of word scores
         double wordScoreTotal = 0;
         int count = 0;
         double wordScore = 0.0;
         
         // Keep looping through the file, and 
         // process each line
         while (fInput.hasNextLine()) {
            // Get the next line
            String line = fInput.nextLine();
            
            // Print out the next line. 
            //System.out.println(line);
            // For your assignment, replace the 
            // line of code above with your code to count 
            // the number of occurrences of the word
            // that the user gave in the file.
            // You will use methods such as getNumericValue
            // in the Character class and the indexOf method 
            // in String.  
            // --> TODO 
            if(line.indexOf(word) != -1){
               count++;
               wordScore = Character.getNumericValue(line.charAt(0));
               wordScoreTotal = (wordScoreTotal + wordScore);
               //System.out.println(wordScoreTotal);
            }
         }
         
         // Print out the number of times the input word
         // appears in the file movieReviews.txt
         System.out.println("The word " + word +
                     " appears " + count + " times in the file");
                     
         // Calculate the average word score 
         // --> TODO
         double average = (wordScoreTotal/count);
         
         // Print out the average word score
         System.out.println("The average score is " + average);
      
      // DO NOT modify the next line   
      } catch(Exception e) { 
         e.printStackTrace();
      }
   
   }
}
