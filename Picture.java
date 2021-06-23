import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 *
 * 02-27-15 altered by Leon Schram
 * This file is made shorter to focus on the Lab15b assignment.
 *
 */
 
 
 
//////////////////////////////////////////////////////////////////////////
//
// This is the student starting file of the Lab15b assignment.
//
// This is the only file that students use to write their methods.
//
//////////////////////////////////////////////////////////////////////////
 
 
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
      
 ////////////////////////////////////////////////////////////////////////  
   
      // REQUIRED FOR 80-POINTS
      public void grayScale()
      {
            for(int i = 0; i < getHeight(); i++) {          
            for(int j = 0; j < getWidth(); j++) {

               Pixel pixel = new Pixel(this, j, i);
               int newGray = (int)pixel.getAverage();
               Color grayColour = new Color(newGray, newGray, newGray);
               pixel.setColor(grayColour);

            }

         }      }
  
//////////////////////////////////////////////////////////////////////////  

      // REQUIRED FOR 80-POINTS
      public void mirror()
      {  
   for(int i = 0 ; i < getHeight(); i++) {   
             for(int j = 0; j < getWidth()/2; j++) {
               Pixel leftpix = new Pixel(this, j, i);
               Pixel rightpix = new Pixel(this, getWidth() - j - 1, i);           
               Color colour1 = leftpix.getColor();
               Color colour2 = rightpix.getColor();
               leftpix.setColor(colour2);
               rightpix.setColor(colour1);
            }

         }           
              }
      
////////////////////////////////////////////////////////////////////////////////////////

      // REQUIRED FOR 80-POINTS
      public void upsideDown()
      {  
    for(int i = 0; i < getWidth(); i++) {     
            for(int j = 0; j < getHeight() / 2; j++) {

               Pixel toppix = new Pixel(this, i, j);
               Pixel botpix = new Pixel(this, i, getHeight() - j - 1);
               Color colour1 = toppix.getColor();
               Color colour2 = botpix.getColor();
               toppix.setColor(colour2);
               botpix.setColor(colour1);

            }

         }
      
      }    
      
//////////////////////////////////////////////////////////////////////////////////////////

   // REQUIRED FOR 90-POINTS
   public void mirrorVertical(){
     Pixel[][] pixels = this.getPixels2D();
      Pixel leftpix;
      Pixel rightpix;
      int width = pixels[0].length;
      for (int row = 0; row < pixels.length; row++){
         for (int col = 0; col < width / 2; col++){
               leftpix = pixels[row][col];
               rightpix = pixels[row][width - col - 1];
               leftpix.setColor(rightpix.getColor());
         }
      }   }
   
//////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 90-POINTS
   public void mirrorHorizontal()
   {
 Pixel[][] pixels = this.getPixels2D();
    Pixel toppix;
    Pixel basepix;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++){
       for (int col = 0; col < pixels[0].length; col++)
       {
          toppix = pixels[row][col];
          basepix = pixels[height - row - 1][col];
          basepix.setColor(toppix.getColor());
       }
    } 
  
   }
      
//////////////////////////////////////////////////////////////////////////////////////////////////      
    
   // REQUIRED FOR 90-POINTS
   public void mirrorDiagonal()
   { 
 Pixel[][] pixels = this.getPixels2D();
       Pixel leftpix;
       Pixel rightpix;

       int max = pixels.length;
       if (pixels[1].length < max)
       max = pixels[1].length;

       for (int row = 1; row < max; row++){
            for (int col = 0; col < row; col++){
                leftpix = pixels[row][col];
                rightpix = pixels[col][row];
                rightpix.setColor(leftpix.getColor());
          }
 }
   
   }
   
/////////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 100-POINTS
   public void mirrorTemple()
   { 
   int cord = 275;
    Pixel leftpix;
    Pixel rightpix;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    for (int row = 28; row < 97; row++) {
      for (int col = 12; col <cord; col++){
            count++;
            leftpix = pixels[row][col]; 
            rightpix = pixels[row][cord - col + cord];
            rightpix.setColor(leftpix.getColor());
 
   
   }
   }
   }
} 

