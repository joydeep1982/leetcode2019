/**
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 */
package com.practice.ds.array;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int max = obj.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
		System.out.println(max);
	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					if (dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}
		
//		for (int i = 0; i < dp.length; i++) {
//			System.out.print(dp[i] + ", ");
//		}
//		
//		System.out.println();
		
		return max;
	}
}
