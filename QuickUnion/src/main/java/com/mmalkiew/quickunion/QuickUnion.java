package com.mmalkiew.quickunion;

/**
 * Simple QuickUnion algorithm implementation.
 * 
 * @author mmalkiew
 *
 */
public class QuickUnion 
{
	private int[] id;
	
	/**
	 * Construtor has to create the array and then go through nad
	 * set the value corresponding to each index I to I.<br/>
	 * <br/>
	 * Set id of earch object to itself (N array accesses)
	 */
	public QuickUnion(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	/**
	 * Chase parent pointers until reach root.<br/>
	 * (depth of i array accesses)
	 * @param i - index of I object
	 * @return Root object
	 */
	private int root(int i)
	{
		while (i != id[i])
			i = id[i];
		
		return i;
	}
	
	/**
	 * Check if p and q have same root.
	 * 
	 * @param p - index of p object
	 * @param q - index of q object
	 * @return true or false
	 */
	private boolean isConnected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	/**
	 * Change root of p to point to root of q.<br/>
	 * (depth of p and q array accesses)
	 * @param p - index of p object
	 * @param q - index of q object
	 */
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i]= j;
	}
	
	/**
	 * Main method and simple example.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int N = 10;
		QuickUnion qu = new QuickUnion(N);
		qu.union(4, 3);
		qu.union(3, 8);
		qu.union(6, 5);
		qu.union(9, 4);
		qu.union(2, 1);
		
		if (qu.isConnected(8, 9))
			System.out.println("Connected...");
		else
			System.out.println("[ERROR] NOT Connected...");
	}
}
