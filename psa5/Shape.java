/* File Header:
 * This file contains an abstract class.
 * This file contains constructors, methods that get
 * attributes of a shape and set attributes of a shape,
 * and method templates that compare objects with shape,
 * convert shapes into strings, draw shapes, and move shapes.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * Class Header:
 * The purpose of this class is to create a template for this class's
 * subclasses to follow and override. An important instance variable in
 * this class is "name" as this will provide the name of the shape.
 */
// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

public abstract class Shape {
    private String name;

    public Shape() {
        // TODO
      this("Shape");
    }

    public Shape(String name) {
        // TODO
      setName(name);
    }
    
    /** This method gets the name of the Shape
      * @param: N/A
      * @return: the name of the Shape
     * */
    public String getName() {
        // TODO
      return name;
    }
    
    /** This method sets the name of the Shape
      * @param: N/A
      * @return: N/A
     * */
    private void setName(String name) {
        // TODO
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        String s = "\n**********************************************************\n"
                + "This should never print. If it does print, then\n"
                + "you did not override equals() properly in class "
                + this.getClass().getName() + "\n"
                + "**********************************************************\n";

        System.out.println(s);

        return this == o;
    }

    public abstract void move(int xDelta, int yDelta);

    public abstract void draw(DrawingCanvas canvas);

    public abstract void draw(DrawingCanvas canvas, Color c, boolean fill);
}
