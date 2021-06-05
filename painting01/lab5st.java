import java.awt.*;
import javax.swing.*;
public class lab5st extends JPanel
{
 public static void main(String[] args)
 {
 JFrame myFrame = new JFrame("My JFrame"); // Instantiates the JFrame.
 myFrame.setSize(1000,1000); // Sets the window size.
 myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows X-out.
 JPanel myPanel = new lab5st(); // Instantiates the JPanel.
 myFrame.add(myPanel); // Adds the JPanel to the JFrame.
 myFrame.setVisible(true); // Makes the window contents visible.
 }

 // This method is automatically called when the jPanel is instantiated.
 public void paintComponent(Graphics g)
 {
 super.paintComponent(g);
	int y = 600;
for (int x = 0; x <= 800; x += 20)
{
	g.drawLine(x,600,800,y);
	y-=15;
}
}
