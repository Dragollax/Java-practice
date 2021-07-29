import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
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
    
}
