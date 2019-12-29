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
}
