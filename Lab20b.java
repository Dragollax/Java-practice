import java.io.*;
import java.util.*;
/*
   Lab 20b
   Point version: aiming for 100
   Description:
      This lab is based off of moving elements within an array. First, given a randomly placed array, the program will sort
   the given array using quick sort. Then, after sorting it into ascending order, the program will rearrange the program
   based off the pattern of biggest number, smallest number, second biggest, second smallest...etc 
      
*/
public class Lab20b
{
	public static void main(String[] args) {
		
      int[] array = {7, 8, 1, 3, 2, 5, 4, 9, 11, 10, 14, 12, 13};
      int n = array.length;
      Program.QuickSort(array, 0, n - 1 );
      System.out.println("Sorting array using quicksort... ");
      System.out.println(Arrays.toString(array));
      Program.Rearrange(array);
      System.out.println("Rearranging array...");
      System.out.println(Arrays.toString(array));
      
    	}
     
   
}
class Program{
   //depends on the array being sorted in ascending order
   public static void Rearrange(int[] arr){
      int[] temp = arr.clone(); //clone the original array
      
      int end = arr.length - 1;//largest element in array
      int start = 0; //smallest element in array
      
      boolean alternate = true;
      for(int i = 0; i < arr.length; i++){
         if(alternate){
            arr[i] = temp[end];
            end--;
         }     
         else{
            arr[i] = temp[start];
            start++;
         }
         //so that we can make sure that it alternates between largest and smallest each time
         alternate = !alternate;
      
      }
      
      
      
      
   }
   
   //swap function used for Rearrange function and Quick Sort
   public static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   
   }
   //
   public static int Partition(int[] array, int start, int end){
      
      int pivot = array[end]; //select pivot as end number in array
      
      int i = start - 1; //counter 
      for(int j = start; j < end; j++){
      //compare j with pivot, move one to left if smaller, do nothing if larger
         if(array[j] < pivot ){
            i++;
            swap(array, i, j);
            
         }
      
      }
      //swap pivot with where i is, pivot is now in the correct position
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;      
        return i + 1; //returns the partition  index for QuickSort
   
   }

   //Quick Sort: similar to merge sort, but uses partition algorithm
   
   public static void QuickSort(int[] array, int start, int end){
         
      //first check if array is down to single element
      if(start < end){
         int PartIndex = Partition(array, start, end); //the partitioning index, or the mid point, will keep dividing array until its single value
         
         QuickSort(array, start, PartIndex - 1); //left side
         
         QuickSort(array, PartIndex + 1, end); //right side
         
      }
   
   } 
   //equilibrium index is when the sum of every element on the left equals the sum of every element on the right
   //we can find the sum of the left array by subtracting the total sum by the current element minus the current indexed
   public static String FindEquilibrium(int[] array){
      //{1,2,3,4,4,5}
      int total = 0;
      
      for(int i : array){
         total += i;
      
      }
      Arraylist<Integer> index = new Arraylist<Integer>();
      int rightSum = 0;
      for(int i = array.length - 1; i >= 0; i--){
         //if sum from right array equals sum from left array
         if(rightSum == total - array[i] + rightSum){
            index.add(i);
         }
         
         //add current array element to the right sum
         rightSum += array[i];
      
      }
      int[] indexArr = new int[index.size()];
      int count = 0;
      for(int i : index){
         index[count] = i;
         count++;
         
      }
      return Arrays.toString(indexArray);
   
   }
   
}   
   
   
   
