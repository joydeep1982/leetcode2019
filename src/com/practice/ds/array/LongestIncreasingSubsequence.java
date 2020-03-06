/**
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.List;

import com.practice.ds.miscell.Utils;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int max = obj.lengthOfLIS(new int[] {-1,2,1,2});
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
		
		Utils.print(dp);
		
		int temp = max;
		List<Integer> result = new ArrayList<Integer>(max);
		for (int i = dp.length - 1; i >= 0; i--) {
			if (dp[i] == temp && temp > 0) {
				result.add(0, nums[i]);
				temp--;
			}
		}
		
		result.forEach(System.out::println);
		
//		for (int i = 0; i < dp.length; i++) {
//			System.out.print(dp[i] + ", ");
//		}
//		
//		System.out.println();
		
		return max;
	}
}
