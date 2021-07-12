import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
/*
   Lab 20b
   Point version: aiming for 100
   Description:
      This lab is based off of moving elements within an array. First, given a randomly placed array, the program will sort
   the given array using quick sort. Then, after sorting it into ascending order, the program will rearrange the program
   based off the pattern of biggest number, smallest number, second biggest, second smallest...etc. Then, in another array, the program
   will find the smallest missing number within the array. Finally, in another array, the program will find a pair that adds up to a
   given sum. This interests me Because I've always wanted to dive deeper into algorithms and data structures, refining my skills
   as a programmer. Since we did merge sort, which was a divide and conquer algorithm, I wanted to apply another divide and conquer
   algorithm that I would learn and integrate without any help. Along with the other methods within the Program class. I wanted to 
   enhance my problem solving skills, so I chose a few array based algorithm problems that I would solve, and slowly increase the 
   difficulty as I get further. In general, this lab and future labs will reflect on my interest in algorithms and problem solving 
   as I improve these skills. 
      
*/
public class Lab20b
{
	public static void main(String[] args) {
		
      int[] array = {0, -3, 5, -4, -2, 3, 1, 0 };
      int n = array.length;      
      System.out.println("Calculating equilibrium indexes... ");
      System.out.println(Program.FindEquilibrium(array));
      Program.QuickSort(array, 0, n - 1 );
      
      System.out.println("Sorting array using quicksort... ");
      System.out.println(Arrays.toString(array));
      Program.Rearrange(array);
      
      System.out.println("Rearranging array...");
      System.out.println(Arrays.toString(array));
      Program.QuickSort(array, 0, n - 1);
      
      int[] array2 = {0, 1, 2, 4, 5, 6, 7};
      System.out.println("Calculating the smallest missing number in array " + Arrays.toString(array2) + "...");
      System.out.println(Program.FindSmallestMissingNumber(array2, 0, array2.length - 1));
      
      int[] array3 = {1, 2, 3, 4, 5, 6, 7};
      int sum = 7;
      System.out.println("Finding nearest pair that adds up to " + sum + " in the array " + Arrays.toString(array3) + "...");
      System.out.println(Program.FindAdditionPairs(array3, sum));

      
      
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
      ArrayList<Integer> index = new ArrayList<Integer>();
      int rightSum = 0;
      for(int i = array.length - 1; i >= 0; i--){
         //if sum from right array equals sum from left array
         if(rightSum == total - (array[i] + rightSum)){
            index.add(i);
         }
         
         //add current array element to the right sum
         rightSum += array[i];
      
      }
      if(index.size() == 0){
         return "no indices were found";
      
      }
      else{
      //just so that we can return an array, then convert it into a string
         int[] indexArray = new int[index.size()];
         int count = 0;
         for(int i : index){
            indexArray[count] = i;
            count++;
            
         }
         return Arrays.toString(indexArray);
      }
   }
   
   //depends on the array being already sorted, and element values match their index number. Basically a modified binary search
   public static int FindSmallestMissingNumber(int[] array, int low, int high){
      
      if(low > high){
         return low;
      
      }
      int middle = low + (high - low) / 2;
      
      if(middle == array[middle]){ //must be on the right side
         return FindSmallestMissingNumber(array, middle + 1, high);
      }
      else{ //must be on the left side
         return FindSmallestMissingNumber(array, low, middle - 1);
      }
   
   }
   //finds a pair within the given array that adds up to the given sum
   public static String FindAdditionPairs(int[] array, int sum){
      //sort the array in ascending order first using quicksort
      QuickSort(array, 0, array.length - 1);
      int start = 0;
      int end = array.length - 1;
      int[] pair = new int[2];
      
      //increment start if the resultant sum is too less, otherwise decrement end if resultant sum is too high
      while(start < end){
      if(array[start] + array[end] == sum){
         pair[0] = array[start];
         pair[1] = array[end];
         return Arrays.toString(pair);
      
      }
      if(array[start] + array[end] < sum){
         start++;
      
      }
      else{
         end--;
      }
      
      }
      
      return "No pair was found that adds up to that sum!";
      
      
   }
   

   
   
}   
   
   
   
