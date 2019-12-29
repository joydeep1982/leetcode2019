/**
 * 
 * https://leetcode.com/problems/house-robber/
 * 
 */
package com.practice.ds.array;

public class HouseRobber {
	
	public static void main(String[] args) {
		HouseRobber obj = new HouseRobber();
		int max = obj.rob(new int[] {2,7,9,3,1});
		System.out.println();
		System.out.println(max);
	}

	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length ==  1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i - 1]);
        }
        
        System.out.println();
        for(int d : dp ) {
        	System.out.print(d + ", ");
        }
        
        return dp[nums.length - 1];
    }
	
	
}
