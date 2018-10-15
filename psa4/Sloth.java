/*
 * @author CSE8B Winter 2018 Staff
 * 02/04/18
 */

// THIS FILE SHOULD extends HappyAnimal

/* EDIT THIS FILE  */

import java.awt.*;
import java.util.Random;

/* File Header:
 * This file extends from HappyAnimal.java.
 * This file allows for the construction of a sloth and
 * allows for the sloth to perform certain actions.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Description:
 * To test the sloths I first ran the simulation with all the
 * critters. I wanted to immediately identify the major problems.
 * I then tested this critter by itself and with a few other critters
 * to identify any smaller issues. Being able to choose which
 * critters were spawned in the simulation and being able to 
 * choose how fast each round occurred helped immensely with my
 * testing.
 * 
 * The simulator first reads whether or not you would like sloths
 * in the simulation. It also reads how many of this critter you would
 * like in the simulation. During the simulation you can adjust the 
 * speed of the rounds to fit your needs. You can also manually
 * go round by round to fit your needs as well.
 * 
 *
 * Class Header:
 * The purpose of this class is to allow for the creation 
 * of a working sloth.
 * eaten and count are important instance variables for 
 * keeping track of how many times the sloth has eaten, while
 * direction is an important instance variable for keeping
 * track of what direction the sloth ought to go.
 */

// This class implements the Sloth critter class.
// Notice that it inherits from the critter class.
public class Sloth extends HappyAnimal {
  // You can add your own instance variables
  protected boolean eaten;
  protected Direction direction;
  protected int count;
  /* Constructor: Create a new Sloth. */
  public Sloth() {
    // TODO
    displayName = "S";
    eaten = false;
    direction = Direction.NORTH;
  }
  
  // eating behavior of Sloth
  
  /**Return whether or not the sloth will eat and count
    * count how many times the sloth has eaten.
    * @param N/A
    * @return true when the sloth will eat
    * */
  @Override
  protected boolean eat() {
    // TODO
    count++;
    return true;
  }
  
  // the fight method of Sloth
  
  /**Return a scratch attack if the sloth has eaten less than 10
    * times and a pounce attack if the sloth has eaten 10 or more times.
    * @param N/A
    * @return a scratch attack if the count is less than 10 or a pounce
    * attack if the count is 10 or greater
    * */
  @Override
  protected Attack fight(String opponent) {
    // TODO
    if (count >= 10){
      return Attack.POUNCE;
    } else {
      return Attack.SCRATCH;
    }
  }
  
  // the move method of Sloth
  
  /**Return what direction the sloth will move
    * @param N/A
    * @return move north if the sloth was going east and vice versa
    * */
  @Override
  protected Direction getMove() {
    // TODO
    if (direction == Direction.NORTH){
      direction = Direction.EAST;
    } else if (direction == Direction.EAST){
      direction = Direction.NORTH;
    }
    return direction;
  }
  
  /**Change the sloth's display name to "Zzz".
    * @param N/A
    * @return N/A
    * */
  @Override
  protected void sleep() {
    // TODO
    displayName = "Zzz";
  }
  
  /**Change the sloth's display name to "S".
    * @param N/A
    * @return N/A
    * */
  @Override
  protected void wakeup() {
    // TODO
    displayName = "S";
  }
}
