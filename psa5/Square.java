/* File Header:
 * This file extends from the abstract ARectangle class.
 * This file contains constructors and methods that get
 * attributes of a square, set attributes of a square, 
 * compares objects with squares, converts squares into 
 * strings, draws squares, and moves squares.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation
 * and manipulation of a square. An important instance variable
 * in this class is "side" due to this variable 
 * providing the dimensions of the square.
 */


// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

public class Square extends ARectangle {

    private int side;

    public Square() {
        // TODO
      this(0,0,0);
    }

    public Square(int x, int y, int side) {
        // TODO
      this(new Point(x,y), side);
    }

    public Square(Point upperLeft, int side) {
        // TODO
      super("Square", upperLeft);
      setSide(side);
    }

    public Square(Square square) {
        // TODO
      this(square.getUpperLeft(),square.getSide());
    }
    
    /** This method sets the side of a square
      * @param: N/A
      * @return: N/A
     * */
    private void setSide(int side) {
        // TODO
      this.side = side;
    }
    
    /** This method gets the side of a square
      * @param: N/A
      * @return: the side of a square
     * */
    public int getSide() {
        // TODO
      return side;
    }
    
    /** This method converts the square into a String
      * @param: N/A
      * @return: the square in the form of a string
     * */
    @Override
    public String toString() {
        // TODO
      return super.toString() + " Sides: " + getSide() + " ";
    }
    
    /** This method compares an object with the square
      * @param: the object to be compared with
      * @return: true if the object and the square are the same;
      * false if not
     * */
    @Override
    public boolean equals(Object o) {
        // TODO
      if (super.equals(o) && o instanceof Square
            && ((Square)o).getSide() == this.getSide()){
        return true;
      } else{
        return false;
      }
    }
    
    /** This method draws the square and fills this square with
      * a random color
      * @param: the canvas to place the square on
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
    
    /** This method draws the square
      * @param: the canvas to place the square on,
      * the color of the square, and whether or not the square is filled
      * @return: N/A
     * */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
        // TODO
      if (c == null){
        c = Color.BLACK;
      }
      if (fill == true){
        FilledRect mySquare = 
          new FilledRect(new Location
                           (getUpperLeft().getX(),getUpperLeft().getY()),
                         getSide(),getSide(),canvas);
        mySquare.setColor(c);
      } else {
        FramedRect mySquare = 
          new FramedRect(new Location
                           (getUpperLeft().getX(),getUpperLeft().getY()),
                         getSide(),getSide(),canvas);
        mySquare.setColor(c);
      }
    }

}
