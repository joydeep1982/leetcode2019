package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Miscell {
	
	public static void main(String[] args) {
		Map<Integer, String> tmap = new TreeMap<Integer, String>((a,b) -> b - a);
		tmap.put(1, "1");
		tmap.put(100, "100");
		tmap.put(2, "2");
		tmap.put(200, "200");
		tmap.put(3, "3");
		tmap.put(300, "300");
		tmap.put(4, "4");
		tmap.put(400, "400");
		tmap.put(5, "5");
		tmap.put(500, "500");
//		for (Entry<Integer, String> entry : tmap.entrySet()) {
//            pq.add(entry.value());
//        }
		
		for (Integer k : tmap.keySet()) {
//			System.out.println(k);
		}
		
		System.out.println(Character.getNumericValue(97));
		
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(q.poll());
	}
	
	public static void main111(String[] args) {
//		System.out.println(isJumpingNumber(7));
//		System.out.println(isJumpingNumber(4343456));
//		System.out.println(isJumpingNumber(8987));
//		System.out.println(isJumpingNumber(796));
//		System.out.println(isJumpingNumber(89098));
		
		for (int i = 4343456; i >= 0; i--) {
			if (isJumpingNumber(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isJumpingNumber(int n) {
		int pr = -1;
		
		while (n > 0) {
			int r = n % 10;
			n = n / 10;
			if (pr != -1) {
				if (!(pr + 1 == r || pr - 1 == r)) {
					return false;
				}
			}
			pr = r;
		}
		
		return true;
	}
	
	public static void main2(String[] args) {
		String s = "hello";
		System.out.println(s.substring(0,1));
	}

	public static void main1(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		int[] arr = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 };
		
		for (int i : arr) {
			pq.add(i);
			if (pq.size() == 4) {
				pq.remove();
			}
		}
		
		System.out.println(pq.remove());
		
//		while (!pq.isEmpty()) {
//			System.out.println(pq.remove());
//		}
		
//		Map<String, List<String>> map = new HashMap<String, List<String>>();
//		List<String> child = map.getOrDefault("k", Collections.EMPTY_LIST);

	}

}
