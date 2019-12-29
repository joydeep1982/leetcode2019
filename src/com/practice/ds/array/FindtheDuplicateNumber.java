/**
 * 
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 */

package com.practice.ds.array;

public class FindtheDuplicateNumber {
	
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		nums = new int []{5,5,5,5,5,4};
		
		FindtheDuplicateNumber obj = new FindtheDuplicateNumber();
		System.out.println(obj.findDuplicate(nums));
	}
	
	public int findDuplicate(int[] nums) {
		// Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}
