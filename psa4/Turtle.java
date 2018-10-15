/* File Header:
 * This file extends from Omnivore.java.
 * This file allows for the construction of a turtle and
 * allows for the turtle to perform certain actions.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 *
 * Description: 
 * To test the turtles I first ran the simulation with all the
 * critters. I wanted to immediately identify the major problems.
 * I then tested this critter by itself and with a few other critters
 * to identify any smaller issues. Being able to choose which
 * critters were spawned in the simulation and being able to 
 * choose how fast each round occurred helped immensely with my
 * testing.
 * 
 * The simulator first reads whether or not you would like turtles
 * in the simulation. It also reads how many of this critter you would
 * like in the simulation. During the simulation you can adjust the 
 * speed of the rounds to fit your needs. You can also manually
 * go round by round to fit your needs as well.
 * 
 * 
 * Class Header:
 * The purpose of this class is to allow for the creation 
 * of a working turtle.
 * attack is an important instance variable because the 
 * turtle needs to know what attack it will use when it
 * cycles through its attacks.
 */

import java.awt.*;
import java.util.Random;

public class Turtle extends Omnivore{
  
 protected Attack attack;
 
 public Turtle(){
  displayName = "Tu";
  color = Color.cyan;
  attack = Attack.ROAR;
 }
 
 /** Cycles to the next attack the turtle will use
   * @param N/A
   * @return N/A
   * */
 protected void generateAttack(){
  if (attack == Attack.ROAR){
   attack = Attack.SCRATCH;
  } else if (attack == Attack.SCRATCH){
   attack  = Attack.POUNCE;
  } else {
   attack = Attack.ROAR;
  }
 }
 
 /** Returns the next direction the turtle will move
   * @param N/A
   * @return move up after waiting twice
   * */
 @Override
 protected Direction getMove(){
   if (count > 2){
    count = 0;
   }
   if (count < 2){
    count++;
    return Direction.CENTER;
   } else {
    count++;
    return Direction.NORTH;
   }
  }
 
 /** Returns the attack that the turtle will use
   * @param the opponent that the turtle will face
   * @return the attack that the turtle has decided
   *  to use
   * */
 @Override
 protected Attack fight(String opponent){
   return attack;
 }
 
 /** Moves to the next attack in the cycle when the
   * turtle wins a fight
   * @param N/A
   * @return N/A
   * */
 @Override
 protected void win(){
   generateAttack();
 }
 
 /** Moves to the next attack in the cycle when the
   * turtle encounters food
   * @param N/A
   * @return false because the turtle will never eat
   * */
 @Override
 protected boolean eat(){
   generateAttack();
   return false;
 }
}
