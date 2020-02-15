package com.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Miscell {
	
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(s.substring(0,1));
	}

	public static void main1(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b - a);

		int[] arr = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 };
		
		for (int i : arr) {
			pq.add(i);
			if (pq.size() == 4) {
				pq.remove();
			}
		}
		
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> child = map.getOrDefault("k", Collections.EMPTY_LIST);

	}

}
