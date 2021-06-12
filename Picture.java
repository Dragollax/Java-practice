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
      Pixel[][] pixels = this.getPixels2D();
 Pixel pixel = null;
 int total = 0;
 int average = 0;
 for (int row = 0; row < pixels.length; row++)
 {
 for (int col = 0; col < pixels[0].length; col++)
 {
 total = 0;
 pixel = pixels[row][col];
 total = total + pixel.getRed();
 total = total + pixel.getGreen();
 total = total + pixel.getBlue();
 average = total / 3;
 pixel.setColor(new Color(average, average, average));
 }
 }
   
      }
  
//////////////////////////////////////////////////////////////////////////  

      // REQUIRED FOR 80-POINTS
      public void mirror()
      {  
       Pixel[][] pixels = this.getPixels2D();
 Pixel leftPixel = null;
 Pixel rightPixel = null;
 int width = pixels[0].length;
 for (int row = 0; row < pixels.length; row++)
 {
 for (int col = 0; col < width / 2; col++)
 {
 leftPixel = pixels[row][col];
 rightPixel = pixels[row][width -1]; 
 leftPixel.setColor(rightPixel.getColor());
 }
 }   } 
           
              }
  /*    
////////////////////////////////////////////////////////////////////////////////////////

      // REQUIRED FOR 80-POINTS
      public void upsideDown()
      {  
      }
      
      }    
      
//////////////////////////////////////////////////////////////////////////////////////////

   // REQUIRED FOR 90-POINTS
   public void mirrorVertical()
   { 
  Pixel[][] pixels = this.getPixels2D();
 Pixel leftPixel = null;
 Pixel rightPixel = null;
 int width = pixels[0].length;
 for (int row = 0; row < pixels.length; row++)
 {
 for (int col = 0; col < width / 2; col++)
 {
 leftPixel = pixels[row][col];
 rightPixel = pixels[row][width - col - 1];
 leftPixel.setColor(rightPixel.getColor());
 }
 }    }
   
//////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 90-POINTS
   public void mirrorHorizontal()
   {
  Pixel[][] pixels = this.getPixels2D();
 Pixel topPixel = null;
 Pixel botPixel = null;
 int height = pixels.length;
 for (int row = 0; row < height / 2; row++)
 {
 for (int col = 0; col < pixels[0].length; col++)
 {
 topPixel = pixels[row][col];
 botPixel = pixels[height - row - 1][col];
 botPixel.setColor(topPixel.getColor());14
 }
 } 
  
   }
      
//////////////////////////////////////////////////////////////////////////////////////////////////      
    
   // REQUIRED FOR 90-POINTS
   public void mirrorDiagonal()
   { 
   Pixel[][] pixels = this.getPixels2D();
 Pixel leftPixel = null;
 Pixel rightPixel = null;
 
 int max = pixels.length;
 if (pixels[0].length < max)
 max = pixels[0].length;
 
  for (int row = 1; row < max; row++)15
 {
 for (int col = 0; col < row; col++)
 {
 leftPixel = pixels[row][col];
 rightPixel = pixels[col][row];
 rightPixel.setColor(leftPixel.getColor());
 }
 }
   
   }
   
/////////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 100-POINTS
   public void mirrorTemple()
   { 
   int mirrorPoint = 276;
 Pixel leftPixel = null;
 Pixel rightPixel = null;
 int count = 0;
 Pixel[][] pixels = this.getPixels2D();
 
 // loop through the rows
 for (int row = 27; row < 97; row++)
 {
 // loop from 13 to just before the mirror point
 for (int col = 13; col < mirrorPoint; col++)
 {
 count++;
 leftPixel = pixels[row][col]; 
 rightPixel = pixels[row][mirrorPoint - col + 
 mirrorPoint];
 rightPixel.setColor(leftPixel.getColor());
 }
 }
 
   
   }
   
} 
*/
