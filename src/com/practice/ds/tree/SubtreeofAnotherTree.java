package com.practice.ds.tree;

import com.practice.ds.beans.TreeNode;
import com.practice.ds.miscell.Utils;

public class SubtreeofAnotherTree {
	
	public static void main(String[] args) {
		SubtreeofAnotherTree o = new SubtreeofAnotherTree();
		
		TreeNode one = Utils.buildTree(new Integer[] {3,4,5,1,null,2}, 0);
		TreeNode two = Utils.buildTree(new Integer[] {3,1,2}, 0);
		
		boolean b = o.isSubtree(one, two);
		System.out.println(b);
	}
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return true && isSubtree(s.right, t.right) && isSubtree(s.left, t.left);
        }
        
        return false || isSubtree(s.right, t) || isSubtree(s.left, t);
    }

}
