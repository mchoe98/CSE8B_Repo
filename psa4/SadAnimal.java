/*
 * @author CSE8B Winter 2018 Staff
 * 02/04/18
 */

/* EDIT THIS FILE  */

import java.awt.*;
import java.util.Random;

/* File Header:
 * This file extends from Critter.java
 * This file contains a constructor for a sad animal
 * and methods that objects of this file's class can perform.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Description:
 * To test the sad animals I first ran the simulation with all the
 * critters. I wanted to immediately identify the major problems.
 * I then tested this critter by itself and with a few other critters
 * to identify any smaller issues. Being able to choose which
 * critters were spawned in the simulation and being able to 
 * choose how fast each round occurred helped immensely with my
 * testing.
 * 
 * The simulator first reads whether or not you would like sad animals
 * in the simulation. It also reads how many of this critter you would
 * like in the simulation. During the simulation you can adjust the 
 * speed of the rounds to fit your needs. You can also manually
 * go round by round to fit your needs as well.
 * 
 * 
 * Class Header:
 * The purpose of this class is to allow for a working
 * sad animal to be created.
 * displayName and color are important instance variables
 * for displaying the critter, eaten is an important
 * instance variable for letting the creature know what
 * direction it should move, and random and count are important
 * instance variables for SadAnimal's sub classes.
 */
/* Partially implements an animal's characteristics. */
public class SadAnimal extends Critter {
 protected String displayName;
 // You can add your own instance variables
 protected Color color;
 protected boolean eaten;
 protected Random random;
 protected int count;
 // Constructor: initialize the object.
 public SadAnimal () {
  // TODO
  displayName = ":-(";
  color = Color.red;
  eaten = false;
 }

 // Movement method of SadAnimal that takes in empty parameter
 // Returns a direction that the critter would move to

 /** Return the direction the sad animal will move.
  * @param N/A
  * @return the direction the sad animal will move
  * */
 @Override
  protected Direction getMove() {
   // TODO
   Direction direction = Direction.WEST;
   if (eaten == true){
    direction = Direction.SOUTH;
   }
   return direction;
  }

 /**Return whether or not the sad animal will eat
  * and changes the status of eaten.
  * @param N/A
  * @return true if the animal will eat
  * */
 @Override
 //Changing the status of eaten
 protected boolean eat() {
   // TODO
   if (eaten == false){
     eaten = true;
   }else{
     eaten = false;
   }
      return true;
 }

 /* This method tells the simulator what color I should be. */


 /** Return what color the sad animal should be
  * @param N/A
  * @return the color the animal should be
  * */
 @Override
  protected Color getColor() {
   // TODO
   return this.color;
  }

 // This method returns the string representation of SadAnimal

 /** Return the string representation of the animal
  * @param N/A
  * @return the string representation of the animal
  * */
 @Override
  public String toString() {
   return this.displayName;
  }

 //Any other methods you need to write or overload

}
