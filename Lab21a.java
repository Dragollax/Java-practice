import java.io.*;
import java.util.*;
/*
   Lab 21a
   Point Version: aimed for 100
   Description: 
      This lab is a continuation on the Algorithm programming challenges like previous labs, and the addition of Tuples. First,
      the program will rotate the array, so that from a certain index, all the numbers before that index will be reversed. 
      E.g.[1,2,3,4,5] -> [4,3,2,1,5]. Then, a function will return which index the array was rotated at. In the previous example:
      index 3. Then, the program will find a triplet that is already in ascending order. E.g [2,5,3,6,2,8] in this case, the first
      triplet in ascending order is 2, 3, 6. Finally, the program will take a number, and find all the possible number combinations
      that add up to the given number. E.g. Given 2, the possible combinations are (1, 1) and (2). The main inspiration of this lab
      came from the tuple. When I first learned Python after C++, I learnt about tuples. I used them a lot when I used python for 
      web development(django and reactjs). And not too long ago, I learnt that Java also had this too. So for this lab, I challenged
      myself into implementing it within a algorithmic programming challenge, and explaining how every part works. As for the rest 
      of what the program does, I found them to be interesting because of the surprising difficulty to code out, and so they took a 
      longer time to code. I found my skills as a programmer increase significantly through this lab, as I learnt quite a few tricks 
      that I did not pick up on before. In summary, this lab taught me both tuples, and intelligent tricks that you can use to shorten
      the code of a program.


*/
public class Lab21a
{
	public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5, 6, 7, 8};   
      
      System.out.println("Original array: ");
      System.out.println(Arrays.toString(array));
      System.out.println("Rotating the array...");
	   SubClass.ReverseArray(array, 5);
      System.out.println(Arrays.toString(array));
      
      System.out.println("Now finding where the the array was rotated...");
      int index = SubClass.FindRotations(array);
      if(index == -1){
         System.out.println("This array was not rotated at all!");
      }
      else{
         System.out.println("This array was rotated at index " + index);
      }
      //note that this will print 1, 7, 8 because the array was rotated
      System.out.println("Finding sorted triplet in array " + Arrays.toString(array) + "...");
      Tuple<Integer, Integer, Integer> triplet = SubClass.FindTriplet(array);
      
      if(triplet != null){          
       System.out.println("The triplets are " + triplet.first + " " + triplet.second + " " + triplet.third + " ");
      
      }      
      else{
         System.out.println("No triplets were found!");
      }

      
      int num = 5;
      System.out.println("Finding all possible sum combinations of number " + num + "...");
      SubClass.FindAllSumCombination(num);
      

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
   
   public static void Find(int[] array, int passed, int number, int index){
      
      if(passed < 0){//if difference gets less than 0
         return;
      }
      
      if(passed == 0){ // we have a combination if the difference reaches to exactly 0
         for(int i = 0; i < index; i++){
            System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
         
         
         
      }
      // if index == 0, set previous to 1, else set previous to the last element 
      int previous = (index == 0) ?  1 : array[index - 1];      
       
      //for loop based off of the elements of passed in array
      for(int j = previous; j <= number; j++){
         array[index] = j;
         //recurse by incrementing the index by 1 for the array, and subtracting the difference by j;
         Find(array, passed - j, number, index + 1);
         
      }
   }
   
   public static void FindAllSumCombination(int n){
   
      int[] array = new int[n];// base: 1 x n will be the max numbers in total  
      
      Find(array, n, n, 0);
      
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
   //have lowest, second lowest, and highest of whatever variable
   public static Tuple<Integer, Integer, Integer> FindTriplet(int[] array){
      int least = 0;
      int mid = 0;
      int lowest_index = 0;
      
      for(int i = 1; i < array.length; i++){
         if(array[i] <= array[lowest_index]){
            lowest_index = i;
                     
         }
         //to prevent mid and least from ending up with the same index
         else if (mid == 0){
            least = lowest_index;
            mid = i;
         }
         //if new index for mid is found
         else if(array[i] < array[mid]){
            mid = i;
         
         }
         else{
            //create a tuple once we have created the triplet
            return Tuple.of(array[least], array[mid], array[i]);
         
         }
      
      
      }
      return null;
   }

}
//for creating a tuple, and using first, second, and third to print it
class Tuple<X,Y,Z>
{
    public final X first;      
    public final Y second;      
    public final Z third;      
 
    // Constructs a new Tuple with specified values
    private Tuple(X first, Y second, Z third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    //so we can use .of() to create a tuple
    public static <X, Y, Z> Tuple <X, Y, Z> of(X a, Y b, Z c)
    {
        return new Tuple<>(a, b, c);
    }

}
