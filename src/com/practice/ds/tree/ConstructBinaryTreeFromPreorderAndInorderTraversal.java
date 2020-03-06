/**
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 */
package com.practice.ds.tree;

import com.practice.ds.beans.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	public static void main(String[] args) {
		
		//[3,9,20,15,7]
		//[9,3,15,20,7]
		
		ConstructBinaryTreeFromPreorderAndInorderTraversal o = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		o.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
			boolean[] used = new boolean[inorder.length];
			return construct(preorder, inorder, used, 0, inorder.length);
	}
	
	public TreeNode construct(int[] preorder, int[] inorder, boolean[] used, int left, int right) {
		if (left == right) {
			return null;
		}
		int root = -1;
		int preOrderRootIndex = -1;
		outerloop:
		for (int i = 0; i < preorder.length; i++) {
			if (used[i]) continue;
			for (int j = left; j < right; j++) {
				if (preorder[i] == inorder[j]) {
					root =  inorder[j];
					preOrderRootIndex = i;
					break outerloop;
				}
			}
		}
		
		TreeNode node = new TreeNode(root);
		used[preOrderRootIndex] = true;
		
		int pivot = -1;
		for (int i = left; i < right; i++) {
			if (inorder[i] == root) {
				pivot = i;
				break;
			}
		}
		
		node.left = construct(preorder, inorder, used, left, pivot);
		node.right = construct(preorder, inorder, used, pivot + 1, right);
		
		return node;
	}

}
