/**
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 */
package com.practice.ds.array;

public class RemoveDuplicatesfromSortedArray {
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray obj = new RemoveDuplicatesfromSortedArray();
		int[] arr = new int[] {0,0,1,1,1,2,2,3,3,4};
		int result = obj.removeDuplicates(arr);
		System.out.println(result);
		System.out.println();
		for (int r : arr) {
			System.out.print(r);
		}
	}
	
	public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums == null || nums.length == 0 || nums.length == 1) return nums.length;
        int i = 0;
        int j = 1;
        int counter = 1;
        int k = 1;
        while ( j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[k++] = nums[j];
                i = j;
                counter++;
            }
            j++;
        }
        return counter;
    }

}
