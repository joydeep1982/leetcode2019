/**
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 */
package com.practice.ds.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray {
	
	public static void main(String[] args) {
		KthLargestElementinanArray obj = new KthLargestElementinanArray();
		int ans = obj.findKthLargest(new int[] {3,2,1,5,6,4}, 2);
		System.out.println(ans);
	}

	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> q = new PriorityQueue<Integer>(k, (i, j) -> j - i);
		
		for (Integer n : nums) {
			q.add(n);
		}
		int ans = 0;
		for(int i = 0; i < k; i++) {
			ans = q.poll();
		}
		return ans;
	}

}
