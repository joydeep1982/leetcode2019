/**
 * 
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 */
package com.practice.ds.array;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		int max = obj.longestCommonSubsequence("ezupkr", "ubmrapg");
		System.out.println(max);
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int rows = text2.length();
		int cols = text1.length();
		int[][] dp = new int[rows][cols];

		dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;

		for (int i = 1; i < cols; i++) {
			int val = text1.charAt(i) == text2.charAt(0) ? 1 : 0;
			dp[0][i] = Math.max(dp[0][i - 1], val);
		}

		for (int i = 1; i < rows; i++) {
			int val = text2.charAt(i) == text1.charAt(0) ? 1 : 0;
			dp[i][0] = Math.max(dp[i - 1][0], val);
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				//System.out.println("comparing " + text2.charAt(i)  + " and " + text1.charAt(j));
				if (text2.charAt(i) == text1.charAt(j)) {
					System.out.println("matched [" + i + ", " + j + "]");
				}
				dp[i][j] = Math.max(dp[i - 1][j - 1] + (text2.charAt(i) == text1.charAt(j) ? 1 : 0), dp[i][j-1]);
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
			}
		}

		System.out.println();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[text2.length() - 1][text1.length() - 1];
	}
}
