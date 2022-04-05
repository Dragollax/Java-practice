/*  
   Lab 20a
   Purpose: Array manipulation
   This program will be used for array manipulation, first it will find the maximum product between two elements within an array, then it will 
   move all zeros present in the array to the start, then to the end. Finally, the array will be sorted with merge sort. In lab 18b, we implemented
   just the merge part of merge sort, with arraylist. So for this lab, I challenged myself into implementing a full fledged merge sort that deals
   with static arrays, and explaining using comments how it works.
*/
import java.io.*;
import java.util.*;

class Lab20a
{
     public static void FindMaxProduct(int[] array){
      //condition: two maximum numbers multiplied together will result in the greatest product
      int max1 = array[0];//biggest number
      int max2 = 0;//second biggest number
      int min1 = array[0];//smallest number
      int min2 = 0;//second smallest number 
      for(int i = 1; i < array.length; i++){
         
         if(array[i] > max1){ //if element of array is bigger than max1
            max2 = max1; 
            max1 = array[i];
         }
         else if(array[i] > max2){//if less than max1, but greater than max2
         
            max2 = array[i];
         
         }
         
         else if(array[i] < min1){//if less than min1
            min2 = min1;
            min1 = array[i];
         }
         else if(array[i] < min2){//if greater than min1, but less than min2
            min2 = array[i];
         }
         
         
      }
      if(max1 * max2 > min1 * min2){//if product of max1 and max2 is greater than that of min1 and min2
         System.out.println("Greatest product of the array: "+  max1 + " x " + max2 + " = " + max1 * max2);
         
      }
      else if (min1 * min2 == max1 * max2){//if products are both the same
         System.out.println("There are two pairs that amount to the same greatest product");

         System.out.println(max1 + " x " + max2 + " = " + max1 * max2);
         System.out.println("and " + min1 + " x " + min2 + " = " + min1 * min2);


      }
      else{//if product of min1 and min2 is greater than that of max1 and max2
         System.out.println("Greatest product of the array: "+  min1 + " x " + min2 + " = " + min1 * min2);

      }
      
    }
    public static void MoveZerosToStart(int[] array){
    //loop through array, if number is not zero, move the end part of the array
      int position = array.length - 1; //end of array
      
      for(int i = array.length - 1; i >= 0; i--){
         if(array[i] != 0){
            array[position] = array[i];//move number from wherever to end of array if is not 0
            position--; //decrement the position by 1 so the next non 0 number can be moved to that position
         }
         
      }
      //if there happens to be zeros present(position not being 0), fill the remaining spots with 0
      while(position >= 0){
         array[position] = 0;
         position--;
      }
    
    }
    public static void MoveZerosToEnd(int[] array){
    //loop through array, if number is not zero, move the end part of the array
      int position = 0; //end of array
      
      for(int i = 0; i <= array.length - 1 ; i++){
         if(array[i] != 0){
            array[position] = array[i];//move number from wherever to end of array if is not 0
            position++; //decrement the position by 1 so the next non 0 number can be moved to that position
         }
         
      }
      //if there happens to be zeros present(position not being 0), fill the remaining spots with 0
      while(position <= array.length -1){
         array[position] = 0;
         position++;
      }
    
    }
    public static void merge(int array[], int left, int mid, int right)
    {    
 
        //two sub arrays
        int leftArr[] = new int[mid - left + 1];
        int rightArr[] = new int[right - mid];   
         
        //copy left half of array to leftArr
        for (int i = 0; i < leftArr.length; i++){
           leftArr[i] = array[left + i];
        }
        //copy right half 
        for (int j = 0; j < rightArr.length; j++){
           rightArr[j] = array[mid + 1 + j];
        }
        //will be used for dealing with left and right array
        int i = 0;
        int j = 0; 
 
        int k = left;
        
        //break the loop when either side has reached their length
        while (i < leftArr.length && j < rightArr.length) {
           if (leftArr[i] <= rightArr[j]) {//if element from leftArr is greater than that of rightArr
                array[k] = leftArr[i];
                i++;//will terminate loop once i becomes greater than the length of leftArr
            }
            else {
                array[k] = rightArr[j];
                j++;//will terminate loop once j becomes greater than the length of rightArr
            }
            k++;
        }
 
        //if i is less than the length of leftArr, that means rightArr is full, and copy remaining elements of leftArr to array
        //Assuming that we've divided everything into single elements already(sorted), either remaining sub array would already be sorted,
        //allowing us to confidently copy all remaining elements from either leftArr or rightArr to the final array
        while (i < leftArr.length) {
            array[k] = leftArr[i];
            i++;
            k++;
        }
 
        //same as above, except with rightArr
        while (j < rightArr.length) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int array[], int left, int right)
    {
        if (left < right) { //keep splitting until all that remains is single element
            int mid = left + (right-left)/2; //find the middle index of the array 
            
            //recursion. this will create a tree when drawn out(left and right nodes) as it keeps dividing
            sort(array, left, mid); //left half of split 
            sort(array, mid + 1, right); //right half of split
            
 
            //merge sorted halves
            merge(array, left, mid, right);
        }
    }
    static void PrintArray(int arr[])
    {
        int n = arr.length;
        for(int i = 0; i < n; ++i)
           System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main (String[] args)
    {

        int[] array = { 3, 4, 5, 3, 0, 0, 0, 2, 3, 5, 4, -5, -10, -10, -5, 9 , 10, 100, 20, 3 };

        FindMaxProduct(array);
        MoveZerosToEnd(array);
        System.out.println("After moving 0s in the array to the end... " + Arrays.toString(array));
        MoveZerosToStart(array);
        System.out.println("After moving 0s in the array to the start... " + Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println("Sorting array with merge sort...");
        PrintArray(array);
        
    }
}