/**
 * 
 * https://leetcode.com/problems/maximal-square/
 * 
 */
package com.practice.ds.array;

public class MaximalSquare {
	
	public static void main(String[] args) {
		MaximalSquare obj = new MaximalSquare();
		char[][] input = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		int res = obj.maximalSquare(input);
		System.out.println("Result: " + res);
	}
	
	public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int result = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
            	int num = matrix[i][j] == '0' ? 0 : 1;
                if (i == 0 || j == 0) dp[i][j] = num;
                else {
                    if (num == 0) {
                        dp[i][j] = 0; 
                        continue;
                    }
                    int max = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    max = Math.min(max, dp[i][j-1]);
                    dp[i][j] = ++max;
                }
                
                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }
        }
        
        return result * result;
    }

}
