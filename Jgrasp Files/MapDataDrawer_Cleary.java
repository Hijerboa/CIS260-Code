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
      // IMPLEMENT THE REST OF THIS METHOD
      for(int i=0;i<480;i++){
         for(int j=0;j<480;j++){
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
     
     // IMPLEMENT THE REST OF THIS METHOD
      for(int i=0;i<480;i++){
         for(int j=0;j<480;j++){
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
      int min = findMinValue();
      int max = findMaxValue();
      
      for (int i=0; i<480; i++) {
         for (int j=0; j<480; j++) {
            int c = 1;// calculated grayscale value FILL THIS IN
            g.setColor(new Color(c, c, c));
            g.fillRect(j, i, 1, 1);
         }
      }
   }
   public int indexOfMinRow(int col){
      int min = grid[col][0];
      for(int i=0; i<480; i++){
         if(grid[col][i] < min){
            min = grid[col][i];
         }
      }
      return min;
   }


   private int minOfThree(int a, int b, int c) {
      if ((a > b) && (a > c)) return a;
      if ((b > a) && (b > c)) return b;
      if ((c > a) && (c > b)) return c;
      return 0;
   }
}