/**
 * 
 * https://leetcode.com/problems/burst-balloons/
 * 
 */
package com.practice.ds.array;

import java.util.stream.IntStream;

import com.practice.ds.miscell.Utils;

public class BurstBalloons {

	public static void main(String[] args) {
		BurstBalloons obj = new BurstBalloons();
		int maxCoins = obj.maxCoins(new int[] { 3, 1, 5, 8 });
		System.out.println("Max coins: " + maxCoins);
	}

	public int maxCoins(int[] nums) {
		if (nums.length == 0) return 0;
		int max = nums[0];
		int[] dp = dp(nums);
		Utils.print(dp);
		for (int i = 0; i < nums.length; i++) {
			final int index = i;
			int [] subArray = IntStream.range(0, nums.length) 
		            .filter(idx -> idx != index) 
		            .map(idx -> nums[idx]) 
		            .toArray();
			max = Math.max(max, dp[i] + maxCoins(subArray));
		}
		
		return max;
	}
	
	public int[] dp(int[] nums) {
		if (nums.length == 0 || nums.length == 1) return nums;
		int[] dp = new int[nums.length];
		dp[0] = nums[0] * nums[1];
		dp[dp.length - 1] = nums[dp.length - 1] * nums[dp.length - 2];
		
		for (int i = 1; i < nums.length - 1; i++) {
			dp[i] = nums[i-1] * nums[i] * nums[i+1];
		}
		return dp;
	}

}
