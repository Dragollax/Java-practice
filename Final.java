import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
   Lab 22 final
   Point version: Aimed for highest possible
   Description:
      For this final project, I wished to demonstrate my skills as I increased the difficulty of the lab once more. This time, I learnt
   and experimented with a lot of things. This final project took me a much longer time to do than the other previous labs as the level
   of difficulty was increased by quite a bit, as I approached new famous problem sets, new algorithms, and new built in functions offered
   by java such as the "stack" and sets. The length of this project is more than 2x the length of the previous labs I have submitted. As for
   the difficulty, a lot of these algorithms were greatly more difficult than the previous algorithms I have written. One reason for which
   was because I challenged myself with 2d arrays/matrix algorithms. It involved intuitive ways of solving a problem that took me hours to 
   figure and code out. It took many hours of frustration, thinking, and excitement to figure out ways to code and debug the programs that 
   I wrote for this project. Overall, this was a great final project that reflected the many ways I have learnt and (kind of) mastered java. 
   This final project can be compared to when I first started doing labs in AP Computer Science A to see an extreme improvement in programming. 
   I have learnt a lot through this course, and am grateful for all the opportunities I was given to practice programming. 
   Thank you! - Kevin Zhang
   
   Guide:
   1 - Enter a string, then a pattern, the program will see if it is possible to match the string to the given pattern
   2 - Given a binary char array with 1's and 0's, there will be a few ?'s which will be replaced with either 1 or 0. The program will calculate
   the total possible combinations of arrays there can be. This one was not made for user input because of the chaos it could cause, and there 
   wasn't really a necessity in doing so
   3 - Given a string of parenthesis e.g. ()()()()))(((, The program will find the greatest number of balanced parenthesis. In this case, 8
   4 - Reverse a string, but using the stack instead of recursion or iteration like normally
   5 - Enter two strings, the program will find if they are isomorphic or not
   6 - Given two strings, the program will find if they can be made identical by inserting a single character. 
   7 - Given 3 strings (2 of which are substrings), see if the first two strings are interleaving of the third string. E.g. String ABC and string 
   DEF are interleaving of the string ABCDEF
   8 - Given two strings, check how many times the second string appears in the first string
   9 - Given a string, see how many deletions are required to make it a palindrome
   10 - Check if an array can be partitioned(split) to add up to the same value on both sides
   
*/


public class Final
{
	public static void main(String[] args) {
        System.out.println("Welcome to Kevin's Final Lab! The following are options to see what you can do here! Type 8 to exit the lab!");
        System.out.println("1- See if a string can match a specific pattern 2- find out how many binary combinations there can be by replacing a ? in a given string");
        System.out.println("3 - find the longest balanced parenthesis pair in a given string 4- reverse a string using the stack");
        System.out.println("5- Check if two strings are isomorphic 6- check if you can match two strings by inserting a single character");
        System.out.println("7- Check if a string interleaves two substrings 8- check how many times a given string appears in another string");
        System.out.println("9- find the minimum number of deletions to change string into a palindrome 10- check if an array can be partitioned to add up to the same value");
        Scanner next = new Scanner(System.in);
        int input = next.nextInt();
        while(input != 0){
        switch(input){
        case 1:
           Scanner one = new Scanner(System.in);
           System.out.println("Enter a String");
           String str = one.nextLine();
           System.out.println("Enter a pattern you want to match the string to");
           String pat = one.nextLine();
    
           // create a map to store mappings between the pattern and string
           Map<Character, String> map = new HashMap<>();
    
           // check for solution
           if (lab.StringPat(str, 0, pat, 0, map))
           {
               for (Map.Entry<Character, String> entry: map.entrySet()) {
                   System.out.println(entry.getKey() + ": " + entry.getValue());
               }
           }
           else {
               System.out.println("This string can't be matched with this pattern!");
           }
           lab.PrintDirections();
           input = next.nextInt();
           break;
        case 2:
           System.out.println("This one was not made to be user input because of the chaos it creates if not done properly");
           System.out.println("The default binary pattern is: 1?11?00?1?");
           char[] pattern = "1?11?00?1?".toCharArray();
           lab.FindAllComb(pattern, 0);
           lab.PrintDirections();
           input = next.nextInt();
           break;
           
        case 3:
        Scanner three = new Scanner(System.in);
        System.out.println("Enter a few pairs of parenthesis");
        String para = three.nextLine();
        System.out.println("The longest number of balanced parenthesis is " + lab.FindPBalance(para));
        lab.PrintDirections();
        input = next.nextInt();

        case 4:
        Scanner four = new Scanner(System.in);
        System.out.println("Enter a string to reverse");
        String reverse = four.nextLine();
 
        reverse = lab.Reverse(reverse);
        System.out.println(reverse);
        lab.PrintDirections();
        input = next.nextInt();
        break;
        case 5:
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first string");
        String X = in.nextLine();
        System.out.println("Enter the second string");
        String Y = in.nextLine();
        if (lab.Isomorphic(X, Y)) {
            System.out.println(X + " and " + Y + " are Isomorphic");
        }
        else {
            System.out.println(X + " and " + Y + " are not Isomorphic");
        }
        lab.PrintDirections();
        input = next.nextInt();
        break;
        case 6:
           Scanner six = new Scanner(System.in);
           System.out.println("Enter the first string");
           String onee = six.nextLine();
           System.out.println("Enter the second string");
           String two = six.nextLine();           
           if(lab.CheckString(onee, two)){
               System.out.println("you can match the following entered string by just inserting one char");
           }
           else{
               System.out.println("you cannot match the following entered string by just inserting one char");

           }
           lab.PrintDirections();
           input = next.nextInt();
           break;
        case 7:
           Scanner seven = new Scanner(System.in);
           System.out.println("Enter the first string");
           String n = seven.nextLine();
           System.out.println("Enter the second string");
           String k = seven.nextLine();
           System.out.println("Enter the general string");
           String string = seven.nextLine();
           Map<String, Boolean> m = new HashMap<>();
           if (lab.Interleaves(n, k, string, m)) {
               System.out.println("The general string string is an interleaving of X and Y");
           }
           else {
               System.out.println("The general string is not interleaving of X and Y");
           }
           lab.PrintDirections();
           input = next.nextInt();
           break;
        case 8:
           Scanner eight = new Scanner(System.in);
           System.out.println("Enter the first string");
           String a = eight.nextLine();
           System.out.println("Enter the second string");
           String b = eight.nextLine();
        
           System.out.println(lab.CountString(a, b));
           lab.PrintDirections();
           input = next.nextInt();  
           break;
        case 9: 
           Scanner nine = new Scanner(System.in);
           System.out.println("Enter a String");
           String lol = nine.nextLine();
           int len = lol.length();
    
           System.out.println("The minimum number of deletions required is " +
                                   lab.MinDel(lol, len));
           lab.PrintDirections();
           input = next.nextInt();   
           break;
        case 10:
           System.out.println("Enter size for array you wish to fill");
           Scanner ten = new Scanner(System.in);
           int size = ten.nextInt();
           int i = 0;
           int[] Arr = new int[size];
           while(i < size){
              System.out.println("Enter number to fill array: ");
              int inputt = ten.nextInt();
              Arr[i] = inputt;
              i++;
           }
    
           if (lab.partition(Arr)) {
               System.out.println("This array can be partitioned");
           }
           else {
               System.out.println("This array cannot be partitioned");
           }
           lab.PrintDirections();
           input = next.nextInt();
           break;
        default:
           lab.PrintDirections();

           input = next.nextInt();
        }
        }

    }
    
	}

class lab{
    public static void PrintDirections(){
        System.out.println("1-Manipulate a string so that it matches a given pattern 2- find out how many binary combinations there can be by replacing a ? in a given string");
        System.out.println("3 - find the longest balanced parenthesis pair in a given string 4- reverse a string using the stack");
        System.out.println("5- Check if two strings are isomorphic 6- check if you can match two strings by inserting a single character");
        System.out.println("7- Check if a string interleaves two substrings 8- check how many times a given string appears in another string");
        System.out.println("9- find the minimum number of deletions to change string into a palindrome 10- check if an array can be partitioned to add up to the same value");
    
    }
    public static boolean StringPat(String str, int i, String pat, int j, Map<Character, String> map){
        int n = str.length();
        int m = pat.length();
 
        // base condition
        if (n < m){
            return false;
        }
 
        // if both pat and string str reach the end
        if (i == n && j == m){
            return true;
        }
 
        // if either string str or pat reaches the end
        if (i == n || j == m){
            return false;
        }
 
        //make the current char the next character in pat
        char curr = pat.charAt(j);
 
        //if the character has been seen before
        if (map.containsKey(curr)){
            String s = map.get(curr);
            int k = s.length();

            String ss;
            if (i + k < str.length()){
                //store the next k characters within ss
                ss = str.substring(i, i + k);
            }
            else{
                ss = str.substring(i);
            }
 
            
            //if the next k characters done match with s, return false
            if (ss.compareTo(s) != 0){
                return false;
            }
 
            //recurse for remaining characters if they do match 
            return StringPat(str, i + k, pat, j + 1, map);
        }
 
        
        //if character is never seen before
        for (int k = 1; k <= n - i; k++){
            //insert substring off the next k characters into the map
            map.put(curr, str.substring(i, i + k));
 
            // check if it leads to the solution
            if (StringPat(str, i + k, pat, j + 1, map)){
                return true;
            }
 
            // otherwise, backtrack and remove curr character from map
            map.remove(curr);
        }
 
        return false;
    }
    
    public static void FindAllComb(char[] pattern, int i){
      if(i == pattern.length){
         System.out.println(pattern);
         return;
      
      }
      if(pattern[i] == '?'){
         for(char c = '0'; c <'2'; c++){
            pattern[i] = c;
            
            FindAllComb(pattern, i + 1);
            
            pattern[i] = '?';
         
         }
         return;
      }
      FindAllComb(pattern, i + 1);
    
    }
    public static int FindPBalance(String str){
     
      Stack<Integer> stack = new Stack<>();
      
      stack.push(-1);
      
      int len = 0;
      
      for(int i = 0; i < str.length(); i++){
         
         if(str.charAt(i) == '('){
            //push the value in the stack
            stack.push(i);
         }
         //if its a closing parenthesis
         else{
         //remove previous opening parenthesis from stack
            stack.pop();
            
            if(stack.empty()){
               stack.push(i);
               continue;
            }
            
            //longest balanced parenthesis ending at current character, which is top of stack
            int clen = i - stack.peek();
            
            //update the length if clen is longer
            if(len < clen){
               len = clen;
            }
         }
      }
      return len;
    }
    
    public static String Reverse(String str){
      
      Stack <Character> stack = new Stack<>();
      
      char[] c = str.toCharArray();
      for(char s: c){
         stack.push(s);
      }  
      
      for(int i = 0; i < str.length(); i++){
         //take the first element from the stack and put it into the char array
         c[i] = stack.pop();
      }
      
      //convert back to string and return
      return new String(c);
    }
    
    public static boolean Isomorphic(String i, String j){
      if(i.length() != j.length()){
         return false;   
      }
      Map<Character, Character> map = new HashMap<>();
      
      Set<Character> set = new HashSet<>(); //no duplicates!
      
      for(int n = 0; n < i.length(); n++){
         char x = i.charAt(n);
         char y = j.charAt(n);
         
         //if character x has been seen before
         if(map.containsKey(x)){
            //if the character x is not the same as character y
            if(map.get(x) != y){
               return false;
            }
         
         }
         //if x hasnt been seen
         else{
            //if y has already been seen, it means that its already linked to a char in string i
            if(set.contains(y)){
               return false;
            }
            
            map.put(x, y);
            set.add(y);
         
         }
         
      }
      return true;
    }
      public static boolean CheckString(String start, String next){
         int i = start.length();
         int j = next.length();
         
         //lengths must not be shorter than each other by more than 1
         if(Math.abs(i - j) > 1){
            return false;
         
         }
         
         //keep track of number of times changed
         int change = 0;
         //keep track of current indexes
         int m = 0;
         int n = 0;
         
         while(m < i && n < j){
            
            //if m'th char of start is the same as n'th char of next, do nothing and move on
            if(start.charAt(m) == next.charAt(n)){
               m++;
               n++;
            
            }
            //if theyre not the same
            else{
            //if string i is longer than string j
            if(i > j){
               m++; //go one forward with m, which represents current char of i
               }
            //opposite of above
            else if(i < j){
               n++;
            }
            //if string i and string j are both the same length
            else{
               m++;
               n++;
            }
               //increment the number of changes 
               change++;
            
            }
         
         }
         //remaining characters
         if(m < i){
            change++;
         }
         
         if(n < j){
            change++;
         }
         return (change == 1);
      
      }
      //dynamic programming approach to solution
      public static boolean Interleaves(String i, String j, String s, Map<String, Boolean> map){
         //if we've reached the end of all strings
         if(i.length() == 0 && j.length() == 0 && s.length() == 0){
            return true;
         }
         //if we reached the end of main string s, but not i or j...clever trick based off of the top part
         if(s.length() == 0){
            return false;
         }
         //create a unique key
         String key = (i + "|" + j + "|" + s);
         
         //if key hasnt been seen before
         if(!map.containsKey(key)){
            //recurse for the remainder of the substring i and j if satisfies both conditions
            //this makes it so that it will recurse either x or y, saving the progress on each side 
            boolean x = (i.length() != 0 && s.charAt(0) == i.charAt(0)) && Interleaves(i.substring(1), j, s.substring(1), map);
            boolean y = (j.length() != 0 && s.charAt(0) == j.charAt(0)) && Interleaves(i, j.substring(1), s.substring(1), map);
            //to handle duplicates, example: ACDABC, C is a duplicate, if either x or y is true, then this works
            map.put(key, x || y);
         }
        
         return map.get(key);
      }
      public static int CountString(String i, String j){
         int m = i.length();
         int n = j.length(); //5
         
         int[][] M = new int[m + 1][n + 1];
         
         //no pattern was found; no string was provided
         for(int x = 0; x <= n; x++){
            M[0][x] = 0;
         
         }
         //one pattern was found; no pattern was provided
         for(int x = 0; x <= m; x++){
            M[x][0] = 1;
         }
         /*
         illustration of algorithm using matrix with "dry" and "dirty'
           d r y
         1 0 0 0
       d 1 1 0 0 one match, add 1 with previous row of 0
       i 1 1 0 0 no match, keep original value of 1 by adding 1 from previous row
       r 1 1 1 0 one match, add previous row, h - 1, with previous row, h
       t 1 1 1 0
       y 1 1 1 1 <- this is the final answer, of M[m][n], as 
                    it is the last value, and the loop ends there too
       
       */
         
         for(int k = 1; k <= m; k++){
            for(int h = 1; h <= n; h++){
            //if last two characters are the same
               if(i.charAt(k - 1) == j.charAt(h - 1)){
                  //fill the spot of k and h in from the previous row, at h - 1, 
                  //and add h from the previous h, basically adding the original value
                  M[k][h] = M[k - 1][h - 1] + M[k - 1][h];
               }
               else{
                  //keep the original value by adding h from the previous row 
                  M[k][h] = M[k - 1][h];
               }
            }
            
         }
            // returns the bottom right corner, which contains the final answer
            return M[m][n];
      }
      //another difficult matrix algorithmic approach
      public static int MinDel(String x, int n){
         //cool new thing i discovered, exactly copy of x, but reversed
         String y = new StringBuilder(x).reverse().toString();
         int[][] matrix = new int[n + 1][n + 1];
         
         for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
               //if last two characters of the strings match each other,
               if(x.charAt(i - 1) == y.charAt(j - 1)){
                  //same trick as last time, except add 1, since we didnt populate the first values of the rows and columns
                  matrix[i][j] = matrix[i-1][j-1] + 1;
               
               }
               else{
                   //if they don't match, set the current position as either 
                   // i - 1 or j - 1 according to which is bigger, which
                   //should result in containing the longest sequence
                   matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
               }
            
            }
         }
       return n - matrix[n][n];
      }
     
     //same dynamic programming concept, except dealing with booleans this time
     
     public static boolean FindSubset(int[] array, int len, int sum){
        //matrix will store true in a cell if we reach a sum that can be sum j
        boolean[][] matrix = new boolean[len + 1][sum + 1];
        //make the first value of every row true for base condition
        for(int i = 0; i <= len; i++){
           matrix[i][0] = true;
        }
        
        for(int i = 1; i <=len; i++){
           for(int j = 1; j <= sum; j++){
              
              //dont include the i'th element of the array if following j is smaller
              if(array[i - 1] > j){
                 matrix[i][j] = matrix[i-1][j];
              }
              else{
                 //find subset with sum j by excluding or including the i'th element, which
                 //should be a value with "true," given that we made the first value of each 
                 //row of the matrix to be "true"
                 matrix[i][j] = matrix[i - 1][j] || matrix[i - 1][j - array[i-1]];
              }
           }
        
        }
        //return value at bottom right corner
        return matrix[len][sum];
        
     
     }
     
      public static boolean partition(int[] A){
        int sum = Arrays.stream(A).sum();
 
        //return true if sum is even, and can be split into two equal sum sub arrays
        return (sum & 1) == 0 && FindSubset(A, A.length, sum/2);
    }
}
