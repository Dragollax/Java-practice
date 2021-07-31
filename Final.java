import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

/*
   Lab 22 final
   Point version: Aimed for highest possible
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
    }
    
	}

class lab{
    public static boolean StringPat(String str, int i, String pat, int j, Map<Character, String> map){
        int n = str.length(), m = pat.length();
 
        // base condition
        if (n < m) {
            return false;
        }
 
        // if both pattern and the string reaches the end
        if (i == n && j == m) {
            return true;
        }
 
        // if either string or pattern reaches the end
        if (i == n || j == m) {
            return false;
        }
 
        // consider the next character from the pattern
        char curr = pat.charAt(j);
 
        // if the character is seen before
        if (map.containsKey(curr))
        {
            String s = map.get(curr);
            int k = s.length();
 
            // `ss` stores next `k` characters of the given string
            String ss;
            if (i + k < str.length()) {
                ss = str.substring(i, i + k);
            }
            else {
                ss = str.substring(i);
            }
 
            // return false if the next `k` characters don't match with `s`
            if (ss.compareTo(s) != 0) {
                return false;
            }
 
            // recur for remaining characters if the next `k` characters match
            return StringPat(str, i + k, pat, j + 1, map);
        }
 
        // process all remaining characters in the string if the current
        // character is never seen before
        for (int k = 1; k <= n - i; k++)
        {
            // insert substring formed by next `k` characters of the string
            // into the map
            map.put(curr, str.substring(i, i + k));
 
            // check if it leads to the solution
            if (StringPat(str, i + k, pat, j + 1, map)) {
                return true;
            }
 
            // otherwise, backtrack – remove the current character from the map
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
      if(i.length() != j.length(){
         return false;   
      }
      Map<Character, Character> map = new HashMap<>();
      
      Set<Character> set = new HashSet<>(); //no duplicates!
      
      for(int i = 0; i < i.length(); i++){
         char x = i.charAt(i);
         char y = j.charAt(i);
         
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
    
}
