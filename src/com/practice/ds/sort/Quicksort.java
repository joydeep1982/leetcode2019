package com.practice.ds.sort;

public class Quicksort {
	
	public static void main(String[] args) {
	
		Quicksort qs = new Quicksort();
		int[] arr = new int[] {10, 80, 30, 60, 90, 40, 50, 70, 20};
		qs.quicksort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void quicksort(int[] nums) {
		qsort(nums, 0, nums.length);
	}
	
	private void qsort(int[] nums, int left, int right) {
		if (left < right) {
			int pos = partition(nums, left, right);
			qsort(nums, left, pos - 1);
			qsort(nums, pos + 1, right);
		}
	}
	
	private int partition(int[] nums, int l, int r) {
		int i = l;
		int j = l;
		int pivot = nums[r - 1];
		
		while ( j < r ) {
			if (nums[j] < pivot) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
			}
			j++;
		}
		
		int temp = nums[i];
		nums[i] = pivot;
		nums[r - 1] = temp;
		
		return i;
	}
}
