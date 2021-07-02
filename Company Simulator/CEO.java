
import java.util.ArrayList;
import java.util.Scanner; 


public class CEO{
   public String name;
   private int CompanyWorth;
   public ArrayList<Manager> managers = new ArrayList<Manager>();
   public ArrayList<Employee> TotalEmployees = new ArrayList<Employee>();
   public CEO(String Enteredname){
   name = Enteredname;
   }
   //method 1
   public void HireManager(String enteredname, int enteredsalary, String name2){
    
      Manager newManager = new Manager(enteredname, enteredsalary, name2);
      managers.add(newManager);
      
      System.out.println("You have successfully hired " + enteredname + " with an ID of " + newManager.id);
   }
   public void AddTotalEmployee(Employee newEmployee){
      TotalEmployees.add(newEmployee);
   }
   //method 2
   public String ShowAllManagers(){
      String temp = "";
      for (int i = 0; i < managers.size(); i++){
         temp = temp + managers.get(i).id + " ";
   }
      return temp;
   
 }
   //method 3
   public void DisplayCompanyWorth(){
      for(int i = 0; i < TotalEmployees.size(); i++){
         CompanyWorth += TotalEmployees.get(i).GeneratedMoney;
      }
      System.out.println("The current company worth is " + CompanyWorth + "$");
   }
   //method 4
   public void FireManager(int id){
      String response;
      int entered_id = id;
      
      System.out.println("Are you sure you wish to fire this manager? Existence of this manager will be checked when you type yes or no.");
      Scanner in = new Scanner(System.in);
      response = in.nextLine();
      boolean found = false;
      int count = 0;
      if(response.toLowerCase().equals("yes")){//1
         while(count < managers.size() && found == false){//2
            if(managers.get(count).id == entered_id){ //3
               Manager tempMan = new Manager();
               tempMan = managers.get(count);
               for(int i = 0; i < tempMan.employees.size(); i++){
                  for(int j = 0; j < TotalEmployees.size(); j++){
                     if(TotalEmployees.get(j) == tempMan.employees.get(i)){ //will remove all employees associated with this manager
                        TotalEmployees.remove(j);  
                     }
                  }
               }
               managers.remove(count);
               System.out.println("You have fired this manager!");
               found = true;
            }//3
            count++;
      }//2
         if(count == managers.size() && found == false){
               System.out.println("No manager with that id was found!");

         }//1
     
            }
         else if (response.toLowerCase().equals("no")){
            System.out.println("You have chosen not to fire this manager");
     }
          else{
               System.out.println("You must enter yes or no, please try again");
               FireManager(entered_id); //recursion
     }
   
   
   
   
   
   }
   //method 5
   public void AllEmployees(){
      System.out.println("Displaying all employee IDs in the whole company(excluding managers): ");
      for(int i = 0; i < TotalEmployees.size(); i++){
         System.out.println(TotalEmployees.get(i).id + "\n");
      }
   }
}