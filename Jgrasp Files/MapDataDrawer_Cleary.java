import java.util.*;
import java.io.*;
import java.awt.*;


public class MapDataDrawer_Cleary
{

  private int[][] grid;

  public MapDataDrawer_Cleary(String filename, int rows, int cols){
      // initialize grid 
      grid = new int[rows][cols];
      
      //read the data from the file into the grid
      File dataFile = new File(filename);
      try {
         Scanner dataInput = new Scanner(dataFile);
         for (int i=0; i<rows; i++) {
            for (int j=0; j<cols;j++) {
               grid[i][j] = dataInput.nextInt();
            
            }
         }
         
      } catch (Exception e) { e.printStackTrace();}

  }
  
  /**
   * @return the min value in the entire grid
   */
  public int findMinValue() {
     int min = Integer.MAX_VALUE;
      //Increment through each value in grid
      for(int i=0;i<480;i++){
         for(int j=0;j<480;j++){
         //If its less than the current value of min, set min equal to that number
            if(grid[i][j] < min){
               min = grid[i][j];
            }
         }
      }
     return min;  
  }
  /**
   * @return the max value in the entire grid
   */
  public int findMaxValue(){
     int max = Integer.MIN_VALUE;
     
     // Increment through each value in grid
      for(int i=0;i<480;i++){
         for(int j=0;j<480;j++){
         //If its greater than the current value of max, set max equal to that number
            if(grid[i][j] > max){
               max = grid[i][j];
            }
         }
      }
     return max;      
  }
  

  /**
   * Draws the grid using the given Graphics object.
   * Colors should be grayscale values 0-255, scaled based on min/max values in grid
   */
  public void drawMap(Graphics g){
      //Initialize min and max
      int min = findMinValue();
      int max = findMaxValue();
      //Increment through each value in grid
      for (int i=0; i<480; i++) {
         for (int j=0; j<480; j++) {
            //find a ratio of the difference between the min and max in relation to 256
            int difference = (max - min);
            int ratio = difference/256;
            ratio++;
            //subtract min from the value
            int anotherNum = grid[i][j]-min;
            //divide the value by the ratio to get a value for c
            int c = anotherNum/ratio;
            g.setColor(new Color(c, c, c));
            g.fillRect(j, i, 1, 1);
         }
      }
   }
   public int indexOfMinRow(int col){
      //initialize min with the first value in the given column
      int min = grid[0][col];
      //initialize index as the first column
      int indexOfMin = 0;
      //increment through each row in the gvien column 
      for(int i=0; i<480; i++){
         //if the value in that location is less than the current min...
         if(grid[i][col] < min){
            //set min equal to that value and then set the index equal to the current row
            min = grid[i][col];
            indexOfMin = i;
         }
      }
      return indexOfMin;
   }
    /**
      * Find a path from West-to-East starting at given row.
      * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
      * @return the total change in elevation traveled from West-to-East
      */
  public int drawLowestElevPath(Graphics g, int row){
    int elevChange = 0;
    int currentRow = row; 
    int currentElev = grid[row][0];
    int addedElev = 0;
    int pastElev = grid[indexOfMinRow(0)][0];
    //System.out.println(currentElev);
    for(int currentCol = 1; currentCol < 480; currentCol++){
      if(minOfThree(grid[(row+1)][currentCol],grid[row][currentCol],grid[(row-1)][currentCol])==1){
         addedElev = Math.abs(pastElev - grid[(row-1)][currentCol]);
         elevChange = elevChange + addedElev;
         pastElev = grid[(row-1)][currentCol];
         g.setColor(new Color(255, 0, 0));
         g.fillRect((row-1), currentCol, 1, 1);
         currentRow--;
      }else if(minOfThree(grid[(row+1)][currentCol],grid[row][currentCol],grid[(row-1)][currentCol])==2){
         addedElev = Math.abs(pastElev - grid[(row)][currentCol]);
         elevChange = elevChange + addedElev;
         pastElev = grid[(row)][currentCol];
         g.setColor(new Color(255, 0, 0));
         g.fillRect((row), currentCol, 1, 1);
      }else if(minOfThree(grid[(row+1)][currentCol],grid[row][currentCol],grid[(row-1)][currentCol])==3){
         addedElev = Math.abs(pastElev - grid[(row+1)][currentCol]);
         elevChange = elevChange + addedElev;
         pastElev = grid[(row+1)][currentCol];
         g.setColor(new Color(255, 0, 0));
         g.fillRect((row+1), currentCol, 1, 1);
         currentRow++;
      }else if(minOfThree(grid[(row+1)][currentCol],grid[row][currentCol],grid[(row-1)][currentCol])==0){
       System.out.println("you fucked up");  
      }
    }
      
      return elevChange;
  }
  
   private int minOfThree(int a, int b, int c) {
      if ((a < b) && (a < c)) return 1;
      if ((b < a) && (b < c)) return 2;
      if ((c < a) && (c < b)) return 3;
      Random rando = new Random();
      int randoNum = rando.nextInt(1);
      if(randoNum == 0){
         if(a == b) return 1;
         if(b == a) return 2;
         if(c == a) return 3;
      }else if(randoNum == 1){
         if(a == b) return 2;
         if(b == a) return 3;
         if(c == a) return 1;
      }
      return 0;
   }
}

