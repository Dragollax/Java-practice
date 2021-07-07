/*
   Lab 17b substitute
   Lab: reverse a string that the user enters by converting it into an array of chars using recursion, then reversing the array using recursion      

*/
import java.util.Scanner; 
public class Main{
   public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word or phrase you want to reverse");
        String input = in.nextLine();
        char[] initial = new char[GetLength(input)];
        char[] newArr = ToArray(input, initial);
        reverse(newArr, 0, newArr.length - 1);
        input = new String(newArr);
      
        System.out.print("The reverse of this word/phrase is " + input);
    }
    
    //function for swapping
    private static void swap(char[] c, int i, int j)
    {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
 
    //Recursive function to swap a char[] array
    public static void reverse(char[] c, int low, int high)
    {
        if (low < high)
        {
            swap(c, low, high);
            reverse(c, low + 1, high - 1);
        }
    }
   static int count = 0;
   static int count2 = 0;
   
    //recursive function to convert a string to a char[] array
    public static char[] ToArray(String words, char[] arr){
      if(count2 == 0){
         arr = new char[words.length()];
         count2++;
      }
      
      while(count < words.length()){
         
         arr[count] = words.charAt(count);
         count++;
         ToArray(words, arr);//recursion
         
      } 
      return arr;
    
    }
    public static int GetLength(String words){
      return words.length();
    
    }
 
  }