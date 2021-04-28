// Lab09ast.java
// The Rational Class Program I
// This is the student, starting version of the Lab09a assignment.


import java.util.Scanner;


public class Lab09ast
{
	private static int num, den;   // numerator and denominator of the rational number

	public static void main (String[] args)
	{
		enterData();
		Rational r = new Rational(num,den);
		r.displayData();
	}

	public static void enterData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the numerator ----> ");
		num = input.nextInt();
		System.out.print("\nEnter the denominator --> ");
		den = input.nextInt();
	}
}



class Rational
{

   private int gcf;
   private int num;
   private int den;
   
   
   public Rational(int num, int den){
   this.num = num;
   this.den = den;
}   
   
	public void displayData()
	{
		System.out.println();
		System.out.println(getOriginal(num, den) + " equals " + getDecimal(num, den));
      System.out.println();
		System.out.println("and reduces to " + getReduced(num, den));
		System.out.println();
	}

    public static int gcf(int n1, int n2) { // i rewrote this for better efficiency and less complexity/euclidean algorithm
        if (n2 == 0) return n1;
        else return gcf(n2, n1 % n2);//recursion
    }//get gcf

   private int getNum(int n1){
   
   return n1;
   
   
} //obtain numerator   
private int getDen(int n2){

   return n2;
   
} //obtain denominator
private double getDecimal(int n1, int n2){
  double dn1 = n1;
  double dn2 = n2;
  double decimal = dn1/dn2;
  return decimal;
   
}//obtain the result
private String getOriginal(int n1, int n2){
     String sn1 = String.valueOf(n1);
     String sn2 = String.valueOf(n2);
     String original = sn1 + "/" + sn2;
     return original;

}//convert into string
private String getReduced(int n1, int n2){
   int gcf =  gcf(n1, n2);
   int reducednum = n1/gcf;
   int reducedden = n2/gcf;
   String original = getOriginal(reducednum, reducedden);
   return original;
}//reduce to lowest terms

}
