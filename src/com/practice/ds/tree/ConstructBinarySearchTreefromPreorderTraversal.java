/**
 * 
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * 
 */
package com.practice.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.practice.ds.beans.TreeNode;

public class ConstructBinarySearchTreefromPreorderTraversal {

	public static void main(String[] args) {
		ConstructBinarySearchTreefromPreorderTraversal obj = new ConstructBinarySearchTreefromPreorderTraversal();
		TreeNode root = obj.bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });

		// build tree
		BinaryTreeInorderTraversal trav = new BinaryTreeInorderTraversal();
		trav.inorderTraversal(root).forEach(System.out::println);
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (Integer i : preorder) {
			q.offer(i);
		}
		return build(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public TreeNode build(Queue<Integer> q, int min, int max) {
		if (q.isEmpty()) return null;
		int val = q.peek();
		if (val < min || val > max) return null;

		TreeNode node = new TreeNode(q.poll());
        node.left = build(q, min, node.val - 1);
        node.right = build(q, node.val + 1, max);

		return node;
	}
}
