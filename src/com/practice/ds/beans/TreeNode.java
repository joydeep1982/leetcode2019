package com.practice.ds.beans;

public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode() {
	}

	public TreeNode(int x) {
		val = x;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.val + "";
	}
}
