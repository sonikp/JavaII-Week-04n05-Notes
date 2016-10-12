import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.awt.Color.*; // added as class exercise to call the color class and methods

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */

/*
 * Michael Floerchinger - ClassExercises Week 04 & 05
 * Module 3 Chapter 07 to 10
 */
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
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
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
  

  
  /*
   * Program 47: Draw lines by setting pixels
   * 
   */
  public void drawGrid()
  {
	  Pixel pixel = null;
	  
	  // Draw horizontal lines
	  for ( int y = 20; y < (this.getHeight() - 1); y+=20)	// drops down to location on the y axis
	  {
		  for ( int x = 0; x < (this.getWidth() - 1); x++)	// draws a line across the picture
		  {
			  pixel = this.getPixel(x, y);
			  pixel.setColor(Color.black);
		  }
	  }
	  
	  // Draw vertical lines
	  for ( int x = 20; x < (this.getWidth() - 1); x+=20)	// move across the picture 20 spaces on the x axis
	  {
		  for ( int y = 0; y < (this.getHeight() - 1); y++)	// draw a line going down the picture 
		  {
			  pixel = this.getPixel(x, y);
			  pixel.setColor(Color.black);
		  }
	  }
	  
  }
  
  /*
   * Program 48: Adding a box
   */
  public void addBox()
  {
	  // get the graphics context from the picture
	  Graphics g = this.getGraphics();
	  
	  // set the color to red
	  g.setColor(Color.red);
	  
	  // draw the box as a filled rectangle
	  g.fillRect(150, 200, 50, 50);		// int x, int y, width, height
	  
  }
  
  
  /*
   * Program 49: General Draw Box
   * 
   * Method to draw a filled box on the current picture
   * @param color the color to draw the box with
   * @param topLeftX the top LH X coordinate of the box
   * @param topLeftY the top LH Y coordinate of the box
   * @param width
   * @param height
   */
  public void drawBox(Color color, int topLeftX, int topLeftY, int width, int height)
  {
	  // get the graphics context for drawing
	  Graphics g = this.getGraphics();
	  
	  // set the current color
	  g.setColor(color);
	  
	  // draw the filled rectangle
	  g.fillRect(topLeftX, topLeftY, width, height);
	  
  }
  
  /*
   * Program 50: Example of using drawing commands
   * 
   */
  public void drawExample()
  {
	  
	  // get the graphics objects to use for drawing
	  Graphics graphics = this.getGraphics();
	  
	  // start with a black color
	  graphics.setColor(Color.black);
	  
	  // draw string x=10, y=75
	  graphics.drawString("This is a test", 100, 75);
	  
	  // draw a line from (10,20) to (300,50)
	  graphics.drawLine(10, 20, 300, 50);
	  
	  // set color yellow
	  graphics.setColor(Color.yellow);
	  
	  // draw filled rectangle upper left (0,200) width 300, height 250
	  graphics.fillRect(0, 200, 300, 500);
	  
	  // set color back to black
	  graphics.setColor(Color.black);
	  
	  // draw outline rectangle upperLH(10,210), width 200, height 100
	  graphics.drawRect(10, 210, 200, 100);
	  
	  // draw oval enclosed by a rectangle with the top LH corner (400,10) width 200, height 100
	  graphics.drawOval(400, 10, 200, 100);
	  
	  // draw arc top LH (400,300) width 200, height 150, arc starts (3 o'clock) and goes 180 degrees
	  graphics.fillArc(400, 300, 200, 150, 0, 180);
	  
	  
  }
  
  
  
  
  
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
 
  public static void main(String[] args) 
  {
	  
	  /*
	  // -------------Chapter 05 Example, Program 50-------------
	  String fileName = FileChooser.getMediaPath("beach.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.show();
	  pictureObj.drawExample();		//drawBox(Color color, int topLeftX, int topLeftY, int width, int height)
	  pictureObj.show();
	  // END -------------Chapter 05 Example, Program 50-------------
	  */
	  
	  
	  
	  /*
	  // -------------Chapter 05 Example, Program 49-------------
	  String fileName = FileChooser.getMediaPath("beach.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.show();
	  pictureObj.drawBox(java.awt.Color.red, 150, 200, 50, 50);		//drawBox(Color color, int topLeftX, int topLeftY, int width, int height)
	  pictureObj.show();
	  // END -------------Chapter 05 Example, Program 49-------------
	  */
	  
	  /*
	  // -------------Chapter 05 Example, Program 48-------------
	  String fileName = FileChooser.getMediaPath("barbara.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  pictureObj.show();
	  pictureObj.addBox();		
	  pictureObj.show();
	  // END -------------Chapter 05 Example, Program 48-------------
	  */
	  
	  /*
	  // -------------Chapter 05 Example, Program 47-------------
	  String fileName = FileChooser.getMediaPath("barbara.jpg");
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  pictureObj.show();
	  pictureObj.drawGrid();
	  pictureObj.show();
	  // END -------------Chapter 05 Example, Program 47-------------
	  */
	  
	  
	  


     
  }
  
} // this } is the end of class Picture, put all new methods before this
 