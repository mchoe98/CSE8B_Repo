/* File Header:
 * This file extends from Turtle.java.
 * This file allows for the construction of a green turtle and
 * allows for the green turtle to perform certain actions.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 *
 * Description:
 * To test the green turtles I first ran the simulation with all the
 * critters. I wanted to immediately identify the major problems.
 * I then tested this critter by itself and with a few other critters
 * to identify any smaller issues. Being able to choose which
 * critters were spawned in the simulation and being able to 
 * choose how fast each round occurred helped immensely with my
 * testing.
 * 
 * The simulator first reads whether or not you would like green turtles
 * in the simulation. It also reads how many of this critter you would
 * like in the simulation. During the simulation you can adjust the 
 * speed of the rounds to fit your needs. You can also manually
 * go round by round to fit your needs as well.
 * 
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation 
 * of a working green turtle.
 * The direction is an important instance variable because
 * the green turtle needs to know what direction to follow
 * when it cycles through its directions.
 */

import java.awt.*;
import java.util.Random;

public class GreenTurtle extends Turtle{
 protected Direction move; 
 public GreenTurtle(){
  displayName = "G";
  color = Color.green;
  random = new Random(9);
  move = Direction.NORTH;
  attack = Attack.ROAR;
 }
  
 /** Goes to the next direction in the green turtle's
   * movement cycle
   * @param N/A
   * @return N/A
   * */
 protected void generateMove(){
  if (move == Direction.SOUTH){
   move = Direction.EAST;
  } else if (move == Direction.EAST){
   move = Direction.WEST;
  } else if (move == Direction.WEST){
   move = Direction.NORTH;
  } else {
   move = Direction.SOUTH;
  }
 }
 
 /** Changing up the green turtle's attack to the other
   * attack option
   * @param N/A
   * @return N/A
   * */
 @Override
  protected void generateAttack(){
   if (attack == Attack.ROAR){
    attack = Attack.SCRATCH;
   } else{
    attack = Attack.ROAR;
   }
 }
 
 /**Returns that the turtle will eat if it has
   * not already eaten three times and changes its
   * direction when it eats
   * @param N/A
   * @return true if the turtle as not eaten three times;
   * false if the turtle has eaten three times
   * */
 @Override
 protected boolean eat(){
   if (count < 3){
    count++;
    generateMove();
    return true;
   }else{
    return false;
   }
 }
 
 /** Returns the attack that the green turtle
   * has decided upon except when facing a sloth.
   * @param the opponent that the green turtle will face
   * @return the attack that the green turtle has already
   * decided upon except when facing a sloth. When facing
   * an awake sloth, it will roar. When facing an asleep
   * sloth, it will forfeit.
   * */
 @Override
  protected Attack fight(String opponent){
   if (opponent.equals("S")){
    return Attack.ROAR;
   } else if (opponent.equals("Zzz")){
    return Attack.FORFEIT;
   } else{
    return attack;
   }
  }
 
 /** Goes to the next attack and direction in the
   * attack and move cycles when it wins.
   * @param N/A
   * @return N/A
   * */
 @Override
 protected void win(){
   generateMove();
   generateAttack();
 }
 
 /** Goes to the next attack in the attack cycle after
   * mating.
   * @param N/A
   * @return N/A
   * */
 @Override
 protected void mate(){
   generateAttack();
 }
 
 /** Returns the direction that the green turtle
   * has decided to move in.
   * @param N/A
   * @return the direction that it will move
   * */
 @Override
  protected Direction getMove(){
   return move;
  }
}
