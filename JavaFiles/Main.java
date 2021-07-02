
import java.util.Scanner; 
public class Main{
public static void main(String[] args) {
    
    Scanner name = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Please enter your name as CEO for the company Apple");

    String enteredname = name.nextLine();  // Read user input
    CEO newCeo = new CEO(enteredname);

    System.out.println("You have entered " + enteredname + " as your name for ceo");  // Output user input
    
    GetResponse(newCeo, enteredname);

   	}
   
   public static void GetResponse(CEO passed_ceo, String ceoName){
      //two things needed to authenticate user: string value "state", along with one of the 3 ceo, manager, and employee objects.
      String state = "ceo";
      String ceo_name = ceoName;
      CEO current_ceo = passed_ceo;
      Manager current_manager = new Manager(); //temporary object holder for manager, will act as a current user attribute
      Employee current_employee = new Employee(); //temporary object holder for employee, will act as a current user attribute
      int id;
      int said = 0;
      int count = 0;
      Scanner next = new Scanner(System.in);  
      System.out.println("What would you like to do next?");
      if(count == 0){
      System.out.println("You can switch roles as ceo, manager, or employee, and see what you can do from there!");
      count++;
      }
      String statement = next.nextLine();
      
      while(!statement.equals("End")){
        
         if (statement.toLowerCase().equals("manager")){
            statement = "";
            System.out.println("Great! Enter a manager id to become them!");
            Scanner next1 = new Scanner(System.in);  
            id = next1.nextInt();
            int count2 = 0;
            boolean found = false;
            while(count2 < current_ceo.managers.size() && found == false){
               if(current_ceo.managers.get(count2).id == id){
                  current_manager = current_ceo.managers.get(count2);
                  System.out.println("You are now a manager with id of " + id);
                  System.out.println("(Manager) Options are: enter any of the 3 roles to switch roles, 'hire', 'fire','employees','profile','demote', or 'end'. Warning: 'end' will terminate the program");
                  found = true;
                  state = "manager";
               }
               count2++;
            }
            if(count2 == current_ceo.managers.size() && found == false){
            System.out.println("The manager you entered does not exist!");
            System.out.println("Please try something else as a/an" + state);

            }
         }
         else if(statement.toLowerCase().equals("ceo")){
            state = "ceo";
            System.out.println("(CEO) Options are: enter any of the 3 roles to switch roles, 'managers', 'hire', 'fire', 'all', 'worth',  or 'end'. Warning: 'end' will terminate the program");
            statement = "";
         }
         else if(statement.toLowerCase().equals("employee")){
            System.out.println("Enter an employee id to become them!");
            Scanner next2 = new Scanner(System.in);  
            id = next2.nextInt();
            boolean found = false;
            int count3 = 0;
            statement = "";
            while (count3 < current_ceo.TotalEmployees.size() && found == false){
               if(current_ceo.TotalEmployees.get(count3).id == id){
                  current_employee = current_ceo.TotalEmployees.get(count3);
                  System.out.println("You are now an employee with id of " + id);
                  System.out.println("(Employee) Options are: enter any of the 3 roles to switch roles, 'work', 'profile',  or 'end'. Warning: 'end' will terminate the program ");
                  found = true;
                  statement = "";
                  state = "employee";
               }
               count3++;
            }
            
            if(count3 == current_ceo.TotalEmployees.size() && found == false){
               System.out.println("The employee you entered does not exist, please try again!");
               System.out.println("Please try something else as a " + state);               
            }
         }
         
         else{
         if(said == 0){
            switch(state){
            case "ceo":
               System.out.println("(CEO) Options are: enter any of the 3 roles to switch roles, 'managers', 'hire', 'fire', 'all', 'worth', or 'end'. Warning: 'end' will terminate the program");
               said++;
               break;
            case "manager":
               System.out.println("(Manager) Options are: enter any of the 3 roles to switch roles, 'hire', 'fire','profile', 'employees, 'demote', or 'end'. Warning: 'end' will terminate the program");
               said++;
               break;
            case "employee":
               System.out.println("(Employee) Options are: enter any of the 3 roles to switch roles, 'work', 'profile',  or 'end'. Warning: 'end' will terminate the program");
               said++;
               break;
            }
        }
    }
         statement = next.nextLine(); 
         switch(statement){
         case "hire":
            if(state != "employee"){//1
               if(state == "ceo"){//2
                  String name = "";
                  int salary = 0;
                  System.out.println("You are hiring as a " + state + ", enter name for the hire");
                  name = next.nextLine();
                  System.out.println("Enter salary for the hire");
                  salary = next.nextInt();
                  current_ceo.HireManager(name, salary, ceo_name);
                  System.out.println("Great!");
                  statement = " ";
                  said = 0;
               }//2
               else{//3
                  String name = "";
                  int salary = 0;
                  System.out.println("You are hiring as a " + state + ", enter name for the hire");
                  name = next.nextLine();
                  System.out.println("Enter salary for the hire");
                  salary = next.nextInt();
                  int hired_id = current_manager.HireEmployee(name, salary, current_manager);
                  System.out.println("Sucessfully hired employee with ID " +  hired_id);
                  statement = " ";
                  said = 0;
                  int countemp = 0;
                  while(true){
                     if(current_manager.employees.get(countemp).id == hired_id){
                        current_ceo.AddTotalEmployee(current_manager.employees.get(countemp));
                        countemp++;
                        break;
                     }
                     countemp++; 
                  }

               }
            }
            else{
            System.out.println("You cannot hire as an employee!");
            }
            break;
         case "fire":
            if(state != "employee"){ //only two states possible: ceo or manager
              if(state == "ceo"){
                  System.out.println("Enter manager id");
                  Scanner inp = new Scanner(System.in);
                  int id1 = inp.nextInt();
                  current_ceo.FireManager(id1);
                  said = 0;
              }
              else{
                  System.out.println("Enter employee id");
                  Scanner get = new Scanner(System.in);
                  int id1 = get.nextInt();
                  current_manager.FireEmployee(id1);
                  said = 0;
              }            
            }
            else{
               System.out.println("You cannot fire as an employee!");
               said = 0;
            }
            break;
         case "work":
            int said2 = 0;
            if(state == "employee"){
               if(said2 == 0){
                  System.out.println("You are currently an employee! Each sentence or word you type will generate the company 100$ enter 'stop' to stop working");
                  said2++;
               }
               Scanner enter = new Scanner(System.in);
               String words = enter.nextLine();
               while(true){
               current_employee.GenerateMoney(words);
               System.out.println(words);
               words = enter.nextLine();
               if(words.toLowerCase().equals("stop")){
                  System.out.println("Going back to employee home page...");
                  said = 0;
                  break;
                  
               }
               }
            
            }
            else{
               System.out.println("you cannot work unless you are an employee, you are currently a " + state);
               said = 0;
            }
            break;
         case "profile":
            if(state == "employee"){
               current_employee.ShowProfile();
               System.out.println("Your generated money: " + current_employee.GeneratedMoney);
               said = 0;
            }
            else if (state == "manager"){
               current_manager.CheckProfile();
               said = 0;
            }
            else{
               System.out.println("You can only check your profile as an employee or as a manager, its pointless if you are a ceo!");
               said = 0;
            }
            break;
         case "worth":
            if(state == "ceo"){
               current_ceo.DisplayCompanyWorth();
               said = 0;
            }
            else{
               System.out.println("You cannot check the company worth as a/an " + state);
               said = 0;
            }
            break;
         case "managers":
            if(state == "ceo"){
               said = 0;
               System.out.println("Displaying all manager IDs: " + current_ceo.ShowAllManagers());
            }
            else{
               said = 0;
               System.out.println("You cannot do this as a/an " + state);
            }
            break;
         case "all":
            if(state != "ceo"){
               System.out.println("You cannot do this as a/an " + state);
            }
            else{
               current_ceo.AllEmployees();   
            }
            break;
         case "promote":
            if(state == "manager"){
               System.out.println("Enter Employee id");
               Scanner getin = new Scanner(System.in);
               int enteredID = getin.nextInt();
               System.out.println("Enter new salary");
               int enteredSalary = getin.nextInt();
               current_manager.PromoteEmployee(enteredID, enteredSalary);
               said = 0;
            }
            else{
               System.out.println("You cannot promote an employee as a/an " + state);
               said = 0;
            }
            break;
         case "demote":
            if(state =="manager"){
               System.out.println("Enter Employee id");
               Scanner getin = new Scanner(System.in);
               int enteredID = getin.nextInt();
               System.out.println("Enter new salary");
               int enteredSalary = getin.nextInt();            
               current_manager.DemoteEmployee(enteredID, enteredSalary);
               said = 0;
            }
            else{
               System.out.println("You cannot demote an employee as a/an " + state);
               said = 0;
            }
         break;
         case "employees":
            if(state == "manager"){
               current_manager.DisplayEmployees();
               said = 0;
            }
            else{
               System.out.println("You cannot use this as a/an " + state);
               said = 0;
            }
         break;
         case "End":
            System.out.println("OK!");
            break;
         }
         
         
         
         
         
         
         }

    }

         
            }
