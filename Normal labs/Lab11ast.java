// Lab11ast.java
// The "Sieve of Eratosthenes" Program
// 2017-01-24
// THIS IS THE IMPROVED STUDENT STARTING FILE WITH COMMENTS AND HINTS. CR

import java.util.Scanner;
import java.text.DecimalFormat;
public class Lab11ast
{
	public static void main(String[] args)
	{
   
		System.out.println("\nLab11a 100 point version\n");
      Scanner input = new Scanner(System.in);
		System.out.print("Enter the primes upper bound  ===>>  ");
      final int MAX = input.nextInt();
		boolean primes[] = new boolean[MAX];   // Array to hold primes, true or false.
                                             // The index of the array represents each number. 
                                             // The value stored at each index is true or false, prime or not prime.
		computePrimes(primes, MAX);
		displayPrimes(primes, MAX);
	}

	public static void computePrimes(boolean[] primes, int n)
	{
		System.out.println("\nCOMPUTING PRIME NUMBERS");
      boolean prime[] = primes;
        for (int i = 0; i < n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p < n; p++) 
        {
          
            if (prime[p] == true) 
            {
           
                for (int i = p * p; i < n; i += p)
                    prime[i] = false;
            }
        }
      
      // See the word document for Steps 1-4.
      // Step 1: A for-loop to set all of numbers in the array from 2 to 100 to true,
      // whether prime or not.
      // Step 2: A for-loop to run through all of the numbers in the array.
            // A for-loop inside the above for-loop to check each number, starting with 2.
            // If it is prime, change all of its multiples to not prime.
      // Step 3-4: Process repeats until MAX is reached.
   }

	public static void displayPrimes(boolean[] primes, int n)
	{
		System.out.println("\n\nPRIMES BETWEEN 1 AND "+ primes.length);
		System.out.println();
      DecimalFormat df = new DecimalFormat();
      df.applyPattern("0000");
   for (int i = 2; i < n; i++)
        {   
            Integer tool = i;
            if (primes[i] == true){
             
                System.out.print(df.format(tool) + " ");
          
             }
                
        }
      // A for-loop to print each index if prime.
	}
}