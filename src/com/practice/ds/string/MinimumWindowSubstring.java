/**
 * 
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 */
package com.practice.ds.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring o = new MinimumWindowSubstring();
		String result = o.minWindow("adobecodebanc", "abc");
		System.out.println(result);
	}

	public String minWindow(String s, String t) {
		String result = "";
		
		Map<Character, Integer> charFrequence = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			int c = charFrequence.getOrDefault(t.charAt(i), 0);
			charFrequence.put(t.charAt(i), c + 1);
		}
		
		int left = 0;
		int right = 0;
		int count = 0;
		int minWindow = Integer.MAX_VALUE;
		
		while (right < s.length()) {
			System.out.println(left + ", " + right + " = " + s.substring(left, right + 1));
			Character ch = s.charAt(right);
			if (charFrequence.containsKey(ch) && charFrequence.get(ch) > 0) {
				charFrequence.put(ch, charFrequence.get(ch) - 1);
				count++;
			}
			if (count == t.length()) {
				System.out.println("found");
				while  (count == t.length()) {
					System.out.println("optimizing " + s.substring(left, right  +  1));
					Character leftCh = s.charAt(left);
					if (charFrequence.containsKey(leftCh)) {
						charFrequence.put(leftCh, charFrequence.get(leftCh) + 1);
						count--;
					}
					left++;
				}
				if (right - left < minWindow) {
					System.out.println("better");
					minWindow = right - left;
					result = s.substring(left, right + 1);
				}
			}
			else {
				right++;
			}
			
			if (count == t.length()) {
				Character leftCh = s.charAt(left);
				if (charFrequence.containsKey(leftCh)) {
					charFrequence.put(leftCh, charFrequence.get(leftCh) + 1);
					count--;
				}
				left++;
			}
			
			
			
//			Character ch = s.charAt(right);
//			System.out.println(ch);
//			
//			if (charFrequence.containsKey(ch) && charFrequence.get(ch) > 0) {
//				charFrequence.put(ch, charFrequence.get(ch) - 1);
//				count++;
//			}
//			if (count == t.length()) {
//				while (!charFrequence.containsKey(s.charAt(left))) {
//					left++;
//				}
//				if (minWindow > (right - left)) {
//					minWindow = right - left;
//					result = s.substring(left, right + 1);
//				}
//				System.out.println("min window " + left + ", " + right);
//				count = 0;
//			}
//			
//			if (minWindow == right - left) {
//				Character rChar = s.charAt(left);
//				if (charFrequence.containsKey(rChar)) {
//					charFrequence.put(rChar, charFrequence.get(rChar) + 1);
//				}
//				left++;
//			}
//			right++;
		}
		
		return result;
	}
}
