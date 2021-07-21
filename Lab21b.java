import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
   Lab 21b
   Point version: Aimed for 110
   Description:
      This lab was aimed towards HashMaps and Sliding Window algorithms. There are 4 methods in total, 3 of which are sliding
      window algorithms, and 1 of which is a HashMap solution to a problem. First, the program will find all the elements within
      the array that add up to 0. In other words, all the zero sum sub arrays. I believe I have done this in a previous lab,
      however now I am using a HashMap to solve this problem. Secondly, the program will find the smallest sub array length
      that adds up to a value greater than a given value. Next, the program will traverse a partially sorted array, and return
      a range of indexes within the array to be sorted. For example: [0,1,2,6,4,3,7]. From index 3 - 5, the array will need to 
      be sorted. Finally, given a binary array, the program will find the longest continuous sequence of 1's within the array,
      given that you can replace k amount of zeroes. The main inspiration was when I first started C++ and Python, there was
      something called Maps and Dictionaries respectively. I challenged myself to implement these into java, by solving certain
      algorithmic challenges using hashmaps. As for the sliding window, this was an algorithm that always intrigued me, but I 
      never got the chance to implement it in anything. So for this lab, the second new thing for me was the sliding window algorithm,
      as I challanged myself to integrate 3 versions of this algorithm in 3 different solutions to different problems. In other words,
      this lab induced me to 2 things: HashMaps and the Sliding Window algorithm
      

*/
class Lab21b{

   public static void main(String[] args){
      int[] array = { -1, 1, 2, 2, -4, 10, -2, -4, -4 };

      Print(array);
      int[] array1 = {2, 2, 3, 4, 5, 6, 7, 8};
      int value = 9;
      int length = FindSum(array1, value);
      if (length != Integer.MAX_VALUE) {
            System.out.println("The smallest length of the sub array that is greater than " + value + " is " + length);
        }
      else {
            System.out.println("No subarray exists");
        }
      
      int[] array2 = { 1, 2, 3, 7, 6, 5, 4, 8, 9 };      
      FindShortest(array2);
      
      int[] BinaryArray = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};
      FindLongest(BinaryArray, 2);
   }
   //sliding window, find sum that is bigger than k
   public static int FindSum(int[] array, int k){
      
      //the sum to find
      int sum = 0;
      
      //stores the length of elements
      int length = Integer.MAX_VALUE;
      
      //the start of the window
      int start = 0;
      
      for(int end = 0; end < array.length; end++){
         //add the element value to the sum
         sum += array[end];
         
         //if the sum exceeds the given value of k
         while(sum > k && start <= end){
            
            //set length to new value if there is a lower value of length found
            length = Integer.min(length, end - start + 1);
            
            //remove elements from the start of the window
            sum -= array[start];
            start++;
         
         } 
      
      }
      return length;
   }
   //hashmap
   public static void Print(int[] array){
      
      
      Map<Integer, List<Integer>> hashmap = new HashMap<>();
      
      //create a key, which will be 0(since we are finding elements that add to zero)
      insert(hashmap, 0, -1);
      
      int sum = 0;
      
      for(int i = 0; i < array.length; i++){
         sum += array[i];
         
         //if the sum already exists in the hashmap
         if(hashmap.containsKey(sum)){
            List<Integer> list = hashmap.get(sum);
            
            for(Integer val : list){
               System.out.println("From index " + (val + 1) + " to " + i);
            
            }
         
         }
         //insert the sum, and the current index into hashmap
         insert(hashmap, sum, i);
      
      }
   
   }
   
   public static <K, V> void insert(Map<K, List<V>> hashmap, K key, V value){
      
      //creates a new key, with an arraylist as a value
      hashmap.putIfAbsent(key, new ArrayList<>());
      //adds the given value to key into the value, which is an arraylist
      hashmap.get(key).add(value);
      
   }
   
   //sliding window
   public static void FindShortest(int[] array){
      
      int start = -1;
      int end = -1;
      
      int max = Integer.MIN_VALUE;
      
      //traverse the array from left to right, keep track of greatest value
      for(int i = 0; i < array.length; i++){
         
         //keep track of the greatest element so far
         if(max < array[i]){
            max = array[i];
         
         }
         //set the end index once a value has been found to be smaller
         if(array[i] < max){
            end = i;
         
         }
      }
      int min = Integer.MAX_VALUE;
      //traverse the array from right to left, keep track of smallest value
      for(int i = array.length - 1; i >= 0; i--){
      
         if(min > array[i]){
            min = array[i];
         
         }
         if(array[i] > min){
            start = i;
         
         }
      
      }
      
      System.out.println("Sort the array from index " + start + " to index " + end);
   
   
   }   
   
   //sliding window
   public static void FindLongest(int[] array, int k){
      int start = 0; //the window's starting index
      int count = 0; //total number of zeros
      int storage = 0; //number of continuous 1's
   
      int startWindow = 0; //left index of max window 
      
      for(int right = 0; right < array.length; right++){
      
         //increase the count of zeros by one if current element is a 0
         if(array[right] == 0){
            count++;
         
         }
         //remove elements from the left side of the window if there are more zeros in count than k
         while(count > k){
            if(array[start] == 0){
               count--;
            
            }
            start++;
            
         
         }
         //update the index of the window, and the size of storage if the size 
         //is greater than storage
         if(right - start + 1 > storage){
            storage = right - start + 1;
            startWindow = start;
            
         }
         
      
      }
         System.out.println("Longest continuous sequence has length " + storage + " from index " 
         + startWindow + " to " + (startWindow + storage - 1));
   
   }
   
 
}
   
   