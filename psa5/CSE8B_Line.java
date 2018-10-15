/* File Header:
 * This file extends from the abstract Shape class.
 * This file contains constructors and methods that get
 * attributes of a line, set attributes of a line, 
 * compares objects with lines, converts lines into 
 * strings, draws lines, and moves lines.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation
 * and manipulation of a line. Important instance variables
 * in this class are "start" and "end" due to these variables 
 * providing the start and end point of the line.
 */

// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

public class CSE8B_Line extends Shape {
    private Point start;
    private Point end;

    public CSE8B_Line() {
        // TODO
      this(new Point(0,0),new Point(0,0));
    }

    public CSE8B_Line(Point start, Point end) {
        // TODO
      // Deep copy for the starting point
      Point s = start;
      Point copyS = new Point(s);
      setStart(copyS);
      // Deep copy for the end point
      Point e = end;
      Point copyE = new Point(e);
      setEnd(copyE);
    }

    public CSE8B_Line(CSE8B_Line line) {
        //TODO
      // Deep copy for the starting point
      Point start = line.getStart();
      Point copyStart = new Point(start);
      setStart(copyStart);
      // Deep copy for the end point
      Point end = line.getEnd();
      Point copyEnd = new Point(end);
      setEnd(copyEnd);
    }
    
    /** This method gets the start point of the line
      * @param: N/A
      * @return: the start point of the line 
     * */
    public Point getStart() {
        // TODO
      return start;
    }
    
    /** This method sets the start point of the line
      * @param: N/A
      * @return: N/A
     * */
    private void setStart(Point start) {
        // TODO
      this.start = start;
    }
    
    /** This method gets the end point of the line
      * @param: N/A
      * @return: the end point of the line
     * */
    public Point getEnd() {
        // TODO
      return end;
    }
    
    /** This method sets the end point of the line
      * @param: N/A
      * @return: N/A
     * */
    private void setEnd(Point end) {
        // TODO
      this.end = end;
    }
    
    /** This method moves the line
      * @param: how much the line should move along the x-axis;
      * how much the line should move along the y-axis
      * @return: N/A
     * */
    @Override
    public void move(int deltaX, int deltaY) {
        // TODO
      getStart().move(deltaX,deltaY);
      getEnd().move(deltaX,deltaY);
    }
    
    /** This method converts the line into a string
      * @param: N/A
      * @return: the line in the form of a string
     * */
    @Override
    public String toString() {
        // TODO
      return "CSE8B_Line: Start: " + 
        getStart().toString() + ": End: " + getEnd().toString() + " ";
    }
    
    /** This method compares an object with the line
      * @param: the object to be compared with
      * @return: true if the object and the line are the same;
      * false if not
     * */
    @Override
    public boolean equals(Object o) {
        // TODO
      if (o != null && o instanceof CSE8B_Line
            && ((CSE8B_Line)o).getStart().equals(this.getStart())
            && ((CSE8B_Line)o).getEnd().equals(this.getEnd())){
        return true;
      } else {
        return false;
      }
    }
    
    /** This method draws the line and makes it a random color
      * @param: the canvas to place the line on
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
    
    /** This method draws the line
      * @param: the canvas to place the line on,
      * the color of the line, and whether or not the line is filled
      * @return: N/A
     * */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
        // TODO
      if (c == null){
        c = Color.BLACK;
      }
      Line myLine = new Line(new Location
                               (getStart().getX(),getStart().getY()),
                             new Location
                               (getEnd().getX(),getEnd().getY()),
                             canvas);
      myLine.setColor(c);
    }
}
