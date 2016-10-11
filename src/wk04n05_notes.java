public class wk04n05_notes
{
	public static void main(String[] args)
	{
		System.out.println("Module 3");
		System.out.println("New CourseMaterial: /Users/Shared/Java-Libraries/CourseCD");
		
		/*
		 *  1. Viewing the Java API
		 *  
		 *  
		 *  
		 *  2. Packages, related libraries
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
		 *  3. Inheritance
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
		 *  4. Interfaces
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
		 *  
		 *  
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}