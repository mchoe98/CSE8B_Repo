/* File Header:
 * This file extends from the abstract Shape class.
 * This file contains constructors and methods that get
 * attributes of a circle, set attributes of a circle, 
 * compares objects with circles, converts circles into 
 * strings, draws circles, and moves circles.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation and
 * manipulation of circles. Important instance variables for this
 * class are "center" and "radius" as these are the attributes of 
 * this class's circles.
 */

// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

public class Circle extends Shape {
    private Point center;
    private int radius;

    public Circle() {
        // TODO
      this(new Point(0,0),0);
    }

    public Circle(Point center, int radius) {
        // TODO
      Point middle = center;
      Point copyMiddle = new Point(middle);
      setCenter(copyMiddle);
      setRadius(radius);
    }

    public Circle(Circle c) {
        // TODO
      Point center = c.getCenter();
      Point copyCenter = new Point(center);
      setCenter(copyCenter);
      setRadius(c.getRadius());
    }
    
    /** This method gets the center point of the circle
      * @param: N/A
      * @return: the center point of the circle 
     * */
    public Point getCenter() {
        // TODO
      return center;
    }
    
    /** This method sets the center point of the circle
      * @param: N/A
      * @return: N/A
     * */
    private void setCenter(Point point) {
        // TODO
      this.center = point;
    }
    
    /** This method gets the radius of the circle
      * @param: N/A
      * @return: the radius of the circle 
     * */
    public int getRadius(){
        // TODO
      return radius;
    }

    /** This method sets the radius of the circle
      * @param: N/A
      * @return: N/A
     * */
    private void setRadius(int radius) {
        // TODO
      this.radius = radius;
    }

    /** This method moves the center point of the circle
      * @param: how much the point will move along the x-axis
      * and how much the point will move along the y-axis
      * @return: N/A
     * */
    @Override
    public void move(int deltaX, int deltaY) {
        // TODO
      getCenter().move(deltaX,deltaY);
    }

    /** This method converts the circle into a String
      * @param: N/A
      * @return: the circle in the form of a string
     * */
    @Override
    public String toString() {
        // TODO
      return "Circle: Center: " + getCenter() +
        ": Radius: " + getRadius() + " ";
    }

    /** This method compares the circle to an object
      * @param: the object to compare the circle with
      * @return: true if the object and the circle are the same;
      * false if not
     * */
    @Override
    public boolean equals(Object o) {
        // TODO
      if (o!=null && o instanceof Circle &&
          ((Circle)o).getCenter().equals(this.getCenter())
            && ((Circle)o).getRadius() == this.getRadius()){
        return true;
      } else {
        return false;
      }
    }
    
    /** This method draws the circle and fills this circle with
      * a random color
      * @param: the canvas to place the circle on
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
    
    /** This method draws the circle
      * @param: the canvas to place the circle upon,
      * the color of the circle, and whether or not
      * the circle will be filled or not
      * @return: N/A
     * */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
        // TODO
      if (c == null){
        c = Color.BLACK;
      }
      if (fill == true){
        FilledOval myCircle =
          new FilledOval(new Location(getCenter().getX()-getRadius()
                                        ,getCenter().getY()-getRadius()),
                         getRadius()*2, getRadius()*2, canvas);
        myCircle.setColor(c);
      } else {
        FramedOval myCircle =
          new FramedOval(new Location(getCenter().getX()-getRadius()
                                        ,getCenter().getY()-getRadius()),
                         getRadius()*2, getRadius()*2, canvas);
        myCircle.setColor(c);
      }
    }

}
