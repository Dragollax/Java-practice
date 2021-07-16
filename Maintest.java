import java.util.*;
public class Maintest
{
	public static void main(String[] args) {
		MyBank tom = new MyBank(3000.0);
		System.out.println("Tom's checking balance: " + tom.getCheckingBalance());
		tom.makeCheckingDeposit(1000.0);
		System.out.println("Tom's checking balance: " + tom.getCheckingBalance());
		tom.makeCheckingWithdrawal(5000.0);
		System.out.println("Tom's checking balance: " + tom.getCheckingBalance());

	
}
}
interface Bank
{
	public double getCheckingBalance();
	public void makeCheckingDeposit(double amount);
	public void makeCheckingWithdrawal(double amount);
}
class MyBank implements Bank
{
	private double checking;
	public MyBank(double c)					{ checking = c;}
	public double getCheckingBalance()			{ return checking; }
	public void makeCheckingDeposit(double amount)		{ checking -= amount; }
	public void makeCheckingWithdrawal(double amount)	{ checking += amount; }
}