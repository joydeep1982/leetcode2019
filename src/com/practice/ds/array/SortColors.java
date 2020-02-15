/**
 * 
 * https://leetcode.com/problems/sort-colors/
 * 
 */
package com.practice.ds.array;

public class SortColors {

	public static void main(String[] args) {
		SortColors obj = new SortColors();
		int[] nums = new int[] { 2, 0, 1 };
		obj.sortColors(nums);
		for (int n : nums) {
			System.out.println(n);
		}
	}

	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int temp;
		int i = 0;

		while (left < right && i < nums.length) {
			int val = nums[i];
			if (val == 0) {
				if (i > left) {
					temp = nums[i];
					nums[i] = nums[left];
					nums[left] = temp;
				}
				else {
					i++;
				}
				left++;
			}
			else if (val == 2) {
				if (i < right) {
					temp = nums[i];
					nums[i] = nums[right];
					nums[right] = temp;
				}
				else {
					i++;
				}
				right--;
			}
			else {
				i++;
			}
		}
	}
}
