/**
 * 
 * https://leetcode.com/problems/group-anagrams/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GroupAnagrams {

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> results = ga.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		results.forEach(System.out::println);
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> anagramGroups = new HashMap<String, List<String>>();

		for (String s : strs) {

			char[] arr = s.toCharArray();
			Arrays.sort(arr);
		
			String key = new String(arr);
			
			List<String> list = anagramGroups.getOrDefault(key, new ArrayList<String>());
			list.add(s);
			anagramGroups.put(key, list);
		}

		List<List<String>> results = new ArrayList<List<String>>();
		Set<String> keys = anagramGroups.keySet();

		for (String key : keys) {
			results.add(anagramGroups.get(key));
		}

		return results;
	}

	private boolean match(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] s1Arr = s1.toCharArray();
		Arrays.sort(s1Arr);

		char[] s2Arr = s2.toCharArray();
		Arrays.sort(s2Arr);

		for (int i = 0; i < s2Arr.length; i++) {
			if (s1Arr[i] != s2Arr[i]) {
				return false;
			}
		}

		return true;
	}
}
