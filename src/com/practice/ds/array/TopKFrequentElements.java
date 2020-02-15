/**
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 */
package com.practice.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopKFrequentElements {
	
	public static void main(String[] args) {
		TopKFrequentElements obj = new TopKFrequentElements();
		
		List<Integer> result = obj.topKFrequent(new int[] { -1, -1 }, 1);
//		List<Integer> result = obj.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
		System.out.println(result);
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val = 1;
			if (map.containsKey(nums[i])) {
				val = val + map.get(nums[i]);
			}
			map.put(nums[i], val);
		}

		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));

		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			pq.add(key);
			if (pq.size() > k)
				pq.remove();
		}

		Integer[] result = new Integer[k];
		for (int i = (k - 1); i >= 0; i--) {
			result[i] = pq.poll();
		}

		return Arrays.asList(result);
    }

}
