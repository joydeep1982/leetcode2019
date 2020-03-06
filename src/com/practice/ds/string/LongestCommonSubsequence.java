/**
 * 
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.List;

import com.practice.ds.miscell.Utils;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		int result = obj.longestCommonSubsequence("clement", "antoine");
		System.out.println("Result: " + result);
	}

	public int longestCommonSubsequence(String text1, String text2) {
		List<Character> chars = new ArrayList<Character>(); 
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    chars.add(text1.charAt(i-1));
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        chars.forEach(System.out::println);
        
        Utils.print(dp);
        
        return dp[text1.length()][text2.length()];
    }
}
