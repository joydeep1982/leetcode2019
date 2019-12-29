/**
 * 
 * https://leetcode.com/problems/climbing-stairs/
 * 
 */
package com.practice.ds;

public class ClimbingStairs {
	
	public static void main(String[] args) {
		int ways = new ClimbingStairs().climbStairs(30);
		System.out.println(ways);
	}
	
	public int climbStairs(int n) {
        return recurse(n, new int[n + 1]);
    }

	public int recurse(int n, int[] tab) {
		if(n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (tab[n] > 0) return tab[n];
        int result = recurse(n-1, tab) + recurse(n-2, tab);
        tab[n] = result;
        return result;
	}
}
