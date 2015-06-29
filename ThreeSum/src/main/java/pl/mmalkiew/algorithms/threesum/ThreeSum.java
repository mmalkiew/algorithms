package pl.mmalkiew.algorithms.threesum;

/**
 * Simple ThreeSum algorithm implementation.
 * 
 * @author michal
 *
 */
public class ThreeSum 
{
	private static final int PROBLEM_SIZE = 2000;
	private static final int RANGE_NUMBER = 100;
	
	private int[] array;
	
	public int count(int[] array)
	{
		int n = array.length;
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				for (int k = j + 1; k < n; k++)
					if (array[i] + array[j] + array[k] == 0)
						count++;
		
		return count;
	}
	
	/**
	 * Construtor has to create the array and fill it with 
	 * random numbers between 0 - PROBLEM_SIZE
	 * 
	 * @param N
	 */
	public ThreeSum(int N)
	{
		array = new int[N];
		for (int i = 0; i < N; i++)
		{
			int item = (int)((Math.random()*RANGE_NUMBER) - (Math.random()*RANGE_NUMBER));
			array[i] = item;
		}
	}
	
	public static void main(String[] args)
	{
		ThreeSum threeSum = new ThreeSum(PROBLEM_SIZE);
		System.out.println(threeSum.count(threeSum.getArray()));
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
}
