/* File Header:
 * This file extends from the abstract ARectangle class.
 * This file contains constructors and methods that get
 * attributes of a rectangle, set attributes of a rectangle, 
 * compares objects with rectangle, converts rectangles into 
 * strings, draws rectangles, and moves rectangles.
 *  
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation
 * and manipulation of a rectangle. Important instance variables
 * in this class are "width" and "height" due to these variables 
 * providing the dimensions of the rectangle.
 */


// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

public class Rectangle extends ARectangle {
    private int width;
    private int height;

    public Rectangle() {
        // TODO
      this(0,0,0,0);
    }

    public Rectangle(int x, int y, int width, int height) {
        // TODO
      this(new Point(x,y),width,height);
    }

    public Rectangle(Point upperLeft, int width, int height) {
        // TODO
      super("Rectangle",upperLeft);
      setWidth(width);
      setHeight(height);
    }

    public Rectangle(Rectangle r) {
        // TODO
      this(r.getUpperLeft(),r.getWidth(),r.getHeight());
    }
    
    /** This method gets the height of the rectangle
      * @param: N/A
      * @return: the height of the rectangle
     * */
    public int getHeight(){
        // TODO
      return height;
    }
    
    /** This method sets the height of the rectangle
      * @param: N/A
      * @return: N/A
     * */
    private void setHeight(int height) {
        // TODO
      this.height = height;
    }
    
    /** This method gets the width of the rectangle
      * @param: N/A
      * @return: the width of the rectangle
     * */
    public int getWidth(){
        // TODO
      return width;
    }
    
    /** This method sets the width of the rectangle
      * @param: N/A
      * @return: N/A
     * */
    private void setWidth(int width) {
        // TODO
      this.width = width;
    }
    
    /** This method converts the rectangle into a String
      * @param: N/A
      * @return: the rectangle in the form of a string
     * */
    @Override
    public String toString() {
        // TODO
      return super.toString() + "Width: " + getWidth() +
        " Height: " + getHeight() + " ";
    }
    
    /** This method compares an object with the rectangle
      * @param: the object to be compared with
      * @return: true if the object and the rectangle are the same;
      * false if not
     * */
    @Override
    public boolean equals(Object o) {
        // TODO
      if (super.equals(o) && o instanceof Rectangle &&
          ((Rectangle)o).getWidth() == this.getWidth() &&
          ((Rectangle)o).getHeight() == this.getHeight()){
        return true;
      }else{
        return false;
      }
    }
    
    /** This method draws the rectangle and fills this rectangle with
      * a random color
      * @param: the canvas to place the rectangle on
      * @return: N/A
     * */
    public void draw(DrawingCanvas canvas) {
      // TODO
      Random generator = new Random();
      int random1 = generator.nextInt(256);
      int random2 = generator.nextInt(256);
      int random3 = generator.nextInt(256);
      Color color = new Color(random1,random2,random3);
      draw(canvas, color, true);
    }
    
    /** This method draws the rectangle
      * @param: the canvas to place the rectangle on,
      * the color of the rectangle, and whether or not the rectangle is filled
      * @return: N/A
     * */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
      // TODO
      if (c == null){
        c = Color.BLACK;
      }
      if (fill == true){
        FilledRect myRect = 
          new FilledRect(new Location
                           (getUpperLeft().getX(),getUpperLeft().getY()),
                         getWidth(),getHeight(),canvas);
        myRect.setColor(c);
      } else {
        FramedRect myRect = 
          new FramedRect(new Location
                           (getUpperLeft().getX(),getUpperLeft().getY()),
                         getWidth(),getHeight(),canvas);
        myRect.setColor(c);
      }
    }
}
