// Lab15avst.java
// 02-28-15 by Leon Schram
// The "Odd Magic Square" Program
// This is the student, starting version of the Lab15 assignment.


import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab15avst
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

      System.out.print("Enter the odd# size of the Magic Square -->  ");
      int size = input.nextInt();
      MagicSquare magic = new MagicSquare(size);

      magic.computeMagicSquare();
      magic.displayMagicSquare();
   	magic.checkRows();          // for 100 & 110 Point Version Only
      System.out.println();
   	magic.checkColumns();		 // for 100 & 110 Point Version Only
      System.out.println();
   	magic.checkDiagonals();	 	 // for 100 & 110 Point Version Only
	}
}


class MagicSquare
{
	private int size;
	private int[][] magic;
   private int sum;
   private int counttemp = 1;
	private DecimalFormat output;
   private int rowtemp;
   private int coltemp;
   private int ditemp;
   private int addsum;
	public MagicSquare(int s)
	{
		size = s;
		magic = new int[size][size];
		output = new DecimalFormat("000");
	}

	public void computeMagicSquare()
	{
    int number = 1;
    int row = 0;
    int column = size / 2;
    int current_row;
    int current_col;
    while (number <= size * size) {
     magic[row][column] = number;
     number++;
     current_row = row;
     current_col = column;
     row -= 1;
     column +=1;
     
     if (row == -1){
     row = size - 1;
     }
     if (column == size){
     column = 0;
     }
     if (magic[row][column] != 0) {
            row = current_row + 1;
            column = current_col;
          
        }
    }
}
	

	public void displayMagicSquare()
	{
		System.out.println();
		System.out.println(size + "x" + size + " Magic Square");
		System.out.println("==================");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(output.format(magic[i][j]) + " ");
            System.out.println();
        }
	}

	public void checkRows()
	{
		System.out.println();
		System.out.println("Checking Rows");
		System.out.println("=============");
		System.out.println();
     
      for (int i = 0; i < size; i++){
            
           System.out.print (magic[i][0]);
            
          for(int j = 0; j < size; j++){
      
           sum += magic[i][j];
           rowtemp = sum;
           
           
           if (counttemp < size)
           System.out.print (" + " + magic[i][counttemp]);
           else{
          System.out.println(" = " + rowtemp);
          counttemp = 0;
          }
          counttemp +=1;
          
           }
           
           sum = 0 ;
      }
    

	}

	public void checkColumns()
	{
		System.out.println();
		System.out.println("Checking Columns");
		System.out.println("================");
		System.out.println();
      int k = 0;
      for (int i = 0; i < size; i++){
       
          for(int j = 0; j < size; j++){
          System.out.print(magic[j][k]);
            k += 1;
          
           //swap places with i and j so that it iterates through columns instead of rows
           sum += magic[j][i];
           coltemp = sum;

           if (counttemp < size){
           System.out.print(" + " + magic[j][i]);
           }
           else{
          System.out.println(" = " + coltemp);
          counttemp = 0;
          }
          counttemp +=1; 
                 
           }
           
           sum = 0 ;
      }

           
  
   }

	public void checkDiagonals()
	{
		System.out.println();
		System.out.println("Checking Diagonals");
		System.out.println("==================");
		System.out.println();
      
     
      for (int i = size - 1 ; i > -1; i--){
            
          for(int j = size -1; j > -1; j--){
           sum += magic[i][j];
           ditemp = sum;
           }
           System.out.print(ditemp + " ");
           sum = 0 ;
      }

	}
   
}

/*
   magic[row][column] = number;
        number++;
        current_row = row;
        current_col = column;
        row -= 1;
        column += 1;
        //if row goes above top row
        if (row == -1) {
            row = size - 1;
        }
        //if column goes beyond right side limit
        if (column == size) {
            column = 0;
        }
        
        if (magic[row][column] != 0) {
            row = current_row + 1;
            column = current_col;
            
*/