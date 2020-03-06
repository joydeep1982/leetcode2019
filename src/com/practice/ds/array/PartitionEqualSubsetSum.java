/**
 * 
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 */
package com.practice.ds.array;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		PartitionEqualSubsetSum o = new PartitionEqualSubsetSum();
		boolean isPossible = o.canPartition(new int[] {100,100,100,100,100,100,100,100});
		System.out.println(isPossible);
	}
	
	public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // not possible to split since it's not a multiple of 2
        if (sum % 2 != 0) {
            return false;
        }
        
        int half = sum / 2;
        return findSubArray(nums, 0, 0, half);
    }
    
    public boolean findSubArray(int[] nums, int pos, int sum, int target) {
    	System.out.println(sum);
        if (sum == target)  {
            return true;
        }
        if (sum > target || pos >= nums.length) {
            return false;
        }
        
        for (int i = pos + 1; i < nums.length; i++) {
            if (findSubArray(nums, i, sum + nums[i], target)) {
                return true;
            }
        }
        return false;
    }

}
