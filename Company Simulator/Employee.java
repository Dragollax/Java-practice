//This is the employee class, all employee methods are managed here
import java.util.Random;
public class Employee{
   Random rand = new Random();
   int upperbound = 999999;
   public int id = rand.nextInt(upperbound); //generates random Employee IDs
   public String name;
   public Integer GeneratedMoney = 0;
   public int salary;
   public Manager manager;
   public Employee(String inputname, int inputsalary, Manager EnteredManager){
   salary = inputsalary;
   manager = EnteredManager;
   name = inputname;
   id = id + 1;
   }
   public Employee(){
   salary = 0;
   name = " ";
   }

   //method 1
   public void GenerateMoney(String word){
      if(!word.equals("") && !word.equals(" ")){
         GeneratedMoney += 100; 
         System.out.println("+100$");
   }
   else{
      System.out.println("Please enter a word!");
   }
   
   }
   //method 2
   public String DisplayGeneratedMoney(){
      String temp = "";
      temp = temp + GeneratedMoney.toString() + "\n";
   
      return temp;
   
 }   
 
 //method 3
 public void ShowProfile(){
   System.out.println("Employee name: " + name);
   System.out.println("Employee manager: " + manager.id);
   System.out.println("Employee salary: " + salary);
   System.out.println("Employee ID: " + id);

   }

   
}