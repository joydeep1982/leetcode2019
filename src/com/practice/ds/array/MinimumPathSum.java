/**
 * 
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 */
package com.practice.ds.array;

public class MinimumPathSum {
	
	public static void main(String[] args) {
		MinimumPathSum obj = new MinimumPathSum();
		int[][] grid = new int [][] {{1,3,1}, {1,5,1}, {4,2,1}};
		int result = obj.minPathSum(grid);
		System.out.println("Result: " + result);
	}
	
	public int minPathSum(int[][] grid) {
        return sum(grid, 0, 0);
    }
    
    public int sum(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) return 0;
        System.out.println("Visiting: [" + i +", " + j + "]");
        return grid[i][j] + Math.min(sum(grid, i, j+ 1), sum(grid, i + 1, j));
    }

}
