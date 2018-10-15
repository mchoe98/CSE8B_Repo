/* Your header */
/* File Header:
 * This file contains methods that allow for the generation of 
 * characters based upon inputted text. This file extends from
 * WordModel due to utilizing many of the same methods.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 *
 * Class Header:
 * The purpose of this class is to allow for the generation of 
 * characters based upon inputted text.
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class CharacterModel extends WordModel {

   public CharacterModel (int degree) {
      super(degree);
   }

   /** This method follows the WordModel's trainfromText method
    * but trains for characters instead of whole words.
    *  @param: the string of text to be used
    *  @return: how many characters were in the text
    * */
   @Override
      public int trainFromText(String content) {
         // TODO
         // Transforming content into an ArrayList
         Scanner scanner = new Scanner(content);
         ArrayList<Character> contentList = new ArrayList<Character>();
         String word;
         int count = 0;
         while(scanner.hasNext()){
            word = new String(scanner.next().toLowerCase());
            for (int index = 0; index < word.length(); index++){
               Character character = new Character(word.charAt(index));
               contentList.add(character);
               count++;
            }
            contentList.add(' ');
            count++;
         }
         // Removing the extra space at the end
         contentList.remove(contentList.size()-1);
         count--;
         ArrayList<String> prefix = new ArrayList<String>();
         int tracker = 0;
         // Utilizing incrementPrediction
         for (int index = 0; index<contentList.size()-degree; index++){
            while(tracker < degree){
               prefix.add(contentList.get(index+tracker).toString());
               tracker++;
            }
            if(tracker == degree){
               incrementPrediction(prefix,contentList.get(index+tracker).
                     toString());
               prefix.clear();
               tracker = 0;
            }
         }
         return count;
      }

   /** This method follows the WordModel's generate method
    * but removes the added spaces.
    *  @param: the amount of characters to be generated
    *  @return: the generated text
    * */
   @Override
      public String generate(int count) {
         // TODO
         // Creating an array of the words for the text
         ArrayList<ArrayList<String>> keys =
            new ArrayList<ArrayList<String>>(predictionMap.keySet());
         keys = new ArrayList<ArrayList<String>>(keys);
         int randomN = random.nextInt(keys.size());
         ArrayList<String> prefix = 
            new ArrayList<String>(keys.get(randomN));
         prefix = new ArrayList<String>(prefix);
         String output = "";
         // Edge Case: the count is less than the first few words
         if (count <= degree){
            for (int index = 0; index < count; index++){
               output = new String(output + prefix.get(index));
            }
            if (count == 0){
               return null;
            }
            return output;
         } else if (count == degree+1){
            for (int index = 0; index < count-1; index++){
               output = new String(output + prefix.get(index));
            }
            output = new String(output + generateNext(prefix));
            return output;
         }
         ArrayList<String> text = new ArrayList<String>(prefix);
         text = new ArrayList<String>(text);
         int tracker = degree;
         while (tracker < count){
            String prediction = new String(generateNext(prefix));
            prediction = new String(prediction);
            prefix.add(prediction);
            prefix = new ArrayList<String>(prefix);
            prefix.remove(0);
            prefix = new ArrayList<String>(prefix);
            text.add(prediction);
            text = new ArrayList<String>(text);
            tracker++;
         }
         // Converting the array into a string
         for (int index = 0; index < text.size(); index++){
            output = new String(output + text.get(index));
         }
         return output;
      }

}
