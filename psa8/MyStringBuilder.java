/* File Header:
 * This file contains many methods for MyStringBuilder.
 * These methods include ways for MyStringBuilder to add characters
 * onto itself, insert characters anywhere into itself, delete portions
 * of itself, translate itself to a string, count how long it is, and
 * compare itself to other MyStringBuilder objects and strings.
 * 
 * Mark Choe
 * mychoe@ucsd.edu
 * 
 * Class Header:
 * The purpose of this class is to create a StringBuilder from 
 * largely scratch. firstNode is an important instance variable for
 * this class because it signals where to start MyStringBuilder.
 * */

public class MyStringBuilder{
   public CharacterNode firstNode;

   public static void main(String[] args){
      //Creating the Objects
      MyStringBuilder string = new MyStringBuilder();
      string.append('M');
      string.append('A');
      string.append('R');
      string.append('K');
      MyStringBuilder string2 = new MyStringBuilder();
      string2.append('M');
      string2.append('A');
      string2.append('R');
      string2.append('K');
      //Changing up the first Object
      string.insert(0,'C');
      string.delete(2,4);
      for (int i = 0; i < 200000; i++){
         string.append('A');
      }
      //Checking the correctness for the other methods
      System.out.println(string.toString());
      System.out.println(string.length());
      System.out.println(string.equals(string2));
      System.out.println(string.equals("MAC"));

   }

   /** This method adds a character to the end of the MyStringBuilder
    * @param: the character to be added
    * @return: N/A
    * */
   public void append(char addingChar){
      CharacterNode currNode;
      if (firstNode == null){
         firstNode = new CharacterNode(addingChar);
         currNode = firstNode;
      } else {
         currNode = firstNode;
         while (currNode.nextNode != null){
            currNode = currNode.nextNode;
         }
         if (currNode.nextNode == null){
            currNode.nextNode = new CharacterNode(addingChar);
         }
      }
   }

   /** This method transaltes MyStringBuilder into a string
    * @param: N/A
    * @return: the MyStringBuilder in string form
    * */
   public String toString(){
      String output = "";
      CharacterNode currNode = null;
      if (firstNode != null){
         currNode = firstNode;
         output = output + currNode.getLetter();
         while (currNode.nextNode != null){
            currNode = currNode.nextNode;
            output = output + currNode.getLetter();
         }
      }
      return output;
   }

   /** This method counts the characters in the calling MyStringBuilder
    * @param: N/A
    * @return: the number of characters in the calling MyStringBuilder
    * */
   public int length(){
      CharacterNode currNode = null;
      int count = 0;
      if (firstNode != null){
         currNode = firstNode;
         count++;
         while (currNode.nextNode != null){
            currNode = currNode.nextNode;
            count++;
         }
         return count;
      }else{
         return count;
      }
   }

   /** This method inputs a character anywhere into the calling object
    * @param: where to input the character, and the character to be inputted
    * @return: N/A
    * */  
   public void insert(int offset, char insertChar) 
      throws IndexOutOfBoundsException{
         // Edge Case: Offset Outside
         if (offset > this.length() || offset < 0){
            throw new IndexOutOfBoundsException("Invalid Offset Inputted");
         }
         CharacterNode currNode = null;
         CharacterNode helpNode = null;
         int count = 0;
         if (firstNode != null){
            if (offset == 0){
               helpNode = firstNode;
               currNode = new CharacterNode(insertChar);
               currNode.nextNode = helpNode;
               firstNode = currNode;
            }
            // Getting to the insertion point
            currNode = firstNode;
            while (currNode.nextNode != null && count < offset-1){
               currNode = currNode.nextNode;
               count++;
            }
            // Inserting
            if (count == offset-1){
               helpNode = currNode.nextNode;
               currNode.nextNode = new CharacterNode(insertChar);
               currNode = currNode.nextNode;
               currNode.nextNode = helpNode;
               currNode = currNode.nextNode;
            }
            if (currNode == null){
               return;
            }
            // Adding the rest
            while (currNode.nextNode != null){
               currNode = currNode.nextNode;
            }
         }
      }

   /** This method deletes a portion of the calling object
    * @param: where to start deleting, and where to stop deleting
    * @return: N/A
    * */ 
   public void delete(int start, int end)
      throws StringIndexOutOfBoundsException{
         // Edge Cases: Start or End Outside
         if (start > this.length() || start > end|| start < 0){
            throw new StringIndexOutOfBoundsException("Invalid Start Inputted");
         }
         if (end < 0){
            throw new StringIndexOutOfBoundsException("Invalid End Inputted");
         }
         if (end > this.length()){
            end = this.length();
         }
         // Delete All
         if (start == 0 && end == this.length()){
            firstNode = null;
         }
         CharacterNode currNode = null;
         CharacterNode helpNode = null;
         int count = 0;
         if (firstNode != null){
            // Getting to the Deletion Point
            currNode = firstNode;
            while (currNode.nextNode != null && count < start-1){
               currNode = currNode.nextNode;
               count++;
            }
            // Deleting
            if (count == start-1){
               helpNode = currNode.nextNode;
               for (int i = 0; i < end-start; i++){
                  helpNode = helpNode.nextNode;
               }
               currNode.nextNode = helpNode;
               currNode = currNode.nextNode;
            }
            if (currNode == null){
               return;
            }
            // Adding the rest
            while (currNode.nextNode != null){
               currNode = currNode.nextNode;
            }
         } else {
            return;
         }
      }

   /** This method compares the calling object to the inputted object
    * @param: the object to compare the calling object with
    * @return: true if the input matches the calling object, false if not
    * */ 
   public boolean equals (Object other){
      // Comparing Object Type
      if (other instanceof MyStringBuilder){
         // Comparing Length
         if (((MyStringBuilder)other).length() != this.length()){
            return false;
         }
         //Comparing Content
         CharacterNode currNode = null;
         CharacterNode currNode2 = null;
         // First Node
         if (firstNode != null){
            currNode = firstNode;
            currNode2 = ((MyStringBuilder)other).firstNode;
            if (currNode != currNode2){
               return false;
            }
            // The Rest of the Nodes
            while (currNode.nextNode != null){
               currNode = currNode.nextNode;
               currNode2 = currNode2.nextNode;
               if (currNode != currNode2){
                  return false;
               }
            }
            return true;
         } else{
            // Both Null?
            if (((MyStringBuilder)other).firstNode == null){
               return true;
            } else{
               return false;
            }
         }
      } else {
         return false;
      }
   }

   /** This method compares the calling object to the inputted string
    * @param: the string to compare the calling object with
    * @return: true if the input matches the calling object, false if not
    * */ 
   public boolean equals (String other){
      // Comparing Length
      if (other.length() != this.length()){
         return false;
      }
      //Comparing Content
      CharacterNode currNode = null;
      char currChar;
      // First Node
      currNode = firstNode;
      currChar = other.charAt(0);
      if (currNode.getLetter() != currChar){
         return false;
      }
      // The Rest of the Nodes
      int count = 1;
      while (currNode.nextNode != null){
         currNode = currNode.nextNode;
         currChar = other.charAt(count);
         count++;
         if (currNode.getLetter() != currChar){
            return false;
         }
      }
      return true;
   }

}
