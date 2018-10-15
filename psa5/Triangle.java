/* File Header:
 * This file extends from the abstract Shape class.
 * This file contains constructors and methods that get
 * attributes of a triangle, set attributes of a triangle, 
 * compares objects with triangles, converts triangles into 
 * strings, draws triangles, and moves triangles.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation
 * and manipulation of a line. Important instance variables
 * in this class are "p1","p2",and "p3" due to these variables 
 * providing the location of triangle's corners.
 */


// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

public class Triangle extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle() {
        // TODO
      this(new Point(0,0),new Point(0,0),new Point(0,0));
    }

    public Triangle(Point p1, Point p2, Point p3) {
        // TODO
      Point point1 = p1;
      Point copyP1 = new Point(point1);
      setPoint1(copyP1);
      Point point2 = p2;
      Point copyP2 = new Point(point2);
      setPoint2(copyP2);
      Point point3 = p3;
      Point copyP3 = new Point(point3);
      setPoint3(copyP3);
    }

    public Triangle(Triangle tri) {
        // TODO
      Point p1 = tri.getPoint1();
      Point copyP1 = new Point(p1);
      setPoint1(copyP1);
      Point p2 = tri.getPoint2();
      Point copyP2 = new Point(p2);
      setPoint2(copyP2);
      Point p3 = tri.getPoint3();
      Point copyP3 = new Point(p3);
      setPoint3(copyP3);
    }
    
    /** This method gets the first corner of the triangle
      * @param: N/A
      * @return: the location of this first corner
     * */
    public Point getPoint1() {
        // TODO
      return p1;
    }
    
    /** This method sets the first corner of the triangle
      * @param: N/A
      * @return: N/A
     * */
    private void setPoint1(Point p1) {
        // TODO
      this.p1=p1;
    }
    
    /** This method gets the second corner of the triangle
      * @param: N/A
      * @return: the location of this second corner
     * */
    public Point getPoint2() {
        // TODO
      return p2;
    }
    
    /** This method sets the second corner of the triangle
      * @param: N/A
      * @return: N/A
     * */
    private void setPoint2(Point p2) {
        // TODO
      this.p2=p2;
    }
    
    /** This method gets the third corner of the triangle
      * @param: N/A
      * @return: the location of this third corner
     * */
    public Point getPoint3() {
        // TODO
      return p3;
    }
    
    /** This method sets the third corner of the triangle
      * @param: N/A
      * @return: N/A
     * */
    private void setPoint3(Point p3) {
        // TODO
      this.p3=p3;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        // TODO
      getPoint1().move(deltaX,deltaY);
      getPoint2().move(deltaX,deltaY);
      getPoint3().move(deltaX,deltaY);
    }
    
    /** This method converts the triangle into a String
      * @param: N/A
      * @return: the triangle in the form of a string
     * */
    @Override
    public String toString() {
        // TODO
      return "Triangle: Point1: "+ getPoint1().toString() +
        ": Point2: " + getPoint2().toString() + ": Point3: " +
        getPoint3().toString() + " ";
    }
    
    /** This method compares an object with the triangle
      * @param: the object to be compared with
      * @return: true if the object and the triangle are the same;
      * false if not
     * */
    @Override
    public boolean equals(Object o) {
        // TODO
      if (o != null && o instanceof Triangle
            && ((Triangle)o).getPoint1().equals(this.getPoint1())
            && ((Triangle)o).getPoint2().equals(this.getPoint2())
            && ((Triangle)o).getPoint3().equals(this.getPoint3())){
        return true;
      } else {
        return false;
      }
    }
    
    /** This method draws the triangle and fills this triangle with
      * a random color
      * @param: the canvas to place the triangle on
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
    
    /** This method draws the triangle
      * @param: the canvas to place the triangle on,
      * the color of the triangle, and whether or not the triangle is filled
      * @return: N/A
     * */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
        // TODO
      if (c == null){
        c = Color.BLACK;
      }
      Line line1 = new Line(new Location
                              (getPoint1().getX(),getPoint1().getY()),
                            new Location
                              (getPoint2().getX(),getPoint2().getY()),
                            canvas);
      Line line2 = new Line(new Location
                              (getPoint2().getX(),getPoint2().getY()),
                            new Location
                              (getPoint3().getX(),getPoint3().getY()),
                            canvas);
      Line line3 = new Line(new Location
                              (getPoint3().getX(),getPoint3().getY()),
                            new Location
                              (getPoint1().getX(),getPoint1().getY()),
                            canvas);
      line1.setColor(c);
      line2.setColor(c);
      line3.setColor(c);
    }

}
