/**
 * 
 * https://leetcode.com/problems/cherry-pickup/
 * 
 */
package com.practice.ds.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CherryPickup {
	
	public static void main(String[] args) {
		CherryPickup cp = new CherryPickup();
		int maxCherry = cp.cherryPickup(new int[][] {
			{0, 1, -1},
			{1, 0, -1},
			{1, 1, 1}
		});
		System.out.println(maxCherry);
	}
	
	public int cherryPickup(int[][] grid) {
		
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		q.add(new Integer[]{0,0});
		Set<Integer[]> visited = new HashSet<Integer[]>();
		
		while (!q.isEmpty()) {
			Integer[] next = q.poll();
//			if (visited.c[next[0]][next[1]]) {
//				
//			}
		}
		
		
		
		return 0;
    }
}
