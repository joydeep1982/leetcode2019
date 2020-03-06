/*
 * 
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 */
package com.practice.ds.tree;

import com.practice.ds.beans.TreeNode;
import com.practice.ds.miscell.Utils;

public class FlattenBinaryTreeToLinkedList {
	
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList o = new FlattenBinaryTreeToLinkedList();
		TreeNode node = Utils.buildTree(new Integer[] {1,2}, 0); 
		o.flatten(node);
		System.out.println(node);
	}
	
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        System.out.println("Pushed: "  + root.val);
        
        flatten(root.left);
        
        System.out.println("Popped: "  + root.val);
        
        if (root.left != null) {
            TreeNode rightChild = root.right;
            root.right = root.left;
            
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = rightChild;
            
            root.left = null;
        }
        
        flatten(root.right);
    }

}
