/* File Header:
 * This file constructs character nodes for MyStringBuilder to use.
 * This file just contains a constructor and a char getter.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is basically to allow for MyStringBuilder
 * to operate properly. Important instance variables are letter and nextNode,
 * because for MyStringBuilder to operate properly the CharacterNodes must keep
 * track of what letter it is and what the next CharacterNode's letter is.
 * */
public class CharacterNode{
   private final char letter;
   public CharacterNode nextNode;

   public CharacterNode(char letter){
      this.letter = letter;
   }
   /** This method returns the letter
    * @param: N/A
    * @return: the letter
    * */
   public char getLetter(){
      return letter;
   }
}
