/**
 * 
 * https://leetcode.com/problems/first-missing-positive/
 * 
 */
package com.practice.ds.array;

public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive obj = new FirstMissingPositive();
//		System.out.println(obj.firstMissingPositive(new int[] { -1, -2 }));
//		System.out.println(obj.firstMissingPositive(new int[] { 1, 2 }));
		System.out.println(obj.firstMissingPositive(new int[] { 3,4,-1,1 }));
	}

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i] - 1;
			if (val >= 0 && val < nums.length) {
				if (nums[val] > 0) {
					nums[val] = -nums[val];
				}
			} else {
				nums[i] = 0;
			}
			
		}
		
		for (int i : nums) {
			System.out.print(i);
			System.out.print(" ");
		}
		
		System.out.println();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				return (i + 1);
			}
		}

		return nums.length + 1;
	}
}
