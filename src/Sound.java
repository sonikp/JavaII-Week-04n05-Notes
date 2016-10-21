
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
	 * Problem 8.5: change volume, 0.5 for +ve and x2 for -ve values
	 */
	public void alteredVolume()
	{
		// create an array
		SoundSample[] sampleArray = this.getSamples();
		
		// loop through all the indexes
		for ( SoundSample value : sampleArray)
		{
			// display current value
			System.out.print(value.getValue());
			
			// test for +ve
			if (value.getValue() >= 0)
			{
				System.out.print("\t increase \t");
				value.setValue((int)(value.getValue() * 0.5));
			
			}
			// test for -ve
			else if (value.getValue() < 0)
			{
				System.out.print("\t decrease \t");
				value.setValue(value.getValue() * 2);
			}
			// display altered value
			System.out.print(value.getValue() + "\n");
			
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
	 * Problem 9.13 Normalize the first 3 seconds
	 * of a sample
	 */
	
	public int normalizeAmount(int sampleLengthSeconds)
	{
		
		
		int largest = 0;
		int maxIndex = 0;
		double sampleLength = this.getSamplingRate() * (double)(sampleLengthSeconds);
		System.out.println("sampleLength based on seconds: " + sampleLength);
		SoundSample[] sampleArray = this.getSamples();
		SoundSample sample = null;
		int value = 0;
		
		// loop through to compare absolute values
		for ( int i = 0; i < sampleLength; i++)
		{
			// get sound values
			sample = sampleArray[i];

			// make values +ve
			value = Math.abs(sample.getValue());
			
			// find largest value
			if ( value > largest)
			{
				largest = value;
				maxIndex = i;
			}
		}
		
		// calculate the multiplies
		double multiplier = 32767.0 / largest;
		System.out.println("multiplier " + multiplier);
		
		
		System.out.println("normalizeAmount(): largest " + largest + " \tlocation " + maxIndex);
		return largest;
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
	
	/*
	 * Program 71: Increase the volume then decrease
	 */
	public void increaseAndDecrease()
	{
		int half = this.getLength() / 2;
		int value = 0;
		
		// loop through the first half of the sound
		for ( int i = 0; i < half; i++)
		{
			// get the current value
			value = this.getSampleValueAt(i);
			
			// set the value to 2x the original
			this.setSampleValueAt(i, value * 2);
		}
		
		// loop through the second half of the sound
		for ( int i = half; i < this.getLength(); i++)
		{
			// get the current value
			value = this.getSampleValueAt(i);
			
			// set the value to half the original
			this.setSampleValueAt(i, (int)(value * 0.5));
			
		}
		
	}
	
	/*
	 * Problem 9.12: play for a % then decrease the volume 
	 * Needs two input values, sound and % when to decrease
	 */
	public void decreaseAtPercentage(Sound source, double percentage)
	{
		int length = source.getLength();
		double volumeDropLocation =  (percentage/100.0) * source.getLength();	// add the .0 to 100 makes this a double value
		int value = 0;
		
		for ( int  i = (int)volumeDropLocation; i < length; i++)
		{
			
			// get the current value
			value = this.getSampleValueAt(i);
		
			// set the value to 2x the original
			this.setSampleValueAt(i, (int)(value * 0.5));
		}
	}
	
	
	
	/*
	 * Problem 9.13: normalize the first second, then reduce by 1/5 every second
	 *  
	 */
	public void decreaseAtARate(Sound source, int seconds)
	{
		/*
		int length = source.getLength();
		double sampleRate = source.getSamplingRate();
		System.out.println(length + " " + sampleRate);
		double timeInSeconds =  length / sampleRate;
		System.out.println(timeInSeconds);
		System.out.println("------------------------");
		System.out.println(source.getLength()/ source.getSamplingRate());
		
		double sampleLength = this.getSamplingRate() * (double)(seconds);
		
		*/
		
		// same formula for calculating locations
//		double sampleLength = this.getSamplingRate() * (double)(seconds);
		
		source.normalizeAmount(seconds);
		

		
		// 
	}
	
	/*
	 * Program 72: Create a Sound Clip
	 */
	public Sound clip(int start, int end)
	{
		// calculate the number of samples in the clip
		int lengthInSamples = end - start + 1;
		Sound target = new Sound(lengthInSamples);	// hold clip
		int value = 0;								// holds the current sample value
		int targetIndex = 0;						// index in target sound
		
		// copy from start to end from source into target
		for ( int i = start; i <= end; i++)
		{
			value = this.getSampleValueAt(i);
			target.setSampleValueAt(i, value);
		}
		return target;
	}
	
	/*
	 * Program 73: Splice words into a single sentence
	 */
	public void splice()
	{
		Sound sound1 = new Sound(FileChooser.getMediaPath("guzdial.wav"));
		Sound sound2 = new Sound(FileChooser.getMediaPath("is.wav"));
		
		int targetIndex = 0;	// the starting place on the target
		int value = 0;
		
		// copy all of the sound 1 into the current sound (target)
		for ( int i = 0; i < sound1.getLength(); i++, targetIndex++)
		{
			value = sound1.getSampleValueAt(i);
			this.setSampleValueAt(targetIndex, value);
		}
		
		// create silence between words by setting values to 0
		for ( int i = 0; i < (int)(this.getSamplingRate() * 0.1); i++, targetIndex++)
		{
			
			this.setSampleValueAt(targetIndex, 0);
			
		}
		
		// copy all of sound 2 into the current sound (target)
		for ( int i = 0; i < sound2.getLength(); i++, targetIndex++)
		{
			
			value = sound2.getSampleValueAt(i);
			this.setSampleValueAt(targetIndex, value);
			
		}
	}
	
	/*
	 * Program 74: Splice words into a single sentence
	 */
	public void splicePreamble()
	{
		String file = FileChooser.getMediaPath("preamble10.wav");
		Sound source = new Sound(file);
		int targetIndex = 0;	// start copying to first sample value
		int value = 0;
		
		// loop copying the "We the " into the current sound
		for (int sourceIndex = 0; sourceIndex < 17407; sourceIndex++, targetIndex++ )
		{
			
			value = source.getSampleValueAt(sourceIndex);
			this.setSampleValueAt(targetIndex, value);
			
		}
		
		
		// loop copying the "united" into the current sound
		for (int sourceIndex = 33414; sourceIndex < 40052; sourceIndex++, targetIndex++)
		{
			value = source.getSampleValueAt(sourceIndex);
			this.setSampleValueAt(targetIndex, value);
			
		}
		
		// copy the "people of the United States"
		for ( int sourceIndex = 17408; sourceIndex < 55510; sourceIndex++, targetIndex++)
		{
			value = source.getSampleValueAt(sourceIndex);
			this.setSampleValueAt(targetIndex, value);
			
		}
		
	}
	
	/*
	 * Program 75: Splice Preamble and Show Target Index
	 */
	public void splicePreamble2()
	{
		String file = FileChooser.getMediaPath("preamble10.wav");
		Sound source = new Sound(file);
		int targetIndex = 0;
		int value = 0;
		
		// loop copying the "we the " int the current sound
		for ( int sourceIndex = 0; sourceIndex < 17407; sourceIndex++, targetIndex++)
		{
			value = source.getSampleValueAt(sourceIndex);
			this.setSampleValueAt(targetIndex, value);
		}
		
		// print value of the target index
		System.out.println("Target index is " + targetIndex);
		
		// loop copying the "united" into the current sound
		for (int sourceIndex = 33414; sourceIndex < 40052; sourceIndex++, targetIndex++)
		{
			value = source.getSampleValueAt(sourceIndex);
			this.setSampleValueAt(targetIndex, value);
			
		}
		
		// print the value of the target index
		System.out.println("Target index is " + targetIndex);
		
		// copy the "people of the United States"
		for (int sourceIndex = 17408; sourceIndex < 55510; sourceIndex++, targetIndex++)
		{
			value = source.getSampleValueAt(sourceIndex);
			this.setSampleValueAt(targetIndex, value);
		}
		
		// print the value of the target index
		System.out.println("Target index is " + targetIndex);
		
	}
	
	/*
	 * Program 76: General Splice Methods
	 */
	public void splice(Sound source, int sourceStart, int sourceStop, int targetStart)
	{
		// loop copying from source to target
		for ( int sourceIndex = sourceStart, targetIndex = targetStart; 
				sourceIndex < sourceStop && targetIndex < this.getLength(); 
				sourceIndex++, targetIndex++)
		{
			this.setSampleValueAt(targetIndex, source.getSampleValueAt(sourceIndex));
			
		}
	}
	
	/*
	 * Program 77: Using the General Splice Method
	 */
	public void splicePreambleTwo()
	{
		Sound preamble = new Sound(FileChooser.getMediaPath("preamble10.wav"));	// sec3silence.wav
		
		// first splice the "we the " into the current sound
		this.splice(preamble,0,17407,0);
		
		// now splice the "united" into the current sound
		this.splice(preamble,33414,40052,17407);
		
		// now splice the "people of the United States" into the current sound
		this.splice(preamble,17408,55510, 24045);
	}
	
	/*
	 * Program 78: Reverse a sound
	 */
	public void reverse()
	{
		Sound orig = new Sound(this.getFileName());
		int length = this.getLength();
		
		// loop through the samples
		for (int targetIndex = 0, sourceIndex = length - 1; targetIndex < length && sourceIndex > 0;
				targetIndex++, sourceIndex--)
		{
			this.setSampleValueAt(targetIndex, orig.getSampleValueAt(sourceIndex));
		}
	}
	
	/*
	 * Program 79: Mirror a sound
	 */
	public void mirror()
	{
		int length = this.getLength(); 		// save the length
		int mirrorPoint = length / 2;		// mirror around this point
		int value = 0;						// hold the current value
		
		// loop from 0 to mirrorPoint
		for ( int i = 0; i < mirrorPoint; i++)
		{
			value = this.getSampleValueAt(i);
			this.setSampleValueAt(length - 1 - i, value);
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
	  
	  // Problem 9.13:
	  String f = FileChooser.getMediaPath("preamble.wav");
	  Sound s = new Sound(f);
	  
	  // get sample rate
	 // int seconds = 1;
	
	 // System.out.println(s.getSamplingRate() * seconds);
	 // System.out.println(s.getLength());
	  
//	  s.explore();
	  s.decreaseAtARate(s, 1);
//	  s.normalizeAmount(1);
//	  s.explore();
	  
	  /*
	  // Problem 9.12:
	  String f = FileChooser.getMediaPath("preamble.wav");
	  Sound s = new Sound(f);
	  s.explore();
	  s.decreaseAtPercentage(s, 25);
	  s.explore();
	  */
	  
	  /*
	  // Program 79:
	  String f = FileChooser.getMediaPath("thisisatest.wav");
	  Sound s = new Sound(f);
	  s.explore();
	  s.mirror();
	  s.explore();
	  */
	  
	  /*
	  // Program 78: Mirror
	  String filename = FileChooser.getMediaPath("thisisatest.wav");	// croak.wav
	  Sound hearMe = new Sound(filename);
	  //hearMe.play();
	  hearMe.reverse();
	  hearMe.play();
	  */
	  
	  /*
	  // Program 77 & 76: 
	  String filename = FileChooser.getMediaPath("sec3silence.wav");	
	  Sound target = new Sound(filename);
	  target.splicePreambleTwo();
	  target.play();
	  */
	  
	  /*
	  // Program 75:
	  String silence = FileChooser.getMediaPath("sec3silence.wav");	
	  Sound target = new Sound(silence);
	  target.explore();
	  target.splicePreamble2();
	  target.explore();
	  */
	  /*
	  // Program 74: 
	  String silence = FileChooser.getMediaPath("sec3silence.wav");	
	  Sound target = new Sound(silence);
	  target.explore();
	  target.splicePreamble();
	  target.explore();
	  */
	  
	  /*
	  // Chapter 9 Program 73: Splice Words into a single sentence
	  String silence = FileChooser.getMediaPath("sec3silence.wav");
	  Sound target = new Sound(silence);
	  target.play();
	  target.splice();
	  target.play();
	  */
	  
	  /*
	  // Chapter 9 Program 72: Create a sound clip
	  Sound test = new Sound(FileChooser.getMediaPath("thisisatest.wav"));
	  test.explore();
	  Sound s1 = test.clip(0, 8500);
	  s1.explore();
	  */
	  /*
	  // example to get the elements at various index values
	  Sound sound = new Sound(FileChooser.getMediaPath("croak.wav"));
	  SoundSample[] sampleArray = sound.getSamples();
	  System.out.println(sampleArray[0]);
	  System.out.println(sampleArray[1]);
	  System.out.println(sampleArray[8000]);
	  Sound soundNew = new Sound(FileChooser.getMediaPath("thisisatest.wav"));
	  SoundSample[] sampleArrayNew = soundNew.getSamples();
	  System.out.println(soundNew);
	  soundNew.explore();
	  */
	  
	  /*
	  // Chapter 9 Program 71:
	  String f = FileChooser.getMediaPath("preamble.wav");
	  Sound s = new Sound(f);
	  s.explore();
	  s.increaseAndDecrease();
	  s.explore();
	  */
	  
	  /*
	  // Problem 8.5: change volume 0.5 for +ve and x2 for -ve
	  String f = FileChooser.getMediaPath("preamble.wav");
	  Sound s = new Sound(f);
	  System.out.println(s);
	  s.alteredVolume();
	  */
	  
	  
	  /*
	  // Problem 8.2 use for-each loop
	  String f = FileChooser.getMediaPath("preamble.wav");
	  Sound s = new Sound(f);
	  System.out.println(s);
	  s.increaseVolume2();
	  */
	  
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