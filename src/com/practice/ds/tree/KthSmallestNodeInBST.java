package com.practice.ds.tree;

import com.practice.ds.beans.TreeNode;
import com.practice.ds.miscell.Utils;

public class KthSmallestNodeInBST {
	
	int count = 1;
	
	public static void main(String[] args) {
		
		TreeNode _20 = new TreeNode(20);
		TreeNode _8 = new TreeNode(8);
		TreeNode _22 = new TreeNode(22);
		TreeNode _4 = new TreeNode(4);
		TreeNode _12 = new TreeNode(12);
		TreeNode _10 = new TreeNode(10);
		TreeNode _14 = new TreeNode(14);
		
		_20.left = _8;
		_20.right = _22;
		_8.left = _4;
		_8.right = _12;
		_12.left = _10;
		_12.right = _14;
		
		TreeNode root = Utils.buildTree(new Integer[] {20, 8, 22, 4, 12, null, null, null, null, 10, 14}, 0);
		TreeNode node = new KthSmallestNodeInBST().recurse(root, 3);
		System.out.println(node);
	}
	
	public TreeNode recurse(TreeNode node, int k) {
		if (node == null) {
			return null;
		}
		TreeNode left = recurse(node.left, k);
		if (left != null) {
			return left;
		}
		if (k == count) {
			return node;
		}
		count++;
		TreeNode right = recurse(node.right, k);
		if (right != null) {
			return right;
		}
		return null;
	}

}
