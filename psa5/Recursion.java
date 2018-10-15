/* File Header:
 * This file contains methods that make squares and make squares into a
 * recursive pattern. This file's class also extends from WindowController.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to make squares into a recursive pattern.
 */

/*
 * Test program for classes Point and Circle for Shapes inheritance
 * exercise - CSE 8B
 *
 * Program draws interlocking squares.
 */

import java.awt.*;
import objectdraw.*;

public class Recursion extends WindowController
{
  public void begin()
  {
    try
    {
      makeSquares();
    }
    catch ( Exception e )
    {
      String msg1 = "An Exception Occurred!";
      String msg2 = "Check the terminal window";
      String msg3 = "for details!";

      Text errorMsg1 = new Text( msg1, 25, 200, canvas );
      Text errorMsg2 = new Text( msg2, 25, 225, canvas );
      Text errorMsg3 = new Text( msg3, 25, 250, canvas );

      errorMsg1.setColor( Color.RED );
      errorMsg1.setFontSize( 32 );
      errorMsg1.setBold( true );

      errorMsg2.setColor( Color.RED );
      errorMsg2.setFontSize( 32 );
      errorMsg2.setBold( true );

      errorMsg3.setColor( Color.RED );
      errorMsg3.setFontSize( 32 );
      errorMsg3.setBold( true );

      e.printStackTrace();
    }
  }

  public void makeSquares()
  {
    Point point = new Point(150, 150);
    
    Square s1 = new Square();
    Square s2 = new Square(150, 150, 200);
    Square s3 = new Square(point, 200);
    Square s4 = new Square(s2);

    s4.move(100, 100);

    recursiveSquare(s3, 0.5, 6);

  }  // End of makeSquares()
    
    /** This creates a recursive square pattern
      * @param: the square to start with, how much each subsequent square
      * should decrease or increase, and how large the pattern should be
      * @return: N/A
     * */
  private void recursiveSquare(Square square, double proportion, int n) {

    // Don't forget the base case!
    if (n == 1){
      return;
    }
    // Make the squares and implement the recursion here:
    int newSide = (int)(square.getSide()*proportion);
    //Upper Left Corner Boxes
    Square square1 = new Square(square.getUpperLeft().getX()-newSide/2,
                        square.getUpperLeft().getY()-newSide/2,
                        newSide);
    square1.draw(canvas, Color.LIGHT_GRAY, true);
    square1.draw(canvas, Color.BLACK, false);
    recursiveSquare(square1,proportion,n-1);
    //Upper Right Corner Boxes
    Square square2 = new Square(square.getUpperLeft().getX()
                                  +square.getSide()-newSide/2,
                                square.getUpperLeft().getY()-newSide/2,
                                newSide);
    square2.draw(canvas, Color.LIGHT_GRAY, true);
    square2.draw(canvas, Color.BLACK, false);
    recursiveSquare(square2,proportion,n-1);
    //Lower Left Corner Boxes
    Square square3 = new Square(square.getUpperLeft().getX()-newSide/2,
                        square.getUpperLeft().getY()
                                  +square.getSide()-newSide/2,
                        newSide);
    square3.draw(canvas, Color.LIGHT_GRAY, true);
    square3.draw(canvas, Color.BLACK, false);
    recursiveSquare(square3,proportion,n-1);
    //Lower Right Corner Boxes
    Square square4 = new Square(square.getUpperLeft().getX()
                                  +square.getSide()-newSide/2,
                                square.getUpperLeft().getY()
                                  +square.getSide()-newSide/2,
                                newSide);
    square4.draw(canvas, Color.LIGHT_GRAY, true);
    square4.draw(canvas, Color.BLACK, false);
    recursiveSquare(square4,proportion,n-1);
    // This draws the square we received.
    square.draw(canvas, Color.LIGHT_GRAY, true);
    square.draw(canvas, Color.BLACK, false);
    
  }

} // End of class 
