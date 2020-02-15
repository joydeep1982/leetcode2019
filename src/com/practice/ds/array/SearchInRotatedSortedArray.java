/**
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 */
package com.practice.ds.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		int[] arr = new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 3, 2, 1, 0 };
		// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
		arr = new int[] { 4, 5, 6, 7, 8, 1, 2, 3 };
		int target = 8;
		System.out.println(obj.search(arr, target));
	}

	public int search(int[] nums, int target) {
		return bsearch(nums, target, 0, nums.length - 1);
	}

	private int bsearch(int[] nums, int target, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;
		System.out.println("left: " + left + ", right: " + right + ", mid: " + mid);
		int midval = nums[mid];
		if (target == midval) {
			return mid;
		}

		if (nums[left] >= target && right > target) {
			// go right
			return bsearch(nums, target, mid + 1, right);
		}
		else if (nums[right] < target && nums[left] <= target) {
			// go left
			return bsearch(nums, target, 0, mid - 1);
		}
		else if (nums[right] < target && nums[left] < target) {
			if (midval > target) {
				// go left
				return bsearch(nums, target, 0, mid - 1);
			} 
			else {
				// go right
				return bsearch(nums, target, mid + 1, right);
			}
				
		} else {
			if (midval > target) {
				// go right
				return bsearch(nums, target, mid + 1, right);
			}
			else {
				// go left
				return bsearch(nums, target, 0, mid - 1);
			}
		}
	}
	
	public List<Integer> sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
    
    public void qsort(int[] nums, int left, int right) {
        while (left < right) {
            int pivot = partition(nums, left, right);
            qsort(nums, left, pivot - 1);
            qsort(nums, pivot + 1, right);
        }
    }
    
    public int partition(int[] nums, int left, int right) {
        
        int pivot = left + (right - left) /2;
        int i = left;
        int j = left;
        
        while (j < pivot) {
            if (nums[j] < nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        
        int temp = nums[pivot];
        nums[pivot] = nums[i];
        nums[i] = temp;
        
        return i;
    }
}
