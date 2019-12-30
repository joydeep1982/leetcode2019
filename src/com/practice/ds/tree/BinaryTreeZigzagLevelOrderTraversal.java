/**
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 */
package com.practice.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.practice.ds.beans.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {

		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);

		one.left = two;
		one.right = three;
		two.left = four;
		three.right = five;

		BinaryTreeZigzagLevelOrderTraversal obj = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> result = obj.zigzagLevelOrder(one);
		System.out.println("--");
		for (List<Integer> r : result) {
			for (Integer n : r) {
				System.out.print(n + ",");
			}
			System.out.println();
		}
		System.out.println("-----");
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		List<Integer> level;
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		int levelCounter = 0;
		
		while (!s1.isEmpty() || !s2.isEmpty()) {
			level = new ArrayList<Integer>();
			
			if (levelCounter% 2 == 0) {
				while (!s1.isEmpty()) {
					TreeNode node = s1.pop();
					if (node.left != null) s2.add(node.left);
					if (node.right != null) s2.add(node.right);
					level.add(node.val);
				}	
			} else {
				while (!s2.isEmpty()) {
					TreeNode node = s2.pop();
                    if (node.right != null) s1.add(node.right);
					if (node.left != null) s1.add(node.left);
					level.add(node.val);
				}
			}
			levels.add(level);
			levelCounter++;
		}
		
		return levels;
	}
}
