import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;

/*
   Lab 22 final
   Point version: Aimed for highest possible
   Description:
      For this final project, I wished to demonstrate my skills as I increased the difficulty of the lab once more. This time, I learnt
   and experimented with a lot of things. This final project took me a much longer time to do than the other previous labs as the level
   of difficulty was increased by quite a bit, as I approached new famous problem sets, new algorithms, and new built in functions offered
   by java such as the "stack" and sets.
*/


public class Final
{
	public static void main(String[] args) {
		  String str = "codesleepcode";
        String pat = "XYX";
 
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
            System.out.println("Solution doesn't exist");
        }
        char[] pattern = "1?11?00?1?".toCharArray();
        lab.FindAllComb(pattern, 0);
        System.out.println(lab.FindPBalance("((()()"));
        String s = "Reverse me";
 
        s = lab.Reverse(s);
        System.out.println(s);
 
        String X = "ACAB";
        String Y = "XCXY";
 
        if (lab.Isomorphic(X, Y)) {
            System.out.println(X + " and " + Y + " are Isomorphic");
        }
        else {
            System.out.println(X + " and " + Y + " are not Isomorphic");
        }
        System.out.println(lab.CheckString("xyz", "xz"));     // true
        System.out.println(lab.CheckString("xyz", "xxx"));    // false
        
        String n = "ABC";
        String k = "DEF";
        String string = "ADEBCF";
         
        Map<String, Boolean> m = new HashMap<>();
        if (lab.Interleaves(n, k, string, m)) {
            System.out.print("Given string is an interleaving of X and Y");
        }
        else {
            System.out.print("Given string is not interleaving of X and Y");
        }
    }
    
    
	}

class lab{
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
      
      }
}
