//This is the driver file for this lab
/* 
   Lab 10
   Name: Car Builder
   Point version: 110 
      The project has 3 examples of inheritance, over 3 examples of composition, and passes parameters from lowest subclass to highest superclass
   
*/


import java.util.Scanner; 
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello! Type 1 to build a Tesla, or 2 to build a BMW!");
      Scanner next = new Scanner(System.in);
      int responseint = next.nextInt();
      Scanner response = new Scanner(System.in);
      if(responseint == 1){
         System.out.println("Great! Enter an engine brand!(anything will do!)");
         String brand = response.nextLine();
         System.out.println("Cool! Now enter a battery brand(anything will do!)");
         String battery = response.nextLine();
         System.out.println("Now enter a number for how many windows you want on your custom tesla!(0-10)");
         int windows = next.nextInt();
         while(windows < 0 || windows > 10){
            System.out.println("You need to enter a number between 0 - 10!");
            windows = next.nextInt();
         }
         System.out.println("Almost there! Enter a number for how many wheels you want your car to have!(3-10)");
         int wheels = next.nextInt();
         while(wheels < 3 || wheels > 10){
            System.out.println("You need to enter a number between 3 - 10!");
            wheels = next.nextInt();
         }
         System.out.println("Last question! Enter a number for how many people you want your tesla to carry! (4-8)");
         int capacity = next.nextInt();
         while(capacity < 4 || capacity > 8){
            System.out.println("You need to enter a number between 4 - 8!");
            capacity = next.nextInt();
         }
         Tesla tesla = new Tesla(windows, capacity, wheels, brand, battery);
         
         System.out.println("Cool! Now you either: 1 - display how tesla is related to the general term 'vehicles', 2 - edit any part of your car, or 3- stop the program");
         int choice = response.nextInt();
         
         while(choice < 1 || choice > 3){
            System.out.println("Enter 1, 2 or 3!");
            choice = response.nextInt(); 
         }
         while(choice != 3){
         if(choice == 1){
            tesla.Display();
            System.out.println("Cool! Now you either: 1 - display how tesla is related to the general term 'vehicles', 2 - edit any part of your car, or 3- stop the program");
            choice = response.nextInt();
            
         }
         else{
            tesla.Edit();
            System.out.println("Cool! Now you either: 1 - display how tesla is related to the general term 'vehicles', 2 - edit any part of your car, or 3- stop the program");
            choice = response.nextInt();
         }
         }
      }
      else if(responseint == 2){
         System.out.println("Great! Enter an engine brand!(anything will do!)");
         String brand = response.nextLine();
         System.out.println("Cool! Now enter a number for the quality of gas you would like for your BMW! 0- regular 1- unleaded 2 - midgrade 3- premium");
         int gas = response.nextInt();
         while(gas < 0 || gas > 3){
            System.out.println("You must enter a number between 0 - 3!");
            gas = response.nextInt();
         }
         System.out.println("Now enter a number for how many windows you want on your custom BMW!(0-10)");
         int windows = next.nextInt();
         while(windows < 0 || windows > 10){
            System.out.println("You need to enter a number between 0 - 10!");
            windows = next.nextInt();
         }
         System.out.println("Almost there! Enter a number for how many wheels you want your car to have!(3-10)");
         int wheels = next.nextInt();
         while(wheels < 3 || wheels > 10){
            System.out.println("You need to enter a number between 3 - 10!");
            wheels = next.nextInt();
         }
         System.out.println("Last question! Enter a number for how many people you want your BMW to carry! (4-8)");
         int capacity = next.nextInt();
         while(capacity < 4 || capacity > 8){
            System.out.println("You need to enter a number between 4 - 8!");
            capacity = next.nextInt();
         }
         BMW bmw = new BMW(windows, capacity, wheels, brand, gas);
         
         System.out.println("Cool! Now you either: 1 - display how BMW is related to the general term 'vehicles', 2 - edit any part of your car, or 3- stop the program");
         int choice = response.nextInt();
         
         while(choice < 1 || choice > 3){
            System.out.println("Enter 1 or 2!");
            choice = response.nextInt();
         }
         while(choice != 3){
         if(choice == 1){
            bmw.Display();
            System.out.println("Cool! Now you either: 1 - display how BMW is related to the general term 'vehicles', 2 - edit any part of your car, or 3- stop the program");
            choice = response.nextInt();
         }
         else{
            bmw.Edit();
            System.out.println("Cool! Now you either: 1 - display how BMQ is related to the general term 'vehicles', 2 - edit any part of your car, or 3- stop the program");
            choice = response.nextInt();
         }
     

      
      }
  	}
   
    else{
               System.out.println("The options are 1 and 2");
            }
   
   
}
//----------------inheritance classes----------------
static class Vehicle{ //Highest superclass
   int capacity = 0;
   public Wheels wheels;
   public Vehicle(int c, int num){
      this.wheels = new Wheels(num);
      capacity = c;
   
   }
   public void Display(){
      System.out.println("______________________________");
      System.out.println("This car is a vehicle that has...");
      System.out.println(wheels.GetWheels() + " wheels from class Wheels");
      System.out.println("And has a carrying capacity of " + capacity);
      System.out.println("______________________________");
   }
   public void EditWheels(int num){
      wheels.SetWheels(num);
   }
   public void EditCapacity(int cap){
      capacity = cap;
   }
}

