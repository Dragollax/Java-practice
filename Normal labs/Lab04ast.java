// Lab04ast.java
// The Mortgage Payment Program
// This the student, starting version of the Lab04a assignment.
import java.text.DecimalFormat;
public class Lab04ast
{
	public static void main(String[ ] args)
	{
		System.out.println("Lab04a, Student Version\n");
		double principal  = 250000;
		double annualRate = 4.85;
		double numYears   = 30;
      double i = (annualRate / 100) / 12;
      double n = numYears * 12;
      double sum1;
      double sum2;
      double sum3;
      double TotalP;
      double TotalI;
      
      //M = P[i(1+i)^n] / [(1+i)^n - 1]
      sum1 = principal *(i * Math.pow((1+i), n)); //first calculate first half, P[i(1+i)^n]
      sum2 = Math.pow((1+i), n) - 1; // then calculate second, [(1+i)^n - 1]
      sum3 = (sum1 / sum2); ///then get the quotient of the two
      TotalP = sum3 * (numYears* 12);
      TotalI = TotalP - principal;               //sets the format
      DecimalFormat Formatter = new DecimalFormat("0.00"); //creates new DecimalFormat on the heap
      String FormatSum3 = Formatter.format(sum3); //uses newly created instance/class to call format, which takes a parameter, in this case is TotalP
      String FormatTotalP = Formatter.format(TotalP);
      String FormatTotalI = Formatter.format(TotalI);

      System.out.println("Principal: " + principal );
      System.out.println("annual rate: " + annualRate + "%");
      System.out.println("Number of Years: " + numYears);
      System.out.println("Monthly Payment: $" + FormatSum3);
      System.out.println("Total Payments: $" + FormatTotalP);
      System.out.println("Total Interest: $" + FormatTotalI);


      
     

		System.out.println();
	}
}
         