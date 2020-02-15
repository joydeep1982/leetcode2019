/**
 * 
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 */
package com.practice.ds.array;

public class FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		FindFirstandLastPositionofElementinSortedArray obj = new FindFirstandLastPositionofElementinSortedArray();
		int[] result = obj.searchRange(new int[] { 2, 2 }, 2);
		System.out.println(result[0] + ", " + result[1]);
	}

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		bsearch(nums, 0, nums.length - 1, target, result);
		return result;
	}

	public void bsearch(int[] nums, int left, int right, int target, int[] result) {
		if (left > right)
			return;
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			if (mid - 1 >= 0 && nums[mid - 1] == target) {
				bsearch(nums, left, mid - 1, target, result);
			} else {
				result[0] = mid;
			}
			if (mid + 1 < nums.length && nums[mid + 1] == target) {
				bsearch(nums, mid + 1, right, target, result);
			} else {
				result[1] = mid;
			}
		} else if (nums[mid] < target) {
			// go right
			bsearch(nums, mid + 1, right, target, result);
		} else {
			// go left
			bsearch(nums, left, mid - 1, target, result);
		}
	}
}
