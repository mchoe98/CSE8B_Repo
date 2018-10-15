/* File Header:
 * This file contains methods that allow for many turtles to draw an 
 * encrypted message. Each turtle draws a character of the encrypted 
 * message in a new world whenever the encryptMT method is used.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to create an encrypted message with
 * each of the message's characters being created by its own turtle to
 * speed up the process. Important variables for this class include WORLD_WIDTH and
 * WORLD_HEIGHT for creating the world, DELAY for selecting how fast 
 * the turtle can draw the message, CHAR_WIDTH, LINE_PADDING, and
 * CHAR_SPACE for drawing each character of the message, and charr, x, and
 * y for running the threads.
 * /

/* Starter Code by Hans Yuan WI 18 */

import turtleClasses.Turtle;
import turtleClasses.World;
import java.awt.*;
import java.util.*;


public class EncryptionTurtleMT extends DrawingTurtle implements Runnable {

   // DON'T CHANGE
   public final static int WORLD_WIDTH = 800;
   public final static int WORLD_HEIGHT = 120;

   // CHANGE BACK TO 75 WHEN DONE
   public final static int DELAY = 75;

   // These constants may be helpful:
   public final static int CHAR_WIDTH = 40;
   public final static int LINE_PADDING = 40;
   public final static int CHAR_SPACE = CHAR_WIDTH + LINE_PADDING;

   private char charr;
   private int x, y;

   /* private constructor -- this should not be called by anyone */
   private EncryptionTurtleMT(char letter, int count, World world){
      // Must fix before being able to compile
      super(world, DELAY);
      super.setPenWidth(3);
      super.setPenColor(Color.RED);
      this.charr = letter;
      this.x = LINE_PADDING + (CHAR_SPACE*count);
      this.y = LINE_PADDING/2;
   }

   /* multithreaded turtle code starts here; we call this method */

   /** This encrypts the inputted string by the rotation and creates turtles
    * to draw this encrypted string
    * @param: the string to encrypt and the amount to rotate the letters
    * @return: N/A
    * */ 
   public static void encryptMT(String originalStr, int rotation) {
      World world = new World(WORLD_WIDTH, WORLD_HEIGHT);
      if (validString(originalStr) == false){
         System.err.println("Invalid String Inputted");
         return;
      } else {
         // Creating the necessary turtles
         int count = 0;
         ArrayList<Thread> turtles = 
            new ArrayList<Thread>();
         for (int i = 0; i < originalStr.length(); i++){
            char letter = letterOperationMT(originalStr.charAt(i), rotation);
            Runnable turtle =
               new EncryptionTurtleMT(letter, count, world);
            Thread thread = new Thread(turtle);
            turtles.add(thread);
            count++;
         }
         // Letting the turtles draw
         for (int i = 0; i < turtles.size(); i++){
            turtles.get(i).start();
         }
      }
   }

   /** This method rotates the inputted character by the rotation amount
    * @param: the character to be rotated, and the amount to rotate
    * @return: the rotated character
    * */ 
   private static char letterOperationMT(char original, int rotation) {
      rotation = rotation % 26;
      if (original + rotation < 65){
         original = (char) (original + rotation + 26);
      } else if (original + rotation > 90){
         original = (char) (original + rotation - 26);
      } else {
         original = (char) (original + rotation);
      }
      return original;
   }
   /** This method checks to see if a string is considered valid
    * @param: the string to be checked
    * @return: true if the input is valid, false if not
    * */ 
   private static boolean validString(String rawInput) {
      // Null or Empty or Too Long
      if (rawInput == null || rawInput.length() == 0 || rawInput.length() > 9){
         return false;
      }
      // Not Uppercase
      for (int i = 0; i < rawInput.length(); i++){
         char letter = rawInput.charAt(i);
         if (letter > 90 || letter < 65){
            return false;
         }
      }
      return true;
   }
   /** This method lets the turtles draw their characters
    * @param: N/A
    * @return: N/A
    * */ 
   public void run(){
      this.draw(charr,x,y);
   }

   public static void main(String[] args) {
      System.out.println("Hello, this is the Main method of EncryptionTurtleMT");
      EncryptionTurtleMT.encryptMT("COMPUTERS", 1);
   }

} // End of public class EncryptionTurtleMT extends Turtle
