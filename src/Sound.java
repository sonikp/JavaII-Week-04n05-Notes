
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound. 
 * 
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound
{
  
  /////////////// consructors ////////////////////////////////////
  
  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }
  
  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }
  
  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }
  
  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }
  
  ////////////////// methods ////////////////////////////////////
  
  public void doNothing()
	{
		SoundSample[] sampleArray = this.getSamples();
		int value = 0;
		
		// loop through all the samples in the array
		for (SoundSample sample : sampleArray)
		{
			value = sample.getValue();
			sample.setValue(value);
		}
	}
	
	public void doNothingWhileLoop()
	{
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		int index = 0;
		int value = 0;
		
		// loop through all the samples in the array
		while ( index < sampleArray.length)
		{
			sample = sampleArray[index];
			value = sample.getValue();
			sample.setValue(value);
			// or sample.setValue(sample.getValue());
			index++;
		}
		
	}
	
	/*
	 * Program 65: Increase an Input Sound's Volume
	 */
	public void increaseVolume()
	{
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		int index = 0;
		int value = 0;
		
		// loop through all the samples in the array
		while (index < sampleArray.length)
		{
			sample = sampleArray[index];
			value = sample.getValue();
			sample.setValue(value * 2);
			index++;
		}
	}
	
	/*
	 * Problem 8.2 Modify to use for-each loop
	 */
	public void increaseVolume2()
	{

		
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		
		// for-each loop
		for ( SoundSample value : sampleArray)
		{
			System.out.println(value);
		}
		
	}
  
	/*
	 * Program 66: Decrease an Input Sound's Volume
	 */
	public void decreaseVolume()
	{
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		int value = 0;
		int index = 0;
		
		// loop through all the samples in the array
		while ( index < sampleArray.length)
		{
			sample = sampleArray[index];
			value = sample.getValue();
			sample.setValue((int) (value * 0.5));
			index++;
		}
	}
	
	/*
	 * 
	 * Program 67: Decrease an Input Sound's Volume using a for loop
	 */
	public void decreaseVolume2()
	{
		SoundSample sampleArray[] = this.getSamples();
		SoundSample sample = null;		
		
		// for loop
		for ( int i = 0; i < sampleArray.length; i++)
		{
			sample = sampleArray[i];
			//System.out.print(sample + " \t");		// debug
			sample.setValue((int)(sample.getValue() * 0.5));
			sample = sampleArray[i];
			//System.out.print(sample + " \n");		// debug
		}
	}
	
	/*
	 * Program 68: Change sounds volume by a factor
	 */
	public void changeVolume(double factor)
	{
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		
		for ( int i = 0; i < sampleArray.length; i++)
		{
			sample = sampleArray[i];
			sample.setValue((int)(sample.getValue() * factor));
		}
	}
	
	/*
	 * Program 69: Normalize the sound to a Maximum amplitude
	 */
	public void normalize()
	{
		int largest = 0;
		int maxIndex = 0;
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		int value = 0;
		
		// loop comparing the absolute value of the current value to the current largest
		for (int i = 0; i < sampleArray.length; i++)
		{
			sample = sampleArray[i];
			value = Math.abs(sample.getValue());	
			//System.out.print(i + "\t" + value + "\t" + largest +  "\t" + maxIndex + "\n"); // debug
			if ( value > largest)
			{
				largest = value;
				maxIndex = i;
			}
		}
		
		// calculate the multiplier (32767.0 = constant for largest allowed value, page 281)
		double multiplier = 32767.0 / largest;
		
		// print largest value and the multiplier
		System.out.println("The largest value was " + largest + " at index " + maxIndex);
		System.out.println("The multiplier is " + multiplier);
		
		// loop through all samples and multiply by the multiplier
		for ( int i = 0; i < sampleArray.length; i++)
		{
			sample = sampleArray[i];
			sample.setValue((int)(sample.getValue() * multiplier));
		}
		
	}
	
	/*
	 * Program 70: Set all samples to extreme volume
	 */
	public void forceToExtreme()
	{
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		
		// loop through the sample values
		for ( int i = 0; i < sampleArray.length; i++)
		{
			// get the current sample
			sample = sampleArray[i];
			
			// if value was +ve (or zero) set to maximum
			if ( sample.getValue() >= 0)
			{
				sample.setValue(32767);
			}
			// else force to max -ve value
			else 
			{
				sample.setValue(-32768);
			}
		}
	}
	
  
  /************************************************************
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();
    
    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;
    
    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();
    
    return output;
  }
 
  public static void main(String[] args)
  {
	  // Problem 8.2 use for-each loop
	  String f = FileChooser.getMediaPath("preamble.wav");
	  Sound s = new Sound(f);
	  System.out.println(s);
	  s.increaseVolume2();

	  
	  /*
	  // Program 70: set to max // min
	  String f = FileChooser.getMediaPath("preamble.wav");
	  Sound s = new Sound(f);
	  System.out.println(s);
	  s.explore();
	  s.forceToExtreme();
	  s.explore();
	  */
	  
	  /*
	  // Program 69: normalizing
	  String f = "/Users/Shared/Java-Libraries/CourseCD/mediasources/preamble.wav";
	  Sound s = new Sound(f);
	  System.out.println(s);
	  s.explore();
	  s.normalize();
	  s.explore();
	  */
	  
	  /*
	  // Program 68: change volume with a factor
	  String f = FileChooser.getMediaPath("gettysburg.wav");
	  Sound s = new Sound(f);
	  System.out.println(s);
	  s.explore();
	  s.changeVolume(3);
	  s.explore();
	  */
	  
	  
	  /*
	  // Program 67; decrease volume with for loop
	  String f = FileChooser.getMediaPath("gettysburg.wav");
	  Sound s = new Sound(f);
	  System.out.println(s);
	  s.decreaseVolume2();
	  */
	  
	 /*
	  // Program 66; decrease volume
	  String f = FileChooser.getMediaPath("gettysburg.wav");
	  Sound s = new Sound(f);
	  System.out.println(s);
	  
	  
	  // do stuff
	  s.play();
	  s.explore();
	  s.decreaseVolume();
	  s.explore();
	  s.write("/Users/Shared/Java-Libraries/CourseCD/results/gettysburgQUIETER.wav");
	  
	  
	  // check results
	  String r = "/Users/Shared/Java-Libraries/CourseCD/results/gettysburgQUIETER.wav";
	  System.out.println(r);
	  Sound o = new Sound(r);
	  System.out.println(s.getSampleValueAt(0));
	  System.out.println(o.getSampleValueAt(0));
	  System.out.println(s.getSampleValueAt(1));
	  System.out.println(o.getSampleValueAt(1));
	  System.out.println(s.getSampleValueAt(999));
	  System.out.println(o.getSampleValueAt(999));
	  */
	  
	  
	  /*
	  // Chapter 08 Sound
	  // Program 65: increase volume
	  String f = FileChooser.getMediaPath("gettysburg.wav");
	  System.out.println(f);
	  Sound s = new Sound(f);
	  // play and increase volume
	  s.play();
	  s.explore();
	  s.increaseVolume();
	  //write the file to the filesystem
	  s.write("/Users/Shared/Java-Libraries/CourseCD/results/gettysburgLOUDER.wav");
	  s.play();
	  s.explore();
	  
	  // check results
	  String results = "/Users/Shared/Java-Libraries/CourseCD/results/gettysburgLOUDER.wav";
	  Sound checkResults = new Sound(results);
	  checkResults.explore();
	  
	  // check results
	  System.out.println(s);
	  System.out.println(checkResults);
	  
	  System.out.println(s.getSampleValueAt(0));
	  System.out.println(checkResults.getSampleValueAt(0));
	  System.out.println(s.getSampleValueAt(1));
	  System.out.println(checkResults.getSampleValueAt(1));
	  System.out.println(s.getSampleValueAt(999));
	  System.out.println(checkResults.getSampleValueAt(999));
	  */
	  
 		
 		
 		/*
 		//Chapter 08 notes
 		 * 
 		 
 		 Sound sound1 = new Sound(FileChooser.pickAFile());
    	sound1.explore();
 		 
 		 
 		  String fileName = FileChooser.getMediaPath("preamble.wav");
 		  Sound sound1 = new Sound(fileName);
 		  System.out.println(sound1);
 		  
 		  SoundSample[] sampleArray = sound1.getSamples();
 		  System.out.println(sampleArray.length);
 		  
 		  System.out.println(sound1.getSampleValueAt(0));
 		  System.out.println(sound1.getSampleValueAt(1));
 		  
 		  System.out.println(sound1.getLength());
 		  //sound1.getSampleValueAt(50000);		// generates an error message as part of this example
 		  
 		  System.out.println(sound1.getSampleValueAt(0));
 		  sound1.setSampleValueAt(0, 12);
 		  System.out.println(sound1.getSampleValueAt(0));
 		  
 		  String differentFile = FileChooser.getMediaPath("preamble.wav");
 		  Sound aSound = new Sound(differentFile);
 		  System.out.println(aSound.getSamplingRate());
 		  //write the file to the filesystem
 		  aSound.write("/Users/Shared/Java-Libraries/CourseCD/results/preamble-op.wav");
 		  aSound.play();
 		  aSound.blockingPlay();
 		  */
    
    
  }
             
} // this } is the end of class Sound, put all new methods before this