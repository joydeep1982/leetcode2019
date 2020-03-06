/**
 * 
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class CountSquareSubmatriceswithAllOnes {
	
	public static void main(String[] args) {
		CountSquareSubmatriceswithAllOnes o = new CountSquareSubmatriceswithAllOnes();
		int count = o.countSquares(new int[][] {
			{0,1,1,1},
			{1,1,1,1},
			{0,1,1,1}
		});
		System.out.println(count);
	}
	
	public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int count = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                    count += dp[i][j];
                }
                else if (matrix[i][j] != 0) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    count += dp[i][j];
                }
            }
        }
        Utils.print(matrix);
        Utils.print(dp);
        
        return count;
    }

}