static class Car extends Vehicle{ //Second lowest subclass. example 1 of inheritance
   public Window window;
   public String whichCar = "";
   public Car(int windows, int capa, int w){
      super(capa, w);  //passes 2 arguments to superclass Vehicle
      this.window = new Window(windows);
   }
      public void Display(){
         super.Display();
         System.out.println(whichCar + " is the car that also has...");
         System.out.println(window.GetWindows() + " windows from composite class Window");
         System.out.println("______________________________");
         
      }
      public void EditWindows(int w){
         window.SetWindow(w);
      
      }
      public void EditParentWheels(int wheels){
         super.EditWheels(wheels);
         System.out.println("Edited wheels ");
      }
      public void EditParentCapacity(int cap){
      super.EditCapacity(cap);
      System.out.println("Edited capacity");
      }
      public void SetCar(String name) {
         whichCar = name;
      }
}

static class Tesla extends Car{ //lowest sub class. Example 2 of inheritance
   public Engine engine;
   public Battery battery;
   String carname = "Tesla";
   public Tesla(int windows, int capa, int wheels, String i, String b){
      super(windows, capa, wheels); //passes 3 arguments to superclass Car
      super.SetCar(carname);
      engine = new Engine(i);
      battery = new Battery(b);
   
   }
   
   public void Display(){
      super.Display();
      System.out.println("and Tesla has a/an... ");
      System.out.println("Engine made by " + engine.GetBrand() + " that comes from composite class Engine");
      System.out.println("Battery made by " + battery.GetBrand() + " that comes from composite class Battery");
      System.out.println("______________________________");
   }
   public void Edit(){
      System.out.println("Which of the following do you want to edit? Engine, battery, windows, wheels, or capacity?");
      Scanner input = new Scanner(System.in);
      String statement = input.nextLine();
      statement.toLowerCase();
      switch(statement){
         case "engine":
            System.out.println("Enter new brand name here...");
            String newName = input.nextLine();
            engine.brand = newName;
            System.out.println("Successful");
            break;
         case "battery":
            System.out.println("Enter new battery name here...");
            String newname = input.nextLine();
            battery.brand = newname;
            System.out.println("Successful");
            break;
         case "windows":
            System.out.println("Enter new window count here...");
            int num = input.nextInt();
            while(num < 0 || num > 10){
               System.out.println("must be 0 - 10!");
               num = input.nextInt();
            }
            super.EditWindows(num);
            System.out.println("Successful");
            break;
         case "wheels":
            System.out.println("Enter wheel count here...");
            int num2 = input.nextInt();
            while(num2 < 3 || num2 > 10){
               System.out.println("must be 3 - 10!");
               num2 = input.nextInt();
            }
            super.EditParentWheels(num2);
            System.out.println("Successful");
            break;
         case "capacity":
            System.out.println("Enter new brand name here...");
            int num1 = input.nextInt();
            while(num1 < 4 || num1 > 8){
               System.out.println("must be 4 - 8!");
               num1 = input.nextInt();
            }
            super.EditParentCapacity(num1);
            System.out.println("Successful");
            break;
         default:
            System.out.println("That isn't apart of any of these choices!");
      
      }
   
   }

}

