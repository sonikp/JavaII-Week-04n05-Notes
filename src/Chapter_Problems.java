public class Chapter_Problems
{
	
	public void test1()
	{
		for ( int x = 5; x > 0; x--)
		{
			System.out.println(x);
		}
	}
	
	public String test3(int x)
	{
		
		return "In Test3" + x;
	}
	
	public String test4(int x)
	{
	
		return Integer.toString(x);
	}
	
	
	public static void main(String[] args)
	{
		
		
		Chapter_Problems n = new Chapter_Problems();
		System.out.println(n.test4(4));
	
		
		for (int i = 10; i <= 10; i++)
		{
	
			System.out.println(i);

		}
		
		
		// chapter 09 problems
		/*
		
		
		
		*/
		// chapter 08 problems
		
		/*
		
		8.6 v
		
		1
		2
		3
		
		8.7 v
		
		loop increasing count indefinitely
		
		8.8 X
		
		3
		x is 3
		
		8.9 v
		
		3, 1
		
		8.10 X <=== does an extra run for x = 10;???
		
		3, 1
		4, 2
		5, 3
		6, 4
		7, 5
		8, 6
		9, 7
		
		8.11	v
		nothing
		
		8.12 v
		
		13, 1
		
		8.13 X <= error !< is not correct syntax
		
		increasing count from:
		13, 1
		
		8.14: X <= incorrect
		13,1 increaseing
		
		8.15 v
		Nothing
		
		
		
		
		
		*/
		
		/*
		
		8.1
		Clipping : when a amplitude of a waveform exceeds the max/min sample size 2^15 or 32767
		Clipping appears when the waveforms has changes shape suddenly and does not follow it's 
		normal contour
		
		Normalization:
		finding the maximum amplitude of a waveform, identifying that maximum in comparison with largest
		possible amplitude, and creating a multiplier value by maxPossibleAmpl/maxAmpOfWave. Then
		multiplying all other wave amplitudes by that value
		
		Amplitude:
		The distance from zero to greatest pressure (or least pressure) of a waveform is 
		amplitude
		
		Rarefactions:
		Decreases in airpressues for a waveform, as opposed to the increases in pressure are
		called compressions
		
		WAV:
		is a standard encoding for sound
		
		Iterate:
		Step through each consecutive value in a loop
		
		for-each loop:
		for (String item : someList)
		sequential step loop through all the items in a list. 
		
		Sine Wave: 
		The simplest form of a sound wave. In a sine wave the compressions and rarefactions 
		arrive with equal size and regularity.
		
		
		*/
	}
}