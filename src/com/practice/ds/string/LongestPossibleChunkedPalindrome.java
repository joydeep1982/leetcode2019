/**
 * 
 * https://www.geeksforgeeks.org/longest-possible-chunked-palindrome/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.List;

public class LongestPossibleChunkedPalindrome {

	public static void main(String[] args) {
		LongestPossibleChunkedPalindrome o = new LongestPossibleChunkedPalindrome();
//		int c = o.chunkedPalindrome("ghiabcdefhelloadamhelloabcdefghi");
//		int c = o.chunkedPalindrome("merchant");
//		int c = o.chunkedPalindrome("geekforgeek");
//		int c = o.chunkedPalindrome("abcdefgdefabc");
		int c = o.chunkedPalindrome("antaprezatepzapreanta");
		System.out.println(c);
	}

	public int chunkedPalindrome(String str) {
		List<String> chunks = new ArrayList<String>();
		int val = chunk(str, 0, str.length() - 1, chunks);
		
		chunks.forEach(System.out::println);
		
		return val;
	}

	public int chunk(String str, int left, int right, List<String> chunks) {
		if (left > right) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = right; i > left; i--) {
			if (str.charAt(left) == str.charAt(i)) {
				int leftPtr = left;
				int rightPtr = i;
				while (rightPtr <= right && str.charAt(rightPtr) == str.charAt(leftPtr)) {
					rightPtr++;
					leftPtr++;
				}
				if (rightPtr - 1 != right) {
					chunks.add(str.substring(left, right + 1));
					return 1;
				}
				if ((leftPtr - left) > max) {
					max = (leftPtr - left);
					chunks.add(str.substring(left, left + max));
					return 2 + chunk(str, left + max, (right - max), chunks);
				}
			}
		}
		chunks.add(str.substring(left, right + 1));
		return 1;
	}

}
