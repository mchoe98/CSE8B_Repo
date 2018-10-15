/**File Header:
  * This file makes a bunch of methods pertaining to 
  * arrays. These methods find the largest number in
  * an array, find the smallest number in an array, 
  * prints out the given array, creates and prints a
  * copy of the initial array, finds the average value
  * of the array's number, and sorts and prints the 
  * given array from least to greatest.
  * 
  * Mark Choe
  * A13917840
  * mychoe@ucsd.edu
  * 01/12/18
  *
  * Compile Error - cannot find symbol
  * Incorrect: min = array[0]
  * Fix: int min = array[0]
  * Explanation: references need to be defined
  * 
  * Compile Error - possible lossy conversion 
  * Incorrect: int average = ( sum / ( array.length ) );
  * Fix: double average = ( sum / ( array.length ) );
  * Explanation: average's type must be double, not int,
  * because an int type would lose information.
  * 
  * Compile Error - incomparable types: int and <null>
  * Incorrect: public static int[] arrayCopy(int array) {
  * Fix: public static int[] arrayCopy(int[] array) {
  * Explanation: array is supposed to be an integer array
  * not an integer.
  *
  * Runtime Error - Array out of Bounds
  * Incorrect: for (int i = 0; i <= array.length; i++) {
  * Fix: for (int i = 0; i <= array.length -1; i++) {
  * Explanation: if the index equaled the array length, it
  * would actually go past the length.
  * 
  * Runtime Error - Array out of Bounds
  * Incorrect: for (int j = 0; i < result.length - i - 1; j++) {
  * Fix:  for (int j = 0; j < result.length - 1; j++) {
  * Explanation: increasing j does not increase i, thus j would 
  * never stop increasing.
  * 
  * Logic Error - not equal
  * Incorrect: if (array != null)
  * Fix: if (array == null)
  * Explanation: the array ought to return nothing if the array's
  * input is null.
  * 
  * Logic Error - increase
  * Incorrect: result[i++] = array[i];
  * Fix: result[i] = array[i];
  * Explanation: there is no reason to increase the index of the 
  * result array.
  * 
  * Logic Error - adding
  * Incorrect: sum = array[i];
  * Fix: sum = sum + array[i];
  * Explanation: the array values should keep adding onto the sum.
  * the sum should not just be the last number of the array.
  * 
  * Logic Error - increase
  * Incorrect: int temp = result[j];
  * Fix: int temp = result[j + 1];
  * Explanation: the temporary value should be saving the smaller
  * value, not the bigger value.
  * 
  * Class Header: 
  * The purpose of this class is to get information from the given
  * array, print the given array, and sort the given array from 
  * least to greatest. The gathered information from the given array
  * includes the greatest number in the array, the smallest number in
  * the array, and the average value of all the array's numbers.
  * */

public class FunWithIntArrays {
  
  // return the largest element in the input array
  public static int findMax(int[] array) {
    //short circuit protects null access
    if (array == null || array.length == 0)
      return -1;
    
    int max = array[0];
    
    for (int i = 0; i <= array.length -1; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    
    return max;
  }
  
  // return the smallest element in the input array
  public static int findMin(int[] array) {
    //short circuit protects null access
    if (array == null || array.length == 0)
      return -1;
    
    int min = array[0];
    
    for (int i = 0; i < array.length -1; i++) {
      if (array[i] < min) {
        min = i;
      }
    }
    
    return min;
  }
  
  
  // return the average of elements in the input array
  public static double findAvg( int array[] ) {
    //short circuit protects null access
    if ( array == null || array.length == 0 )
      return -1;
    
    double sum = 0;
    
    for ( int i=0; i < array.length; i++ ) {
      sum = sum + array[i];
    }
    
    double average =( sum / ( array.length ) );
    
    return average;
  }
  
  // return a copy of the input array
  public static int[] arrayCopy(int[] array) {
    if (array == null)
      return null;
    
    int[] result = new int[array.length];
    
    for (int i = 0; i < array.length; i++) {
      result[i] = array[i];
    }
    return result;
  }
  
  // output the elements of the input array
  public static void printArray(int[] array) {
    if (array == null)
      return;
    
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + ", ");
    }
    
    System.out.println();
  }
  
  // return a sorted copy of the input array
  public static int[] arraySort(int[] array) {
    if (array == null)
      return null;
    
    int[] result = arrayCopy(array);
    
    for (int i = 0; i < result.length - 1; i++) {
      for (int j = 0; j < result.length - 1; j++) {
        if (result[j] > result[j + 1]) {
          //swapping result[j] and result[j+1]
          int temp = result[j + 1];
          result[j + 1] = result[j];
          result[j] = temp;
        }
      }
    }
    return result;
  }
}
