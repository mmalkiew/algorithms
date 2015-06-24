package pl.mmalkiew.algorithms.bubblesort;

/**
 * Simple BubbleSort algorithm implementation.
 * 
 * @author mmalkiew
 *
 */
public class BubbleSort 
{
	private static final int PROBLEM_SIZE = 100;
	private static final int RANGE_NUMBER = 100;
	private int[] array;
	
	/**
	 * Constructor has to create the array and fill it with 
	 * random numbers between 0 - PROBLEM_SIZE
	 * 
	 * @param N - problem size
	 */
	public BubbleSort(int N)
	{
		array = new int[N];
		for (int i = 0; i < N; i++)
		{
			int item = (int)(Math.random()*RANGE_NUMBER);
			array[i] = item;
		}
	}
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BubbleSort bs = new BubbleSort(PROBLEM_SIZE);
		//	prints the array
		bs.printArray();
		
		//	sorts the array
		bs.sort();
		
		System.out.println();
		
		//	prints the array
		bs.printArray();
	}
	
	/**
	 * Internally calls to bubblesort algorithm
	 */
	public void sort()
	{
		int left = 0;
		int right = array.length - 1;
		
		bubbleSort(left, right);
	}
	
	/**
	 * Bubble sort algorithm.
	 * 
	 * @param left first index of the array
	 * @param right last index of the array
	 */
	private void bubbleSort(int left, int right)
	{
		for (int i = right; i > 1; i--)
		{
			for (int j = left; j < i; j ++)
			{
				if (array[j] > array[j + 1])
					swap(j, j + 1);
			}
		}
	}
	
	/**
	 * THis method is used to swap the values between the two given index
	 * @param left first index of the array
	 * @param right second index of the array
	 */
	private void swap(int left, int right)
	{
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
	
	/**
	 * This method prints the contents of the array.
	 */
	private void printArray()
	{
		for (int i : array)
			System.out.print(i + " ");
	}

}
