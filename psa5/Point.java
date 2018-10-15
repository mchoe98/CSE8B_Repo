// TODO: File header goes here.
/* File Header:
 * This file contains a class that is not an extension of the abstract
 * Shape class. This file contains constructors and methods
 * that get attributes of a point, set attributes of a point, 
 * compares objects with points, converts points into 
 * strings, and moves points.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation
 * and manipulation of a point. Important instance variables
 * in this class are "x" and "y" due to these variables 
 * providing the location of the point.
 */

/**
 * The Point class represents a single 2D location that our
 * shapes will use.
 */
public class Point {
    
    // The x coordinate of this point. getX() and setX() are the only two
    // methods that should access this variable (not even constructors!).
    private int x;

    // The y coordinate of this point. getY() and setY() are the only two
    // methods that should access this variable (not even constructors!).
    private int y;

    /**
     * The no-arg constructor for the Point class. This initializes a new
     * point with an x and y of 0.
     * */
    public Point() {
        // TODO
      this(0,0);
    }

    /**
     * The general constructor fot the Point class. This initializes a new
     * Point at the specified x and y location.
     * 
     * @param x The x position of the new Point.
     * @param y The y position of the new Point.
     * */
    public Point(int x, int y) {
        // TODO
      setX(x);
      setY(y);
    }

    /**
     * Copy constructor for the Point class. This initializes a new Point at
     * the same x and y as another point.
     * 
     * @param point The Point whose x and y values to copy.
     * */
    public Point(Point point) {
        // TODO
      int x = point.getX();
      int y = point.getY();
      Point copy = new Point(x,y);
      setX(x);
      setY(y);
    }

    /**
     * Getter for the x coordinate of this Point.
     * 
     * @return The x position for this Point.
     * */
    public int getX() {
        // TODO
      return x;
    }

    /**
     * Setter for the x coordinate of this Point.
     * 
     * @param x The new x coordinate to move this Point to.
     * */
    private void setX(int x) {
        // TODO
      this.x = x;
    }

    /**
     * Getter for the y coordinate of this Point.
     * 
     * @return The y position for this Point.
     * */
    public int getY() {
        // TODO
      return y;
    }

    /**
     * Setter for the y coordinate of this Point.
     * 
     * @param y The new y coordinate to move this Point to.
     * */
    private void setY(int y) {
        // TODO
      this.y = y;
    }

    /**
     * Moves this Point by a certain x and y amount.
     * 
     * @param deltaX The amount to increase the x coordinate
     *               of this point.
     * @param deltaY The amount to increase the y coordinate
     *               of this point.
     * */
    public void move(int deltaX, int deltaY) {
        // TODO
      setX(getX()+deltaX);
      setY(getY()+deltaY);
    }

    /**
     * Generates the string representation of this Point so that it can be
     * displayed to the user.
     * 
     * @return A string in the form "Point: (x, y)"
     * */
    @Override
    public String toString() {
        // TODO
      return "Point: (" + getX() + ", " + getY() + ") ";
    }

    /**
     * Determines whether this Point is equivalent to another object.
     * 
     * @param o The object to compare this Point to.
     * @return True only if o is a non-null instance of the Point class
     *         with the same x and y coordinates as this point, false
     *         otherwise.
     * */
    @Override
    public boolean equals(Object o) {
        // TODO
      if (o != null && o instanceof Point &&
          ((Point)o).getX()==(this.getX()) &&
           ((Point)o).getY()==(this.getY())){
        return true;
      } else {
        return false;
      }
    }   
}
