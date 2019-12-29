/**
 * 
 * https://leetcode.com/problems/two-sum/submissions/
 * 
 */
package com.practice.ds.miscell;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] ret = new TwoSum().twoSum();
		System.out.println(ret[0] + " " + ret[1]);
		
	}
	
	public int[] twoSum() {
		Integer target = 9;
		Integer[] nums = new Integer[]{2,7, 11, 15};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if  (map.containsKey(target - nums[i])) {
				return new int[] {i, map.get(target - nums[i])};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}
}
