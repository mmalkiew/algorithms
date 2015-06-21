package com.mmalkiew.quickfind;

/**
 * Simple QuickFind algorithm implementation.
 * 
 * @author mmalkiew
 *
 */
public class QuickFind 
{
	private int[] id;
	
	/**
	 * Construtor has to create the array and then go through nad
	 * set the value corresponding to each index I to I.<br/>
	 * <br/>
	 * Set id of earch object to itself (N array accesses)
	 */
	public QuickFind(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	/**
	 * Check whether p and q are in the same component.<br/>
	 * (2 array accesses)
	 * @param p - index of p object
	 * @param q - index of q object
	 * @return true or false
	 */
	public boolean isConnected(int p, int q)
	{
		return id[p] == id[q];
	}
	
	/**
	 * Change all entries with id[p] to id[q]<br/>
	 * (At most 2N + 2 accessess)
	 * @param p
	 * @param q
	 */
	public void union(int p, int q)
	{
		int pId = id[p];
		int qId = id[q];
		
		for (int i = 0; i < id.length; i++)
			if (id[i] == pId)
				id[i] = qId;
	}
	
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int N = 10;
		QuickFind qf = new QuickFind(N);
		qf.union(4, 3);
		qf.union(3, 8);
		qf.union(6, 5);
		qf.union(9, 4);
		qf.union(2, 1);
		
		if (qf.isConnected(8, 9))
			System.out.println("Connected...");
		else
			System.out.println("[ERROR] NOT Connected...");
	}
}
