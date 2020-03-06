package com.practice.ds.array;

import java.util.HashMap;
import java.util.Map;

public class ContiniousSubarraySum {
	
	public static void main(String[] args) {
		ContiniousSubarraySum o = new ContiniousSubarraySum();
//		boolean r = o.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6);
		boolean r = o.checkSubarraySum(new int[] {-3, 0, 3, 4, -4}, 6);
		System.out.println(r);
	}
	
	public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
        	System.out.println(nums[i]);
            curr += nums[i];
            System.out.println(curr);
            int remaining = k == 0 ? curr : curr % k;
            System.out.println("remining: " + remaining);
            if (map.containsKey(remaining) && i - map.get(remaining) >= 2) {
            	System.out.println("matched");
                return true;
            }
            System.out.println("key : " + remaining + " value: " + i);
            map.putIfAbsent(remaining, i);
            
            System.out.println();
            System.out.println();
        }
        
        return false;
    }

}
