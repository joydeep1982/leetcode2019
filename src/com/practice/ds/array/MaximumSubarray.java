/**
 * 
 * https://leetcode.com/problems/maximum-subarray/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class MaximumSubarray {
	
	public static void main(String[] args) {
		MaximumSubarray obj = new MaximumSubarray();
		int max = obj.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(max);
	}

	public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        
        Utils.print(dp);
        
        return max;
    }
}
