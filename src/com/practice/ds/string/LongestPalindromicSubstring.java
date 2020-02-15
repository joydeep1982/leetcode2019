/**
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 */
package com.practice.ds.string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
//		String result = obj.longestPalindrome("babad");
		String result = obj.longestPalindrome("abcda");
		System.out.println("Result: " + result);
	}
	
	public String longestPalindrome(String s) {
		System.out.println("String: " + s);
		int len = s.length();
		if (len  <= 1) {
			return s;
		}
		
		if (s.charAt(0) == s.charAt(len - 1)) {
			// matched, proceed
			String matched = String.valueOf(s.charAt(0));
			return matched + longestPalindrome(s.substring(1, len - 1)) + matched;
		} else {
			// unmatched
			String s1 = longestPalindrome(s.substring(0, len - 1));
			String s2 = longestPalindrome(s.substring(1, len));
			
			return s1.length() > s2.length() ? s1 : s2;
		}
	}
	
	

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
