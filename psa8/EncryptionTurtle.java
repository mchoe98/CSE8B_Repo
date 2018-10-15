/* File Header:
 * This file contains methods that allow for a turtle to draw an 
 * encrypted message. The one turtle draws the encrypted message
 * in a new world whenever an EncryptionTurtle object is constructed.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to have one turtle draw an encrypted
 * message. Important variables for this class include WORLD_WIDTH and
 * WORLD_HEIGHT for creating the world, DELAY for selecting how fast 
 * the turtle can draw the message, and CHAR_WIDTH, LINE_PADDING, and
 * CHAR_SPACE for drawing each character of the message.
 * /

/* Starter Code by Hans Yuan WI 18 */
import turtleClasses.Turtle;
import turtleClasses.World;
import java.awt.*;
import java.util.*;


public class EncryptionTurtle extends DrawingTurtle {

   // DON'T CHANGE
   public final static int WORLD_WIDTH = 800;
   public final static int WORLD_HEIGHT = 120;

   // CHANGE BACK TO 75 WHEN DONE
   public final static int DELAY = 75;

   // These constants may be helpful:
   public final static int CHAR_WIDTH = 40;
   public final static int LINE_PADDING = 40;
   public final static int CHAR_SPACE = CHAR_WIDTH + LINE_PADDING;

   /* single threaded encryption algorithm starts here */
   public EncryptionTurtle(String originalString, int rotation){
      // Must fix before being able to compile
      super(new World(WORLD_WIDTH, WORLD_HEIGHT), DELAY);
      super.setPenWidth(3);
      super.setPenColor(Color.BLUE);
      String encryptedStr = new String(encrypt(originalString, rotation));
      int count = 0;
      for (char a:encryptedStr.toCharArray()){
         super.draw(a, LINE_PADDING + (CHAR_SPACE*count) , LINE_PADDING/2);
         count++;
      }
   }

   /** This method checks to see if a string is considered valid
    * @param: the string to be checked
    * @return: true if the input is valid, false if not
    * */ 
   private boolean validString(String rawInput) {
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
   /** This method encrypts the inputted string by the inputted rotation
    * @param: the string to be encrypted, and the amount to rotate each char
    * @return: the encrypted string
    * */ 
   private String encrypt(String originalStr, int rotation) {
      if (validString(originalStr) == false){
         System.err.println("Invalid String Inputted");
         return "";
      } else {
         String string = new String();
         for (int i = 0; i < originalStr.length(); i++){
            char letter = originalStr.charAt(i);
            string = string + letterOperation(letter, rotation);
         }
         originalStr = string;
      }
      return originalStr;
   }

   /** This method rotates the inputted character by the rotation amount
    * @param: the character to be rotated, and the amount to rotate
    * @return: the rotated character
    * */ 
   private char letterOperation(char original, int rotation){
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

   public static void main(String[] args) {
      System.out.println("Hello, this is the Main method of EncryptionTurtle");
      EncryptionTurtle turtle = new EncryptionTurtle("COMPUTERS", 1);
   }

} // End of public class EncryptionTurtle extends Turtle
