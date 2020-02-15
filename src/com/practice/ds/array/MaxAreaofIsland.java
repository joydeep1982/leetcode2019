/**
 * 
 * https://leetcode.com/problems/max-area-of-island/
 * 
 */
package com.practice.ds.array;

public class MaxAreaofIsland {

	public static void main(String[] args) {
		MaxAreaofIsland obj = new MaxAreaofIsland();
		int[][] grid = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		grid = new int[][] { { 1 } };
		int area = obj.maxAreaOfIsland(grid);
		System.out.println("Area: " + area);
	}

	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;

		int row = grid.length;
		int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
                if (!visited[i][j])
				    max = Math.max(max, maxArea(grid, i, j, visited));
			}
		}

		return max;
	}

	public int maxArea(int[][] grid, int i, int j, boolean[][] visited) {
		if (i >= grid.length || j >= grid[0].length)
			return 0;
		if (i < 0 || j < 0)
			return 0;
		if (visited[i][j])
			return 0;
		if (grid[i][j] == 0)
			return 0;
		visited[i][j] = true;
		return 1 + maxArea(grid, i + 1, j, visited) // top cell
				+ maxArea(grid, i - 1, j, visited) // bottom cell
				+ maxArea(grid, i, j + 1, visited) // right cell
				+ maxArea(grid, i, j - 1, visited); // left cell
	}

}
