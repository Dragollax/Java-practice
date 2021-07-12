import java.io.*;
import java.util.*;

public class Lab21a
{
	public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5, 6, 7, 8};   
   
	   SubClass.ReverseArray(array, 5);
      System.out.println(Arrays.toString(array));
      
      int index = SubClass.FindRotations(array);
      if(index == -1){
         System.out.println("This array was not rotated at all!");
      }
      else{
         System.out.println(index);
      }

      System.out.println(Arrays.toString(array));
   
	}
}

class BaseClass{
   
   public static void swap(int[] array, int i, int j){
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   
   }
   
   public static void Reverse(int[] array, int start, int end){
      for(int i = start, j = end; i < j; i++, j--){
         swap(array, i, j);
      
      }
}
   public static void ReverseArray(int[] array, int n){
      //Reverse array from start to given ending point
      Reverse(array, 0, n);
      
   }
   

   
   

}
   
class SubClass extends BaseClass{

   //given that the array was sorted, and rotated n number of times, we
   //can find using binary search where exactly an index where the element in front and behind it is larger
   public static int FindRotations(int[] array){
      int start = 0; 
      int end = array.length - 1;        
      
      while(start <= end){
         if(array[start] >= array[end]){
            return start;
         }
         
         int mid = start + (end - start) / 2; //our current index
         //if it exceeds the limit, make next the first element of the array
         int next = (mid + 1) % array.length; 
         //if it goes below 0, make previous the last element of the array
         int previous = (mid - 1 + array.length) % array.length; 
         
         //2,1,7... index of 1 is the index where it was rotated
         if(array[mid] <= array[next] && array[mid] <= array[previous]){
            return mid;
         }
         
         else if (array[mid] >= array[previous]){
            end = mid + 1;
         }
         else{
            start = mid - 1;
         }
      
      }
      return -1;
   
   }

}