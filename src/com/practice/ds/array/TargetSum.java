/**
 * 
 * https://leetcode.com/problems/target-sum/
 * 
 */
package com.practice.ds.array;

public class TargetSum {

	public static void main(String[] args) {
		TargetSum ts = new TargetSum();
		int count = ts.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3);
		System.out.println("Count: " + count);
	}

	public int findTargetSumWays(int[] nums, int S) {
		return recurse(nums, 0, false, 0, S, "");
	}

	public int recurse(int[] nums, int pos, boolean isPlus, int sum, int target, String result) {
		if (pos == nums.length) {
			if (target == sum) {
				System.out.println("matched " + result);
				return 1;
			}
			return 0;
		}
		
		int sub = sum + (-1 * nums[pos]);
		int add = sum + nums[pos];
		
//		System.out.println("Prev Sum: " + sum);
//		System.out.println("Num: " + nums[pos]);
//		System.out.println("Add: " + add);
//		System.out.println("Sub: " + sub);
//		System.out.println();
//		System.out.println();
		
		return recurse(nums, pos + 1, false, sub, target, result + "-" + nums[pos]) 
				+ recurse(nums, pos + 1, true, add, target, result + "+" + nums[pos]);
	}

}
