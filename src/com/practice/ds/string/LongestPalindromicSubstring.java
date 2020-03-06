/**
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 */
package com.practice.ds.string;

import com.practice.ds.miscell.Utils;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		String result = obj.longestPalindrome("abcba");
//		String result = obj.longestPalindrome("babad");
//		String result = obj.longestPalindrome("babaddtattarrattatddetartrateedredividerb");
		System.out.println("Result: " + result);
	}

	public String longestPalindrome(String s) {

		if (s.length() == 0)
			return "";
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		int max = 0;
		int start = 1;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
			if (i < s.length() - 1) {
				dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
				if (dp[i][i + 1]) {
					max = 1;
					start = i;
					end = i + 2;
				}
			}
		}

		Utils.print(dp, "T", "-");

//		for (int i = 0; i < s.length(); i++) {
//			for (int j = i + 2; j < s.length(); j++) {
//				dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i][j - 2];
//				if (dp[i][j] && j - i > max) {
//					max = j - i;
//					start = i;
//					end = j + 1;
//					System.out.println(s.substring(start, end));
//				}
//			}
//		}
		
		for (int i = s.length() - 2; i >= 0; i--) {
			for (int j = i + 2; j < s.length(); j++) {
				System.out.println(i + ", " + j);
				dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
				if (dp[i][j] && j - i > max) {
					max = j - i;
					start = i;
					end = j + 1;
					System.out.println(s.substring(start, end));
				}
			}
		}

		Utils.print(dp, "T", "-");

		return s.substring(start, end);
		// return longestPalin(s, 0, s.length());
	}

	public String longestPalin(String s, int left, int right) {
		System.out.println("left " + left + " right " + right);
		if (left >= right) {
			return s.substring(left, right);
		}
		System.out.println(s.substring(left, right));
		if (right - left == 1) {
			return s.substring(left, right);
		}

		int l = left;
		int r = right - 1;
		boolean allMatched = true;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				allMatched = false;
				break;
			}
			l++;
			r--;
		}

		if (allMatched) {
			return s.substring(left, right);
		}

		String s1 = longestPalin(s, left + 1, right);
		String s2 = longestPalin(s, left, right - 1);

		return s1.length() > s2.length() ? s1 : s2;
	}

//	public String longestPalindrome(String s) {
//		System.out.println("String: " + s);
//		int len = s.length();
//		if (len  <= 1) {
//			return s;
//		}
//		
//		if (s.charAt(0) == s.charAt(len - 1)) {
//			// matched, proceed
//			String matched = String.valueOf(s.charAt(0));
//			return matched + longestPalindrome(s.substring(1, len - 1)) + matched;
//		} else {
//			// unmatched
//			String s1 = longestPalindrome(s.substring(0, len - 1));
//			String s2 = longestPalindrome(s.substring(1, len));
//			
//			return s1.length() > s2.length() ? s1 : s2;
//		}
//	}

//	public String longestPalindrome(String s) {
//		if (s.length() <= 1)
//			return s;
//
//		int len = s.length() - 1;
//		String ret = "";
//		if (s.charAt(0) == s.charAt(len)) {
//			ret = longestPalindrome(s.substring(1, len - 1));
//		} else {
//			String s1 = longestPalindrome(s.substring(1, len));
//			String s2 = longestPalindrome(s.substring(0, len - 1));
//			ret = s2;
//			if (s1.length() > s2.length())
//				ret = s1;
//		}
//		
//		return ret;
//	}
}
