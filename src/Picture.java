import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.awt.Color.*; // added as class exercise to call the color class and methods

import static java.awt.Color.RED; // added by Robert as class exercise to call the color class and methods


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
   * Problem 8.3 Modify clearblue to use for-each look
   */

  public void clearBlue()
  {
	  Pixel[] pixelArray = this.getPixels();
		  
	  for ( Pixel value : pixelArray)
	  {
		  System.out.println(value.getBlue());
		  value.setBlue(0);
	  }
  }
  
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
  
  /*
   * Program 51: 
   * An example of using oval and arc drawing commands
   * 
   */
  public void drawFace()
  {
	  // get the graphics object
	  Graphics g = this.getGraphics();
	  
	  // start with black color
	  g.setColor(Color.black);
	  
	  // draw oval
	  g.drawOval(130, 50, 380, 380);
	  
	  // draw the ovals for the eyes
	  g.fillOval(225, 155, 40, 40);
	  g.fillOval(375, 155, 40, 40);
	  
	  // draw the arcs for the eyebrows
	  g.drawArc(225, 145, 40, 40, 45, 90);
	  g.drawArc(375, 145, 40, 40, 45, 90);
	  
	  // draw the arc for the mouth
	  g.drawArc(190, 85, 255, 255, -45, -90);
	  

  }
  
  
  /*
   * Program 52: 
   * Draw a String on a picture
   * 
   */
  public void drawString(String text, int x, int y)
  {
	  // get the graphics object
	  Graphics graphics = this.getGraphics();
	  
	  // set the color
	  graphics.setColor(Color.black);
	  
	  // set font
	  graphics.setFont(new Font("Arial", Font.BOLD,24));
	  
	  // set string
	  graphics.drawString(text, x, y);
	  
  }
  
  
  /*
   * Program 53: 
   * Draw a String on a picture
   * 
   */
  public void drawHorizontalCenteredString(String text, int y)
  {
	  // get graphics object
	  Graphics g = this.getGraphics();
	  
	  // create the font object
	  Font font = new Font("Arial", Font.BOLD, 24);
	  	  
	  // set color
	  g.setColor(Color.black);
	  
	  // get font metrics
	  FontMetrics fontMetrics = g.getFontMetrics();
	  
	  // get width of string
	  int strWidth = fontMetrics.stringWidth(text);
	  
	  // calculate center of picture
	  int center = (int)(this.getWidth() * 0.5);
	  
	  // draw string in center
	  g.drawString(text, center - (int)(strWidth * 0.5), y);

  }
  
  /*
   * Program 54: 
   * Draw gray effect onto current picture
   * 
   */
  public void drawGrayEffect()
  {
	  // create a medium gray
	  Color medGray = new Color(100, 100, 100);
	  
	  // do 100 columns of medium gray
	  for ( int x = 0; x < 100; x++)
	  {
		  for (int y = 0; y < 100; y++)
		  {
			  this.getPixel(x,y).setColor(medGray);
		  }
	  }
	  
	  // do 100 columns of gray starting at medium and getting lighter
	  for ( int x = 100, grayLevel = 100; x < 200; x++, grayLevel++)
	  {
		  for ( int y = 0; y < 100; y++)
		  {
			  this.getPixel(x, y).setColor(new Color(grayLevel, grayLevel, grayLevel));
		  }
	  }
	  
	  // do 100 columns of gray starting at medium and getting lighter
	  for ( int x = 200, grayLevel = 0; x < 300; x++, grayLevel++)
	  {
		  for ( int y = 0; y < 100; y++)
		  {
			  this.getPixel(x, y).setColor(new Color(grayLevel, grayLevel, grayLevel));
		  }
	  }
	  
	  // do 100 columns of medium gray
	  for ( int x = 300; x < 400; x++)
	  {
		  for (int y = 0; y < 100; y++)
		  {
			  this.getPixel(x,y).setColor(medGray);
		  }
	  }
  }
  
  /*
   * Program 55: 
   * Draw a picture with a succession of filled rectangles with the top LH
   * corner the darkest and the bottom RH the lightest 
   * 
   */
  public void drawFilledRectangles()
  {
	  // get graphics object
	  Graphics g = this.getGraphics();
	  Color color = null;
	  
	  // loop 25 times
	  for ( int i = 25; i > 0; i--)
	  {
		  color = new Color(i * 10, i * 5, i);
		  g.setColor(color);
		  g.fillRect(0, 0, i * 10, i * 10);
	  }
  }
  
  /*
   * Program 56: Draw the picture in 7.11
   * Method to draw a picture with a succession of rectangles on the current picture 
   * 
   */
  public void drawRectangles()
  {
	  // get graphics object
	  Graphics g = this.getGraphics();
	  Color color = null;
	  
	  // loop 25 times
	  for ( int i = 25; i > 0; i--)
	  {
		  g.setColor(Color.black);
		  g.drawRect(i, i, i * 3, i * 4);	// 
		  g.drawRect(100 + i * 4, 100 + i * 3, i * 8, i * 10);
	  }
  }
  
  /*
   * Program 57: Draw an X on a picture
   * 
   * Method to add two crossed lines to a picture. One line will go from top to bottom,
   * the other will go from bottom to top
   * 
   */
  public void drawWideX(Color color, float width)
  {
	  // get the Graphics2D object
	  Graphics graphics = this.getGraphics();
	  Graphics2D g2 = (Graphics2D) graphics;
	  
	  // set the color and brush width
	  g2.setColor(color);
	  g2.setStroke(new BasicStroke(width));
	  
	  // get the max x and y values
	  int maxX = getWidth() - 1;
	  int maxY = getHeight() - 1;
	  
	  // draw the lines
	  g2.draw(new Line2D.Double(0, 0, maxX, maxY));
	  g2.draw(new Line2D.Double(0, maxY, maxX, 0));
	  
  }
  
  /*
   * Program 58: Copy a Picture to this Picture
   * 
   * A method to copy the passed picture into the current picture at the given x and y position
   * in the current picture
   * @param source the picture to copy
   * @param x the x of the upper LH corner to copy to
   * @param y the y of the upper LH corner to copy to
   * 
   */
  public void copyPic(Picture source, int x, int y)
  {
	  // get the graphics object
	  Graphics g = this.getGraphics();
	  
	  // copy image
	  g.drawImage(source.getImage(), x, y, null);
  }
  
  /*
   * Program 59: Copy a Picture to this Picture using Graphics2D
   * 
   * A method to copy the passed picture into the current picture at the given x and y position
   * in the current picture
   * @param source the picture to copy
   * @param x the x of the upper LH corner to copy to
   * @param y the y of the upper LH corner to copy to
   * 
   */
  public void copyPic2D(Picture source, int x, int y)
  {
	  // get picture object
	  Graphics graphics = this.getGraphics();
	  Graphics g2D = (Graphics2D) graphics;
	  
	  // copy image
	  g2D.drawImage(source.getImage(), x, y, null);
  }
  
  /*
   * Program 60: General Scale Method
   * 
   * Method to create a new picture by scaling the current 
   * picture by the given x and y factor
   * @param xFactor the amount to scale in x
   * @param yFactor the amount to scale in y
   * 
   */
  public Picture scale(double xFactor, double yFactor)
  {
	  // set up the scale transform
	  AffineTransform scaleTransform = new AffineTransform();
	  scaleTransform.scale(xFactor, yFactor);
	  
	  // create a new picture object that is the right size
	  Picture result = new Picture((int)(getWidth() * xFactor), (int)(getHeight() * yFactor));
	  
	  // get the graphics 2d object to draw on the result
	  Graphics graphics = result.getGraphics();
	  Graphics2D g2d = (Graphics2D) graphics;
	  
	  // draw the current image onto the result image scaled
	  g2d.drawImage(this.getImage(), scaleTransform, null);
	  // the above line doesn't work
	  return result;
  }
  
  /*
   * Program 61: General Shear Method
   * 
   * Method to create a new picture by shearing the current picture by the given x and y factors
   * 
   * 
   */
  
  
  public Picture shear(double xFactor, double yFactor)
  {
	  // set up the shear transform
	  AffineTransform shearTransform = new AffineTransform();
	  shearTransform.shear(xFactor, yFactor);
	  Rectangle2D rect = getTransformEnclosingRect(shearTransform);
	  
	  // create a new picture object big enough to hold the result
	  Picture result = new Picture((int)(Math.ceil(rect.getWidth())), (int)(Math.ceil(rect.getHeight())));
	  
	  // get the graphics 2d object from the result
	  Graphics graphics = result.getGraphics();
	  Graphics2D g2 = (Graphics2D) graphics;
	  
	  // save the current transformation and set-up to center the new image
	  AffineTransform savedTrans = g2.getTransform();
	  AffineTransform centerTrans = new AffineTransform();
	  centerTrans.translate(0 - rect.getX(), 0 - rect.getY());
	  g2.setTransform(centerTrans);
	  
	  // draw the current image onto the result image sheared
	  g2.drawImage(this.getImage(), shearTransform, null);
	  
	  // reset g2 transformation to the saved one
	  g2.setTransform(savedTrans);
	  
	  return result;
	  

  }
  
  
  /*
   * Program 62: Using a Gradient Paint
   * 
   * 
   */
  
  public void drawSun(int x, int y, int width, int height)
  {
	  // get the graphics2D object for this picture
	  Graphics graphics = this.getGraphics();
	  Graphics2D g2D = (Graphics2D) graphics;
	  
	  // create a gradient for painting from yellow to red
	  float xMid = (float)(width / 0.5 + x);
	  GradientPaint gPaint = new GradientPaint(xMid, y, Color.yellow,xMid, y + height, Color.red);
	  
	  // set the gradient and draw the ellipse
	  g2D.setPaint(gPaint);
	  g2D.fill(new Ellipse2D.Double(x, y, width, height));
	  
  }
  
  

  /*
   * Program 63: Overlap Pictures Using AlphaComposite
   * 
   * Method to overlap one picture with another
   * 
   */
  
  public void overlapPictures(Picture p1, Picture p2, int startOverlap)
  {
	  int amountOverlap = p1.getWidth() - startOverlap;
	  
	  // get the Graphics2D object
	  Graphics graphics = this.getGraphics();
	  Graphics2D g2D = (Graphics2D) graphics;
	  
	  // draw p1 up to overlap point
	  g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1.0f));
	  g2D.drawImage(p1.getImage(), 0, 0, startOverlap,p1.getHeight(), 
			  0, 0, startOverlap,p1.getHeight(), null);
	  
	  // draw p1 in the overlap area
	  g2D.drawImage(p1.getImage(), startOverlap, 0, p1.getWidth(), p1.getHeight(), 
			  startOverlap, 0, p1.getWidth(), p1.getHeight(), null);
	  
	  // set the composite to blend the old and new pixels 50%
	  g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5f));
	  
	  g2D.drawImage(p2.getImage(), startOverlap, 0, p1.getWidth(), p2.getHeight(), 
			  0, 0, amountOverlap, p2.getHeight(), null);
	  
	  // draw p2 after the overlap
	  g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)1.0f));
	  
	  g2D.drawImage(p2.getImage(), p1.getWidth(), 0, p2.getWidth() + startOverlap,
			  p2.getHeight(), amountOverlap, 0, p2.getWidth(), p2.getHeight(), null);

}
  
  /*
   * Program 64: Clip an image to an Ellipse
   * 
   */
  
  public Picture clipToEllipse()
  {
	  
	  int width = this.getWidth();
	  int height = this.getHeight();
	  Picture result = new Picture(width, height);
	  
	  // get the graphics2D object
	  Graphics graphics = result.getGraphics();
	  Graphics2D g2D = (Graphics2D) graphics;	  
	  
	  // create an ellipse to use for clipping
	  Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, width, height);
	  
	  // use the ellipse for clipping
	  g2D.setClip(ellipse);
	  
	  // draw image
	  g2D.drawImage(this.getImage(), 0, 0, width, height, null);
	  
	  // return the result
	  return result;
	  
  }
  
  /*
   * Problem 7.5 Draw a house
   */
  
  public void drawHouse()
  {
	  // create the graphics object
	  Graphics graphics = this.getGraphics();
	  Graphics2D g2D = (Graphics2D) graphics;
	  
	  // set color
	  g2D.setColor(Color.darkGray);
	  
	  // set line thickness
	  g2D.setStroke(new BasicStroke(10));
	  
	  // determine center of the picture
	  int width = this.getWidth();
	  int height = this.getHeight();
	  int centerX = this.getWidth() / 2;
	  int centerY = this.getHeight() / 2;
	  System.out.println(width + " \t" + height);
	  System.out.println(centerX + " \t" + centerY);
	  
	  
	  // draw main house
	  g2D.drawRect((this.getWidth() / 4), (this.getHeight() / 2), 
			  ((this.getWidth() / 4) * 2), ((this.getHeight() / 8) * 3));
	  
	  // draw roof
	  g2D.drawLine((this.getWidth() / 20),((this.getHeight() / 10) * 8), centerX, (centerY / 3));
	  g2D.drawLine(centerX, (centerY / 3), ((this.getWidth() / 20) * 19),((this.getHeight() / 10) * 8));
	  
	  // draw door
	  graphics.drawRect(390, 330, 50, 80);	// door
	  graphics.drawRect(395, 335, 40, 40);	// window
	  graphics.drawOval(396, 382, 5, 5);	// knob
	 
	 
	  // draw two windows
	  graphics.drawRect(200, 270, 50, 50);	// Window
	  graphics.drawRect(280, 270, 50, 50);
	  
	  
  }
  
  
  /*
   * Problem 7.6 Add speech bubble
   */
  
  public void speechBubble()
  {
	  
	  // create the graphics object
	  Graphics graphics = this.getGraphics();
	  Graphics2D g2D = (Graphics2D) graphics;
	  
	  // set color
	  g2D.setColor(Color.GREEN);
	  
	  // set thickness
	  g2D.setStroke(new BasicStroke(10));
	  
	  // draw oval enclosed by a rectangle with the top LH corner (400,10) width 200, height 100
	  g2D.drawOval(400, 10, 200, 100);
	  
	  // draw arc
	  g2D.drawArc(400, 90, 40, 40, 110, 100);
	  g2D.drawArc(388, 40, 75, 95, 140, 90);	
	  	
	  // change text back to black
	  g2D.setColor(Color.BLACK);
	  // include text
	  g2D.drawString("\"Some clever remark!!\"", 430, 70);
	  
  }
  
  
  
  
  /**************************************************************
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
	  // Problem 8.3 Modify program 7 to use for-each look
	  Picture p = new Picture(FileChooser.getMediaPath("beach.jpg"));
	  System.out.println(p);
	  p.clearBlue();
	  p.explore();
	  */
	  
	  
	  
	  
	  
	  /*
	  // Chapter 07 problems
	  // -------------Problem 07.05 -------------------------
	  Picture picObj = new Picture(FileChooser.getMediaPath("640x480.jpg"));
	  System.out.println(picObj);
	  picObj.drawHouse();
	  picObj.speechBubble();
	  picObj.explore();
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 64-------------
	  // 	Draw sun in photo
	  Picture p = new Picture(FileChooser.getMediaPath("beach.jpg"));
	  System.out.println(p);
	  Picture p2 = p.clipToEllipse();
	  p2.show();
	  // END -------------Chapter 07 Example, Program 63-------------
	  */
	  
	  
	  // -------------Chapter 07 Example, Program 63-------------
	  // 	Draw sun in photo
	  Picture p1 = new Picture(FileChooser.getMediaPath("KatieFancy.jpg"));
	  Picture p2 = new Picture(FileChooser.getMediaPath("swan.jpg"));
	  Picture p3 = new Picture(FileChooser.getMediaPath("640x480.jpg"));
	  System.out.println(p1 + "\n" + p2 + "\n" + p3 + "\n");
	  p3.overlapPictures(p1, p2, 150);
	  p3.show();
	  // END -------------Chapter 07 Example, Program 63-------------
	  
	  
	  
	  /*
	  // -------------Chapter 07 Example, Program 62-------------
	  // 	Draw sun in photo
	  Picture pictureObj = new Picture(FileChooser.getMediaPath("beach.jpg"));
	  System.out.println(pictureObj);
	  pictureObj.drawSun(201, 80, 40, 40);
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 62-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 61-------------
	  // 	
	  Picture pictureObj = new Picture(FileChooser.getMediaPath("carolina.jpg"));
	  System.out.println(pictureObj);
	  Picture pictureObjNew = pictureObj.shear(1.0, 0.0);
	  pictureObjNew.show();
	  // END -------------Chapter 07 Example, Program 61-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 60-------------
	  // 	Works
	  Picture pictureObj = new Picture(FileChooser.getMediaPath("carolina.jpg"));
	  System.out.println(pictureObj);
	  Picture pictureObjNew = pictureObj.scale(2.0, 0.5);
	  // the above line doesn't work
	  pictureObjNew.show();
	  // END -------------Chapter 07 Example, Program 60-------------
	  *.
	  
	  /*
	  // -------------Chapter 07 Example, Program 59-------------
	  // 	
	  Picture p1 = new Picture(FileChooser.getMediaPath("beach.jpg"));
	  System.out.println(p1);
	  Picture p2 = new Picture(FileChooser.getMediaPath("turtle.jpg"));
	  System.out.println(p2);
	  p1.copyPic2D(p2, 194, 304);
	  p1.show();
	  // END -------------Chapter 07 Example, Program 59-------------
	  */
	  
	  
	  /*
	  // -------------Chapter 07 Example, Program 58-------------
	  // 	
	  Picture p1 = new Picture(FileChooser.getMediaPath("beach.jpg"));
	  System.out.println(p1);
	  Picture p2 = new Picture(FileChooser.getMediaPath("turtle.jpg"));
	  System.out.println(p2);
	  p1.copyPic(p2, 194, 304);
	  p1.show();
	  // END -------------Chapter 07 Example, Program 58-------------
	  */
	 
	  /*
	  // -------------Chapter 07 Example, Program 57-------------
	  // 
	  String fileName = FileChooser.getMediaPath("grayMotorcycle.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.drawWideX(java.awt.Color.RED, 50);
	  pictureObj.drawWideX(RED, 50);	
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 57-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 56-------------
	  // 
	  String fileName = FileChooser.getMediaPath("640x480.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  pictureObj.drawRectangles();	
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 56-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 55-------------
	  // 
	  String fileName = FileChooser.getMediaPath("640x480.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  pictureObj.drawFilledRectangles();	
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 55-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 54-------------
	  // 
	  String fileName = FileChooser.getMediaPath("640x480.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  pictureObj.drawGrayEffect();	
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 54-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 53-------------
	  // 
	  String fileName = FileChooser.getMediaPath("greece.jpg");	//640x480.jpg	
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.show();
	  String text = "This is a text string";
	  pictureObj.drawHorizontalCenteredString(text, 343);	
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 53-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 52-------------
	  // 
	  String fileName = FileChooser.getMediaPath("greece.jpg");	//640x480.jpg	
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.show();
	  pictureObj.drawString("This is a photo of Greece", 127,343);		
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 52-------------
	  */

	  /*
	  // -------------Chapter 07 Example, Program 51-------------
	  // Vector based representation = instructions to create drawing
	  String fileName = FileChooser.getMediaPath("640x480.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.show();
	  pictureObj.drawFace();		
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 51-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 50-------------
	  String fileName = FileChooser.getMediaPath("beach.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.show();
	  pictureObj.drawExample();		
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 50-------------
	  */
	  
	  /*
	  // -------------Chapter 05 Example, Program 49-------------
	  String fileName = FileChooser.getMediaPath("beach.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  //pictureObj.show();
	  pictureObj.drawBox(java.awt.Color.red, 150, 200, 50, 50);		//drawBox(Color color, int topLeftX, int topLeftY, int width, int height)
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 49-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 48-------------
	  String fileName = FileChooser.getMediaPath("barbara.jpg");		
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  pictureObj.show();
	  pictureObj.addBox();		
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 48-------------
	  */
	  
	  /*
	  // -------------Chapter 07 Example, Program 47-------------
	  String fileName = FileChooser.getMediaPath("barbara.jpg");
	  Picture pictureObj = new Picture(fileName);
	  System.out.println(pictureObj);
	  pictureObj.show();
	  pictureObj.drawGrid();
	  pictureObj.show();
	  // END -------------Chapter 07 Example, Program 47-------------
	  */
	  
	  
	  


     
  }
  
} // this } is the end of class Picture, put all new methods before this
 