import java.awt.*;
import java.util.Random;

/* File Header:
 * This file extends from GreenTurtle.
 * This file allows for the construction of my critter and
 * allows for my critter to perform certain actions.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Description:
 * To test my critter I first ran the simulation with all the
 * critters. I wanted to immediately identify the major problems.
 * I then tested this critter by itself and with a few other critters
 * to identify any smaller issues. Being able to choose which
 * critters were spawned in the simulation and being able to 
 * choose how fast each round occurred helped immensely with my
 * testing.
 * 
 * The simulator first reads whether or not you would like your critter
 * in the simulation. It also reads how many of this critter you would
 * like in the simulation. During the simulation you can adjust the 
 * speed of the rounds to fit your needs. You can also manually
 * go round by round to fit your needs as well.
 * 
 *
 * Class Header:
 * The purpose of this class is to allow for the creation 
 * of a working critter of my creation.
 */

public class Mark_mychoe extends GreenTurtle{
  
  public Mark_mychoe(){
  displayName = "Lady Luck";
  color = Color.ORANGE;
  random = new Random(777);
  }
  
  /** Returns a random attack.
    * @param the opponent to be faced
    * @return a random attack
    * */
  @Override
  protected Attack fight(String opponent){
    int fight = random.nextInt(3);
    if (fight == 0){
      return Attack.ROAR;
    } else if (fight == 1){
      return Attack.SCRATCH;
    } else{
    return Attack.POUNCE;
    }
  }
  
  /** Returns a random direction.
    * @param N/A
    * @return a random direction
    * */
  @Override
  protected Direction getMove(){
    int move = random.nextInt(4);
    if (move == 0){
      return Direction.NORTH;
    } else if (move == 1){
      return Direction.SOUTH;
    } else if (move == 2){
      return Direction.WEST;
    } else{
      return Direction.EAST;
    }
  }
}