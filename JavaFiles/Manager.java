import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Random;
public class Manager{
   Random rand = new Random();
   int upperbound = 999999;
   public int id = rand.nextInt(upperbound); //generates random manager IDs
   String name;
   int salary;
   String ceo_name = "";
   public ArrayList<Employee> employees = new ArrayList<Employee>();
  
   public Manager(String enteredName, int enteredSalary, String ceoName){
      name = enteredName;
      salary = enteredSalary;
      id = id + 1;
      ceo_name = ceoName;
   }
   public Manager(){
   name = "";
   ceo_name = "";
   }
   //method 1
   public int HireEmployee(String ename, int salary, Manager emanager){
      Employee hired_emp = new Employee(ename, salary, emanager);
      employees.add(hired_emp);
      return hired_emp.id;
   
   }
   //method 2
   public void DisplayEmployees(){
      int count = 1;
      System.out.println("Displaying employees managed by manager of id " + id);
      for(int i = 0; i < employees.size(); i++){
         System.out.println(count + " " + employees.get(i).id + "\n");
   }
   
   }
   //method 3
   public void PromoteEmployee(int EmployeeID, int newSalary){
      Employee employee = new Employee();
      boolean found = false;
      for(int i = 0; i < employees.size(); i++){
         if(employees.get(i).id == EmployeeID){  
            employee = employees.get(i);
            employees.remove(i);
            found = true;
         }
      
      }  
         if(found == false){
            System.out.println("This employee was not found!");
         }

      if(newSalary > employee.salary){
         employee.salary = newSalary;
         System.out.println("You have successfully promoted this employee with a raise of " + newSalary +"!");
         employees.add(employee);
      }
      else{
         System.out.println("The entered salary for employee " + employee.id + " is lower than their original salary!");
         System.out.println("If you wish to demote this employee, please do that with the demote employee method!");
         employees.add(employee);

      }
   }
   //method 4
   public void DemoteEmployee(int EmployeeID, int newSalary){
     Employee employee = new Employee();
     boolean found = false;
     for(int i = 0; i < employees.size(); i++){
         if(employees.get(i).id == EmployeeID){  
            employee = employees.get(i);
            employees.remove(i);
            found = true;
         }
         
      }  
         if(found == false){
            System.out.println("This employee was not found!");
         }
         if(newSalary < employee.salary){
            employee.salary = newSalary;
            System.out.println("You have successfully demoted this employee with a lower salary of " + newSalary +"!");
            employees.add(employee);

         }
         else{
            System.out.println("The entered salary for employee " + employee.id + " is higher than their original salary!");
            System.out.println("If you wish to promote this employee, please do that with the promote employee method!"); 
            employees.add(employee);

         }
   }
   //method 5
   public void FireEmployee(int id){
      String response;
      int entered_id = id;
      System.out.println("Are you sure you wish to fire this Employee?");
      Scanner in = new Scanner(System.in);
      response = in.nextLine();
      boolean found = false;
      int count = 0;
      if(response.toLowerCase().equals("yes")){//1
         while(count < employees.size() && found == false){//2
            if(employees.get(count).id == entered_id){//3
               employees.remove(count);
               System.out.println("You have fired this employee!");

               found = true;
            }//3
            count++;
         }//2
         if(count == employees.size() && found == false){
            System.out.println("No employee with that id was found!");
         }
         }//1
     else if (response.toLowerCase().equals("no")){
         System.out.println("You have chosen not to fire this employee");
     }
     else{
      System.out.println("You must enter yes or no, please try again");
      FireEmployee(entered_id); //recursion
     }
   
   
   
   
   }
   public void CheckProfile(){
      System.out.println("Salary : " + salary);
      System.out.println("Name : " + name);
      System.out.println("ID : " + id);
   }
      
}
   
