package com.mmalkiew.quicksort;

/**
 * Simple QuickSort algorithm implementation.
 * 
 * @author mmalkiew
 *
 */
public class QuickSort {
	
	private int[] array;
	
	/**
	 * Construtor has to create the array and fill it with 
	 * random numbers between 0 - 100
	 * 
	 * @param N
	 */
	public QuickSort(int N)
	{
		array = new int[N];
		for (int i = 0; i < N; i++)
		{
			int item = (int)(Math.random()*100);
			array[i] = item;
		}
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		QuickSort qs = new QuickSort(10);
		//	prints init array
		qs.printArray();
		
		//	sort init array
		qs.sort();
		
		System.out.println("");
		
		//	print sorted array
		qs.printArray();
	}
	
	/**
	 * This method sorts an array and internally calls quickSort
	 */
	public void sort()
	{
		int left = 0;
		int right = array.length -1;
		
		quickSort(left, right);
	}
	
	/**
	 * This method is used to sort the array using quciksort algorithm.<br/>
	 * It takes the left and right end of the array as the two cursors.
	 * @param left begin of the array
	 * @param right end of the array
	 */
	private void quickSort(int left, int right)
	{
		if (left >= right)
			return;
		
		/*
		 * For the simplicity, I took the right most item of the array as a pivot
		 */
		int pivot = array[right];
		int partition = partition(left, right, pivot);
		
		/*
		 * Recursively, calls the quicksort with the different left and right parameters 
		 */
		quickSort(0, partition - 1);
		quickSort(partition + 1, right);
	}
	
	/**
	 * This method is used to partition the given array and returns the integer
	 * which points.
	 * 
	 * @param left left cursor
	 * @param right right cursor
	 * @param pivot pivot
	 * @return index in which we divide an array
	 */
	private int partition(int left, int right, int pivot)
	{
		int leftCursor = left -1;
		int rightCursor = right;
		
		while (leftCursor < rightCursor)
		{
			while (array[++leftCursor] < pivot);
			while (rightCursor > 0 && array[--rightCursor] > pivot);
			
			if (leftCursor >= rightCursor)
				break;
			else
				swap(leftCursor, rightCursor);
		}
		
		swap(leftCursor, right);
		
		return leftCursor;
	}
	
	/**
	 * This method is used to swap the values between the two given index
	 * 
	 * @param left First index value
	 * @param right Second index value
	 */
	private void swap(int left, int right)
	{
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
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
