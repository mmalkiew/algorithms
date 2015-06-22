package pl.mmalkiew.algorithms.mergesort;

/**
 * Simple MergeSort algorithm implementation.
 * 
 * @author mmalkiew
 *
 */
public class MergeSort 
{
	private static final int PROBLEM_SIZE = 100;
	private static final int RANGE_NUMBER = 100;
	
	private int[] numbers;
	private int[] helper;
	
	/**
	 * Construtor has to create the array and fill it with 
	 * random numbers between 0 - PROBLEM_SIZE
	 * 
	 * @param N
	 */
	public MergeSort(int N)
	{
		numbers = new int[N];
		helper = new int[N];
		for (int i = 0; i < N; i++)
		{
			int item = (int)(Math.random()*RANGE_NUMBER);
			numbers[i] = item;
		}
	}
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		MergeSort ms = new MergeSort(PROBLEM_SIZE);
		//	prints init array
		ms.printArray();
		
		//	sort init array
		ms.sort();
		
		System.out.println("");
		
		//	print sorted array
		ms.printArray();
		
	}
	
	/**
	 * This method sorts an array and internally calls MergeSort
	 */
	public void sort()
	{
		mergeSort(0, numbers.length - 1);
	}
	
	/**
	 * This method is used to sort the array using mergesort algorithm.<br/>
	 * 
	 * @param low index of the left side
	 * @param high index of the right side
	 */
	private void mergeSort(int low, int high)
	{
		/*
		 * Check if low is smaller then high, if not then
		 * the array is sorted
		 */
		if (low < high)
		{
			/*
			 * Get the index of the element which is in the middle
			 */
			int middle = low + (high - low) / 2;
			
			/*
			 * Sort the left side of the array
			 */
			mergeSort(low, middle);
			
			/*
			 * Sort the right side of the array
			 */
			mergeSort(middle + 1, high);
			
			/*
			 * Combine them both
			 */
			merge(low, middle, high);
		}
	}
	
	/**
	 * This method comibine the result of the two collections.
	 * 
	 * @param low
	 * @param middle
	 * @param high
	 */
	private void merge(int low, int middle, int high)
	{
		/*
		 * Copy both parts into the helper array
		 */
		for (int i = low; i <= high; i++)
			helper[i] = numbers[i];
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		/*
		 * Copy the smallest values from either the left or he right side back
		 * to the original array
		 */
		while (i <= middle && j <= high)
		{
			if (helper[i] <= helper[j])
			{
				numbers[k] = helper[i];
				i++;
			}
			else
			{
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		
		/*
		 * Copy the rest of the left side of the array into the target array
		 */
		while (i <= middle)
		{
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}
	
	/**
	 * This method prints the contents of the array.
	 */
	private void printArray()
	{
		for (int i : numbers)
			System.out.print(i + " ");
	}

}
