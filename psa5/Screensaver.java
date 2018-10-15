/* File Header:
 * This file contains methods that draws random shapes onto the screen.
 * Between each shape is a random delay. Addtionally, this file's class
 * extends from ActiveObject.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to create a sort of screen saver by
 * drawing random shapes onto the screen.
 */

import java.awt.*;
import objectdraw.*;
import java.util.*;


public class Screensaver extends ActiveObject {
  private static final int DELAY = 300;
  private DrawingCanvas canvas;

  public Screensaver( DrawingCanvas canvas )
  {
    this.canvas = canvas; // Need this to tell objects where to draw.
        // Gotten from the GUI controller object.

    start();      // Start the animation.
  }
  public void run()
  {
    try
    {
      // number of loop
      int NUM = 10;
      // SEED for random
      int SEED = 2048;
      // Declar x, y, and size
      int x, y, x2, y2, x3, y3, size, size2;
      // Initialize height and width
      int height = canvas.getHeight();
      int width = canvas.getWidth();
      // Initialize greater and smaller
      int greaterOne = height > width ? height: width;
      int smallerOne = height < width ? height: width;
      Random random = new Random(SEED);
      // Declare arraylist of shapes
      ArrayList<Shape> list = new ArrayList<Shape>();
      // Adding shapes to arraylist
      for(int index=0;index<NUM;index++){
        // Add random Circle to ArrayList
        x = random.nextInt(width);
        y = random.nextInt(height);
        size = random.nextInt(greaterOne/8);
        list.add(new Circle(new Point(x,y),size));
        // Add random Square to ArrayList
        x = random.nextInt(width);
        y = random.nextInt(height);
        size = random.nextInt(greaterOne/8);
        list.add(new Square(new Point(x,y),size));
        // Add random Rectangle to ArrayList
        x = random.nextInt(width);
        y = random.nextInt(height);
        size = random.nextInt(greaterOne/8);
        size2 = random.nextInt(greaterOne/8);
        list.add(new Rectangle(new Point(x,y),size,size2));
        // Add random Triangle to ArrayList
        x = random.nextInt(width);
        y = random.nextInt(height);
        x2 = random.nextInt(width);
        y2 = random.nextInt(height);
        x3 = random.nextInt(width);
        y3 = random.nextInt(height);
        list.add(new Triangle(new Point(x,y),new Point(x2,y2),new Point(x3,y3)));
        // Add random Line to ArrayList
        x = random.nextInt(width);
        y = random.nextInt(height);
        x2 = random.nextInt(width);
        y2 = random.nextInt(height);
        list.add(new CSE8B_Line(new Point(x,y),new Point(x2,y2)));
      }
      // Call the method
      drawShape(list);
    }
    catch ( Exception e )
    {
    }
  }

    // TODO. Implement the drawShape method below
      
    /** This method draws each shape in the array list with
      * a delay between each drawing.
      * @param: the list of Shapes to use
      * @return: N/A
      * */
  public void drawShape( ArrayList<Shape> list){
    for (Shape index:list){
      index.draw(canvas);
      pause( DELAY );
    }
  }

}
