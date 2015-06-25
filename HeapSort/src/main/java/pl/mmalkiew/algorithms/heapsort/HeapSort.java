package pl.mmalkiew.algorithms.heapsort;

/**
 * Simple HeapSort algorithm implementation.
 * 
 * @author mmalkiew
 *
 */
public class HeapSort 
{
	/**
     * Rearranges the array in ascending order, using the natural order.
     * @param array the array to be sorted
     */
	public void sort(Comparable[] array)
	{
		int n = array.length;
        for (int k = n/2; k >= 1; k--)
            sink(array, k, n);
        while (n > 1) {
            exch(array, 1, n--);
            sink(array, 1, n);
        }
	}
	
	private void sink(Comparable[] array, int k, int n)
	{
		while (2*k <= n)
		{
			int j = 2*k;
			if (j < n && less(array, j, j + 1))
				j++;
			
			if (!less(array,k, j))
				break;
			
			exch(array, k, j);
			k = j;
		}
	}
	
	private boolean less(Comparable[] array, int i, int j )
	{
		return array[i - 1].compareTo(array[j - 1]) < 0;
	}
	
	private void exch(Object[] array, int i, int j)
	{
		Object swap = array[i - 1];
		array[i - 1] = array[j -1];
		array[j - 1] = swap;
	}
	
	/**
	 * This method prints the contents of the array.
	 */
	private void printArray(String[] array)
	{
		for (String i : array)
			System.out.print(i + " ");
	}
	
	/**
	 * Main methods.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		String[] array = new String[]{"B", "A", "D", "C", "F","V", "G"}; 
		HeapSort hs = new HeapSort();
		hs.printArray(array);
		System.out.println();
		hs.sort(array);
		hs.printArray(array);
	}

}
