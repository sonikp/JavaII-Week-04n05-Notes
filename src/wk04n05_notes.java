import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class wk04n05_notes
{
	public static void main(String[] args)
	{
		System.out.print("Module 3 Chapter 07 to 10");
		System.out.print("\tNew Course Material: /Users/Shared/Java-Libraries/CourseCD \n*************************"
				+ "***************************************************************** \n\n");
		
		
		String str = new String("       this string ends with balls      ");
		String var1 = str.trim();
		System.out.println(str);
		System.out.println(var1);
		
		/*
		 * Chapter 07 problems
		 * 
		 * 7.5 --------------------------------------------------------------------------------------------------
		 * 
		 * Draw house in Picture.java
		 * 
		 * 7.4 --------------------------------------------------------------------------------------------------
		 * 
		 * JPEG, BMP, AutoCAD
		 * 
		 * 
		 * 
		 * 7.3 --------------------------------------------------------------------------------------------------
		 * 
		 * 1. what methods from the String class are inherited?
		 * 
		 * Methods inherited from class java.lang.Object:
		 * clone, finalize, getClass, notify, notifyAll, wait, wait, wait
		 * 
		 * Methods inherited from interface java.lang.CharSequence:
		 * chars, codePoints
		 * 
		 * 2. String class inherits from java.lang.Object, & java.lang.CharSequence
		 * 
		 * 3. Math inherits from java.lang.Object
		 * 
		 * 4. Integer class inherits from java.lang.Object
		 * 
		 * 5. the interfaces in java.lang are:
		 *  Appendable
			AutoCloseable
			CharSequence
			Cloneable
			Comparable
			Iterable
			Readable
			Runnable
			Thread.UncaughtExceptionHandler
			
			6. Goto the Interface Comparable, and look at the "All Known Implementing Classes"
			
			7. the string class implements the following interfaces:
			Serializable, CharSequence, Comparable<String>
			
			
		 * 
		 * 7.2 --------------------------------------------------------------------------------------------------
		 * 
		 * 1. endsWith
		 * 
		 	String str = new String("this string ends with balls");
			boolean var1 = str.endsWith("nuts");
			boolean var2 = str.endsWith("balls");
			System.out.println(var1 + " \t" + var2);
		 
		 	2. first position of a character: indexOf();
		 	
		 	String str = new String("this string ends with balls");
			int var1 = str.indexOf("a");
			System.out.println(var1);
		 	
		 	3. last position of a character: lastIndexOf();
		 	
		 	String str = new String("this string ends with balls");
			int var1 = str.lastIndexOf("i");
			System.out.println(var1);
			
			4. removes extra whitespace before and after the other characters : trim();
		 	
		 	String str = new String("       this string ends with balls      ");
			String var1 = str.trim();
			System.out.println(str);
			System.out.println(var1);
		 * 
		 * 
		 * 
		 * 7.1 --------------------------------------------------------------------------------------------------
		 * 
		 * Compression:
		 * 
		 * A technique used to reduce file sizes, by grouping similar data and reducing the same groupings of data.
		 * 
		 * A constant:
		 * 
		 * A constant are variables that are declared with the keyword final, which means the value of the
		 * variable cannot change
		 * 
		 * Vector Graphics:
		 * 
		 * Graphics created using computer programs and algorithms to create a picture when desired
		 * 
		 * Bitmapped Graphics:
		 * 
		 * A image representation as a file, containing pixel representations for each location of the picture file.
		 * 
		 * A Package:
		 * 
		 * A package id a collection of related classes. Java defines a large number of classes, and for ease of use
		 * groups similar related functions into the same package.
		 * 
		 * Inheritance:
		 * 
		 * A subclass inheriting the methods and fields for the parent class. In Java, a class can
		 * only inherit from one parent. The subclass then inherits all the classess and methods and fields from 
		 * all the previous inheritances 
		 * 
		 * An Interface
		 * 
		 * An interface is a boundary between two things. In Java it is a reference type. It is similar to a class. It is a collection
		 * of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface
		 * 
		 */
		
		
		
		/*
		 * Program 59: Important note on inheritance
		 * 
		 * An object of a child class can invoke public methods that are
		 * defined in a parent class just as if they were defined in the child class.
		 * An object of a child class can also access any public fields in a parent 
		 * class as if they were defined in the child class
		 */
		
		
		
		
		/*
		 *  ***************************************************************
		 *  Notes from lessons for Module 3 Chapter 07 to 10
		 *  ***************************************************************
		 *  
		 *  1. Viewing the Java API ---------------------------------------
		 *  
		 *  
		 *  
		 *  2. Packages, related libraries ---------------------------------------
		 *  
		 *  package com.acme.area51.projectX.teleportation;
		 *  
		 *  To import:
		 *  
		 *  import com.acme.area51.projectX.teleportation.AntiMatter;
		 *  
		 *  Import statement allows for the creation of an AntiMatter object:
		 *  
		 *  AntiMatter amObj = new AntiMatter();
		 *  
		 *  Without it, to create the same object
		 *  
		 *  com.acme.area51.projectX.teleportation.AntiMatter amObj = new com.acme.area51.projectX.teleportation.AntiMatter();
		 *  
		 *  Common classes are provided as zipped up package hierarchies know as .jar (i.e. java archive files)
		 *  
		 *  
		 *  
		 *  3. Inheritance ---------------------------------------
		 *  
		 *  When a class inherits from another class, it gets all the fields (instance variables) 
		 *  and methods of the class it inherits from.
		 *  
		 *  Inheritance has a IS-A relationship, therefore, when the class inherits
		 *  similar classes from a parent, then we say it has an IS-A relationship.
		 *  
		 *  Inheritance Terminology (pairs):
		 * 
		 *  super		sub
		 *  parent		child
		 *  base		derived
		 *  
		 *  A subclass inherits from a superclass
		 *  A child class inherits from a parent class
		 *  A derived class inherits from its base class	
		 * 
		 * Example:
		 * 
		 * public class Picture extends SimplePicture
		 * 
		 * extends = inherits
		 * 
		 * A subclass is said to inherit from its superclass
		 * 
		 * In the SimplePicture.java file, there is the statement:
		 * 
		 * private BufferedImage bufferedImage;
		 * 
		 * This BufferedImage is an object field within the SimplePicture object;
		 * in other words, a SimplePicture object contains (or HAS-A) BufferedImage object
		 * 
		 * NB: the 'private' keyword ensures that this field cannot be accessed 
		 * from outside of the SimplePicture object
		 * 
		 *  
		 *  // exercise from class lesson, slide 15 / 30
		 *  
		 *  AWT Graphics (slide 15)
		 *  
		 *  Downcasting is generally very dangerous, since you run the risk of downcasting
		 *  to a class level that doesnt match the class that the object was instantiated from
		 *  
		 *  4. Interfaces ---------------------------------------
		 *  
		 *  - Interfaces are class-like constructs that generally do not have data fields,
		 *    and only define method declarations
		 *    
		 *  - Interfaces do not provide method bodies, they only provide method declarations
		 *  
		 *  - Objects cannot be instantiated from an interface
		 *  
		 *  - Java can only extend (inherit from) one class
		 *  - Java CAN implement multiple interfaces.
		 *  
		 *  - the ability to implement multiple interfaces confers a multiple inheritance-like ability to 
		 *    Java classes
		 *  
		 *  Interface = provides a method body for each of the methods declared by the interfaces that the
		 *  class implements
		 *  
		 *  Abstract = a class that does not provide method bodies for all of the interface methods, whic
		 *  means that objects cannot be instantiated from that class
		 *  
		 *  Example:
		 *  
		 *  public interface Peaceable // within file Peaceable.java
		 *  {
		 * 		void governPeacefully();
		 *  }
		 *  
		 *  public abstract class Utopia implements Peaceable // in Utopia.java
		 *  {
		 *  	...
		 *  }
		 *  
		 *  read/look at:
		 *  Java API spec docs under java.awt package within the Interfaces section
		 *  
		 *  5. Static Methods ---------------------------------------
		 *  
		 *  Non-static = are methods that belong to various objects instantiated from a given class
		 *  Non-static = are defined within a class definition, but are invoked upon the objects that have been instantiated from 
		 *  that class
		 *  
		 *  Static Methods, do not belong to objects, they belong to a given class - in a sense they stay within that class
		 *  Static Methods; are invoked upon the class, using the class name rather than an object reference
		 *  
		 *  Example : Non-static
		 *  
		 *  Account savings = new Account( 350.42 ); // Object must be created
		 *  System.out.println( savings.getBalance ()); // Object reference uset to invoke
		 *  
		 *  Static method
		 *  
		 *  // Object does not need to be created
		 *  System.out.println( Account.getBankName()); // Class name used to invoke
		 *  
		 *  Private Methods:
		 *  
		 *  are only methods that can only be invoked from within the object it belongs to
		 *  are usually methods that serve as utility methods, methods that help other public methods do their jobs
		 *  best practice to restrict visibility as much as possible
		 *  if a method doesn't need to be public, the it should not be.
		 *  if you can do what you need when a method is private, then it should be private.
		 *  
		 *  6. Another way to Draw
		 *  
		 *  Swing
		 *  
		 *  Swing is a package that provides a rich set of user-interface classes
		 *  JFrame is a Swing class = enclosing window frame of a basic Java application
		 *  JPanel is a Swing class = has it's own Graphics (Graphics2D) object, allowing drawing within the panel
		 *  JPanel class has a paintComponent(Graphics g)
		 *  paintComponent is invoked automatically by the Swing event=dispatch thread
		 *  
		 *   
		 *  
		 */
		
		
		/*
		
		  public void addBox()		// exercise from class lesson, slide 15 / 30
  {
	  Graphics gr = this.getGraphics();
	  gr.setColor(Color.red);
	  gr.fillRect(150, 200, 50, 50);
	  
	  
	  // casting a graphics object(downcasting) from graphics down to graphics2D
	  Graphics g = this.getGraphics();
	  Graphics2D g2 = (Graphics2D) g;	// enables use of Graphics
	  g2.setColor(Color.BLUE);
	  g2.fillRect(10, 40, 80, 60);
	  g2.setColor(Color.RED);
	  g2.drawString("I took the red pill", 2 ,2);
  }
		
		
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}