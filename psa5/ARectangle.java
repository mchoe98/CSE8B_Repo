/* File Header:
 * This file creates an abstract class that extends from the abstract
 * Shape class. This file provides methods for getting and setting the 
 * upper left corner, moving the upper left corner, converting the object
 * into a String, and comparing between objects that must be overriden by
 * this class's sub classes. This file also contains some constructors.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to create a template for this class's
 * subclasses to follow and override. An important instance variable in
 * this class is "upperLeft" as this will be the starting point of the
 * sub classes' shapes.
 */

// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

public abstract class ARectangle extends Shape {
    private Point upperLeft;

    public ARectangle() {
        // TODO
      this("ARectangle",0,0);
    }

    public ARectangle(String name, int x, int y) {
        // TODO
      this(name,new Point(x,y));
    }

    public ARectangle(String name, Point upperLeft) {
        // TODO
      super(name);
      setUpperLeft(upperLeft);
    }

    public ARectangle(ARectangle r) {
        // TODO
      this(r.getName(),r.getUpperLeft());
    }
    /** This method gets the upper left corner of the ARectangle
      * @param: N/A
      * @return: the upper left corner point of the ARectangle 
     * */
    public Point getUpperLeft() {
        // TODO
      return upperLeft;
    }
    
    /** This method sets the upper left corner of the ARectangle
      * with a deep copy
      * @param: N/A
      * @return: N/A 
     * */
    private void setUpperLeft(Point point) {
        // TODO
      int x = point.getX();
      int y = point.getY();
      Point upperLeft = new Point(x,y);
      this.upperLeft = upperLeft;
    }

    /** This method moves the upper left corner of the ARectangle
      * @param: how much the point will move along the x-axis
      * and how much the point will move along the y-axis
      * @return: N/A 
     * */
    @Override
    public void move(int deltaX, int deltaY) {
        // TODO
      getUpperLeft().move(deltaX,deltaY);
    }

    /** This method converts ARectangle into a String
      * @param: N/A
      * @return: ARectangle in the form of a string
     * */
    @Override
    public String toString() {
        // TODO
      return getName() + ": Upper Left Corner: " + 
        getUpperLeft().toString() + " ";
    }
    
    /** This method compares an ARectangle object with an inputted object
      * @param: the object to be compared with
      * @return: true if the objects are the same; false if not
     * */
    @Override
    public boolean equals(Object o) {
        // TODO
      if (o != null && o instanceof ARectangle
         && ((ARectangle)o).getUpperLeft().equals(this.getUpperLeft())){
      return true;
      }
      return false;
    }
}
