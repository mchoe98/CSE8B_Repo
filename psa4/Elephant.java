/* File Header:
 * This file extends from HappyAnimal.java.
 * This file allows for the construction of an elephant and
 * allows for the elephant to perform certain actions.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 *
 * Description:
 * To test the elephants I first ran the simulation with all the
 * critters. I wanted to immediately identify the major problems.
 * I then tested this critter by itself and with a few other critters
 * to identify any smaller issues. Being able to choose which
 * critters were spawned in the simulation and being able to 
 * choose how fast each round occurred helped immensely with my
 * testing.
 * 
 * The simulator first reads whether or not you would like elephants
 * in the simulation. It also reads how many of this critter you would
 * like in the simulation. During the simulation you can adjust the 
 * speed of the rounds to fit your needs. You can also manually
 * go round by round to fit your needs as well.
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation 
 * of a working elephant.
 * goalX and goalY are important instance variables, because
 * without them, the elephants would not know where to go.
 */

import java.awt.*;
import java.util.Random;

public class Elephant extends HappyAnimal{
 protected static int goalX;
 protected static int goalY;
 public Elephant(){
  displayName = "El";
  color = Color.gray;
  random = new Random(2048);
 }
 
 /** Returns the attack that the elephant will use
   * @param the opponent that it will face
   * @return the pounce attack
   * */
 @Override
  protected Attack fight(String opponent){
   return Attack.POUNCE;
  }
 
 /** Returns the direction the elephant will move to
   * get closer to the goal
   * @param N/A
   * @return the direction the elephant will move to
   * get closer to the goal
   * */
 @Override 
  protected Direction getMove(){
   // Getting a new goal
   if ((getX() == goalX && getY() == goalY) ||
     (goalX == 0 && goalY == 0)){
    goalX = random.nextInt(getWidth());
    goalY = random.nextInt(getHeight());
   }
   // Figuring out which axis to go along
   if (Math.abs(getX()-goalX)>Math.abs(getY()-goalY)){
    if (getX()-goalX>0){
     return Direction.WEST;
    } else {
     return Direction.EAST;
    }
   } else {
    if (getY()-goalY>0){
     return Direction.NORTH;
    } else {
     return Direction.SOUTH;
    }
   }
  }
}
