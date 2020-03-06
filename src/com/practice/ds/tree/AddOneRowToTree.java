/**
 * 
 * https://leetcode.com/problems/add-one-row-to-tree/
 * 
 */
package com.practice.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.practice.ds.beans.TreeNode;
import com.practice.ds.miscell.Utils;

public class AddOneRowToTree {
	
	public static void main(String[] args) {
		AddOneRowToTree o = new AddOneRowToTree();
		TreeNode root = Utils.buildTree(new Integer[] {4,2,6,3,1,5}, 0);
		root = o.addOneRow(root, 1, 2);
		System.out.println(root);
	}
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int level = 1;
        boolean breakPoint = false;
            
        while (!q.isEmpty()) {
            int size = q.size();
            breakPoint = d - 1 == level;
            if (breakPoint) {
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            
            level++;
        }
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode lNode = new TreeNode(v);
            TreeNode rNode = new TreeNode(v);
            
            lNode.left = node.left;
            rNode.right = node.right;
            
            node.left = lNode;
            node.right = rNode;
        }
        
        return root;
    }

}
