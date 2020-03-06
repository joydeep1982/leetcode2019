/**
 * 
 * https://leetcode.com/problems/circular-array-loop/
 * 
 */
package com.practice.ds.array;

public class CircularArrayLoop {
	
	public static void main(String[] args) {
		CircularArrayLoop o = new CircularArrayLoop();
		boolean b = o.circularArrayLoop(new int[] {2,-1,1,2,2});
		System.out.println(b);
	}
	
	public boolean circularArrayLoop(int[] nums) {
        int[] pathMapper = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (pathMapper[i] == 1) 
                continue;
            if (hasCycle(nums, pathMapper, i)) {
                return true;
            }         
        }
        
        return false;
    }
    
    private boolean hasCycle(int[] nums, int[] pathMapper, int start) {
        boolean crossedLeft = false;
        boolean crossedRight = false;
        
        int i = start;
        while(true) {
            pathMapper[i]++;
            
            // increment function
            i = i + nums[i];
            
            if (i > nums.length - 1) {
                i = i % nums.length;
                crossedRight = true;
            }
            else if ( i < 0) {
                i = -1 * i & nums.length;
                crossedLeft = true;
            }
            
            if (pathMapper[i] > 1 && i == start && (crossedLeft || crossedRight)) {
                return true;
            }
            else if (pathMapper[i] > 1) {
                return false;
            }
            
            if (nums[i] == 0) {
                return false;
            }
        }
    }	

}
