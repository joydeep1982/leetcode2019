/**
 * 
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 */
package com.practice.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.practice.ds.beans.TreeNode;

public class BinaryTreeInorderTraversal {
	
	public static void main(String[] args) {
		BinaryTreeInorderTraversal obj  = new BinaryTreeInorderTraversal();
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		//seven.right = eight;
		
		obj.inorderTraversal(one).forEach(System.out::println);
		
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();
		List<Integer> items = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		
		do {
			if (current != null) {
				stack.add(current);
				current = current.left;
			}
			else {
				current = stack.pop();
				items.add(current.val);
				if (current.right != null) {
					current = current.right;
				} else {
					current = null;
				}
			}
		} while (!stack.isEmpty() || current != null);
		
		return items;
	}

}
