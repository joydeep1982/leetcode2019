package com.practice.ds.miscell;

import com.practice.ds.beans.ListNode;
import com.practice.ds.beans.TreeNode;

public class Utils {

	public static void print(ListNode list) {
		do {
			System.out.print(list.val);
			list = list.next;
		} while (list != null);
	}

	public static void print(int[] arr) {
		System.out.println();
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(boolean[][] arr, String t, String f) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] ? t : f);
			}
			System.out.println();
		}
	}

	public static TreeNode buildTree(Integer[] nodes, int pos) {
		if (pos < 0 || pos >= nodes.length || nodes[pos] == null)
			return null;
		TreeNode node = new TreeNode(nodes[pos]);

		node.left = buildTree(nodes, 2 * pos + 1);
		node.right = buildTree(nodes, 2 * pos + 2);

		return node;
	}

}
