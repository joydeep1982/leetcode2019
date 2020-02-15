package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = new int[] { 8, 4, 3, 7, 2, 1, 5, 6 };
		ms.mergesort(arr);
		
		Utils.print(arr);
	}

	public void mergesort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int mid = left + (right - left) / 2;
		sort(arr, mid + 1, right);
		sort(arr, left, mid);

		merge(arr, left, right, mid);
	}

	public void merge(int[] arr, int left, int right, int mid) {
//		System.out.println("left: " + left);
//		System.out.println("right: " + right);
//		System.out.println("middle: " + mid);
//		System.out.println();

		int lArrSize = mid - left + 1;
		int rArrSize = right - mid;

		int[] lArr = new int[lArrSize];
		int[] rArr = new int[rArrSize];

		for (int i = 0; i < lArrSize; i++) {
			lArr[i] = arr[left + i];
		}
		for (int i = 0; i < rArrSize; i++) {
			rArr[i] = arr[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int pos = left;
		while (i < lArrSize && j < rArrSize) {
			if (lArr[i] < rArr[j]) {
				arr[pos] = lArr[i];
				i++;
			}
			else {
				arr[pos] = rArr[j];
				j++;
			}
			pos++;
		}
		
		while ( i < lArrSize) {
			arr[pos] = lArr[i];
			i++;
			pos++;
		}
		
		while ( j < rArrSize) {
			arr[pos] = rArr[j];
			j++;
			pos++;
		}
	}
}
