// Lab06st.java
// Student Version

import java.awt.*;
import javax.swing.*;
import java.lang.Math;
public class lab06st extends JPanel
{
 public static void main(String[] args)
 {
 JFrame myFrame = new JFrame("My JFrame"); // Instantiates the JFrame.
 myFrame.setSize(1000,1000); // Sets the window size.
 myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows X-out.
 JPanel myPanel = new lab06st(); // Instantiates the JPanel.
 myFrame.add(myPanel); // Adds the JPanel to the JFrame.
 myFrame.setVisible(true); // Makes the window contents visible.
 }

 // This method is automatically called when the jPanel is instantiated.

	public void paint(Graphics g) 	
	{
    super.paintComponent(g);
		// Draw Grid
		g.drawRect(10,10,780,580);
		g.drawLine(400,10,400,590);
		g.drawLine(10,300,790,300);
		
		
		
		// Draw Random Squares
      for (int k = 1; k <= 200; k++)
       {
       int x = (int)(Math.random() * 340) + 10;
       int y = (int)(Math.random() * 240) + 10;
       int red = (int)(Math.random() * 256) + 0;
       int green = (int)(Math.random() * 256) + 0;
       int blue = (int)(Math.random() * 256) + 0;
       g.setColor(new Color(red,green,blue));
       g.fillRect(x,y,50,50);
 } 

				
		
		// Draw Random Lines


      for (int k = 1; k <= 500; k++)
          {
          int x1 = (int)(Math.random() * 390) + 10;
          int y1 = (int)(Math.random() * 290) + 300;
          int x2 = (int)(Math.random() * 390) + 10;
          int y2 = (int)(Math.random() * 290) + 300;
          int red = (int)(Math.random() * 256) + 0;
          int green = (int)(Math.random() * 256) + 0;
          int blue = (int)(Math.random() * 256) + 0;
          g.setColor(new Color(red,green,blue));
       
          g.drawLine(x1,y1,x2,y2);
          } 
		
		// Draw Random Circles
 for (int k = 1; k <= 500; k++)
       {
       int x = (int)(Math.random() * 340) + 400;
       int y = (int)(Math.random() * 240) + 10;
       int red = (int)(Math.random() * 256) + 0;
       int green = (int)(Math.random() * 256) + 0;
       int blue = (int)(Math.random() * 256) + 0;
       g.setColor(new Color(red,green,blue));
       g.drawOval(x,y,50,50);
 } 



		
		// Draw 3-D Box
	   
	   }
	
	}
