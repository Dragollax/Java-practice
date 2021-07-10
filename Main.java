/*
   String manipulation lab
   Lab 17b substitute
   Lab: Reverse a string that the user enters by converting it into an array of chars using recursion, then reversing the array by swapping using recursion
        Then, check if the word is a palindrome using a recursive function to do so. Then, print all possible variations of the string possible
        Point version: 110 if possible, for the complexity of what is written
   
   There are 5 recursive functions: GetLength() which returns length of string, ReverseString() which reverses the string, IsPalindrome() that checks
   if the string is a palindrome, ToArray() that converts the string into an array of chars, and PrintAllPossible( that prints all the possible variations
   of the entered string WARNING: anything above 3 letters will cause chaos since the number of possibities is n^n!!

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
        int length = newArr.length;
        ReverseString(newArr, 0, newArr.length - 1);
        input = new String(newArr);
        boolean isPal = IsPalindrome(input);
        System.out.println("The reverse of this word/phrase is " + input);
        if(isPal == true){
            System.out.println("The word/phrase is a palindrome");
            System.out.println(length);
        }
        else{
            System.out.println("The word/phrase is not a palindrome");
        }
        PrintAllPossible(newArr, "", length, length);
         
        
    }
    
    //function for swapping
    private static void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    //Recursive function to swap a char[] array
    public static void ReverseString(char[] arr, int low, int high)
    {
        if (low < high)
        {
            swap(arr, low, high);
            ReverseString(arr, low + 1, high - 1);
        }
    }
   static int count = 0;
   static int count2 = 0;
   
    //conversion from string to char array using recursion
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
      if(words.equals("")){
         return 0;
      }
      
      return 1 + GetLength(words.substring(1));
      
    
    }
    public static boolean IsPalindrome(String s){
    
       //if string is down to one letter
       if(s.length() == 1 || s.length() == 0){
         return true;
       }
       
       //if character does not match with each other
       if(s.charAt(0) != s.charAt(s.length() - 1)){
         return false;
       }
       
       //if two characters match
       else{                     
         //if start and end match, proceed to the next first and last letters to see if they're the same
         return IsPalindrome(s.substring(1, s.length() - 1));
       
       }
       
    }
    
    //base: for an entered string n, there will be n^k possible variations of that string. String has to be converted into char array first
    static void PrintAllPossible(char[] arr, String p, int n, int k){
    
      if(k == 0){
          System.out.println(p);//after n is maxed, print out the string p that contains all previous chars from previous loops
          return; //break out of the recursion loop 
      }
      
      for(int i = 0; i < n; ++i){
         String newStr = p + arr[i]; //create new string with passed in initially empty string, plus i-th letter in char[]
         PrintAllPossible(arr, newStr, n, k - 1); //k - 1 times left of possible single variation
      
      }
      
      
      
    }
 
  }