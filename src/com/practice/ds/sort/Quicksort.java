package com.practice.ds.sort;

import com.practice.ds.miscell.Utils;

public class Quicksort {
	
	public static void main(String[] args) {
	
		Quicksort qs = new Quicksort();
		int[] arr = new int[] {10, 80, 30, 60, 90, 40, 50, 70, 20};
		arr = new int[] {5, 1, 1, 2, 0 , 0};
		qs.quicksort(arr);
		Utils.print(arr);
	}
	
	public void quicksort(int[] nums) {
		qsort(nums, 0, nums.length - 1);
	}
	
	public void qsort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            qsort(nums, left, pos - 1);
            qsort(nums, pos + 1, right);
        }
    }
	
	private int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
        int i = left;
        int j = left;
        
        while (j < right) {
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        
        int temp = nums[right];
        nums[right] = nums[i];
        nums[i] = temp;
        
        return i;
	}
}
