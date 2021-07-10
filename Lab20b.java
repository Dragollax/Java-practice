import java.io.*;
import java.util.*;
/*
   Lab 20b
   Point version: aiming for 100

*/
public class Lab20b
{
	public static void main(String[] args) {
		
      int[] array = {7, 8, 1, 3, 2, 5, 4, 9, 11, 10, 14, 12, 13};
      int n = array.length;
      QuickSort(array, 0, n - 1 );
	}
   
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
      
      int i = (start - 1); //counter 
      for(int j = start; j < end; j++){
      //compare j with pivot, move one to left if smaller, do nothing if larger
         if(array[j] < pivot ){
            i++;
            swap(array, i, j);
            
         }
      
      }
      //swap pivot with where i is, pivot is now in the correct position
      swap(array, i + 1, pivot);
      return i + 1; //returns the partition  index for QuickSort
   
   }

   //Quick Sort: similar to merge sort, but uses partition algorithm
   
   public static void QuickSort(int[] array, int start, int end){
         
      //first check if array is down to single element
      if(start < end){
         int PartIndex = Partition(array, start, end); //the partitioning index, or the mid point, will keep dividing array until its single value
         
         QuickSort(array, start, PartIndex - 1); //left side
         
         QuickSort(array, PartIndex - 1, end); //right side
         
      }
   
   } 
   
      
   
   
   
   
   
}