/**
 * 
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {

	public static void main(String[] args) {
		FindAllAnagramsinaString o = new FindAllAnagramsinaString();
		o.findAnagrams("cbaebabacd", "abc").forEach(System.out::println);
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		
		int[] frequency = new int[26];
		for (char c : p.toCharArray()) {
			frequency[c - 'a']++;
		}
		
		int left = 0;
		int right = 0;
		int count = p.length();
		
		while (right < s.length()) {
			System.out.println(left + ", " + right + " -> " + (right - left));
			System.out.println(s.substring(left, right + 1));
			
			if (frequency[s.charAt(right++) - 'a']-- >= 1) {
				System.out.println("decrementing count");
				count--;
			}
			
			if (count == 0) {
				System.out.println("matched");
				result.add(left);
			}
			
			if (right - left == p.length() && frequency[s.charAt(left++) - 'a']++ >= 0) {
				System.out.println("incrementing count and frequency for " + s.charAt(left - 1));
				count++;
			}
		}
		
		return result;
	}

}
