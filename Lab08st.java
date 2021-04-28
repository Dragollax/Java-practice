// Lab08st.java
// The "Palindrome" Program
// This is the student starting file for Lab08.

import java.util.Scanner;

public class Lab08st
{
	public static void main (String args[])
	{
		System.out.println("\nLab08v80\n");
      Scanner input = new Scanner(System.in);
		boolean notFinished = false;
		do
		{
			System.out.print("Enter a string  ===>>  ");
			String str = input.nextLine();
			System.out.println();
			System.out.println("Entered String:     " + str);
			System.out.println("Palindrome:         " + Palindrome.isPal(str));
         //System.out.println(Palindrome.isLetter(str)); this was put here for tests
         //System.out.println(Palindrome.purge(str)); this was also put here for tests
			System.out.println("Almost Palindrome:  " + Palindrome.almostPal(str));	  // used only for the 100 point version
			System.out.print("Do you wish to repeat this program [Y/N]?  ===>>  ");
         
			String repeat = input.nextLine();
			notFinished = (repeat.equals("Y")) || (repeat.equals("y"));
			System.out.println();
		}
		while (notFinished);
	}
}



class Palindrome
{
	/*
	 * Precondition:  s is an arbitrary String.
	 * Postcondition: The value of true is returned if s is a Palindrome, false otherwise.
    * Note:          >>>>> This method is required for both the 80 point and the 100 point versions  <<<<<
	 */
	public static boolean isPal(String s)
	{
  String lower = s.toLowerCase();
   String reversed = reverseString(lower);
   if (lower.equals(reversed)) {
            return true;  
        } else {
            return false;
        }
   
   	}  
      //reverse string
   public static String reverseString(String input) {

        StringBuffer buffer = new StringBuffer();
        buffer.append(input);

        return buffer.reverse().toString();
    }
   
   /*
	 * Precondition:  s is a String of one character.
	 * Postcondition: The value of true is returned if s is a letter and false otherwise.
    * Note:          >>>>> This method is only completed for the 100 point version  <<<<<
	 */
   public static boolean isLetter(String letter)
   {
         String newLetter = letter.toLowerCase();
   
      return newLetter.compareTo("a") >= 0 && newLetter.compareTo("z") <= 0;
   
   
   } 
   
	/*
	 * Precondition:  s is an arbitrary String.
	 * Postcondition: All non-letter characters are removed from s, and this "purged" String is returned.
    * Note:          >>>>> This method is only completed for the 100 point version  <<<<<
	 */
	public static String purge(String s)
	{
      s.trim();
      
      String newString = "";
    for(int i = 0; i < s.length(); i++) {     
      
      if(isLetter(s.substring(i, i+1))) {
         
       newString += s.substring(i, i+1);
         
         }
      
      }   
   
      return newString;   
        // This statement is provided to allow initial compiling.
	}
  
   
   /*
	 * Precondition:  s is an arbitrary String.
	 * Postcondition: After purging all non-letter characters from s,
	 *                the value of true is returned if the resulting String is a Palindrome, false otherwise.
    * Note:          >>>>> This method is only completed for the 100 point version  <<<<<
	 */
	public static boolean almostPal(String s)
	{
              String news = purge(s);
   String reversed = reverseString(news);
   if (news.equals(reversed)) {
            return true;  
        } else {
            return false;
        }
     // This statement is provided to allow initial compiling.
	}

}
