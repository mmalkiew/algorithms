package com.mmalkiew.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mmalkiew
 *
 */
public class Application 
{
	private Application() { }
	
	/**
     * Searches for the integer key in the sorted array a[].
     * 
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int rank(int key, int[] a) 
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) 
        {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        
        return -1;
    }
	
    /**
     * Main class
     */
    public static void main(String[] args) 
    {
        // array of integers
        int[] whitelist = {10,4,1,43,2,7,6,5,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

        // sort the array
        Arrays.sort(whitelist);
        Scanner scanner = new Scanner(System.in);
        // read integer key from standard input
        int key = scanner.nextInt();
        if (rank(key, whitelist) == -1)
        	System.out.println("Not found");
        else
        	System.out.println("Key found");
    }
}
