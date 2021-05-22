// Lab18avst.java
// The Student Records Algorithm Program
// This is the student, starting version of the Lab18a lab assignment.


import java.io.*;
import java.util.*;
import java.text.DecimalFormat;


public class Lab18avst
{
	public static void main(String[] args) throws IOException
	{
		List studentArray = new List(100);
		studentArray.getList();
		studentArray.display("UNSORTED LIST OF STUDENTS");
		studentArray.pause();

		studentArray.gpaSort();
		studentArray.display("STUDENTS SORTED IN DESCENDING ORDER BY GPA");
		studentArray.pause();

		studentArray.ageSort();
		studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY AGE");
		studentArray.pause();

		studentArray.idSort();
		studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY ID#");
		studentArray.pause();

    	int studentID = getID();
      //int index = studentArray.search(studentID); //linear search output
    	int index = studentArray.bsearch(studentID); //binary search output

	if (index == -1)
	    System.out.println("There is no student with an ID# of "+studentID+".\n");
	else
	{
		studentArray.displayStudent(index);   // displays the information for the found student
		studentArray.delete(index);           // remove the same student from the array
		studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY ID# WITHOUT STUDENT# "+studentID);
		studentArray.pause();
	}
	}

	public static int getID()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the 6-digit ID of the student.  { 100000 - 999999 }  -->  ");
		return input.nextInt();
	}
}


class Person
{
	public String name;
	public int id;
	public int age;
	public double gpa;

	Person(String n, int ID, int a,double g)
	{
		name = n;
		id = ID;
		age = a;
		gpa = g;
	}
}


class List
{
	private Person student[];	// stores array elements
	private int capacity;		// actual array capacity
	private int size;			// number of elements in the array
	public List(int c)
	{
		capacity = c;
		size = 0;
		student = new Person[capacity];
	}

	public void getList() throws IOException
	{
		FileReader inFile = new FileReader("students.dat");
		BufferedReader inStream = new BufferedReader(inFile);
		String s1,s2,s3,s4;
		int age, id;
		double gpa;
		int index = 0;
		while( ((s1 = inStream.readLine()) != null) &&
			   ((s2 = inStream.readLine()) != null) &&
			   ((s3 = inStream.readLine()) != null) &&
			   ((s4 = inStream.readLine()) != null) )
		{
			String name = s1;
			id = Integer.parseInt(s2);
			age = Integer.parseInt(s3);
			gpa = Double.parseDouble(s4);

			student[index] = new Person(name,id,age,gpa);
			index++;
		}
		inStream.close();
		size = index;
	}

	private String spaces(String name)
    {
    	int tab = 24 - name.length();
    	String temp = "";
    	for (int j = 1; j <= tab; j++)
    	    temp += " ";
    	return temp;
    }

	public void display(String listInfo)
	{
		DecimalFormat output = new DecimalFormat("0.000");
		System.out.println("\nDISPLAYING "+ listInfo);
		System.out.println("\nStudent ID#     Student Name            Age         GPA");
		System.out.println("============================================================");

		for (int k = 0; k < size; k++)
			System.out.println(student[k].id + "          "+student[k].name + spaces(student[k].name) + student[k].age + "          " + output.format(student[k].gpa));
	}

	public void pause()
	{
		Scanner input = new Scanner(System.in);
		String dummy;
		System.out.println("\nPress <Enter> to continue.");
		dummy = input.nextLine();
	}

	public void displayStudent(int x)
	{
   System.out.println("Student Record for ID# " + student[x].id + "\n");
   System.out.println("Name: " + student[x].name + "\n");
   System.out.println("Age: " + student[x].age  + "\n");
   System.out.println("GPA: " + student[x].gpa + "\n");
	}
   public int search(int studentID){ //linear search
        for (int i = 0; i < size; i++)
        {
            if (student[i].id == studentID)
                return i;
        }
        return -1;
	}
   public int bsearch(int studentID){ //binary search
   boolean found = false;
      int lo = 0;
      int hi = size-1;
      int mid = 0;
         while (lo <= hi && !found)
         {
             mid = (lo + hi) / 2;
             if (student[mid].id == studentID)
                  found = true;
             else
             {
            if (studentID > student[mid].id)
               lo = mid + 1;
            else
               hi = mid - 1;
               }
          }
               if (found)
                  return mid;
               else
                  return -1;


     
   }

	private void swap(int x, int y)
	{
   int temp = x;
   x = y;
   y = temp;
	}

	public void gpaSort()
	{
   for (int i = 0; i < size-1; i++)
        {
         int max = i;
            for (int j = i+1; j < size; j++)
                if (student[j].gpa > student[max].gpa)
                    max = j;
                    
            Person temp = student[max];
            student[max] = student[i];
            student[i] = temp;
        }
	}

	public void ageSort()
	{
   for (int i = 0; i < size-1; i++)
        {
         int min = i;
            for (int j = i+1; j < size; j++)
                if (student[j].age < student[min].age )
                    min = j;
                    
            Person temp = student[min];
            student[min] = student[i];
            student[i] = temp;
        }

	}

	public void idSort()
	{
   for (int i = 1; i < size; i++) {
        int key = student[i].id;
        Person personkey = student[i];
        int j = i - 1;
         
      while (j >= 0 && student[j].id > key) {
                student[j + 1] = student[j];
                j = j - 1;
            }
            student[j+1] = personkey;
        }

	}



	public void delete(int index)
	{
		// Precondition:  "index" stores the index of a student object that exists in the "student" array.
		// Postcondition: The student object at index "index" is removed from the "student" array.
		//                All other objects in the "student" array are unaffected.
      
      for(int j = index; j < size - 1; j++){
        student[j] = student[j+1];
      }
      size = size-1; //reduce size by one to prevent duplicate values after removing array element

	}
}
