/**
 * 
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 */
package com.practice.ds.array;

public class MaximumProductSubarray {
	
	public static void main(String[] args) {
		MaximumProductSubarray obj = new MaximumProductSubarray();
		int max = obj.maxProduct(new int[] {-2, 3, -4});
		System.out.println(max);
	}

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for(int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1] * nums[i], nums[i]);
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		
		for (int i = 0; i < dp.length;  i++) {
			System.out.println(dp[i]);
		}
		
		return max;
	}
}
