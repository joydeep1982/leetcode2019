package com.practice.ds.miscell;

import com.practice.ds.beans.ListNode;

public class Utils {
	
	public static void print(ListNode list) {
		do {
			System.out.print(list.val);
			list  = list.next;
		} while (list != null);
	}

	public static void print(int[] arr) {
		System.out.println();
		for(int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
	
	public static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length;i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
