/**
 * 
 * https://leetcode.com/problems/unique-paths-iii/
 * 
 */
package com.practice.ds.array;

import java.util.LinkedList;
import java.util.Queue;

import com.practice.ds.miscell.Utils;

public class UniquePathsIII {

	public static void main(String[] args) {
		UniquePathsIII o = new UniquePathsIII();
		int[][] grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
		int paths = o.uniquePathsIII(grid);
		System.out.println(paths);
	}

	public int uniquePathsIII(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];

		int sI = -1;
		int sJ = -1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					sI = i;
					sJ = j;
				}
			}
		}

		int pathCount = 0;
		Queue<String> q = new LinkedList<String>();
		q.add(sI + ":" + sJ);

		Utils.print(visited, "T", "-");
		pathCount = bfs(grid, visited, q);
		

		return pathCount;
	}

	public int bfs(int[][] grid, boolean[][] visited, Queue<String> q) {
		int pathCount = 0;
		while (!q.isEmpty()) {
			String[] data = q.poll().split(":");
			int i = Integer.parseInt(data[0]);
			int j = Integer.parseInt(data[1]);
			
			if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
				continue;
			}

			if (visited[i][j]) {
				continue;
			}
			System.out.println(i + ", " + j);
			visited[i][j] = true;
			if (grid[i][j] == -1) {
				System.out.println("obstructed");
				visited[i][j] = false;
				continue;
			}
			if (grid[i][j] == 2) {
				System.out.println("matched");
				visited[i][j] = false;
				Utils.print(visited, "T", "-");
				pathCount++;
			}
			
			q.add((i + 1) + ":" + (j));
			q.add((i - 1) + ":" + (j));
			q.add((i) + ":" + (j + 1));
			q.add((i) + ":" + (j - 1));
		}
		return pathCount;
	}

//	public int uniquePathsIII(int[][] grid) {
//		int m = grid.length;
//		int n = grid[0].length;
//		boolean[][] visited = new boolean[m][n];
//
//		int sI = -1;
//		int sJ = -1;
//
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (grid[i][j] == 1) {
//					sI = i;
//					sJ = j;
//				}
//			}
//		}
//
//		return dfs(grid, visited, sI, sJ, 0);
//	}

//	public int dfs(int[][] grid, boolean[][] visited, int i, int j, int level) {
//		// bound check
//		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
//			return 0;
//		}
//		if (visited[i][j]) {
//			return 0;
//		}
//		for (int x = 0; x < level; x++) {
//			System.out.print("-");
//		}
//		System.out.println(i + ", " + j);
//		visited[i][j] = true;
//		if (grid[i][j] == -1) {
//			System.out.println("Obstructed");
//			return 0;
//		}
//		if (grid[i][j] == 2) {
//			System.out.println("Reached destination");
//			visited[i][j] = false;
//			return 1;
//		}
//
//		int right = dfs(grid, visited, i + 1, j, level + 1);
//		int left = dfs(grid, visited, i - 1, j, level + 1);
//		int top = dfs(grid, visited, i, j - 1, level + 1);
//		int bottom = dfs(grid, visited, i, j + 1, level + 1);
//
//		return left + right + top + bottom;
//	}
}