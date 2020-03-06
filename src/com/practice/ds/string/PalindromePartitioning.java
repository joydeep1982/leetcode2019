/**
 * 
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.List;

import com.practice.ds.miscell.Utils;

public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning obj = new PalindromePartitioning();
		List<List<String>> results = obj.partition("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg");

//		int count = 0;
//		for (List<String> result : results) {
//			count++;
//			System.out.print(count + " ");
//			System.out.println(result);
//		}
	}

	public List<List<String>> partition(String s) {

		List<List<String>> result = new ArrayList<List<String>>();
		if (s.length() == 1) {
			List<String> r = new ArrayList<String>();
			r.add(s);
			result.add(r);
			return result;
		}

		int len = s.length();
		boolean[][] palin = new boolean[len][len];

		// every single character is considered as palindrome
				// every first two character if same is considered as palindrome
		for (int i = 0; i < len; i++) {
			palin[i][i] = true;
			if (i + 1 < s.length() - 1) {
				palin[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = i + 2; j < len; j++) {
				palin[i][j] = s.charAt(i) == s.charAt(j) && palin[i][j - 2];
			}
		}
		
		List<String> x = new ArrayList<String>();

		Utils.print(palin, "T", "-");
		int count = 0;
		// result collection
		for (int i = 0; i < len; i++) {
			List<String> r = new ArrayList<String>();
			for (int j = i; j < len; j++) {
				if (palin[i][j]) {
					r.add(s.substring(i, j + 1));
					x.add(s.substring(i, j+ 1));
					count++;
				}
			}
			result.add(r);
		}
		
		count = 0;
		for (String xx : x) {
			count++;
			System.out.print(count + " ");
			System.out.println(xx);
		}

		return result;
	}

}