static class BMW extends Car{//example 3 of inheritance
   public Engine engine;
   public Gas gas;
   private String name = "BMW";
   public BMW(int n, int c, int w, String engine, int index){
      super(n, c, w);
      super.SetCar(name);
      this.engine = new Engine(engine);
      this.gas = new Gas(index);

   }
   public void Display(){
      super.Display();
      System.out.println("and this BMW...");      
      System.out.println("has an engine made by " + engine.GetBrand() + " that comes from composite class Engine");
      System.out.println("uses gas of quality " + gas.GetQ() + " that comes from composite class Gas");
      System.out.println("______________________________");
   }
   public void Edit(){
      System.out.println("Which of the following do you want to edit? Engine, gas, windows, wheels, or capacity?");
      Scanner input = new Scanner(System.in);
      String statement = input.nextLine();
      statement.toLowerCase();
      switch(statement){
         case "engine":
            System.out.println("Enter new brand name here...");
            String newName = input.nextLine();
            engine.brand = newName;
            System.out.println("Successful");
            break;
         case "gas":
            System.out.println("Enter gas index here...0- regular 1- unleaded 2- mid-grade 3- premium");
            int index = input.nextInt();
            int q = 0;
            while(index < 0 || index > 3){
               System.out.println("must be 0 - 3!");
               index = input.nextInt();
            }
            q = index;
            gas.SetQ(q);
            System.out.println("Successful");
            break;
         case "windows":
            System.out.println("Enter new window count here...");
            int num = input.nextInt();
            while(num < 0 || num > 10){
               System.out.println("must be 0 - 10!");
               num = input.nextInt();
            }
            super.EditWindows(num);
            System.out.println("Successful");
            break;
         case "wheels":
            System.out.println("Enter wheel count here...");
            int num2 = input.nextInt();
            while(num2 < 3 || num2 > 10){
               System.out.println("must be 3 - 10!");
               num2 = input.nextInt();
            }

            super.EditParentWheels(num2);
            System.out.println("Successful");
            break;
         case "capacity":
            System.out.println("Enter new capacity here...");
            int num1 = input.nextInt();
            while(num1 < 4 || num1 > 8){
               System.out.println("must be 4 - 8!");
               num1 = input.nextInt();
            }

            super.EditParentCapacity(num1);
            System.out.println("Successful");
            break;
         default:
            System.out.println("That isn't apart of any of these choices!");
      
      }
   
   }   
}
//----------------composition classes-----------------

static class Battery{
   public String brand = "";
   public Battery(String b){
      brand = b;
   }
   
   public String GetBrand(){
      return brand;
   }
   
}   

static class Window{
   public Integer num_of_windows = 0;
   public Window(int n){
      num_of_windows = n;
   }
   public int GetWindows(){
      return num_of_windows;
   }
   
   public void SetWindow(int n){
      num_of_windows = n;
   }
}

static class Wheels{
   public int num_of_wheels = 0;
   public Wheels(int w){
      num_of_wheels = w;
   }
   public int GetWheels(){
   
   return num_of_wheels;
   
   }
   public void SetWheels(int n){
      num_of_wheels = n;
   }
}

static class Engine{
   public String brand = "";
   public Engine(String e){
      brand = e;
   }
   
   public String GetBrand(){
      return brand;
   }
}

static class Gas{
   String quality;
   String[] qualities = {"regular", "unleaded", "mid", "premium"};
   public Gas(int i){
      quality = qualities[i];
   }
   
   public String GetQ(){
      return quality;
   }
   
   public void SetQ(int in){
      
      quality = qualities[in]; 
   }
  
   }
}

