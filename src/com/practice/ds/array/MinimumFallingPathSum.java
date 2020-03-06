/**
 * 
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class MinimumFallingPathSum {
	
	public static void main(String[] args) {
		MinimumFallingPathSum o = new MinimumFallingPathSum();
		int min = o.minFallingPathSum(new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		});
		System.out.println(min);
	}
	
	public int minFallingPathSum(int[][] A) {
        int side = A.length;
        int[][] dp = new int[side][side];
        for (int i = 0; i < side; i++) {
            dp[0][i] = A[0][i];
        }
        int minFallingPath = Integer.MAX_VALUE;
        for (int i = 1; i < side; i++){
            for (int j = 0; j < side; j++) {
                if (j == 0) {
                    dp[i][j] = A[i][j] +Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if (j == side - 1) {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else {
                    dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j+1], dp[i-1][j+1]), dp[i-1][j]);
                }
                if (i == side - 1) {
                	minFallingPath = Math.min(minFallingPath, dp[i][j]);
                }
            }
        }
        
        Utils.print(dp);
        
        return minFallingPath;
    }

}
