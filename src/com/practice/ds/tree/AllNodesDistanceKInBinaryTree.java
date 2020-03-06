/**
 * 
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * 
 */
package com.practice.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.practice.ds.beans.TreeNode;
import com.practice.ds.miscell.Utils;

public class AllNodesDistanceKInBinaryTree {
	
	public static void main(String[] args) {
		AllNodesDistanceKInBinaryTree o = new AllNodesDistanceKInBinaryTree();
		
		TreeNode root = Utils.buildTree(new Integer[] {3,5,1,6,2,0,8,null,null,7,4}, 0);
		
		List<Integer> result = o.distanceK(root, root.left, 3);
		
		result.forEach(System.out::println);
	}
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<Integer>();
        Map<TreeNode, TreeNode> parentLookup = new HashMap<TreeNode, TreeNode>();
        buildParentLookup(root, null, parentLookup);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        q.add(target);
        int level = 1;
        boolean save;
        
        while (!q.isEmpty()) {
            int len = q.size();
            save = level == K;
            for (int i = 0; i < len; i++) {
            	
            	for (int x = 0 ; x < level; x++) {
            		System.out.print("-");
            	}
            	
                TreeNode node = q.poll();
                System.out.print(" processing node " + node.val + " adding ");
                visited.add(node);
                if (node.left != null && !visited.contains(node.left)) {
                	System.out.print(node.left.val + ", ");
                    q.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                	System.out.print(node.right.val + ", ");
                    q.add(node.right);
                }
                if (parentLookup.containsKey(node)) {
                	TreeNode temp = parentLookup.get(node);
                	System.out.print(temp.val + ", ");
                	if (!visited.contains(temp)) {
                		System.out.print(" added");
                		q.add(temp);
                	}
                }
                
                if (save) {
                    result.add(node.val);
                }
                
                System.out.println();
            }
            
            level++;
        }
        
        return result;
    }
    
    private void buildParentLookup(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return;
        }
        if (parent != null) {
            map.put(node, parent);
        }
        buildParentLookup(node.left, node, map);
        buildParentLookup(node.right, node, map);
    }

}
