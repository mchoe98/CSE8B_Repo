/* Your header */
/* File Header:
 * This file contains methods that allow for the generation of 
 * words based upon inputted text. This file also utilizes a cache
 * for faster implementations.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 *
 * Class Header:
 * The purpose of this class is to allow for the generation of 
 * words based upon inputted text. Important instance variables
 * include predictionMap, cache, degree, and random as they all
 * allow for this program to run according to the PSA guidelines.
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class WordModel {

   protected HashMap<ArrayList<String>, HashMap<String, Integer>>
      predictionMap;
   protected HashMap<ArrayList<String>, ArrayList<String>> cache;

   protected int degree;
   protected Random random;

   public WordModel (int degree) {
      // TODO
      this.predictionMap = new HashMap<ArrayList<String>,HashMap<String,
         Integer>>();
      this.cache = new HashMap<ArrayList<String>, ArrayList<String>>();
      this.degree = degree;
      this.random = new Random();
   }

   /** This method adds to the HashMaps if the keys are missing,
    * but increments the predictionMap if they are not.
    *  @param: the words that make up the prefix, and the prediction
    *  for this prefix
    *  @return: N/A 
    * */
   public void incrementPrediction(ArrayList<String> prefix, String
         prediction){
      // TODO
      prefix = new ArrayList<String>(prefix);
      prediction = new String(prediction);
      // Adding to the predictionMap
      if (predictionMap.containsKey(prefix)==false){
         HashMap<String,Integer> innerMap = new HashMap<String,Integer>();
         Integer startCount = 0;
         startCount = new Integer(startCount);
         innerMap.put(prediction,startCount);
         predictionMap.put(prefix,innerMap);
      }
      // Adding to the predictionMap's value
      HashMap<String,Integer> innerMap = predictionMap.get(prefix);
      prefix = new ArrayList<String>(prefix);
      if (innerMap.containsKey(prediction)==false){
         innerMap.put(prediction,0);
         innerMap = new HashMap<String, Integer>(innerMap);
      }
      // Incrementing the count
      Integer currentValue = new Integer(innerMap.get(prediction));
      innerMap.put(prediction,currentValue+1);
      prefix = new ArrayList<String>(prefix);
      prediction = new String(prediction);
      innerMap = new HashMap<String,Integer>(innerMap);
      predictionMap.put(prefix,innerMap);
   }

   /** This method goes through text, utilizes the incrementPrediction
    * method, and returns the number of words in the text.
    *  @param: the string of text to be used
    *  @return: how many words were in the text
    * */
   public int trainFromText(String content) {
      // TODO
      // Transforming content into an ArrayList
      Scanner scanner = new Scanner(content);
      ArrayList<String> contentList = new ArrayList<String>();
      String word;
      int count = 0;
      while(scanner.hasNext()){
         word = new String(scanner.next().toLowerCase());
         contentList.add(word);
         count++;
      }
      ArrayList<String> prefix = new ArrayList<String>();
      int tracker = 0;
      // Utilizing incrementPrediction
      for (int index = 0; index<contentList.size()-degree; index++){
         while(tracker < degree){
            prefix.add(contentList.get(index+tracker));
            tracker++;
         }
         if(tracker == degree){
            incrementPrediction(prefix,contentList.get(index+tracker));
            prefix.clear();
            tracker = 0;
         }
      }
      return count;
   }

   /** This method adds the information of the predictionMap to the cache
    *  @param: the prefix to be used
    *  @return: the cache's value
    * */
   public ArrayList<String> getFlattenedList(ArrayList<String> prefix){
      // TODO
      // Checking the cache for the prefix
      if (cache.containsKey(prefix)){
         return cache.get(prefix);
         // Adding to the cache
      } else {
         HashMap<String,Integer> innerMap = new HashMap<String,Integer>
            (predictionMap.get(prefix));
         innerMap = new HashMap<String,Integer>(innerMap);
         ArrayList<String> keys = new ArrayList<String>(innerMap.keySet());
         keys = new ArrayList<String>(keys);
         ArrayList<String> cacheValue = new ArrayList<String>();
         cacheValue = new ArrayList<String>(cacheValue);
         for (int index = 0; index < keys.size(); index++){
            for (int index2 = 0; index2 < 
                  innerMap.get(keys.get(index));index2++){
               cacheValue.add(keys.get(index));
               cacheValue = new ArrayList<String>(cacheValue);
            }
         }
         cache.put(prefix,cacheValue);
         cache = new HashMap <ArrayList<String>, ArrayList<String>>(cache);
         return cache.get(prefix);
      }
   }

   /** This method predicts the next word based upon the given prefix
    *  @param: the prefix to be used
    *  @return: the generated prediction based upon the prefix
    * */
   public String generateNext(ArrayList<String> prefix) {
      // TODO
      ArrayList<String> flattenedList = new ArrayList<String>
         (getFlattenedList(prefix));
      flattenedList = new ArrayList<String>(flattenedList);
      int randomN = random.nextInt(flattenedList.size());
      String word = new String(flattenedList.get(randomN));
      return word;
   }

   /** This method generates a certain amount of words based upon
    * some given text.
    *  @param: the amount of words to be generated
    *  @return: the generated text
    * */
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
            output = new String(output + prefix.get(index) + " ");
         }
         if (count == 0){
            return null;
         }
         return output;
      } else if (count == degree+1){
         for (int index = 0; index < count-1; index++){
            output = new String(output + prefix.get(index) + " ");
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
         output = new String(output + text.get(index) + " ");
      }
      return output;
   }

   /** return reference to predictionMap */
   public HashMap<ArrayList<String>, HashMap<String, Integer>> getPredictionMap() {
      return this.predictionMap;
   }

   /* return reference to cache */
   public HashMap<ArrayList<String>, ArrayList<String>> getCache(){
      return this.cache;
   }

   /* return a reference to the random object */
   public Random getRandom(){
      return this.random;
   }

   /* return the degree */
   public int getDegree(){
      return this.degree;
   }


   /* provided for debug purposes,
      but really, provided so students can look at how to iterate HashMap */ 
   public void printMap(){

      /* for each key (prefix) in predictionMap, 
         print prefix, print all predictions with counts */
      for(ArrayList<String> prefix: predictionMap.keySet()){
         System.out.println("Prefix: " + prefix + ":");

         HashMap<String, Integer> freqMap = predictionMap.get(prefix);
         /* for each key (prediction) in the subsequen HashMap, 
            print prediction, print count */
         for (String prediction: freqMap.keySet()){
            System.out.printf("\tPrediction: \"%s\"   Count: %d\n", 
                  prediction, freqMap.get(prediction));           
         }
      }       
   }

}
