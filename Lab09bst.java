// Lab09bst.java
// The Rational Class Program II
// This is the student, starting version of the Lab09b assignment.


import java.util.Scanner;


public class Lab09bst
{
	private static int num1, den1;   // numerator and denominator of the 1st rational number
	private static int num2, den2;   // numerator and denominator of the 2nd rational number

	public static void main (String[] args)
	{
		enterData();

		Rational r1 = new Rational(num1,den1);
		Rational r2 = new Rational(num2,den2);
		Rational r3 = new Rational();

		r3.multiply(r1,r2);
		System.out.println("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getReduced());
		r3.divide(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getReduced());

   //100 Point Version Only
	r3.add(r1,r2);
   System.out.println("\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getReduced());
	r3.subtract(r1,r2);
	System.out.println("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getReduced());
		System.out.println();
	}

	public static void enterData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the 1st numerator ----> ");
		num1 = input.nextInt();
		System.out.print("\nEnter the 1st denominator --> ");
		den1 = input.nextInt();
		System.out.print("\nEnter the 2nd numerator ----> ");
		num2 = input.nextInt();
		System.out.print("\nEnter the 2nd denominator --> ");
		den2 = input.nextInt();
	}
}


class Rational
{

   private int num;
   private int den;
   private int firstNum;	   // entered numerator
	private int firstDen;	   // entered denominator
	private int reducedNum;		// reduced numerator
	private int reducedDen;		// reduced denominator
   private int gcf;           // greatest common factor
   private String finalfrac = ""; //reduced fraction 
   
   public Rational(){
   num = 1;
   den = 1;
   
   }
   
   
   public Rational(int num, int den){
   this.num = num;
   this.den = den;
}   
  

    public static int gcf(int n1, int n2) { // i rewrote this for better efficiency and less complexity/euclidean algorithm
        if (n2 == 0) return n1;
        else return gcf(n2, n1 % n2);//recursion
    }//get gcf

   public int getNum(){
   
   return num;
   
   
} //obtain numerator   
public int getDen(){

   return den;
   
} //obtain denominator

public String add(Rational a, Rational b){
int anum = a.getNum();

int aden = a.getDen();

int bnum = b.getNum();

int bden = b.getDen();
//times the denominator together

int numerator = anum * bden + bnum *aden;
int denominator = aden * bden;

// then find the gcf

int gcf = gcf(numerator, denominator);

int finalnum = numerator/gcf;
int finalden = denominator/gcf;

String original = returnOriginal(finalnum, finalden);

return finalfrac = original;

}
public String subtract(Rational a, Rational b){

int anum = a.getNum();

int aden = a.getDen();

int bnum = b.getNum();

int bden = b.getDen();

int numerator = anum * bden - bnum *aden;
int denominator = aden * bden;

int gcf = gcf(numerator, denominator);

int finalnum = numerator/gcf;
int finalden = denominator/gcf;

String original = returnOriginal(finalnum, finalden);

return finalfrac = original;

}
public String divide(Rational a, Rational b){
int anum = a.getNum();

int aden = a.getDen();

int bnum = b.getDen(); //swap with numerator because dividing

int bden = b.getNum();

int numerator = anum * bnum;

int denominator = aden * bden;

int gcf = gcf(numerator, denominator);

int finalnum = numerator/gcf;
int finalden = denominator/gcf;
String original = returnOriginal(finalnum, finalden);

return finalfrac = original;

}

public String multiply(Rational a, Rational b){ //multiply fractions and return string version of it
int anum = a.getNum();

int aden = a.getDen();

int bnum = b.getNum();

int bden = b.getDen();

int numerator = anum * bnum;

int denominator = aden * bden;

int gcf = gcf(numerator, denominator);

int finalnum = numerator/gcf;
int finalden = denominator/gcf;
String original = returnOriginal(finalnum, finalden);

return finalfrac = original;

}
private String returnOriginal(int a, int b){ // this is for a tool to be used
     String sn1 = String.valueOf(a);
     String sn2 = String.valueOf(b);
     String original = sn1 + "/" + sn2;
     return original;
}

public String getOriginal(){ //just returned
     String sn1 = String.valueOf(num);
     String sn2 = String.valueOf(den);
     String original = sn1 + "/" + sn2;
     return original;

}//convert into string
public String getReduced(){
return finalfrac;
}//reduce to lowest terms

}
